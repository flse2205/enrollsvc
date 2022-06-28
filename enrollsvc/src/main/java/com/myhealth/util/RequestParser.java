/**
 * 
 */
package com.myhealth.util;

/**
 * @author hshaik
 *
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RequestParser {
	
	 Map<String, String> parseRequest(String requestStr) {
			
			Map< String, String> map = new HashMap<String, String>();
			Pattern keyRegex = Pattern.compile("\"*\":\"{*}\"");
			//Pattern valueRegex = Pattern.compile("\"{*}\"");
			List list = new ArrayList();
			Matcher m = keyRegex.matcher(requestStr);
			int count=0;
			while(m.find()) {
				count++;
				System.out.println(m.group());
				
			}
			
			String[] arrayStr = requestStr.split(",");
			for(String str : arrayStr) {
				map.put(str.substring(0, str.indexOf(":")-1), str.substring(str.indexOf(":"),str.length()-1));				
			}
			
			return map;
		}
	 
	 public void getRegexString(String requestStr) {
		 //Pattern keyRegex = Pattern.compile("\"[a-zA-Z0-9]{0,}\"");
		 //Pattern valueRegex = Pattern.compile("\\{([^}]*.?)\\}"); 
		 
		 //String keyRegex = "\"[a-zA-Z0-9]{1}\"";
		 String valueRegex = "\\{([^}]*.?)\\}";
		 
		 //Pattern keypattern = Pattern.compile(keyRegex);
		 Pattern pattern = Pattern.compile(valueRegex);
		 Matcher keyMatcher = pattern.matcher(requestStr.substring(1));
		 //Matcher valueMatcher = pattern.matcher(requestStr.substring(1));
		 int count=0;

		while(keyMatcher.find()) {
			count++;
			System.out.println(requestStr.substring(requestStr.indexOf("\""), requestStr.indexOf(":")));
			requestStr = requestStr.substring(requestStr.indexOf(":"), requestStr.lastIndexOf("\""));
			System.out.println(keyMatcher.group());
			System.out.println(requestStr);
			System.out.println(count);
			if(requestStr.indexOf("},") != -1) {
				requestStr = requestStr.substring(requestStr.indexOf("},"));
				System.out.println(requestStr);
				
			}		
		}
	 }
	 
	 public static void main(String[] str) {
		 RequestParser parser = new RequestParser();
		 String //requestStr = "{ \"gender\":\"M\",\"numberOfLimbs\":\"4\",\"isTwoLegged\":\"true\" }";
		 //requestStr = "{\"employee\":\"{ \"gender\":\"M\",\"numberOfLimbs\":\"4\"}\"}";
		 requestStr = "{\"employee\":\"{ \"gender\":\"M\",\"numberOfLimbs\":\"4\"}\"}";
		 /* String[] strArr= requestStr.split("\\{([^}]*.?)\\}");
		 for(String strn : strArr) {
			 System.out.println(strn);
		 }*/
		 parser.getRegexString(requestStr);
		 
		 //requestStr = validateRequest(requestStr);
		// requestStr = requestStr.substring(1, requestStr.length()-1);
		 //requestStr = requestStr.replace("\"", "");
		 //Map<String, String> map = parser.parseRequest(requestStr);
		 /*for(Map.Entry<String, String> entry: parser.parseRequest(requestStr).entrySet()) {
			 System.out.println(entry.getKey().strip() +":"+ entry.getValue().strip());
		 }*/
	 }

	private static String validateRequest(String requestStr) {
		/* TODO Auto-generated method stub
		   check the root tags. 
		   split the root elements.
		   check the child tags.
		   check the child elements for correctness.
		   Use pattern matches to validate the strings.
		*/
		
		return null;
	}

}
