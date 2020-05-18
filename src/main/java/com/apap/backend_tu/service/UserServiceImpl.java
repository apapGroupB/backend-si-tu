package com.apap.backend_tu.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.backend_tu.model.UserModel;
import com.apap.backend_tu.repository.UserDb;
import com.apap.backend_tu.repository.UserDb2;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDb UserDb;
	
	@Autowired
	private UserDb2 UserDb2;

	@Override
	public UserModel addUser(UserModel user) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		UserModel cek = this.getUserByuuid(uuid);
		// String uname = user.getUsername();
		// UserModel validation=this.getUserByusername(uname);
		// if(validation!=null) {
		// return null;
		// }
		DateFormat tonip = new SimpleDateFormat("yyyyMMdd");
		Date lahir = user.getTanggal_lahir();
		String convert = tonip.format(lahir);
		String nip = "P" + convert + uuid;

		while (cek != null) {
			uuid = UUID.randomUUID().toString().replace("-", "");}
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
		user.setUuid(uuid);
		user.setNip(nip);
		UserDb2.insertuser_profile2(user.getNama(), user.getAlamat());
		return UserDb.save(user);
	}

	@Override
	public UserModel getUserByuuid(String uuid) {

		return UserDb.findByuuid(uuid);
	}

	@Override
	public List<UserModel> getAlluser() {
		// TODO Auto-generated method stub
		return UserDb.findAll();
	}

	@Override
	public void deletePengajuanSurat(String uuid) {
		UserDb.delete(this.getUserByuuid(uuid));
	}

	@Override
	public void updateUser(String uuid, UserModel user) {
		UserModel toset = this.getUserByuuid(uuid);
		toset.setId_role(user.getId_role());
		toset.setPassword(user.getPassword());
		toset.setUsername(user.getUsername());
		toset.setAlamat(user.getAlamat());
		toset.setNama(user.getNama());
		toset.setTanggal_lahir(user.getTanggal_lahir());
		toset.setTelepon(user.getTelepon());
		toset.setTempat_lahir(user.getTempat_lahir());
	}

	@Override
	public UserModel getUserByusername(String username) {
		// TODO Auto-generated method stub
		return UserDb.findByUsername(username);
	}

	@Override
	public boolean validateUsername(String username) {
		List<UserModel> users = UserDb.validateUsername(username);
		if (users.size() > 0) {
			return false;
		} else {
			return true;}}
	
    @Override
    public String encrypt(String password){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }
}
