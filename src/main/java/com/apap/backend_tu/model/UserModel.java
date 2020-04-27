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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class UserModel implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Size(max = 200)
	@Column(name = "uuid", nullable = true)
	private String uuid;

	@NotNull
	@Size(max = 200)
	@Column(name = "username", nullable = true)
	private String username;

	@NotNull
	@Size(max = 200)
	@Column(name = "password", nullable = true)
	private String password;

	@NotNull
	@Column(name = "id_role", nullable = false)
	private int id_role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	// private List<PengajuanSuratModel> listPengajuanSurat = new
	// ArrayList<PengajuanSuratModel>();



	// public List<PengajuanSuratModel> getListPengajuanSurat() {
	// return listPengajuanSurat;
	// }
	//
	// public void setListPengajuanSurat(List<PengajuanSuratModel>
	// listPengajuanSurat) {
	// this.listPengajuanSurat = listPengajuanSurat;
	// }



}
