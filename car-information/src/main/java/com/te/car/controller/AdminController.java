package com.te.car.controller;

import java.util.List;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.car.dto.AdminDetails;
import com.te.car.model.AuthenticateRequest;
import com.te.car.model.AuthenticationResponse;
import com.te.car.service.AdminService;
import com.te.car.util.JwtUtil;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService detailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AdminService service;
	
	@GetMapping("/adminget/{email}")
	public ResponseEntity<?> getData(@PathVariable String email) {
		AdminDetails details = service.getData(email);
		if (details != null) {
			return new ResponseEntity<AdminDetails>(details,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Data not found for E-mail"+email,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/adminadd")
	public ResponseEntity<?> addData(@RequestBody AdminDetails adminDetails) {
		try {
			service.addData(adminDetails);
			return new ResponseEntity<String>("Data added successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Data not Added Succcessully",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/adminall")
	public ResponseEntity<?> allData() {
		List<AdminDetails> allData = service.allData();
		if (allData != null) {
			return new ResponseEntity<List<AdminDetails>>(allData,HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Somthing went worng",HttpStatus.OK);
		}
		
	}
	
	@PutMapping("/adminupdate/{id}")
	public ResponseEntity<?> updateData(@PathVariable int id,@RequestBody AdminDetails adminDetails) {
		try {
			service.updateData(id,adminDetails);
			return new ResponseEntity<String>("data updated successfully",HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("data not updated",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticateRequest authenticateRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(), authenticateRequest.getPassword()));
		} catch (AuthenticationException e) {
			throw new Exception("invalid username and password");
		}
		UserDetails userDetails = detailsService.loadUserByUsername(authenticateRequest.getUserName());
		String token = jwtUtil.generateToken(userDetails);
		return new ResponseEntity<AuthenticationResponse>(new AuthenticationResponse(token),HttpStatus.OK);
		
	}
}
