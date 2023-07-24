package kr.megaptera.F4T2.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.megaptera.F4T2.dtos.AccountCreatedDto;
import kr.megaptera.F4T2.dtos.AccountDto;
import kr.megaptera.F4T2.dtos.ErrorDto;
import kr.megaptera.F4T2.dtos.InvalidNameLengthErrorDto;
import kr.megaptera.F4T2.dtos.PasswordDoNotMatchErrorDto;
import kr.megaptera.F4T2.dtos.UserIdAlreadyExistErrorDto;
import kr.megaptera.F4T2.dtos.WrongPasswordFormatErrorDto;
import kr.megaptera.F4T2.dtos.WrongUserIdFormatErrorDto;
import kr.megaptera.F4T2.exceptions.AccountNotFound;
import kr.megaptera.F4T2.exceptions.InvalidNameLength;
import kr.megaptera.F4T2.exceptions.PasswordDoNotMatch;
import kr.megaptera.F4T2.exceptions.UserIdAlreadyExist;
import kr.megaptera.F4T2.exceptions.WrongPasswordFormat;
import kr.megaptera.F4T2.exceptions.WrongUserIdFormat;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.OauthToken;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("me")
    public AccountDto account(
            @RequestAttribute("userId") UserId userId
    ) {
        Account account = accountService.detail(userId);
        return account.toDto();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountCreatedDto register(
            @RequestBody AccountDto accountDto
    ) {
        Account account = accountService.create(accountDto);

        return account.toCreatedDto();
    }

    @GetMapping("auth")
    public String getLogin(@RequestParam("code") String code) throws JsonProcessingException {

        OauthToken oauthToken = accountService.getAccessToken(code);

        String jwtToken = accountService.saveAccountAndGetToken(oauthToken.getAccess_token());

        return jwtToken;
    }

    @ExceptionHandler(AccountNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String accountNotFound() {
        return "Account not Found!";
    }

    @ExceptionHandler(InvalidNameLength.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto invalidNameLength() {
        return new InvalidNameLengthErrorDto();
    }

    @ExceptionHandler(WrongUserIdFormat.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto wrongUserIdFormat() {
        return new WrongUserIdFormatErrorDto();
    }

    @ExceptionHandler(WrongPasswordFormat.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto wrongPasswordFormat() {
        return new WrongPasswordFormatErrorDto();
    }

    @ExceptionHandler(PasswordDoNotMatch.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto passwordDoNotMatch() {
        return new PasswordDoNotMatchErrorDto();
    }

    @ExceptionHandler(UserIdAlreadyExist.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDto userIdAlreadyExist() {
        return new UserIdAlreadyExistErrorDto();
    }
}
