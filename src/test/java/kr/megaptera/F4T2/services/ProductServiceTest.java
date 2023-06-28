package kr.megaptera.F4T2.services;

import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class ProductServiceTest {
    ProductRepository productRepository;
    ProductService productService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);

        productService = new ProductService(productRepository);
    }

    @Test
    void list() {
        Product product = mock(Product.class);

        given(productRepository
                .findAll())
                .willReturn(List.of(product));

        List<Product> products = productService.list();

        assertThat(products).hasSize(1);
    }
}
