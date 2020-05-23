package com.apap.backend_tu.service;

import java.util.List;

import com.apap.backend_tu.model.UserModel;

public interface UserService {
	List<UserModel> getAlluser();
	void deleteUser(String uuid);
	UserModel addUser(UserModel user);
	UserModel getUserByuuid(String uuid);
	UserModel getUserByusername(String username);
	boolean updateUser(String uuid, UserModel user);
	boolean validateUsername(String username);
	public String encrypt(String password);
}
