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
	
	public String toInputConfig()throws Exception{
		ActionContext context=ActionContext.getContext();
		List<Product> productList=ProductDao.getProductList();
		context.put("productList", productList);
		
		
		List<SwConfig> swConfigList=SwConfigDao.getSwConfigList();
		context.put("SwConfig", swConfigList);
		
		List<HwConfig> hwConfigList=HwConfigDao.getHwConfigList();
		context.put("HwConfig", hwConfigList);
		
		return "inputConfig";
	}
	
	public String inputConfig()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		//System.out.println("Production Id is "+Integer.parseInt(request.getParameter("pID")));
		//String swCID=request.getParameter("swCID");
		//System.out.println("sw configuraiton id is "+Integer.parseInt(swCID));
		//System.out.println("hw configuration id is "+Integer.parseInt(request.getParameter("hwCID")));
		Product product=new Product();
		product=ProductDao.getProduct(Integer.parseInt(request.getParameter("pID")));
		SwConfig swConfig=new SwConfig();
		swConfig=SwConfigDao.getSwConfig(Integer.parseInt(request.getParameter("swCID")));
		HwConfig hwConfig=new HwConfig();
		hwConfig=HwConfigDao.getHwConfig(Integer.parseInt(request.getParameter("hwCID")));
		//System.out.println("product ID is "+product.getId());
		//System.out.println(product.gettestcases());
		context.put("caseList", product.gettestcases());
		context.put("product",product);
		context.put("pID", product.getId());
		context.put("swConfig",swConfig);
		context.put("hwConfig",hwConfig);
		return "toAddTestResult";
	}
	
	public String toChooseSWConfig()throws Exception{
		ActionContext context=ActionContext.getContext();
				
		List<SwConfig> sw_config=SwConfigDao.getSwConfigList();
		context.put("SwConfig", sw_config);
		/*
		List<HwConfig> hw_config=HwConfigDao.getHwConfigList();
		context.put("HwConfig", hw_config);
		*/
		
		return "chooseSWConfig";
	}
	
	public String toAddTestResult()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		
		String pID=request.getParameter("pID");
		System.out.println("pID is "+pID);
		String swCID=request.getParameter("swCID");
		System.out.println("swCID is "+swCID);
		String hwCID=request.getParameter("hwCID");
		System.out.println("hwCID is "+hwCID);
		//String caseID=request.getParameter("caseID");
		//System.out.println("caseID is "+caseID);
		String[] result=request.getParameterValues("result");
		  for(int i=0;i<result.length;i++)
		  {  
		   System.out.println(result[i]);
		   System.out.println("Length is"+result[i].length());
		  }
		String[] casesID=request.getParameterValues("cases");
		  for(int i=0;i<casesID.length;i++)
		  {  
		   System.out.println(casesID[i]);    
		  }
		  
		String[] trackers=request.getParameterValues("trackerNos");
		for(int i=0;i<trackers.length;i++)
		  {  
		   System.out.println(trackers[i]);    
		  }
		
		String[] notes=request.getParameterValues("notes");
		for(int i=0;i<notes.length;i++)
		  {  
		   System.out.println(notes[i]);    
		  }		
		Date time = new Date();

		System.out.println("before add test reulst function");
		for(int i=0;i<casesID.length;i++)
		{
		if(!result[i].equals("No Run"))
		TestResultDao.addTestResult(pID, swCID, hwCID, casesID[i], result[i], "try", trackers[i], notes[i], time);
		}
		Product product=new Product();
		product=ProductDao.getProduct(Integer.parseInt(request.getParameter("pID")));
		SwConfig swConfig=new SwConfig();
		swConfig=SwConfigDao.getSwConfig(Integer.parseInt(request.getParameter("swCID")));
		HwConfig hwConfig=new HwConfig();
		hwConfig=HwConfigDao.getHwConfig(Integer.parseInt(request.getParameter("hwCID")));
		
		context.put("caseList", product.gettestcases());
		context.put("product",product);
		context.put("swConfig",swConfig);
		context.put("hwConfig",hwConfig);
		return "toAddTestResult";
		
		/*
		System.out.println("In to addTestResult");
		Product product=new Product();
		System.out.println("PId is "+Integer.parseInt(request.getParameter("product")));
		product=ProductDao.getProduct(Integer.parseInt(request.getParameter("product")));
		System.out.println("product ID is "+product.getId());
		//System.out.println(product.gettestcases());
		context.put("caseList", product.gettestcases());
		context.put("product",product.getProduction());
		return "toAddTestResult";
		*/
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
		int swID=SwConfigDao.addSwConfig(BMC,FRUSDR,HSC,PSUFW,BIOS,ME);
		
		//Add HardWare configuration		
		String SKU=request.getParameter("bbSKU");
		String Fab=request.getParameter("Fab");
		String Chassis=request.getParameter("Chassis");
		String HSBP=request.getParameter("HSBP");
		String PSU=request.getParameter("PSU");
		String CPU=request.getParameter("CPU");
		String Memory=request.getParameter("Memory");
		int hwID=HwConfigDao.addHwConfig(SKU, Fab, Chassis, HSBP, PSU, CPU, Memory);
		
		/*
		String caseResult=request.getParameter("caseResult");
		String trackerNO=request.getParameter("trackerNO");
		String notes=request.getParameter("notes");
		String pid=request.getParameter("pID");
		String cid=request.getParameter("caseID");
		String swID=request.getParameter("caseID");
		*/
		
		//TestResultDao.addTestResult(SKU, Fab, Chassis, HSBP, PSU, CPU, Memory);
		
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
		//System.out.println("tcase title is "+testResultList.get(4).gettcase().getTestTitle());
		List<TestCase> testCaseList=TestCaseDao.getTestCaseList();
		context.put("testResultList", testResultList);
		context.put("testVar", testResultList.get(2).gettcase());
		context.put("testResult", testResultList.get(0));
		context.put("testCaseList", testCaseList);
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
		context.put("testResultList", testResultList);
		return "testResultList";
    }
    /*
    public String toEditTestResult()throws Exception{
    	
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		TestResult testResult=TestResultDao.getTestResult(Integer.parseInt(id));
		context.put("testResult", testResult);
	    return "editTestResult";
    }
    */
}