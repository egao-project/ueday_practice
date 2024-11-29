package model;

import dao.AccountsDAO;

public class UpdateAccountLogic {
	public boolean execute(String userId, String newName) {
		System.out.println(newName + "," + userId);

		AccountsDAO dao = new AccountsDAO();
		boolean result = dao.updateAccount(userId, newName);
		return result;
	}

}
