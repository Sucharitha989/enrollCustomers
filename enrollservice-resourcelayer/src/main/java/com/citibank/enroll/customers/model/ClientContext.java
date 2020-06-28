package com.citibank.enroll.customers.model;

public class ClientContext {
	
	private String clientId;
	private String channelId;
	private String requestId;
	private String messageTimestamp;
	
	
	@Override
	public String toString() {
		return "ClientContext [clientId=" + clientId + ", channelId=" + channelId + ", requestId=" + requestId
				+ ", messageTimestamp=" + messageTimestamp + "]";
	}
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
