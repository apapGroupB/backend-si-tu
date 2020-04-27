package com.apap.backend_tu.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * PilotModel
 */
@Entity
@Table(name = "pengajuan_surat")
public class PengajuanSuratModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 200)
	@Column(name = "nomor_surat", nullable = false, unique = true)
	private String nomor_surat;
	
    @NotNull
    @Column(name = "tanggal_pengajuan", nullable = false)
    private Date tanggal_pengajuan;
    
    @NotNull
    @Column(name = "tanggal_disetujui", nullable = false)
    private Date tanggal_disetujui;

	@NotNull
	@Size(max = 200)
	@Column(name = "keterangan", nullable = true)
	private String keterangan;

	@NotNull
	@Column(name = "status", nullable = false)
	private int status;
	
	@NotNull
	@Column(name = "id_jenis_surat", nullable = false)
	private int id_jenis_surat;
	
	
	@NotNull
	@Column(name = "uuid_user", nullable = true)
	private String uuid_user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomor_surat() {
		return nomor_surat;
	}

	public void setNomor_surat(String nomor_surat) {
		this.nomor_surat = nomor_surat;
	}

	public Date getTanggal_pengajuan() {
		return tanggal_pengajuan;
	}

	public void setTanggal_pengajuan(Date tanggal_pengajuan) {
		this.tanggal_pengajuan = tanggal_pengajuan;
	}

	public Date getTanggal_disetujui() {
		return tanggal_disetujui;
	}

	public void setTanggal_disetujui(Date tanggal_disetujui) {
		this.tanggal_disetujui = tanggal_disetujui;
	}

	public String getKeterangan() {
		return keterangan;
	}

	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId_jenis_surat() {
		return id_jenis_surat;
	}

	public void setId_jenis_surat(int id_jenis_surat) {
		this.id_jenis_surat = id_jenis_surat;
	}

	public String getUuid_user() {
		return uuid_user;
	}

	public void setUuid_user(String uuid_user) {
		this.uuid_user = uuid_user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	// @ManyToOne(fetch = FetchType.LAZY, optional = false)
	// @JoinColumn(name = "user_uuid_user", referencedColumnName = "uuid_user")
	// @OnDelete(action = OnDeleteAction.CASCADE)
	// @JsonIgnoreS
	// private UserModel user;



	// public UserModel getUser() {
	// return user;
	// }
	//
	// public void setUser(UserModel user) {
	// this.user = user;
	// }


}