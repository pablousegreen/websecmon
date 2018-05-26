package com.springsecurity.websecmon.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.springsecurity.websecmon.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
	
}
