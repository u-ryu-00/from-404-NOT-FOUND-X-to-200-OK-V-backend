package kr.megaptera.F4T2.services;

import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.AccountRepository;
import kr.megaptera.F4T2.repositories.CartRepository;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class AddServiceTest {
    private AddService addService;

    private AccountRepository accountRepository;

    private ProductRepository productRepository;

    private CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);

        productRepository = mock(ProductRepository.class);

        cartRepository = mock(CartRepository.class);

        addService = new AddService(accountRepository, productRepository, cartRepository);
    }

    @Test
    void add() {
        UserId userId = new UserId("a111");

        Long productId = 1L;

        Account account = new Account(1L, userId, "내이름", 50000L);

        Product product = new Product(1L, "소음이 적은 레이저 기계식 키보드", "저소음 적축 레이저 기계식 키보드입니다.", "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80", 49000L, 2);

        given(accountRepository.findByUserId(userId)).willReturn(Optional.of(account));

        given(productRepository.findByProductId(productId)).willReturn(Optional.of(product));

        addService.add(new UserId("a111"), 1L, "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80", "소음이 적은 레이저 기계식 키보드", "저소음 적축 레이저 기계식 키보드입니다.", 49000L, 49000L, 2, 1);

        verify(cartRepository).save(any());
    }
}
