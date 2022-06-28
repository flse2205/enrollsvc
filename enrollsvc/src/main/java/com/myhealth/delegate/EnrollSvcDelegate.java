/**
 * 
 */
package com.myhealth.delegate;

import com.myhealth.bean.EnrollServiceRequest;
import com.myhealth.bean.EnrollServiceResponse;

/**
 * @author hshaik
 *
 */
public class EnrollSvcDelegate {
	
	private ServiceLookUp lookupSvc = new EnrollSvcsLookUp();
	private String svcType;

	/**
	 * @param svcType the svcType to set
	 */
	public void setSvcType(String svcType) {
		this.svcType = svcType;
	}
	
	/**
	 * 
	 * @param enrollServiceRequest
	 * @return
	 */
	public EnrollServiceResponse performTask(EnrollServiceRequest enrollServiceRequest) {
		return lookupSvc.getService(svcType).invokeService(enrollServiceRequest);
	}

}
