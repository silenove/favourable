package com.favourable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.favourable.domain.User;
import com.favourable.domain.UserBean;

public class UserDao {
	private Connection con;

	public UserDao(Connection con) {
		this.con = con;
	}

	public UserBean getUserByName(String name) throws SQLException {
		String sql = "select * from userinfo where userName=?";
		PreparedStatement pred = con.prepareStatement(sql);
		pred.setString(1, name);
		ResultSet rest = pred.executeQuery();
		UserBean userBean = null;
		while (rest.next()) {
			userBean = new UserBean();
			userBean.setName(rest.getString("userName"));
			userBean.setPass(rest.getString("userPassword"));
		}
		return userBean;
	}

	public UserBean getAdminByName(String name) throws SQLException {
		String sql = "select * from managerinfo where managerName=?";
		PreparedStatement pred = con.prepareStatement(sql);
		pred.setString(1, name);
		ResultSet rest = pred.executeQuery();
		UserBean userBean = null;
		while (rest.next()) {
			userBean = new UserBean();
			userBean.setName(rest.getString("managerName"));
			userBean.setPass(rest.getString("managerPassword"));
		}
		return userBean;
	}

	public void saveUser(User userBean) {

		String sql = "insert into userinfo(userName,userPassword,userCity,userAreaID,userBlock,userPhone,userEmail) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, userBean.getUserName());
			pre.setString(2, userBean.getUserPassword());
			pre.setString(3, userBean.getUserCity());
			pre.setString(4, userBean.getUserAreaID() + "");
			pre.setString(5, userBean.getUserBlock());
			pre.setString(6, userBean.getUserPhone());
			pre.setString(7, userBean.getUserEmail());
			pre.executeUpdate();
			pre.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public User getUserByUserName(String name) {
		String sql = "select * from userinfo where userName=?";
		User user = null;
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, name);
			ResultSet resultSet = pre.executeQuery();

			while (resultSet.next()) {
				user = new User();
				user.setUserID(resultSet.getInt("userID"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserPassword(resultSet.getString("userPassword"));
				user.setUserCity(resultSet.getString("userCity"));
				user.setUserAreaID(resultSet.getInt("userAreaID"));
				user.setUserBlock(resultSet.getString("userBlock"));
				user.setUserPhone(resultSet.getString("userPhone"));
				user.setUserEmail(resultSet.getString("userEmail"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;

	}

	public boolean updatePassword(String name, String password) {

		int flag = 0;
		String sql = "update userinfo set userPassword=? where userName=?";
		PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, name);
			flag = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (flag == 0) {
			return false;
		} else {
			return true;
		}

	}
}
