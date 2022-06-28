/**
 * 
 */
package com.myhealth.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hshaik
 *
 */

public class ComplexKeyValueParser {

	public Map<String, List<String>> parseRequest(String requestStr) {
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		if(requestStr.startsWith("{")) {
			requestStr = requestStr.substring(1, requestStr.length() -1);
			while(requestStr.indexOf("],") != -1 || requestStr.endsWith("]")) {
				String keyStr =  requestStr.substring(requestStr.indexOf("\"")+1,
						requestStr.indexOf("\":"));
				System.out.println(keyStr.strip());
				String valueStr = requestStr.substring(requestStr.indexOf("["), requestStr.indexOf("]"));				
				map.put(keyStr, parseArray(valueStr));
				if(requestStr.contains("],")) {
					requestStr = requestStr.substring(requestStr.indexOf("],")+1);
				} else if(requestStr.endsWith("]")) {
					break;					
				}
				System.out.println(requestStr.indexOf("],")+1);
				
			}			
		}
		return map;

	}
	public List<String> parseArray(String requestStr) {
		List<String> listArrays = new ArrayList<String>();
		if(requestStr.startsWith("[")) {
			requestStr = requestStr.substring(1, requestStr.length() -1);
			String[] arrStr = requestStr.split("},");
			for(String str: arrStr) {
				if(!str.endsWith("}"))
					str = str.concat("}");
				listArrays.add(str);
			}
		}
		return listArrays;
	}
	public static void main(String[] args) {
		String requestStr = "{\" employees\":[{"+ "\"gender\":\"M\",\"numberOfLimbs\":\"4\"},{"+ "\"gender\":\"F\",\"numberOfLimbs\":\"4\"},{"+"\"gender\":\"X\",\"numberOfLimbs\":\"4\""+"}],"
				+ "\" dependents\":[{"+ "\"spouse\":\"RS\",\"age\":\"41\"},{"+ "\"son\":\"RaS\",\"age\":\"16\"},{"+"\"son\":\"OS\",\"age\":\"13\""+"}],"
					+"\" extDependents\":[{"+ "\"father\":\"JS\",\"age\":\"70\"},{"+ "\"grandfather\":\"PR\",\"age\":\"90\"},{"+"\"grandmother\":\"RB\",\"age\":\"85\""+"}]}";
		ComplexKeyValueParser ckvp = new ComplexKeyValueParser();
		Map<String, List<String>> requestMap = ckvp.parseRequest(requestStr);
		requestMap.forEach((strKey, listStr) ->{
			System.out.println("Key: "+strKey +"\tValue: "+listStr);
			listStr.forEach(System.out::println);
			
		});
	}
	
	

}
