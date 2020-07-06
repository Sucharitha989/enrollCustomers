package com.citibank.enroll.customers.process.builder;

public class EnrollmentProcessRespBuilder {

	public String respMessage;

	public String getRespMessage() {
		return respMessage;
	}

	public void setRespMessage(String respMessage) {
		this.respMessage = respMessage;
	}

	@Override
	public String toString() {
		return "EnrollmentProcessRespBuilder [respMessage=" + respMessage + "]";
	}

}
