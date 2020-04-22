package com.apap.backend_tu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.backend_tu.repository.UserDb;



@Service
@Transactional
public class UserServiceImpl {
	
	@Autowired
	private UserDb UserDb;

}
