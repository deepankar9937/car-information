package com.te.lms.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.lms.dto.MentorDetails;

public interface MentorDao extends CrudRepository<MentorDetails, Integer>{

	public MentorDetails findByMentorId(int id);
}
