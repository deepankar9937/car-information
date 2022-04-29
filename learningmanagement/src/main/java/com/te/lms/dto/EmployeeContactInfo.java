package com.te.lms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class EmployeeContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int contactInfoId;
	
	private String contactType;
	
	private long contactNo;
}
