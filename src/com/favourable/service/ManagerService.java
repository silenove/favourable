package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.favourable.dao.ManagerDao;
import com.favourable.domain.Manager;
import com.favourable.domain.UserBean;
import com.favourable.util.DBUtil;

public class ManagerService {
	public boolean addAdmin(Manager managerBean) {

		// 1, Connection to the DB
		Connection connection = DBUtil.getConnection();

		// 2, Generate a processor
		ManagerDao managerDao = new ManagerDao(connection);

		try {
			// check whether the user has been existed
			Manager checkBean = managerDao.getByName(managerBean
					.getManagerName());
			if (checkBean != null)
				return false;
			else {
				managerDao.saveAdmin(managerBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public int ismanger(String mname) {
		Connection con = DBUtil.getConnection();
		ManagerDao userDao = new ManagerDao(con);
		try {
			Manager manager = userDao.getByName(mname);
			if (manager != null) {
				return manager.getMarketID();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
