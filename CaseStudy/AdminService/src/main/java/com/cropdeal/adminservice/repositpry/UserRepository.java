package com.cropdeal.adminservice.repositpry;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.cdi.MongoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.cropdeal.adminservice.model.UserModel;
@Repository
public interface UserRepository extends MongoRepository<UserModel,String>{

	UserModel findByUsername(String username);

}
