package model;

import java.util.List;
import java.util.Map;

import DTO.WeaponListDTO;
import dao.WeaponListDAO;

public class RegisterWeapon extends AbstractModel implements Action {
	WeaponListDTO weaponListDTO;
	Weapon weapon;
	List<String> errors;

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap) {
		// TODO 自動生成されたメソッド・スタブ
		pretreatment(paramMap, sessionMap);

		if (!errors.isEmpty()) {
			// エラーメッセージをリクエストに設定
			result.setSuccess(false);
			postProcessing();
			return result;
		}

		WeaponListDAO dao = new WeaponListDAO();
		weaponListDTO = dao.registerWeapon(weapon);

		postProcessing();
		return result;

	}

	@Override
	public void pretreatment(Map<String, String[]> paramMap, Map<String, String[]> sessionParams) {
		// TODO 自動生成されたメソッド・スタブ
		weapon = new Weapon(paramMap.get("type")[0],
				paramMap.get("name")[0], paramMap.get("range")[0], paramMap.get("damage")[0],
				paramMap.get("sub")[0],
				paramMap.get("special")[0]);

		ValueCheck valueCheck = new ValueCheck();
		errors = valueCheck.weaponValueCheck(weapon.getType(), weapon.getName(), weapon.getRange(),
				weapon.getDamage(), weapon.getSub(), weapon.getSpecial());

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
