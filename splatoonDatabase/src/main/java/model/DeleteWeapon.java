package model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;

import DTO.WeaponListDTO;
import dao.WeaponListDAO;

public class DeleteWeapon implements Action {

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		String[] weaponIdsValue = paramMap.get("weaponId");
		String[] weaponIds = null;
		if (weaponIdsValue != null) {
			weaponIds = new String[weaponIdsValue.length];
			for (int i = 0; i < weaponIdsValue.length; i++) {
				weaponIds[i] = weaponIdsValue[i];
			}
		}
		WeaponListDAO dao = new WeaponListDAO();

		if (weaponIds != null && weaponIds.length > 0) {
			ExecuteResult result = new ExecuteResult("/WEB-INF/jsp/deleteWeaponResult.jsp");
			WeaponListDTO weaponListDTO = dao.deleteWeapon(weaponIds);
			result.addData("weaponList", weaponListDTO.getWeaponList());
			result.addData("message", weaponListDTO.getMessage());
			return result;

		} else {
			List<Weapon> weaponList = dao.allWeaponData();
			ExecuteResult result = new ExecuteResult("/WEB-INF/jsp/weaponList.jsp");
			result.addData("weaponList", weaponList);
			result.addData("message", "削除対象のブキを選択してください");
			return result;

		}

	}

}
