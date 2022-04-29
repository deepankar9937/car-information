package com.te.lms.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class MentorDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mentorId;
	
	private String mentorName;
	
	private String employeeId;
	
	private	String email;
	
	
	
}
