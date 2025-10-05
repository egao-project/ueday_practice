package com.example.demo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String redirectToIndex() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // 現在のユーザーの認証情報を取得する
		if (authentication != null && authentication.isAuthenticated()) { // ユーザーがログインしている場合
			return "redirect:/weaponList";
		}
		return "redirect:/login"; // ユーザーがログインしていない場合、"/login"にリダイレクトする
	}

}
