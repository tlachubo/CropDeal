package com.cropdeal.dealerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cropdeal.dealerservice.models.Dealer;

@Service
@Component
public interface DealerService {
	
	public List<Dealer> findAll();
	public Dealer updateDealer(Dealer dealer);
	public Optional<Dealer> getDealerById(String id);
    public Dealer addDealer(Dealer dealer) ;
    public String deleteById(String id);

}
