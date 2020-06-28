package com.citibank.customers.enrollment.model;

public class EnrollmentServiceRes {

	public StatusBlock Status;
	public String ackno;
	public EnrollmentServiceReq EnrollmentDetails;

	public StatusBlock getStatus() {
		return Status;
	}

	public void setStatus(StatusBlock status) {
		Status = status;
	}

	public String getAckno() {
		return ackno;
	}

	public void setAckno(String ackno) {
		this.ackno = ackno;
	}

	public EnrollmentServiceReq getEnrollmentDetails() {
		return EnrollmentDetails;
	}

	public void setEnrollmentDetails(EnrollmentServiceReq enrollmentDetails) {
		EnrollmentDetails = enrollmentDetails;
	}

}
	