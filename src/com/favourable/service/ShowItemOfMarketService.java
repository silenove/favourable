package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.favourable.dao.ItemDao;
import com.favourable.domain.Item;
import com.favourable.util.DBUtil;

public class ShowItemOfMarketService {
	private int marketTable;

	public int getMarketTable() {
		return marketTable;
	}

	public void setMarketTable(int marketTable) {
		this.marketTable = marketTable;
	}

	public ShowItemOfMarketService(int marketTable) {
		this.marketTable = marketTable;
	}

	public ArrayList<Item> showItemOfMarket() throws SQLException {
		Connection connection = DBUtil.getConnection();
		ItemDao itemDao = new ItemDao(connection, marketTable);
		ArrayList<Item> items = itemDao.getMarketItem();
		return items;
	}

	public ArrayList<Item> showItemofCatagory(String catagory)
			throws SQLException {
		Connection connection = DBUtil.getConnection();
		ItemDao itemDao = new ItemDao(connection, marketTable);
		ArrayList<Item> items = itemDao.getItemByCatagory(catagory);
		return items;
	}
}
