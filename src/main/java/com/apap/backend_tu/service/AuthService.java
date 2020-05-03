package com.apap.backend_tu.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface AuthService {
    UserDetails loadUserByUsername(String username);
};
