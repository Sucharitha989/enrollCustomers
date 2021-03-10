package com.citibank.enroll.customers.dao.impl;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.citibank.enroll.customers.dao.EnrollmentDAO;
import com.citibank.enroll.customers.dao.exception.BusinessException;
import com.citibank.enroll.customers.dao.exception.SystemException;
import com.citibank.enroll.customers.dao.model.EnrollmentDAOReq;
import com.citibank.enroll.customers.dao.model.EnrollmentDAORes;


public class EnrollmentDAOImpl implements EnrollmentDAO {
	public EnrollmentDAORes enroll(EnrollmentDAOReq daoReq) throws BusinessException,SystemException, IOException, ClassNotFoundException, SQLException {

		
		
		System.out.println("Entered into DAOReq : " + daoReq);

		// 1.get the daoreq from the pocess layer.
		EnrollmentDAORes daoResp = null;
		try {
			
			
			  String env = System.getProperty("env");
			  
			  System.out.println("environment is : "+env);
			  
			  String filename = "properties\\enroll-"+env+"-db"+".properties";
			  
			  System.out.println("fileName is: "+filename);
			  
			  InputStream input=getClass().getClassLoader().getResourceAsStream(filename);

			  Properties properties = new Properties();
			  
			  properties.load(input);
			  
			  String dbUrl = properties.getProperty("db-url");
			  
			
			  String username = properties.getProperty("username");
			  
			  	  
			  String password = properties.getProperty("password");
			  
		
			 
			   
				
					Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(dbUrl, username, password);
				
			   String sql = "{ call ENROLLMENT-DETAILS(?,?,?,?,?,?,?,?,?) }";
			 
				con.prepareCall(sql);
		
				CallableStatement csmt = con.prepareCall(sql);
			
			   csmt.setString(1, daoReq.getClientId());
			   csmt.setString(2, daoReq.getChannelId());
			   csmt.setString(3, daoReq.getCardNum());
			   csmt.setString(4, daoReq.getCvvNum());
			   csmt.setString(5, daoReq.getExpDate());
			   
			   csmt.registerOutParameter("STATUS-CODE", 6);
			   csmt.registerOutParameter("STATUS-MSG", 7);
			   csmt.registerOutParameter("ENROLLMENT-NUM", 8);
			   
			   
			// 2.prepare the db req(sql or plsql)
			// 3.call db by passing db req and get the db response resultset.
		
            boolean b = csmt.execute();
			ResultSet rs =   csmt.executeQuery();
			String respCode = csmt.getString(6); //status code

			String respMsg = csmt.getString(7);  //status msg

			   
			   
			// String respCode= "0"; // get this response from database.
			// String respMsg = "Success"; // get this response from database.

			// 4.prepare the dao response.

			daoResp  = new EnrollmentDAORes();
			
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
			}
			else {

				throw new SystemException(respCode, respMsg);
			}
		} 
			  catch (BusinessException e) {
				  e.printStackTrace();
			  throw e; 
			  }
			  catch (SystemException e) {
			// TODO : logging details
			e.printStackTrace();
			throw e;
		}
		System.out.println("Exit from DaoReq : " + daoResp);
		return daoResp;

	}
}