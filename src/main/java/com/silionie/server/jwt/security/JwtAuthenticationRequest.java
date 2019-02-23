package com.silionie.server.jwt.security;

import com.silionie.server.domain.User;

public class JwtAuthenticationRequest {
    private String username;
    private String password;
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static User map(JwtAuthenticationRequest data){
        User user = new User();
        user.setUsername(data.getUsername());
        user.setPassword(data.getPassword());
        return user;
    }

}
