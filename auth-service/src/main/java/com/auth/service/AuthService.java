package com.auth.service;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth.dto.APIResponse;
import com.auth.dto.UserDto;
import com.auth.entity.AppUser;
import com.auth.repository.AuthRepository;

@Service 
public class AuthService {
	
	private AuthRepository authRepository;
	private PasswordEncoder passwordEncoder;
	
	public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder) {
		this.authRepository = authRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public APIResponse<String> registerUser(UserDto dto) {
		AppUser user=new AppUser();
		BeanUtils.copyProperties(dto, user);
		user.setPassword(passwordEncoder.encode(dto.getPassword()));
		authRepository.save(user);
		APIResponse<String> response=new APIResponse<>();
		response.setData("Registration Succesful");
		response.setStatus(201);
		response.setMessage("User registration completed!!");
		return response;
	}
	
	

}
