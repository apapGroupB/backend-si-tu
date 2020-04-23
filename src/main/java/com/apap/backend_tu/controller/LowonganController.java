package com.apap.backend_tu.controller;

import java.util.List;

import com.apap.backend_tu.model.JenisLowonganModel;
import com.apap.backend_tu.service.LowonganService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lowongan")
public class LowonganController {

    @Autowired
    private LowonganService lowonganService;

    @PostMapping(value = "/jenislowongan/add")
    public JenisLowonganModel addJenisLowonganSubmit(@RequestBody JenisLowonganModel jenisLowongan) {
        return lowonganService.addJenisLowongan(jenisLowongan);
    }

    @GetMapping(value = "/jenislowongan/viewall")
    public List<JenisLowonganModel> jenisLowonganViewAll() {
        List<JenisLowonganModel> jenisLowongan = lowonganService.getAllJenisLowongan();
        return jenisLowongan;
    }

}