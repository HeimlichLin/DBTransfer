package idv.heimlich.dbTransfer.domain.dao;

import idv.heimlich.dbTransfer.common.db.IConverter;
import idv.heimlich.dbTransfer.common.db.RowMap;
import idv.heimlich.dbTransfer.common.db.sql.SqlWhere;

public abstract class GeneralDAO<PO> {
	
	final String tableName;

	public GeneralDAO(String tableName) {
		this.tableName = tableName;
	}
	
	public abstract IConverter<PO> getConverter();
	
	public abstract SqlWhere getPkSqlWhere(PO arg0);
	
	public final RowMap getRowMap(PO po) {
		return this.getConverter().toRowMap(po);		
	}
	
	public String getTableName() {
		return this.tableName;
	}

}
