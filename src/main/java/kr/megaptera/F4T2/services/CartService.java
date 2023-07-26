package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.models.Cart;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public List<Cart> list(UserId userId) {
        return cartRepository.findAllByUserId(userId);
    }

    public Cart detail(Long id) {
        return cartRepository.findById(id).get();
    }

    public void delete(Long id) {
        Cart cart = cartRepository.getById(id);
        cartRepository.delete(cart);
    }
}

