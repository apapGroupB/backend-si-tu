package com.apap.backend_tu.service;

import com.apap.backend_tu.model.JenisLowonganModel;
import com.apap.backend_tu.repository.JenisLowonganDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class JenisLowonganServiceImpl implements JenisLowonganService {

    @Autowired
    private JenisLowonganDb jenisLowonganDb;

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

    // @Override
    // public JenisLowonganModel getByNama(String nama) {
    // return jenisLowonganDb.findByNama(nama);
    // }

    @Override
    public int validateByNama(JenisLowonganModel jenisLowongan) {
        JenisLowonganModel dataJenisLowongan = jenisLowonganDb.findByNama(jenisLowongan.getNama());
        return dataJenisLowongan == null ? 0 : 1;
    }

}
