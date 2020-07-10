package com.hemanth.graphql.testgraphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hemanth.graphql.testgraphql.model.Users;

public interface UserRepository extends JpaRepository<Users, String> {
	
	List<Users> findByName(String name);
	
	List<Users> findBySchool(String school);

}
