package com.ascent.service;

import com.ascent.po.Users;

public interface IUserService {	
	//	�û���½
	public Users userLogin(String username,String password);

	//��ӷ���
	public String addObject(Object obj,String username);
}