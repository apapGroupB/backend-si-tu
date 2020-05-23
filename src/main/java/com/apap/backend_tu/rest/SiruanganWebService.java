package com.apap.backend_tu.rest;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.model.RestPengajuanSuratModel;
import com.apap.backend_tu.service.PengajuanSuratService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webservice")
@CrossOrigin(origins = "*")
public class SiruanganWebService {

    @Autowired
    private PengajuanSuratService pengajuanSuratService;

    @GetMapping(value = "cek-surat/{noSurat}")
    public RestPengajuanSuratModel getSuratSiruangan(@PathVariable(value = "noSurat") String nomor_surat, Model model) {
        PengajuanSuratModel surat = pengajuanSuratService.getPengajuanSuratByNoSurat(nomor_surat);
        RestPengajuanSuratModel result = new RestPengajuanSuratModel(surat.getNomor_surat(),
                surat.getTanggal_pengajuan(), surat.getTanggal_disetujui(), surat.getKeterangan(), surat.getStatus(),
                surat.getId_jenis_surat(), surat.getUuid_user());
        return result;
    }

}