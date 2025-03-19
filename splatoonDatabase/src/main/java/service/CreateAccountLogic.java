package service;

import dao.AccountsDAO;
import model.Account;

public class CreateAccountLogic {
	public boolean execute(Account account) {
		AccountsDAO dao = new AccountsDAO();
		boolean result = dao.createAccount(account);
		return result;
	}
}
