package kr.megaptera.F4T2.dtos;

public class AddResultDto {
    private Long id;

    private Long productId;

    private Integer quantity;

    public AddResultDto() {
    }

    public AddResultDto(Long id, Long productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
