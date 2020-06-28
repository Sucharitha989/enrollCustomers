package com.citibank.enroll.customers.builder;

import com.citibank.enroll.customers.model.EnrollmentResourceReq;
import com.citibank.enroll.customers.model.EnrollmentResourceRes;
import com.citibank.enroll.customers.process.model.EnrollmentProcessRes;
import com.citibank.enroll.customers.resource.StatusBlock;

public class EnrollmentResourceRespBuilder {

	public EnrollmentResourceRes buildResourceResp(EnrollmentProcessRes processResp, EnrollmentResourceReq request) {

		EnrollmentResourceRes response = new EnrollmentResourceRes();

		StatusBlock status = new StatusBlock();
		status.setRespCode(processResp.getRespCode());
		status.setRespMsg(processResp.getRespMsg());
		status.setStatus(processResp.getStatus());

		response.setStatus(status);

		response.setEnrollmentDetails(request);
		return response;
	}

}
