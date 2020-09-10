package com.yongx.spring5;

public class User {

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userAge=" + userAge + "]";
	}

	private String userName;
	private String userAge;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public void add() {
		System.out.println("add...");
	}
}
