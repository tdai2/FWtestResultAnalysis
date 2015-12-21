<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>'editProduct.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<style type="text/css">
body {
	margin-left: 3px;
	margin-top: 0px;
	margin-right: 3px;
	margin-bottom: 0px;
}

.style1 {
	color: #e1e2e3;
	font-size: 12px;
}

.style2 {
	color: #000000;
	font-size: 12px;
}

.style3 {
	color: #344b50;
	font-size: 12px;
}

.style3 a {
	color: #6A5ACD;
}

.style4 {
	font-size: 12px;
	color: #295568;
}
</style>


    <script type="text/javascript">
    
    	function check(){
    		var name=document.getElementById("name");
    		if(name=="")
    		{
    			alert("Name can't be Empty！");
    			return false;
    		}
    		var name=document.getElementById("uType");
    		if(uType=="")
    		{
    			alert("Type can't be Empty！");
    			return false;
    		}
    		return true;
    	}
    </script>
    
	</head>

<body>
<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
   <tr>
          		<td>
          			<s:form action="productaction" theme="simple">
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
					<tr>
						<th bgcolor="#ffffff" align="center" width="60px">
							<div class="style2">ID：</div>
						</th >
						
						<th bgcolor="#ffffff" align="center" width="60px">			
							 <div class="style2">Product</div>
						</th>
						<th bgcolor="#ffffff" align="center" width="60px">
							<div class="style2">Family：</div>
						</th >
						
					</tr>
					<tr>
					    <td bgcolor="#ffffff"  width="60px" >
							<div class="style2">
								<s:property value="#product.id"></s:property>
								<s:hidden name="pid" value="%{#product.id}" theme="simple"></s:hidden>
							</div>
						</td >
							
						<td bgcolor="#ffffff"  width="60px" >
							<div class="style2">
								<s:textfield name="family" value="%{#product.family}" theme="simple"></s:textfield>
							</div>
						</td >
						
						<td bgcolor="#ffffff"  width="60px" >
							<div class="style2">
								<s:textfield name="production" value="%{#product.production}" theme="simple"></s:textfield>
							</div>
						</td >
						<td  bgcolor="#ffffff" align="center">
							<div class="style2">
							 <s:submit value="submit" method="editProduct" theme="simple" onclick="return check();"></s:submit>
							 </div>
						</td>
					</tr>
		
	                 </table>
					</s:form>
		
					<s:form action="productaction" theme="simple">
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
	 				<tr>		
						<tr>
						
							<td bgcolor="d3eaef" align="center">
						    <div class="style2">
						    ID
						    </div>
						    </td>
						
							<td bgcolor="d3eaef" align="center">
						    <div class="style2">
						    Catagory
						   </div>
						   </td>							
						   						   
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   Title
						   </div>
						   </td>
						    
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Version
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Case included in Project or not
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Change
			   	           </div>
			               </td>
			               
					    </tr>
	
						<s:hidden name="pid" value="%{#product.id}" theme="simple"></s:hidden>
						<s:iterator var="caseNotIncluded" value="#request.caseNotIncluded">
								<tr>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
										<s:property value="#caseNotIncluded.id"></s:property>										
										</div>
									</td>

									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#caseNotIncluded.testCatagory"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#caseNotIncluded.testTitle"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#caseNotIncluded.testCaseVersion"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
									 
									<s:checkbox name="notIncluded" value="false" fieldValue="included" />  
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
									<s:hidden name="cid" value="%{#caseNotIncluded.id}" theme="simple"></s:hidden>									
									<s:submit value="add to product" method="addProductCase" theme="simple" onclick="return check();"></s:submit>
										</div>
									</td>
									 
								</tr>
						</s:iterator>
						
						<s:iterator var="caseIncluded" value="#request.caseIncluded">
								<tr>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
										<s:property value="#caseIncluded.id" />
										</div>
									</td>

									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#caseIncluded.testCatagory"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#caseIncluded.testTitle"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#caseIncluded.testCaseVersion"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
										<s:checkbox name="Included"  value="true" fieldValue="included"/>
										</div>
									</td>
									
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
									<!--<s:hidden name="rid" value="#caseIncluded.id" theme="simple"></s:hidden>-->	
									<!-- <s:hidden name="rid" value="%{#caseIncluded.id}" theme="simple"></s:hidden> -->
									
									<!-- <s:set var="rid" value="#caseIncluded.id" /> --> 
									<s:submit value="delete from product" method="removeProductCase" theme="simple" onclick="return check();">
									<s:hidden name="rid" value="%{#caseIncluded.id}" theme="simple"></s:hidden>
									</s:submit>
									
										</div>
								</tr>
							</s:iterator>
							 
							
					</table>
					</s:form>
				</td>
          
          </tr>
		
</table>
 
	</body>
</html>
