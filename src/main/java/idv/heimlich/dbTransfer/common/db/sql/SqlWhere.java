package idv.heimlich.dbTransfer.common.db.sql;

import idv.heimlich.dbTransfer.common.db.utils.SqlFormatUtil;
import idv.heimlich.dbTransfer.common.exception.ApBusinessException;

import java.util.HashMap;
import java.util.Map;

public class SqlWhere {
	
	private Map<String, String> values;

	public SqlWhere() {
		this.values = new HashMap<String, String>();
	}

	protected SqlWhere(Map<String, String> value) {
		if (values == null) {
			throw new ApBusinessException(
					"The parameter of SqlWhere value cannot be null!");
		} else {
			this.values = value;
		}
	}

	public Map<String, String> toMap() {
		return this.values;
	}

	public String toString() {
		return this.values.toString();
	}

	public void add(String key, String value) {
		if (key != null) {
			this.values.put(key.toUpperCase(), value);
		}
	}

	public Object getObjectValue(String key) {
		Object value = null;
		if (key != null) {
			value = (this.values.get(key) != null ? this.values.get(key) : null);
		}
		return value;
	}

	public String getString(String key) {
		String value = null;
		if (key != null) {
			value = (this.values.get(key) != null ? this.values.get(key)
					.toString() : null);
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
		if (values == null) {
			return "";
		}
		return SqlFormatUtil.whereMapToString(values);
	}

}
