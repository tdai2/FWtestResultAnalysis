package com.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.HibernateSessionFactory;
import com.model.TestCase;

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
	
	public static void addTestCase(String TestCatagory, String TestTitle, String TestCaseVersion,int ProductID)
	{
		Session session=HibernateSessionFactory.getSession();
		TestCase testcase=new TestCase();
		testcase.setTestCatagory(TestCatagory);
		testcase.setTestTitle(TestTitle);
		testcase.setTestCaseVersion(TestCaseVersion);
		testcase.setProductId(ProductID);
		
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
	
	public static void editTestCase(String TestCatagory, String TestTitle, String TestCaseVersion,int ProductID,String id)
	{
		Session session=HibernateSessionFactory.getSession();
		TestCase testcase=new TestCase();
		testcase.setId(Integer.parseInt(id));
		testcase.setTestCatagory(TestCatagory);
		testcase.setTestTitle(TestTitle);
		testcase.setTestCaseVersion(TestCaseVersion);
		testcase.setProductId(ProductID);
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
		testcase.setProductId(ProductID);
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
