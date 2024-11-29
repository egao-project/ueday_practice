package model;

import dao.AccountsDAO;

public class CreateAccountLogic {
	public boolean execute(Account account) {
		AccountsDAO dao = new AccountsDAO();
		boolean result = dao.createAccount(account);
		return result;
	}
}
