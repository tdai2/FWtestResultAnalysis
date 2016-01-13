package com.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import com.dao.*;
import com.model.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class SwConfigAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public String delSwConfig()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		SwConfigDao.deleteSwConfig(Integer.parseInt(id));
		List<SwConfig> SwConfigList=SwConfigDao.getSwConfigList();
		context.put("SwConfiglist", SwConfigList);
		return "SwConfigList";
	}
	
	public String toAddSwConfig()throws Exception{
		return "toAddSwConfig";
	}
	
	
	public String addSwConfig()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String bmc=request.getParameter("bmc");
		String frusdr=request.getParameter("frusdr");
		String hsc=request.getParameter("hsc");
		String psu=request.getParameter("psu");
		String bios=request.getParameter("bios");
		String me=request.getParameter("me");
		
		//String[] testResult = request.getParameterValues("resultList");
		SwConfigDao.addSwConfig(bmc,frusdr,psu,hsc,bios,me);
		
		List<Product> productList=ProductDao.getProductList();
		context.put("productList", productList);		
		List<HwConfig> hwConfigList=HwConfigDao.getHwConfigList();
		context.put("HwConfig", hwConfigList);
		List<SwConfig> SwConfigList=SwConfigDao.getSwConfigList();
		context.put("SwConfig", SwConfigList);
		
		return "addSwConfig";
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
	public String showSwConfigList()throws Exception{
		ActionContext context=ActionContext.getContext();
	
		List<SwConfig> SwConfigList=SwConfigDao.getSwConfigList();
		context.put("SwConfigList", SwConfigList);
		List<Product> productList=ProductDao.getProductList();
		context.put("productList",productList);
		return "SwConfigList";
	}
	/*
    public String editSwConfig()throws Exception{
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String catagory=request.getParameter("testCatagory");
		String title=request.getParameter("testTitle");
		String version=request.getParameter("SwConfigVersion");
		String[] products = request.getParameterValues("pList");
		SwConfigDao.editSwConfig(catagory,title,version,getProductSet(products),id);
		List<SwConfig> SwConfigList=SwConfigDao.getSwConfigList();
		context.put("SwConfiglist", SwConfigList);
		return "SwConfigList";
    }
    
    public String toEditSwConfig()throws Exception{
    	
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		SwConfig SwConfig=SwConfigDao.getSwConfig(Integer.parseInt(id));
		context.put("SwConfig", SwConfig);
	    return "editSwConfig";
    }
    */
}