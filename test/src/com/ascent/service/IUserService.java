package com.ascent.service;

import com.ascent.po.Users;

public interface IUserService {	
	//	用户登陆
	public Users userLogin(String username,String password);

	//添加方法
	public String addObject(Object obj,String username);
}