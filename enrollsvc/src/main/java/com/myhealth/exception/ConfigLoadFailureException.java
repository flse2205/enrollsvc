/**
 * 
 */
package com.myhealth.exception;

/**
 * @author hshaik
 *
 */
public class ConfigLoadFailureException extends Exception {

	public ConfigLoadFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConfigLoadFailureException(String message) {
		super(message);
	}

}
