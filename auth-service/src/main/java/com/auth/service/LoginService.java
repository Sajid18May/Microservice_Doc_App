package com.auth.service;

import java.util.Collections;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auth.entity.AppUser;
import com.auth.repository.AuthRepository;

@Service
public class LoginService implements UserDetailsService{
	private AuthRepository authRepository;
		
	public LoginService(AuthRepository authRepository) {
		this.authRepository = authRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = authRepository.findAppUserByUsername(username).get();	
		return new User(username, user.getPassword(),Collections.singleton(new SimpleGrantedAuthority(user.getRole())));
	}

}
