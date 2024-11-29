package model;

import java.io.Serializable;

public class EditAccount implements Serializable {
	private String userId;
	private String newName;

	public EditAccount() {

	}

	public EditAccount(String userId, String newName) {
		this.userId = userId;
		this.newName = newName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

}
