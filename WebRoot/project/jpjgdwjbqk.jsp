<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>军工单位基本情况</title>
    <link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
	<script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/json2.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/jpjgdwjbqk.js"></script>
</head>

<body>

<div data-options="region:'center',split:false">
	
	<!-- 军工单位基本情况-->
	<table id="jgdwjbqk" ></table>
	<br>
	<div style="text-align:center">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submit()">submit</a>
	</div>
	<br>
	
	<!-- 产值或销售收入情况-->
	<table id="srqk">
	</table>
	<br><br>	
	
	<!-- 武器装备科研生产的许可专业（产品）-->
	<table id="ry">
	</table>
	<br><br>

		<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="srqk">
		<form id="frmsrqk" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>年度:</dd>
				<dd><input size="15" id="year" name="year" /></dd>
			</dl>
			<dl>
				<dd>总产值（或销售收入）:</dd>
				<dd><input size="15" id="zcz" name="zcz" /></dd>
			</dl>
			<dl>
				<dd>军品:</dd>
				<dd><input size="15" id="jp" name="jp" /></dd>
			</dl>
			<dl>
				<dd>民品:</dd>
				<dd><input size="15" id="mp" name="mp" /></dd>
			</dl>

		</form>
	</div>
	
	<div id="ry">
		<form id="frmry" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>部门及职务:</dd>
				<dd><input size="15" id="bmzw" name="bmzw" /></dd>
			</dl>
			<dl>
				<dd>姓名:</dd>
				<dd><input size="15" id="xm" name="xm" /></dd>
			</dl>
						<dl>
				<dd>办公电话:</dd>
				<dd><input size="15" id="bgdh" name="bgdh" /></dd>
			</dl>
			<dl>
				<dd>手机:</dd>
				<dd><input size="15" id="sj" name="sj" /></dd>
			</dl>
		</form>
	</div>

	
</div>	

</div>


</body>

</html>
