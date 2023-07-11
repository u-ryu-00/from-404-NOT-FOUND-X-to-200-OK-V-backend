package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.models.Cart;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.CartRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;
    private final Pageable pageable;

    public CartService(CartRepository cartRepository, Pageable pageable) {
        this.cartRepository = cartRepository;
        this.pageable = pageable;
    }

    public Page<Cart> list(UserId userId, int page) {
        Pageable pageable = PageRequest.of(page - 1, 8);
        return cartRepository.findAllByUserId(userId, pageable);
    }

    public Cart detail(Long id) {
        return cartRepository.findById(id).get();
    }

    public int pages(UserId userId) {
        Page<Cart> cartPage = cartRepository.findAllByUserId(userId, pageable);

        return cartPage.getTotalPages();
    }

    public void delete(Long id) {
        Cart cart = cartRepository.getById(id);
        cartRepository.delete(cart);
    }
}

