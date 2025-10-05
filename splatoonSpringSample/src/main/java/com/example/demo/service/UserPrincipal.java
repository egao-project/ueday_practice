package com.example.demo.service;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.User;

public class UserPrincipal implements UserDetails {

	private User user;

	public UserPrincipal(User user) {
		this.user = user;
	}

	// ユーザーに与えられる権限を返す。ここでは全てのユーザーに"USER"という権限を与えている。
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}

	// Userオブジェクトのパスワードを返す
	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return user.getPassword();
	}

	// Userオブジェクトのユーザー名を返す
	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return user.getUsername();
	}

	// アカウントが有効期限切れでないことを示すために、常にtrueを返す
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// アカウントがロックされていないことを示すために、常にtrueを返す
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 資格情報が有効期限切れでないことを示すために、常にtrueを返す
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// アカウントが有効であることを示すために、常にtrueを返す
	@Override
	public boolean isEnabled() {
		return true;
	}

}
