package com.cropdeal.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropdeal.adminservice.model.Admin;
import com.cropdeal.adminservice.repositpry.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	AdminRepository adminrepository;
	
	@Override
	public List<Admin> findAll() {
		return adminrepository.findAll();
	}

	@Override
	public Optional<Admin> getAdminById(String adminId) {
		return adminrepository.findById(adminId);
	}

	@Override
	public Admin addAdmin(Admin admin) {
		return adminrepository.insert(admin);
	}


	@Override
	public Admin updateAdmin(Admin admin) {
		return adminrepository.save(admin);

	}

	@Override
	public String deleteById(String adminId) {
		adminrepository.deleteById(adminId);
		return null;
	}

}
