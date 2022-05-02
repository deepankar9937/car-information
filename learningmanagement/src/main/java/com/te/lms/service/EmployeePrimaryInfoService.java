package com.te.lms.service;

import java.util.List;

import com.te.lms.dto.EmployeePrimaryInfo;

public interface EmployeePrimaryInfoService {

	public EmployeePrimaryInfo getDetails(String empId);
	
	public EmployeePrimaryInfo addDetails(EmployeePrimaryInfo employeePrimaryInfo);
	
	public boolean changeStatus(String empId,String employeeStatus);
	
	public boolean employeeApprove(String empId,EmployeePrimaryInfo employeePrimaryInfo);
	
	public boolean employeeReject(String empId,EmployeePrimaryInfo employeePrimaryInfo);
	
	public List<EmployeePrimaryInfo> employeePendingList();
}
