package kr.megaptera.F4T2.controllers;

import kr.megaptera.F4T2.dtos.AccountCreatedDto;
import kr.megaptera.F4T2.dtos.AccountDto;
import kr.megaptera.F4T2.exceptions.AccountNotFound;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @ExceptionHandler(AccountNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String accountNotFound() {
        return "Account not Found!";
    }
}
