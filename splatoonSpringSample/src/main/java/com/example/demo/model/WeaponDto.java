package com.example.demo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class WeaponDto {

	private Integer id;
	private String type;
	private String name;
	private String weaponRange;
	private String damage;
	private String sub;
	private String special;
	private Date createDate;
	private Date updateDate;
}
