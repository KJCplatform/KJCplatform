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
	<script type="text/javascript" src="<%=basePath%>/script/zonghechaxun.js"></script>
</head>

<body>
<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>综合查询条件1：</th>
                    <td>
						<select id="select" name="select">
						<option value="0"></option>
						<option value="1">公司</option>
						<option value="2">专家</option>
						<option value="3">项目</option>
						
						</select>
						
						 <input id="fileName" />
					</td>
                </tr>
               <!--  <tr>
					<th>文件号：</th>
					<td>
                        <input id="fileId" />
					</td>
					
                
                </tr> -->
                <tr>
                    <th>选择查询条件2：</th>
                    <td>
						<select id="select2" name="select2">
						<option value="0"></option>
						<option value="1">公司</option>
						<option value="2">专家</option>
						<option value="3">项目</option>
						
						</select>
						
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
			<th field="gongsi" width="130">按公司综合查询</th>
			<th field="zhuanjia" width="130">按专家综合查询</th>
			<th field="xiangmu" width="130">按项目综合查询</th>
			
			
		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:600px;height:200px">
			<input type="hidden" id="id" name="id" />
			
			<dl>
				<dd>XXX:
				<a href="#" class="easyui-linkbutton" id="btnImport" onclick="" >XXX</a>
			    </dd>

			    <dd>XXX:
				
				<form id="questionTypesManage"  method="post" enctype="multipart/form-data">  
                <input type="text" id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:150px" data-options="prompt:'XXX'">  
				<a href="#" class="easyui-linkbutton" id="btnExport"  onclick="" >XXX</a>
				</form>
				</dd>
				
			</dl>
			
			
		</form>
	</div>
</div>	



</body>

</html>
