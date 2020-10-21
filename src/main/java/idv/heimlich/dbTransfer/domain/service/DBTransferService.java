package idv.heimlich.dbTransfer.domain.service;

import idv.heimlich.dbTransfer.domain.dto.JobDTO;

public interface DBTransferService {

	int executeFrontWork(JobDTO dto);

	int executeTransfer(JobDTO dto);

}
