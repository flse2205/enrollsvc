/**
 * 
 */
package com.myhealth.servlet;

import com.myhealth.bean.EnrollServiceRequest;

/**
 * @author hshaik
 *
 */
public class RequestBuilder {
	
	
	/**
	 * 
	 * @param token
	 * @return
	 */
	public EnrollServiceRequest buildRequest(String token) {
		EnrollServiceRequest request = new EnrollServiceRequest();
		request.setToken(token);
		return request;
	}

}
