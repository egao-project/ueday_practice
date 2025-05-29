package model;

import java.util.Map;

import jakarta.servlet.ServletException;

public class NotFoundAction extends AbstractModel implements Action {
	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException {
		throw new ServletException("404 Not Found: アクションが見つかりません");
	}

	@Override
	public void postProcessing() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void pretreatment(Map<String, String[]> parameterMap, Map<String, String[]> sessionParams) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
