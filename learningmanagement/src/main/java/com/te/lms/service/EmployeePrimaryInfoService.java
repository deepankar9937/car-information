package com.te.lms.service;

import com.te.lms.dto.EmployeePrimaryInfo;

public interface EmployeePrimaryInfoService {

	public EmployeePrimaryInfo getDetails(String empId);
	
	public EmployeePrimaryInfo addDetails(EmployeePrimaryInfo employeePrimaryInfo);
	
	public boolean changeStatus(String empId,String employeeStatus);
}
