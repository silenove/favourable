package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.favourable.dao.AreaDao;
import com.favourable.domain.Area;
import com.favourable.util.DBUtil;

public class ShowAreaService {

	public List<Area> showAllAreas() {

		Connection connection = DBUtil.getConnection();
		AreaDao areaDao = new AreaDao(connection);
		List<Area> areaList = new ArrayList<Area>();
		try {
			areaList = areaDao.getAllArea();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (areaList.size() == 0)
			return null;
		else {
			return areaList;
		}
	}

}
