package kr.megaptera.F4T2.models;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import kr.megaptera.F4T2.dtos.AccountCreatedDto;
import kr.megaptera.F4T2.dtos.AccountDto;
import kr.megaptera.F4T2.exceptions.LackOfAmount;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private UserId userId;

    private String encodedPassword;

    private String name;

    private Long amount;

    public Account() {
    }

    public Account(UserId userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public Account(UserId userId, String name, Long amount) {
        this.userId = userId;
        this.name = name;
        this.amount = 500000L;
    }

    public Account(Long id, UserId userId, String name, Long amount) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.amount = amount;
    }

    public Account(Long id, UserId userId, String encodedPassword, String name, Long amount) {
        this.id = id;
        this.userId = userId;
        this.encodedPassword = encodedPassword;
        this.name = name;
        this.amount = amount;
    }

    public Account(Long id, String encodedPassword, String name, long amount) {
        this.id = id;
        this.encodedPassword = encodedPassword;
        this.name = name;
        this.amount = 500000L;
    }

    public static Account fake(String userId) {
        return new Account(1L, new UserId(userId), "내이름", 500000L);
    }

    public static Account fake(UserId userId) {
        return Account.fake(userId.value());
    }

    public Long getId() {
        return id;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getEncodedPassword() {
        return encodedPassword;
    }

    public String getName() {
        return name;
    }

    public Long getAmount() {
        return amount;
    }

    public boolean authenticate(String password, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(password, encodedPassword);
    }

    public void changePassword(String password, PasswordEncoder passwordEncoder) {
        encodedPassword = passwordEncoder.encode(password);
    }

    public AccountCreatedDto toCreatedDto() {
        return new AccountCreatedDto(id, name, amount, userId.value());
    }

    public void pay(Product product, Integer quantity) {
        Long totalPrice = product.getPrice() * quantity;

        if (totalPrice > this.amount) {
            throw new LackOfAmount();
        }

        Long totalAmount = 0L;

        totalAmount += totalPrice;

        this.amount -= totalAmount;
    }

    public AccountDto toDto() {
        return new AccountDto(userId.value(), name, amount);
    }

    public void add(Product product, Integer quantity) {
        Long totalPrice = product.getPrice() * quantity;

//        if (totalPrice > this.amount) {
//            throw new LackOfAmount();
//        }

//        this.amount -= product.getPrice() * quantity;
    }
}
