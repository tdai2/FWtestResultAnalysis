package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.BookDao;
import com.dao.UserDao;
import com.model.Book;
import com.model.HibernateSessionFactory;
import com.model.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class UserAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public String login()throws Exception{
		//�õ�context
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		//ȡ�õ�¼ѧ��
		String no=request.getParameter("no");
		//��¼����
		String pwd=request.getParameter("pwd");
		//�Ƿ�Ϊ��
		if(no.isEmpty()||pwd.isEmpty())
		{
			return ERROR;
		}else {
			//�������ݿ�
			User  user=UserDao.isLogin(no, pwd);
			if(user==null)
			{
				return ERROR;
			}else {
				
				return SUCCESS;
			}			
		}		
	}
	public String delUser()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		UserDao.deleteUser(Integer.parseInt(id));
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		return "user";
	}
	
	public String toAddUser()throws Exception{
		return "toAddUser";
	}
	public String addUser()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String uType=request.getParameter("uType");
		String email=request.getParameter("email");
		String ssid=request.getParameter("ssid");
		String phone=request.getParameter("phone");
		
		UserDao.addUser(name, pwd,uType,email,ssid,phone);
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		return "user";
	}
	
	public String showUserList()throws Exception{
		ActionContext context=ActionContext.getContext();
	
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		
		
		return "user";
	}

    public String editUser()throws Exception{
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String uType=request.getParameter("uType");
		String email=request.getParameter("email");
		String ssid=request.getParameter("ssid");
		String phone=request.getParameter("phone");
		UserDao.editUser(id,name, pwd,uType,email,ssid,phone);
		List<User> userList=UserDao.getUserList();
		context.put("userlist", userList);
		return "user";
    }
    public String toEditUser()throws Exception{
    	
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		User user=UserDao.getUser(Integer.parseInt(id));
		context.put("user", user);
	    return "editUser";
    }
    
}