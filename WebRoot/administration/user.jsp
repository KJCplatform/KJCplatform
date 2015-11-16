<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>用户管理</title>
   	<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
    	$(function() {
    		
    		
    		 $('#cc').combobox({    
    		        url:'<%=basePath%>/system/UserAction_home.action',    
    		        valueField:'id',    
    		        textField:'text'   
    		    }); 
    	});
    
    </script>
  </head> 
  <body>
    <p>用户选择：<input id="cc" name = "user"  value = "请选择"></p>
    <br>
    <form>
  		<fieldset>
   			 <legend>权限分配</legend>
    			身高：<input type="text" />
   				 体重：<input type="text" />
 		 </fieldset>
	</form>
  </body>
</html>
