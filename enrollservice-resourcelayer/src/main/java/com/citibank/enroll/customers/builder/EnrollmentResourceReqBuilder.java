package com.citibank.enroll.customers.builder;

import java.util.ArrayList;
import java.util.List;

import com.citibank.enroll.customers.model.EnrollmentResourceReq;
import com.citibank.enroll.customers.process.model.EnrollmentProcessReq;

public class EnrollmentResourceReqBuilder {

	
	public EnrollmentProcessReq buildProcessEnrollReq(EnrollmentResourceReq request) {
		
		EnrollmentProcessReq processReq = new EnrollmentProcessReq();
		
		processReq.setClientId(request.getClientContext().getClientId());
		processReq.setChannelId(request.getClientContext().getChannelId());
		processReq.setCvvNum(request.getCustomerInfo().getCardNum());
		processReq.setCvvNum(request.getCustomerInfo().getCvvNum());
		processReq.setExpDate(request.getCustomerInfo().getExpDate());
		processReq.setNameOnCard(request.getCustomerInfo().getNameOnCard());
		
		
		List<String> mobNums = new ArrayList<String>();
		for (String mooobNum : request.getCustomerInfo().getMobileNumber()) {
			mobNums.add(mooobNum);
			processReq.setMobileNumber(mobNums);	
		}
		return processReq;
	}

}
