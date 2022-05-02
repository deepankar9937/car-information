package com.te.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dao.MentorDao;
import com.te.lms.dto.MentorDetails;

@Service
public class MentorServiceImp implements MentorService{

	
	@Autowired
	private MentorDao dao;
	
	@Override
	public MentorDetails addData(MentorDetails mentorDetails) {
		return dao.save(mentorDetails);
	}

	@Override
	public MentorDetails getData(int id) {
		return dao.findByMentorId(id);
	}

	@Override
	public boolean deleteData(int id) {
		MentorDetails mentorDetails = dao.findByMentorId(id);
		if (mentorDetails != null) {
			dao.delete(mentorDetails);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean updateData(int id, MentorDetails details) {
		MentorDetails mentorDetails = dao.findByMentorId(id);
		if (mentorDetails != null) {
			mentorDetails.setMentorName(details.getMentorName());
			mentorDetails.setEmail(details.getEmail());
			mentorDetails.setEmployeeId(details.getEmployeeId());
			mentorDetails.setMentorSkills(details.getMentorSkills());
			MentorDetails save = dao.save(mentorDetails);
			if (save != null) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

}
