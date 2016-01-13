package com.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.model.*;

public class HwConfigDao {
	
	public static void deleteHwConfig(int id)
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			session.beginTransaction();
			HwConfig hwConfig=(HwConfig)session.get(HwConfig.class, id);
			session.delete(hwConfig);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	public static int addHwConfig(String SKU, String Fab, String Chassis, String HSBP, String PSU, String CPU,String Memory)
	{
		Session session=HibernateSessionFactory.getSession();
		HwConfig hwConfig=new HwConfig();
		hwConfig.setBoardSku(SKU);
		hwConfig.setBoardFab(Fab);
		hwConfig.setChassis(Chassis);
		hwConfig.setHsbp(HSBP);
		hwConfig.setPsu(PSU);
		hwConfig.setCpu(CPU);
		hwConfig.setMemory(Memory);
		
		try {
			session.beginTransaction();		
			session.save(hwConfig);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return hwConfig.getId();
	}
	
	public static void editHwConfig(String id,String SKU, String Fab, String Chassis, String HSBP, String PSU, String CPU,String Memory)
	{
		Session session=HibernateSessionFactory.getSession();
		HwConfig hwConfig=new HwConfig();
		hwConfig.setBoardSku(SKU);
		hwConfig.setBoardFab(Fab);
		hwConfig.setChassis(Chassis);
		hwConfig.setHsbp(HSBP);
		hwConfig.setPsu(PSU);
		hwConfig.setCpu(CPU);
		hwConfig.setMemory(Memory);
		hwConfig.setId(Integer.parseInt(id));		
		try {
			session.beginTransaction();		
			session.update(hwConfig);
			session.getTransaction().commit();
			session.clear();
			session.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static List<HwConfig> getHwConfigList()
	{
		Session session=HibernateSessionFactory.getSession();
		try {
			
			Criteria criteria=session.createCriteria(HwConfig.class);
			
			List<HwConfig> hwConfigs=criteria.list();
		
			session.close();
			return hwConfigs;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	// to do
	
	public static HwConfig getHwConfig(int id) {
		// TODO Auto-generated method stub
		
		Session session = HibernateSessionFactory.getSession();
		
		try {
			session.beginTransaction();
			HwConfig hwConfig=(HwConfig)session.get(HwConfig.class, id);
			session.getTransaction().commit();
			return hwConfig;
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		
		} finally {
			session.close();
		}
		return null;
	}
}
