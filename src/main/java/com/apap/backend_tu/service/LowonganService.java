package com.apap.backend_tu.service;

import java.util.ArrayList;
import java.util.List;

import com.apap.backend_tu.model.LowonganModel;

public interface LowonganService {
    LowonganModel addLowongan(LowonganModel lowongan);
    List<LowonganModel> getAllLowongan();
    void deleteLowongan(long id);
    void updateLowongan(long id, LowonganModel lowongan);

//    LowonganModel getLowonganByUuid(String uuid);
    LowonganModel getLowonganById(long id);

}