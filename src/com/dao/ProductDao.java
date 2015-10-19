package com.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.HibernateSessionFactory;
import com.model.Product;

public class ProductDao {
	
	public static void deleteProduct(int id)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			Product product=(Product)session.get(Product.class, id);
			session.delete(product);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static void addProduct(String family, String production)
	{
		Session session=HibernateSessionFactory.getSession();
		Product product=new Product();
		product.setFamily(family);
		product.setProduction(production);
		
		try {
			session.beginTransaction();		
			session.save(product);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void editProduct(String id,String family, String production)
	{
		Session session=HibernateSessionFactory.getSession();
		Product product=new Product();
		product.setId(Integer.parseInt(id));
		product.setFamily(family);
		product.setProduction(production);
		
		try {
			session.beginTransaction();		
			session.update(product);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static List<Product> getProductList()
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(Product.class);
			
			List<Product> products=criteria.list();
		
			session.close();
			return products;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	// to do
	public static void updateProduct(String family, String production)
	{
		Session session=HibernateSessionFactory.getSession();
		Product product=new Product();
		product.setFamily(family);
		product.setProduction(production);
		try{
			
			session.save(product);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static Product getProduct(int id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			Product product=(Product)session.get(Product.class, id);
			session.getTransaction().commit();
			return product;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		return null;
	}
}
