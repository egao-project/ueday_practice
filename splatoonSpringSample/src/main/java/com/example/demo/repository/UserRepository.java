package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// ユーザー名でユーザーを探すメソッド
	User findByUsername(String username);

}
