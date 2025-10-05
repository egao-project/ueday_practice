package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Weapon;

public interface WeaponRepositoryCustom {
	// 複数検索（or条件）を実行し結果をリストで返すメソッド
	List<Weapon> searchWeapons(String keyword, String matchType, List<String> fields);
}