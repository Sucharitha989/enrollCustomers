package com.citibank.enroll.customers.builder;

import com.citibank.enroll.customers.model.EnrollmentResourceReq;
import com.citibank.enroll.customers.model.EnrollmentResourceRes;
import com.citibank.enroll.customers.model.StatusBlock;
import com.citibank.enroll.customers.process.model.EnrollmentProcessRes;

public class EnrollmentResourceRespBuilder {

	public EnrollmentResourceRes buildResourceResp(final EnrollmentProcessRes processResp, final EnrollmentResourceReq request) {

		final EnrollmentResourceRes response = new EnrollmentResourceRes();

		final StatusBlock status = new StatusBlock();
		status.setRespCode(processResp.getRespCode());
		status.setRespMsg(processResp.getRespMsg());
		status.setStatus(processResp.getStatus());

		response.setStatus(status);

		response.setEnrollmentDetails(request);
		return response;
	}

}
