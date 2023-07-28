package kr.megaptera.F4T2.services;

import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.Cart;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.AccountRepository;
import kr.megaptera.F4T2.repositories.CartRepository;
import kr.megaptera.F4T2.repositories.OrderRepository;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class PayServiceTest {
    private PayService payService;

    private AccountRepository accountRepository;

    private ProductRepository productRepository;

    private OrderRepository orderRepository;

    private CartRepository cartRepository;

    @BeforeEach
    void setUp() {
        accountRepository = mock(AccountRepository.class);

        productRepository = mock(ProductRepository.class);

        orderRepository = mock(OrderRepository.class);

        cartRepository = mock(CartRepository.class);

        payService = new PayService(accountRepository, productRepository, orderRepository, cartRepository);
    }

    @Test
    void pay() {
        UserId userId = new UserId("a111");
        Long productId = 1L;
        String name = "소음이 적은 레이저 기계식 키보드";
        String description = "저소음 적축 레이저 기계식 키보드입니다.";
        String image = "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80";
        Long price = 49000L;
        Integer inventory = 2;
        Integer quantity = 1;
        String receiver = "받는 사람";
        String address = "주소";
        String zonecode = "12345";
        String phoneNumber = "010-1234-5678";
        String deliveryMessage = "배송메시지";
        LocalDateTime createdAt = LocalDateTime.now();
        Long totalPrice = 49000L;

        Account account = new Account(1L, new UserId("a111"), "내이름", 500000L);

        Product product = new Product(
                1L,
                "소음이 적은 레이저 기계식 키보드",
                "저소음 적축 레이저 기계식 키보드입니다.",
                "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80",
                49000L,
                2
        );

        Cart cart = new Cart(1L, new UserId("a111"), 1L, "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80", "소음이 적은 레이저 기계식 키보드", "저소음 적축 레이저 기계식 키보드입니다.", 49000L, 49000L, 2, 1);

        given(accountRepository.findByUserId(userId)).willReturn(Optional.of(account));

        given(productRepository.findByProductId(productId)).willReturn(Optional.of(product));

        given(cartRepository
                .findAll(any(Pageable.class)))
                .willReturn(new PageImpl<>(List.of(cart)));

        payService.pay(userId, productId, name, description, image, price, inventory, quantity, receiver, address, zonecode, phoneNumber, deliveryMessage, createdAt, totalPrice);

        verify(orderRepository).save(any());
    }

}
