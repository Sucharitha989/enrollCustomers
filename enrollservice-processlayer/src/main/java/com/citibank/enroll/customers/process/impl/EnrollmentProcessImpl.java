
package com.citibank.enroll.customers.process.impl;

import java.io.IOException;

import com.citibank.cardverify.service.client.CardVerifyServiceClient;
import com.citibank.cardverify.service.client.impl.CardVerifyServiceClientImpl;
import com.citibank.cardverify.service.client.model.CardVerifyServiceClientReq;
import com.citibank.cardverify.service.client.model.CardVerifyServiceClientRes;
import com.citibank.enroll.customers.dao.EnrollmentDAO;
import com.citibank.enroll.customers.dao.exception.BusinessException;
import com.citibank.enroll.customers.dao.exception.SystemException;
import com.citibank.enroll.customers.dao.impl.EnrollmentDAOImpl;
import com.citibank.enroll.customers.dao.model.EnrollmentDAOReq;
import com.citibank.enroll.customers.dao.model.EnrollmentDAORes;
import com.citibank.enroll.customers.process.builder.EnrollmentProcess;
import com.citibank.enroll.customers.process.builder.EnrollmentProcessReqBuilder;
import com.citibank.enroll.customers.process.builder.EnrollmentProcessRespBuilder;
import com.citibank.enroll.customers.process.model.EnrollmentProcessReq;
import com.citibank.enroll.customers.process.model.EnrollmentProcessRes;

public class EnrollmentProcessImpl implements EnrollmentProcess{

	public EnrollmentProcessRes enroll(EnrollmentProcessReq processReq) throws BusinessException, SystemException, IOException  {
		
		System.out.println("Entered into the process layer: "+processReq);
		//1
		//2
		
		CardVerifyServiceClientReq clientReq =new CardVerifyServiceClientReq();
		clientReq.setClientId(processReq.getClientId());
		clientReq.setChannelId(processReq.getChannelId());
		clientReq.setCardNum(processReq.getCardNum());
		clientReq.setCvvNum(processReq.getCvvNum());
		clientReq.setExpDate(processReq.getExpDate());
		clientReq.setNameOnCard(processReq.getNameOnCard());
	
		//3
		CardVerifyServiceClient svcClient = new CardVerifyServiceClientImpl();
		CardVerifyServiceClientRes clientResp = svcClient.enroll(clientReq);
		
		EnrollmentDAORes daoResp = null;
		
		if("0".equals(clientResp.getRespCode())){
			
			EnrollmentDAOReq daoReq = new EnrollmentDAOReq();
			
			daoReq.setClientId(processReq.getClientId());
			daoReq.setChannelId(processReq.getChannelId());
			daoReq.setCardNum(processReq.getCardNum());
			daoReq.setCvvNum(processReq.getCvvNum());
			daoReq.setExpDate(processReq.getExpDate());
			daoReq.setNameOnCard(processReq.getNameOnCard());
		
			EnrollmentDAO dao = new EnrollmentDAOImpl();
			
			daoResp = dao.enroll(daoReq);
		}else{
			
		}
		
		//6
		EnrollmentProcessRes processResp = new EnrollmentProcessRes();
		
		processResp.setRespCode(daoResp.getRespCode());
		processResp.setRespMsg(daoResp.getRespMsg());
		processResp.setStatus(daoResp.getStatus());
		processResp.setDesc(daoResp.getDesc());
	  
		System.out.println("Exit from the process layer: "+processReq);
		
		return processResp;




}

}
