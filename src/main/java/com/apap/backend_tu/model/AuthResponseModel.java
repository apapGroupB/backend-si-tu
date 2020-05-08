package com.apap.backend_tu.model;

public class AuthResponseModel {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private final String name;
    private final String username;
    private final int id_role;

    public AuthResponseModel(
            String jwttoken,
            String name,
            String username,
            int id_role
            ) {
        this.jwttoken = jwttoken;
        this.name = name;
        this.username = username;
        this.id_role = id_role;
    }

    public String getJwttoken() {
        return this.jwttoken;
    }
    public String getName() { return this.name; }
    public String getUsername() { return this.username; }
    public int getId_role() { return this.id_role; }
}
