package kr.megaptera.F4T2.dtos;

import java.util.List;

public class ProductsDto {
    private final List<ProductDto> products;

    public ProductsDto(List<ProductDto> products) {
        this.products = products;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
