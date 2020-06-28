package com.citibank.customers.enrollment.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.citibank.customers.enrollment.model.CustomerEnrollmentReq;
import com.citibank.customers.enrollment.model.EnrollmentServiceRes;
import com.citibank.customers.enrollment.svc.client.EnrollmentServiceClient;
import com.citibank.customers.enrollment.svc.client.EnrollmentServiceClientImpl;

@Controller

public class CustomerEnrollmentController {
	
	public String enrollment(@ModelAttribute CustomerEnrollmentReq request) {
		//1.get the request from UI
		//2.prepare the request for service client
		
		try {
			CustomerEnrollmentReq req = new CustomerEnrollmentReq();
			//3.call the service client and get the response
			EnrollmentServiceClient svcClient = new EnrollmentServiceClientImpl();
			EnrollmentServiceRes response = svcClient.enroll(req);
			
		} catch (IOException e) {
			
		e.printStackTrace();
		}
		//4.convert service response to web response.
		return null;

	
	
	}

}
