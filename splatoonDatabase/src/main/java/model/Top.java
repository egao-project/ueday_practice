package model;

import java.util.Map;

public class Top extends AbstractModel implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap) {
		// TODO 自動生成されたメソッド・スタブ
		postProcessing();
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
