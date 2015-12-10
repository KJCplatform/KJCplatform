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
<title>国家科学技术奖国防科技工业专用项目特等奖统计</title>
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
<script type="text/javascript" src="<%=basePath%>/script/kjgjkjjgfxmtj.js"></script>
  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

	<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
		<form id="searchForm">
			<table>
				<tr>
					<th>年度：</th>
					<td><input id="fileName" /></td>
				</tr>
				<tr>
					<th>特等奖：</th>
					<td><input id="fileId" /></td>
					<td><a class="easyui-linkbutton"
						data-options="iconCls:'icon-search'" href="javascript:void(0);"
						onclick="doSearch();">查询</a></td>

				</tr>
			</table>
		</form>
	</div>


	<div data-options="region:'center',split:false">
		<!-- 表格主题部分-->
		<table id="dg">
			<thead>
				<tr>
					<th field="nd" width="130">年度</th>
					<th field="tdj" width="130">特等奖</th>
					<th field="ydj" width="130">一等奖</th>
					<th field="edj" width="130">二等奖</th>
				
					<th field="hj" width="130">合计</th>
			    <th field="jlnf" width="130">记录年份</th>
		
				</tr>
			</thead>
		</table>
	</div>

	<!-- 编辑数据的div，默认看不到 -->
	<div id="divEdit" style="display:none;">
		<div id="tabEdit" style="overflow-y:auto;">
	<form id="frmEdit" style="width:800px;height:400px"
				method="post">
				<input type="hidden" id="id" name="id" />
				<dl>
					<dd>
						年度: <input size="15" id="nd" name="nd" />
					</dd>
				</dl>

				<dl>
					<dd>
						特等奖: <input size="15" id="tdj" name="tdj" />
					</dd>
				</dl>
				<dl>
					<dd>
						一等奖: <input size="15" id="ydj" name="ydj" />
					</dd>
				</dl>
				<dl>
					<dd>
						二等奖: <input size="15" id="edj" name="edj" />
					</dd>
				</dl>
			
								<dl>
				
				</dl>


			</form>
		</div>
	</div>
</body>

</html>
