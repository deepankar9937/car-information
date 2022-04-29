package com.te.lms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmployeeEducationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationInfoId;
	
	private String educationType;
	
	private int yearOfPassing;
	
	private double percentage;
	
	private String universityName;
	
	private String instituteName;
	
	private String specialization;
	
	private String state;
}
