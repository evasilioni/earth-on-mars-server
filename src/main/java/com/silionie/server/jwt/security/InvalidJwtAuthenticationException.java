package com.silionie.server.jwt.security;

import com.silionie.server.jwt.security.controller.AuthenticationException;


public class InvalidJwtAuthenticationException extends AuthenticationException {

    public InvalidJwtAuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
