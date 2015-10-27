package com.action;

import java.util.*;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.*;
import com.model.*;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TestResultAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public String delTestResult()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		TestResultDao.deleteTestResult(Integer.parseInt(id));
		List<TestResult> testResultList=TestResultDao.getTestResultList();
		context.put("testResultlist", testResultList);
		return "testResultList";
	}
	
	public String toChooseProduct()throws Exception{
		ActionContext context=ActionContext.getContext();
		List<Product> productList=ProductDao.getProductList();
		context.put("productList", productList);
		return "toChooseProduct";
	}
	
	public String toAddTestResult()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		System.out.println("In to addTestResult");
		Product product=new Product();
		System.out.println("PId is "+Integer.parseInt(request.getParameter("product")));
		product=ProductDao.getProduct(Integer.parseInt(request.getParameter("product")));
		System.out.println("product ID is "+product.getId());
		//System.out.println(product.gettestcases());
		context.put("caseList", product.gettestcases());
		context.put("product",product.getProduction());
		return "toAddTestResult";
	}
	
	public String addTestResult()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		//Add SoftWare configuration 
		String BMC=request.getParameter("BMC");
		String FRUSDR=request.getParameter("FRUSDR");
		String HSC=request.getParameter("HSC");
		String PSUFW=request.getParameter("PSUFW");
		String BIOS=request.getParameter("BIOS");
		String ME=request.getParameter("ME");
		SwConfigDao.addSwConfig(BMC,FRUSDR,HSC,PSUFW,BIOS,ME);
		//Add HardWare configuration		
		String SKU=request.getParameter("bbSKU");
		String Fab=request.getParameter("Fab");
		String Chassis=request.getParameter("Chassis");
		String HSBP=request.getParameter("HSBP");
		String PSU=request.getParameter("PSU");
		String CPU=request.getParameter("CPU");
		String Memory=request.getParameter("Memory");
		HwConfigDao.addHwConfig(SKU, Fab, Chassis, HSBP, PSU, CPU, Memory);
		
		
		List<TestResult> testResultList=TestResultDao.getTestResultList();
		context.put("testResultList", testResultList);
		return "testResultList";
	}
	public Set<Product> getProductSet(String[] pID){
		Set<Product> result = new HashSet<Product> (); 
		System.out.println("In getProductSet");
		for(int i=0;i<pID.length;i++){
			result.add(ProductDao.getProduct(Integer.parseInt(pID[i])));
			
		}
		System.out.println("Current pId is "+result.toString());
		return result;
	}
	
	public String showTestResultList()throws Exception{
		ActionContext context=ActionContext.getContext();
	
		List<TestResult> testResultList=TestResultDao.getTestResultList();
		context.put("testResultList", testResultList);
		List<Product> resultList=ProductDao.getProductList();
		context.put("resultList",resultList);
		return "testResultList";
	}

    public String editTestResult()throws Exception{
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String catagory=request.getParameter("testCatagory");
		String title=request.getParameter("testTitle");
		String version=request.getParameter("testResultVersion");
		String[] results = request.getParameterValues("pList");
		//TestResultDao.editTestResult(catagory,title,version,getProductSet(results),id);
		List<TestResult> testResultList=TestResultDao.getTestResultList();
		context.put("testResultlist", testResultList);
		return "testResultList";
    }
    public String toEditTestResult()throws Exception{
    	
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		TestResult testResult=TestResultDao.getTestResult(Integer.parseInt(id));
		context.put("testResult", testResult);
	    return "editTestResult";
    }
    
}