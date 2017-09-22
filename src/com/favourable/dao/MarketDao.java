package com.favourable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.favourable.domain.Market;

public class MarketDao {

	Connection connection = null;

	public MarketDao(Connection connection) {
		this.connection = connection;
	}

	// 根据超市ID查询
	public Market getMarketByMarketID(int marketID) throws SQLException {
		String sql = "select * from marketinfo where marketID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, marketID);
		ResultSet resultSet = preparedStatement.executeQuery();
		Market market = null;
		while (resultSet.next()) {
			market = new Market();
			market.setMarketID(resultSet.getInt("marketID"));
			market.setMarketName(resultSet.getString("marketName"));
			market.setMarketLicense(resultSet.getString("marketLicense"));
			market.setMarketCity(resultSet.getString("marketCity"));
			int id = resultSet.getInt("marketAreaID");
			market.setMarketAreaID(id);
			sql = "select * from areainfo where areaID=" + id + "";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet1 = preparedStatement.executeQuery();
			resultSet1.next();
			market.setMarketArea(resultSet1.getString("areaName"));
			market.setMarketBlock(resultSet.getString("marketBlock"));
			market.setMarketPicture(resultSet.getString("marketPicture"));
		}
		return market;
	}

	// 根据地区ID查询
	public List<Market> getMarketByAreaID(int areaID) throws SQLException {
		String sql = "select * from marketinfo where marketAreaID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, areaID);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Market> marketList = new ArrayList<Market>();
		while (resultSet.next()) {
			Market market = new Market();
			market.setMarketID(resultSet.getInt("marketID"));
			market.setMarketName(resultSet.getString("marketName"));
			market.setMarketLicense(resultSet.getString("marketLicense"));
			market.setMarketCity(resultSet.getString("marketCity"));
			market.setMarketAreaID(resultSet.getInt("marketAreaID"));
			market.setMarketBlock(resultSet.getString("marketBlock"));
			market.setMarketPicture(resultSet.getString("marketPicture"));
			marketList.add(market);
		}
		return marketList;
	}

	// 根据超市名称模糊查询
	public List<Market> getMarketByMarketName(String marketName)
			throws SQLException {
		String sql = "select * from marketinfo" + " where marketName like '%"
				+ marketName + "%'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Market> marketList = new ArrayList<Market>();
		while (resultSet.next()) {
			Market market = new Market();
			market.setMarketID(resultSet.getInt("marketID"));
			market.setMarketName(resultSet.getString("marketName"));
			market.setMarketLicense(resultSet.getString("marketLicense"));
			market.setMarketCity(resultSet.getString("marketCity"));
			int id = resultSet.getInt("marketAreaID");
			market.setMarketAreaID(id);
			sql = "select * from areainfo where areaID=" + id + "";
			preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet1 = preparedStatement.executeQuery();
			resultSet1.next();
			market.setMarketArea(resultSet1.getString("areaName"));
			market.setMarketBlock(resultSet.getString("marketBlock"));
			market.setMarketPicture(resultSet.getString("marketPicture"));
			marketList.add(market);
		}
		return marketList;
	}

	// 查询所有超市
	public List<Market> getAllMarket() throws SQLException {
		String sql = "select * from marketinfo";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Market> marketList = new ArrayList<Market>();
		while (resultSet.next()) {
			Market market = new Market();
			market.setMarketID(resultSet.getInt("marketID"));
			market.setMarketName(resultSet.getString("marketName"));
			market.setMarketLicense(resultSet.getString("marketLicense"));
			market.setMarketCity(resultSet.getString("marketCity"));
			market.setMarketAreaID(resultSet.getInt("marketAreaID"));
			market.setMarketBlock(resultSet.getString("marketBlock"));
			market.setMarketPicture(resultSet.getString("marketPicture"));
			marketList.add(market);
		}
		return marketList;
	}

	public void saveMarket(Market userBean) {

		String sql = "insert into marketinfo(marketName,marketLicense,marketCity,marketAreaID,marketBlock,marketPicture) values(?,?,?,?,?,?)";

		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			pre.setString(1, userBean.getMarketName());
			pre.setString(2, userBean.getMarketLicense());
			pre.setString(3, userBean.getMarketCity());
			pre.setString(4, userBean.getMarketAreaID() + "");
			pre.setString(5, userBean.getMarketBlock());
			pre.setString(6, userBean.getMarketPicture());
			pre.executeUpdate();
			pre.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean createMarketTable(int marketID) {
		boolean flag = true;
		String marketTable = "market" + String.valueOf(marketID);
		String sql = "create table " + marketTable
				+ " (itemID int primary key,"
				+ "itemName varchar(20) not null,originalPrice varchar(20),"
				+ "currentPrice varchar(20)," + "discount float(20),"
				+ "product varchar(20)," + "marketID int(20) not null,"
				+ "catagory varchar(20) not null," + "itemPicture varchar(30))";

		try {
			PreparedStatement pre = connection.prepareStatement(sql);
			flag = pre.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public String getMarketID(Market marketBean) throws SQLException {
		String sql = "select * from marketinfo where marketLicense=?";
		PreparedStatement pred = connection.prepareStatement(sql);
		pred.setString(1, marketBean.getMarketLicense());
		ResultSet rest = pred.executeQuery();
		String marketIDString = null;
		while (rest.next()) {
			marketIDString = rest.getString("marketID");
		}

		return marketIDString;
	}

}
