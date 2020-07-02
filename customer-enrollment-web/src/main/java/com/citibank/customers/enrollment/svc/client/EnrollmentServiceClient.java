package com.citibank.customers.enrollment.svc.client;

import java.io.IOException;

import com.citibank.customers.enrollment.model.CustomerEnrollmentReq;
import com.citibank.customers.enrollment.model.EnrollmentServiceReq;
import com.citibank.customers.enrollment.model.EnrollmentServiceRes;

public interface EnrollmentServiceClient {

EnrollmentServiceRes enroll(EnrollmentServiceReq request);
}
