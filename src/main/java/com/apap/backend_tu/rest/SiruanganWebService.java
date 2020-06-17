package com.apap.backend_tu.rest;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.model.RestPengajuanSuratModel;
import com.apap.backend_tu.model.StatusModel;
import com.apap.backend_tu.service.PengajuanSuratService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public static final Logger logger = LoggerFactory.getLogger(SiruanganWebService.class);

    @Autowired
    private PengajuanSuratService pengajuanSuratService;

    @GetMapping(value = "cek-surat/{noSurat}")
    public ResponseEntity<?> getSuratSiruangan(@PathVariable(value = "noSurat") String nomor_surat, Model model) {
        logger.info("Fetching Surat with nomor_surat {}", nomor_surat);
        PengajuanSuratModel surat = pengajuanSuratService.getPengajuanSuratByNoSurat(nomor_surat);
        if (surat == null) {
            logger.error("Surat with nomor_surat {} not found", nomor_surat);
            // String error = "Surat with nomor_surat " + nomor_surat + " not found";
            StatusModel status = new StatusModel(false, "Not found", "");
            return new ResponseEntity<StatusModel>(status, HttpStatus.NOT_FOUND);
        }
        RestPengajuanSuratModel result = new RestPengajuanSuratModel(surat.getNomor_surat(),
                surat.getTanggal_pengajuan(), surat.getTanggal_disetujui(), surat.getKeterangan(), surat.getStatus(),
                surat.getId_jenis_surat(), surat.getUuid_user());
        return new ResponseEntity<RestPengajuanSuratModel>(result, HttpStatus.OK);
    }

}