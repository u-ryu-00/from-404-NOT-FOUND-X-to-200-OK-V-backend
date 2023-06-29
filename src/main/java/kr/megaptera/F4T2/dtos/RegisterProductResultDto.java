package kr.megaptera.F4T2.dtos;

public class RegisterProductResultDto {
    private Long id;

    private Long productId;

    private Integer inventory;

    public RegisterProductResultDto() {
    }

    public RegisterProductResultDto(Long id, Long productId, Integer inventory) {
        this.id = id;
        this.productId = productId;
        this.inventory = inventory;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public Integer getInventory() {
        return inventory;
    }
}
