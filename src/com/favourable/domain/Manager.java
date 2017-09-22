package com.favourable.domain;

public class Manager {

	private int managerID;
	private String managerName;
	private String managerPassword;
	private String managerPhone;
	private String managerEmail;
	private int marketID;

	public Manager() {
		super();
	}

	public Manager(int managerID, String managerName, String managerPassword,
			String managerPhone, String managerEmail, int marketID) {
		super();
		this.managerID = managerID;
		this.managerName = managerName;
		this.managerPassword = managerPassword;
		this.managerPhone = managerPhone;
		this.managerEmail = managerEmail;
		this.marketID = marketID;
	}

	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPassword() {
		return managerPassword;
	}

	public void setManagerPassword(String managerPassword) {
		this.managerPassword = managerPassword;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public int getMarketID() {
		return marketID;
	}

	public void setMarketID(int marketID) {
		this.marketID = marketID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((managerEmail == null) ? 0 : managerEmail.hashCode());
		result = prime * result + managerID;
		result = prime * result
				+ ((managerName == null) ? 0 : managerName.hashCode());
		result = prime * result
				+ ((managerPassword == null) ? 0 : managerPassword.hashCode());
		result = prime * result
				+ ((managerPhone == null) ? 0 : managerPhone.hashCode());
		result = prime * result + marketID;
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
		Manager other = (Manager) obj;
		if (managerEmail == null) {
			if (other.managerEmail != null)
				return false;
		} else if (!managerEmail.equals(other.managerEmail))
			return false;
		if (managerID != other.managerID)
			return false;
		if (managerName == null) {
			if (other.managerName != null)
				return false;
		} else if (!managerName.equals(other.managerName))
			return false;
		if (managerPassword == null) {
			if (other.managerPassword != null)
				return false;
		} else if (!managerPassword.equals(other.managerPassword))
			return false;
		if (managerPhone == null) {
			if (other.managerPhone != null)
				return false;
		} else if (!managerPhone.equals(other.managerPhone))
			return false;
		if (marketID != other.marketID)
			return false;
		return true;
	}

}
