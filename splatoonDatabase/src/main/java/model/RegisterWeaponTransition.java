package model;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;

public class RegisterWeaponTransition implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		String[] weaponId = paramMap.get("weaponId");

		if (weaponId == null) {
			ExecuteResult result = new ExecuteResult("/WEB-INF/jsp/registerWeapon.jsp");
			return result;

		} else {
			//チェックボックスをチェックしていたらフォワード
			ExecuteResult result = new ExecuteResult("/WEB-INF/jsp/weaponList.jsp");
			result.addData("message", "チェックを外してから登録ボタンを押してください");
			return result;

		}

	}

}
