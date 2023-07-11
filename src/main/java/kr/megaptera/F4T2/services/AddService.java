package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.exceptions.AccountNotFound;
import kr.megaptera.F4T2.exceptions.ProductNotFound;
import kr.megaptera.F4T2.models.Account;
import kr.megaptera.F4T2.models.Cart;
import kr.megaptera.F4T2.models.Product;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.AccountRepository;
import kr.megaptera.F4T2.repositories.CartRepository;
import kr.megaptera.F4T2.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AddService {
    private AccountRepository accountRepository;
    private ProductRepository productRepository;
    private CartRepository cartRepository;

    public AddService(AccountRepository accountRepository, ProductRepository productRepository, CartRepository cartRepository) {
        this.accountRepository = accountRepository;
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
    }

    public Cart add(UserId userId, Long productId, String image, String name, String description, Long price, Long totalPrice, Integer inventory, Integer quantity) {
        Account account = accountRepository.findByUserId(userId)
                .orElseThrow(() -> new AccountNotFound(userId));

        Product product = productRepository.findByProductId(productId)
                .orElseThrow(() -> new ProductNotFound(productId));

        account.add(product, quantity);

        totalPrice = product.getPrice() * quantity;

        Cart cart = new Cart(null, userId, productId,
                image, name, description, price, totalPrice, inventory, quantity);

        cartRepository.save(cart);

        return cart;
    }
}
