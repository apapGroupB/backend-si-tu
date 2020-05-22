package com.apap.backend_tu.controller;

import java.util.ArrayList;
import java.util.List;

import com.apap.backend_tu.model.LowonganModel;
import com.apap.backend_tu.model.RestUserModel;
import com.apap.backend_tu.rest.PerpustakaanWebService;
import com.apap.backend_tu.service.LowonganService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/lowongan")
@CrossOrigin(origins = "*")
public class LowonganController {

    @Autowired
    private PerpustakaanWebService perpustakaanWebService;

    @Autowired
    private LowonganService lowonganService;

    @PostMapping(value = "/add")
    public LowonganModel addLowonganSubmit(@RequestBody LowonganModel lowongan) {
        return lowonganService.addLowongan(lowongan);
    }

    @GetMapping(value = "/viewall")
    public List<LowonganModel> lowonganViewAll() {
        List<LowonganModel> lowongan = lowonganService.getAllLowongan();
        RestUserModel userRequired = perpustakaanWebService.getTotalUserPustakawan();
        if(userRequired.getTotal() < 5) {

            LowonganModel newLowongan = new LowonganModel(5 - userRequired.getTotal());
            lowonganService.addLowongan(newLowongan);
        }
        return lowongan;
    }

    @GetMapping(value = "perpustakaan/viewall")
    public List<RestUserModel> perpustakaanViewAll() {
        final String uri = "http://si-perpus-b6.herokuapp.com/perpustakaan/user/viewall";
        RestTemplate restTemplate = new RestTemplate();
        List<RestUserModel> result = restTemplate.getForObject(uri, List.class);
        return result;
    }

    @PostMapping(value = "update/{id}")
    public LowonganModel updateLowonganSubmit(@PathVariable long id, @RequestBody LowonganModel lowongan) {
        lowonganService.updateLowongan(id, lowongan);
        LowonganModel newLowongan = lowonganService.getLowonganById(id);
        return newLowongan;
    }

    @GetMapping(value = "/delete/{id}")
    private Boolean hapusLowongan(@PathVariable(value = "id") long id, Model model) {
        lowonganService.deleteLowongan(id);
        return true;
    }
}