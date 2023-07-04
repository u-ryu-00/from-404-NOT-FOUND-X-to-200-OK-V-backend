package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.exceptions.AccountNotFound;
import kr.megaptera.F4T2.exceptions.ProductNotFound;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.Order;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.AccountRepository;
import kr.megaptera.F4T2.repositories.OrderRepository;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@Transactional
public class PayService {
    private final AccountRepository accountRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    public PayService(AccountRepository accountRepository, ProductRepository productRepository, OrderRepository orderRepository) {
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Order pay(UserId userId, Long productId, String name, String description, String image, Long price, Integer inventory, Integer quantity,
                     String receiver, String address, String phoneNumber, String deliveryMessage, LocalDateTime createdAt) {

        Account account = accountRepository.findByUserId(userId)
                .orElseThrow(() -> new AccountNotFound(userId));

        Product product = productRepository.findByProductId(productId)
                .orElseThrow(() -> new ProductNotFound(productId));

        account.pay(product, quantity);

        Long totalPrice = product.getPrice() * quantity;

        Order order = new Order(null, userId, productId,
                name, description, image, price, inventory, quantity, totalPrice,
                receiver, address, phoneNumber, deliveryMessage, createdAt);

        orderRepository.save(order);

        return order;
    }
}