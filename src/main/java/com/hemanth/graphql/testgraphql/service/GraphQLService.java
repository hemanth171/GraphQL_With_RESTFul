package com.hemanth.graphql.testgraphql.service;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.hemanth.graphql.testgraphql.model.Books;
import com.hemanth.graphql.testgraphql.repository.BookRepository;
import com.hemanth.graphql.testgraphql.service.datafetcher.AllBooksDataFetcher;
import com.hemanth.graphql.testgraphql.service.datafetcher.BookDataFetcher;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Service
public class GraphQLService {
	
	@Value("classpath:books.graphql")
	Resource resource;
	
	private GraphQL graphQL;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	AllBooksDataFetcher allBooksDataFetcher;
	
	@Autowired
	BookDataFetcher bookDataFetcher;
	
	@PostConstruct
	private void loadSchema() throws IOException {
		System.out.println("Starting loadSchema");
		
		// Load the data into DB
		loadDataIntoHSQL();
		
		// Load the shcema file
		File schemaFile = resource.getFile();
		// Parse the schema
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemaFile);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		graphQL = GraphQL.newGraphQL(schema).build();
		System.out.println("Ending loadSchema");
	}
	
	private void loadDataIntoHSQL() {

        Stream.of(
                new Books("123", "Book of Clouds", "Kindle Edition",
                        new String[] {
                        "Chloe Aridjis"
                        }, "Nov 2017"),
                new Books("124", "Cloud Arch & Engineering", "Orielly",
                        new String[] {
                                "Peter", "Sam"
                        }, "Jan 2015"),
                new Books("125", "Java 9 Programming", "Orielly",
                        new String[] {
                                "Venkat", "Ram"
                        }, "Dec 2016")
        ).forEach(book -> {
            bookRepository.save(book);
        });
    }
	
	private RuntimeWiring buildRuntimeWiring() {
		return RuntimeWiring.newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring
						.dataFetcher("allBooks", allBooksDataFetcher)
						.dataFetcher("book", bookDataFetcher))
				.build();
	}
	
	public GraphQL getGraphQL() {
		return graphQL;
	}
}
