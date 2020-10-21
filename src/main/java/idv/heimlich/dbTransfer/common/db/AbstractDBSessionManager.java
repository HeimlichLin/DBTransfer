package idv.heimlich.dbTransfer.common.db;

import idv.heimlich.dbTransfer.common.db.impl.DBSessionImpl;

public abstract class AbstractDBSessionManager {
	
	private static IDBSession dbSession;
	
	public IDBSession getDBSession() {
		if (dbSession == null) {
			dbSession = new DBSessionImpl();
		}
		return dbSession;
	}
	
	protected abstract String getConnId();

}
