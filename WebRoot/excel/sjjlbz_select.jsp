<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>数字框</title>
    <link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
	<style type="text/css">
		#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			color:#666;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
	</style>
	
	
	<script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/sjjlbz.js"></script>
	
    <script src="<%=basePath%>/script/jquery-form.js"></script>
    <script src="<%=basePath%>/script/jquery.validate.min.js"></script>
<!-- <script type="text/javascript" src="<%=basePath%>/script/datagrid-detailview.js"></script> -->
	
  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
 
</head>

<body>

 <form id="sjjlbz_select" method="post" >
 
 请选择导出项：<br>
<input name="Fruit" type="checkbox" value="" />苹果<br>
<input name="Fruit" type="checkbox" value="" />桃子<br> 
<input name="Fruit" type="checkbox" value="" />香蕉<br> 
<input name="Fruit" type="checkbox" value="" />梨<br>
 
     <a href="#" class="easyui-linkbutton" id="btnExport" onclick="ShowExport()" >确定</a> 　
 
 </form>
   

</body>

</html>
