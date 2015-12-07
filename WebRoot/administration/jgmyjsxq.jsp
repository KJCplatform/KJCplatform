<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>军工民用技术需求调查表</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/jgmyjsxq.js"></script>
</head>

<body>

<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>序号：</th>
                    <td>
						<input id="xh2" />
					</td>
                </tr>
                <tr>
					<th>单位：</th>
					<td>
                        <input id="dw2" />
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td>
                
                </tr>
            </table>
        </form>
</div>

<form id="questionTypesManage"  method="post" enctype="multipart/form-data">  
   选择文件：　<input type="text" id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">  
       　　<a href="#" class="easyui-linkbutton" id="btnImport" onclick="ShowImport()" >导入</a>                       
       <a href="#" class="easyui-linkbutton" id="btnExport"  onclick="selectExcel()" >导出</a> 　
</form>

<div id="divEdit2" style="display:none;">
	<div id="tabEdit2" style="overflow-y:auto;">
		<form id="frmEdit2" style="width:330px;margin:0px 0px 0px 0px"  method= "post">
		 >>>请选择导出项<<<
		 <br> <br>
<input name="Items" type="checkbox" checked="checked" value="1" />序号	<br>
<input name="Items" type="checkbox" checked="checked" value="2" />单位<br> 
<input name="Items" type="checkbox" checked="checked" value="3" />技术或产品名称<br> 
<input name="Items" type="checkbox" checked="checked" value="4" />技术优势及特点<br>
<input name="Items" type="checkbox" checked="checked" value="5" />功能和用途<br> 
<input name="Items" type="checkbox" checked="checked" value="6" />技术需求愿望<br> 
<input name="Items" type="checkbox" checked="checked" value="7" />需要协作形式<br>
<input name="Items" type="checkbox" checked="checked" value="8" />联系人<br>
<input name="Items" type="checkbox" checked="checked" value="9" />联系方式<br>
		</form>
	</div>
</div>		

<div data-options="region:'center',split:false">
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="xh" width="130">序号</th>
			<th field="jlnf" width="130">记录年份</th>
			<th field="dw" width="130">单位</th>
			<th field="jsmc" width="130">技术或产品名称</th>
			<th field="jsys" width="130">技术优势及特点</th>
			<th field="gnyt" width="130">功能和用途</th>
			<th field="jsxq" width="130">技术需求愿望</th>
			<th field="xzxs" width="130">需要协作形式</th>
			<th field="lxr" width="130">联系人</th>
			<th field="lxfs" width="130">联系方式</th>	
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
				<dd>序号:</dd>
				<dd><input size="15" id="xh" name="xh" /></dd>
			</dl>
			<dl>
				<dd>记录年份:</dd>
				<dd><input size="15" id="jlnf" name="jlnf" /></dd>
			</dl>
			<dl>
				<dd>单位:</dd>
				<dd><input size="15" id="dw" name="dw" /></dd>
			</dl>
			<dl>
				<dd>技术或产品名称:</dd>
				<dd><input type="text" style="width: 150px" id="jsmc" name="jsmc" /></dd>
			</dl>
			<dl>
				<dd>技术优势及特点:</dd>
				<dd><textarea cols="45" rows="3" id="jsys" name="jsys"></textarea></dd>
			</dl>
			<dl>
				<dd>功能和用途:</dd>
				<dd><input  type="text" style="width: 150px" id="gnyt" name="gnyt" /></dd>
			</dl>
			<dl>
				<dd>需要协作形式:</dd>
				<dd><input size="15" id="xzxs" name="xzxs" /></dd>
			</dl>
			<dl>
				<dd>联系人:</dd>
				<dd><input size="15" id="lxr" name="lxr" /></dd>
			</dl>
			<dl>
				<dd>联系方式:</dd>
				<dd><input size="15" id="lxfs" name="lxfs" /></dd>
			</dl>
		</form>
	</div>
</div>	
</body>

</html>
