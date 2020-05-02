package com.apap.backend_tu.controller;

import java.util.List;

import com.apap.backend_tu.model.StatusModel;
import com.apap.backend_tu.model.JenisSuratModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import com.apap.backend_tu.service.JenisSuratService;

@RestController
@RequestMapping("/jenis-surat")
@CrossOrigin(origins = "*")
public class JenisSuratController {

	@Autowired
	private JenisSuratService jenisSuratService;

	@GetMapping(value = "/viewall")
	public List<JenisSuratModel> viewAllJenisSurat(Model m) {
		List<JenisSuratModel> jenisSurat = jenisSuratService.getAllJenisSurat();
		return jenisSurat;
	}

	@PostMapping(value = "/add", consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public StatusModel addJenisSuratModel(@RequestBody JenisSuratModel jenissurat) {
		if (jenisSuratService.validatenama(jenissurat.getNama())) {
			jenisSuratService.addJenisSurat(jenissurat);
			return new StatusModel(true, "data Added to DB", "user_profile");
		} else {
			return new StatusModel(false, "Username " + jenissurat.getNama() + " already Exists.", "user_profile");
		}
	}

	@PostMapping(value = "/update/{id}")
	public JenisSuratModel updateJenisSurat(@RequestBody JenisSuratModel pengajuanSurat, @PathVariable long id) {
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