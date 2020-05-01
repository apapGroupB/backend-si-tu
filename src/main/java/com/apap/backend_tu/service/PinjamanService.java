package com.apap.backend_tu.service;

import com.apap.backend_tu.model.PinjamanModel;
import com.apap.backend_tu.model.PengajuanSuratModel;


import java.util.List;

public interface PinjamanService {
    List<PinjamanModel> getAllPinjaman();
    PinjamanModel addPinjaman(PinjamanModel jenisSurat);
}
