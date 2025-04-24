package model;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;

public class Logout implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		ExecuteResult result = new ExecuteResult(true);
		return result;

	}

}
