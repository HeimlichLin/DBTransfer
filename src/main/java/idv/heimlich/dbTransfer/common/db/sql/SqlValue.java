package idv.heimlich.dbTransfer.common.db.sql;

import idv.heimlich.dbTransfer.common.db.utils.SqlFormatUtil;
import idv.heimlich.dbTransfer.common.exception.ApBusinessException;

import java.util.HashMap;
import java.util.Map;

public class SqlValue {
	
private Map<String, Object> values;
	
	protected SqlValue() {
		this.values = new HashMap<String, Object>();
	}
	
	protected SqlValue(Map<String, Object> value) {
		if (values == null) {
			throw new ApBusinessException(
					"The parameter of SqlValue value cannot be null!");
		} else {
			this.values = value;
		}
	}
	
	protected Map<String, Object> toMap() {
		return this.values;
	}
		
	public String toString() {
		return this.values.toString();
	}
	
	protected void add(String key, Object value) {
		if (key != null) {
			this.values.put(key.toUpperCase(), value);
		}
	}
	
	protected Object getObjectValue(String key) {
		Object value =null;
		if (key != null) {
			value = (this.values.get(key) != null ? this.values.get(key) : null);
		}		
		return value;
	}
	
	protected String getString(String key) {
		String value =null;
		if (key != null) {
			value = (this.values.get(key) != null ? this.values.get(key).toString() : null);
		}		
		return value;
	}
	
	public Object[] getKeys() {
		return this.values.keySet().toArray();
	}
	
	public Object[] getValues() {
		return this.values.values().toArray();
	}
	
	public void clear() {
		this.values.clear();
	}

	public Object remove(Object key) {
		return this.values.remove(key);
	}
	
	public int size() {
		return this.values.size();
	}
	
	public String get() {
		return SqlFormatUtil.valueMapToString(this.values);
	}

}
