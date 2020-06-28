package com.citibank.customers.enrollment.model;

public class ServiceDetails {
private String serviceName;
private String apiName;
private String version;

public String getServiceName() {
	return serviceName;
}
public void setServiceName(String serviceName) {
	this.serviceName = serviceName;
}
public String getapiName() {
	return apiName;
}
public void setapiName(String apiName) {
	this.apiName = apiName;
}
public String getVersion() {
	return version;
}
public void setVersion(String version) {
	this.version = version;
}
@Override
public String toString() {
	return "ServiceDetails [serviceName=" + serviceName + ", apiName=" + apiName + ", version=" + version + "]";
}



}
