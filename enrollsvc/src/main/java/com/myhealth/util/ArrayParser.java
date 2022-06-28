/**
 * 
 */
package com.myhealth.util;

/**
 * @author hshaik
 *
 */
public class ArrayParser {
	
	public void parseRequest(String requestStr) {
		if(requestStr.startsWith("[")) {
			requestStr = requestStr.substring(1, requestStr.length() -1);
			String[] arrStr = requestStr.split("},");
			for(String str: arrStr) {
				if(!str.endsWith("}"))
					str = str.concat("}");
				System.out.println(str);
			}
		}
	}

	public static void main(String[] args) {
		String requestStr = //"[{ \"gender\":\"M\",\"numberOfLimbs\”:\”4\”}, { \"gender\”:\”F\”,\”numberOfLimbs\”:\”4\”}, { \"gender\”:\”X\”,\”numberOfLimbs\”:\”4\”}] "; 
				"[{"+ "\"gender\":\"M\",\"numberOfLimbs\":\"4\"},{"+ "\"gender\":\"F\",\"numberOfLimbs\":\"4\"},{"+"\"gender\":\"X\",\"numberOfLimbs\":\"4\""+"}]";
				
		ArrayParser arrParser =  new ArrayParser();
		arrParser.parseRequest(requestStr);

	}

}
