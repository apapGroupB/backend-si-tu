package com.apap.backend_tu.service;

import com.apap.backend_tu.model.PinjamanModel;
import com.apap.backend_tu.model.UserModel;



import java.util.List;

public interface PinjamanService {
    List<PinjamanModel> getAllPinjaman();
    PinjamanModel addPinjaman(PinjamanModel jenisSurat);
    void deletePengajuanSurat(long id);
	PinjamanModel getPinjamanByid(long id);
	void updatePinjaman(String uuid, UserModel user);
}
