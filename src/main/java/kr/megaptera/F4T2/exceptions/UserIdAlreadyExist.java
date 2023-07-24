package kr.megaptera.F4T2.exceptions;

public class UserIdAlreadyExist extends RuntimeException {
    private final RuntimeException exception;

    public UserIdAlreadyExist() {
        this.exception = null;
    }

    public UserIdAlreadyExist(RuntimeException exception) {
        this.exception = exception;
    }
}
