package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "weapons")
public class Weapon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "type")
	private String type;

	@Column(name = "name")
	private String name;

	@Column(name = "weapon_range")
	private String weaponRange;

	@Column(name = "damage")
	private String damage;

	@Column(name = "sub")
	private String sub;

	@Column(name = "special")
	private String special;

	@Column(name = "created_at")
	private Date createDate;

	@Column(name = "update_at")
	private Date updateDate;
}
