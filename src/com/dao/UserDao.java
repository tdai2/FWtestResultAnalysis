package com.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.HibernateSessionFactory;
import com.model.User;

public class UserDao {
	public static User isLogin(String name,String pwd)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(User.class);
			criteria.add(Restrictions.eq("name", name)).add(Restrictions.eq("pwd", pwd));
			List<User> users=criteria.list();
		
			session.close();
			if(users.isEmpty())
			{
				return null;
			}else {
				return users.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static void deleteUser(int id)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			User user=(User)session.get(User.class, id);
			session.delete(user);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void addUser(String name, String pwd, String type, String ssid, String email, String phone)
	{
		Session session=HibernateSessionFactory.getSession();
		User user=new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setType(type);
		user.setEmail(email);
		user.setSsid(ssid);
		user.setPhone(phone);
		
		try {
			session.beginTransaction();		
			session.save(user);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void editUser(String id,String name, String pwd, String type, String ssid, String email, String phone)
	{
		Session session=HibernateSessionFactory.getSession();
		User user=new User();
		user.setId(Integer.parseInt(id));
		user.setName(name);
		user.setPwd(pwd);
		user.setType(type);
		user.setEmail(email);
		user.setSsid(ssid);
		user.setPhone(phone);
		try {
			session.beginTransaction();		
			session.update(user);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static List<User> getUserList()
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(User.class);
			
			List<User> users=criteria.list();
		
			session.close();
			return users;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	// to do
	public static void updateUser(String name, String pwd, String type, String ssid, String email, String phone)
	{
		Session session=HibernateSessionFactory.getSession();
		User user=new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setType(type);
		user.setEmail(email);
		user.setSsid(ssid);
		user.setPhone(phone);
		try {
			
			session.save(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static User getUser(int id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			User user=(User)session.get(User.class, id);
			session.getTransaction().commit();
			return user;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		return null;
	}
}
