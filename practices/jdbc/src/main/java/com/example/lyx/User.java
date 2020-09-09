package com.example.lyx;

import java.util.Date;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class User {

	private String loginId;
	private int nodeId;
	private String authPw;
	private Date updateTime;
	private String mdn;

//	@Override
//	public String toString() {
//		return "User [loginId=" + loginId + ", nodeId=" + nodeId + ", authPw=" + authPw + ", updateTime=" + updateTime
//				+ ", mdn=" + mdn + ", mailAddr=" + mailAddr + ", serviceId=" + serviceId + ", webMailUseFlg="
//				+ webMailUseFlg + "]";
//	}
//	private String mailAddr;
//
//	public String getLoginId() {
//		return loginId;
//	}
//	public void setLoginId(String loginId) {
//		this.loginId = loginId;
//	}
//	public int getNodeId() {
//		return nodeId;
//	}
//	public void setNodeId(int nodeId) {
//		this.nodeId = nodeId;
//	}
//	public String getAuthPw() {
//		return authPw;
//	}
//	public void setAuthPw(String authPw) {
//		this.authPw = authPw;
//	}
//	public Date getUpdateTime() {
//		return updateTime;
//	}
//	public void setUpdateTime(Date updateTime) {
//		this.updateTime = updateTime;
//	}
//	public String getMdn() {
//		return mdn;
//	}
//	public void setMdn(String mdn) {
//		this.mdn = mdn;
//	}
//	public String getMailAddr() {
//		return mailAddr;
//	}
//	public void setMailAddr(String mailAddr) {
//		this.mailAddr = mailAddr;
//	}
//	public int getServiceId() {
//		return serviceId;
//	}
//	public void setServiceId(int serviceId) {
//		this.serviceId = serviceId;
//	}
//	public int getWebMailUseFlg() {
//		return webMailUseFlg;
//	}
//	public void setWebMailUseFlg(int webMailUseFlg) {
//		this.webMailUseFlg = webMailUseFlg;
//	}
	private int serviceId;
	private int webMailUseFlg;
}
