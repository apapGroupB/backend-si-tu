package com.apap.backend_tu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.service.PengajuanSuratService;





@RestController
public class PengajuanSuratController {
	
	@Autowired
	private PengajuanSuratService pengajuanSuratService;
	
	@GetMapping(value= "/pengajuan-surat")
	public List<PengajuanSuratModel> viewAllPilot(Model m) {
		List<PengajuanSuratModel> pengajuanSurat = pengajuanSuratService.getAllPengajuanSurat();
		System.out.println(pengajuanSurat);
		return pengajuanSurat;	
	}
}
