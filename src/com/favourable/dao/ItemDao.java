package com.favourable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.favourable.domain.Item;
import com.favourable.domain.Market;

import java.util.ArrayList;
import java.util.List;

public class ItemDao {

	private Connection connection;
	private String marketTable;

	// 构造函数包括数据库连接、超市ID
	public ItemDao(Connection connection, int marketTable) {
		this.connection = connection;
		this.marketTable = "market" + String.valueOf(marketTable);
	}

	// 根据商品ID查询商品
	public Item getItemByItemID(int itemID) throws SQLException {
		String sql = "select * from " + marketTable + " where itemID=" + itemID;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		Item item = null;
		while (resultSet.next()) {
			item = new Item();
			item.setItemID(resultSet.getInt("itemID"));
			item.setItemName(resultSet.getString("itemName"));
			item.setOriginalPrice(resultSet.getString("originalPrice"));
			item.setCurrentPrice(resultSet.getString("currentPrice"));
			item.setDiscount(resultSet.getFloat("discount"));
			item.setProduct(resultSet.getString("product"));

			int id = resultSet.getInt("marketID");
			item.setMarketID(id);
			sql = "select * from marketinfo where marketID=" + id + "";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet1 = preparedStatement.executeQuery();
			resultSet1.next();
			item.setMarketName(resultSet1.getString("marketName"));

			MarketDao marketDao = new MarketDao(connection);
			Market market = marketDao.getMarketByMarketID(id);
			String adderss = market.getMarketCity() + market.getMarketArea()
					+ market.getMarketBlock() + "";
			item.setMarketAddress(adderss);
			item.setCatagory(resultSet.getString("catagory"));
			item.setItemPicture(resultSet.getString("itemPicture"));
		}
		return item;
	}

	// 查询超市内所有商品
	public ArrayList<Item> getMarketItem() throws SQLException {
		String sql = "select * from " + marketTable + "";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Item> itemList = new ArrayList<Item>();
		while (resultSet.next()) {
			Item item = new Item();
			item.setItemID(resultSet.getInt("itemID"));
			item.setItemName(resultSet.getString("itemName"));
			item.setOriginalPrice(resultSet.getString("originalPrice"));
			item.setCurrentPrice(resultSet.getString("currentPrice"));
			item.setDiscount(resultSet.getFloat("discount"));
			item.setProduct(resultSet.getString("product"));
			item.setMarketID(resultSet.getInt("marketID"));
			item.setCatagory(resultSet.getString("catagory"));
			item.setItemPicture(resultSet.getString("itemPicture"));
			itemList.add(item);
		}
		return itemList;
	}

	// 根据商品名称模糊查询
	public List<Item> getItemByItemName(String itemName1) throws SQLException {
		String sql = "select * from " + marketTable + " where itemName like '%"
				+ itemName1 + "%'";
		// String
		// sql="select * from "+marketTable+" where itemName='"+itemName1+"'";
		// ? 的坑大大的
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		// preparedStatement.setString(1, marketTable);
		// preparedStatement.setString(2, itemName);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Item> itemList = new ArrayList<Item>();
		while (resultSet.next()) {
			Item item = new Item();
			item.setItemID(resultSet.getInt("itemID"));
			item.setItemName(resultSet.getString("itemName"));
			item.setOriginalPrice(resultSet.getString("originalPrice"));
			item.setCurrentPrice(resultSet.getString("currentPrice"));
			item.setDiscount(resultSet.getFloat("discount"));
			item.setProduct(resultSet.getString("product"));
			int id = resultSet.getInt("marketID");
			item.setMarketID(id);
			item.setCatagory(resultSet.getString("catagory"));
			item.setItemPicture(resultSet.getString("itemPicture"));

			// add by leo,2016.7.4
			sql = "select * from marketinfo where marketID=" + id + "";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			item.setMarketName(resultSet.getString("marketName"));
			itemList.add(item);
		}
		return itemList;
	}

	public ArrayList<Item> getItemByCatagory(String catagory)
			throws SQLException {
		String sql = "select * from " + marketTable + " where catagory=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, catagory);
		ResultSet resultSet = preparedStatement.executeQuery();
		ArrayList<Item> lists = new ArrayList<Item>();
		while (resultSet.next()) {
			Item item = new Item();
			item.setItemID(resultSet.getInt("itemID"));
			item.setItemName(resultSet.getString("itemName"));
			item.setOriginalPrice(resultSet.getString("originalPrice"));
			item.setCurrentPrice(resultSet.getString("currentPrice"));
			item.setDiscount(resultSet.getFloat("discount"));
			item.setProduct(resultSet.getString("product"));
			item.setMarketID(resultSet.getInt("marketID"));
			item.setCatagory(resultSet.getString("catagory"));
			item.setItemPicture(resultSet.getString("itemPicture"));
			lists.add(item);

		}
		return lists;
	}

}
