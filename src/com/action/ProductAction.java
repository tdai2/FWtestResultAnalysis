package com.action;

import java.util.List;

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
		String id = request.getParameter("id");
		String family=request.getParameter("family");
		String production=request.getParameter("production");
		ProductDao.editProduct(id,family, production);
		List<Product> productList=ProductDao.getProductList();
		context.put("productlist", productList);
		return "product";
    }
    public String toEditProduct()throws Exception{
    	
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id=request.getParameter("id");
		Product product=ProductDao.getProduct(Integer.parseInt(id));
		context.put("product", product);
		List<TestCase> testCaseList=TestCaseDao.getTestCaseList();
		context.put("testCaseList", testCaseList);
	    return "editProduct";
    }
    
    public String editProductionCase()throws Exception{
		return "editProductionCase";
	}
    
    public String ProductionCaseManagement()throws Exception{  
    	return "editProduct";
    }
}