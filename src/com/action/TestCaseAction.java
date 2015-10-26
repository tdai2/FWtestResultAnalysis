package com.action;

import java.util.*;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.BookDao;
import com.dao.TestCaseDao;
import com.model.Book;
import com.model.Product;
import com.dao.ProductDao;
import com.model.HibernateSessionFactory;
import com.model.TestCase;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class TestCaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	
	
	public String delTestCase()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		TestCaseDao.deleteTestCase(Integer.parseInt(id));
		List<TestCase> testCaseList=TestCaseDao.getTestCaseList();
		context.put("testCaselist", testCaseList);
		return "testCaseList";
	}
	
	public String toAddTestCase()throws Exception{
		ActionContext context=ActionContext.getContext();
		List<Product> productList=ProductDao.getProductList();
		context.put("productList", productList);
		return "toAddTestCase";
	}
	public String addTestCase()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String catagory=request.getParameter("catagory");
		String title=request.getParameter("Title");
		String version=request.getParameter("Version");
		String[] products = request.getParameterValues("pList");
		TestCaseDao.addTestCase(catagory,title,version,getProductSet(products));
		List<TestCase> testCaseList=TestCaseDao.getTestCaseList();
		context.put("testCaseList", testCaseList);
		return "testCaseList";
	}
	public Set<Product> getProductSet(String[] pID){
		Set<Product> product = new HashSet<Product> (); 
		System.out.println("In getProductSet");
		for(int i=0;i<pID.length;i++){
			product.add(ProductDao.getProduct(Integer.parseInt(pID[i])));
			
		}
		System.out.println("Current pId is "+product.toString());
		return product;
	}
	
	public String showTestCaseList()throws Exception{
		ActionContext context=ActionContext.getContext();
	
		List<TestCase> testCaseList=TestCaseDao.getTestCaseList();
		context.put("testCaseList", testCaseList);
		List<Product> productList=ProductDao.getProductList();
		context.put("productList",productList);
		return "testCaseList";
	}

    public String editTestCase()throws Exception{
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String catagory=request.getParameter("testCatagory");
		String title=request.getParameter("testTitle");
		String version=request.getParameter("testCaseVersion");
		String[] products = request.getParameterValues("pList");
		TestCaseDao.editTestCase(catagory,title,version,getProductSet(products),id);
		List<TestCase> testCaseList=TestCaseDao.getTestCaseList();
		context.put("testCaselist", testCaseList);
		return "testCaseList";
    }
    public String toEditTestCase()throws Exception{
    	
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		TestCase testCase=TestCaseDao.getTestCase(Integer.parseInt(id));
		context.put("testCase", testCase);
	    return "editTestCase";
    }
    
}