package com.apap.backend_tu.service;

import com.apap.backend_tu.model.PinjamanModel;

import java.util.List;

public interface PinjamanService {
    List<PinjamanModel> getAllPinjaman();

    PinjamanModel   addPinjaman(PinjamanModel jenisSurat);

    void deletePinjaman(long id);

    PinjamanModel getPinjamanByid(long id);

    void updatePinjaman(long id, PinjamanModel pinjaman);

}
