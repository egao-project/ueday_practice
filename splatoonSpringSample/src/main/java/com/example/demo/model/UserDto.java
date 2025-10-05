package com.example.demo.model;

import lombok.Data;

@Data
public class UserDto {
	private Integer id;
	private String username;
	private String password;
	private String email;
}
