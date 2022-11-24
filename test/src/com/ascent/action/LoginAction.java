package com.ascent.action;


import java.io.IOException;
import java.io.PrintWriter;

import com.ascent.po.Users;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseAction{
	public String username;
	public String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String execute() throws IOException{
		if(this.getUsername()!=null && this.getPassword()!=null){
			Users user = userService.userLogin(this.getUsername(),this.getPassword());
			if(user!=null){
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			return ERROR;
		}
		
	}
	

}
