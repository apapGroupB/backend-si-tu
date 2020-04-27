package com.apap.backend_tu.controller;

import java.sql.Date;
import java.util.List;

import com.apap.backend_tu.model.JenisLowonganModel;
import com.apap.backend_tu.model.LowonganModel;
import com.apap.backend_tu.service.LowonganService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;

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

    @DeleteMapping(value = "/jenis/delete/{delId}")
    public String deleteJenisLowongan(@PathVariable("delId") long id) {
        lowonganService.removeJenisLowongan(id);
        return "Jenis lowongan terhapus";
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

    @PutMapping(value = "update/{upId}")
    public String updateLowonganSubmit(@PathVariable(value = "upId") long upId, @RequestParam("judul") String judul,
            @RequestParam("tanggal_dibuka") Date tanggal_dibuka, @RequestParam("tanggal_ditutup") Date tanggal_ditutup,
            @RequestParam("keterangan") String keterangan, @RequestParam("jumlah") int jumlah,
            @RequestParam("id_jenis_lowongan") int id_jenis_lowongan, @RequestParam("uuid_user") String uuid_user) {

        return null;
    }

}