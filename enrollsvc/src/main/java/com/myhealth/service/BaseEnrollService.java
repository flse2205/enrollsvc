/**
 * 
 */
package com.myhealth.service;

import java.util.Properties;

import com.myhealth.bean.EnrollServiceRequest;
import com.myhealth.bean.EnrollServiceResponse;
import com.myhealth.delegate.ServiceLookUp;

/**
 * @author hshaik
 *
 */
public  abstract class BaseEnrollService implements EnrollService {

	EnrollServiceResponse enrollResponse = null;
	ServiceLookUp lookUpService = null;
	protected Properties config = null;


	/**
	 * @param config
	 */
	public BaseEnrollService(Properties config) {
		this.config = config;
	}

	/**
	 * 
	 */
	@Override
	public abstract EnrollServiceResponse invokeService(EnrollServiceRequest enrollServiceRequest) ;

}
