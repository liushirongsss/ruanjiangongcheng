package com.ascent.action;

import com.ascent.service.ICommoditiesService;
import com.ascent.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction extends ActionSupport {
	
	protected ICommoditiesService commoditiesService;		//调用Service层对象
	protected IUserService userService;		//调用Service层对象

	public IUserService getUserService() {
		return userService;
	}
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public ICommoditiesService getCommoditiesService() {
		return commoditiesService;
	}
	public void setCommoditiesService(ICommoditiesService commoditiesService) {
		this.commoditiesService = commoditiesService;
	}
	
}
