package model;

import dao.AccountsDAO;

public class LoginLogic {
	public boolean execute(LoginUser loginUser) {
		AccountsDAO dao = new AccountsDAO();
		Account account = dao.findByLogin(loginUser);
		return account != null;
	}

}
