package com.apap.backend_tu.model;

public class AuthResponseModel {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;
    private final String name;
    private final String username;
    private final String uuid;
    private final int id_role;

    public AuthResponseModel(
            String token,
            String name,
            String username,
            int id_role,
            String uuid
            ) {
        this.token = token;
        this.name = name;
        this.username = username;
        this.id_role = id_role;
        this.uuid = uuid;
    }

    public String getJwttoken() {
        return this.token;
    }
    public String getUuid() { return this.uuid; }
    public String getName() { return this.name; }
    public String getUsername() { return this.username; }
    public int getId_role() { return this.id_role; }
}
