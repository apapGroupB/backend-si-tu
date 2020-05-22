package com.apap.backend_tu.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;

public class RestUserModel {
    private int id_role;
    private int total;

    public RestUserModel () {
    }

    public RestUserModel(int id_role, int total){
        this.id_role = id_role;
        this.total = total;
    }

    public int getTotal() {
        return this.total;
    }

    public int getId_role() {
        return this.id_role;
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
