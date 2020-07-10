package com.hemanth.graphql.testgraphql.service.datafetcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hemanth.graphql.testgraphql.model.Books;
import com.hemanth.graphql.testgraphql.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class BookDataFetcher implements DataFetcher<Books> {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public Books get(DataFetchingEnvironment dataFetchingEnvironment) {
		String isn = dataFetchingEnvironment.getArgument("id");
		
		return bookRepository.findByIsn(isn);
	}

}
