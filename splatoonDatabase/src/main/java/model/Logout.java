package model;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;

public class Logout extends AbstractModel implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		return result;

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
