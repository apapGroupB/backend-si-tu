package com.apap.backend_tu.service;

import java.util.List;

import com.apap.backend_tu.model.KoperasiPinjamanModel;
import com.apap.backend_tu.model.PinjamanModel;
import com.apap.backend_tu.model.SivitasSiswaModel;
import com.apap.backend_tu.model.UserModel;
import com.apap.backend_tu.repository.PinjamanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class PinjamanServiceImpl implements PinjamanService {
	@Autowired
	private PinjamanDb pinjamanDb;
	
	private static boolean addPinjamanKoperasi(PinjamanModel pinjaman) {
		final String url = "http://si-sivitas.herokuapp.com/api";
		RestTemplate restTemplate = new RestTemplate();
		KoperasiPinjamanModel koperasi = new KoperasiPinjamanModel(pinjaman);
		KoperasiPinjamanModel result = restTemplate.postForObject((url), koperasi, KoperasiPinjamanModel.class);
		return true;}

	@Override
	public List<PinjamanModel> getAllPinjaman() {
		return pinjamanDb.findAll();
	}

	@Override
	public PinjamanModel addPinjaman(PinjamanModel pinjaman) {
		addPinjamanKoperasi(pinjaman);
		pinjamanDb.save(pinjaman);
		return pinjaman;
	}

	@Override
	public PinjamanModel getPinjamanByid(long id) {
		return pinjamanDb.findById(id);
	}

	@Override
	public void deletePinjaman(long id) {
		pinjamanDb.delete(this.getPinjamanByid(id));
	}

	@Override
	public void updatePinjaman(long id, PinjamanModel pinjaman) {
		PinjamanModel pinjam = this.getPinjamanByid(id);
		pinjam.setJumlah_pengembalian(pinjaman.getJumlah_pengembalian());
		pinjam.setJumlah_pinjaman(pinjaman.getJumlah_pinjaman());
		pinjam.setStatus(pinjaman.getStatus());
		pinjam.setTanggal_disetujui(pinjaman.getTanggal_disetujui());
		pinjam.setTanggal_pengajuan(pinjaman.getTanggal_disetujui());
		pinjam.setTanggal_pengembalian(pinjaman.getTanggal_pengembalian());
	}

}