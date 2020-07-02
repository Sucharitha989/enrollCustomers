package com.citibank.customers.enrollment.model;



public class EnrollmentServiceReq {

	
	public ClientContext clientContext;
	public CustomerInfo customerInfo;
	public ServiceDetails serviceDetails;
	
	public ClientContext getClientContext() {
		return clientContext;
	}
	public void setClientContext(ClientContext clientContext) {
		this.clientContext = clientContext;
	}
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	public ServiceDetails getServiceDetails() {
		return serviceDetails;
	}
	public void setServiceDetails(ServiceDetails serviceDetails) {
		this.serviceDetails = serviceDetails;
	}
	
	
	

}
