package com.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.*;

public class SwConfigDao {
	
	public static void deleteSwConfig(int id)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			SwConfig swConfig=(SwConfig)session.get(SwConfig.class, id);
			session.delete(swConfig);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static int addSwConfig(String BMC, String FRUSDR, String PSU, String HSC, String BIOS, String ME )
	{
		Session session=HibernateSessionFactory.getSession();
		SwConfig swConfig=new SwConfig();
		swConfig.setBmcVersion(BMC);
		swConfig.setFrusdrVersion(FRUSDR);
		swConfig.setHscVersion(HSC);
		swConfig.setPsuVersion(PSU);
		swConfig.setBiosVersion(BIOS);
		swConfig.setMeVersion(ME);
		
		try {
			session.beginTransaction();		
			session.save(swConfig);
			session.getTransaction().commit();
			session.clear();
			session.close();
			 
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return swConfig.getId();
	}
	
	public int editSwConfig(String id,String BMC, String FRUSDR, String PSU, String HSC, String BIOS, String ME )
	{
		Session session=HibernateSessionFactory.getSession();
		SwConfig swConfig=new SwConfig();
		swConfig.setBmcVersion(BMC);
		swConfig.setFrusdrVersion(FRUSDR);
		swConfig.setHscVersion(HSC);
		swConfig.setPsuVersion(PSU);
		swConfig.setBiosVersion(BIOS);
		swConfig.setMeVersion(ME);
		swConfig.setId(Integer.parseInt(id));		
		try {
			session.beginTransaction();		
			session.update(swConfig);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return swConfig.getId();
	}
	
	public static List<SwConfig> getSwConfigList()
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(SwConfig.class);
			
			List<SwConfig> swConfigs=criteria.list();
		
			session.close();
			return swConfigs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	// to do
	
	public static SwConfig getSwConfig(int id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			SwConfig swConfig=(SwConfig)session.get(SwConfig.class, id);
			session.getTransaction().commit();
			return swConfig;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		return null;
	}
}
