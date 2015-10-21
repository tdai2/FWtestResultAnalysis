package com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;

import com.dao.BookDao;
import com.dao.TestCaseDao;
import com.model.Book;
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
		return "toAddTestCase";
	}
	public String addTestCase()throws Exception{
		ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String catagory=request.getParameter("catagory");
		String title=request.getParameter("Title");
		String version=request.getParameter("Version");
		String pID=request.getParameter("pID");
		TestCaseDao.addTestCase(catagory,title,version,Integer.parseInt(pID));
		List<TestCase> testCaseList=TestCaseDao.getTestCaseList();
		context.put("testCaseList", testCaseList);
		return "testCaseList";
	}
	
	public String showTestCaseList()throws Exception{
		ActionContext context=ActionContext.getContext();
	
		List<TestCase> testCaseList=TestCaseDao.getTestCaseList();
		context.put("testCaseList", testCaseList);
		
		return "testCaseList";
	}

    public String editTestCase()throws Exception{
    	ActionContext context=ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String catagory=request.getParameter("testCatagory");
		String title=request.getParameter("testTitle");
		String version=request.getParameter("testCaseVersion");
		String pID=request.getParameter("productID");
		TestCaseDao.editTestCase(catagory,title,version,Integer.parseInt(pID),id);
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