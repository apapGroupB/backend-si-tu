package com.apap.backend_tu.service;

import java.util.List;
import com.apap.backend_tu.model.PinjamanModel;
import com.apap.backend_tu.model.UserModel;
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
        return pinjaman;}

	@Override
	public PinjamanModel getPinjamanByid(long id) {
		return pinjamanDb.findById(id);
	}


	@Override
	public void deletePengajuanSurat(long id) {
		pinjamanDb.delete(this.getPinjamanByid(id));}


	@Override
	public void updatePinjaman(String uuid, UserModel user) {
		// TODO Auto-generated method stub
		
	}
	
}