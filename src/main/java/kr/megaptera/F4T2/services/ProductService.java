package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.dtos.UpdateProductDto;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private Pageable pageable;

    public ProductService(ProductRepository productRepository, Pageable pageable) {
        this.productRepository = productRepository;
        this.pageable = pageable;
    }

    public Page<Product> list(int page) {
        Pageable pageable = PageRequest.of(page - 1, 6);
        return productRepository.findAll(pageable);
    }

    public Long update(Long id, UpdateProductDto updateProductDto) {
        Product product = productRepository.getById(id);

        product.update(updateProductDto.getName(), updateProductDto.getDescription(), updateProductDto.getImage(),
                updateProductDto.getPrice(), updateProductDto.getInventory());

        return productRepository.save(product).getProductId();
    }

    public void delete(Long id) {
        Product product = productRepository.getById(id);
        productRepository.delete(product);
    }

    public Product detail(Long id) {
        return productRepository.findById(id).get();
    }

    public int pages() {
        Page<Product> productPage = productRepository.findAll(pageable);

        return productPage.getTotalPages();
    }
}
