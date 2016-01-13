<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'itemlist.jsp' starting page</title>
    
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
		.style3 a{
			color:#6A5ACD;
		}
		.style4 {
	       font-size: 12px;
	       color: #295568;
		}
				a:Link       {
			color:#0000ff;
		 font-family: "Tahoma,宋体";  text-decoration: none;}
a:visited    { color:#0000ff; font-family: "Tahoma,宋体"; text-decoration: none;}
a:hover      { color:#0000ff; font-family: "Tahoma,宋体";  text-decoration: underline;}
a:active     { color:#0000ff; "Tahoma,宋体";  text-decoration: none;}
a            { color:#0000ff; text-decoration: none; }
#txt{
			width:100%;
			height: 200px;
		}
		#txt{
			width: 100%;
	height: 100px;
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
    		var pwd=document.getElementById("pwd");
    		if(num=="")
    		{
    			alert("Password can't be empty！");
    			return false;
    		}
    		var repwd=document.getElementById("repwd");
    		if(repwd!=pwd)
    		{
    			alert("Password are not identical！");
    			return false;
    		}
    		return true;
    	}
    </script>
  </head>
  
  <body>
    	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
             <td height="30px" width="100%">
				<table  width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
				   <tr>
					<td bgcolor="#353c44" width="100%" height="24px">
						<table width="100%" border="0" align="center" cellpadding="0"
							cellspacing="0">
							<tr >
								<td valign="bottom">
									<span class="style1" >Add Hardware Configuration</span>
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
          			<s:form action="hwConfigAction" theme="simple">
					<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
					<tr>
						<td bgcolor="#ffffff" align="center" width="150px">
							<div class="style2">Board SKU：</div>
						</td >
						<td bgcolor="#ffffff"  width="150px">
							<div class="style2">
								<s:textfield name="boardSku" theme="simple"></s:textfield>
							</div>
						</td >
					</tr>
					
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">Board Fab:</div>
						</td>
						<td bgcolor="#ffffff" width="200px">			
							 <div class="style2">
								<s:textfield name="boardFab" theme="simple"></s:textfield>
							 </div>
						</td>
					</tr>
					
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">HSBP:</div>
						</td>
						<td bgcolor="#ffffff" width="200px">			
							 <div class="style2">
								<s:textfield name="hsbp" theme="simple"></s:textfield>
							 </div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">Chassis:</div>
						</td>
						<td bgcolor="#ffffff" width="200px">			
							 <div class="style2">
								<s:textfield name="chassis" theme="simple"></s:textfield>
							 </div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">PSU:</div>
						</td>
						<td bgcolor="#ffffff" width="200px">			
							 <div class="style2">
								<s:textfield name="psu" theme="simple"></s:textfield>
							 </div>
						</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">CPU:</div>
						</td>
						<td bgcolor="#ffffff" width="200px">			
							 <div class="style2">
								<s:textfield name="cpu" theme="simple"></s:textfield>
							 </div>
						</td>
					</tr>
					
					<tr>
						<td bgcolor="#ffffff" align="center" width="200px">			
							 <div class="style2">Memory:</div>
						</td>
						<td bgcolor="#ffffff" width="200px">			
							 <div class="style2">
								<s:textfield name="memory" theme="simple"></s:textfield>
							 </div>
						</td>
					</tr>
		
					<tr height="50px">
						<td colspan="2" bgcolor="#ffffff" align="center">
							<div class="style2">
							 <s:submit value="submit" method="addHwConfig" theme="simple" onclick="return check();"></s:submit>
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
