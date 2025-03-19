package service;

import dao.AccountsDAO;

public class DeleteAccountLogic {
	public boolean execute(String[] userIds) {
		AccountsDAO dao = new AccountsDAO();
		boolean result = dao.deleteAccount(userIds);
		return result;
	}

}
