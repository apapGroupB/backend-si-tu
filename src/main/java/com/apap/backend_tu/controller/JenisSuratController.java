package com.apap.backend_tu.controller;

import java.util.List;

import com.apap.backend_tu.model.LowonganModel;
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
}