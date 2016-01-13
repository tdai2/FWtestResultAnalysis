package com.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import com.dao.*;
import com.model.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class HwConfigAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public String delHwConfig()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		HwConfigDao.deleteHwConfig(Integer.parseInt(id));
		List<HwConfig> HwConfigList=HwConfigDao.getHwConfigList();
		context.put("HwConfiglist", HwConfigList);
		return "HwConfigList";
	}
	
	public String toAddHwConfig()throws Exception{
		return "toAddHwConfig";
	}
	
	
	public String addHwConfig()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String boardSku=request.getParameter("boardSku");
		String boardFab=request.getParameter("boardFab");
		String chassis=request.getParameter("chassis");
		String hsbp=request.getParameter("hsbp");
		String psu=request.getParameter("psu");
		String cpu=request.getParameter("cpu");
		String memory=request.getParameter("memory");
		//String[] testResult = request.getParameterValues("resultList");
		HwConfigDao.addHwConfig(boardSku,boardFab,chassis,hsbp,psu,cpu,memory);
		
		List<Product> productList=ProductDao.getProductList();
		context.put("productList", productList);		
		List<SwConfig> swConfigList=SwConfigDao.getSwConfigList();
		context.put("SwConfig", swConfigList);
		List<HwConfig> hwConfigList=HwConfigDao.getHwConfigList();
		context.put("HwConfig", hwConfigList);
		return "addHwConfig";
	}
	/*
	public Set<Product> getProductSet(String[] pID){
		Set<Product> product = new HashSet<Product> (); 
		System.out.println("In getProductSet");
		for(int i=0;i<pID.length;i++){
			product.add(ProductDao.getProduct(Integer.parseInt(pID[i])));
			
		}
		System.out.println("Current pId is "+product.toString());
		return product;
	}
	*/
	public String showHwConfigList()throws Exception{
		ActionContext context=ActionContext.getContext();
	
		List<HwConfig> HwConfigList=HwConfigDao.getHwConfigList();
		context.put("HwConfigList", HwConfigList);
		List<Product> productList=ProductDao.getProductList();
		context.put("productList",productList);
		return "HwConfigList";
	}
	/*
    public String editHwConfig()throws Exception{
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String catagory=request.getParameter("testCatagory");
		String title=request.getParameter("testTitle");
		String version=request.getParameter("HwConfigVersion");
		String[] products = request.getParameterValues("pList");
		HwConfigDao.editHwConfig(catagory,title,version,getProductSet(products),id);
		List<HwConfig> HwConfigList=HwConfigDao.getHwConfigList();
		context.put("HwConfiglist", HwConfigList);
		return "HwConfigList";
    }
    
    public String toEditHwConfig()throws Exception{
    	
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		HwConfig HwConfig=HwConfigDao.getHwConfig(Integer.parseInt(id));
		context.put("HwConfig", HwConfig);
	    return "editHwConfig";
    }
    */
}