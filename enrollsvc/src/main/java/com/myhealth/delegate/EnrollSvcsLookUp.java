/**
 * 
 */
package com.myhealth.delegate;

import java.util.Map;
import java.util.Properties;

import com.myhealth.bean.EnrollServiceRequest;
import com.myhealth.service.BaseEnrollService;
import com.myhealth.service.EnrollService;
import com.myhealth.util.ConfigFileLoader;

/**
 * @author hshaik
 *
 */
public class EnrollSvcsLookUp implements ServiceLookUp {
	
	Map appConfig = null;
	EnrollService enrollService = null;
	Properties configProperties = null;
	/**
	 * 
	 */


	@Override
	public EnrollService getService(String svcType) {
		try {
			appConfig = ConfigFileLoader.getInstance().getAppConfig();
			configProperties = (Properties) appConfig.get("enrollsvcs");
			Class<?> loadClass = Class.forName(String.format(configProperties.getProperty(svcType)));
			Class[] parameters = new Class[1];
			parameters[0]= Properties.class;
			System.out.println(loadClass.getDeclaredConstructor(parameters));
			enrollService = (BaseEnrollService) loadClass.getDeclaredConstructor(parameters).newInstance(configProperties);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.getLocalizedMessage();
		}				
		return enrollService;
	}

}
