package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.UserDao;

import com.model.User;

public class Login {

	public String userLogin() {// ��̨�����¼
		HttpServletRequest request = ServletActionContext.getRequest();
		String name = request.getParameter("name");
		String password = request.getParameter("pwd");
		if(UserDao.isLogin(name,password)!=null)
		{
			return "success";
		}else {
			return "loginerror";
		}
	
	}

	
	public String exit(){
		return "exit";
	}
}
