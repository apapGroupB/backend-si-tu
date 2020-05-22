package com.apap.backend_tu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apap.backend_tu.model.PengajuanSuratModel;

@Repository
public interface PengajuanSuratDb extends JpaRepository<PengajuanSuratModel, Long> {
    PengajuanSuratModel findById(long id);

    PengajuanSuratModel findByketerangan(String keterangan);

    @Query(value = "SELECT * from pengajuan_surat WHERE nomor_surat = ?1", nativeQuery = true)
    PengajuanSuratModel findByNomorSurat(String nomor_surat);

}