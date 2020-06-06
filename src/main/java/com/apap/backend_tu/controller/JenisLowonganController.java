package com.apap.backend_tu.controller;

import com.apap.backend_tu.model.JenisLowonganModel;
import com.apap.backend_tu.model.StatusModel;
import com.apap.backend_tu.service.JenisLowonganService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jenis-lowongan")
@CrossOrigin(origins = "*")
public class JenisLowonganController {

    @Autowired
    private JenisLowonganService jenisLowonganService;

    @PostMapping(value = "/add")
    public StatusModel addJenisLowonganSubmit(@RequestBody JenisLowonganModel jenisLowongan) {
        int validate = jenisLowonganService.validateByNama(jenisLowongan);
        if (validate == 0) {
            jenisLowonganService.addJenisLowongan(jenisLowongan);
            return new StatusModel(true, "data Added to DB", "jenis_lowongan");
        } else
            return new StatusModel(false, "Username " + jenisLowongan.getNama() + " already Exists.", "jenis_lowongan");
    }

    @GetMapping(value = "/viewall")
    public List<JenisLowonganModel> jenisLowonganViewAll() {
        List<JenisLowonganModel> jenisLowongan = jenisLowonganService.getAllJenisLowongan();
        return jenisLowongan;
    }

    @GetMapping(value = "/delete/{delId}")
    public String deleteJenisLowongan(@PathVariable("delId") long id) {
        jenisLowonganService.removeJenisLowongan(id);
        return "Jenis lowongan terhapus";
    }

}
