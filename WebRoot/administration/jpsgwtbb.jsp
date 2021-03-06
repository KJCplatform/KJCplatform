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
<script type="text/javascript" src="<%=basePath%>/script/jpsgwtbb.js"></script>
  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

	<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
		<form id="searchForm">
			<table>
				<tr>
					<th>产品名称：</th>
					<td><input id="fileName" /></td>
				</tr>
				<tr>
					<th>填表人：</th>
					<td><input id="fileId" /></td>
					<td><a class="easyui-linkbutton"
						data-options="iconCls:'icon-search'" href="javascript:void(0);"
						onclick="doSearch();">查询</a></td>

				</tr>
			</table>
		</form>
	</div>

<form id="questionTypesManage"  method="post" enctype="multipart/form-data">  
   选择文件：　<input type="text" id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">  
       　　<a href="#" class="easyui-linkbutton" id="btnImport" onclick="ShowImport()" >导入</a>                       
     <a href="#" class="easyui-linkbutton" id="btnExport"  onclick="selectExcel()" >导出</a> 　
     <a href="#" class="easyui-linkbutton" id="btnExport"  onclick="selectFile()" >查看附件</a> 　      
</form>

<div id="divEdit2" style="display:none;">
	<div id="tabEdit2" style="overflow-y:auto;">
		<form id="frmEdit2" style="width:330px;margin:0px 0px 0px 0px"  method= "post">
		 >>>请选择导出项<<<
		 <br> <br>
			<input name="Items" type="checkbox" checked="checked" value="1" />产品名称<br>
			<input name="Items" type="checkbox" checked="checked" value="2" />发生日期<br> 
			<input name="Items" type="checkbox" checked="checked" value="3" /> 质量事故或重大质量问题发生的原因等基本情况<br> 
			<input name="Items" type="checkbox" checked="checked" value="4" />备注<br>
			<input name="Items" type="checkbox" checked="checked" value="5" />填表人<br> 
			<input name="Items" type="checkbox" checked="checked" value="6" />质量部门负责人<br> 
			<input name="Items" type="checkbox" checked="checked" value="7" />报出日期	<br>
			<input name="Items" type="checkbox" checked="checked" value="8" />记录日期（年份）<br>

		</form>
	</div>
</div>		
	<div id="open" style="display:none;">
			<div id="tabOpen" style="width:400px; height:300px; overflow:auto;">
				<form id="openFj">
					<input id="Fj1" name ="Fj1" type="checkbox" value="附件1"/>
					<span id="fj1Name" ></span><br>
					<input id="Fj2" name ="Fj2" type="checkbox" value="附件2"/>
					<span id="fj2Name" ></span><br>					
				</form>
			</div>		
	</div>
	
				

	<div data-options="region:'center',split:false">
		<!-- 表格主题部分-->
		<table id="dg">
			<thead>
				<tr>
					<th field="cpmc">产品名称</th>
					<th field="fsrq">发生日期</th>
					<th field="yyqk">质量事故或重大质量问题发生的原因等基本情况</th>
					<th field="bz">备注</th>
					<th field="tbr">填表人</th>
					<th field="zlbmfzr">质量部门负责人</th>
			        <th field="bcrq">报出日期</th>
			        <th field="fj1">附件1</th>
			        <th field="fj2">附件2</th>
			        

				</tr>
			</thead>
		</table>
	</div>

	<!-- 编辑数据的div，默认看不到 -->
	<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:800px; height:400px; overflow:auto;" method= "post" enctype="multipart/form-data">
				<input type="hidden" id="id" name="id" />
				<dl>
					<dd>
						产品名称: <input size="15" id="cpmc" name="cpmc" />
					</dd>
				</dl>


				<dl>
					<dd>
						发生日期: <input  type="text" style="width: 150px" id="fsrq" name="fsrq" />
					</dd>
				</dl>
				<dl>
					<dd>
						质量事故或重大质量问题发生的原因等基本情况: <input size="15" id="yyqk" name="yyqk" />
					</dd>
				</dl>
				<dl>
					<dd>
						备注: <input size="15" id="bz" name="bz" />
					</dd>
				</dl>
				<dl>
					<dd>
						填表人: <input size="15" id="tbr" name="tbr" />
					</dd>
				</dl>
								<dl>
					<dd>
						质量部门负责人: <input size="15" id="zlbmfzr" name="zlbmfzr" />
					</dd>
				</dl>
				<dl>
					<dd>
						报出日期: <input  type="text" style="width: 150px" id="bcrq" name="bcrq" />
					</dd>
				</dl>
				<dl>
					<dd>
						附件1: <input  type="text" style="width: 150px" id="fj1" name="fj1" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'"/>
					</dd>
				</dl>
				
				<dl>
					<dd>
						附件2: <input  type="text" style="width: 150px" id="fj2" name="fj2" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'"/>
					</dd>
				</dl>

				
			</form>
		</div>
	</div>
</body>

</html>
