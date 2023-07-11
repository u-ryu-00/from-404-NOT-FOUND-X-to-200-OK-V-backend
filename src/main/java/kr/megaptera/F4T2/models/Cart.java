package kr.megaptera.F4T2.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import kr.megaptera.F4T2.dtos.AddResultDto;
import kr.megaptera.F4T2.dtos.CartDto;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long cartId;

    @Embedded
    private UserId userId;

    private Long productId;

    private String image;

    private String name;

    private String description;

    private Long price;

    private Long totalPrice;

    private Integer inventory;

    private Integer quantity;


    public Cart() {
    }

    public Cart(Long cartId, UserId userId, Long productId, String image, String name, String description, Long price, Long totalPrice, Integer inventory, Integer quantity) {
        this.cartId = cartId;
        this.userId = userId;
        this.productId = productId;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.totalPrice = totalPrice;
        this.inventory = inventory;
        this.quantity = quantity;
    }

    public Long getCartId() {
        return cartId;
    }

    public UserId getUserId() {
        return userId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Long getPrice() {
        return price;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public Integer getInventory() {
        return inventory;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public AddResultDto toAddResultDto() {
        return new AddResultDto(cartId, productId, quantity);
    }

    public CartDto toDto() {
        return new CartDto(cartId, productId, image, name, description, price, totalPrice, inventory, quantity);
    }

    public void updateInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public static Cart fake() {
        return new Cart(1L, new UserId("a111"), 1L, "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80", "소음이 적은 레이저 기계식 키보드", "저소음 적축 레이저 기계식 키보드입니다.", 49000L, 49000L, 2, 1);
    }
}
