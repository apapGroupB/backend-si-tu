package com.apap.backend_tu.service;

import java.util.List;

import com.apap.backend_tu.model.PinjamanModel;
import com.apap.backend_tu.model.UserModel;
import com.apap.backend_tu.model.UserModel2;

public interface UserService {
	List<UserModel> getAlluser();
	void deletePengajuanSurat(String uuid);
	UserModel addUser(UserModel user);
	UserModel getUserByuuid(String uuid);
	UserModel getUserByusername(String username);
	void updateUser(String uuid, UserModel user);
	boolean validateUsername(String username);
	public String encrypt(String password);

	
}
