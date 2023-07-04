package kr.megaptera.F4T2.repositories;

import kr.megaptera.F4T2.models.Order;
import kr.megaptera.F4T2.models.UserId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Page<Order> findAllByUserId(UserId userId, Pageable pageable);
}
