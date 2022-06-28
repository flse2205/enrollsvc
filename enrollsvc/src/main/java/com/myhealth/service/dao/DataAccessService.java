/**
 * 
 */
package com.myhealth.service.dao;

import java.util.Properties;

import com.myhealth.bean.EnrollServiceRequest;
import com.myhealth.bean.EnrollServiceResponse;
import com.myhealth.service.BaseEnrollService;

/**
 * @author hshaik
 *
 */
public class DataAccessService extends BaseEnrollService {
	
	EnrollSvcDBConnection enrollConnection = null;	
	EnrollServiceResponse enrollResponse = null;
	
	public DataAccessService(Properties config) {
		
		super(config);
		enrollResponse = new EnrollServiceResponse();
		
	}


	/**
	 * 
	 */
	@Override
	public EnrollServiceResponse invokeService(EnrollServiceRequest enrollServiceRequest) {

		enrollConnection = new EnrollSvcsDBConnectionImpl(config);
		enrollResponse.setId("123ABC234");
		enrollResponse.setResponseCode(200);
		enrollResponse.setDescription("OK");
		return enrollResponse;
		
	}
	
}
