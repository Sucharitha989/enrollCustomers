package com.citibank.enroll.customers.resource;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.citibank.enroll.customers.builder.EnrollmentResourceReqBuilder;
import com.citibank.enroll.customers.builder.EnrollmentResourceRespBuilder;
import com.citibank.enroll.customers.dao.exception.BusinessException;
import com.citibank.enroll.customers.dao.exception.SystemException;
import com.citibank.enroll.customers.model.ClientContext;
import com.citibank.enroll.customers.model.CustomerInfo;
import com.citibank.enroll.customers.model.EnrollmentResourceReq;
import com.citibank.enroll.customers.model.EnrollmentResourceRes;
import com.citibank.enroll.customers.model.ServiceDetails;
import com.citibank.enroll.customers.process.builder.EnrollmentProcess;
import com.citibank.enroll.customers.process.impl.EnrollmentProcessImpl;
import com.citibank.enroll.customers.process.model.EnrollmentProcessReq;
import com.citibank.enroll.customers.process.model.EnrollmentProcessRes;
import com.citibank.enroll.customers.validator.EnrollmentReqInvalidException;
import com.citibank.enroll.customers.validator.EnrollmentReqValidator;
@Path("/v1")
public class EnrollmentResource {

	
	
	

/*
{
  "clientContext" : {
    "clientId" : "citi",
    "channelId" : "mobile",
    "requestId" : "c3b930fd-7c73-4206-88d7-5c6fa489210f",
    "messageTimeStamp" : null
  },
  "customerInfo" : {
    "mobileNumber" : [ "98776555443", "87665544434" ],
    "cardNum" : "2323434343434343434343",
    "cvvNum" : "123",
    "expDate" : "12-2021",
    "nameOnCard" : "sreenu"
  },
  "servicedtls" : {
    "serviceName" : "EnrollmentService",
    "apiName" : "enrollment",
    "version" : "1.0"
  }
}
	
*/	
	
	
	
	
	
	
 
@Path("/enrollment")
@Consumes("application/json") //this is request presentation--convert json to java object
@Produces("application/json") //this is request presentation--convert java to json object
@POST
	public EnrollmentResourceRes enroll(EnrollmentResourceReq request) throws IOException{
		System.out.println("Entered into the resource Layer : "+ request );
		
		EnrollmentResourceRes response = null;
		//1. Get the request from client or consumer.
		try{
		//2. Validate the request.
		
		EnrollmentReqValidator validator = new EnrollmentReqValidator();
		
			validator.validateRequest(request);

		
		//3. Prepare the request for the process layer.
			
		EnrollmentResourceReqBuilder reqBuilder = new EnrollmentResourceReqBuilder();
		EnrollmentProcessReq processReq = reqBuilder.buildProcessEnrollReq(request);
		
		//4. Call the process layer by passing process req and get the process resp.
		
		 EnrollmentProcess process = new EnrollmentProcessImpl();
		 
		 //EnrollmentProcessRes processResp = ((EnrollmentProcessImpl) process).enroll(processReq)(WRONG);
		 
		 EnrollmentProcessRes processResp = process.enroll(processReq);
		 
		 //5. Prepare the resource resp.
		 EnrollmentResourceRespBuilder respBuilder = new EnrollmentResourceRespBuilder();
		 //EnrollmentResourceRes 
		 response = respBuilder.buildResourceResp(processResp,request);
          }
		
		
		 catch (EnrollmentReqInvalidException exce) {
			 
			 response = new EnrollmentResourceRes();
			 
			 StatusBlock statusBlock = new StatusBlock();
			 
			 statusBlock.setRespCode(exce.getRespCode());
			 statusBlock.setRespMsg(exce.getRespMsg());
			 
			 
			 
			 response.setStatus(statusBlock);
		
	} catch (SystemException e) {

		 response = new EnrollmentResourceRes();
		 
		 StatusBlock statusBlock = new StatusBlock();
		 
		 statusBlock.setRespCode(e.getRespCode());
		 statusBlock.setRespMsg(e.getRespMsg());
		 
		 
		 
		 response.setStatus(statusBlock);
	
		
			e.printStackTrace();
		} catch (BusinessException e) {
			
 response = new EnrollmentResourceRes();
			 
			 StatusBlock statusBlock = new StatusBlock();
			 
			 statusBlock.setRespCode(e.getRespCode());
			 statusBlock.setRespMsg(e.getRespMsg());

			 response.setStatus(statusBlock);
		
			e.printStackTrace();
		}
	
		
		
		//6. Send resource response to consumer.
		
		System.out.println("Exit from Resource Layer : "+ request);
		return response;
}
public static void main (String[] args) throws IOException{
	EnrollmentResourceReq request = new EnrollmentResourceReq();

  // prepare the client details

ClientContext clientContext = new ClientContext();
ClientContext.setClientId("ciit");
ClientContext.setChannelId("mobile");
ClientContext.setRequestId(UUID.randomUUID().toString());
request.setClientContext(clientContext);

  //prepare the customer details 
CustomerInfo customerInfo = new CustomerInfo();
customerInfo.setCardNum("232323232322323243");
customerInfo.setExpDate("12-2021");
customerInfo.setCvvNum("123");
customerInfo.setNameOnCard("Sreenu");
List<String>mobileNumber = new ArrayList();


mobileNumber.add("98776555443");
mobileNumber.add("87665544434");

customerInfo.setMobileNumber(mobileNumber);

request.setCustomerInfo(customerInfo);

ServiceDetails servicedtls = new ServiceDetails();
servicedtls.setServiceName("EnrollmentService");
servicedtls.setApiName("enrollment");
servicedtls.setVersion("1.0");

request.setServiceDetails(servicedtls);

EnrollmentResource resource = new EnrollmentResource();

EnrollmentResourceRes enrollResp = resource.enroll(request);








}


}






