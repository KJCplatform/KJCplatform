<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>专家综合查询表</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/professor.js"></script>
	  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>按专家姓名查询：</th>
                    <td>
						<input id="fileName" />
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td>
                </tr>
               <!--  <tr>
					<th>：</th>
					<td>
                        <input id="fileId" />
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td>
                
                </tr> -->
            </table>
        </form>
  
</div>
          
   <!--  <form id="questionTypesManage"  method="post" enctype="multipart/form-data">  
   选择文件：　<input type="text" id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">  
       　　<a href="#" class="easyui-linkbutton" id="btnImport" onclick="ShowImport()" >导入</a>                       
       <a href="#" class="easyui-linkbutton" id="btnExport"  onclick="selectExcel()" >导出</a> 　
</form> -->

<div data-options="region:'center',split:false" >
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="xm" >姓名</th>
			<th field="xb" >性别</th>
			<th field="gzdw" >工作单位</th>
			<th field="gzbm">工作部门</th>
			<th field="zw" >职务</th>
			<th field="cgmcZzq" >软件著作权成果名称</th>
			<th field="cgmcQt" >其他成果名称</th>
			<th field="cgmcDj" >登记鉴定成果名称</th>
			<th field="cgmcZl">国防专利成果名称</th>
			
		
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
				<dd>姓名:</dd>
				<dd><input size="20" id="xm" name="xm" /></dd>
			</dl>
			<dl>
				<dd>性别:</dd>
				<dd><input size="20" id="xb" name="xb" /></dd>
			</dl>
			<dl>
				<dd>工作单位:</dd>
				<dd><input size="20" id="gzdw" name="gzdw" /></dd>
			</dl>
			<dl>
				<dd>工作部门:</dd>
				<dd><input size="20" id="gzbm" name="gzbm" /></dd>
			</dl>
			<dl>
		<dd>职务:</dd>
				<dd><input size="20" id="zw" name="zw" /></dd>
			</dl>
			<dl>
				<dd>软件著作权成果名称:</dd>
				<dd><input size="20" id="cgmcZzq" name="cgmcZzq" /></dd>
			</dl>
			<dl>
				<dd>其他成果名称:</dd>
				<dd><input size="20" id="cgmcQt" name="cgmcQt" /></dd>
			</dl>
			<dl>
				<dd>登记鉴定成果名称:</dd>
				<dd><input size="20" id="cgmcDj" name="cgmcDj" /></dd>
			</dl>
			<dl>
				<dd>国防专利成果名称:</dd>
				<dd><input size="20" id="cgmcZl" name="cgmcZl" /></dd>
			</dl>
			
			                  
		</form>
	</div>
</div>	

<div id="divEdit2" style="display:none;">
	<div id="tabEdit2" style="overflow-y:auto;">
		<form id="frmEdit2" style="height:400px;margin:0px 0px 0px 0px"  method= "post">
		 >>>请选择导出项<<<
		 <br> <br>
<input name="Items" type="checkbox" checked="checked" value="1" />姓名<br>
<input name="Items" type="checkbox" checked="checked" value="2" />性别<br> 
<input name="Items" type="checkbox" checked="checked" value="3" />工作单位<br> 
<input name="Items" type="checkbox" checked="checked" value="4" />工作部门<br>
<input name="Items" type="checkbox" checked="checked" value="5" />职务<br> 
<input name="Items" type="checkbox" checked="checked" value="6" />软件著作权成果名称<br> 
<input name="Items" type="checkbox" checked="checked" value="7" />其他成果名称<br>
<input name="Items" type="checkbox" checked="checked" value="8" />登记鉴定成果名称<br>
<input name="Items" type="checkbox" checked="checked" value="9" />国防专利成果名称<br>


		</form>
	</div>
</div>	
</body>

</html>
