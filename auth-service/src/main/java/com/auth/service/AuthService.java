package com.auth.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.repository.AuthRepository;

@Service 
public class AuthService {
	
	private AuthRepository authRepository;
	private PasswordEncoder passwordEncoder;
	
	public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
		this.authRepository = authRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	

}
