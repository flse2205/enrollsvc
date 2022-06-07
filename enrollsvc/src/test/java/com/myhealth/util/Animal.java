package com.myhealth.util;

public class Animal extends BaseResponseBean {
	
	private String gender;
	private String numberOfLimbs;
	private boolean isTwoLegged;
	
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the numberOfLimbs
	 */
	public String getNumberOfLimbs() {
		return numberOfLimbs;
	}

	/**
	 * @param numberOfLimbs the numberOfLimbs to set
	 */
	public void setNumberOfLimbs(String numberOfLimbs) {
		this.numberOfLimbs = numberOfLimbs;
	}

	/**
	 * @return the isTwoLegged
	 */
	public boolean isTwoLegged() {
		return isTwoLegged;
	}

	/**
	 * @param isTwoLegged the isTwoLegged to set
	 */
	public void setTwoLegged(boolean isTwoLegged) {
		this.isTwoLegged = isTwoLegged;
	}

	@Override
	protected String createResponseString() {
		return "{ \"" + "gender\":" + "\"" + gender + "\"," + "\"numberOfLimbs\":" + "\"" + numberOfLimbs + "\","
				+ "\"isTwoLegged\":" + "\"" + isTwoLegged + "\" }";
	}

}
