package kr.megaptera.F4T2.services;

import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class RegisterProductServiceTest {
    private ProductRepository productRepository;

    private RegisterProductService registerProductService;

    @BeforeEach
    void setUp() {
        productRepository = mock(ProductRepository.class);

        registerProductService = new RegisterProductService(productRepository);
    }

    @Test
    void register() {
        Long productId = 1L;
        String name = "저소음 적축 레이저 기계식 키보드";
        String description = "소음이 적은 레이저 기계식 키보드";
        String image = "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80";
        Long price = 49000L;
        Integer inventory = 2;

        Product product = new Product(
                1L,
                "저소음 적축 레이저 기계식 키보드",
                "소음이 적은 레이저 기계식 키보드",
                "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80",
                49000L,
                2
        );

        given(productRepository.findByProductId(productId)).willReturn(Optional.of(product));

        registerProductService.register(productId, name, description, image, price, inventory);

        verify(productRepository).save(any());
    }
}
