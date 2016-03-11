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
	<script type="text/javascript" src="<%=basePath%>/script/dataarrange.js"></script>
</head>

<body>



 <div data-options="region:'center',split:false">
	<!-- 表格主题部分 -->
	 <table id="dg">
	<!-- <thead>
		<tr>
			<th field="sjbf" width="130">数据备份</th>
			<th field="sjhy" width="130">数据还原</th>
			
			
		</tr>
	</thead> -->
	</table> 
</div> 

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:600px;height:200px">
			<input type="hidden" id="id" name="id" />
			<br></br> <br></br> 
			<dl>
				<dd>数据备份:
				<a href="#" class="easyui-linkbutton" id="btnImport" onclick="tocd()" >数据备份</a>
			&nbsp &nbsp &nbsp &nbsp
			    </dd>
			    <br></br>
			   <!--  <dd>
				数据还原:
				
				<form id="questionTypesManage"  method="post" enctype="multipart/form-data">  
                <input type="text" id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:150px" data-options="prompt:'选择还原点'">  
				<a href="#" class="easyui-linkbutton" id="btnExport"  onclick="sjhy()" >数据还原</a>
				</form>
				</dd> -->
				
			</dl>
			
			<dl>
				<dd>&nbsp&nbsp 原地址:
				<select id="path" name="path" >
				<option value=""></option>
				<option value="C:\\kjcdata。sql">C:kjcdata</option>
				<option value="D:\\kjcdata。sql">D:kjcdata</option>
				<option value="E:\\kjcdata。sql">E:kjcdata</option>
				<option value="F:\\kjcdata。sql">F:kjcdata</option>
				<option value="G:\\kjcdata。sql">G:kjcdata</option>
				<option value="H:\\kjcdata。sql">H:kjcdata</option>
				</select>
				<a href="#" class="easyui-linkbutton" id="btnExport"  onclick="sjhy()" >还原</a>
				</dd>
				
			</dl>
		</form>
	</div>
</div>	



</body>

</html>
