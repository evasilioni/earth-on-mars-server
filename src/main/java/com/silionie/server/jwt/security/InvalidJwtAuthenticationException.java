package com.silionie.server.jwt.security;

import io.jsonwebtoken.JwtException;


public class InvalidJwtAuthenticationException extends JwtException {

    public InvalidJwtAuthenticationException(String explanation) {
        super(explanation);
    }
}
