package com.gaming.authservice.exception;

public class BadCredentialsException extends AuthException {

    public BadCredentialsException() {
        super("BAD_CREDENTIALS");
    }
}
