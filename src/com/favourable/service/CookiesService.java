/*
 created by leo
 date:2016.7.8
 */

package com.favourable.service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

import com.favourable.domain.Item;
import com.favourable.util.JsonParse;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class CookiesService {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public CookiesService(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		this.request = request;
		this.response = response;
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	}

	public void setMarketCookies(String name, int maxNum)
			throws UnsupportedEncodingException {
		String json = "";
		ArrayList<String> cookieList;
		cookieList = getMarketCookies();
		if (cookieList != null) {
			if (cookieList.size() >= maxNum) {
				cookieList.remove(0);
			}
		}
		cookieList.add(name);
		json = JsonParse.ListTojson(cookieList);

		System.out.print("set market:json-utf8 is " + json + "\n");
		json = new String(json.getBytes("utf-8"), "ISO-8859-1");
		System.out.print("set market:json-iso is " + json + "\n");

		Cookie cookie = new Cookie("marketHistory", json);
		response.addCookie(cookie);
	}

	public ArrayList<String> getMarketCookies()
			throws UnsupportedEncodingException {
		ArrayList<String> marketLists = new ArrayList<String>();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) { // 前面有*表示market，否则表示item,最后加上/
			if ("marketHistory".equals(cookie.getName())) {
				String json = cookie.getValue();

				System.out.print("get market:json-iso is " + json + "\n");
				json = new String(json.getBytes("ISO-8859-1"), "utf-8");
				System.out.print("get market:json-utf is " + json + "\n");

				marketLists = JsonParse.jsonToList(json);
			}
		}
		return marketLists;
	}

	public void setItemCookies(String name, int maxNum)
			throws UnsupportedEncodingException {
		String json = "";
		ArrayList<String> cookieList;
		cookieList = getItemCookies();
		if (cookieList.size() >= maxNum) {
			cookieList.remove(0);
		}
		cookieList.add(name);
		json = JsonParse.ListTojson(cookieList);

		System.out.print("set item:json-utf8 is " + json + "\n");
		json = new String(json.getBytes("utf-8"), "ISO-8859-1");
		System.out.print("set item:json-iso is " + json + "\n");

		Cookie cookie = new Cookie("itemHistory", json);
		response.addCookie(cookie);
	}

	public ArrayList<String> getItemCookies()
			throws UnsupportedEncodingException {
		if (request == null) {
			System.out.print("result is null");
		}
		ArrayList<String> itemLists = new ArrayList<String>();
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) { // 前面有*表示market，否则表示item,最后加上/
			if ("itemHistory".equals(cookie.getName())) {
				String json = cookie.getValue();

				System.out.print("get item:json-iso is " + json + "\n");
				json = new String(json.getBytes("ISO-8859-1"), "utf-8");
				System.out.print("get item:json-utf is " + json + "\n");

				itemLists = JsonParse.jsonToList(json);
			}
		}
		return itemLists;
	}

}
