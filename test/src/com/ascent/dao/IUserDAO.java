package com.ascent.dao;

import com.ascent.po.Users;

public interface IUserDAO {
	//�û���½
	public Users userLogin(String username,String password);
	
	//��ӷ���
	public String addObject(Object obj,String username);
}
