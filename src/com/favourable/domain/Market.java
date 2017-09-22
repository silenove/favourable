package com.favourable.domain;

public class Market {

	private int marketID;
	private String marketName;
	private String marketLicense;
	private String marketCity;
	private int marketAreaID;
	private String marketBlock;
	private String marketPicture;
	private String marketArea;

	public String getMarketArea() {
		return marketArea;
	}

	public void setMarketArea(String marketArea) {
		this.marketArea = marketArea;
	}

	public Market() {
		super();
	}

	public Market(int marketID, String marketName, String marketLicense,
			String marketCity, int marketAreaID, String marketBlock,
			String marketPicture) {
		super();
		this.marketID = marketID;
		this.marketName = marketName;
		this.marketLicense = marketLicense;
		this.marketCity = marketCity;
		this.marketAreaID = marketAreaID;
		this.marketBlock = marketBlock;
		this.marketPicture = marketPicture;
	}

	public int getMarketID() {
		return marketID;
	}

	public void setMarketID(int marketID) {
		this.marketID = marketID;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public String getMarketLicense() {
		return marketLicense;
	}

	public void setMarketLicense(String marketLicense) {
		this.marketLicense = marketLicense;
	}

	public String getMarketCity() {
		return marketCity;
	}

	public void setMarketCity(String marketCity) {
		this.marketCity = marketCity;
	}

	public int getMarketAreaID() {
		return marketAreaID;
	}

	public void setMarketAreaID(int marketAreaID) {
		this.marketAreaID = marketAreaID;
	}

	public String getMarketBlock() {
		return marketBlock;
	}

	public void setMarketBlock(String marketBlock) {
		this.marketBlock = marketBlock;
	}

	public String getMarketPicture() {
		return marketPicture;
	}

	public void setMarketPicture(String marketPicture) {
		this.marketPicture = marketPicture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + marketAreaID;
		result = prime * result
				+ ((marketBlock == null) ? 0 : marketBlock.hashCode());
		result = prime * result
				+ ((marketCity == null) ? 0 : marketCity.hashCode());
		result = prime * result + marketID;
		result = prime * result
				+ ((marketLicense == null) ? 0 : marketLicense.hashCode());
		result = prime * result
				+ ((marketName == null) ? 0 : marketName.hashCode());
		result = prime * result
				+ ((marketPicture == null) ? 0 : marketPicture.hashCode());
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
		Market other = (Market) obj;
		if (marketAreaID != other.marketAreaID)
			return false;
		if (marketBlock == null) {
			if (other.marketBlock != null)
				return false;
		} else if (!marketBlock.equals(other.marketBlock))
			return false;
		if (marketCity == null) {
			if (other.marketCity != null)
				return false;
		} else if (!marketCity.equals(other.marketCity))
			return false;
		if (marketID != other.marketID)
			return false;
		if (marketLicense == null) {
			if (other.marketLicense != null)
				return false;
		} else if (!marketLicense.equals(other.marketLicense))
			return false;
		if (marketName == null) {
			if (other.marketName != null)
				return false;
		} else if (!marketName.equals(other.marketName))
			return false;
		if (marketPicture == null) {
			if (other.marketPicture != null)
				return false;
		} else if (!marketPicture.equals(other.marketPicture))
			return false;
		return true;
	}

}
