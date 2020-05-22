package com.apap.backend_tu.model;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class KoperasiPinjamanModel {
    private	int status;
    private int jumlah_pinjaman;
    private String tanggal_pengajuan;
    private int jumlah_pengembalian;
    private String tanggal_pengembalian;
    private String tanggal_disetujui;
    
    public KoperasiPinjamanModel(PinjamanModel pinjaman) {
    	this.status=pinjaman.getStatus();
    	this.jumlah_pinjaman=pinjaman.getJumlah_pinjaman();
    	this.tanggal_pengajuan=convertDateToString(pinjaman.getTanggal_pengajuan());
    	this.jumlah_pengembalian=pinjaman.getJumlah_pengembalian();
    	this.tanggal_pengembalian=convertDateToString(pinjaman.getTanggal_pengembalian());
    	this.tanggal_disetujui=convertDateToString(pinjaman.getTanggal_disetujui());
    }
    
    public String convertDateToString(Date dt) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateToString = df.format(dt);
        return dateToString;
    }

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getJumlah_pinjaman() {
		return jumlah_pinjaman;
	}

	public void setJumlah_pinjaman(int jumlah_pinjaman) {
		this.jumlah_pinjaman = jumlah_pinjaman;
	}

	public String getTanggal_pengajuan() {
		return tanggal_pengajuan;
	}

	public void setTanggal_pengajuan(String tanggal_pengajuan) {
		this.tanggal_pengajuan = tanggal_pengajuan;
	}

	public int getJumlah_pengembalian() {
		return jumlah_pengembalian;
	}

	public void setJumlah_pengembalian(int jumlah_pengembalian) {
		this.jumlah_pengembalian = jumlah_pengembalian;
	}

	public String getTanggal_pengembalian() {
		return tanggal_pengembalian;
	}

	public void setTanggal_pengembalian(String tanggal_pengembalian) {
		this.tanggal_pengembalian = tanggal_pengembalian;
	}

	public String getTanggal_disetujui() {
		return tanggal_disetujui;
	}

	public void setTanggal_disetujui(String tanggal_disetujui) {
		this.tanggal_disetujui = tanggal_disetujui;
	}
}
