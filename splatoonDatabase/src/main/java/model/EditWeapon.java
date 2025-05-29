package model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;

import DTO.WeaponListDTO;
import dao.WeaponListDAO;

public class EditWeapon extends AbstractModel implements Action {
	Weapon weapon = new Weapon();
	WeaponListDTO weaponListDTO = new WeaponListDTO();
	List<String> errors = null;

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		pretreatment(paramMap, sessionMap);
		//文字入力チェック
		ValueCheck valueCheck = new ValueCheck();
		errors = valueCheck.weaponValueCheck(weapon.getType(), weapon.getName(), weapon.getRange(),
				weapon.getDamage(), weapon.getSub(), weapon.getSpecial());

		if (!errors.isEmpty()) {
			// エラーメッセージをリクエストに設定
			result.setSuccess(false);
			postProcessing();
			return result;
		}
		WeaponListDAO dao = new WeaponListDAO();
		weaponListDTO = dao.editWeapon(weapon);
		postProcessing();
		return result;

	}

	@Override
	public void pretreatment(Map<String, String[]> parameterMap, Map<String, String[]> sessionParams) {
		// TODO 自動生成されたメソッド・スタブ
		weapon = new Weapon(Integer.parseInt(parameterMap.get("weaponId")[0]), parameterMap.get("type")[0],
				parameterMap.get("name")[0], parameterMap.get("range")[0], parameterMap.get("damage")[0],
				parameterMap.get("sub")[0],
				parameterMap.get("special")[0]);
	}

	@Override
	public void postProcessing() {
		// TODO 自動生成されたメソッド・スタブ
		if (result.isSuccess()) {
			result.addData("weaponList", weaponListDTO.getWeaponList());
			result.addData("message", weaponListDTO.getMessage());
		} else {
			result.addData("errors", errors);
		}
	}

}
