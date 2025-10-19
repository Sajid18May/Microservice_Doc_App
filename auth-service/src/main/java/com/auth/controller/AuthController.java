package com.auth.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.dto.APIResponse;
import com.auth.dto.LoginDto;
import com.auth.dto.UserDto;
import com.auth.service.AuthService;
import com.auth.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	private AuthService authService;
	private AuthenticationManager authenticationManager;
	private JwtService jwtService;
	
	
	public AuthController(AuthService authService, AuthenticationManager authenticationManager, JwtService jwtService) {
		this.authService = authService;
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
	}

	@PostMapping("/login")
	public ResponseEntity<APIResponse<String>> userLogin(LoginDto dto) {
		APIResponse<String> response = new APIResponse<>();
		UsernamePasswordAuthenticationToken passwordAuthenticationToken= new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
		Authentication authentication=authenticationManager.authenticate(passwordAuthenticationToken);
		if(authentication.isAuthenticated()) {
			jwtService.generateJwtToken(dto.getUsername(), authentication.getAuthorities().iterator().next().getAuthority());
			response.setStatus(200);
			response.setMessage("Welcome "+dto.getUsername());
			response.setData("Login Successful");
			return new ResponseEntity<APIResponse<String>>(response, HttpStatusCode.valueOf(response.getStatus()));
		}
		response.setStatus(401);
		response.setMessage("Wrong username or Password");
		response.setData("Login Failed");
		return new ResponseEntity<APIResponse<String>>(response, HttpStatusCode.valueOf(response.getStatus()));
	}
	
	@PostMapping("/register")
	public ResponseEntity<APIResponse<String>> userRestration(UserDto dto) {
		APIResponse<String> response = authService.registerUser(dto);
		return new ResponseEntity<APIResponse<String>>(response, HttpStatusCode.valueOf(response.getStatus()));
	}

}
