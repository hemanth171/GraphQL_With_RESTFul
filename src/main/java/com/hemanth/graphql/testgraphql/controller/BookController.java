package com.hemanth.graphql.testgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hemanth.graphql.testgraphql.service.GraphQLService;

import graphql.ExecutionResult;

@RestController
@RequestMapping("/graphql/books")
public class BookController {
	
	@Autowired
	GraphQLService graphQLService;
	
	@PostMapping("/all")
	public ResponseEntity<Object> getAllBooks(@RequestBody String query) {
		ExecutionResult execute = graphQLService.getGraphQL().execute(query);
		
		return new ResponseEntity<>(execute, HttpStatus.OK);
	}

}
