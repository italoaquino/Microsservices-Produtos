package com.oauth.feingClients;

import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oauth.entities.User;


@Component
@FeignClient(name = "hr-user",  decode404 = true, path = "/api/v1")
public interface UserFeing {

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	ResponseEntity<User> findByEmail(@RequestParam String email);
	
}
