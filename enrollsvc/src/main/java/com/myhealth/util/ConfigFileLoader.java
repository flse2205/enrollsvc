/**
 * 
 */
package com.myhealth.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.myhealth.exception.ConfigLoadFailureException;

/**
 * @author hshaik
 *
 */
public class ConfigFileLoader {

    private final static String[] propertyFiles = { "enrollsvcs.properties", "daoservice.properties" };
    
    private static ConfigFileLoader loader;
    
    private static Map<String,Properties> appConfig;


	/**
     * 
     * @return
     * @throws ConfigLoadFailureException
     */
    public synchronized static ConfigFileLoader getInstance() throws ConfigLoadFailureException {
        if(loader == null){
            loader =  new ConfigFileLoader();
        }
        return loader;
    }

    /**
     * 
     * @throws ConfigLoadFailureException
     */
    private ConfigFileLoader() throws ConfigLoadFailureException {
        if(appConfig == null){
            appConfig = loadAppConfig(propertyFiles);
        }
    }
            
    /**
	 * @return the appConfig
	 */
	public static Map<String, Properties> getAppConfig() {
		return appConfig;
	}
	
	/**
	 * 
	 * @param config
	 * @return
	 * @throws ConfigLoadFailureException 
	 */
	public Properties getAppConfigProperties(String config) throws ConfigLoadFailureException {
    	if(appConfig == null) {
    		appConfig = ConfigFileLoader.getInstance().loadAppConfig(propertyFiles);
    	}else if(appConfig.get(config) == null) {
    		appConfig.put(config, loadGlobalProperties(config+".properties"));
    	}   	
		return appConfig.get(config);
	}

	/**
	 * 
	 * @param propertyFiles
	 * @return
	 * @throws ConfigLoadFailureException
	 */
	private Map<String, Properties> loadAppConfig(String[] propertyFiles) throws ConfigLoadFailureException {
		appConfig = new HashMap<String,Properties>();
		for(String pFile: propertyFiles) {
			appConfig.put(pFile.substring(0, pFile.indexOf(".")), loadGlobalProperties(pFile));
		}
		return appConfig;
	}

	/**
     * 
     * @param absoluteFilePath
     * @return
     * @throws ConfigLoadFailureException
     */
    public Properties loadGlobalProperties(String absoluteFilePath) throws ConfigLoadFailureException {
        Properties configParams = null;
        try(InputStream ip = this.getClass().getClassLoader().getResourceAsStream(absoluteFilePath)){
            configParams = new Properties();
            if(ip == null){
                throw new ConfigLoadFailureException("Failed to load appConfig properties");
            }
            configParams.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ConfigLoadFailureException ("Exception while loading properties");
        }
        return configParams;
    }
    
    public static void main(String[] args) {
    	try {
			Map<String,Properties> props = ConfigFileLoader.getInstance().loadAppConfig(propertyFiles);
			System.out.println(props.get("enrollsvcs"));
			props.put("enrollsvcs", null);
			System.out.println(props.get("enrollsvcs"));
			System.out.println(ConfigFileLoader.getInstance().getAppConfigProperties("enrollsvcs"));
		} catch (ConfigLoadFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    
}
