package com.silionie.server.jwt.security.service;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private String token;
    private String firstname;
    private String lastname;

    public AuthenticationResponse() {

    }

    public AuthenticationResponse(String token, String firstname, String lastname) {
        this.token = token;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getToken() {
        return this.token;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}