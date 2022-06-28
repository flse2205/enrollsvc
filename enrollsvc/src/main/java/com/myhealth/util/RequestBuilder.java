/**
 * 
 */
package com.myhealth.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hshaik
 *
 */
public class RequestBuilder<T, K, V> {
	
	public T buildRequest(String requestStr) {
				
		if(requestStr.startsWith("{")) {
			return  parseRequest(requestStr);
			
		}		
		return null;
		
	}

	private T parseRequest(String requestStr) {
		
		Map< String, String> map = new HashMap<String, String>();
		String[] arrayStr = requestStr.split(",");
		for(String str : arrayStr) {
			String[] kvStr = str.split(":");
			map.put(kvStr[0], kvStr[1]);
		}
		
		return null;
	}

	private Map<K, V> parseRequest(String requestStr, Map<K,V> map) {
		
		
		 /*else if(requestStr.startsWith("[")) {
		
		T t = null;
		
	}*/

	/* Map<K,V> map = new HashMap<K,V>();
	map = parseRequest(requestStr, map);	*/	
		return null;
	}

}
