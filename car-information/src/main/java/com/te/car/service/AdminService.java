package com.te.car.service;

import java.util.List;

import com.te.car.dto.AdminDetails;

public interface AdminService {
	
	public AdminDetails getData(String email);
	
	public AdminDetails addData(AdminDetails details);
	
	public List<AdminDetails> allData();

	public boolean updateData(int id, AdminDetails adminDetails);
	
	public AdminDetails login(String adminEmail,String adminPassword); 

}
