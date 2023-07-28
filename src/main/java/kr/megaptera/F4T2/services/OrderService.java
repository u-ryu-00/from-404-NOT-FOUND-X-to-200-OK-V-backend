package kr.megaptera.F4T2.services;

import jakarta.transaction.Transactional;
import kr.megaptera.F4T2.models.Order;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.repositories.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private Pageable pageable;

    public OrderService(OrderRepository orderRepository, Pageable pageable) {
        this.orderRepository = orderRepository;
        this.pageable = pageable;
    }

    public Page<Order> list(UserId userId, int page) {
        Pageable pageable = PageRequest.of(page - 1, 8);
        return orderRepository.findAllByUserId(userId, pageable);
    }

    public Order detail(Long id) {
        return orderRepository.findById(id).get();
    }

    public int pages(UserId userId) {
        Page<Order> orderPage = orderRepository.findAllByUserId(userId, pageable);

        return orderPage.getTotalPages();
    }

    public void delete(Long id) {
        Order order = orderRepository.getById(id);
        orderRepository.delete(order);
    }
}
