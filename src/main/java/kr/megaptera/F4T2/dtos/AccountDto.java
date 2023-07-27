package kr.megaptera.F4T2.dtos;

public class AccountDto {
    private String userId;
    private String userName;
    private Long amount;
    private String password;
    private String confirmPassword;

    public AccountDto() {

    }

    public AccountDto(String userId, String userName, Long amount, String password, String confirmPassword) {
        this.userId = userId;
        this.userName = userName;
        this.amount = amount;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public AccountDto(String userId, String userName, Long amount) {
        this.userId = userId;
        this.userName = userName;
        this.amount = amount;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public Long getAmount() {
        return amount;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
