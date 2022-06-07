package com.myhealth.util;

public class ResponseBuilder<T> {
	
	public String buildResponseString(T t) {		
		Object obj = (T)t;
		BaseResponseBean respBean = (BaseResponseBean)obj;
		return respBean.createResponseString();
		
	}

}
