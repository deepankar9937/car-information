package com.te.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dao.EmployeePrimaryInfoDao;
import com.te.lms.dto.EmployeePrimaryInfo;

@Service
public class EmployeePrimaryInfoServiceImp implements EmployeePrimaryInfoService{

	@Autowired
	private EmployeePrimaryInfoDao dao;
	
	@Override
	public EmployeePrimaryInfo getDetails(String empId) {
		return dao.findByEmployeeId(empId);
	}

	@Override
	public EmployeePrimaryInfo addDetails(EmployeePrimaryInfo employeePrimaryInfo) {
		return dao.save(employeePrimaryInfo);
	}

	@Override
	public boolean changeStatus(String empId,String employeeStatus) {
		EmployeePrimaryInfo employee = dao.findByEmployeeId(empId);
		if (employee != null) {
			employee.setEmployeeStatus(employeeStatus);
			dao.save(employee);
			return true;
		} else {
			return false;
		}
	}

	

	
}
