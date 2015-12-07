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
<script type="text/javascript" src="<%=basePath%>/script/kjndjpptkyxmb2.js"></script>
 <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

	<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
		<form id="searchForm">
			<table>
				<tr>
					<th>项目编号：</th>
					<td><input id="fileName" /></td>
				</tr>
				<tr>
					<th>项目名称：</th>
					<td><input id="fileId" /></td>
					<td><a class="easyui-linkbutton"
						data-options="iconCls:'icon-search'" href="javascript:void(0);"
						onclick="doSearch();">查询</a></td>

				</tr>
			</table>
		</form>
	</div>


	<div data-options="region:'center',split:false"  style="overflow:scroll" >
		<!-- 表格主题部分-->
		<table id="dg">
			<thead>
				<tr>
					<th field="xmbh">项目编号</th>
					<th field="xmmc">项目名称</th>
					<th field="cyzgbm">承研单位主管部门</th>
					<th field="cydw">承研单位</th>
					<th field="xqzgbm">需求单位主管部门</th>
					<th field="xqdw">需求单位</th>
		
					<th field="bjxh">背景型号</th>
					<th field="xmnr">项目内容</th>
					<th field="yzzq">研制周期</th>
					<th field="pfzjf">批复总经费</th>
					<th field="pfgbjf">批复国拨经费</th>
		
					<th field="bz">备注</th>
					
					 <th field="jlnf">记录年份</th>
				
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
						项目编号: <input size="15" id="xmbh" name="xmbh" />
					</dd>
				</dl>


				<dl>
					<dd>
						项目名称: <input size="15" id="xmmc" name="xmmc" />
					</dd>
				</dl>
				<dl>
					<dd>
						承研单位主管部门: <input size="15" id="cyzgbm" name="cyzgbm" />
					</dd>
				</dl>
				<dl>
					<dd>
						承研单位: <input size="15" id="cydw" name="cydw" />
					</dd>
				</dl>
				<dl>
					<dd>
						需求单位主管部门: <input size="15" id="xqzgbm" name="xqzgbm" />
					</dd>
				</dl>
								<dl>
					<dd>
						需求单位: <input size="15" id="xqdw" name="xqdw" />
					</dd>
				</dl>
	
				<dl>
					<dd>
						背景型号: <input size="15" id="bjxh" name="bjxh" />
					</dd>
				</dl>


				<dl>
					<dd>
						项目内容: <input size="15" id="xmnr" name="xmnr" />
					</dd>
				</dl>
				<dl>
					<dd>
						研制周期: <input size="15" id="yzzq" name="yzzq" />
					</dd>
				</dl>
				<dl>
					<dd>
						批复总经费: <input size="15" id="pfzjf" name="pfzjf" />
					</dd>
				</dl>
				<dl>
					<dd>
						批复国拨经费: <input size="15" id="pfgbjf" name="pfgbjf" />
					</dd>
				</dl>
								<dl>
					<dd>
						到位总经费: <input size="15" id="dwzjf" name="dwzjf" />
					</dd>
				</dl>
								
				<dl>
					<dd>
						备注: <input size="15" id="bz" name="bz" />
					</dd>
				</dl>
				

			</form>
		</div>
	</div>
</body>

</html>
