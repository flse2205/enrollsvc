package com.myhealth.util;

import com.myhealth.bean.IResponse;

public abstract class BaseResponseBean implements IResponse {

	protected abstract String createResponseString();
	
}
