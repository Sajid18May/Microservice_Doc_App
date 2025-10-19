package com.auth.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class JwtService {
	private static final String SECRET_KEY="MySecretKey";
	private static final long EXPIRATION_TIME=86400000;
	
	public String generateJwtToken(String username, String role) {
		return JWT.create()
				.withSubject(username)
				.withClaim("role", role)
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
				.sign(Algorithm.HMAC256(SECRET_KEY));
		
	}
	
	public String getSubjectFromJwtToken(String token) {
		return JWT.require(Algorithm.HMAC256(SECRET_KEY))
				.build()
				.verify(token)
				.getSubject();
	}
}
