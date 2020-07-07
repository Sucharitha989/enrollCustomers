package com.citibank.cardverify.service.client.impl;

import com.citibank.cardverify.service.client.CardVerifyServiceClient;
import com.citibank.cardverify.service.client.model.CardVerifyServiceClientReq;
import com.citibank.cardverify.service.client.model.CardVerifyServiceClientRes;

public class CardVerifyServiceClientImpl implements CardVerifyServiceClient {

	public CardVerifyServiceClientRes enroll(CardVerifyServiceClientReq clientReq) {
		
		System.out.println("Entered into card service : "+ clientReq);
		
			CardVerifyServiceClientRes clientResp = new CardVerifyServiceClientRes();
			
			clientResp.setActive(true);
			clientResp.setRespCode("0");
			clientResp.setRespMsg("success");
			clientResp.setStatus("valid");
		
			System.out.println("exit from card service : "+ clientResp);
		return clientResp;
	}
	
	
}

