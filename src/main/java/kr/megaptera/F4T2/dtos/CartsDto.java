package kr.megaptera.F4T2.dtos;

import java.util.List;

public class CartsDto {
    private final List<CartDto> carts;

    public CartsDto(List<CartDto> carts) {
        this.carts = carts;
    }

    public List<CartDto> getCarts() {
        return carts;
    }
}
