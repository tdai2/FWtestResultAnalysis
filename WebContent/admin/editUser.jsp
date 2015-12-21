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

		<title>'editUser.jsp' starting page</title>

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
          			<s:form action="useraction" theme="simple">
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
					<tr>
						<td bgcolor="#ffffff" align="center" width="150px">
							<div class="style2">ID：</div>
						</td >
						<td bgcolor="#ffffff"  width="60px" colspan="2">
							<div class="style2">
							<s:property value="#user.id"></s:property>
								<s:hidden name="id" value="%{#user.id}" theme="simple"></s:hidden>
							</div>
						</td >
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="150px">
							<div class="style2">Name：</div>
						</td >
						<td bgcolor="#ffffff"  width="60px" colspan="2">
							<div class="style2">
								<s:textfield name="name" value="%{#user.name}" theme="simple"></s:textfield>
							</div>
						</td >
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">User Type</div>
						</td>
						<td bgcolor="#ffffff"  width="60px" colspan="2">
							<div class="style2">
								<s:textfield name="uType" value="%{#user.type}" theme="simple"></s:textfield>
							</div>
						</td >
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">Password：</div>
						</td>
						<td bgcolor="#ffffff"  width="60px" colspan="2">
							<div class="style2">
								<s:textfield name="pwd" value="%{#user.pwd}" theme="simple"></s:textfield>
							</div>
						</td >
					</tr>
						
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">Email</div>
						</td>
						<td bgcolor="#ffffff"  width="60px" colspan="2">
							<div class="style2">
								<s:textfield name="email" value="%{#user.email}" theme="simple"></s:textfield>
							</div>
						</td >
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">SSid</div>
						</td>
						<td bgcolor="#ffffff"  width="60px" colspan="2">
							<div class="style2">
								<s:textfield name="ssid" value="%{#user.ssid}" theme="simple"></s:textfield>
							</div>
						</td >
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">phone</div>
						</td>
						<td bgcolor="#ffffff"  width="60px" colspan="2">
							<div class="style2">
								<s:textfield name="phone" value="%{#user.phone}" theme="simple"></s:textfield>
							</div>
						</td >
					</tr>
					
					<tr height="50px">
						<td colspan="2" bgcolor="#ffffff" align="center">
							<div class="style2">
							 <s:submit value="submit" method="editUser" theme="simple" onclick="return check();"></s:submit>
							 </div>
						</td>
					</tr>
					</table>
					</s:form>
				</td>
          
          </tr>
						
</table>

	</body>
</html>
