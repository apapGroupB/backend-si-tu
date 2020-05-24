package com.apap.backend_tu.repository;

import com.apap.backend_tu.model.PengajuanSuratModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DashboardDB extends JpaRepository<PengajuanSuratModel, Long> {

//    @Query(value = "WITH list_date AS (SELECT ( (NOW() + INTERVAL '1 day')  + CONCAT(IFNULL((s::LONGTEXT, '') , ' day'))::VARCHAR(30) ::DATETIME(0) AS created FROM generate_series(-20, 20, 1) AS s) select new ValueModel(count(ps.id_jenis_surat), DATE_FORMAT(created, '%Y-%m-%d') as submit_date) FROM list_date left join pengajuan_surat ps on ps.tanggal_pengajuan::longtext = DATE_FORMAT(created, '%Y-%m-%d') WHERE created BETWEEN NOW()::DATE-EXTRACT(DOW FROM NOW())::INTEGER-14 AND (NOW() + INTERVAL '1 day')::DATE-EXTRACT(DOW from NOW())::INTEGER group by ps.id_jenis_surat, DATE_FORMAT(created, '%Y-%m-%d') order by submit_date;", nativeQuery = true)
//    List<ValueModel> getPengajuanList();

    @Query(value = "select count(ps.id_jenis_surat) as count, ps.id_jenis_surat, ps.tanggal_pengajuan from pengajuan_surat ps where ps.tanggal_pengajuan BETWEEN DATE_SUB(NOW(), INTERVAL 14 DAY) AND NOW() GROUP by ps.id_jenis_surat, ps.tanggal_pengajuan;", nativeQuery = true)
    List<Object> getPengajuanList();

    @Query(value = "SELECT count(*) from pengajuan_surat", nativeQuery = true)
    int getTotalPengajuan();

    @Query(value = "SELECT count(*) from lowongan", nativeQuery = true)
    int getTotalLowongan();

    @Query(value = "SELECT count(*) from user_profile", nativeQuery = true)
    int getTotalUser();

    @Query(value = "SELECT count(ps.status) as count, ps.status  from pengajuan_surat ps group by ps.status order by ps.status", nativeQuery = true)
    List<Object> getByJenisSurat();
}
