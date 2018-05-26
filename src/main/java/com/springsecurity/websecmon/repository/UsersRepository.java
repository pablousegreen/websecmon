package com.springsecurity.websecmon.repository;


import com.springsecurity.websecmon.model.Users;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository  extends MongoRepository<Users,String>{
		public Optional<Users> findByName(String userName);
}
