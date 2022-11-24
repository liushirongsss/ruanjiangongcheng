package com.ascent.po;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class UsersTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		Users user = new Users();
		String str = "liushirong";
		user.setName(str);
		String str2 = user.getName();
		Assert.assertEquals(str, str2);
		
	}

	@Test
	public void testGetPassword() {
		Users user = new Users();
		String str = "a1234";
		user.setPassword(str);
		String str2 = user.getPassword();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetPhone() {
		Users user = new Users();
		int str = 12345;
		user.setPhone(str);
		int str2 = user.getPhone();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetAddress() {
		Users user = new Users();
		String str = "xxx";
		user.setAddress(str);
		String str2 = user.getAddress();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetAuth() {
		Users user = new Users();
		int str = 0;
		user.setAuth(str);
		int str2 = user.getAuth();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetEmailid() {
		Users user = new Users();
		String str = "1@qq.com";
		user.setEmailid(str);
		String str2 = user.getEmailid();
		Assert.assertEquals(str, str2);
	}

	@Test
	public void testGetStatus() {
		Users user = new Users();
		String str = "null";
		user.setStatus(str);
		String str2 = user.getStatus();
		Assert.assertEquals(str, str2);
	}

}
