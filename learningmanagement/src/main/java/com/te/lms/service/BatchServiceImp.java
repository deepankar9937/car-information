package com.te.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.dao.BatchDao;
import com.te.lms.dto.BatchDetails;

@Service
public class BatchServiceImp implements BatchService{

	@Autowired
	private BatchDao dao;
	
	
	@Override
	public BatchDetails addData(BatchDetails batchDetails) {
		return dao.save(batchDetails);
	}

	@Override
	public BatchDetails getData(int id) {
		return dao.findByBatchId(id);
	}

	
}
