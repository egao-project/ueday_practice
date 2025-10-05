package com.example.demo.service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserDto;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		// 入力されたユーザー名からユーザ名を検索する
		User user = userRepository.findByUsername(userName);
		if (user == null) {
			// 存在しない場合はエラーメッセージを返す
			throw new UsernameNotFoundException("ユーザーが見つかりません。");
		}
		return new UserPrincipal(user);
	}

	public User findByUsername(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Transactional
	public void save(UserDto userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		// passwordをハッシュ化してから保存
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setEmail(userDto.getEmail());

		userRepository.save(user);
	}

}
