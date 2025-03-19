package service;

import java.io.Serializable;

public class EditWeaponList implements Serializable {
	private int weaponId;
	private String type;
	private String name;
	private String range;
	private String damage;
	private String sub;
	private String special;

	public EditWeaponList() {

	}

	public EditWeaponList(int weaponId) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.weaponId = weaponId;
	}

	public int getWeaponId() {
		return weaponId;
	}

	public void setWeaponId(int weaponid) {
		this.weaponId = weaponid;
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

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
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
