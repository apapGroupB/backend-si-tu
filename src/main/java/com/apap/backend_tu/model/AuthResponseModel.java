package com.apap.backend_tu.model;

public class AuthResponseModel {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public AuthResponseModel(String jwttoken) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
