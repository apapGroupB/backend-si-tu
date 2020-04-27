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
    public void removeJenisLowongan(long id) {
        jenisLowonganDb.deleteById(id);
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

    @Override
    public void updateLowongan(LowonganModel lowongan) {
        LowonganModel dataLowongan = lowonganDb.getOne(lowongan.getId());
        dataLowongan.setJudul(lowongan.getJudul());
        dataLowongan.setTanggal_dibuka(lowongan.getTanggal_dibuka());
        dataLowongan.setTanggal_ditutup(lowongan.getTanggal_ditutup());
        dataLowongan.setKeterangan(lowongan.getKeterangan());
        dataLowongan.setJumlah(lowongan.getJumlah());
        dataLowongan.setId_jenis_lowongan(lowongan.getId_jenis_lowongan());
        dataLowongan.setUuid_user(lowongan.getUuid_user());
    }

}