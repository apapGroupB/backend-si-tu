package com.apap.backend_tu.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "lowongan")
public class LowonganModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NotNull
    @Size(max = 200)
    @Column(name = "judul", nullable = false)
    private String judul;

    public String getJudul() {
        return this.judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    @NotNull
    @Column(name = "tanggal_dibuka", nullable = false)
    private Date tanggal_dibuka;

    public Date getTanggal_dibuka() {
        return this.tanggal_dibuka;
    }

    public void setTanggal_dibuka(Date tanggal_dibuka) {
        this.tanggal_dibuka = tanggal_dibuka;
    }

    @Column(name = "tanggal_ditutup")
    private Date tanggal_ditutup;

    public Date getTanggal_ditutup() {
        return this.tanggal_ditutup;
    }

    public void setTanggal_ditutup(Date tanggal_ditutup) {
        this.tanggal_ditutup = tanggal_ditutup;
    }

    @NotNull
    @Size(max = 200)
    @Column(name = "keterangan", nullable = false)
    private String keterangan;

    public String getKeterangan() {
        return this.keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    @NotNull
    @Column(name = "jumlah", nullable = false)
    private int jumlah;

    public int getJumlah() {
        return this.jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @NotNull
    @Column(name = "id_jenis_lowongan", nullable = false)
    private int id_jenis_lowongan;

    public int getId_jenis_lowongan() {
        return this.id_jenis_lowongan;
    }

    public void setId_jenis_lowongan(int id_jenis_lowongan) {
        this.id_jenis_lowongan = id_jenis_lowongan;
    }

    @NotNull
    @Size(max = 200)
    @Column(name = "uuid_user", nullable = false)
    private String uuid_user;

    public String getUuid_user() {
        return this.uuid_user;
    }

    public void setUuid_user(String uuid_user) {
        this.uuid_user = uuid_user;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public LowonganModel() {
    }

    public LowonganModel(int jumlah) {
        java.util.Date now = new java.util.Date();
        this.judul = "Lowongan Pustakawan";
        this.id_jenis_lowongan = 5;
        this.jumlah = jumlah;
        this.tanggal_dibuka = new Date(now.getTime());
        this.tanggal_ditutup = new Date(now.getTime() + 31l * 24l * 60l * 60l * 1000l);
        this.keterangan = "“Dibutuhkan Pustakawan Cakap";
        this.uuid_user = "SI Perpustakaan";
    }

}