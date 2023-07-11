package kr.megaptera.F4T2.dtos;

import java.util.List;

public class CartsDto {
    private final List<CartDto> carts;
    private int totalPages;

    public CartsDto(List<CartDto> carts) {
        this.carts = carts;
    }

    public CartsDto(List<CartDto> carts, int totalPages) {
        this.carts = carts;
        this.totalPages = totalPages;
    }

    public List<CartDto> getCarts() {
        return carts;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
