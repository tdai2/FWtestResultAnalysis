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

    	function selectRow(tr)
    	{
        	var caseID = tr.cells[0].innerText;
            document.getElementById("caseID").value=caseID;
            alert("caseID="+caseID);
            var caseResult = tr.cells[3].innerText;
            document.getElementById("testResult").value=testResult;
            alert("testResult="+testResult);
            var trackerNO = tr.cells[4].innerText;
            document.getElementById("trackerNO").value=trackerNO;
            var notes = tr.cells[5].innerText;
            document.getElementById("notes").value=notes;
            alert("trackerNO="+trackerNO);
            alert("notes="+notes);            
        	}
        function showProduct()
        {
            var xmlhtpp;
            if(window.XMLHttpRequest)
                {
                xmlhttp=new XMLHttpRequest();
                }
            else
                {
                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }

           xmlhttp.onreadystatechange=function()
           {
               if(xmlhttp.readyState==4 && xmlhttp.status==200)
                   {
                   
                   }
               }
            
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
<s:form action="TestResultAction" theme="simple">
		<table width="100%" border="0" align="center" cellpadding="0"
			cellspacing="0">
			<tr>
				<td height="30px" width="100%">
					<table width="100%" border="0" align="center" cellpadding="0"
						cellspacing="0">
					<tr>
						<td bgcolor="#ffffff" width="200px">			
							 <div class="style2">
							 <s:select label="Please chosse Products"
							  name="pID"
							  headerKey="-1"
							  hearderValue="Select Product"
							  list="#request.productList"  listValue="production" listKey="id"  
							 />
							 </div>
						</td>
						
						<td colspan="2" bgcolor="#ffffff" align="center">
							<div class="style2">
							 <s:submit value="submit" method="inputConfig" theme="simple" onclick="return check();"></s:submit>
							 </div>
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
										<td valign="bottom">Please chosse SW configuration
										</td>
										
										<td bgcolor="d3eaef" align="right" colspan="8" >
								           <div style="margin-right:20px;">
							 	            <s:a action="swConfigAction" method="toAddSwConfig">
                 								Add A SW config
				           					</s:a>
								           </div>
							            </td>			
							            
									</tr>
								</table>
							</td>
						</tr>
						<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
						<tr>
						    <td bgcolor="d3eaef" align="center">
						    <div class="style2">
						    Choose The SW configurtion 
						    </div>
						    </td>
						
							<td bgcolor="d3eaef" align="center">
						    <div class="style2">
						    BMC Version
						    </div>
						    </td>
						
							<td bgcolor="d3eaef" align="center">
						    <div class="style2">
						    FRUSDR Version
						   </div>
						   </td>							
						   						   
						   <td bgcolor="d3eaef" align="center">
						   <div class="style2">
						   HSC FW Version
						   </div>
						   </td>
						    
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       PSU FW Version
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       BIOS Version
			   	           </div>
			               </td>
			               
			               <td bgcolor="d3eaef" align="center">
   				           <div class="style2">
					       ME Version
			   	           </div>
			               </td>
						</tr>
						<s:iterator var="swConfig" value="#request.SwConfig"> 
								<tr>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
									    <input type="radio" name="swCID" value="${swConfig.id}" >
										</div>
									</td>
									
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
										<s:property value="#swConfig.bmcVersion"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#swConfig.fusdrVersion"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#swConfig.hscVersion"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#swConfig.psuVersion"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#swConfig.biosVersion"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#swConfig.meVersion"></s:property>
										</div>
									</td>
								</tr>
						</s:iterator>
					</table>
				</table>>
				</td>>
			</tr>
			<table width="100%" border="0" cellpadding="0" cellspacing="1"
						bgcolor="#a8c7ce">
			<tr>
				<td height="30px" width="100%">
					<table width="100%" border="0" align="center" cellpadding="1"
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
										
										<td bgcolor="d3eaef" align="right" colspan="8" >
								           <div style="margin-right:20px;">
							 	            <s:a action="hwConfigAction" method="toAddHwConfig">
                 								Add A HW config
				           					</s:a>
								           </div>
							            </td>										
									</td>
									</tr>
								</table>
							</td>
						</tr>
						</table>
						<table width="100%" border="0" align="center" cellpadding="0" cellspacing="1">
						<tr>
									<tr>
								    <td bgcolor="d3eaef" align="center">
						            <div class="style3">
						            Choose The HW configuration
						            </div>
						            </td>			
									
									<td bgcolor="d3eaef" align="center">
						            <div class="style3">
						            Base Board SKU:
						            </div>
						            </td>							
						   						   
						            <td bgcolor="d3eaef" align="center">
						            <div class="style3">
						             Base Board Fab
						            </div>
						            </td>
						    
			                        <td bgcolor="d3eaef" align="center">
   				                    <div class="style3">
					                 Chassis
			   	                    </div>
			                        </td>
			               
			                        <td bgcolor="d3eaef" align="center">
   				                    <div class="style3">
			   	                    </div>
			                        </td>
			               
			                        <td bgcolor="d3eaef" align="center">
   				                    <div class="style3">
					                PSU
					                </div>
			                        </td>
			               
			                        <td bgcolor="d3eaef" align="center">
   				                    <div class="style3">
					                CPU
			   	                    </div>
			                        </td>
			               
			                        <td bgcolor="d3eaef" align="center">
   				                    <div class="style3">
					                Memory
			   	                    </div>
			                        </td>
								</tr>							
						</tr>
						<s:iterator var="hwConfig" value="#request.HwConfig"> 
								<tr>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
									    <input type="radio" name="hwCID" value="${hwConfig.id}" >
										</div>
									</td>
									
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
										<s:property value="#hwConfig.boardSku"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#hwConfig.boardFab"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#hwConfig.chassis"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#hwConfig.hsbp"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#hwConfig.psu"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#hwConfig.cpu"></s:property>
										</div>
									</td>
									<td bgcolor="#ffffff" align="center">
										<div class="style3">
											<s:property value="#hwConfig.memory"></s:property>
										</div>
									</td>
								</tr>
						</s:iterator>
					</table>
				</td>
			</tr>
			</table>
			</table>>		
          </s:form>

</body>
</html>
