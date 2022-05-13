package com.te.lms.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class BatchDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int batchId;
	
	private String batchName;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "mentorId",name = "Mentor")
	private MentorDetails details;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "batchId",name = "batch")
	private List<Technology> technology;
	
	private Date startDate;
	
	private Date endDate;
	
}