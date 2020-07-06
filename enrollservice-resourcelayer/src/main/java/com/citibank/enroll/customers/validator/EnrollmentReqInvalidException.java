package com.citibank.enroll.customers.validator;

public class EnrollmentReqInvalidException extends Exception {
	private final String respCode;
	private final String respMsg;
	

	public EnrollmentReqInvalidException(final String respCode, final String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
		
	}


	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}


}
