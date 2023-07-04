package kr.megaptera.F4T2.exceptions;

public class LoginFailed extends RuntimeException {
    public LoginFailed() {
        super("Login failed");
    }
}
