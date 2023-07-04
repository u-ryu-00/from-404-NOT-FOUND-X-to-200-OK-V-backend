package kr.megaptera.F4T2.controllers;

import jakarta.validation.Valid;
import kr.megaptera.F4T2.dtos.OrderDto;
import kr.megaptera.F4T2.dtos.OrdersDto;
import kr.megaptera.F4T2.dtos.PayDto;
import kr.megaptera.F4T2.dtos.PayResultDto;
import kr.megaptera.F4T2.models.Order;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.OrderService;
import kr.megaptera.F4T2.services.PayService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("orders")
public class OrderController {
    private final OrderService orderService;
    private final PayService payService;

    public OrderController(OrderService orderService, PayService payService) {
        this.orderService = orderService;
        this.payService = payService;
    }

    @GetMapping
    public OrdersDto list(
            @RequestAttribute("userId") UserId userId,
            @RequestParam(required = false, defaultValue = "1") Integer page
    ) {
        List<OrderDto> orderDtos =
                orderService.list(userId, page)
                        .stream()
                        .map(order -> order.toDto())
                        .collect(Collectors.toList());

        int totalPages = orderService.pages(userId);

        return new OrdersDto(orderDtos, totalPages);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PayResultDto pay(
            @RequestAttribute("userId") UserId userId,
            @Valid @RequestBody PayDto payDto
    ) {
        Order order = payService.pay(
                userId, payDto.getProductId(),
                payDto.getName(),
                payDto.getDescription(),
                payDto.getImage(),
                payDto.getPrice(),
                payDto.getInventory(),
                payDto.getQuantity(),
                payDto.getReceiver(),
                payDto.getAddress(),
                payDto.getPhoneNumber(),
                payDto.getDeliveryMessage(),
                payDto.getCreatedAt()
        );
        return order.toPayResultDto();
    }

    @GetMapping("/{id}")
    public OrderDto product(
            @PathVariable("id") Long id
    ) {
        Order order = orderService.detail(id);

        return order.toDto();
    }
}
