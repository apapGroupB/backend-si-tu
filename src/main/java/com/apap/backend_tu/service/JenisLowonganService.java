package com.apap.backend_tu.service;

import com.apap.backend_tu.model.JenisLowonganModel;
import java.util.List;

public interface JenisLowonganService {
    JenisLowonganModel addJenisLowongan(JenisLowonganModel jenisLowongan);

    List<JenisLowonganModel> getAllJenisLowongan();

    void removeJenisLowongan(long id);

    int validateByNama(JenisLowonganModel jenisLowongan);

}