package model;

import java.util.ArrayList;
import java.util.List;

import dao.AccountsDAO;
import dao.WeaponListDAO;
import service.LoginUser;

public class MainModel {
	public boolean login(String userId, String password) {
		LoginUser loginUser = new LoginUser(userId, password);
		AccountsDAO bo = new AccountsDAO();
		Account loginAccount = bo.findByLogin(loginUser);

		boolean result = false;

		if (loginAccount != null)
			result = true;

		return result;

	}

	public List<Weapon> getWeaponList(String[] searchBy, String searchKeyword, String matchType) {

		// 初回の画面遷移時に初期値をセット
		if (searchKeyword == null)
			searchKeyword = "";
		if (matchType == null)
			matchType = "partial";

		List<Weapon> weaponList = new ArrayList<Weapon>();
		WeaponListDAO dao = new WeaponListDAO();

		if (searchKeyword == "") {
			// 検索キーワードが空白の場合、ブキ一覧を全件取得
			weaponList = dao.allWeaponData();

			if (weaponList == null) {
				return null;
			}

		} else {
			// 絞り込み検索実行
			if (matchType.equals("partial")) { // 検索パターンが部分一致の場合

				weaponList = dao.searchWeaponDataPartial(searchBy, searchKeyword);

			} else if (matchType.equals("exact")) { // 検索パターンが完全一致の場合

				weaponList = dao.searchWeaponDataExact(searchBy, searchKeyword);

			}

		}
		return weaponList;
	}
}
