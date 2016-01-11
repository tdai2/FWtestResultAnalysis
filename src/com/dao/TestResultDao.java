package com.dao;

import java.util.*;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javassist.bytecode.Descriptor.Iterator;

import com.model.*;
import com.dao.*;


public class TestResultDao {

	public static void deleteTestResult(int id)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			TestResult testResult=(TestResult)session.get(TestResult.class, id);
			session.delete(testResult);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static void addTestResult(Product product, SwConfig swConfig, HwConfig hwConfig,TestCase tcase ,String result, String tType, String tracker, String note, Date time )
	{
		Session session=HibernateSessionFactory.getSession();
		TestResult testResult=new TestResult();
		//Set<Product> ps=new HashSet<Product>();
		testResult.setProduct(product);
		testResult.setswConfig(swConfig);
		testResult.sethwConfig(hwConfig);
		testResult.settcase(tcase);
		testResult.setCaseResult(result);
		testResult.setTestType(tType);
		testResult.setTrackerNo(tracker);
		testResult.setNotes(note);
		testResult.setRecordTime(time);		
		try {
			session.beginTransaction();		
			session.save(testResult);
			session.getTransaction().commit();
			session.clear();
			session.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public static void addTestResult(String pID, String swCID, String hwCID,String caseID,String result, String tType, String tracker, String note, Date time )
	{
		
		addTestResult(
				ProductDao.getProduct(Integer.parseInt(pID)),
				SwConfigDao.getSwConfig(Integer.parseInt(swCID)),
		        HwConfigDao.getHwConfig(Integer.parseInt(hwCID)),
		        TestCaseDao.getTestCase(Integer.parseInt(caseID)),
				result,
				tType,
				tracker,
				note,
				time);	
	}
	
	public static void editTestResult(Product product, SwConfig swConfig, HwConfig hwConfig,TestCase tcase ,String result, String tType, String tracker, String note, Date time )
	{
		Session session=HibernateSessionFactory.getSession();
		TestResult testResult=new TestResult();
		//Set<Product> ps=new HashSet<Product>();
		testResult.setProduct(product);
		testResult.setswConfig(swConfig);
		testResult.sethwConfig(hwConfig);
		testResult.settcase(tcase);
		testResult.setCaseResult(result);
		testResult.setTestType(tType);
		testResult.setTrackerNo(tracker);
		testResult.setNotes(note);
		testResult.setRecordTime(time);		
		try {
			session.beginTransaction();		
			session.update(testResult);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static List<TestResult> getTestResultList()
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(TestResult.class);
			
			List<TestResult> testResults=criteria.list();
		
			session.close();
			return testResults;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	// to do
	public static void updateTestResult(Product product, SwConfig swConfig, HwConfig hwConfig,TestCase tcase ,String result, String tType, String tracker, String note, Date time )
	{
		Session session=HibernateSessionFactory.getSession();
		TestResult testResult=new TestResult();
		//Set<Product> ps=new HashSet<Product>();
		testResult.setProduct(product);
		testResult.setswConfig(swConfig);
		testResult.sethwConfig(hwConfig);
		testResult.settcase(tcase);
		testResult.setCaseResult(result);
		testResult.setTestType(tType);
		testResult.setTrackerNo(tracker);
		testResult.setNotes(note);
		testResult.setRecordTime(time);		
		try {
			
			session.save(testResult);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static TestResult getTestResult(int id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			TestResult testResult=(TestResult)session.get(TestResult.class, id);
			session.getTransaction().commit();
			return testResult;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		return null;
	}
}
