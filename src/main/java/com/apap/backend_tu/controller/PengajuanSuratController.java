package com.apap.backend_tu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.service.PengajuanSuratService;

@RestController
@RequestMapping("/pengajuan-surat")
@CrossOrigin(origins = "*")
public class PengajuanSuratController {

	@Autowired
	private PengajuanSuratService pengajuanSuratService;

	@GetMapping(value = "/viewall")
	public List<PengajuanSuratModel> viewAllPengajuanSurat(Model m) {
		List<PengajuanSuratModel> pengajuanSurat = pengajuanSuratService.getAllPengajuanSurat();
		return pengajuanSurat;
	}

	@PostMapping(value = "/add", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public PengajuanSuratModel addPengajuanSuratSubmit(@RequestBody PengajuanSuratModel pengajuanSurat) {
		return pengajuanSuratService.addPengajuanSurat(pengajuanSurat);
	}

	@PostMapping(value = "/update/{id}")
	public PengajuanSuratModel updatePengajuanSuratSubmit(@RequestBody PengajuanSuratModel pengajuanSurat,
			@PathVariable long id) {
		pengajuanSuratService.updatePengajuanSurat(id, pengajuanSurat);
		PengajuanSuratModel newPengajuan = pengajuanSuratService.getPengajuanSuratById(id);
		return newPengajuan;
	}

	@GetMapping(value = "/delete/{id}")
	private Boolean hapusPengajuan(@PathVariable(value = "id") long id, Model model) {
		pengajuanSuratService.deletePengajuanSurat(id);
		return true;
	}

}
