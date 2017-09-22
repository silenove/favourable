package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.favourable.dao.ShowGoodsDao;
import com.favourable.domain.Item;
import com.favourable.util.DBUtil;

;

public class ShowGoodsService {
	private String marketTable;

	public ShowGoodsService(String marketTable) {
		this.marketTable = marketTable;
	}

	public List<Item> showgoods() {
		Connection con = DBUtil.getConnection();
		ShowGoodsDao dbao = new ShowGoodsDao(con, marketTable);
		List<Item> bl = null;
		try {
			bl = dbao.getgoods();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}

	public boolean addGoods(Item ub) {
		Connection con = DBUtil.getConnection();
		ShowGoodsDao dbao = new ShowGoodsDao(con, marketTable);
		Item item = null;
		try {
			item = dbao.getitemByID(ub.getItemID());
			if (item != null) {
				return false;
			} else {
				dbao.addItem(ub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public boolean delGoods(int itemID) {
		Connection con = DBUtil.getConnection();
		ShowGoodsDao dbao = new ShowGoodsDao(con, marketTable);
		Item item = null;
		try {
			item = dbao.getitemByID(itemID);
			if (item == null) {
				return false;
			} else {
				dbao.delItem(itemID);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

}
