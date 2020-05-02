package com.apap.backend_tu.model;

public class StatusModel {
    private boolean status;
    private String description;
    private String table;

    public StatusModel(boolean status, String description, String table) {
        this.status = status;
        this.description = description;
        this.table = table;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTable() {
        return this.table;
    }
}
