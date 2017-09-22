package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.favourable.dao.AreaDao;
import com.favourable.domain.Area;
import com.favourable.util.DBUtil;

public class AreaService {

	public String getAreaID(String area) {

		// 1, Connection to the DB
		Connection connection = DBUtil.getConnection();

		// 2, Generate a processor
		AreaDao areaDao = new AreaDao(connection);
		String areaID = null;
		try {
			areaID = areaDao.getAreaID(area);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return areaID;
	}

	public Area getAreaByAreaID(int areaID) {
		Connection connection = DBUtil.getConnection();

		AreaDao areaDao = new AreaDao(connection);

		Area area = null;

		try {
			area = areaDao.getAreaByID(areaID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return area;
	}
}
