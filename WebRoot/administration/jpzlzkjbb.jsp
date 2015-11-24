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
<title>数字框</title>
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
<script type="text/javascript" src="<%=basePath%>/script/jpzlzkjbb.js"></script>
  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

	<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
		<form id="searchForm">
			<table>
				<tr>
					<th>季度：</th>
					<td><input id="fileName" /></td>
				</tr>
				<tr>
					<th>单位名称：</th>
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
					<th field="jd">季度</th>
					<th field="dwmc">单位名称</th>
					<th field="hgl">军品一次交验（检）合格率</th>
					<th field="cgl">重大试验成功率</th>
					<th field="ssl">军品质量损失率</th>
					<th field="zlhdqk">单位重大质量活动情况</th>
		            <th field="tbr">填表人</th>
					<th field="zlbfzr">质量部门负责人</th>
			    	<th field="shr">审核人</th>
					<th field="bcrq">报出日期</th>
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
						季度: <input size="15" id="jd" name="jd" />
					</dd>
				</dl>


				<dl>
					<dd>
						单位名称: <input size="15" id="dwmc" name="dwmc" />
					</dd>
				</dl>
				<dl>
					<dd>
						军品一次交验（检）合格率: <input size="15" id="hgl" name="hgl" />
					</dd>
				</dl>
				<dl>
					<dd>
						重大试验成功率: <input size="15" id="cgl" name="cgl" />
					</dd>
				</dl>
				<dl>
					<dd>
						军品质量损失率: <input size="15" id="ssl" name="ssl" />
					</dd>
				</dl>
								<dl>
					<dd>
						单位重大质量活动情况: <input size="15" id="zlhdqk" name="zlhdqk" />
					</dd>
				</dl>
								<dl>
					<dd>
						填表人: <input size="15" id="tbr" name="tbr" />
					</dd>
				</dl>
												<dl>
					<dd>
						质量部门负责人: <input size="15" id="zlbfzr" name="zlbfzr" />
					</dd>
				</dl>
												<dl>
					<dd>
						审核人: <input size="15" id="shr" name="shr" />
					</dd>
				</dl>
												<dl>
					<dd>
						报出日期: <input  type="text" style="width: 150px" id="bcrq" name="bcrq" />
					</dd>
				</dl>

			</form>
		</div>
	</div>
</body>

</html>
