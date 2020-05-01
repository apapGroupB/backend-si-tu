package com.apap.backend_tu.service;

import java.util.List;

import com.apap.backend_tu.model.LowonganModel;

public interface LowonganService {


    LowonganModel addLowongan(LowonganModel lowongan);

    List<LowonganModel> getAllLowongan();

    void updateLowongan(LowonganModel lowongan);

}