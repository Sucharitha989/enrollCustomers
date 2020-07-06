package com.citibank.enroll.customers.process.model;

public class EnrollmentProcessRes {
private String respCode;
private String respMsg;
private String status;
private String desc;

public String getDesc() {
	return desc;
}
public void setDesc(String desc) {
	this.desc = desc;
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
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "EnrollmentProcessRes [respCode=" + respCode + ", respMsg=" + respMsg + ", status=" + status + ", desc="
			+ desc + "]";
}

	}


