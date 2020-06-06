package com.apap.backend_tu.repository;

import com.apap.backend_tu.model.LowonganModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface LowonganDb extends JpaRepository<LowonganModel, Long> {
    LowonganModel findById(long id);
    // LowonganModel findByUuid_user(String uuid);

    // @Query(value = "SELECT * from lowongan WHERE uuid_user = 'siperpustakaan' AND
    // tanggal_dibuka < tanggal_ditutup AND tanggal_ditutup > CURRENT_DATE;",
    // nativeQuery = true)
    @Query(value = "SELECT * from lowongan WHERE judul = 'Lowongan Pustakawan' AND tanggal_ditutup > CURRENT_DATE;", nativeQuery = true)
    public ArrayList<LowonganModel> validaLowonganPerpus();
}