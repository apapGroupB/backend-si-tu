package com.apap.backend_tu.service;

import java.util.List;


import com.apap.backend_tu.model.UserModel;

public interface UserService {
	List<UserModel> getAlluser();
	void deletePengajuanSurat(String uuid);
	UserModel addUser(UserModel user);
	UserModel getUserByuuid(String uuid);
	UserModel getUserByusername(String username);
	void updateUser(String uuid, UserModel user);

}
