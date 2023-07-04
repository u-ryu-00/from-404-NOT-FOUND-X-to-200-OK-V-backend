package kr.megaptera.F4T2.repositories;

import kr.megaptera.F4T2.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findByProductId(Long id);

    Page<Product> findAll(Pageable pageable);
}
