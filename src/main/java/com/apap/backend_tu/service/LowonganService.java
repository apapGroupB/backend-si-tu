package com.apap.backend_tu.service;

import java.util.List;

import com.apap.backend_tu.model.JenisLowonganModel;
import com.apap.backend_tu.model.LowonganModel;

public interface LowonganService {

    JenisLowonganModel addJenisLowongan(JenisLowonganModel jenisLowongan);

    List<JenisLowonganModel> getAllJenisLowongan();

    void removeJenisLowongan(long id);

    LowonganModel addLowongan(LowonganModel lowongan);

    List<LowonganModel> getAllLowongan();

    void updateLowongan(LowonganModel lowongan);

}