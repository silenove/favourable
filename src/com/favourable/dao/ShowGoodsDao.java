package com.favourable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.favourable.domain.Item;

public class ShowGoodsDao {
	private Connection con;
	private String marketTable;

	public ShowGoodsDao(Connection con, String marketTable) {
		this.con = con;
		this.marketTable = marketTable;
	}

	public List<Item> getgoods() throws SQLException {
		String sql = "select * from " + marketTable;
		PreparedStatement pred = con.prepareStatement(sql);
		ResultSet rest = pred.executeQuery();
		List<Item> buliderList = new ArrayList<Item>();
		while (rest.next()) {
			Item bd = new Item();
			bd.setItemID(rest.getInt("ItemID"));
			bd.setItemName(rest.getString("ItemName"));
			bd.setOriginalPrice(rest.getString("OriginalPrice"));
			bd.setCurrentPrice(rest.getString("CurrentPrice"));
			bd.setDiscount(rest.getFloat("Discount"));
			bd.setProduct(rest.getString("Product"));
			bd.setMarketID(rest.getInt("MarketID"));
			bd.setCatagory(rest.getString("catagory"));
			bd.setItemPicture(rest.getString("itemPicture"));
			buliderList.add(bd);
		}
		pred.close();
		return buliderList;
	}

	public void addItem(Item ub) throws SQLException {
		String sql = "insert into " + marketTable
				+ " values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pred = con.prepareStatement(sql);
		pred.setInt(1, ub.getItemID());
		pred.setString(2, ub.getItemName());
		pred.setString(3, ub.getOriginalPrice());
		pred.setString(4, ub.getCurrentPrice());
		pred.setFloat(5, ub.getDiscount());
		pred.setString(6, ub.getProduct());
		pred.setInt(7, ub.getMarketID());
		pred.setString(8, ub.getCatagory());
		pred.setString(9, ub.getItemPicture());
		pred.executeUpdate();
		pred.close();
	}

	public void delItem(int itemID) throws SQLException {
		String sql = "delete from " + marketTable + " where itemID =";
		sql = sql + Integer.toString(itemID);
		PreparedStatement pred = con.prepareStatement(sql);
		pred.executeUpdate();
		pred.close();
	}

	public Item getitemByID(int itemID) throws SQLException {
		String sql = "select * from " + marketTable + " where itemID = ?";
		PreparedStatement pred = con.prepareStatement(sql);
		pred.setString(1, Integer.toString(itemID));
		ResultSet rest = pred.executeQuery();
		Item item = null;
		while (rest.next()) {
			item = new Item();
			item.setItemID(rest.getInt("itemID"));
			item.setItemName(rest.getString("itemName"));
			item.setOriginalPrice(rest.getString("originalPrice"));
			item.setCurrentPrice(rest.getString("currentPrice"));
			item.setDiscount(rest.getFloat("discount"));
			item.setProduct(rest.getString("product"));
			item.setMarketID(rest.getInt("marketID"));
			item.setCatagory(rest.getString("catagory"));
			item.setItemPicture(rest.getString("itemPicture"));
		}
		pred.close();
		return item;
	}

	public int getmarketIDbymanager(int managerID) throws SQLException {
		String sql = "select marketID from managerinfo where m = ?";
		PreparedStatement pred = con.prepareStatement(sql);
		pred.setString(1, Integer.toString(managerID));
		ResultSet rest = pred.executeQuery();
		int market = 0;
		while (rest.next()) {
			// item = new Item();
			// item.setItemID(rest.getInt("itemID"));
			// item.setItemName(rest.getString("itemName"));
			// item.setOriginalPrice(rest.getString("originalPrice"));
			// item.setCurrentPrice(rest.getString("currentPrice"));
			// item.setDiscount(rest.getFloat("discount"));
			// item.setProduct(rest.getString("product"));
			// item.setMarketID(rest.getInt("marketID"));
			// item.setCatagory(rest.getString("catagory"));
			// item.setItemPicture(rest.getString("itemPicture"));
			market = rest.getInt("marketID");
			String markettable = "market" + Integer.toString(market);

		}
		pred.close();
		return market;
	}

}
