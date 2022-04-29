package com.te.lms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmployeeSecondaryInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int secondaryInfoId;
	
	private String panNo;
	
	private long aadharNo;
	
	private String fatherName;
	
	private String motherName;
	
	private String spouseName;
	
	private String passportNo;
	
	private String maritalStatus;
}
