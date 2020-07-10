package com.hemanth.graphql.testgraphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemanth.graphql.testgraphql.model.Users;
import com.hemanth.graphql.testgraphql.repository.UserRepository;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/all")
	public List<Users> getAll() {
		return userRepository.findAll();
	}
	
	@GetMapping("/name/{name}")
	public List<Users> findByName(@PathVariable("name") final String name) {
		return userRepository.findByName(name);
	}
	
	@GetMapping("/school/{school}")
	public List<Users> findBySchool(@PathVariable("school") final String school) {
		return userRepository.findBySchool(school);
	}

}
