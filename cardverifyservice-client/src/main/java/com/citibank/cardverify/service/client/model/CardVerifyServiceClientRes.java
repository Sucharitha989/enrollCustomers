package com.citibank.cardverify.service.client.model;

public class CardVerifyServiceClientRes {

	private boolean active;
	private String respCode;
	private String respMsg;
	private String status;
	
	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	
 

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "CardVerifyServiceClientRes [active=" + active + ", respCode=" + respCode + ", respMsg=" + respMsg
				+ ", status=" + status + "]";
	}



}
