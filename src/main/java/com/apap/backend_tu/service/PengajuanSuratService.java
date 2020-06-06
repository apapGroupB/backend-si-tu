package com.apap.backend_tu.service;

import com.apap.backend_tu.model.PengajuanSuratModel;

import java.util.List;

public interface PengajuanSuratService {
	List<PengajuanSuratModel> getAllPengajuanSurat();

	void updatePengajuanSurat(long id, PengajuanSuratModel pustakawan);

	void deletePengajuanSurat(long id);

	PengajuanSuratModel getPengajuanSuratById(long id);

	PengajuanSuratModel addPengajuanSurat(PengajuanSuratModel pengajuanSurat);

	PengajuanSuratModel getPengajuanSuratByNoSurat(String nomor_surat);
	
	List<PengajuanSuratModel> getPengajuanByuuid(String uuid);
}
