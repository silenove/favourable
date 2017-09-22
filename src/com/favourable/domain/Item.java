package com.favourable.domain;

public class Item {

	private int itemID;
	private String itemName;
	private String originalPrice;
	private String currentPrice;
	private float discount;
	private String product;
	private int marketID;
	private String marketName;
	private String marketAddress;

	public String getMarketAddress() {
		return marketAddress;
	}

	public void setMarketAddress(String marketAddress) {
		this.marketAddress = marketAddress;
	}

	public String getMarketName() {
		return marketName;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	private String catagory;
	private String itemPicture;

	public Item() {
		super();
	}

	public Item(int itemID, String itemName, String originalPrice,
			String currentPrice, float discount, String product, int marketID,
			String catagory, String itemPicture) {
		super();
		this.itemID = itemID;
		this.itemName = itemName;
		this.originalPrice = originalPrice;
		this.currentPrice = currentPrice;
		this.discount = discount;
		this.product = product;
		this.marketID = marketID;
		this.catagory = catagory;
		this.itemPicture = itemPicture;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}

	public String getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(String currentPrice) {
		this.currentPrice = currentPrice;
	}

	public float getDiscount() {
		return this.discount;
	}

	public double getDiscount1() {
		double discount1 = Double.valueOf(this.originalPrice)
				/ Double.valueOf(this.currentPrice);
		if (discount1 > 100) {
			return 100.0;
		}
		return discount1;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getMarketID() {
		return marketID;
	}

	public void setMarketID(int marketID) {
		this.marketID = marketID;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getItemPicture() {
		return itemPicture;
	}

	public void setItemPicture(String itemPicture) {
		this.itemPicture = itemPicture;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((catagory == null) ? 0 : catagory.hashCode());
		result = prime * result
				+ ((currentPrice == null) ? 0 : currentPrice.hashCode());
		result = prime * result + Float.floatToIntBits(discount);
		result = prime * result + itemID;
		result = prime * result
				+ ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result
				+ ((itemPicture == null) ? 0 : itemPicture.hashCode());
		result = prime * result + marketID;
		result = prime * result
				+ ((originalPrice == null) ? 0 : originalPrice.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		Item other = (Item) obj;
		if (catagory == null) {
			if (other.catagory != null)
				return false;
		} else if (!catagory.equals(other.catagory))
			return false;
		if (currentPrice == null) {
			if (other.currentPrice != null)
				return false;
		} else if (!currentPrice.equals(other.currentPrice))
			return false;
		if (Float.floatToIntBits(discount) != Float
				.floatToIntBits(other.discount))
			return false;
		if (itemID != other.itemID)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemPicture == null) {
			if (other.itemPicture != null)
				return false;
		} else if (!itemPicture.equals(other.itemPicture))
			return false;
		if (marketID != other.marketID)
			return false;
		if (originalPrice == null) {
			if (other.originalPrice != null)
				return false;
		} else if (!originalPrice.equals(other.originalPrice))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}
