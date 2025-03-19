package DTO;

import java.util.List;

import model.Weapon;

public class WeaponListDTO {
	private List<Weapon> weaponList;
	private String message;

	public WeaponListDTO() {
	}

	public WeaponListDTO(List<Weapon> weaponList, String message) {
		this.weaponList = weaponList;
		this.message = message;

	}

	public List<Weapon> getWeaponList() {
		return weaponList;
	}

	public void setWeaponList(List<Weapon> weaponList) {
		this.weaponList = weaponList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
