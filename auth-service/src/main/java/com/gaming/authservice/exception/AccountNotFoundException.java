package com.gaming.authservice.exception;

public class AccountNotFoundException extends AuthException {

    public AccountNotFoundException() {
        super("ACCOUNT_NOT_FOUND");
    }
}
