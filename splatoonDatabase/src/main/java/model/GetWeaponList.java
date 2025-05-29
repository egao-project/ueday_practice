package model;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;

import dao.WeaponListDAO;
import util.JudgeParams;

public class GetWeaponList extends AbstractModel implements Action {
	String[] searchBy;
	String[] searchKeywordArr;
	String[] matchTypeArr;
	String searchKeyword;
	String matchType;
	String mismatchMsg = "";
	List<Weapon> weaponList;

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServerException, IOException, ServletException {
		pretreatment(paramMap, sessionMap);
		weaponList = new ArrayList<>();

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

		postProcessing();
		return result;

	}

	@Override
	public void pretreatment(Map<String, String[]> parameterMap, Map<String, String[]> sessionParams) {
		// TODO 自動生成されたメソッド・スタブ
		// paramMapを優先して取得
		searchBy = JudgeParams.getReqParam("searchBy", sessionParams, parameterMap);
		searchKeywordArr = JudgeParams.getReqParam("searchKeyword", sessionParams, parameterMap);
		matchTypeArr = JudgeParams.getReqParam("matchType", sessionParams, parameterMap);

		searchKeyword = (searchKeywordArr != null && searchKeywordArr.length > 0) ? searchKeywordArr[0] : "";
		matchType = (matchTypeArr != null && matchTypeArr.length > 0) ? matchTypeArr[0] : "partial";

	}

	@Override
	public void postProcessing() {
		// TODO 自動生成されたメソッド・スタブ
		result.addData("weaponList", weaponList);
		result.addData("mismatchMsg", mismatchMsg);
		result.addData("searchBy", searchBy);
		result.addData("searchKeyword", searchKeyword);
		result.addData("matchType", matchType);
	}
}
