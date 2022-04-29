package com.te.lms.dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EmployeeExperienceInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int experienceInfoId;
	
	private String companyName;
	
	private int noOfYearOfExperience;
	
	private Date dateOfJoining;
	
	private Date dateOfRelieving;
	
	private String designation;
	
	private String location;
}
