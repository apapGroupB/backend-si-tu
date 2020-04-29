package com.apap.backend_tu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.model.UserModel;


@Repository
public interface UserDb extends JpaRepository<UserModel, Long>{
	UserModel findByuuid(String uuid);
}