package model;

import java.io.Serializable;

public class Account implements Serializable {
	private String userId;
	private String pass;
	private String name;
	private int weaponId;

	public Account() {
	}

	public Account(String userId, String pass, String name) {
		this.userId = userId;
		this.pass = pass;
		this.name = name;
	}

	public Account(String userId, String pass, String name, int weaponId) {
		this.userId = userId;
		this.pass = pass;
		this.name = name;
		this.weaponId = weaponId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

}
