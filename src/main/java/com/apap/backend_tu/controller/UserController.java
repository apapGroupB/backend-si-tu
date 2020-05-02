package com.apap.backend_tu.controller;

import java.util.List;

import com.apap.backend_tu.model.StatusModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apap.backend_tu.model.PengajuanSuratModel;
import com.apap.backend_tu.model.UserModel;
import com.apap.backend_tu.service.UserService;


//import com.apap.backend_tu.service.UserService;
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value= "/viewall")
	public List<UserModel> viewAlluser(Model m) {
		List<UserModel> user = userService.getAlluser();
		return user;}
	
	@PostMapping(value = "/add",consumes= {MimeTypeUtils.APPLICATION_JSON_VALUE})
	public StatusModel addusermodel(@RequestBody UserModel user) {
		if(userService.validateUsername(user.getUsername())) {
			userService.addUser(user);
			return new StatusModel(true, "data Added to DB", "user_profile");
		} else {
			return new StatusModel(false, "Username " + user.getUsername() + " already Exists.", "user_profile");
		}
	}
	
	@GetMapping(value = "/delete/{uuid}")
	private Boolean hapusUser(@PathVariable(value = "uuid") String uuid, Model model) {
		userService.deletePengajuanSurat(uuid);
		return true;}
	
	@PostMapping(value = "/update/{uuid}")
	public UserModel updateUser(
			@RequestBody UserModel user,
			@PathVariable String uuid) {
		userService.updateUser(uuid, user);
		UserModel newUser = userService.getUserByuuid(uuid);
		return newUser;
	}
	
}
