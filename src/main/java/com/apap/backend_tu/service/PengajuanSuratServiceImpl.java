package com.apap.backend_tu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.repository.PengajuanSuratDb;


@Service
@Transactional
public class PengajuanSuratServiceImpl implements PengajuanSuratService {
	@Autowired
	private PengajuanSuratDb pengajuanSuratDb;
	
	@Override
	public List<PengajuanSuratModel> getAllPengajuanSurat() {
		return pengajuanSuratDb.findAll();
	}


	@Override
	public PengajuanSuratModel addPengajuanSurat(PengajuanSuratModel pengajuanSurat) {
		pengajuanSuratDb.save(pengajuanSurat);
		return pengajuanSurat;
	}

	@Override
	public PengajuanSuratModel getPengajuanSuratById(long id) {
		return pengajuanSuratDb.findById(id);
	}

	@Override
	public void updatePengajuanSurat(long id, PengajuanSuratModel pengajuanSuratData) {
		PengajuanSuratModel pengajuanSurat = this.getPengajuanSuratById(id);
		pengajuanSurat.setId_jenis_surat(pengajuanSuratData.getId_jenis_surat());
		pengajuanSurat.setKeterangan(pengajuanSuratData.getKeterangan());
		pengajuanSurat.setNomor_surat(pengajuanSuratData.getNomor_surat());
		pengajuanSurat.setStatus(pengajuanSuratData.getStatus());
		pengajuanSurat.setTanggal_disetujui(pengajuanSuratData.getTanggal_disetujui());
		pengajuanSurat.setTanggal_pengajuan(pengajuanSuratData.getTanggal_pengajuan());
	}

	public void deletePengajuanSurat(long id) {
		pengajuanSuratDb.delete(this.getPengajuanSuratById(id));
	}

}
