package model;

import java.util.List;

import dao.AccountsDAO;

public class GetAccoutListLogic {
	public List<Account> getAllAccountListLogic() {
		AccountsDAO dao = new AccountsDAO();
		List<Account> accountList = dao.allAccountData();

		if (accountList == null) {
			return null;
		}
		return accountList;
	}

}
