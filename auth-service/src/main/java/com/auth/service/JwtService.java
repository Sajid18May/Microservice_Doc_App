package com.auth.service;

import org.springframework.stereotype.Service;

@Service
public class JwtService {
	private static final String SECRET_KEY="MySecretKey";
	private static final long EXPIRATION_TIME=86400000;
}
