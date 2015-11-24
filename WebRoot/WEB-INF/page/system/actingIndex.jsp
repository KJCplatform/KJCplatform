<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>TestData编辑</title>
<link href="${pageContext.request.contextPath }/css/Style.css" type="text/css" rel="stylesheet">

  <script language="javascript"> 
  function checkchar(){
  
  if(document.Form1.stationRun.value.length>500){
  
     alert("不能超过50字");
     return;
  }
  if(document.Form1.devRun.value.length>500){
  
     alert("不能超过50字");
     return;
  }
  document.Form1.action="system/TestDataAction_save.do";
  document.Form1.submit();
  alert(" TestData保存成功!");
  }
  function addEnter(element){
   document.getElementById(element).value = document.getElementById(element).value+"<br>";
   
  }
  </script>


</head>

<body>
<s:form name="Form1" id="Form1" method="post">

	<table cellspacing="1" cellpadding="5" width="90%" align="center" bgcolor="#f5fafe" style="border:1px solid #8ba7e3" border="0">

        <tr>
			<td class="ta_01" colspan=2 align="center" background="${pageContext.request.contextPath }/images/b-info.gif">
			<font face="宋体" size="2"><strong>TestData编辑</strong></font>
			</td>
		</tr>
		<TR height=10><td></td><td></td></TR>
		
		<tr>
			<td class="ta_01" align="center" bgcolor="#f5fafe" width="15%">事  件：</td>
			<td class="ta_01" bgcolor="#ffffff" style="word-break: break-all">
				<s:textarea name="event" id="event" cssStyle="width: 500px; height: 160px; padding: 1;FONT-FAMILY: 宋体; FONT-SIZE: 9pt" />
			</td>
			
		</tr>
		<tr>
			<td class="ta_01" align="center" bgcolor="#f5fafe" width="15%">详细描述：</td>
			<td class="ta_01" bgcolor="#ffffff" style="word-break: break-all">
				<s:textarea name="discription" id="discription" cssStyle="width: 500px; height: 160px; padding: 1;FONT-FAMILY: 宋体; FONT-SIZE: 9pt" />
			</td>
			
		</tr>
        <tr>
			<td class="ta_01" style="width: 100%" align="center" bgcolor="#f5fafe" colspan="2">
			<input type="button" name="BT_Submit" value="保存" onclick="checkchar()" id="BT_Submit" style="font-size:12px; color:black; height=20;width=50">
			</td>
		</tr>
	</table>
	　 
</s:form>
<s:form name="Form2" id="Form2"  method="post">
	<table cellSpacing="1" cellPadding="0" width="90%" align="center" bgColor="#f5fafe" border="0">
		<TBODY>
			<TR height=10><td></td></TR>			
			<tr>
			  	<td>
	                <TABLE style="WIDTH: 105px; HEIGHT: 20px" border="0">
									<TR>
										<TD align="center" background="${pageContext.request.contextPath }/images/cotNavGround.gif"><img src="${pageContext.request.contextPath }/images/yin.gif" width="15"></TD>
										<TD class="DropShadow" background="${pageContext.request.contextPath }/images/cotNavGround.gif">TestData列表</TD>
									</TR>
		             </TABLE>
                  </td>
			</tr>
			<tr>
				<td class="ta_01" align="center" bgColor="#f5fafe" colspan=3>			
						<table cellspacing="0" cellpadding="1" rules="all" bordercolor="gray" border="1" id="DataGrid1"
							style="BORDER-RIGHT:gray 1px solid; BORDER-TOP:gray 1px solid; BORDER-LEFT:gray 1px solid; WIDTH:100%; WORD-BREAK:break-all; BORDER-BOTTOM:gray 1px solid; BORDER-COLLAPSE:collapse; BACKGROUND-COLOR:#f5fafe; WORD-WRAP:break-word">
							<tr style="FONT-WEIGHT:bold;FONT-SIZE:12pt;HEIGHT:25px;BACKGROUND-COLOR:#afd1f3">
							    <td align="center" width="40%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">event</td>
								<td align="center" width="40%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">discription</td>
								<td align="center" width="20%" height=22 background="${pageContext.request.contextPath }/images/tablehead.jpg">date</td>
							</tr>
							<s:if test="#request.commonList!=null">
								<s:iterator value="%{#request.commonList}" var="common">
									<tr onmouseover="this.style.backgroundColor = 'white'" onmouseout="this.style.backgroundColor = '#F5FAFE';">
										<td style="HEIGHT:22px" align="center" width="40%">
											<s:property value="%{#common.event}"/>
										</td>
										<td style="HEIGHT:22px" align="center" width="40%">
											<s:property value="%{#common.discription}"/>
										</td>
										<td style="HEIGHT:22px" align="center" width="20%">
											<s:property value="%{#common.date}"/>
										</td>
									</tr>
								</s:iterator>
							</s:if>
						</table>
					</td>
				</tr>        
		</TBODY>
	</table>
</s:form>
</body>
</html>