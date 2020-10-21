package idv.heimlich.dbTransfer;

import idv.heimlich.dbTransfer.common.log.LogFactory;
import idv.heimlich.dbTransfer.domain.controller.DBTransferController;
import idv.heimlich.dbTransfer.domain.dto.JobDTO;

import org.slf4j.Logger;

public class Test {
	
	private static Logger LOGGER = LogFactory.getInstance();
	
	public static void main(String[] args) {
		JobDTO dto = new JobDTO("DECLAR");
		dto.setSourceSqlWhere("BONDNO", "A0001");
		dto.setTargetTableName("DECLAR");
		dto.setTargetValues("BONDNO", "GGGGG");
		
		Test test = new Test();
		test.excute(dto);
	}
	
	public void excute(JobDTO dto) {
		LOGGER.info("------ STAR ------");
		DBTransferController controller = new DBTransferController();
		controller.excute(dto);
		LOGGER.info("------ FINISH ------");
	}

}
