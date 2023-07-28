package kr.megaptera.F4T2.dtos;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class PayDto {
    private Long productId;

    private String name;

    private String description;

    private String image;

    private Long price;

    private Integer inventory;

    private Integer quantity;

    @NotBlank
    private String receiver;

    @NotBlank
    private String address;

    @NotBlank
    private String zonecode;

    @NotBlank
    private String phoneNumber;

    private String deliveryMessage;

    private LocalDateTime createdAt;

    private Long totalPrice;

    public PayDto() {
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

    public Integer getQuantity() {
        return quantity;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getAddress() {
        return address;
    }

    public String getZonecode() {
        return zonecode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDeliveryMessage() {
        return deliveryMessage;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }
}
