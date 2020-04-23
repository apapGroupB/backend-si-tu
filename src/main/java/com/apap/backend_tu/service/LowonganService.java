package com.apap.backend_tu.service;

import java.util.List;

import com.apap.backend_tu.model.JenisLowonganModel;

public interface LowonganService {

    JenisLowonganModel addJenisLowongan(JenisLowonganModel jenisLowongan);

    List<JenisLowonganModel> getAllJenisLowongan();

}