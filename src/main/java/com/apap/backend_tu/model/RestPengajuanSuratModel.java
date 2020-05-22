package com.apap.backend_tu.model;

import java.sql.Date;

public class RestPengajuanSuratModel {
    private String nomor_surat;
    private Date tanggal_pengajuan;
    private Date tanggal_disetujui;
    private String keterangan;
    private int status;
    private int id_jenis_surat;
    private String uuid_user;

    public RestPengajuanSuratModel(String nomor_surat, Date tanggal_pengajuan, Date tanggal_disetujui,
            String keterangan, int status, int id_jenis_surat, String uuid_user) {
        this.nomor_surat = nomor_surat;
        this.tanggal_pengajuan = tanggal_pengajuan;
        this.tanggal_disetujui = tanggal_disetujui;
        this.keterangan = keterangan;
        this.status = status;
        this.id_jenis_surat = id_jenis_surat;
        this.uuid_user = uuid_user;

    }

    public String getUuid_user() {
        return this.uuid_user;
    }

    public void setUuid_user(String uuid_user) {
        this.uuid_user = uuid_user;
    }

    public int getId_jenis_surat() {
        return this.id_jenis_surat;
    }

    public void setId_jenis_surat(int id_jenis_surat) {
        this.id_jenis_surat = id_jenis_surat;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getKeterangan() {
        return this.keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTanggal_disetujui() {
        return this.tanggal_disetujui;
    }

    public void setTanggal_disetujui(Date tanggal_disetujui) {
        this.tanggal_disetujui = tanggal_disetujui;
    }

    public Date getTanggal_pengajuan() {
        return this.tanggal_pengajuan;
    }

    public void setTanggal_pengajuan(Date tanggal_pengajuan) {
        this.tanggal_pengajuan = tanggal_pengajuan;
    }

    public String getNomor_surat() {
        return this.nomor_surat;
    }

    public void setNomor_surat(String nomor_surat) {
        this.nomor_surat = nomor_surat;
    }

}