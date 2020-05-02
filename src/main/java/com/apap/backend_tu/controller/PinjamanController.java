package com.apap.backend_tu.controller;

import java.util.List;
import com.apap.backend_tu.model.PinjamanModel;
import com.apap.backend_tu.service.PinjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pinjaman")
@CrossOrigin(origins = "*")
public class PinjamanController {

    @Autowired
    private PinjamanService pinjamanService;

    @GetMapping(value= "/viewall")
    public List<PinjamanModel> viewAllJenisSurat(Model m) {
        List<PinjamanModel> pinjaman = pinjamanService.getAllPinjaman();
        return pinjaman;}

    @PostMapping(value = "/add")
    public PinjamanModel addJenisSurat(@RequestBody PinjamanModel pinjaman) {
        return pinjamanService.addPinjaman(pinjaman);}
    
    
}