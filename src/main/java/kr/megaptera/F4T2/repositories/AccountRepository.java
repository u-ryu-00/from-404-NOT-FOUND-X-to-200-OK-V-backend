package kr.megaptera.F4T2.repositories;

import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUserId(UserId userId);

    Account findByName(String name);

    Account getByUserId(UserId userId);
}
