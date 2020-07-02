package com.citibank.enroll.customers.model;

import java.util.List;


public class CustomerInfo {

	private String cardNum;
	private String cvvNum;
	private String expDate;
	private String nameOnCard;
	private List<String> mobileNumber;

	@Override
	public String toString() {
		return "CustomerInfo [cardNum=" + cardNum + ", cvvNum=" + cvvNum + ", expDate=" + expDate + ", nameOnCard="
				+ nameOnCard + ", mobileNumber=" + mobileNumber + "]";
	}

	public List<String> getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(List<String> mobileNumber) {
		this.mobileNumber = mobileNumber;
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

}
