package com.citibank.customers.enrollment.model;

public class ClientContext {
	
	private String clientId;
	private String channelId;
	private String requestId;
	private String messageTimestamp;
	
	
	public String getClientId() {
		return clientId;
	}
	public static void setClientId(String clientId) {
		clientId = clientId;
	}
	public String getChannelId() {
		return channelId;
	}
	public static void setChannelId(String channelId) {
		channelId = channelId;
	}
	public String getRequestId() {
		return requestId;
	}
	public static void setRequestId(String requestId) {
		requestId = requestId;
	}
	public String getMessageTimestamp() {
		return messageTimestamp;
	}
	public static void setMessageTimestamp(String messageTimestamp) {
		messageTimestamp = messageTimestamp;
	}
	

}
