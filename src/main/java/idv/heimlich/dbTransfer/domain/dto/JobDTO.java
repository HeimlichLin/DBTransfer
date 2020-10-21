package idv.heimlich.dbTransfer.domain.dto;

import idv.heimlich.dbTransfer.common.db.sql.SqlObject;

import java.util.HashMap;
import java.util.Map;

public class JobDTO {
	
	private String sourceTableName; // 來源對象表格
//	private SqlWhere sourceSqlWhere; // 來源條件
	private SqlObject sourceSqlObject;
	
	private String targetTableName; // 目標對象表格
	private Map<String, String> targetValues = new HashMap<String, String>(); // 目標變更值
	
	public JobDTO(String sourceTableName) {
		this.sourceTableName = sourceTableName;
		this.sourceSqlObject = new SqlObject(sourceTableName);
	}

	public String getSourceTableName() {
		return sourceTableName;
	}

	public void setSourceSqlWhere(String key, String value) {
		this.sourceSqlObject.setSqlWhere(key, value);
	}

	public String getTargetTableName() {
		return targetTableName;
	}

	public void setTargetTableName(String targetTableName) {
		this.targetTableName = targetTableName;
	}

	public Map<String, String> getTargetValues() {
		return targetValues;
	}

	public void setTargetValues(String key, String value) {
		this.targetValues.put(key.toUpperCase(), value);
	}

	public SqlObject getSourceSqlObject() {
		return sourceSqlObject;
	}

}
