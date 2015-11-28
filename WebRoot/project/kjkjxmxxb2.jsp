<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>科技项目信息</title>
    <link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
	<script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/json2.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/kjkjxmxxb2.js"></script>
</head>

<body>

<div data-options="region:'center',split:false">
	
	<!-- 科技项目信息-->
	<table id="kjxmxx" ></table>
	<br>
	<div style="text-align:center">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submit()">提交</a>
	</div>
	<br>
	<!-- 其他参加单位-->
	<table id="cjdw">
	</table>
	<br><br>	

		<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="cjdw">
		<form id="frmcjdw" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>序号:</dd>
				<dd><input size="15" id="xh" name="xh" /></dd>
			</dl>
			<dl>
				<dd>单位名称:</dd>
				<dd><input size="15" id="dwmc" name="dwmc" /></dd>
			</dl>
<!-- 			<dl> -->
<!-- 				<dd>科技项目信息表:</dd> -->
<!-- 				<dd><input size="15" id="FK_kj_kjxmxxb" name="FK_kj_kjxmxxb" /></dd> -->
<!-- 			</dl> -->

		</form>
	</div>
	
</div>	

</div>


</body>

</html>
