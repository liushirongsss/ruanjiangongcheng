package com.ascent.dao.Impl;

import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import com.ascent.po.Users;
import com.ascent.dao.IUserDAO;

public class IUserDAOImpl extends HibernateDaoSupport implements IUserDAO {

	public Users userLogin(String username, String password) {
		String[] u = {username,password};
		String sql = "from Users u where u.name=? and u.password=?";
		List list = this.getHibernateTemplate().find(sql,u);
		Users user = new Users();
		if(list.size()>0){
			user = (Users) list.get(0);
		} else {
			user = null;
		}
		return user;
		
	}
	
	public String addObject(Object obj,String username) {
		String[] u = {username};
		String sql = "from Users u where u.name=?";
		List list = this.getHibernateTemplate().find(sql,u);
		Users user = new Users();
		if(list.size()>0){
			return "error";
		} else {
			this.getHibernateTemplate().save(obj);
			return "success";
		}
		
	}
}