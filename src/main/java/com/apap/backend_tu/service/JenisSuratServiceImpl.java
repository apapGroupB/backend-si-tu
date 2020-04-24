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
	private JenisSuratDb JenisSuratDb;

	@Override
	public List<JenisSuratModel> getAllJenisSurat() {
		return JenisSuratDb.findAll();
	}
	

}