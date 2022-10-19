package com.hruser.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hruser.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByEmail(String email);
	
}
