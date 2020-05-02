package com.apap.backend_tu.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apap.backend_tu.model.JenisSuratModel;

@Repository
public interface JenisSuratDb extends JpaRepository<JenisSuratModel, Long> {
	JenisSuratModel findById(long id);

	@Query(value = "SELECT * FROM jenis_surat WHERE nama = ?1", nativeQuery = true)
	public ArrayList<JenisSuratModel> validatenama(String username);
}