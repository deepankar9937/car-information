package com.te.lms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.te.lms.dao.AttendanceDao;
import com.te.lms.dto.Attendance;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AttendanceServiceImp implements AttendanceService{
	
	
	private final AttendanceDao dao;

	@Override
	public List<Attendance> takeAttendance(List<Attendance> attendance)  {
		for (Attendance attendance2 : attendance) {
			log.info("list Attendance"+attendance.toString());
			log.info("iterate attendance"+attendance2.toString());
			attendance2.setAttendanceDate(LocalDate.now());
			attendance.add(attendance2);
			
			log.info("After add"+attendance.toString());
			
			
		}
		return (List<Attendance>) dao.saveAll(attendance);
	}

	@Override
	public Attendance getAttendanceByEmployee(String empId) {
		return dao.findByEmployeePrimaryInfo(empId);
	}

}
