package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.favourable.dao.MarketDao;
import com.favourable.domain.Market;
import com.favourable.util.DBUtil;

public class ShowMarketService {

	public List<Market> showMarketByMarketName(String marketName) {

		Connection connection = DBUtil.getConnection();
		MarketDao marketDao = new MarketDao(connection);
		List<Market> marketList = null;
		try {
			marketList = marketDao.getMarketByMarketName(marketName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (marketList.size() == 0)
			return null;
		else
			return marketList;
	}

	public Market showMarketByMarketID(int marketID) {
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

	public List<Market> showAreaMarketByAreaID(int areaID) {
		Connection connection = DBUtil.getConnection();
		MarketDao marketDao = new MarketDao(connection);
		List<Market> marketList = null;
		try {
			marketList = marketDao.getMarketByAreaID(areaID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return marketList;
	}

}
