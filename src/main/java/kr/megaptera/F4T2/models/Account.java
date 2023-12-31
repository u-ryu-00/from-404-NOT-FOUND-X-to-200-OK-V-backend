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

    private String userName;

    private Long amount;

    public Account() {
    }

    public Account(UserId userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Account(UserId userId, String userName, Long amount) {
        this.userId = userId;
        this.userName = userName;
        this.amount = 500000L;
    }

    public Account(Long id, UserId userId, String userName, Long amount) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.amount = amount;
    }

    public Account(Long id, UserId userId, String encodedPassword, String userName, Long amount) {
        this.id = id;
        this.userId = userId;
        this.encodedPassword = encodedPassword;
        this.userName = userName;
        this.amount = amount;
    }

    public Account(Long id, String encodedPassword, String userName, long amount) {
        this.id = id;
        this.encodedPassword = encodedPassword;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
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
        return new AccountCreatedDto(id, userName, amount, userId.value());
    }

    public void pay(Product product, Integer quantity) {
        Long totalPrice = product.getPrice() * quantity;

//        if (totalPrice > this.amount) {
//            throw new LackOfAmount();
//        }
    }

    public AccountDto toDto() {
        return new AccountDto(userId.value(), userName, amount);
    }

    public void add(Product product, Integer quantity) {
        Long totalPrice = product.getPrice() * quantity;
    }
}
