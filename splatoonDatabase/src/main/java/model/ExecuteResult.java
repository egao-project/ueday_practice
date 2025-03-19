package model;

import java.util.HashMap;
import java.util.Map;

public class ExecuteResult {
	private String nextPage;
	private Map<String, Object> data;

	public ExecuteResult(String nextPage) {
		this.nextPage = nextPage;
		this.data = new HashMap<String, Object>();
	}

	public String getNextPage() {
		return nextPage;

	}

	public Map<String, Object> getData() {
		return data;

	}

	public void addData(String key, Object value) {
		data.put(key, value);

	}
}
