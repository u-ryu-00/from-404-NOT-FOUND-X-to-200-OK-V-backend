package kr.megaptera.F4T2.dtos;

public class RegisterProductDto {
    private Long productId;

    private String name;

    private String description;

    private String image;

    private Long price;

    private Integer inventory;

    public RegisterProductDto() {
    }

    public RegisterProductDto(Long productId, String name, String description, String image, Long price, Integer inventory) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.inventory = inventory;
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

    public Integer getInventory() {
        return inventory;
    }
}
