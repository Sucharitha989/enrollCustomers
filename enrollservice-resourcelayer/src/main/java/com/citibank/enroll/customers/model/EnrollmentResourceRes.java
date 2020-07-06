package com.citibank.enroll.customers.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EnrollmentResourceRes {

	private StatusBlock Status;
	private String ackno;
	private EnrollmentResourceReq EnrollmentDetails;

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

	@Override
	public String toString() {
		return "EnrollmentResourceRes [Status=" + Status + ", ackno=" + ackno + ", EnrollmentDetails="
				+ EnrollmentDetails + "]";
	}

}
	