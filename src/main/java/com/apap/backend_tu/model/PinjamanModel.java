package com.apap.backend_tu.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Entity
@Table(name = "pinjaman")
public class PinjamanModel {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Column(name = "status", nullable = false)
    private int status;

    @NotNull
    @Column(name = "jumlah_pinjaman", nullable = false)
    private int jumlah_pinjaman;

    @NotNull
    @Column(name = "tanggal_pengajuan", nullable = false)
    private Date tanggal_pengajuan;

    @Column(name = "jumlah_pengembalian", nullable = true)
    private int jumlah_pengembalian;

    @Column(name = "tanggal_pengembalian", nullable = true)
    private Date tanggal_pengembalian;

    @Column(name = "tanggal_disetujui", nullable = true)
    private Date tanggal_disetujui;


    public long getId() {
        return this.id;
    }

    public int getStatus() {
        return this.status;
    }

    public int getJumlah_pinjaman() {
        return this.jumlah_pinjaman;
    }

    public Date getTanggal_pengajuan() {
        return this.tanggal_pengajuan;
    }

    public int getJumlah_pengembalian() {
        return this.jumlah_pengembalian;
    }

    public Date getTanggal_pengembalian() {
        return this.tanggal_pengembalian;
    }

    public Date getTanggal_disetujui() {
        return this.tanggal_disetujui;
    }



    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setJumlah_pinjaman(int jumlah_pinjaman) {
        this.jumlah_pinjaman = jumlah_pinjaman;
    }

    public void setTanggal_pengajuan(Date tanggal_pengajuan) {
        this.tanggal_pengajuan = tanggal_pengajuan;
    }

    public void setJumlah_pengembalian(int jumlah_pengembalian) {
        this.jumlah_pengembalian = jumlah_pengembalian;
    }

    public void setTanggal_pengembalian(Date tanggal_pengembalian) {
        this.tanggal_pengembalian = tanggal_pengembalian;
    }

    public void setTanggal_disetujui(Date tanggal_disetujui) {
        this.tanggal_disetujui = tanggal_disetujui;
    }
}

