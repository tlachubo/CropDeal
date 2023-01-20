package com.cropdeal.adminservice.repositpry;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cropdeal.adminservice.model.Admin;
@Repository
public interface AdminRepository extends MongoRepository<Admin ,String>{

}
