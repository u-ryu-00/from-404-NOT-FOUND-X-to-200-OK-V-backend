package kr.megaptera.F4T2.exceptions;

public class WrongPasswordFormat extends RuntimeException {
    private final RuntimeException exception;

    public WrongPasswordFormat() {
        this.exception = null;
    }

    public WrongPasswordFormat(RuntimeException exception) {
        this.exception = exception;
    }
}
