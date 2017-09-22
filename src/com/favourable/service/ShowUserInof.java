package com.favourable.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.favourable.dao.UserDao;
import com.favourable.dao.UserDao;
import com.favourable.domain.User;
import com.favourable.util.DBUtil;

public class ShowUserInof {
	private String userName;

	public ShowUserInof(String userName) {
		this.userName = userName;
	}

	public User getuserinfo() {
		Connection con = DBUtil.getConnection();
		UserDao udao = new UserDao(con);
		User bl = null;
		try {
			bl = udao.getUserByUserName(userName);
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bl;
	}
}
