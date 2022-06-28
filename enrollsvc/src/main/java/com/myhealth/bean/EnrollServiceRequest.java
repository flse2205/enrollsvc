/**
 * 
 */
package com.myhealth.bean;

/**
 * @author hshaik
 *
 */
public class EnrollServiceRequest {
	
	private String token;

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return "EnrollServiceRequest [token=" + token + "]";
	}

}
