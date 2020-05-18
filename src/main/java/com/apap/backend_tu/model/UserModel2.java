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
@Table(name = "user_profile2")
public class UserModel2 implements Serializable {
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;





	@NotNull
	@Size(max = 200)
	@Column(name = "nama", nullable = false)
	private String nama;



	@Size(max = 200)
	@Column(name = "alamat", nullable = true)
	private String alamat;



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



	public String getAlamat() {
		return alamat;
	}



	public void setAlamat(String alamat) {
		this.alamat = alamat;
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
