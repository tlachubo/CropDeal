package com.cropdeal.dealerservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropdeal.dealerservice.models.Dealer;
import com.google.common.base.Optional;

public interface DealerRepository extends MongoRepository<Dealer, String>{
	
	

}
