package com.te.lms.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int attendanceId;
	
	private LocalDate attendanceDate;
	
	private boolean morningAttendance;
	
	private boolean noonAttendance;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "employeeId")
	private EmployeePrimaryInfo employeePrimaryInfo;
}