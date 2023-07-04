package kr.megaptera.F4T2.services;

import kr.megaptera.F4T2.exceptions.LoginFailed;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;

    public LoginService(AccountRepository accountRepository,
                        PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Account login(UserId userId, String password) {
        Account account = accountRepository.findByUserId(userId)
                .orElseThrow(() -> new LoginFailed());

        if (account == null || !account.authenticate(password, passwordEncoder)) {
            throw new LoginFailed();
        }
        return account;
    }
}
