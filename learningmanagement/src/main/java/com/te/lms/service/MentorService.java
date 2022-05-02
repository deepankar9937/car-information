package com.te.lms.service;

import com.te.lms.dto.MentorDetails;

public interface MentorService {

	public MentorDetails addData(MentorDetails mentorDetails);
	
	public MentorDetails getData(int id);
	
	public boolean deleteData(int id);
	
	public boolean updateData(int id, MentorDetails details);
}