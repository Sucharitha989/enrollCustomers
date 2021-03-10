package com.citibank.enroll.customers.validator;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.citibank.enroll.customers.model.ClientContext;
import com.citibank.enroll.customers.model.CustomerInfo;
import com.citibank.enroll.customers.model.EnrollmentResourceReq;
import com.citibank.enroll.customers.model.ServiceDetails;

public class EnrollmentReqValidatorTest {
	EnrollmentReqValidator validator  = null;
	EnrollmentResourceReq request = null;

	@Before
	public void setUP() {
		validator = new EnrollmentReqValidator();
        request = buildResourceReq();
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

	@Test
	public void testRequestObject_invalidScenario() {
		//request.getCustomerInfo().setCardNum(null);
		try {
			validator.validateRequest(null);
		} catch (EnrollmentReqInvalidException e) {
			assertEquals("enr001", e.getRespCode());
			// e.printStackTrace();
		}
	}
	
	/*
	 * @Test public void testRequestObject_invalidScenario_1() {
	 * 
	 * try { //request.setClientContext(null); validator.validateRequest(request); }
	 * catch (EnrollmentReqInvalidException e) { assertEquals("enr001",
	 * e.getRespCode()); // e.printStackTrace(); } }
	 * 
	 * @Test public void testRequestObject_invalidScenario_2() {
	 * 
	 * try { request.setCustomerInfo(null); validator.validateRequest(request); }
	 * catch (EnrollmentReqInvalidException e) { assertEquals("enr001",
	 * e.getRespCode()); // e.printStackTrace(); } }
	 */
	
	@Test
	public void testChannelId_Null_Scenario() {
		request.getClientContext().setClientId(null);
		try {
			validator.validateRequest(request);
		} catch (EnrollmentReqInvalidException e) {
			assertEquals("enr002", e.getRespCode());
			// e.printStackTrace();
		}
	}
	
	
	@Test
	public void testChannelId_EmptyScenarios() {
		
		request.getClientContext().setChannelId(null);
		try {
			validator.validateRequest(request);
		} catch (EnrollmentReqInvalidException e) {
			assertEquals("enr003", e.getRespCode());
	
		
	}
	}
}

