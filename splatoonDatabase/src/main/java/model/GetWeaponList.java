package model;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;

import dao.WeaponListDAO;

public class GetWeaponList implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap)
			throws ServerException, IOException, ServletException {
		// TODO 自動生成されたメソッド・スタブ
		// 絞り込み検索実行時に送られてくる値を取得
		String[] searchByValue = paramMap.get("searchBy");
		String[] searchKeywordValue = paramMap.get("searchKeyword");
		String[] matchTypeValue = paramMap.get("matchType");
		String[] searchBy = null;

		if (searchByValue != null) {
			searchBy = new String[searchByValue.length];
			for (int i = 0; i < searchByValue.length; i++) {
				searchBy[i] = searchByValue[i];
			}
		}

		String searchKeyword = (searchKeywordValue != null && searchKeywordValue.length > 0) ? searchKeywordValue[0]
				: "";
		String matchType = (matchTypeValue != null && matchTypeValue.length > 0) ? matchTypeValue[0] : "partial";
		String mismatchMsg = "";

		List<Weapon> weaponList = new ArrayList<Weapon>();
		WeaponListDAO dao = new WeaponListDAO();

		if (searchKeyword == "") {
			// 検索キーワードが空白の場合、ブキ一覧を全件取得
			weaponList = dao.allWeaponData();

			if (weaponList.size() == 0 || weaponList == null)
				mismatchMsg = "表示するブキがありません";

		} else if (matchType.equals("partial")) {
			// 絞り込み検索実行
			weaponList = dao.searchWeaponDataPartial(searchBy, searchKeyword);
			if (weaponList.size() == 0 || weaponList == null)
				mismatchMsg = "条件に一致するブキがありません";

		} else {
			weaponList = dao.searchWeaponDataExact(searchBy, searchKeyword);
			if (weaponList.size() == 0 || weaponList == null)
				mismatchMsg = "条件に一致するブキがありません";
		}

		ExecuteResult result = new ExecuteResult("/WEB-INF/jsp/weaponList.jsp");
		result.addData("mismatchMsg", mismatchMsg);
		result.addData("weaponList", weaponList);
		result.addData("searchBy", searchBy);
		result.addData("searchKeyword", searchKeyword);
		result.addData("matchType", matchType);
		return result;

	}
}
