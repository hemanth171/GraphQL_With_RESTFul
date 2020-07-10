package com.hemanth.graphql.testgraphql.service.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hemanth.graphql.testgraphql.model.Books;
import com.hemanth.graphql.testgraphql.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllBooksDataFetcher implements DataFetcher<List<Books>> {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Books> get(DataFetchingEnvironment arg0) {
		return bookRepository.findAll();
	}

}
