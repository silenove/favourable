package com.favourable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.favourable.domain.Area;
import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

public class AreaDao {

	private Connection connection;

	public AreaDao(Connection connection) {
		this.connection = connection;
	}

	public Area getAreaByName(String areaName) throws SQLException {
		String sql = "select * from areainfo where areaName=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, areaName);
		ResultSet resultSet = preparedStatement.executeQuery();
		Area area = null;

		while (resultSet.next()) {
			area = new Area();
			area.setAreaID(resultSet.getInt("areaID"));
			area.setAreaName(resultSet.getString("areaName"));
		}

		return area;

	}

	public Area getAreaByID(int areaID) throws SQLException {
		String sql = "select * from areainfo where areaID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setInt(1, areaID);
		ResultSet resultSet = preparedStatement.executeQuery();
		Area area = null;
		while (resultSet.next()) {
			area = new Area();
			area.setAreaID(resultSet.getInt("areaID"));
			area.setAreaName(resultSet.getString("areaName"));
		}

		return area;

	}

	public List<Area> getAllArea() throws SQLException {
		String sql = "select * from areainfo";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Area> areaList = new ArrayList<Area>();
		while (resultSet.next()) {
			Area area = new Area();
			area.setAreaID(resultSet.getInt("areaID"));
			area.setAreaName(resultSet.getString("areaName"));
			areaList.add(area);
		}

		if (areaList.size() == 0)
			return null;
		else
			return areaList;
	}

	public String getAreaID(String name) throws SQLException {
		String sql = "select * from areainfo where areaName like '%" + name
				+ "%'";
		PreparedStatement pred = connection.prepareStatement(sql);
		// pred.setString(1, name);
		ResultSet rest = pred.executeQuery();

		String areaID = "";
		while (rest.next()) {
			areaID = rest.getString("areaID");
		}
		return areaID;
	}

}
