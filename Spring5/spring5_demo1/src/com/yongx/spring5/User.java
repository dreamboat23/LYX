package com.yongx.spring5;

public class User {


	@Override
	public String toString() {
		return "User [userName=" + userName + ", userAge=" + userAge + ", userAddress=" + userAddress + "]";
	}

	private String userName;
	private String userAge;
	private String userAddress;

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


	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public void add() {
		System.out.println("add...");
	}
}
