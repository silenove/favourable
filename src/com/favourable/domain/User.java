package com.favourable.domain;

import java.sql.Connection;

import com.favourable.service.AreaService;
import com.favourable.util.DBUtil;

public class User {

	private int userID;
	private String userName;
	private String userPassword;
	private String userCity;
	private int userAreaID;
	private String userBlock;
	private String userPhone;
	private String userEmail;

	public User() {
		super();
	}

	public String getAreaNameById(int id) {
		AreaService areaService = new AreaService();
		String areaName = areaService.getAreaByAreaID(id).getAreaName();
		return areaName;
	}

	public User(int userID, String userName, String userPassword,
			String userCity, int userAreaID, String userBlock,
			String userPhone, String userEmail) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userCity = userCity;
		this.userAreaID = userAreaID;
		this.userBlock = userBlock;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public int getUserAreaID() {
		return userAreaID;
	}

	public void setUserAreaID(int userAreaID) {
		this.userAreaID = userAreaID;
	}

	public String getUserBlock() {
		return userBlock;
	}

	public void setUserBlock(String userBlock) {
		this.userBlock = userBlock;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + userAreaID;
		result = prime * result
				+ ((userBlock == null) ? 0 : userBlock.hashCode());
		result = prime * result
				+ ((userCity == null) ? 0 : userCity.hashCode());
		result = prime * result
				+ ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userID;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result
				+ ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result
				+ ((userPhone == null) ? 0 : userPhone.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userAreaID != other.userAreaID)
			return false;
		if (userBlock == null) {
			if (other.userBlock != null)
				return false;
		} else if (!userBlock.equals(other.userBlock))
			return false;
		if (userCity == null) {
			if (other.userCity != null)
				return false;
		} else if (!userCity.equals(other.userCity))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userID != other.userID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userPhone == null) {
			if (other.userPhone != null)
				return false;
		} else if (!userPhone.equals(other.userPhone))
			return false;
		return true;
	}

}
