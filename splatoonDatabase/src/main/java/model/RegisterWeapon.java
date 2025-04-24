package model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;

import DTO.WeaponListDTO;
import dao.WeaponListDAO;

public class RegisterWeapon implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		Weapon weapon = new Weapon(paramMap.get("type")[0],
				paramMap.get("name")[0], paramMap.get("range")[0], paramMap.get("damage")[0],
				paramMap.get("sub")[0],
				paramMap.get("special")[0]);

		ValueCheck valueCheck = new ValueCheck();
		List<String> errors = valueCheck.weaponValueCheck(weapon.getType(), weapon.getName(), weapon.getRange(),
				weapon.getDamage(), weapon.getSub(), weapon.getSpecial());

		if (!errors.isEmpty()) {
			// エラーメッセージをリクエストに設定
			ExecuteResult result = new ExecuteResult(false);
			result.addData("errors", errors);
			return result;
		}

		ExecuteResult result = new ExecuteResult(true);
		WeaponListDAO dao = new WeaponListDAO();
		WeaponListDTO weaponListDTO = dao.registerWeapon(weapon);
		result.addData("weaponList", weaponListDTO.getWeaponList());
		result.addData("message", weaponListDTO.getMessage());
		return result;

	}

}
