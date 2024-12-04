package model;

import dao.WeaponListDAO;

public class DeleteWeaponLogic {
	public boolean execute(String[] weaponIds) {
		WeaponListDAO dao = new WeaponListDAO();
		boolean result = dao.deleteWeapon(weaponIds);
		return result;
	}

}
