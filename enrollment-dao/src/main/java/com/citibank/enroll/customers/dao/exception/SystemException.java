package com.citibank.enroll.customers.dao.exception;

public class SystemException extends Exception { 
	private String respCode;
    private String respMsg;


public SystemException(String respCode, String respMsg) {
	this.respCode = respCode;
	this.respMsg = respMsg;
}


public String getRespCode() { 
	return respCode;
	}

public String getRespMsg() { 
	return respMsg;
	}


@Override
public String toString() {
	return "SystemException [respCode=" + respCode + ", respMsg=" + respMsg + "]";
}



}