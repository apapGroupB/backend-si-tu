package com.apap.backend_tu.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.apap.backend_tu.model.SivitasGuruModel;
import com.apap.backend_tu.model.SivitasPegawaiModel;
import com.apap.backend_tu.model.SivitasSiswaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.backend_tu.model.UserModel;
import com.apap.backend_tu.repository.UserDb;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDb UserDb;

	private static boolean addUserSivitas(UserModel user)
	{
		final String uri = "http://si-sivitas.herokuapp.com/api";
		RestTemplate restTemplate = new RestTemplate();
		if(user.getId_role() == 3) {
			SivitasGuruModel newGuru = new SivitasGuruModel(user);
			SivitasGuruModel result = restTemplate.postForObject( (uri+"/teachers"), newGuru, SivitasGuruModel.class);
			return true;
		} else if(user.getId_role() == 4) {
			SivitasSiswaModel newSiswa = new SivitasSiswaModel(user);
			SivitasSiswaModel result = restTemplate.postForObject((uri+"/students"), newSiswa, SivitasSiswaModel.class);
			return true;
		} else {
			SivitasPegawaiModel newPegawai = new SivitasPegawaiModel(user);
//			System.out.println("HEYOOW CEK: " + newPegawai.getIdUser());
//			System.out.println("HEYOOW CEK1: " + newPegawai.getNip());
//			System.out.println("HEYOOW CEK2: " + newPegawai.getNama());
//			System.out.println("HEYOOW CEK3: " + newPegawai.getTanggalLahir());
//			System.out.println("HEYOOW CEK4: " + newPegawai.getTempatLahir());
//			System.out.println("HEYOOW CEK5: " + newPegawai.getAlamat());
//			System.out.println("HEYOOW CEK6: " + newPegawai.getTelepon());
			System.out.println("PATHH: " + uri+"/employees");
			System.out.println("PEGAWAI: " + newPegawai);
			SivitasPegawaiModel result = restTemplate.postForObject((uri+"/employees"), newPegawai, SivitasPegawaiModel.class);
			return true;
		}
	}

	@Override
	public UserModel addUser(UserModel user) {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		UserModel cek = this.getUserByuuid(uuid);
		DateFormat tonip = new SimpleDateFormat("ddMMyyyy");
		Date lahir = user.getTanggal_lahir();
		String convert = tonip.format(lahir);
		String nip = (user.getId_role() == 3 ? "G" : user.getId_role() == 4 ? "S" : "P") + convert + uuid;

		while (cek != null) {
			uuid = UUID.randomUUID().toString().replace("-", "");}
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
		user.setUuid(uuid);
		user.setNip(nip);

		addUserSivitas(user);
		return UserDb.save(user);
	}

	@Override
	public UserModel getUserByuuid(String uuid) {

		return UserDb.findByuuid(uuid);
	}

	@Override
	public List<UserModel> getAlluser() {
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
		toset.setAlamat(user.getAlamat());
		toset.setNama(user.getNama());
		toset.setTanggal_lahir(user.getTanggal_lahir());
		toset.setTelepon(user.getTelepon());
		toset.setTempat_lahir(user.getTempat_lahir());
	}

	@Override
	public UserModel getUserByusername(String username) {
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
