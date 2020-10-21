package idv.heimlich.dbTransfer.domain.controller;

import idv.heimlich.dbTransfer.domain.dto.JobDTO;
import idv.heimlich.dbTransfer.domain.service.DBTransferService;
import idv.heimlich.dbTransfer.domain.service.impl.DBTransferServiceImpl;

public class DBTransferController {
	
	public void excute(JobDTO dto) {
		DBTransferService service = new DBTransferServiceImpl();
		service.executeFrontWork(dto);
		service.executeTransfer(dto);
	}
	

}
