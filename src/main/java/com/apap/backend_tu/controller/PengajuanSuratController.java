package com.apap.backend_tu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.service.PengajuanSuratService;





@RestController
@CrossOrigin(origins = "*")
public class PengajuanSuratController {
	
	@Autowired
	private PengajuanSuratService pengajuanSuratService;

//	@CrossOrigin(origins = "http://localhost:2016")
	@GetMapping(value= "/pengajuan-surat")
	public List<PengajuanSuratModel> viewAllPilot(Model m) {
		List<PengajuanSuratModel> pengajuanSurat = pengajuanSuratService.getAllPengajuanSurat();
		System.out.println(pengajuanSurat);
		return pengajuanSurat;	
	}
}
