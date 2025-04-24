package model;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;

import dao.WeaponListDAO;
import util.JudgeParams;

public class GetWeaponList implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServerException, IOException, ServletException {
		// paramMapを優先して取得
		String[] searchBy = JudgeParams.getReqParam("searchBy", sessionMap, paramMap);
		String[] searchKeywordArr = JudgeParams.getReqParam("searchKeyword", sessionMap, paramMap);
		String[] matchTypeArr = JudgeParams.getReqParam("matchType", sessionMap, paramMap);

		String searchKeyword = (searchKeywordArr != null && searchKeywordArr.length > 0) ? searchKeywordArr[0] : "";
		String matchType = (matchTypeArr != null && matchTypeArr.length > 0) ? matchTypeArr[0] : "partial";

		List<Weapon> weaponList = new ArrayList<>();
		String mismatchMsg = "";
		WeaponListDAO dao = new WeaponListDAO();

		if (searchKeyword.isEmpty()) {
			weaponList = dao.allWeaponData();
			if (weaponList == null || weaponList.isEmpty()) {
				mismatchMsg = "表示するブキがありません";
			}
		} else if (matchType.equals("partial")) {
			weaponList = dao.searchWeaponDataPartial(searchBy, searchKeyword);
			if (weaponList == null || weaponList.isEmpty()) {
				mismatchMsg = "条件に一致するブキがありません";
			}
		} else {
			weaponList = dao.searchWeaponDataExact(searchBy, searchKeyword);
			if (weaponList == null || weaponList.isEmpty()) {
				mismatchMsg = "条件に一致するブキがありません";
			}
		}

		ExecuteResult result = new ExecuteResult(true);
		result.addData("weaponList", weaponList);
		result.addData("mismatchMsg", mismatchMsg);
		result.addData("searchBy", searchBy);
		result.addData("searchKeyword", searchKeyword);
		result.addData("matchType", matchType);

		return result;
	}
}
