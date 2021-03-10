package com.citibank.enroll.customers.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.citibank.enroll.customers.dao.exception.BusinessException;
import com.citibank.enroll.customers.dao.exception.SystemException;
/*import com.citibank.enroll.customers.dao.exception.BusinessException;
import com.citibank.enroll.customers.dao.exception.SystemException;*/
import com.citibank.enroll.customers.dao.model.EnrollmentDAOReq;
import com.citibank.enroll.customers.dao.model.EnrollmentDAORes;

public interface EnrollmentDAO {

	EnrollmentDAORes enroll(EnrollmentDAOReq daoReq) throws IOException, BusinessException, SystemException, ClassNotFoundException, SQLException;

}
