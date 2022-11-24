package com.ascent.action;
import com.opensymphony.xwork2.ActionContext;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.ascent.po.Users;
public class RegisterAction extends BaseAction{
	public Integer id;
	public String name;
	public String password;
	public Integer phone;
	public String address;
	public String emailid;
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	/**
	 * 注册用户
	 * @return
	 */
	public String addUser(){
		Users user = new Users();
		user.setName(this.getName());
		user.setPassword(this.getPassword());
		user.setPhone(this.getPhone());
		user.setAddress(this.getAddress());
		user.setEmailid(this.getEmailid());

		//保存对象
		userService.addObject(user,this.getName());
		return SUCCESS;
		
	}
	public String execute(){
		Users user = new Users();
		user.setName(this.getName());
		user.setPassword(this.getPassword());
		user.setPhone(this.getPhone());
		user.setAddress(this.getAddress());
		user.setEmailid(this.getEmailid());

		//保存对象
		if(userService.addObject(user,this.getName()).equals("success")){
			return SUCCESS;
		}
		else{
			return ERROR;
		}
		
		
	}
}
