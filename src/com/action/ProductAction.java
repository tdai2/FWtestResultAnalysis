package com.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.*;
import com.model.*;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class ProductAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public String delProduct()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		ProductDao.deleteProduct(Integer.parseInt(id));
		List<Product> productList=ProductDao.getProductList();
		context.put("productlist", productList);
		return "product";
	}
	
	public String toAddProduct()throws Exception{
		return "toAddProduct";
	}
	public String addProduct()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String family=request.getParameter("family");
		String production=request.getParameter("production");
		ProductDao.addProduct(family, production);
		List<Product> productList=ProductDao.getProductList();
		context.put("productlist", productList);
		return "product";
	}
	
	public String showProductList()throws Exception{
		ActionContext context=ActionContext.getContext();
		List<Product> productList=ProductDao.getProductList();
		context.put("productlist", productList);		
		return "product";
	}

    public String editProduct()throws Exception{
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id = request.getParameter("pid");
		String family=request.getParameter("family");
		String production=request.getParameter("production");
		ProductDao.editProduct(id,family, production);
		
		List<Product> productList=ProductDao.getProductList();
		
		context.put("productlist", productList);
		return "product";
    }
    
    public String addProductCase()throws Exception{
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cid");
		
		int temp = 0;
		 System.out.println("In addProductCase. cid is "+cid);
		System.out.println("pid lenght is "+pid.length());
		System.out.println("cid lenght is "+cid.length());
		Product product=ProductDao.getProduct(Integer.parseInt(pid));
		String family= product.getFamily();
		String production = product.getProduction();
		
		cid = cid.substring(0, cid.length()-2);
		
		
		System.out.println("cid lenght is "+cid.length());
		temp = Integer.parseInt(cid);
		 System.out.println("tmep = "+ temp);
		TestCase testcase=TestCaseDao.getTestCase(temp);
		Set<TestCase> testcases=product.gettestcases();
		Set<TestResult> testResults=product.getResults();
		 testcases.add(testcase);
		 //System.out.println("Before add case to product");
		ProductDao.editProductCase(pid,family,production,testcases,testResults);
		toEditProduct(pid);
		return "editProduct";
    }
    
    public String removeProductCase()throws Exception{
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String pid = request.getParameter("pid");
		String cid = request.getParameter("cid");
		cid = cid.substring(0, cid.length()-2);
		Enumeration params = request.getParameterNames();
        
		 System.out.println("cid is "+cid);
		
		 //System.out.println("pid is "+pid);
		Product product=ProductDao.getProduct(Integer.parseInt(pid));
		String family= product.getFamily();
		String production = product.getProduction();
		TestCase testcase=TestCaseDao.getTestCase(Integer.parseInt(cid));
		Set<TestCase> testcases=product.gettestcases();
		Set<TestResult> testResults=product.getResults();
		System.out.println("To remove case ID:"+testcase.getId());
		testcases.remove(testcase);
		Iterator<TestCase> t= product.gettestcases().iterator();  
		  while (t.hasNext()) {    ; 
		   System.out.println(t.next().getId());    
		  }
		ProductDao.editProductCase(pid,family,production,testcases,testResults);
		toEditProduct(pid);
		return "editProduct";
		
    }
    
    public String toEditProduct()throws Exception{
    	
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		System.out.println("id is "+id);
		Product product=ProductDao.getProduct(Integer.parseInt(id));
		context.put("product", product);
		List<TestCase> caseIncluded=new ArrayList<TestCase>(product.gettestcases());
		List<TestCase> caseNotIncluded=TestCaseDao.getTestCaseList();
		caseNotIncluded.removeAll(caseIncluded);
/*
		Iterator<TestCase> before = caseNotIncluded.iterator();  
		  while (before.hasNext()) {    ; 
		   System.out.println(before.next());    
		  }
		
		  Iterator<TestCase> included= caseIncluded.iterator();  
		  while (included.hasNext()) {    ; 
		   System.out.println(included.next());    
		  }
	*/	  
		 //System.out.println(caseNotIncluded.removeAll(caseIncluded));
		
		//Iterator<TestCase> after = caseNotIncluded.iterator();  
		//  before = caseNotIncluded.iterator();
		//  included= caseIncluded.iterator();
		//  System.out.println(caseIncluded.get(0));
		//  System.out.println(caseNotIncluded.remove(caseIncluded.get(0)));
		  /*		
		  while (before.hasNext()) {    ;
		  if (caseIncluded.contains(before.next())) {  
              before.remove();
              System.out.println("in remove cycle find");    
		  }
		  System.out.println("in remove cycle not find");
		  }
		  */
		context.put("caseNotIncluded", caseNotIncluded);
		context.put("caseIncluded", caseIncluded);
	    return "editProduct";
    }
    
public void toEditProduct(String id)throws Exception{
    	
    	ActionContext context=ActionContext.getContext();		
		System.out.println("in to EditProduct fucntion the product id is "+id);
		Product product=ProductDao.getProduct(Integer.parseInt(id));
		List<TestCase> caseIncluded=new ArrayList<TestCase>(product.gettestcases());
		List<TestCase> caseNotIncluded=TestCaseDao.getTestCaseList();
		caseNotIncluded.removeAll(caseIncluded);
		context.put("product", product);
		context.put("caseNotIncluded", caseNotIncluded);
		context.put("caseIncluded", caseIncluded);
    }
    
    public String editProductionCase()throws Exception{
		return "editProductionCase";
	}
    
    public String ProductionCaseManagement()throws Exception{  
    	return "editProduct";
    }
}