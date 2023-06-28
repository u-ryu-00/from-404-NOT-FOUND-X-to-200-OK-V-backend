package kr.megaptera.F4T2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import kr.megaptera.F4T2.dtos.ProductDto;
import kr.megaptera.F4T2.dtos.RegisterProductResultDto;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long productId;

    private String name;

    private String description;

    private String image;

    private Long price;

    private Integer quantity;

    public Product() {
    }

    public Product(Long productId, String name, String description, String image, Long price, Integer quantity) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product fake() {
        return new Product(1L, "저소음 적축 레이저 기계식 키보드", "소음이 적은 레이저 기계식 키보드", "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80", 49000L, 2);
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public Long getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public RegisterProductResultDto toRegisterProductResultDto() {
        return new RegisterProductResultDto(null, productId, quantity);
    }

    public ProductDto toDto() {
        return new ProductDto(productId, name, description, image, price, quantity);
    }

    public void update(String name, String description, String image, Long price, Integer quantity) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }
}
