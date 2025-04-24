package util;

import model.Action;

public class ActionData {
	private final Action action;
	private final String successJspPath;
	private final String failureJspPath;

	public ActionData(Action action, String successJspPath, String failureJspPath) {
		this.action = action;
		this.successJspPath = successJspPath;
		this.failureJspPath = failureJspPath;
	}

	public Action getAction() {
		return action;
	}

	public String getSuccessJspPath() {
		return successJspPath;
	}

	public String getFailureJspPath() {
		return failureJspPath;
	}
}
