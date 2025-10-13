package com.auth.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.dto.APIResponse;
import com.auth.dto.LoginDto;
import com.auth.dto.UserDto;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@PostMapping("/login")
	public ResponseEntity<APIResponse<String>> userLogin(LoginDto dto) {
		APIResponse<String> response = new APIResponse<>();
		return new ResponseEntity<APIResponse<String>>(response, HttpStatusCode.valueOf(response.getStatus()));
	}
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse<String>> userRestration(UserDto dto) {
		APIResponse<String> response = new APIResponse<>();
		return new ResponseEntity<APIResponse<String>>(response, HttpStatusCode.valueOf(response.getStatus()));
	}

}
