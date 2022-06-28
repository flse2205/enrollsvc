/**
 * 
 */
package com.myhealth.bean;

import com.myhealth.util.BaseResponseBean;

/**
 * @author hshaik
 *
 */
public class EnrollServiceResponse  extends BaseResponseBean{
	
	private String id;
	private Integer responseCode;
	private String description;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * @return the responseCode
	 */
	public Integer getResponseCode() {
		return responseCode;
	}
	
	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return " {\"id\"=" + "\""+id+"\"" + ", \"responseCode\"=" + "\""+responseCode+"\"" + ", \"description\"=" + "\""+description+"\""
				+ "}";
	}

	@Override
	protected String createResponseString() {
		// TODO Auto-generated method stub
		return this.toString().replace("=", ":");
	}

}
