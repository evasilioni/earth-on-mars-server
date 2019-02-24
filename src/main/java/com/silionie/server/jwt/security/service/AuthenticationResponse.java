package com.silionie.server.jwt.security.service;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private final String token;

    public AuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}