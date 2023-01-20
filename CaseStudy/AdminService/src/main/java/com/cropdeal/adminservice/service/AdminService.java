package com.cropdeal.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cropdeal.adminservice.model.Admin;
@Service
public interface AdminService {

	public List<Admin> findAll();
	public Optional<Admin> getAdminById(String id);
	public Admin addAdmin(Admin admin);
	public Admin updateAdmin(Admin admin); 
	public String deleteById(String adminId);
}

