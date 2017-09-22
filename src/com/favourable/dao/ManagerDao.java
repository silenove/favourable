package com.favourable.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.favourable.domain.Manager;

public class ManagerDao {
	private Connection con;

	public ManagerDao(Connection con) {
		this.con = con;
	}

	public void saveAdmin(Manager managerBean) {
		String sql = "insert into managerinfo(managerName,managerPassword,managerPhone,managerEmail,marketID) values(?,?,?,?,?)";
		try {
			PreparedStatement pre = con.prepareStatement(sql);
			pre.setString(1, managerBean.getManagerName());
			pre.setString(2, managerBean.getManagerPassword());
			pre.setString(3, managerBean.getManagerPhone());
			pre.setString(4, managerBean.getManagerEmail());
			pre.setString(5, managerBean.getMarketID() + "");
			pre.executeUpdate();
			pre.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Manager getByName(String managerName) throws SQLException {
		String sql = "select * from managerinfo where managerName = ?";
		PreparedStatement pred = con.prepareStatement(sql);
		pred.setString(1, managerName);
		ResultSet rest = pred.executeQuery();
		Manager manager = null;
		while (rest.next()) {
			manager = new Manager();
			manager.setManagerName(rest.getString("managerName"));
			manager.setManagerPassword(rest.getString("managerPassword"));
			manager.setMarketID(rest.getInt("marketID"));
		}
		pred.close();
		return manager;
	}
}
