package model;

import java.util.Map;

import dao.AccountsDAO;
import service.LoginUser;

public class LoginCheck implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap) {
		// TODO 自動生成されたメソッド・スタブ
		String[] userIdValues = paramMap.get("userId");
		String[] passValues = paramMap.get("pass");
		String userId = (userIdValues != null && userIdValues.length > 0) ? userIdValues[0] : null;
		String pass = (passValues != null && passValues.length > 0) ? passValues[0] : null;

		LoginUser loginUser = new LoginUser(userId, pass);
		AccountsDAO bo = new AccountsDAO();
		Account loginAccount = bo.findByLogin(loginUser);

		if (loginAccount != null) {
			ExecuteResult result = new ExecuteResult(true);
			result.addData("userId", loginAccount.getUserId());
			return result;
		} else {
			ExecuteResult result = new ExecuteResult(false);
			result.addData("massage", "ログインに失敗しました。");
			return result;
		}

	}

}
