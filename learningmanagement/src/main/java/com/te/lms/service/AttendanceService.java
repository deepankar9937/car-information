package com.te.lms.service;

import java.util.List;

import com.te.lms.dto.Attendance;

public interface AttendanceService {

	public List<Attendance> takeAttendance(List<Attendance> attendance);
	
	public Attendance getAttendanceByEmployee(String empId);
}
