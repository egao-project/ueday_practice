package model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;

import dao.WeaponListDAO;

public class EditWeaponTransition implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		String[] selectedWeaponIds = paramMap.get("weaponId");
		String[] weaponIds = null;
		if (selectedWeaponIds != null) {
			weaponIds = new String[selectedWeaponIds.length];
			for (int i = 0; i < selectedWeaponIds.length; i++) {
				weaponIds[i] = selectedWeaponIds[i];
			}
		}
		WeaponListDAO dao = new WeaponListDAO();
		//選択されたブキが1つの場合
		if (weaponIds != null && weaponIds.length == 1) {

			//ブキIDで武器情報を取得
			Weapon weapon = dao.editWeaponData(weaponIds[0]);
			int weaponId = Integer.parseInt(weaponIds[0]);

			ExecuteResult result = new ExecuteResult(true);
			//	初期入力のためのブキ情報をセット
			result.addData("weapon", weapon);
			result.addData("weaponId", weaponId);
			return result;

		} else {
			// ブキ一覧を取得して再セット
			List<Weapon> weaponList = dao.allWeaponData();
			String message = (weaponIds == null || weaponIds.length == 0)
					? "ブキが選択されていません"
					: "編集するブキを1つ選択してください";

			ExecuteResult result = new ExecuteResult(false);
			result.addData("weaponList", weaponList);
			result.addData("message", message);
			return result;

		}

	}

}
