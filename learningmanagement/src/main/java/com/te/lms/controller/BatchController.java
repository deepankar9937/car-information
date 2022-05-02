package com.te.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.BatchDetails;
import com.te.lms.service.BatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {

	@Autowired
	private BatchService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addData(@RequestBody BatchDetails batchDetails) {
		try {
			service.addData(batchDetails);
			return new ResponseEntity<String>("Data added Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Data Not Added successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getDate(@PathVariable int id) {
		BatchDetails details = service.getData(id);
		if (details != null) {
			return new ResponseEntity<BatchDetails>(details,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Data Found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
