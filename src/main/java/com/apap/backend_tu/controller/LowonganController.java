package com.apap.backend_tu.controller;

import java.util.List;

import com.apap.backend_tu.model.JenisLowonganModel;
import com.apap.backend_tu.model.LowonganModel;
import com.apap.backend_tu.service.LowonganService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lowongan")
@CrossOrigin(origins = "*")
public class LowonganController {

    @Autowired
    private LowonganService lowonganService;

    @PostMapping(value = "/jenis/add")
    public JenisLowonganModel addJenisLowonganSubmit(@RequestBody JenisLowonganModel jenisLowongan) {
        return lowonganService.addJenisLowongan(jenisLowongan);
    }

    @GetMapping(value = "/jenis/viewall")
    public List<JenisLowonganModel> jenisLowonganViewAll() {
        List<JenisLowonganModel> jenisLowongan = lowonganService.getAllJenisLowongan();
        return jenisLowongan;
    }

    @PostMapping(value = "/add")
    public LowonganModel addLowonganSubmit(@RequestBody LowonganModel lowongan) {
        return lowonganService.addLowongan(lowongan);
    }

    @GetMapping(value = "/viewall")
    public List<LowonganModel> lowonganViewAll() {
        List<LowonganModel> lowongan = lowonganService.getAllLowongan();
        return lowongan;
    }

}