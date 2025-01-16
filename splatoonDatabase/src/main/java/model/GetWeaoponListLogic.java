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

	public List<Weapon> getSearchWeaponListLogic(String searchBy, String searchKeyword, String matchType) {
		WeaponListDAO dao = new WeaponListDAO();
		List<Weapon> weaponList = null;

		if (matchType.equals("partial")) { // 検索パターンが部分一致の場合
			System.out.println("bubunnitti");
			weaponList = dao.searchWeaponDataPartial(searchBy, searchKeyword);
			System.out.println(weaponList.size());
			return weaponList;

		} else if (matchType.equals("exact")) { // 検索パターンが完全一致の場合

			weaponList = dao.searchWeaponDataExact(searchBy, searchKeyword);
			System.out.println(weaponList.size());
			return weaponList;

		}

		return null;

	}

}
