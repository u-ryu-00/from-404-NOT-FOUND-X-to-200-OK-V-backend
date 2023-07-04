package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.dtos.AccountDto;
import kr.megaptera.F4T2.exceptions.AccountNotFound;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AccountService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;

    public AccountService(PasswordEncoder passwordEncoder,
                          AccountRepository accountRepository) {
        this.passwordEncoder = passwordEncoder;
        this.accountRepository = accountRepository;
    }

    public Account create(AccountDto accountDto) {
        String userIdString = accountDto.getUserId();

        UserId userId = new UserId(userIdString);

        Account account = new Account(userId, accountDto.getName(), accountDto.getAmount());

        account.changePassword(accountDto.getPassword(), passwordEncoder);
        account.changePassword(accountDto.getConfirmPassword(), passwordEncoder);

        accountRepository.save(account);

        return account;
    }

    public Account detail(UserId userId) {
        return accountRepository.findByUserId(userId)
                .orElseThrow(() -> new AccountNotFound(userId));
    }
}
