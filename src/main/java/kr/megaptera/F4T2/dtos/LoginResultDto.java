package kr.megaptera.F4T2.dtos;

public class LoginResultDto {
    private final String accessToken;

    private final String userName;

    private final Long amount;

    public LoginResultDto(String accessToken, String userName, Long amount) {
        this.accessToken = accessToken;
        this.userName = userName;
        this.amount = amount;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserName() {
        return userName;
    }

    public Long getAmount() {
        return amount;
    }
}
