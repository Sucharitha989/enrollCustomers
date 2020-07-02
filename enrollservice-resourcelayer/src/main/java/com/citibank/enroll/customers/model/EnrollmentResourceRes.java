package com.citibank.enroll.customers.model;



import com.citibank.enroll.customers.resource.StatusBlock;

public class EnrollmentResourceRes {

	public StatusBlock Status;
	public String ackno;
	public EnrollmentResourceReq EnrollmentDetails;

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

	public EnrollmentResourceReq getEnrollmentDetails() {
		return EnrollmentDetails;
	}

	public void setEnrollmentDetails(EnrollmentResourceReq enrollmentDetails) {
		EnrollmentDetails = enrollmentDetails;
	}

}
	