package com.citibank.enroll.customers.process.builder;

import java.io.IOException;

import com.citibank.enroll.customers.dao.exception.BusinessException;
import com.citibank.enroll.customers.dao.exception.SystemException;
import com.citibank.enroll.customers.process.model.EnrollmentProcessReq;
import com.citibank.enroll.customers.process.model.EnrollmentProcessRes;

public interface EnrollmentProcess {

	EnrollmentProcessRes enroll(EnrollmentProcessReq processReq) throws SystemException, BusinessException, IOException;
}