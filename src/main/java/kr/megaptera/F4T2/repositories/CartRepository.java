package kr.megaptera.F4T2.repositories;

import kr.megaptera.F4T2.models.Cart;
import kr.megaptera.F4T2.models.UserId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Page<Cart> findAllByUserId(UserId userId, Pageable pageable);

    Cart findByProductId(Long productId);
}
