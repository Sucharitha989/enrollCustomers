package com.citibank.enroll.customers.validator;

import com.citibank.enroll.customers.model.ClientContext;
import com.citibank.enroll.customers.model.EnrollmentResourceReq;

public class EnrollmentReqValidator {
/*@param request
@throws EnrollmentReqInvalidException*/
	
	public void validateRequest(final EnrollmentResourceReq request) throws EnrollmentReqInvalidException{
		
		//TODO: validate the rquest, if the request is valid,nothing returns
		// if the request is invalid then handle user defined exception and throws the exception
		
		if(request==null || request.getClientContext() == null || request.getCustomerInfo() == null){
			
			
			
			throw new EnrollmentReqInvalidException("enr001","request object is null or empty");
		}
		
		final ClientContext clientContext = request.getClientContext();
		if(clientContext.getClientId()==null || " ".equals(clientContext.getClientId())){
			
			throw new EnrollmentReqInvalidException("enr002","clientId is invalid");
		}
		

	if(clientContext.getChannelId()==null || " ".equals(clientContext.getChannelId())){
		
		throw new EnrollmentReqInvalidException("enr003","channelId is invalid");
	}
	//TODO: Need to write the validations for all the required elements
	
}
}