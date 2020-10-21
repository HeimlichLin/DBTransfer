package idv.heimlich.dbTransfer.common.db;

public interface IDBSessionFactory {

	IDBSession getXdaoSession(String conn);

}
