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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.MentorDetails;
import com.te.lms.service.MentorService;

@RestController
@RequestMapping("/mentor")
public class MentorController {

	@Autowired
	private MentorService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> addDetail(@RequestBody MentorDetails mentorDetails) {
		MentorDetails mentor = service.addData(mentorDetails);
		if (mentor != null) {
			return new ResponseEntity<String>("Data added successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not added successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getDetail(@PathVariable int id) {
		MentorDetails data = service.getData(id);
		if (data != null) {
			return new ResponseEntity<MentorDetails>(data,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data Not Found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteData(@PathVariable int id) {
		boolean isDeleted = service.deleteData(id);
		if (isDeleted == true) {
			return new ResponseEntity<String>("Data deleted Successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data is not successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> upadateData(@PathVariable int id, @RequestBody MentorDetails details) {
		boolean isUpdated = service.updateData(id, details);
		if (isUpdated == true) {
			return new ResponseEntity<String>("Data Updated Successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data is not updated successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
