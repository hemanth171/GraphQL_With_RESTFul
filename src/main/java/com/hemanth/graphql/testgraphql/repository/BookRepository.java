package com.hemanth.graphql.testgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemanth.graphql.testgraphql.model.Books;

public interface BookRepository extends JpaRepository<Books, String> {
	
	Books findByIsn(String isn);

}
