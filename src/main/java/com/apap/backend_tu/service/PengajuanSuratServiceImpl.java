package com.apap.backend_tu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.repository.PengajuanSuratDb;


@Service
@Transactional
public class PengajuanSuratServiceImpl implements PengajuanSuratService {
	@Autowired
	private PengajuanSuratDb PengajuanSuratDb;
	
	@Override
	public List<PengajuanSuratModel> getAllPengajuanSurat() {
		return PengajuanSuratDb.findAll();
	}

}
