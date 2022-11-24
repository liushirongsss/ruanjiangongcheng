package com.ascent.service.Impl;

import com.ascent.dao.IUserDAO;
import com.ascent.po.Users;
import com.ascent.service.IUserService;

public class IUserServiceImpl implements IUserService {
	
	private IUserDAO userDAO;

	public Users userLogin(String username, String password) {
		return userDAO.userLogin(username, password);
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public String addObject(Object obj,String username) {
		return userDAO.addObject(obj,username);
	}
}