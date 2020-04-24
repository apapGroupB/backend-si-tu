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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * PilotModel
 */
@Entity
@Table(name = "jenis_surat")
public class JenisSuratModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Size(max = 200)
	@Column(name = "nama", nullable = false, unique = true)
	private String nama;


	@NotNull
	@Size(max = 200)
	@Column(name = "keterangan", nullable = true)
	private String keterangan;



	// @ManyToOne(fetch = FetchType.LAZY, optional = false)
	// @JoinColumn(name = "user_uuid_user", referencedColumnName = "uuid_user")
	// @OnDelete(action = OnDeleteAction.CASCADE)
	// @JsonIgnore
	// private UserModel user;










	// public UserModel getUser() {
	// return user;
	// }
	//
	// public void setUser(UserModel user) {
	// this.user = user;
	// }



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNama() {
		return nama;
	}



	public void setNama(String nama) {
		this.nama = nama;
	}



	public String getKeterangan() {
		return keterangan;
	}



	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}

}