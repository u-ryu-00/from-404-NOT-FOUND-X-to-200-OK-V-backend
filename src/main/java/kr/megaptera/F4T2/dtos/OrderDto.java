package kr.megaptera.F4T2.dtos;

import java.time.LocalDateTime;

public class OrderDto {
    private Long orderId;

    private Long productId;

    private String name;

    private String description;

    private String image;

    private Long price;

    private Integer inventory;

    private Integer quantity;

    private Long totalPrice;

    private String receiver;

    private String address;

    private String phoneNumber;

    private String deliveryMessage;

    private LocalDateTime createdAt;

    public OrderDto() {
    }

    public OrderDto(Long orderId, Long productId, String name, String description, String image, Long price, Integer inventory, Integer quantity, Long totalPrice, String receiver, String address, String phoneNumber, String deliveryMessage, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.image = image;
        this.price = price;
        this.inventory = inventory;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.receiver = receiver;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.deliveryMessage = deliveryMessage;
        this.createdAt = createdAt;
    }

    public Long getOrderId() {
        return orderId;
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

    public Long getTotalPrice() {
        return totalPrice;
    }

    public String getReceiver() {
        return receiver;
    }

    public String getAddress() {
        return address;
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
}
