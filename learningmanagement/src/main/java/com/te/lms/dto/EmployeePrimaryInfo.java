	package com.te.lms.dto;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class EmployeePrimaryInfo {

	@Id
	private String employeeId;
	
	private String employeeName;
	
	private Date dateOfJoining;
	
	private Date DateOfBirth;
	
	private String email;
	
	private String password;
	
	private String role;
	
	private String bloodGroup;
	
	private String designation;
	
	private String gender;
	
	private String nationality;
	
	private String employeeStatus;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "secondary_info",referencedColumnName = "secondaryInfoId")
	private EmployeeSecondaryInfo employeeSecondaryInfo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
	private List<EmployeeEducationInfo> educationInfo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
	private List<EmployeeAddressInfo> addressInfo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bank_details",referencedColumnName = "bankDetailsId")
	private EmployeeBankDetails bankDetails;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
	private List<EmployeeTechnicalSkillInfo> technicalSkillInfos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
	private List<EmployeeExperienceInfo> employeeExperienceInfos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id",referencedColumnName = "employeeId")
	private List<EmployeeContactInfo> contactInfos; 
	
	
}
