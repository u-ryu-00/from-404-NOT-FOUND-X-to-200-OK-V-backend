package kr.megaptera.F4T2.services;

import kr.megaptera.F4T2.dtos.AccountDto;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.AccountRepository;
import kr.megaptera.F4T2.utils.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AccountServiceTest {
    AccountService accountService;

    AccountRepository accountRepository;

    PasswordEncoder passwordEncoder;

    JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);

        given(accountRepository.findByUserId(any()))
                .willReturn(Optional.of(Account.fake("a111")));

        int hashLength = 32;
        int saltLength = 16;
        int parallelism = 4;
        int memory = 65536;
        int iterations = 3;

        passwordEncoder = new Argon2PasswordEncoder(
                saltLength, hashLength, parallelism, memory, iterations);

        accountService = new AccountService(passwordEncoder, accountRepository, jwtUtil);
    }

    @Test
    void create() {
        AccountService accountService = new AccountService(
                passwordEncoder, accountRepository, jwtUtil);

        given(accountRepository.findByUserId(any()))
                .willReturn(Optional.empty());

        AccountDto accountDto = new AccountDto(
                "a111", "내이름", 500000L, "Aa1!!!!!", "Aa1!!!!!");

        Account account = accountService.create(accountDto);

        assertThat(account).isNotNull();

        verify(accountRepository).save(account);
    }

    @Test
    void account() {
        UserId userId = new UserId("a111");

        Account account = accountService.detail(userId);

        verify(accountRepository).findByUserId(userId);

        assertThat(account.getUserId()).isEqualTo(userId);
    }
}
