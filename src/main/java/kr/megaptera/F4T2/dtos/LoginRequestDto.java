package kr.megaptera.F4T2.dtos;

public class LoginRequestDto {
    private String userId;

    private String password;

    public LoginRequestDto() {
    }

    public LoginRequestDto(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }
}
