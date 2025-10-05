package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Weapon;
import com.example.demo.repository.WeaponRepository;

@Service
public class WeaponListService {

	private WeaponRepository weaponRepository;

	@Autowired
	public WeaponListService(WeaponRepository weaponRepository) {
		this.weaponRepository = weaponRepository;
	}

	@Transactional
	public Weapon registerWeapon(Weapon weapon) { // ブキ登録、編集を行う（createもupdateもsaveを使用）
		return weaponRepository.save(weapon);
	}

	@Transactional
	public List<Weapon> getAllWeaponList() { // ブキリストを全件取得
		return weaponRepository.findAll();
	}

	@Transactional
	public Optional<Weapon> getWeaponById(Long id) { // idからブキ情報を取得する
		return weaponRepository.findById(id);
	}

	@Transactional
	public void deleteWeapon(List<Long> id) { // idからブキ情報を削除する
		weaponRepository.deleteAllById(id);
	}

	@Transactional
	public List<Weapon> searchWeapons(String keyword, String matchType, List<String> fields) {
		// 文字列、完全一致か部分一致か、チェックボックスで選択された検索項目をもとに複数検索を実行し結果を取得する
		return weaponRepository.searchWeapons(keyword, matchType, fields);
	}
}
