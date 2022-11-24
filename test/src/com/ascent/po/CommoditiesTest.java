package com.ascent.po;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CommoditiesTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetTradename() {
		Commodities user = new Commodities();
		String str = "Amerts";
		user.setTradename(str);
		String str2 = user.getTradename();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetWeight() {
		Commodities user = new Commodities();
		int str = 100;
		user.setWeight(str);
		int str2 = user.getWeight();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetCategory() {
		Commodities user = new Commodities();
		String str = "DDD";
		user.setCategory(str);
		String str2 = user.getCategory();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetNumber() {
		Commodities user = new Commodities();
		int str = 100;
		user.setNumber(str);
		int str2 = user.getNumber();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetPurchaseprice() {
		Commodities user = new Commodities();
		int str = 231;
		user.setPurchaseprice(str);
		int str2 = user.getPurchaseprice();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetSales() {
		Commodities user = new Commodities();
		int str = 312;
		user.setSales(str);
		int str2 = user.getSales();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetBrand() {
		Commodities user = new Commodities();
		String str = "Wsda";
		user.setBrand(str);
		String str2 = user.getBrand();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetSupplier() {
		Commodities user = new Commodities();
		String str = "asdaaa";
		user.setSupplier(str);
		String str2 = user.getSupplier();
		Assert.assertEquals(str, str2);
	}

}
