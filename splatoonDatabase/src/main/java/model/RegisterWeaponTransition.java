package model;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;

public class RegisterWeaponTransition extends AbstractModel implements Action {
	String[] weaponId = null;

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		pretreatment(paramMap, sessionMap);

		if (weaponId == null) {
			return result;

		} else {
			//チェックボックスをチェックしていたらフォワード
			result.setSuccess(false);
			postProcessing();
			return result;

		}

	}

	@Override
	public void postProcessing() {
		// TODO 自動生成されたメソッド・スタブ
		result.addData("message", "チェックを外してから登録ボタンを押してください");
	}

	@Override
	public void pretreatment(Map<String, String[]> parameterMap, Map<String, String[]> sessionParams) {
		// TODO 自動生成されたメソッド・スタブ
		weaponId = parameterMap.get("weaponId");
	}

}
