package kr.megaptera.F4T2.dtos;

public class CartDto {
    private Long cartId;

    private Long productId;

    private String image;

    private String name;

    private String description;

    private Long price;

    private Long totalPrice;

    private Integer inventory;

    private Integer quantity;

    public CartDto() {
    }

    public CartDto(Long cartId, Long productId, String image, String name, String description, Long price, Long totalPrice, Integer inventory, Integer quantity) {
        this.cartId = cartId;
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
}
