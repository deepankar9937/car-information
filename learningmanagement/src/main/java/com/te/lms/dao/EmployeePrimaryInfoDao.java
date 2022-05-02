package com.te.lms.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.te.lms.dto.EmployeePrimaryInfo;

public interface EmployeePrimaryInfoDao extends CrudRepository<EmployeePrimaryInfo, Integer>{

	public EmployeePrimaryInfo findByEmployeeId(String empId);
	
	public List<EmployeePrimaryInfo> findByEmployeeStatus(String employeeStatus);
}
