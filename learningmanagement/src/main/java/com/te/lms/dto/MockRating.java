package com.te.lms.dto;

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
public class MockRating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int mockRatingId;
	
	private String mockType;
	
	private String mockTakenBy;
	
	private String technology;
	
	private int practicalKnowledge;
	
	private int theoreticalKnowledge;
	
	private String overallFeedback;
	
	private String detailedFeedback;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "mockId")
	private MockDetails mockDetails;
}
