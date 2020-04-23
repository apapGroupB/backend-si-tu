package com.apap.backend_tu.service;

import java.util.List;

import javax.transaction.Transactional;

import com.apap.backend_tu.model.JenisLowonganModel;
import com.apap.backend_tu.repository.JenisLowonganDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class LowonganServiceImpl implements LowonganService {

    @Autowired
    private JenisLowonganDb jenisLowonganDb;

    @Override
    public JenisLowonganModel addJenisLowongan(JenisLowonganModel jenisLowongan) {

        jenisLowonganDb.save(jenisLowongan);
        return jenisLowongan;

    }

    @Override
    public List<JenisLowonganModel> getAllJenisLowongan() {
        return jenisLowonganDb.findAll();
    }
}