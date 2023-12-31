package kr.megaptera.F4T2.dtos;

public class AccountCreatedDto {
    private Long id;

    private String name;

    private Long amount;

    private String userId;

    public AccountCreatedDto() {

    }

    public AccountCreatedDto(Long id, String name, Long amount, String userId) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getAmount() {
        return amount;
    }

    public String getUserId() {
        return userId;
    }
}
