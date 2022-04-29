package com.te.lms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EmployeeTechnicalSkillInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int technicalSkillId;
	
	private String skillType;
	
	private String skillRating;
	
	private double yearOfExperience;
}
