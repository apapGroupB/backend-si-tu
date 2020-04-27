package com.apap.backend_tu.controller;

import java.util.List;

import com.apap.backend_tu.model.LowonganModel;
import com.apap.backend_tu.model.JenisSuratModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.apap.backend_tu.model.JenisSuratModel;
import com.apap.backend_tu.service.JenisSuratService;





@RestController				
@RequestMapping("/jenis-surat")
@CrossOrigin(origins = "*")
public class JenisSuratController {
	
	@Autowired
	private JenisSuratService jenisSuratService;

	@GetMapping(value= "/viewall")
	public List<JenisSuratModel> viewAllJenisSurat(Model m) {
		List<JenisSuratModel> jenisSurat = jenisSuratService.getAllJenisSurat();
		return jenisSurat;	
	}

	@PostMapping(value = "/add")
	public JenisSuratModel addJenisSurat(@RequestBody JenisSuratModel jenisSurat) {
		return jenisSuratService.addJenisSurat(jenisSurat);
	}

	@PostMapping(value = "/update/{id}")
	public JenisSuratModel updateJenisSurat(
			@RequestBody JenisSuratModel pengajuanSurat,
			@PathVariable long id) {
		jenisSuratService.updateJenisSurat(id, pengajuanSurat);
		JenisSuratModel newPengajuan = jenisSuratService.getJenisSuratById(id);
		return newPengajuan;
	}

	@GetMapping(value = "/delete/{id}")
	private Boolean hapusJenisSurat(@PathVariable(value = "id") long id, Model model) {
		jenisSuratService.deleteJenisSurat(id);
		return true;
	}
}