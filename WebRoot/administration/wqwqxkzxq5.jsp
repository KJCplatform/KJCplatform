<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>军品配套科研项目</title>
<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>/script/easyui/themes/icon.css" />
<style type="text/css">
#fm {
	margin: 0;
	padding: 10px 30px;
}

.ftitle {
	font-size: 14px;
	font-weight: bold;
	color: #666;
	padding: 5px 0;
	margin-bottom: 10px;
	border-bottom: 1px solid #ccc;
}

.fitem {
	margin-bottom: 5px;
}

.fitem label {
	display: inline-block;
	width: 80px;
}
</style>

<script type="text/javascript"
	src="<%=basePath%>/script/easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
<!-- <script type="text/javascript" src="<%=basePath%>/script/kjndjpptkyxmb2.js"></script> -->
 <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

	<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
		<form id="searchForm">
			<table>
				<tr>
					<th>序号：</th>
					<td><input id="fileName" /></td>
				</tr>
				<tr>
					<th>专业名称：</th>
					<td><input id="fileId" /></td>
					<td><a class="easyui-linkbutton"
						data-options="iconCls:'icon-search'" href="javascript:void(0);"
						onclick="doSearch();">查询</a></td>

				</tr>
			</table>
		</form>
	</div>


	<div data-options="region:'center',split:false" >
		<!-- 表格主题部分-->
		<table id="dg">
			<thead>
				<tr>
					<th field="xh" width="150">序号</th>
			        <th field="xmdm" width="150">项目代码</th>
					<th field="xmmc" width="150">项目名称</th>
					<th field="kysc" width="150">科研/生产</th>
					<th field="xklx" width="150">许可类型</th>
				</tr>
			</thead>
		</table>
	</div>

	<!-- 编辑数据的div，默认看不到 -->
	<div id="divEdit" style="display:none;">
		<div id="tabEdit" style="overflow-y:auto;">
			<form id="frmEdit"
				style="width:600px; height:600px;margin:100px 0px 0px 0px"
				method="post">
				<input type="hidden" id="id" name="id" />
				<dl>
					<dd>
						序号: <input size="15" id="xh" name="xh" />
					</dd>
				</dl>


				<dl>
					<dd>
						项目代码: <input size="15" id="xmdm" name="xmdm" />
					</dd>
				</dl>
				<dl>
					<dd>
						项目名称: <input size="15" id="xmmc" name="xmmc" />
					</dd>
				</dl>
				
				<dl>
					<dd>
						科研/生产: <select   style="width: 150px" id="kysc" name="kysc" >
				<option value="科研">科研</option>
				<option value="生产">生产</option>
				</select>
					</dd>
					
				</dl>
					<dl>
					<dd>
						许可类型: <input size="15" id="xklx" name="xklx" />
					</dd>
				</dl>
				
				

			</form>
		</div>
	</div>
</body>

</html>
