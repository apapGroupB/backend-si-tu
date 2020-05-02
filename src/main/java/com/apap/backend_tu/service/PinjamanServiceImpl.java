package com.apap.backend_tu.service;

import java.util.List;
import com.apap.backend_tu.model.PinjamanModel;
import com.apap.backend_tu.repository.PinjamanDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PinjamanServiceImpl implements PinjamanService {
	@Autowired
	private PinjamanDb pinjamanDb;

	@Override
	public List<PinjamanModel> getAllPinjaman() {
		return pinjamanDb.findAll();
	}

	@Override
	public PinjamanModel addPinjaman(PinjamanModel pinjaman) {
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