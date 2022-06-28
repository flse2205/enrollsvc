/**
 * 
 */
package com.myhealth.service;

import com.myhealth.bean.EnrollServiceRequest;
import com.myhealth.bean.EnrollServiceResponse;

/**
 * @author hshaik
 *
 */
public interface EnrollService {

	EnrollServiceResponse invokeService(EnrollServiceRequest enrollServiceRequest);

}
