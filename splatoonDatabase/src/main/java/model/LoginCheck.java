package model;

import java.util.Map;

import dao.AccountsDAO;
import service.LoginUser;

public class LoginCheck extends AbstractModel implements Action {
	String[] userIdValues;
	String[] passValues;
	String userId;
	String pass;
	Account loginAccount = new Account();

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap) {
		// TODO 自動生成されたメソッド・スタブ
		pretreatment(paramMap, sessionMap);

		LoginUser loginUser = new LoginUser(userId, pass);
		AccountsDAO bo = new AccountsDAO();
		loginAccount = bo.findByLogin(loginUser);

		if (loginAccount != null) {
			postProcessing();
			return result;
		} else {
			result.setSuccess(false);
			postProcessing();
			return result;
		}

	}

	@Override
	public void pretreatment(Map<String, String[]> parameterMap, Map<String, String[]> sessionParams) {
		// TODO 自動生成されたメソッド・スタブ
		userIdValues = parameterMap.get("userId");
		passValues = parameterMap.get("pass");
		userId = (userIdValues != null && userIdValues.length > 0) ? userIdValues[0] : null;
		pass = (passValues != null && passValues.length > 0) ? passValues[0] : null;
	}

	@Override
	public void postProcessing() {
		// TODO 自動生成されたメソッド・スタブ
		if (result.isSuccess()) {
			result.addData("userId", loginAccount.getUserId());
		} else {
			result.addData("massage", "ログインに失敗しました。");
		}

	}

}
