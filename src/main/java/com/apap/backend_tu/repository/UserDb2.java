package com.apap.backend_tu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apap.backend_tu.model.UserModel;
import com.apap.backend_tu.model.UserModel2;

import java.util.ArrayList;

import javax.transaction.Transactional;

@Repository
public interface UserDb2 extends JpaRepository<UserModel, Long> {
	UserModel2 findByuuid(String uuid);

	UserModel2 findByUsername(String username);
	// UserModel existsBy(String uuid);

	@Query(value = "SELECT * FROM user_profile WHERE username = ?1", nativeQuery = true)
	public ArrayList<UserModel2> validateUsername(String username);

	@Modifying
	@Query(
	  value = 
	    "insert into user_profile2 (nama, alamat) values (:nama, :alamat )",
	  nativeQuery = true)
	void insertuser_profile2(@Param("nama") String nama, @Param("alamat") String alamat);
}