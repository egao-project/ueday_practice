package model;

import dao.WeaponListDAO;

public class UpdateWeapontLogic {
	//	public boolean execute(EditWeapon editWeapon) {
	public boolean execute(Weapon editWeapon) {

		WeaponListDAO dao = new WeaponListDAO();
		boolean result = dao.updateWeapon(editWeapon);
		return result;
	}

}
