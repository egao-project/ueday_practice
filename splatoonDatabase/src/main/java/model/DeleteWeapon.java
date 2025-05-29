package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;

import DTO.WeaponListDTO;
import dao.WeaponListDAO;

public class DeleteWeapon extends AbstractModel implements Action {
	String[] weaponIdsValue = null;
	String[] weaponIds = null;
	WeaponListDTO weaponListDTO = new WeaponListDTO();
	List<Weapon> weaponList = new ArrayList<Weapon>();

	@Override
	public ExecuteResult execute(Map<String, String[]> paramMap, Map<String, String[]> sessionMap)
			throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ
		pretreatment(paramMap, sessionMap);
		WeaponListDAO dao = new WeaponListDAO();

		if (weaponIds != null && weaponIds.length > 0) {
			weaponListDTO = dao.deleteWeapon(weaponIds);
			postProcessing();
			return result;

		} else {
			weaponList = dao.allWeaponData();
			result.setSuccess(false);
			postProcessing();
			return result;

		}

	}

	@Override
	public void postProcessing() {
		// TODO 自動生成されたメソッド・スタブ
		if (result.isSuccess()) {
			result.addData("weaponList", weaponListDTO.getWeaponList());
			result.addData("message", weaponListDTO.getMessage());
		} else {
			result.addData("weaponList", weaponList);
			result.addData("message", "削除対象のブキを選択してください");
		}

	}

	@Override
	public void pretreatment(Map<String, String[]> parameterMap, Map<String, String[]> sessionParams) {
		// TODO 自動生成されたメソッド・スタブ
		weaponIdsValue = parameterMap.get("weaponId");
		if (weaponIdsValue != null) {
			weaponIds = new String[weaponIdsValue.length];
			for (int i = 0; i < weaponIdsValue.length; i++) {
				weaponIds[i] = weaponIdsValue[i];
			}
		}
	}

}
