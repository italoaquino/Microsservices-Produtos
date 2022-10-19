package com.oauth.entities.services;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.oauth.entities.User;
import com.oauth.feingClients.UserFeing;


@Service
public class UserService implements UserDetailsService{

	private static org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeing userFeing;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeing.findByEmail(username).getBody();
		
		if(user == null) {
			logger.error("Email not Found");
			throw new UsernameNotFoundException("Email Inválido!");
		}
		logger.info(username);
		return user;
	}
	
	
}
