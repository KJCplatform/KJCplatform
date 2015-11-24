<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>公文管理</title>
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
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/document.js"></script>
</head>

<body>

<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>文件名：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>文件号：</th>
					<td>
                        <input id="fileId" />
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
			<th field="wjm" width="130">文件名</th>
			<th field="wjh" width="130">文件编号</th>
			<th field="fwjg" width="130">发文机关</th>
			<th field="fwrq" width="130">发文日期</th>
			<th field="jbnr" width="130">交办内容</th>
			<th field="jzrq" width="130">截止日期</th>
			<th field="jbr" width="130">交办人</th>
			<th field="cljg" width="130">处理结果</th>
		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>文件名:</dd>
				<dd><input size="15" id="wjm" name="wjm" /></dd>
			</dl>
			<dl>
				<dd>文件号:</dd>
				<dd><input size="15" id="wjh" name="wjh" /></dd>
			</dl>
			<dl>
				<dd>发文机关:</dd>
				<dd><input size="15" id="fwjg" name="fwjg" /></dd>
			</dl>
			<dl>
				<dd>发文日期:</dd>
				<dd><input type="text" style="width: 150px" id="fwrq" name="fwrq" /></dd>
			</dl>
			<dl>
				<dd>交办内容:</dd>
				<dd><textarea cols="45" rows="3" id="jbnr" name="jbnr"></textarea></dd>
			</dl>
			<dl>
				<dd>截止日期:</dd>
				<dd><input  type="text" style="width: 150px" id="jzrq" name="jzrq" /></dd>
			</dl>
			<dl>
				<dd>交办人:</dd>
				<dd><input size="15" id="jbr" name="jbr" /></dd>
			</dl>
			<dl>
				<dd>处理结果:</dd>
				<dd><textarea cols="45" rows="3" id="cljg" name="cljg"></textarea></dd>
			</dl>
		</form>
	</div>
</div>	
</body>

</html>
