<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>武器装备科研生产许可证需求</title>
    <link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
	<script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/json2.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/wqwqxkzxq.js"></script>
</head>

<body>

<div data-options="region:'center',split:false">
	
	<!-- 武器装备科研生产许可证需求-->
	<table id="wqzbkyscxkzxq" ></table>
	<br>
	<div style="text-align:center">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submit()">提交</a>
	</div>
	<br>
	
	<!-- 产值或销售收入情况-->
	<table id="srqk">
	</table>
	<br><br>	
	
	<!-- 武器装备科研生产的许可专业（产品）-->
	<table id="xkzycp">
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
	
	<div id="xkzycp">
		<form id="frmxkzycp" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>项目代码:</dd>
				<dd><input size="15" id="xmdm" name="xmdm" /></dd>
			</dl>
			<dl>
				<dd>项目名称:</dd>
				<dd><input size="15" id="xmmc" name="xmmc" /></dd>
			</dl>
						<dl>
				<dd>科研/生产:</dd>
				<dd><input size="15" id="kysc" name="kysc" /></dd>
			</dl>
			<dl>
				<dd>许可类型:</dd>
				<dd><input size="15" id="xklx" name="xklx" /></dd>
			</dl>
		</form>
	</div>

	
</div>	

</div>


</body>

</html>
