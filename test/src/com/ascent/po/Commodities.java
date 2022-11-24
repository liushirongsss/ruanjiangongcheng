package com.ascent.po;

/**
 * Commodities entity. @author MyEclipse Persistence Tools
 */

public class Commodities implements java.io.Serializable {

	// Fields

	private Integer id;
	private String tradename;
	private Integer weight;
	private String category;
	private Integer number;
	private Integer purchaseprice;
	private Integer sales;
	private String brand;
	private String supplier;

	// Constructors

	/** default constructor */
	public Commodities() {
	}

	/** full constructor */
	public Commodities(String tradename, Integer weight, String category, Integer number, Integer purchaseprice,
			Integer sales, String brand, String supplier) {
		this.tradename = tradename;
		this.weight = weight;
		this.category = category;
		this.number = number;
		this.purchaseprice = purchaseprice;
		this.sales = sales;
		this.brand = brand;
		this.supplier = supplier;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTradename() {
		return this.tradename;
	}

	public void setTradename(String tradename) {
		this.tradename = tradename;
	}

	public Integer getWeight() {
		return this.weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPurchaseprice() {
		return this.purchaseprice;
	}

	public void setPurchaseprice(Integer purchaseprice) {
		this.purchaseprice = purchaseprice;
	}

	public Integer getSales() {
		return this.sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSupplier() {
		return this.supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

}