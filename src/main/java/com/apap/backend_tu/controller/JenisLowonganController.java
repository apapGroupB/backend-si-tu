package com.apap.backend_tu.controller;

import com.apap.backend_tu.model.JenisLowonganModel;
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

    @PostMapping(value = "/jenis/add")
    public JenisLowonganModel addJenisLowonganSubmit(@RequestBody JenisLowonganModel jenisLowongan) {
        return jenisLowonganService.addJenisLowongan(jenisLowongan);
    }

    @GetMapping(value = "/jenis/viewall")
    public List<JenisLowonganModel> jenisLowonganViewAll() {
        List<JenisLowonganModel> jenisLowongan = jenisLowonganService.getAllJenisLowongan();
        return jenisLowongan;
    }

    @DeleteMapping(value = "/jenis/delete/{delId}")
    public String deleteJenisLowongan(@PathVariable("delId") long id) {
        jenisLowonganService.removeJenisLowongan(id);
        return "Jenis lowongan terhapus";
    }
}
