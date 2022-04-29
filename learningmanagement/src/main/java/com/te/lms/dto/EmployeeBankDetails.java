package com.te.lms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmployeeBankDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankDetailsId;
	
	private long accountNo;
	
	private String bankName;
	
	private String bankType;
	
	private String ifscCode;
	
	private String branch;
	
	private String State;
	
}
