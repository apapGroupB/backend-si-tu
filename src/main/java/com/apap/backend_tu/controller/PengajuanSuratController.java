package com.apap.backend_tu.controller;

import java.util.List;

import com.apap.backend_tu.model.LowonganModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.service.PengajuanSuratService;





@RestController
@RequestMapping("/pengajuan-surat")
@CrossOrigin(origins = "*")
public class PengajuanSuratController {
	
	@Autowired
	private PengajuanSuratService pengajuanSuratService;

	@GetMapping(value= "/viewall")
	public List<PengajuanSuratModel> viewAllPengajuanSurat(Model m) {
		List<PengajuanSuratModel> pengajuanSurat = pengajuanSuratService.getAllPengajuanSurat();
		return pengajuanSurat;	
	}
}
