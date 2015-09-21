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

		<title>'Userlist.jsp' starting page</title>

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
											<span class="style1">User List</span>
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
									<s:a action="useraction" method="toAddUser">
									Add user
									</s:a>
								</div>
							</td>
						
						</tr>
						<tr>
						
							<td bgcolor="d3eaef" align="center">
						    <div class="style2">
						    ID
						    </div>
						    </td>
						
							<td bgcolor="d3eaef" align="center">
						    <div class="style2">
						    User Name
						   </div>
						   </td>							
						   						   
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   usertype
						   </div>
						   </td>
						
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   email
						   </div>
						   </td>
						   
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   ssid
						   </div>
						   </td>
			           
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       phone
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Operation
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       Operation
			   	           </div>
			               </td>								
						</tr>
	

						<s:iterator var="user" value="#request.userlist">
						
								<tr>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
										<s:property value="#user.id"></s:property>
										</div>
									</td>

									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#user.name"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#user.type"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#user.email"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#user.ssid"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#user.phone"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:a action="useraction" method="delUser">
												Delete
												<s:param name="id">${user.id}</s:param>
											</s:a>
										</div>
									</td>
									
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:a action="useraction" method="delUser">
												Delete
												<s:param name="id">${user.id}</s:param>
											</s:a>
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
