package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.favourable.dao.ItemDao;
import com.favourable.dao.MarketDao;
import com.favourable.domain.Item;
import com.favourable.servlet.ShowItemDetailServelet;
import com.favourable.util.DBUtil;

public class ShowItemDetailService {
	private int ItemID;
	private int marketID;

	public ShowItemDetailService(int ItemID, int marketID) {
		this.ItemID = ItemID;
		this.marketID = marketID;
	}

	public Item showItemDetail() throws SQLException {
		Connection con = DBUtil.getConnection();
		ItemDao itemDao = new ItemDao(con, marketID);
		return itemDao.getItemByItemID(ItemID);
	}
}
