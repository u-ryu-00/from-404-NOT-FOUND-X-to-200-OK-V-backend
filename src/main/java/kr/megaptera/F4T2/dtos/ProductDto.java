package kr.megaptera.F4T2.dtos;

public class ProductDto {
    private Long id;

    private String name;

    private String description;

    private String image;

    private Long price;

    private Integer quantity;

    public ProductDto() {
    }

    public ProductDto(Long id, String name, String description, String image, Long price, Integer quantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
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
}
