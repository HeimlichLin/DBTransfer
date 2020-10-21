package idv.heimlich.dbTransfer.common.db;

public interface IConverter<Po> {

	Po convert(RowMap rapMap);
	
	RowMap toRowMap(Po po);

}
