package com.te.lms.service;

import java.util.List;

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
		employeePrimaryInfo.setEmployeeStatus("PENDING");
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

	@Override
	public boolean employeeApprove(String empId,EmployeePrimaryInfo employeePrimaryInfo) {
		EmployeePrimaryInfo employeeDetails = dao.findByEmployeeId(empId);
		if (employeeDetails != null) {
			employeeDetails.setBatchDetails(employeePrimaryInfo.getBatchDetails());
			employeeDetails.setEmployeeStatus("ACTIVE");
			dao.save(employeeDetails);
			return true;
		} 
		return false;
	}

	@Override
	public boolean employeeReject(String empId,EmployeePrimaryInfo employeePrimaryInfo) {
		EmployeePrimaryInfo employeeDetails = dao.findByEmployeeId(empId);
		if (employeeDetails != null) {
			employeeDetails.setReason(employeePrimaryInfo.getReason());
			employeeDetails.setEmployeeStatus("TERMINATED");
			dao.save(employeeDetails);
			return true;
		}
		return false;
	}

	@Override
	public List<EmployeePrimaryInfo> employeePendingList() {
		List<EmployeePrimaryInfo> pendingEmployeeDetails = dao.findByEmployeeStatus("PENDING");
		if (!pendingEmployeeDetails.isEmpty()) {
			return pendingEmployeeDetails;
		}
		return null;
	}

	

	
}
