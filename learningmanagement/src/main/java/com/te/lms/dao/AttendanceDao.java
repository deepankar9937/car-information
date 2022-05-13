package com.te.lms.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.lms.dto.Attendance;

public interface AttendanceDao extends CrudRepository<Attendance, Integer>{

	public Attendance findByAttendanceId(int id);
	
	public Attendance findByEmployeePrimaryInfo(String empId);
}
