package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Weapon;
import com.example.demo.service.WeaponListService;

@Controller
public class WeaponListController {

	private WeaponListService weaponListService;

	@Autowired
	public WeaponListController(WeaponListService weaponListService) {
		this.weaponListService = weaponListService;
	}

	@GetMapping("/weaponList")
	public String viewWeaponList(Model model) {
		List<Weapon> weaponList = weaponListService.getAllWeaponList();
		model.addAttribute("weaponList", weaponList);
		return "weaponList";
	}

	@PostMapping("/saveWeapon")
	public String saveWeapon(@ModelAttribute("weapon") Weapon weapon) {
		weaponListService.registerWeapon(weapon);
		return "redirect:/weaponList";
	}

	@GetMapping("/weaponRegister")
	public String weaponRegister(Model model) {
		Weapon weapon = new Weapon();
		model.addAttribute("weapon", weapon);
		return "weaponRegister";
	}

	@GetMapping("/weaponEdit")
	public String weaponEdit(@RequestParam(required = false) List<Long> weaponIds, Model model) {
		Long weaponId = weaponIds.get(0);
		Optional<Weapon> weapon = weaponListService.getWeaponById(weaponId);
		model.addAttribute("weapon", weapon);
		return "editWeapon";
	}

	@GetMapping("/weaponDelete")
	public String weaponDelete(@RequestParam(required = false) List<Long> weaponIds) {
		this.weaponListService.deleteWeapon(weaponIds);
		return "redirect:weaponList";
	}

	@GetMapping("weaponSearch")
	public String searchWeapons(
			@RequestParam("keyword") String keyword,
			@RequestParam("matchType") String matchType,
			@RequestParam(value = "fields", required = false) List<String> fields,
			Model model) {

		List<Weapon> results = weaponListService.searchWeapons(keyword, matchType, fields);

		model.addAttribute("weaponList", results);
		model.addAttribute("keyword", keyword);
		model.addAttribute("matchType", matchType);
		model.addAttribute("fields", fields);

		return "weaponList";
	}
}