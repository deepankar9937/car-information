package com.te.lms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class MentorSkill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;
	
	private String skillName;
	
}