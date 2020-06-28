package com.citibank.enroll.customers.model;

public class ServiceDetails {
private String serviceName;
private String apiName;
private String version;

@Override
public String toString() {
	return "ServiceDetails [serviceName=" + serviceName + ", apiName=" + apiName + ", version=" + version + "]";
}
public String getServiceName() {
	return serviceName;
}
public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}
public String getApiName() {
	return apiName;
}
public void setApiName(String apiName) {
	this.apiName = apiName;
}
public String getVersion() {
	return version;
}
public void setVersion(String version) {
	this.version = version;
}



}
