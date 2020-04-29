package com.apap.backend_tu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apap.backend_tu.model.PengajuanSuratModel;


@Repository
public interface PengajuanSuratDb extends JpaRepository<PengajuanSuratModel, Long>{
    PengajuanSuratModel findById(long id);
    PengajuanSuratModel findByketerangan(String keterangan);
}