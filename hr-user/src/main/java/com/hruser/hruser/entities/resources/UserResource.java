package com.hruser.hruser.entities.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hruser.hruser.entities.User;
import com.hruser.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

	private UserRepository userRepository;
	
	public UserResource(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		return new ResponseEntity<List<User>>(userRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		return new ResponseEntity<User>(userRepository.findByEmail(email), HttpStatus.OK);
	}
	
}
