package com.te.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.car.dto.CarDetails;
import com.te.car.service.CarService;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired
	private CarService service;

	@PostMapping("/caradd")
	public ResponseEntity<?> addData(@RequestBody CarDetails details) {
		try {
			service.addData(details);
			return new ResponseEntity<String>("Data added Successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Data not added successfully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/carget/{id}")
	public ResponseEntity<?> getData(@PathVariable int id) {
		CarDetails data = service.getData(id);
		if (data != null) {
			return new ResponseEntity<CarDetails>(data,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("data not found",HttpStatus.OK);
		}
	}
	
	@GetMapping("/carall")
	public ResponseEntity<?> getAll() {
		List<CarDetails> all = service.getAll();
		
		if (all != null) {
			return new ResponseEntity<List<CarDetails>>(all,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No car found",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
