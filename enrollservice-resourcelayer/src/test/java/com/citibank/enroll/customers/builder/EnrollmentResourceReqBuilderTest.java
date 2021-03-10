package com.citibank.enroll.customers.builder;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.citibank.enroll.customers.model.ClientContext;
import com.citibank.enroll.customers.model.CustomerInfo;
import com.citibank.enroll.customers.model.EnrollmentResourceReq;
import com.citibank.enroll.customers.model.ServiceDetails;
import com.citibank.enroll.customers.process.model.EnrollmentProcessReq;

public class EnrollmentResourceReqBuilderTest {
	EnrollmentResourceReqBuilder requestBuilder;
	

	@Test
	public void testBuildProcessEnrollReq() {
		
		requestBuilder= new EnrollmentResourceReqBuilder();
		EnrollmentResourceReq	request =buildResourceReq();
		
		EnrollmentProcessReq processReq= requestBuilder.buildProcessEnrollReq(request);
		
		assertEquals(processReq.getClientId(), request.getClientContext().getClientId());
		assertEquals(processReq.getChannelId(),request.getClientContext().getChannelId());
	
		
		//assertEquals(processReq.getCardNum(),request.getCustomerInfo().getCardNum());
		
	}


	private EnrollmentResourceReq buildResourceReq() {
		
		EnrollmentResourceReq request = new EnrollmentResourceReq();

		  // prepare the client details

		ClientContext clientContext = new ClientContext();
		clientContext.setClientId("citi");
		clientContext.setChannelId("mobile");
		clientContext.setRequestId(UUID.randomUUID().toString());
		request.setClientContext(clientContext);

		  //prepare the customer details 
		CustomerInfo customerInfo = new CustomerInfo();
		customerInfo.setCardNum("232323232322323243");
		customerInfo.setExpDate("12-2021");
		customerInfo.setCvvNum("123");
		customerInfo.setNameOnCard("Sreenu");
		List<String>mobileNumber = new ArrayList<String>();


		mobileNumber.add("98776555443");
		mobileNumber.add("87665544434");

		customerInfo.setMobileNumber(mobileNumber);

		request.setCustomerInfo(customerInfo);

		ServiceDetails servicedtls = new ServiceDetails();
		servicedtls.setServiceName("EnrollmentService");
		servicedtls.setApiName("enrollment");
		servicedtls.setVersion("1.0");

		request.setServiceDetails(servicedtls);

		
		
		return request;

		
		
	}

}
