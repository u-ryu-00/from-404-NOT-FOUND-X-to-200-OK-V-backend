package kr.megaptera.F4T2.exceptions;

public class WrongUserIdFormat extends RuntimeException {
    private final RuntimeException exception;

    public WrongUserIdFormat() {
        this.exception = null;
    }

    public WrongUserIdFormat(IllegalArgumentException exception) {
        this.exception = exception;
    }
}
