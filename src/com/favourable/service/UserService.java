package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.favourable.dao.UserDao;
import com.favourable.domain.User;
import com.favourable.domain.UserBean;
import com.favourable.util.DBUtil;

public class UserService {

	// is right passwd
	public boolean isUser(UserBean ub) {
		Connection con = DBUtil.getConnection();
		UserDao userDao = new UserDao(con);
		try {
			UserBean userBean = userDao.getUserByName(ub.getName());
			if (userBean != null) {
				if (userBean.getPass().equals(ub.getPass())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isAdmin(UserBean ub) {
		Connection con = DBUtil.getConnection();
		UserDao userDao = new UserDao(con);
		try {
			UserBean userBean = userDao.getAdminByName(ub.getName());
			if (userBean != null) {
				if (userBean.getPass().equals(ub.getPass())) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// regist
	public boolean addUser(User userBean) {

		// 1, Connection to the DB
		Connection connection = DBUtil.getConnection();

		// 2, Generate a processor
		UserDao userDao = new UserDao(connection);

		try {
			// check whether the user has been existed
			UserBean checkBean = userDao.getUserByName(userBean.getUserName());
			if (checkBean != null)
				return false;
			else {
				userDao.saveUser(userBean);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return true;
	}

	public User getUserByUserName(String userName) {
		Connection connection = DBUtil.getConnection();
		UserDao userDao = new UserDao(connection);

		User user = null;

		user = userDao.getUserByUserName(userName);

		return user;
	}

	public boolean resetUserPassword(String name, String password) {
		Connection connection = DBUtil.getConnection();
		UserDao userDao = new UserDao(connection);
		boolean flag = userDao.updatePassword(name, password);
		return flag;
	}

	public boolean confirmUser(String name, String email) {
		Connection connection = DBUtil.getConnection();
		UserDao userDao = new UserDao(connection);
		User user = userDao.getUserByUserName(name);
		if (user == null)
			return false;
		if (user.getUserName().equals(name)
				&& user.getUserEmail().equals(email))
			return true;
		else {
			return false;
		}

	}
}
