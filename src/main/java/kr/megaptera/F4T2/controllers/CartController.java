package kr.megaptera.F4T2.controllers;

import jakarta.validation.Valid;
import kr.megaptera.F4T2.dtos.AddDto;
import kr.megaptera.F4T2.dtos.AddResultDto;
import kr.megaptera.F4T2.dtos.CartDto;
import kr.megaptera.F4T2.dtos.CartsDto;
import kr.megaptera.F4T2.models.Cart;
import kr.megaptera.F4T2.models.UserId;
import kr.megaptera.F4T2.services.AddService;
import kr.megaptera.F4T2.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("cart")
public class CartController {
    private AddService addService;
    private CartService cartService;

    public CartController(AddService addService, CartService cartService) {
        this.addService = addService;
        this.cartService = cartService;
    }

    @GetMapping
    public CartsDto list(
            @RequestAttribute("userId") UserId userId,
            @RequestParam(required = false, defaultValue = "1") Integer page
    ) {
        List<CartDto> cartDtos =
                cartService.list(userId, page)
                        .stream()
                        .map(cart -> cart.toDto())
                        .collect(Collectors.toList());

        int totalPages = cartService.pages(userId);

        return new CartsDto(cartDtos, totalPages);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddResultDto add(
            @RequestAttribute("userId") UserId userId,
            @Valid @RequestBody AddDto addDto
    ) {
        Cart cart = addService.add(
                userId, addDto.getProductId(),
                addDto.getImage(),
                addDto.getName(),
                addDto.getDescription(),
                addDto.getPrice(),
                addDto.getTotalPrice(),
                addDto.getInventory(),
                addDto.getQuantity()
        );
        return cart.toAddResultDto();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        cartService.delete(id);
    }
}
