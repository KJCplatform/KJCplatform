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
	<script type="text/javascript" src="<%=basePath%>/script/sjjlbz.js"></script>
	
    <script src="<%=basePath%>/script/jquery-form.js"></script>
    <script src="<%=basePath%>/script/jquery.validate.min.js"></script>
<!-- <script type="text/javascript" src="<%=basePath%>/script/datagrid-detailview.js"></script> -->
	

 
</head>

<body>

<!-- <div data-options="region:'north',title:'高级查询'" style="height: 60px;" > -->
<!--         <form id="searchFormtest"> -->
<!--             <table> -->
<!--                 <tr> -->
<!--                     <th>法人单位名称：</th> -->
<!--                     <td> -->
<!-- 						<input id="fileName" /> -->
<!-- 					</td> -->
<!--                 </tr> -->
<!--                 <tr> -->
<!-- 					<th>涉及的计量专业：</th> -->
<!-- 					<td> -->
<!--                         <input id="fileId" /> -->
<!-- 					</td> -->
<!-- 					<td> -->
<!-- 						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a> -->
<!-- 					</td> -->
                
<!--                 </tr> -->
<!--             </table> -->
            
<!--         </form> -->
<!-- </div> -->


<!--     <div class="container">   -->
<!--         <h3>导入Excel</h3>   -->
<!--         <form id="uploadimg-form" enctype="multipart/form-data"  action="" method="post">   -->
<!--             <input type="file" title="选择文件" name="fileUpload" id="fileUpload"/><br /><br />   -->
<!--             <input id="fileBtn" type="submit"  class="btn" value="文件上传"/> -->
            
            
            
<!--          <input id="export" type="button"  onclick="Exproter()" class="btn" value="导出文件"/><br /><br />   -->
        
<!--         </form>   -->
  
<!--         <div id="showData" style="display: none;">   -->
<!--             <div>   -->
<!--                 <p>导入数据如下：</p>   -->
<!--                 <p id="jsonShow"></p>   -->
<!--             </div>   -->
<!--         </div>   -->
<!--     </div>  -->
 
    
    <form id="questionTypesManage"  method="post" enctype="multipart/form-data">  
   选择文件：　<input type="text" id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">  
       　　<a href="#" class="easyui-linkbutton" id="btnImport" onclick="ShowImport()" >导入</a>                       
       <a href="#" class="easyui-linkbutton" id="btnExport" onclick="ShowExport()" >导出</a> 　
</form>


<!-- <input id="file_upl" type="file"  /> -->
<!-- <input  type="button" style="width:80px"  value="导入" onclick="test()" /> -->

<div data-options="region:'center',split:false">
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="frmc" width="130">法人单位名称</th>
			<th field="jlzy" width="130">涉及的计量专业</th>
			<th field="qjsl" width="130">企事业最高计量标准器具数量</th>
			<th field="txdz" width="130">通讯地址</th>
			<th field="lxr" width="130">联系人</th>
			<th field="bgdh" width="130">办公电话</th>
			<th field="sj" width="130">手机</th>
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
				<dd><input size="15" id="frmc" name="frmc" />*</dd>
			</dl>
			<dl>
				<dd>涉及的计量专业:</dd>
				<dd><input size="15" id="jlzy" name="jlzy" />*</dd>
			</dl>
			<dl>
				<dd>企事业最高计量标准器具数量:</dd>
				<dd><input size="15" id="qjsl" name="qjsl" /></dd>
			</dl>
			<dl>
				<dd>通讯地址:</dd> 
				<dd><input type="text" style="width: 150px" id="txdz" name="txdz" /></dd>
			</dl>
			<dl>
				<dd>联系人:</dd>
				<dd><textarea cols="45" rows="3" id="lxr" name="lxr"></textarea></dd>
			</dl>
			<dl>
				<dd>办公电话:</dd>
				<dd><input  type="text" style="width: 150px" id="bgdh" name="bgdh" /></dd>
			</dl>
			<dl>
				<dd>手机:</dd>
				<dd><input  type="text" style="width: 150px" id="sj" name="sj" /></dd>
			</dl>
		</form>
	</div>
</div>	
</body>

</html>
