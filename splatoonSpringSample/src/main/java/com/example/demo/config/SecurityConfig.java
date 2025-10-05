package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	// Spring Security のフィルタチェーンを定義
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.authorizeHttpRequests(auth -> auth
						// ログイン画面と静的リソースは誰でもアクセス可
						.requestMatchers("/login", "/css/**", "/js/**").permitAll()
						// それ以外は認証が必要
						.anyRequest().authenticated())
				.formLogin(login -> login
						.loginPage("/login") // ログイン画面のURL
						.defaultSuccessUrl("/", true) // ログイン成功後の遷移先
						.permitAll())
				.logout(logout -> logout
						.logoutSuccessUrl("/login?logout") // ログアウト後の遷移先
						.permitAll());

		return http.build();
	}

	// パスワードエンコーダー
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
