package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String user_id;
	private String pass;

	public LoginUser() {

	}

	public LoginUser(String user_id, String pass) {
		this.user_id = user_id;
		this.pass = pass;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
