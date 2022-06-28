/**
 * 
 */
package com.myhealth.util;

/**
 * @author hshaik
 *
 */
public abstract class BaseRequestBean<T> {
	
	protected abstract T buildObjectFromString(String requestStr);

}
