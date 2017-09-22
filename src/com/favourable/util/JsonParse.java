/* created by leo
   date:2016.7.8
 */
package com.favourable.util;

import java.util.ArrayList;

import javax.servlet.http.Cookie;

public class JsonParse {
	public static ArrayList<String> jsonToList(String json) {
		ArrayList<String> lists = new ArrayList<String>();
		int len = json.length();
		int begin = 0;
		int end = len;
		for (int i = 0; i < len; i++) {
			if (json.charAt(i) == '/') {
				String temp = json.substring(begin, i);
				lists.add(temp);
				begin = i + 1;
			}
		}
		return lists;
	}

	public static String ListTojson(ArrayList<String> lists) {
		int len = lists.size();
		String json = "";
		for (int i = 0; i < len; i++) {
			json += (lists.get(i) + "/");
		}
		return json;
	}
}
