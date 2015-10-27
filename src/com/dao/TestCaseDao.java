package com.dao;

import java.util.*;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.HibernateSessionFactory;
import com.model.TestCase;

import javassist.bytecode.Descriptor.Iterator;

import com.model.Product;

public class TestCaseDao {

	public static void deleteTestCase(int id)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			TestCase testcase=(TestCase)session.get(TestCase.class, id);
			session.delete(testcase);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void addTestCase(String TestCatagory, String TestTitle, String TestCaseVersion,Set<Product> products)
	{
		Session session=HibernateSessionFactory.getSession();
		TestCase testcase=new TestCase();
		//Set<Product> ps=new HashSet<Product>();
		testcase.setTestCatagory(TestCatagory);
		testcase.setTestTitle(TestTitle);
		testcase.setTestCaseVersion(TestCaseVersion);
		testcase.setProducts(products);
		//testcase.setProductId(ProductID);
		try {
			session.beginTransaction();		
			session.save(testcase);
			session.getTransaction().commit();
			session.clear();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void addCaseToProduct(TestCase tCase,Set <Product>pList){
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		 System.out.println("In addCaseToProduct");
		try
		{
			System.out.println("tcase is "+tCase.getId());
			TestCase sCase = new TestCase();
			sCase=(TestCase) session.get("com.model.TestCase", tCase.getId());
			
			System.out.println("sCase is "+sCase.getId());
			Product product1 = new Product();
			for(Product product : pList)
			{
				//System.out.println("product ID is "+product.getId());
				//product1=(Product) session.get("com.model.Product", product.getId());
				//System.out.println("product1 ID is "+product1.getId());
				//System.out.println("sCase is "+sCase.getId());
				//sCase.getProducts().add(product);
				 	
			}
	
		session.getTransaction().commit();
		session.clear();
		session.close();}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
	}
		}
	
	public static void editTestCase(String TestCatagory, String TestTitle, String TestCaseVersion,Set <Product> products,String id)
	{
		Session session=HibernateSessionFactory.getSession();
		TestCase testcase=new TestCase();
		testcase.setId(Integer.parseInt(id));
		testcase.setTestCatagory(TestCatagory);
		testcase.setTestTitle(TestTitle);
		testcase.setTestCaseVersion(TestCaseVersion);
		testcase.setProducts(products);
		
		//testcase.setProductId(ProductID);
		try {
			session.beginTransaction();		
			session.update(testcase);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static List<TestCase> getTestCaseList()
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(TestCase.class);
			
			List<TestCase> testcases=criteria.list();
		
			session.close();
			return testcases;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	// to do
	public static void updateTestCase(String TestCatagory, String TestTitle, String TestCaseVersion,int ProductID,String id)
	{
		Session session=HibernateSessionFactory.getSession();
		TestCase testcase=new TestCase();
		testcase.setTestCatagory(TestCatagory);
		testcase.setTestTitle(TestTitle);
		testcase.setTestCaseVersion(TestCaseVersion);
		//testcase.setProductId(ProductID);
		try {
			
			session.save(testcase);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static TestCase getTestCase(int id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			TestCase testcase=(TestCase)session.get(TestCase.class, id);
			session.getTransaction().commit();
			return testcase;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		return null;
	}
}
