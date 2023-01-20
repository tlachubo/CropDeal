package com.cropdeal.farmerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.farmerservice.model.Farmer;
import com.cropdeal.farmerservice.repository.FarmerRepository;

@Service
public class FarmerServiceImpl implements FarmerService{

	@Autowired
	FarmerRepository farmerrepository; 
	
	@Override
	public List<Farmer> findAll() {
		return farmerrepository.findAll();
	}
	
	@Override
	public Optional<Farmer> getFarmerById(String farmerId) {
		return farmerrepository.findById(farmerId);
	}

	@Override
	public Farmer addFarmer(Farmer farmer) {
	return farmerrepository.insert(farmer);
	}
	
	@Override
		public Farmer updateFarmer(Farmer farmer) {
		return farmerrepository.save(farmer);
		}

	@Override
	public String deleteById(String farmerId) {
		farmerrepository.deleteById(farmerId);
		return null;
	}
}


