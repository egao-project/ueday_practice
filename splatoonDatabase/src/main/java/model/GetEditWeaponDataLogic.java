package model;

import dao.WeaponListDAO;

public class GetEditWeaponDataLogic {
	public Weapon getEditWeaponDataLogic(String weaponId) {
		WeaponListDAO dao = new WeaponListDAO();
		Weapon weapon = dao.editWeaponData(weaponId);

		if (weapon == null) {
			return null;
		}
		return weapon;
	}

}
