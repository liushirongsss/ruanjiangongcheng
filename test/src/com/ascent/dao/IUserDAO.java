package com.ascent.dao;

import com.ascent.po.Users;

public interface IUserDAO {
	//用户登陆
	public Users userLogin(String username,String password);
	
	//添加方法
	public String addObject(Object obj,String username);
}
