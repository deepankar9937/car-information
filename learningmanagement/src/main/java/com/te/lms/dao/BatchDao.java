package com.te.lms.dao;

import org.springframework.data.repository.CrudRepository;

import com.te.lms.dto.BatchDetails;

public interface BatchDao extends CrudRepository<BatchDetails, Integer>{

	public BatchDetails findByBatchId(int id);
}
