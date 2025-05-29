package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;

import dao.WeaponListDAO;

public class EditWeaponTransition extends AbstractModel implements Action {
	String[] selectedWeaponIds = null;
	String[] weaponIds = null;
	Weapon weapon = new Weapon();
	List<Weapon> weaponList = new ArrayList<Weapon>();
	int weaponId;
	String message = "";

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		pretreatment(paramMap, sessionMap);
		WeaponListDAO dao = new WeaponListDAO();
		//選択されたブキが1つの場合
		if (weaponIds != null && weaponIds.length == 1) {

			//ブキIDで武器情報を取得
			weapon = dao.editWeaponData(weaponIds[0]);
			weaponId = Integer.parseInt(weaponIds[0]);
			//	初期入力のためのブキ情報をセット
			postProcessing();
			return result;

		} else {
			result.setSuccess(false);
			// ブキ一覧を取得して再セット
			weaponList = dao.allWeaponData();
			message = (weaponIds == null || weaponIds.length == 0)
					? "ブキが選択されていません"
					: "編集するブキを1つ選択してください";
			postProcessing();
			return result;

		}

	}

	@Override
	public void postProcessing() {
		// TODO 自動生成されたメソッド・スタブ
		if (result.isSuccess()) {
			result.addData("weapon", weapon);
			result.addData("weaponId", weaponId);
		} else {
			result.addData("weaponList", weaponList);
			result.addData("message", message);
		}
	}

	@Override
	public void pretreatment(Map<String, String[]> parameterMap, Map<String, String[]> sessionParams) {
		// TODO 自動生成されたメソッド・スタブ
		selectedWeaponIds = parameterMap.get("weaponId");
		if (selectedWeaponIds != null) {
			weaponIds = new String[selectedWeaponIds.length];
			for (int i = 0; i < selectedWeaponIds.length; i++) {
				weaponIds[i] = selectedWeaponIds[i];
			}
		}
	}

}
