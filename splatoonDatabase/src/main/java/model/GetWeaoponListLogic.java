package model;

import java.util.List;

import dao.WeaponListDAO;

public class GetWeaoponListLogic {
	public List<Weapon> getAllWeaponListLogic() {
		WeaponListDAO dao = new WeaponListDAO();
		List<Weapon> weaponList = dao.allWeaponData();

		if (weaponList == null) {
			return null;
		}
		return weaponList;
	}

}
