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
	
	<script type="text/javascript">
		function selectRow(tr)
    	{
        	var results=document.getElementById("jsvar");  
        	//results=100;      
            alert("results="+results);
        	}
		
		</script>
	
		<base href="<%=basePath%>">

		<title>'TestCaselist.jsp' starting page</title>

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
	</head>

	<body>
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30px" width="100%">
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
						<tr>
							<td bgcolor="#353c44" width="100%" height="24px">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td width="18px" valign="bottom">
										</td>
										<td valign="bottom">
											<span class="style1">Test Result List</span>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td>
					<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						
						<tr width="100%" height="50px" > 
							<td bgcolor="d3eaef" align="right" colspan="8" >
								<div style="margin-right:20px;">
									<s:a action="TestResultAction" method="toEditTestConfig">
									Add Test Result
									</s:a>
								</div>
							</td>
						</tr>
						
						<tr>
						
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   Result ID
						   </div>
						   </td>
						
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   Case Title
						   </div>
						   </td>
						   
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   Product
						   </div>
						   </td>							
						   						   
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   Result
						   </div>
						   </td>
						    
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       BMC version
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       FRUSDR version
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Board SKU
			   	           </div>
			               </td>
						</tr>
						
						<s:iterator var="result" value="#request.testResultList">
								<tr>
									<td bgcolor="#ffffff" align="center" >
										<div class="style3">
										<s:property value="#result.testResultId"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.tcase.testTitle"></s:property>
										</div>
									</td>

									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.product.production"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.caseResult"></s:property>
											
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.tcase"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.swConfig.bmcVersion"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.hwConfig.boardSKU"></s:property>
										</div>
									</td>
									
								</tr>
						
						</s:iterator>
					</table>
				</td>
			</tr>

		
		</table>
		</td>
		</tr>

		</table>

	</body>
</html>
