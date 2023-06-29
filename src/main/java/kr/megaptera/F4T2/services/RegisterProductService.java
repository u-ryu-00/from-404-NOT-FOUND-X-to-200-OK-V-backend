package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterProductService {
    private ProductRepository productRepository;

    public RegisterProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product register(Long productId, String name, String description, String image, Long price, Integer inventory) {
        Product product = new Product(productId, name, description, image, price, inventory);

        productRepository.save(product);

        return product;
    }
}
