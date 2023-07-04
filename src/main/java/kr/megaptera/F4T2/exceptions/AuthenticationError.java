package kr.megaptera.F4T2.exceptions;

public class AuthenticationError extends RuntimeException {
    public AuthenticationError() {
        super("Authentication error");
    }
}
