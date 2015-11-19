<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>数字框</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/zjtxl.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>姓名：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>单位：</th>
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
			<th field="xm" width="130">专家姓名</th>
			<th field="dw" width="130">工作单位</th>
			<th field="bm" width="130">工作部门</th>
			<th field="zw" width="130">职务</th>
			<th field="lxfszj" width="130">座机</th>
			<th field="lxfssj" width="130">手机</th>
		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
	
<div id="divEdit" style="border:0px;padding:3px; PADDING:0px;width:200px; height:280px; LINE-HEIGHT: 20px; 
	OVERFLOW: auto;  display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>专家姓名:</dd>
				<dd><input size="15" id="xm" name="xm" /></dd>
			</dl>
			<dl>
				<dd>工作单位:</dd>
				<dd><input size="15" id="dw" name="dw" /></dd>
			</dl>
			<dl>
				<dd>工作部门:</dd>
				<dd><input size="15" id="bm" name="bm" /></dd>
			</dl>
			<dl>
				<dd>技术职称:</dd>
				<dd><input  type="text" style="width: 150px" id="zw" name="zw" /></dd>
			</dl>
			<dl>
				<dd>座机:</dd>
				<dd><input  type="text" style="width: 150px" id="lxfszj" name="lxfszj" /></dd>
			</dl>
			<dl>
				<dd>手机:</dd>
				<dd><input  type="text" style="width: 150px" id="lxfssj" name="lxfssj" /></dd>
			</dl>
		</form>
	</div>
</div>	
</body>

</html>
