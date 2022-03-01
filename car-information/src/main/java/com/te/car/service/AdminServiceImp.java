package com.te.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.car.dao.AdminDao;
import com.te.car.dto.AdminDetails;
import com.te.car.dto.MyAdminDetails;

@Service
public class AdminServiceImp implements AdminService,UserDetailsService{
	
	@Autowired
	private AdminDao dao;
	
	

	@Override
	public AdminDetails getData(String email) {
		return dao.findByAdminEmail(email);
	}



	@Override
	public AdminDetails addData(AdminDetails details) {
		return dao.save(details);
	}



	@Override
	public List<AdminDetails> allData() {
		return (List<AdminDetails>) dao.findAll();
	}



	@Override
	public boolean updateData(int id, AdminDetails adminDetails) {
		AdminDetails details = dao.findByAdminId(id);
		
		details.setAdminEmail(adminDetails.getAdminEmail());
		details.setAdminName(adminDetails.getAdminName());
		details.setAdminPassword(adminDetails.getAdminPassword());
		details.setAdminRole(adminDetails.getAdminRole());
		if (dao.save(details)!=null) {
			return true;
		} else {
			return false; 
		}
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AdminDetails details = dao.findByAdminEmail(username);
		if (details != null) {
			return new MyAdminDetails(details);
		} else {
			throw new UsernameNotFoundException("User Not Found");
		}
	}



	@Override
	public AdminDetails login(String adminEmail, String adminPassword) {
		AdminDetails adminDetails = dao.findByAdminEmail(adminEmail);
		if (adminDetails != null) {
			if (adminDetails.getAdminPassword().equals(adminPassword)) {
				return adminDetails;
			}
		} 
		return null;
	}

	

}
