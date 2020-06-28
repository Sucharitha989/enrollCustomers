package com.citibank.cardverify.service.client;

import com.citibank.cardverify.service.client.model.CardVerifyServiceClientReq;
import com.citibank.cardverify.service.client.model.CardVerifyServiceClientRes;

public interface CardVerifyServiceClient {
	CardVerifyServiceClientRes enroll(CardVerifyServiceClientReq clientReq);
	}