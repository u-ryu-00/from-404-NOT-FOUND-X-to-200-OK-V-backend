package kr.megaptera.F4T2.repositories;

import kr.megaptera.F4T2.models.Cart;
import kr.megaptera.F4T2.models.UserId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findAllByUserId(UserId userId);

    List<Cart> findAllByProductId(Long productId);

    Optional<Cart> findByProductId(Long id);
}
