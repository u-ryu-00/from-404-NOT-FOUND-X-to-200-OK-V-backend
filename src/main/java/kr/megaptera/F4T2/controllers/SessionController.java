package kr.megaptera.F4T2.controllers;

import kr.megaptera.F4T2.dtos.LoginRequestDto;
import kr.megaptera.F4T2.dtos.LoginResultDto;
import kr.megaptera.F4T2.exceptions.LoginFailed;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.LoginService;
import kr.megaptera.F4T2.utils.JwtUtil;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("session")
public class SessionController {
    private final LoginService loginService;
    private final JwtUtil jwtUtil;

    public SessionController(LoginService loginService, JwtUtil jwtUtil) {
        this.loginService = loginService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResultDto login(
            @RequestBody LoginRequestDto loginRequestDto
    ) {
        UserId userId = new UserId(loginRequestDto.getUserId());

        String password = loginRequestDto.getPassword();

        Account account = loginService.login(userId, password);

        String accessToken = jwtUtil.encode(userId);

        return new LoginResultDto(
                accessToken,
                account.getName(),
                account.getAmount()
        );
    }

    @ExceptionHandler(LoginFailed.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String loginFailed() {
        return "Login failed";
    }
}
