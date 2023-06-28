package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.dtos.UpdateProductDto;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> list() {
        return productRepository.findAll();
    }

    public Long update(Long id, UpdateProductDto updateProductDto) {
        Product product = productRepository.getById(id);

        product.update(updateProductDto.getName(), updateProductDto.getDescription(), updateProductDto.getImage(),
                updateProductDto.getPrice(), updateProductDto.getQuantity());

        return productRepository.save(product).getProductId();
    }

    public void delete(Long id) {
        Product product = productRepository.getById(id);
        productRepository.delete(product);
    }

    public Product detail(Long id) {
        return productRepository.findById(id).get();
    }
}
