package model;

import java.util.Map;

public class Top implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap) {
		// TODO 自動生成されたメソッド・スタブ
		ExecuteResult result = new ExecuteResult("/WEB-INF/top.jsp");
		return result;
	}

}
