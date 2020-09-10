package com.yongx.spring5;

public class Orders {

	@Override
	public String toString() {
		return "Orders [oName=" + oName + ", oAddress=" + oAddress + "]";
	}
	private String oName;
	private String oAddress;
	//有参构造
	public Orders(String oName, String oAddress) {
		this.oName = oName;
		this.oAddress = oAddress;
	}

}
