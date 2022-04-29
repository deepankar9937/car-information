package com.te.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.EmployeePrimaryInfo;
import com.te.lms.service.EmployeePrimaryInfoService;

@RestController
public class EmployeePrimaryController {

	@Autowired
	private EmployeePrimaryInfoService service;
	
	@GetMapping("/get/{empId}")
	public ResponseEntity<?> getData(@PathVariable String empId) {
		EmployeePrimaryInfo details = service.getDetails(empId);
		if (details != null) {
			return new ResponseEntity<EmployeePrimaryInfo>(details,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addData(@RequestBody EmployeePrimaryInfo employeePrimaryInfo) {
		EmployeePrimaryInfo addDetails = service.addDetails(employeePrimaryInfo);
		if (addDetails != null) {
			return new ResponseEntity<EmployeePrimaryInfo>(addDetails,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/changeStatus/{empId}")
	public ResponseEntity<?> changeStatus(@PathVariable String empId,@RequestBody String employeeStatus) {
		boolean status = service.changeStatus(empId, employeeStatus);
		if (status == true) {
			return new ResponseEntity<String>("Status changed",HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Status Not changed",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
