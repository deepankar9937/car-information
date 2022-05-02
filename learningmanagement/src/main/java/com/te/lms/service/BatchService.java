package com.te.lms.service;

import com.te.lms.dto.BatchDetails;

public interface BatchService {

	public BatchDetails addData(BatchDetails batchDetails);
	
	public BatchDetails getData(int id);
}
