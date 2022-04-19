package com.example.demo.security;


public class SecurityConstants {
    public static final String SECRET = "helloshin";
    public static final long EXPIRATION_TIME = 15*60*1000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/signup";
    public static final String LOGIN_URL = "/login";
    private SecurityConstants() {
    }


}
