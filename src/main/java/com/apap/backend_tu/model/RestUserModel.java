package com.apap.backend_tu.model;

public class RestUserModel {
    private String userName;
    private int id_role;

    public RestUserModel(String userName, int id_role){
        this.userName = userName;
        this.id_role = id_role;
    }

    public String getUserName() {
        return userName;
    }

    public int getId_role() {
        return id_role;
    }
}
