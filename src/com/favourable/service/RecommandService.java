/*
 created by leo
 date:2016.7.6
 */
package com.favourable.service;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.DefaultEditorKit.InsertBreakAction;

import sun.misc.Compare;

import com.favourable.dao.ItemDao;
import com.favourable.dao.MarketDao;
import com.favourable.domain.Item;
import com.favourable.domain.Market;
import com.favourable.util.DBUtil;
import com.mysql.jdbc.MiniAdmin;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class RecommandService {
	HttpServletRequest request;
	HttpServletResponse response;
	final static int maxRecommandNum = 5;
	final double itemWeight = 4.0; // 商品被搜索过 *4
	final double marketWeight = 3.0; // 超市被搜索过 *3
	final double disCountWeight = 1.0; // 折扣最高
	ArrayList<Result> results = new ArrayList<Result>(); // 猜你喜欢
	ArrayList<Result> mostHotResults = new ArrayList<Result>();// 热销商品
	private Boolean isTraved = false;

	class Result implements Comparable<Result> {
		Item item;

		public Item getItem() {
			return item;
		}

		public void setItem(Item item) {
			this.item = item;
		}

		public double getRecommmandDegree() {
			return RecommmandDegree;
		}

		public void setRecommmandDegree(double recommmandDegree) {
			RecommmandDegree = recommmandDegree;
		}

		double RecommmandDegree;

		public Result(Item item, double RecommandDegree) {
			this.item = item;
			this.RecommmandDegree = RecommandDegree;
		}

		public int compareTo(Result result1) {
			if (this.getRecommmandDegree() > result1.getRecommmandDegree()) {
				return -1;
			}
			if (this.getRecommmandDegree() < result1.getRecommmandDegree()) {
				return 1;
			}
			return 0;
		}
	}

	public RecommandService(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public ArrayList<Item> getRecommandItem()
			throws UnsupportedEncodingException, SQLException {
		if (isTraved == false) {
			Traversal();
			isTraved = true;
		}
		ArrayList<Item> finalResults = new ArrayList<Item>();
		int size = results.size();
		// System.out.print("result: size is "+size+"\n");
		for (int i = 0; i < size; i++) {
			// System.out.print("results:name is "+results.get(i).getItem().getItemName()+" recommandDegree is "+results.get(i).getRecommmandDegree()+"\n");
			finalResults.add(results.get(i).getItem());
		}
		return finalResults;
	}

	public ArrayList<Item> getMostHotItem(int maxNum)
			throws UnsupportedEncodingException, SQLException {
		if (isTraved == false) {
			Traversal();
			isTraved = true;
		}
		Collections.sort(mostHotResults);
		ArrayList<Item> finalResult = new ArrayList<Item>();
		int size = mostHotResults.size();
		if (size > maxNum) {
			size = maxNum;
		}
		for (int i = 0; i < size; i++) {
			// System.out.print("sort: name is "+mostHotResults.get(i).getItem().getItemName()+" value is "+mostHotResults.get(i).RecommmandDegree+"\n");
			finalResult.add(mostHotResults.get(i).getItem());
		}
		return finalResult;
	}

	public void Traversal() throws SQLException, UnsupportedEncodingException {
		if (this.request == null) {
			System.out.print("RecommandService: request is null");
		}
		CookiesService cookiesService = new CookiesService(this.request,
				this.response);
		ArrayList<String> marketNameLists, itemNamelists;
		itemNamelists = cookiesService.getItemCookies();
		marketNameLists = cookiesService.getMarketCookies();
		Connection connection = DBUtil.getConnection();
		MarketDao marketDao = new MarketDao(connection);
		ArrayList<Market> markets = (ArrayList<Market>) marketDao
				.getAllMarket();
		int marketSize = markets.size();
		for (Market market : markets) { // 遍历所有超市
			int marketID = market.getMarketID();
			String marketName = market.getMarketName();
			ItemDao itemDao = new ItemDao(connection, marketID);
			ArrayList<Item> items = itemDao.getMarketItem();
			for (Item item : items) { // 遍历超市所有商品
				String itemName = item.getItemName();
				double discount = item.getDiscount1();
				double recommandDegree = discount;
				if (marketIsSearched(marketNameLists, marketName) == true) {
					recommandDegree *= marketWeight;
				}
				if (itemIsSearched(itemNamelists, itemName)) {
					recommandDegree *= itemWeight;
				}
				// System.out.print("name is "+itemName+" recommandDegree is "+recommandDegree+"\n");
				Result result = new Result(item, recommandDegree);
				insertToResult(result);
				Result mostHotResult = new Result(item, discount);
				mostHotResults.add(mostHotResult);
			}
		}
	}

	boolean itemIsSearched(ArrayList<String> itemNameLists, String name) {
		if (itemNameLists == null) {
			return false;
		}
		int size = itemNameLists.size();
		for (int i = 0; i < size; i++) {
			String temp = itemNameLists.get(i);
			// if(temp.equals("鼠标")){
			// System.out.print("recommand: name is "+name+" equal:"+name.contains(temp)+"\n");
			// }
			if (name.contains(temp)) {
				return true;
			}
		}
		return false;
	}

	boolean marketIsSearched(ArrayList<String> marketNameLists, String name) {

		if (marketNameLists == null) { // cookies为空
			return false;
		}
		int size = marketNameLists.size();
		for (int i = 0; i < size; i++) {
			String temp = marketNameLists.get(i);
			if (temp.contains(name)) {
				return true;
			}
		}
		return false;
	}

	public void insertToResult(Result result) {
		double minDegree = 10000.0;
		int minIndex = 0;
		int size = results.size();
		for (int i = 0; i < size; i++) {
			Result result1 = results.get(i);
			double recommmandDegree1 = result1.getRecommmandDegree();
			if (recommmandDegree1 < minDegree) {
				minDegree = recommmandDegree1;
				minIndex = i;
			}
			// System.out.print("result: name is "+itemName+" recommandDegree1 is "+recommmandDegree1+" i= "+i+"\n");
		}
		// System.out.print("minDegree is "+minDegree+" minIndex= "+minIndex+"\n");
		// System.out.print("insert: size is "+size+"\n");
		if (size >= maxRecommandNum) {
			if (result.getRecommmandDegree() > minDegree) {
				results.remove(minIndex);
				results.add(result);
			}
		} else {
			// System.out.print("insert: has inserted one record");
			results.add(result);
		}
	}
}
