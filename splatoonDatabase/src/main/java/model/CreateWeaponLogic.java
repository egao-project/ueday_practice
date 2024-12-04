package model;

import dao.WeaponListDAO;

public class CreateWeaponLogic {
	public boolean execute(Weapon weapon) {
		WeaponListDAO dao = new WeaponListDAO();
		boolean result = dao.createWeapon(weapon);
		return result;
	}

}
