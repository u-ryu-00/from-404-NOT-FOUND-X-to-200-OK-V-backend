package kr.megaptera.F4T2.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.megaptera.F4T2.dtos.OrderDto;
import kr.megaptera.F4T2.dtos.PayResultDto;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "ORDER_HISTORY")
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;

    @Embedded
    private UserId userId;

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

    private String zonecode;

    private String phoneNumber;

    private String deliveryMessage;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public Order() {
    }

    public Order(Long orderId, UserId userId, Long productId, String name, String description, String image, Long price, Integer inventory, Integer quantity, Long totalPrice, String receiver, String address, String zonecode, String phoneNumber, String deliveryMessage, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.userId = userId;
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
        this.zonecode = zonecode;
        this.phoneNumber = phoneNumber;
        this.deliveryMessage = deliveryMessage;
        this.createdAt = createdAt;
    }

    public static Order fake() {
        LocalDateTime createdAt = LocalDateTime.now();
        return new Order(1L, new UserId("a111"), 1L, "소음이 적은 레이저 기계식 키보드", "저소음 적축 레이저 기계식 키보드입니다.", "https://images.unsplash.com/photo-1601445638532-3c6f6c3aa1d6?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=386&q=80", 49000L, 2, 1, 49000L, "받는 사람", "주소", "우편번호", "010-1234-5678", "배송메시지", createdAt);
    }

    public Long getOrderId() {
        return orderId;
    }

    public UserId getUserId() {
        return userId;
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

    public PayResultDto toPayResultDto() {
        return new PayResultDto(orderId, productId, quantity);
    }

    public OrderDto toDto() {
        return new OrderDto(orderId, productId, name, description, image, price, inventory, quantity, totalPrice, receiver, address, zonecode, phoneNumber, deliveryMessage, createdAt);
    }
}
