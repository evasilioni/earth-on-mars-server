package com.silionie.server.jwt.security;

import com.silionie.server.domain.User;

public class JwtAuthenticationResponse {
    private String username;
    private Object token;
    private String firstName;
    private String lastName;

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getToken() {
        return token;
    }

    public void setToken(Object token) {
        this.token = token;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static JwtAuthenticationResponse map(User user, String token) {
        JwtAuthenticationResponse response = new JwtAuthenticationResponse();
        response.setUsername(user.getUsername());
        response.setToken(token);
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        return response;
    }
}
