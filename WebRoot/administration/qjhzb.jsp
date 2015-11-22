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
	<script type="text/javascript" src="<%=basePath%>/script/qjhzb.js"></script>
	  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>法人单位名称：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>所属计量专业：</th>
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
			<th field="frmc" width="130">法人单位名称</th>
			<th field="jlzy" width="130">所属计量专业</th>
			<th field="qjmc" width="130">企事业最高计量标准器具名称</th>
			<th field="zsh" width="130">证书号</th>
			<th field="zmcxh" width="130">主标准器名称型号</th>
			<th field="ptmcxh" width="130">配套设备名称型号</th>
			<th field="clcsfw" width="130">测量参数及范围</th>
			<th field="bqdd" width="130">不确定度或准确度等级或最大允许误差</th>
			<th field="zsyjg" width="130">主标准器溯源机构</th>

		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit" style="overflow-y:auto;">
		<form id="frmEdit" style="width:600px; height:600px;margin:100px 0px 0px 0px"  method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>法人单位名称:</dd>
				<dd><input size="15" id="frmc" name="frmc" /></dd>
			</dl>
			<dl>
				<dd>所属计量专业:</dd>
				<dd><input size="15" id="jlzy" name="jlzy" /></dd>
			</dl>
			<dl>
				<dd>企事业最高计量标准器具名称:</dd>
				<dd><input size="15" id="qjmc" name="qjmc" /></dd>
			</dl>
			<dl>
				<dd>证书号:</dd>
				<dd><input type="text" style="width: 150px" id="zsh" name="zsh" /></dd>
			</dl>
			<dl>
				<dd>主标准器名称型号:</dd>
				<dd><textarea cols="45" rows="3" id="zmcxh" name="zmcxh"></textarea></dd>
			</dl>
			<dl>
				<dd>配套设备名称型号:</dd>
				<dd><textarea cols="45" rows="3" id="ptmcxh" name="ptmcxh"></textarea></dd>
			</dl>
			<dl>
				<dd>测量参数及范围:</dd>
				<dd><input size="15" id="clcsfw" name="clcsfw" /></dd>
			</dl>
			<dl>
				<dd>不确定度或准确度等级或最大允许误差:</dd>
				<dd><textarea cols="45" rows="3" id="bqdd" name="bqdd"></textarea></dd>
			</dl>
						<dl>
				<dd>主标准器溯源机构:</dd>
				<dd><textarea cols="45" rows="3" id="zsyjg" name="zsyjg"></textarea></dd>
		
			
			
		</form>
	</div>
</div>	
</body>

</html>
