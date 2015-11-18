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
<title>高新技术企业信息</title>
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
<script type="text/javascript" src="<%=basePath%>/script/kjndgxjsqypjb.js"></script>
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
					<th>企业名称：</th>
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
					<th field="year">年度</th>
					<th field="qymc">企业名称</th>
					<th field="cply">主营产品所属领域</th>
					<th field="zgzs">职工总数</th>
					<th field="dzysrs">大专以上学历科技人员数</th>
					<th field="yfrys">研发人员数</th>
					<th field="xmhds">研发项目核定数</th>
					<th field="cphds">高新技术产品核定数</th>
					<th field="jfze">研发项目经费核定总额</th>
					<th field="yncpsr">近一年高新产品销售收入核定额</th>
					<th field="jnyfze">在中国境内研发费用总额定数</th>
					<th field="dzrybl">大专以上学历科技人员占企业职工总数比例</th>
					<th field="yfrybl">研发人员占企业职工总数的比例</th>
					<th field="jsnyfbl">近3年研究开发费用总额占总销售收入比例</th>
					<th field="jsnjnbl">近3年在中国境内研发费用总额占全部研发费用总额比例</th>
					<th field="jyngxsrbl">近1年高新技术产品（服务）收入占当年总收入比例</th>
					<th field="zhdf">综合得分</th>
					<th field="zscqdf">知识产权得分</th>
					<th field="zhnldf">转化能力得分</th>
					<th field="glspdf">管理水平得分</th>
					<th field="czzbdf">成长指标得分</th>
					<th field="zhpj">对企业整体情况的综合评价</th>
					<th field="pdzjz">评定专家组</th>
					
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
						年度: <input size="15" id="year" name="year" />
					</dd>
				</dl>


				<dl>
					<dd>
						企业名称: <input size="15" id="qymc" name="qymc" />
					</dd>
				</dl>
				<dl>
					<dd>
						主营产品所属领域: <input size="15" id="cply" name="cply" />
					</dd>
				</dl>
				<dl>
					<dd>
						职工总数: <input size="15" id="zgzs" name="zgzs" />
					</dd>
				</dl>
				<dl>
					<dd>
						大专以上学历科技人员数: <input size="15" id="dzysrs" name="dzysrs" />
					</dd>
				</dl>
								<dl>
					<dd>
						研发人员数: <input size="15" id="yfrys" name="yfrys" />
					</dd>
				</dl>
				
								<dl>
					<dd>
						研发项目核定数: <input size="15" id="xmhds" name="xmhds" />
					</dd>
				</dl>


				<dl>
					<dd>
						高新技术产品核定数: <input size="15" id="cphds" name="cphds" />
					</dd>
				</dl>
				<dl>
					<dd>
						研发项目经费核定总额: <input size="15" id="jfze" name="jfze" />
					</dd>
				</dl>
				<dl>
					<dd>
						近一年高新产品销售收入核定额: <input size="15" id="yncpsr" name="yncpsr" />
					</dd>
				</dl>
				<dl>
					<dd>
						在中国境内研发费用总额定数: <input size="15" id="jnyfze" name="jnyfze" />
					</dd>
				</dl>
								<dl>
					<dd>
						大专以上学历科技人员占企业职工总数比例: <input size="15" id="dzrybl" name="dzrybl" />
					</dd>
				</dl>
				
								<dl>
					<dd>
						研发人员占企业职工总数的比例: <input size="15" id="yfrybl" name="yfrybl" />
					</dd>
				</dl>


				<dl>
					<dd>
						近3年研究开发费用总额占总销售收入比例: <input size="15" id="jsnyfbl" name="jsnyfbl" />
					</dd>
				</dl>
				<dl>
					<dd>
						近3年在中国境内研发费用总额占全部研发费用总额比例: <input size="15" id="jsnjnbl" name="jsnjnbl" />
					</dd>
				</dl>
				<dl>
					<dd>
						近1年高新技术产品（服务）收入占当年总收入比例: <input size="15" id="jyngxsrbl" name="jyngxsrbl" />
					</dd>
				</dl>
				<dl>
					<dd>
						综合得分: <input size="15" id="zhdf" name="zhdf" />
					</dd>
				</dl>
								<dl>
					<dd>
						知识产权得分: <input size="15" id="zscqdf" name="zscqdf" />
					</dd>
				</dl>

				<dl>
					<dd>
						转化能力得分: <input size="15" id="zhnldf" name="zhnldf" />
					</dd>
				</dl>
				<dl>
					<dd>
						管理水平得分: <input size="15" id="glspdf" name="glspdf" />
					</dd>
				</dl>
				<dl>
					<dd>
						成长指标得分: <input size="15" id="czzbdf" name="czzbdf" />
					</dd>
				</dl>
				<dl>
					<dd>
						对企业整体情况的综合评价: <input size="15" id="zhpj" name="zhpj" />
					</dd>
				</dl>
								<dl>
					<dd>
						评定专家组: <input size="15" id="pdzjz" name="pdzjz" />
					</dd>
				</dl>
				
			</form>
		</div>
	</div>
</body>

</html>
