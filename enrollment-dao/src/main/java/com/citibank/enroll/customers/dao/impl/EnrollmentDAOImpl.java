package com.citibank.enroll.customers.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.citibank.enroll.customers.dao.EnrollmentDAO;
import com.citibank.enroll.customers.dao.exception.BusinessException;
import com.citibank.enroll.customers.dao.exception.SystemException;
import com.citibank.enroll.customers.dao.model.EnrollmentDAOReq;
import com.citibank.enroll.customers.dao.model.EnrollmentDAORes;

public class EnrollmentDAOImpl implements EnrollmentDAO {
	public EnrollmentDAORes enroll(EnrollmentDAOReq daoReq) throws BusinessException, SystemException, IOException {

		
		
		System.out.println("Entered into DAOReq : " + daoReq);

		// 1.get the daoreq from the pocess layer.
		EnrollmentDAORes daoResp = null;
		try {
			
			String env = System.getProperty("env");

			System.out.println("environment is : "+env);

			String filename = "properties\\enroll-service-"+env+"-db"+".properties";
			
			System.out.println("fileName is: "+filename);
			

			InputStream input = getClass().getClassLoader().getResourceAsStream(filename);

			Properties properties = new Properties();

			properties.load(input);
			
			String dbUrl = properties.getProperty("db-url");
			
			System.out.println("db url : "+dbUrl);
			
			String username = properties.getProperty("username");
			
			System.out.println("username : "+username);
			
			String password = properties.getProperty("password");
			
			System.out.println("password : "+password);
			
			
			// 2.prepare the db req(sql or plsql)
			// 3.call db by passing db req and get the db response resultset.
		

			String respCode = "0"; // get this response from database.
			String respMsg = "Success"; // get this response from database.

			// 4.prepare the dao response.

			daoResp = new EnrollmentDAORes();
			if ("0".equals(respCode)) {

				/* EnrollmentDAORes daoResp = new EnrollmentDAORes(); */
				daoResp.setRespcode("0");
				daoResp.setRespMsg("success");
				daoResp.setDesc("good");
				daoResp.setStatus("delivered");
				daoResp.setAck("1212321232132");

			} else if ("100".equals(respCode) || "101".equals(respCode) || "102".equals(respCode)
					|| "103".equals(respCode)) {
				throw new BusinessException(respCode, respMsg);
			} else {

				throw new SystemException(respCode, respMsg);
			}
		} catch (BusinessException e) {
			// TODO : logging details
			e.printStackTrace();
			throw e;
		} catch (SystemException e) {
			// TODO : logging details
			e.printStackTrace();
			throw e;
		}
		System.out.println("Exit from DaoReq : " + daoResp);
		return daoResp;

	}
}