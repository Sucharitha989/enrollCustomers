package com.citibank.enroll.customers.dao.exception;

public class BusinessException extends Exception { 
	public String respCode;
    public String respMsg;
	public BusinessException(String respCode2, String respMsg2) {
		// TODO Auto-generated constructor stub
	}
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	@Override
	public String toString() {
		return "BusinessException [respCode=" + respCode + ", respMsg=" + respMsg + "]";
	}
    
    
    
    
    
    
}