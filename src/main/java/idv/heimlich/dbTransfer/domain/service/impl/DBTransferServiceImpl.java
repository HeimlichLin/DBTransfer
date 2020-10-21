package idv.heimlich.dbTransfer.domain.service.impl;

import java.util.Map;
import java.util.Map.Entry;

import idv.heimlich.dbTransfer.common.db.IDBSession;
import idv.heimlich.dbTransfer.common.db.IDBSessionFactory;
import idv.heimlich.dbTransfer.common.db.RowMap;
import idv.heimlich.dbTransfer.common.db.RowMapList;
import idv.heimlich.dbTransfer.common.db.impl.DBSessionFactoryImpl;
import idv.heimlich.dbTransfer.common.db.sql.SqlCode;
import idv.heimlich.dbTransfer.common.db.sql.SqlObject;
import idv.heimlich.dbTransfer.common.log.LogFactory;
import idv.heimlich.dbTransfer.domain.dto.JobDTO;
import idv.heimlich.dbTransfer.domain.service.DBTransferService;

import org.slf4j.Logger;

public class DBTransferServiceImpl implements DBTransferService {
	
	private static Logger LOGGER = LogFactory.getInstance();
	private IDBSessionFactory sessionFactory = new DBSessionFactoryImpl();
	
	@Override
	public int executeFrontWork(JobDTO dto) {
		int i = 0;
		if (dto.getTargetTableName().isEmpty()) {
			LOGGER.info("不須刪除");
		} else {
			SqlObject sqlObject = new SqlObject(dto.getTargetTableName());
			for (Entry<String, String> entry : dto.getTargetValues().entrySet()) {
				sqlObject.setSqlWhere(entry.getKey(), entry.getValue());
			}
			i = this.getDBSession().executeUpdate(SqlCode.creatDeleteSql(sqlObject));
			LOGGER.info("刪除:" + i);
		}
		return i;
	}
	
	@Override
	public int executeTransfer(JobDTO dto) {
		int i = 0;
		RowMapList rowMapList = this.get(dto);
		if (rowMapList.size() == 0) {
			LOGGER.info("查無資料");
		} else {
			i = this.insert(rowMapList, dto.getTargetTableName(), dto.getTargetValues());
		}
		return i;
	}
	
	/**
	 * 取檔
	 */
	private RowMapList get(JobDTO dto) {
		RowMapList list = this.getDBSession().query(SqlCode.creatSelectSql(dto.getSourceSqlObject()));
		LOGGER.info("取得:" + list.size());
		return list;
	}
	
	/**
	 * 調整
	 */
	private void pro() {
		
	}
	
	/**
	 * 寫入
	 */
	private int insert(RowMapList rowMapList, String targetTableName, Map<String, String> targetValues) {
		int i = 0;
		for (RowMap rowMap : rowMapList.getRowMapList()) {
			for (Entry<String, String> entry : targetValues.entrySet()) {
				rowMap.setValue(entry.getKey(), entry.getValue());
				i += this.getDBSession().insert(targetTableName, rowMap);				
			}
		}
		LOGGER.info("寫入:" + i);
		return i;
	}
	
	private IDBSession getDBSession() {
		return this.sessionFactory.getXdaoSession("");
	}
	

}
