package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.favourable.dao.MarketDao;
import com.favourable.domain.Market;
import com.favourable.util.DBUtil;

public class MarketService {

	public boolean addMarket(Market marketBean) {

		// 1, Connection to the DB
		Connection connection = DBUtil.getConnection();

		// 2, Generate a processor
		MarketDao marketDao = new MarketDao(connection);

		marketDao.saveMarket(marketBean);

		return true;
	}

	public String getMarketID(Market marketBean) {

		Connection connection = DBUtil.getConnection();
		MarketDao marketDao = new MarketDao(connection);
		String marketIDString = null;
		try {
			marketIDString = marketDao.getMarketID(marketBean);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return marketIDString;
	}

	public boolean createMarketTable(int marketID) {

		Connection connection = DBUtil.getConnection();
		MarketDao marketDao = new MarketDao(connection);

		boolean flag = true;
		flag = marketDao.createMarketTable(marketID);
		return flag;
	}

	public Market getMarketByMarketID(int marketID) {
		Connection connection = DBUtil.getConnection();
		MarketDao marketDao = new MarketDao(connection);
		Market market = null;
		try {
			market = marketDao.getMarketByMarketID(marketID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return market;

	}

}
