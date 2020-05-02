package com.apap.backend_tu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.model.UserModel;

import java.util.ArrayList;


@Repository
public interface UserDb extends JpaRepository<UserModel, Long>{
	UserModel findByuuid(String uuid);
	UserModel findByusername(String username);
//	UserModel existsBy(String uuid);

	@Query(value = "SELECT * FROM user_profile WHERE username = ?1", nativeQuery = true)
	public ArrayList<UserModel> validateUsername(String username);
}