package com.gaming.authservice.exception;

public class AccountNotActiveException extends AuthException {

    public AccountNotActiveException() {
        super("ACCOUNT_NOT_ACTIVE");
    }
}
