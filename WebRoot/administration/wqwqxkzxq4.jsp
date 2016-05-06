<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>申请增加的武器装备科研生产许可专业产品</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/wqwqxkzxq4.js"></script>
</head>

<body>

<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>项目代码：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>项目名称：</th>
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
<form id="questionTypesManage" method="post"
		enctype="multipart/form-data">
		选择文件： <input type="text" id="uploadExcel" name="uploadExcel"
			class="easyui-filebox" style="width:200px"
			data-options="prompt:'请选择文件...'"> <a href="#"
			class="easyui-linkbutton" id="btnImport" onclick="ShowImport()">导入</a>
		<a href="#" class="easyui-linkbutton" id="btnExport"
			onclick="selectExcel()">导出</a> <a href="#" class="easyui-linkbutton"
			id="btnExport" onclick="writeFileToService()">上传附件</a>
		<!-- <a href="#" class="easyui-linkbutton" id="btnExport"  onclick="topdf()" >导出pdf</a>　 -->
	</form>

	<div id="divEdit2" style="display:none;">
		<div id="tabEdit2" style="overflow-y:auto;">
			<form id="frmEdit2" style="width:330px;margin:0px 0px 0px 0px"
				method="post">
				>>>请选择导出项<<< <br> <br> 
				<input name="Items" type="checkbox" checked="checked" value="1" />序号 <br> 
				<input name="Items" type="checkbox" checked="checked" value="2" />项目代码<br> 
				<input name="Items" type="checkbox" checked="checked" value="3" />项目名称<br>
				<input name="Items" type="checkbox" checked="checked" value="4" />科研生产<br> 
				<input name="Items" type="checkbox" checked="checked" value="5" />许可类型<br>
				<input name="Items" type="checkbox" checked="checked" value="6" />记录年份<br>
			</form>
		</div>
	</div>

<div data-options="region:'center',split:false">
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="xh" >序号</th>
			<th field="xmdm" >项目代码</th>
			<th field="xmmc" >项目名称</th>
		    <th field="kysc" >科研生产</th>
			<th field="xklx" >许可类型</th>
		    <th field="jlnf" width="130">记录时间(年份)</th>
			<th field="username" width="130">操作员</th>
			<th field="gxsj" width="130">更新时间</th>
	
		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
    <div id="divEdit" style="display:none;">
        <div id="tabEdit" style="overflow-y:auto;">
		<form id="frmEdit" style="width:800px; height:400px; overflow:auto;" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>序号:</dd>
				<dd><input size="15" id="xh" name="xh" /></dd>
			</dl>
			<dl>
				<dd>项目代码:</dd>
				<dd><input size="15" id="xmdm" name="xmdm" /></dd>
			</dl>
			<dl>
				<dd>项目名称:</dd>
				<dd><input size="15" id="xmmc" name="xmmc" /></dd>
			</dl>
            
            <dl>
                <dd>科研/生产:</dd>
                <dd><select   style="width: 150px" id="kysc" name="kysc" >
                <option value="科研">科研</option> 
                <option value="生产">生产</option>
                </select>
                </dd>
            </dl>

			<dl>
				<dd>许可类型</dd>
				<dd><select style="width: 150px" id="xklx" name="xklx" >
				<option value="一类">一类</option>
				<option value="二类">二类</option>
                  </select>
                </dd>
                
			</dl> 
		</form>
	</div>
</div>	
</body>

</html>
