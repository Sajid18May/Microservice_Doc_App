package com.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.entity.AppUser;

@Repository
public interface AuthRepository extends JpaRepository<AppUser, Long>{
	
	Optional<AppUser> findAppUserByEmail(String email);
	Optional<AppUser> findAppUserByUsername(String username);
}
