package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.exceptions.AccountNotFound;
import kr.megaptera.F4T2.exceptions.ProductNotFound;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.Cart;
import kr.megaptera.F4T2.models.Order;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.AccountRepository;
import kr.megaptera.F4T2.repositories.CartRepository;
import kr.megaptera.F4T2.repositories.OrderRepository;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PayService {
    private final AccountRepository accountRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public PayService(AccountRepository accountRepository, ProductRepository productRepository, OrderRepository orderRepository, CartRepository cartRepository) {
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    public Order pay(UserId userId, Long productId, String name, String description, String image, Long price, Integer inventory, Integer quantity,
                     String receiver, String address, String phoneNumber, String deliveryMessage, LocalDateTime createdAt, Long totalPrice) {

        Account account = accountRepository.findByUserId(userId)
                .orElseThrow(() -> new AccountNotFound(userId));

        Product product = productRepository.findByProductId(productId)
                .orElseThrow(() -> new ProductNotFound(productId));

        Optional<Cart> cartOptional = cartRepository.findByProductId(productId);

        account.pay(product, quantity);

        inventory -= quantity;

        Order order = new Order(null, userId, productId,
                name, description, image, price, inventory, quantity, totalPrice,
                receiver, address, phoneNumber, deliveryMessage, createdAt);

        orderRepository.save(order);

        product.updateInventory(inventory);

        if (cartOptional.isPresent()) {
            Cart cart = cartOptional.get();
            cart.updateInventory(inventory);
            System.out.println("cart inventory update");
        }
        return order;
    }
}
