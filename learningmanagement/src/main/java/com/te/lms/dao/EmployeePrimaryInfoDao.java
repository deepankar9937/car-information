package com.te.lms.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.lms.dto.EmployeePrimaryInfo;

public interface EmployeePrimaryInfoDao extends CrudRepository<EmployeePrimaryInfo, Integer>{

	public EmployeePrimaryInfo findByEmployeeId(String empId);
}
