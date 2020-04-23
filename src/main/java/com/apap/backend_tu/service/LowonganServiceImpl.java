package com.apap.backend_tu.service;

import java.util.List;

import javax.transaction.Transactional;

import com.apap.backend_tu.model.JenisLowonganModel;
import com.apap.backend_tu.model.LowonganModel;
import com.apap.backend_tu.repository.JenisLowonganDb;
import com.apap.backend_tu.repository.LowonganDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LowonganServiceImpl implements LowonganService {

    @Autowired
    private JenisLowonganDb jenisLowonganDb;

    @Autowired
    private LowonganDb lowonganDb;

    @Override
    public JenisLowonganModel addJenisLowongan(JenisLowonganModel jenisLowongan) {

        jenisLowonganDb.save(jenisLowongan);
        return jenisLowongan;

    }

    @Override
    public List<JenisLowonganModel> getAllJenisLowongan() {
        return jenisLowonganDb.findAll();
    }

    @Override
    public LowonganModel addLowongan(LowonganModel lowongan) {
        lowonganDb.save(lowongan);
        return lowongan;
    }

    @Override
    public List<LowonganModel> getAllLowongan() {
        return lowonganDb.findAll();
    }
}