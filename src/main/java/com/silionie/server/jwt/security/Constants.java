package com.silionie.server.jwt.security;

public class Constants {
    public static final String SECRET_KEY = "secret";
    public static final long EXPIRATION_TIME_MILLIS = 1800000; // 30 mins
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_IN_URL = "/users/sign-in";
    public static final String UNITS_URL = "/units";
    public static final String REVIEWS_URL = "/reviews";
}