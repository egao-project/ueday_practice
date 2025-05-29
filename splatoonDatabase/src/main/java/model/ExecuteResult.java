package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExecuteResult {
	private boolean success;
	private Map<String, Object> data;
	private List<Map<String, Object>> sessionData;

	public ExecuteResult() {
		this.data = new HashMap<String, Object>();
		this.sessionData = new ArrayList<Map<String, Object>>();
	}

	public ExecuteResult(boolean success) {
		this.success = success;
		this.data = new HashMap<String, Object>();
		this.sessionData = new ArrayList<Map<String, Object>>();
	}

	public ExecuteResult(boolean success, Map<String, Object> data) {
		this.success = success;
		this.data = data;
		this.sessionData = new ArrayList<Map<String, Object>>();
	}

	public ExecuteResult(boolean success, Map<String, Object> data, List<Map<String, Object>> sessionData) {
		this.success = success;
		this.data = data;
		this.sessionData = sessionData;
	}

	public Map<String, Object> getData() {
		return data;

	}

	public List<Map<String, Object>> getSessionData() {
		return sessionData;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public boolean isSuccess() {
		return success;
	}

	public void addData(String key, Object value) {
		data.put(key, value);

	}

	public void addSessionData(Map<String, Object> sessionAddData) {
		sessionData.add(sessionAddData);
	}
}
