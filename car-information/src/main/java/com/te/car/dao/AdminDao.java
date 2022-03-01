package com.te.car.dao;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.te.car.dto.AdminDetails;

@EnableJpaRepositories
public interface AdminDao extends CrudRepository<AdminDetails, Integer>{
	public AdminDetails findByAdminEmail(String email);
	
	public AdminDetails findByAdminId(int id);
	
	
		
}
