package kr.megaptera.F4T2.repositories;

import kr.megaptera.F4T2.models.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findByReviewId(Long id);

    Page<Review> findAllByProductId(String productId, Pageable pageable);
}
