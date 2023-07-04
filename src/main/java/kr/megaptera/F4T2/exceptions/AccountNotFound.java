package kr.megaptera.F4T2.exceptions;

import kr.megaptera.F4T2.models.UserId;

public class AccountNotFound extends RuntimeException {
    public AccountNotFound(UserId userId) {
        super("Account not found (userId: " + userId + ")");
    }
}
