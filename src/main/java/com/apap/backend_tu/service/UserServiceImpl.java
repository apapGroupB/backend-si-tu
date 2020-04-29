package com.apap.backend_tu.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.backend_tu.model.UserModel;
import com.apap.backend_tu.repository.UserDb;



@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDb UserDb;

	@Override
	public UserModel addUser(UserModel user) {
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyymmddHHmmssSSS");
        String strDate = dateFormat.format(date);
        user.setUuid(strDate);
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
		UserModel toset=this.getUserByuuid(uuid);
		toset.setId_role(user.getId_role());
		toset.setPassword(user.getPassword());
		toset.setUsername(user.getUsername());
	}





}
