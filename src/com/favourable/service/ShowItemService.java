package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.favourable.dao.ItemDao;
import com.favourable.dao.MarketDao;
import com.favourable.domain.Item;
import com.favourable.domain.Market;
import com.favourable.util.DBUtil;

public class ShowItemService {

	public List<Item> showItemByItemName(String itemName) {

		Connection connection = DBUtil.getConnection();
		MarketDao marketDao = new MarketDao(connection);
		List<Item> itemList = new ArrayList<Item>();
		try {
			List<Market> marketList = marketDao.getAllMarket();
			for (Market market : marketList) {
				ItemDao itemDao = new ItemDao(connection, market.getMarketID());
				List<Item> items = itemDao.getItemByItemName(itemName);
				for (Item item : items) {
					itemList.add(item);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (itemList.size() == 0)
			return null;
		else
			return itemList;
	}

	public List<Item> showMarketItem(int marketID) {

		Connection connection = DBUtil.getConnection();
		ItemDao itemDao = new ItemDao(connection, marketID);
		List<Item> itemList = null;
		try {
			itemList = itemDao.getMarketItem();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return itemList;
	}

}
