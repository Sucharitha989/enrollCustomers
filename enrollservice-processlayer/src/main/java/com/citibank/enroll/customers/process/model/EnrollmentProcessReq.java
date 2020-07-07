package com.citibank.enroll.customers.process.model;

import java.util.List;

public class EnrollmentProcessReq {

	private String clientId;
	private String channelId;
	private String cardNum;
	private String cvvNum;
	private String expDate;
	private String nameOnCard;
	private List<String> MobileNumber;
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCvvNum() {
		return cvvNum;
	}
	public void setCvvNum(String cvvNum) {
		this.cvvNum = cvvNum;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	public List<String> getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(List<String> mobileNumber) {
		MobileNumber = mobileNumber;
	}
	@Override
	public String toString() {
		return "EnrollmentProcessReq [clientId=" + clientId + ", channelId=" + channelId + ", cardNum=" + cardNum
				+ ", cvvNum=" + cvvNum + ", expDate=" + expDate + ", nameOnCard=" + nameOnCard + ", MobileNumber="
				+ MobileNumber + "]";
	}
			
	
	}


