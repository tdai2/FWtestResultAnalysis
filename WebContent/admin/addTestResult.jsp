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
											<span class="style1">Add Test Result for </span>
											<span class="style1">
											<s:property value="#request.product"></s:property>
											</span>
										</td>
									</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<s:form action="TestResultAction" theme="simple">
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
											<span class="style1">SW Configuration: </span>
										</td>
									</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td bgcolor="#353c44" width="100%" height="24px">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
									<td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   BMC Version:
						   	<s:textfield name="BMC" theme="simple"></s:textfield>
						   </div>
						   </td>							
						   						   
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   FRUSDR Version
						   <s:textfield name="FRUSDR" theme="simple"></s:textfield>
						   </div>
						   </td>
						    
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       HSC FW Version
					       <s:textfield name="HSC" theme="simple"></s:textfield>
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       PSU FW Version
					       <s:textfield name="PSUFW" theme="simple"></s:textfield>
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       BIOS Version
					       <s:textfield name="BIOS" theme="simple"></s:textfield>
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       ME Version
					       <s:textfield name="ME" theme="simple"></s:textfield>
			   	           </div>
			               </td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
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
											<span class="style1">HW Configuration: </span>
										</td>
									</td>
									</tr>
								</table>
							</td>
						</tr>
						<tr>
							<td bgcolor="#353c44" width="100%" height="24px">
								<table width="100%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
									<td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   Base Board SKU:
						   	<s:textfield name="bbSKU" theme="simple"></s:textfield>
						   </div>
						   </td>							
						   						   
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   Base Board Fab
						   <s:textfield name="Fab" theme="simple"></s:textfield>
						   </div>
						   </td>
						    
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Chassis
					       <s:textfield name="Chassis" theme="simple"></s:textfield>
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       HSBP
					       <s:textfield name="HSBP" theme="simple"></s:textfield>
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       PSU
					       <s:textfield name="PSU" theme="simple"></s:textfield>
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       CPU
					       <s:textfield name="CPU" theme="simple"></s:textfield>
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Memory
					       <s:textfield name="Memory" theme="simple"></s:textfield>
			   	           </div>
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
						<tr>				
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   Case Title
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
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Edit
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Delete
			   	           </div>
			               </td>
			               
						</tr>
	

						<s:iterator var="result" value="#request.caseList">
						
								<tr>

									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.testTitle"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.testTitle"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.testTitle"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.testTitle"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#result.testTitle"></s:property>
										</div>
									</td>
									
									
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:a action="TestCaseAction" method="toEditTestResult">
												Edit
												<s:param name="id">${result.id}</s:param>
											</s:a>
										</div>
									</td>
									
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:a action="TestCaseAction" method="delTestResult">
												Delete
												<s:param name="id">${result.id}</s:param>
											</s:a>
										</div>
									</td>
								</tr>
						
						</s:iterator>
					</table>
				</td>
			</tr>
		<tr height="50px">
						<td colspan="2" bgcolor="#ffffff" align="center">
							<div class="style2">
							 <s:submit value="submit" method="addTestResult" theme="simple" onclick="return check();"></s:submit>
							 </div>
						</td>
					</tr>
			</s:form>
		</table>
		</td>
		</tr>

		</table>

	</body>
</html>
