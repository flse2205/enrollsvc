/**
 * 
 */
package com.myhealth.util;

/**
 * @author hshaik
 *
 */
import java.util.HashMap;
import java.util.Map;

public class SimpleKeyValueParser {

	Map<String, String> parseRequest(String requestStr) {
		Map<String, String> map = new HashMap<String, String>();
		String[] arrayStr = requestStr.split(",");
		for (String str : arrayStr) {
			String[] kvStr = str.split(":");
			map.put(kvStr[0], kvStr[1]);
		}
		return map;
	}

	boolean validateEntry(String key, String value) {
		if (key.startsWith("\"") && key.endsWith("\"") 
				&& value.startsWith("\"") && value.endsWith("\"")) {
			return true;
		}
		return false;

	}
}
