package com.apap.backend_tu.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class SivitasGuruModel {
    private String idUser;
    private String nig;
    private String nama;
    private String tempatLahir;
    private String tanggalLahir;
    private String alamat;
    private String telepon;

    public String convertDateToString(Date dt) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateToString = df.format(dt);
        return dateToString;
    }

    public SivitasGuruModel () {

    }

    public SivitasGuruModel(UserModel user){
        this.idUser = user.getUuid();
        this.nig = user.getNip();
        this.nama = user.getNama();
        this.tempatLahir = user.getTempat_lahir();
        this.tanggalLahir =convertDateToString(user.getTanggal_lahir());
        this.alamat = user.getAlamat();
        this.telepon = user.getTelepon();
    }

    public String getIdUser() {
        return idUser;
    }

    public String getNig() {
        return nig;
    }

    public String getNama() {
        return nama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelepon() {
        return telepon;
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
