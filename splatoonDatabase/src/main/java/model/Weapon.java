package model;

import java.io.Serializable;

public class Weapon implements Serializable {
	private int weaponId;
	private String type;
	private String name;
	private String weaponRange;
	private String damage;
	private String sub;
	private String special;

	public Weapon() {
	}

	public Weapon(int weaponId, String type, String name, String weaponRange, String damage, String sub,
			String special) {
		this.weaponId = weaponId;
		this.type = type;
		this.name = name;
		this.weaponRange = weaponRange;
		this.damage = damage;
		this.sub = sub;
		this.special = special;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponId) {
		this.weaponId = weaponId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeaponRange() {
		return weaponRange;
	}

	public void setWeaponRange(String weaponRange) {
		this.weaponRange = weaponRange;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getSub() {
		return sub;
	}

	public void setSub(String sub) {
		this.sub = sub;
	}

	public String getSpecial() {
		return special;
	}

	public void setSpecial(String special) {
		this.special = special;
	}

}
