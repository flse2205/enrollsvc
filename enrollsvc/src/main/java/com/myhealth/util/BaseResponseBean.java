/**
 * 
 */
package com.myhealth.util;

/**
 * @author hshaik
 *
 */
import com.myhealth.bean.IResponse;

public abstract class BaseResponseBean implements IResponse {

	protected abstract String createResponseString();
	
}
