package com.apap.backend_tu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.backend_tu.model.JenisSuratModel;
import com.apap.backend_tu.repository.JenisSuratDb;

@Service
@Transactional
public class JenisSuratServiceImpl implements JenisSuratService {
	@Autowired
	private JenisSuratDb jenisSuratDb;

	@Override
	public List<JenisSuratModel> getAllJenisSurat() {
		return jenisSuratDb.findAll();
	}

	@Override
	public JenisSuratModel addJenisSurat(JenisSuratModel jenisSurat) {
		jenisSuratDb.save(jenisSurat);
		return jenisSurat;
	}

	@Override
	public JenisSuratModel getJenisSuratById(long id) {
		return jenisSuratDb.findById(id);
	}

	@Override
	public void updateJenisSurat(long id, JenisSuratModel jenisSuratData) {
		JenisSuratModel jenisSurat = this.getJenisSuratById(id);
		jenisSurat.setNama(jenisSuratData.getNama());
		jenisSurat.setKeterangan(jenisSuratData.getKeterangan());
	}

	public void deleteJenisSurat(long id) {
		jenisSuratDb.delete(this.getJenisSuratById(id));
	}

	@Override
	public boolean validatenama(String nama) {
		List<JenisSuratModel> users = jenisSuratDb.validatenama(nama);
		if (users.size() > 0) {
			return false;
		} else {
			return true;
		}
	}

}