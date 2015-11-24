<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>高新技术企业认定备案</title>
    <link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
	<script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/json2.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/kjgxqybab.js"></script>
</head>

<body>

<div data-options="region:'center',split:false">
	
	<!-- 高新技术企业认定备案-->
	<table id="gxjsqyrdba" ></table>
	<br>
	<div style="text-align:center">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submit()">提交</a>
	</div>
	<br>
	
	<!-- 上年度高新技术产品（服务）情况-->
	<table id="gxcp">
	</table>
	<br><br>	
	
	<!-- 企业研究开发项目情况 -->
	<table id="yfxm">
	</table>
	<br><br>
	
		<!-- 近3年内获得的自主知识产权情况 -->
	<table id="zscq">
	</table>
	<br><br>

		<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="gxcp">
		<form id="frmgxcp" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>产品编号:</dd>
				<dd><input size="15" id="cpbh" name="cpbh" /></dd>
			</dl>
			<dl>
				<dd>项目（服务）名称:</dd>
				<dd><input size="15" id="cpmc" name="cpmc" /></dd>
			</dl>
			<dl>
				<dd>上年度销售收入:</dd>
				<dd><input size="15" id="shsr" name="shsr" /></dd>
			</dl>

		</form>
	</div>
	
	<div id="yfxm">
		<form id="frmyfxm" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>项目编号:</dd>
				<dd><input size="15" id="xmbh" name="xmbh" /></dd>
			</dl>
			<dl>
				<dd>项目名称:</dd>
				<dd><input size="15" id="xmmc" name="xmmc" /></dd>
			</dl>
						<dl>
				<dd>项目研发经费-合计:</dd>
				<dd><input size="15" id="jfhj" name="jfhj" /></dd>
			</dl>
			<dl>
				<dd>项目研发经费-内部:</dd>
				<dd><input size="15" id="jfnb" name="jfnb" /></dd>
			</dl>
			<dl>
				<dd>项目研发经费-外部:</dd>
				<dd><input size="15" id="jfwb" name="jfwb" /></dd>
			</dl>
		</form>
	</div>

	
		<div id="zscq">
		<form id="frmzscq" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>项目编号:</dd>
				<dd><input size="15" id="xmbh" name="xmbh" /></dd>
			</dl>
			<dl>
				<dd>授权项目名称:</dd>
				<dd><input size="15" id="sqmc" name="sqmc" /></dd>
			</dl>
						<dl>
				<dd>类别:</dd>
				<dd><input size="15" id="lb" name="lb" /></dd>
			</dl>
			<dl>
				<dd>授权号:</dd>
				<dd><input size="15" id="sqh" name="sqh" /></dd>
			</dl>
			<dl>
				<dd>授权日期:</dd>
				<dd><input size="15" id="sqrq" name="sqrq" /></dd>
			</dl>
		</form>
	</div>
</div>	

</div>


</body>

</html>
