<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>科技项目库</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/kjkjxmk.js"></script>
	 <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>单位名称：</th>
                    <td>
						<input id="fileName"/>
					</td>
                </tr>
                <tr>
					<th>项目名称：</th>
					<td>
                        <input id="fileID"/>
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td>
                
                </tr>
            </table>
        </form>
</div>


<div data-options="region:'center',split:false">
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="lb"  >类别</th>
			<th field="xh"  >序号</th>
			<th field="dwmc"  >单位名称</th>
			<th field="xmmc"  >项目名称</th>
			<th field="jsgmnr"  >建设规模及内容</th>
			<th field="xmjszq"  >项目建设周期</th>
			<th field="ymjd"  >项目进度</th>
			<th field="ztz"  >总投资</th>
			<th field="ywctz"  >已完成投资</th>
			<th field="bntz"  >本年度计划投资</th>
			<th field="bz"  >备注</th>
			
				    <th field="jlnf">记录年份</th>
	
		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:800px; height:400px; overflow:auto;" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>类别:</dd>
				<dd><input size="20" id="lb" name="lb" /></dd>
			</dl>
			<dl>
				<dd>序号:</dd>
				<dd><input size="20" id="xh" name="xh" /></dd>
			</dl>
			<dl>
				<dd>单位名称:</dd>
				<dd><input type="text" style="width: 150px" id="dwmc" name="dwmc" /></dd>
			</dl>
			<dl>
				<dd>项目名称:</dd>
				<dd><input type="text" style="width: 150px" id="xmmc" name="xmmc" /></dd>
			</dl>
			<dl>
				<dd>建设规模及内容:</dd>
				<dd><textarea cols="20" rows="3" id="jsgmnr" name="jsgmnr"></textarea></dd>
			</dl>
			
			<dl>
				<dd>项目建设周期:</dd>
				<dd><input size="20" id="xmjszq" name="xmjszq" /></dd>
			</dl>
			<dl>
				<dd>项目进度:</dd>
				<dd><input size="20" id="ymjd" name="ymjd" /></dd>
			</dl>
			<dl>
				<dd>总投资:</dd>
				<dd><input size="20" id="ztz" name="ztz" /></dd>
			</dl>
			<dl>
				<dd>已完成投资:</dd>
				<dd><input size="20" id="ywctz" name="ywctz" /></dd>
			</dl>
			<dl>
				<dd>本年度计划投资:</dd>
				<dd><input size="20" id="bntz" name="bntz" /></dd>
			</dl>
			<dl>
				<dd>备注:</dd>
				<dd><textarea cols="20" rows="3" id="bz" name="bz"></textarea></dd>
			</dl>
		</form>
	</div>
</div>	
</body>

</html>
