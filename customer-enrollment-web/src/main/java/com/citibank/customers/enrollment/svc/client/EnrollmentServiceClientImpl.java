package com.citibank.customers.enrollment.svc.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.citibank.customers.enrollment.model.ClientContext;
import com.citibank.customers.enrollment.model.CustomerEnrollmentReq;
import com.citibank.customers.enrollment.model.CustomerInfo;
import com.citibank.customers.enrollment.model.EnrollmentServiceReq;
import com.citibank.customers.enrollment.model.EnrollmentServiceRes;
import com.citibank.customers.enrollment.model.ServiceDetails;

public class EnrollmentServiceClientImpl implements EnrollmentServiceClient {

	public EnrollmentServiceRes enroll(EnrollmentServiceReq enrollrequest) throws IOException {

		// 1.prepare the client details

		ClientContext clientContext = new ClientContext();
		clientContext.setClientId("ciit");
		clientContext.setChannelId("mobile");
		clientContext.setRequestId(UUID.randomUUID().toString());
		enrollrequest.setClientContext(clientContext);

		// 2.prepare the customer details

		ServiceDetails servicedtls = new ServiceDetails();
		servicedtls.setServiceName("EnrollmentService");
		servicedtls.setApiName("Enrollment");
		servicedtls.setVersion("0.0.1");

		enrollrequest.setServiceDetails(servicedtls);

		String url = "http://localhost:1010/enrollment-servicewar/rest/v1/enrollment";

		/*
		 * String env = System.getProperty("env");
		 * 
		 * System.out.println("environment is : " + env);
		 * 
		 * String filename = "properties\\enroll-service-" + env + ".properties";
		 * 
		 * InputStream input =
		 * getClass().getClassLoader().getResourceAsStream(filename);
		 * 
		 * Properties properties = new Properties();
		 * 
		 * properties.load(input);
		 * 
		 * String url = properties.getProperty("enroll-service");
		 * 
		 * System.out.println(" service url  is : " + url);
		 */
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json");

		HttpEntity<EnrollmentServiceReq> request = new HttpEntity<EnrollmentServiceReq>(enrollrequest, headers);

		RestTemplate restTemplate = new RestTemplate();

		// add these convertes to do java object to json.
		/*
		 * It's an eclipse setup issue, not a Jersey issue.
		 * 
		 * From this thread ClassNotFoundException:
		 * com.sun.jersey.spi.container.servlet.ServletContainer
		 * 
		 * Right click your eclipse project Properties -> Deployment Assembly -> Add ->
		 * Java Build Path Entries -> Gradle Dependencies -> Finish
		 */
		/*
		 * SEVERE: Servlet [Jersey-servelet] in web application [/enrollment-servicewar]
		 * threw load() exception java.lang.ClassNotFoundException:
		 * com.sun.jersey.spi.container.servlet.ServletContainer
		 */

		List<HttpMessageConverter<?>> messageConverters = new ArrayList();
		messageConverters.add(new MappingJackson2HttpMessageConverter());

		restTemplate.setMessageConverters(messageConverters);

		EnrollmentServiceRes response = restTemplate.postForObject(url, request, EnrollmentServiceRes.class);

		return response;
	}
	
	  public static void main(String[] args) throws IOException {
	  
	  EnrollmentServiceReq request = new EnrollmentServiceReq();
	  
	  
	  //System.setProperty("env", "test");
	  
	  EnrollmentServiceReq request1 = new EnrollmentServiceReq();
	  
	  
	  // prepare the customer details
	  
	  CustomerInfo customerInfo = new CustomerInfo();
	  
	  customerInfo.setCardNum("232323232322323243");
	  customerInfo.setExpDate("12-2021"); 
	  customerInfo.setCvvNum("123");
	  customerInfo.setNameOnCard("Sreenu"); 
	  List<String> mobileNumber = new ArrayList<String>();
	  
	  mobileNumber.add("98776555443"); 
	  mobileNumber.add("87665544434");
	  
	  customerInfo.setMobileNumber(mobileNumber);
	  
	  request.setCustomerInfo(customerInfo);
	  
	  EnrollmentServiceClient svcClient = new EnrollmentServiceClientImpl();
	  
	  EnrollmentServiceRes resp = svcClient.enroll(request);
	  System.out.println("service response is : " + resp); 
	  }
	  
	  public EnrollmentServiceRes enroll(CustomerEnrollmentReq req) throws  IOException {
		return null; 
		   }
	 
}

