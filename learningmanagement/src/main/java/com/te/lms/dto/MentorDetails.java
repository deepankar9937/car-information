package com.te.lms.dto;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "mentorId",name = "mentor_id")
	private List<MentorSkill> mentorSkills;
}
