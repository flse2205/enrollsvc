/**
 * 
 */
package com.myhealth.delegate;

import com.myhealth.service.EnrollService;

/**
 * @author hshaik
 *
 */
public interface ServiceLookUp {

	EnrollService getService(String svcType);

}
