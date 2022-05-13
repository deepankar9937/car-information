package com.te.lms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.Attendance;
import com.te.lms.service.AttendanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendance")
public class AttendanceController {

	private final AttendanceService service;
	
	@PostMapping("/takeAttendance")
	public ResponseEntity<?> takeAttendance(@RequestBody List<Attendance> attendance) {
		List<Attendance> takeAttendance = service.takeAttendance(attendance);
		if (takeAttendance != null) {
			return new ResponseEntity<String>("Attendance taken Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Attendance not taken Successfully",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
