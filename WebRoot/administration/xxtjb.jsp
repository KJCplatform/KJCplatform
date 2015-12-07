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
	<script type="text/javascript" src="<%=basePath%>/script/xxtjb.js"></script>
	 <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>单位名称：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>姓名：</th>
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
<input name="Items" type="checkbox" checked="checked" value="1" />单位名称<br>
<input name="Items" type="checkbox" checked="checked" value="2" />姓名<br> 
<input name="Items" type="checkbox" checked="checked" value="3" />性别 <br> 
<input name="Items" type="checkbox" checked="checked" value="4" />文化程度	<br> 
<input name="Items" type="checkbox" checked="checked" value="5" />出生年月	<br> 
<input name="Items" type="checkbox" checked="checked" value="6" />计量检定员证号	<br>
<input name="Items" type="checkbox" checked="checked" value="7" />首次取证日期<br>
<input name="Items" type="checkbox" checked="checked" value="8" />有效期<br>
<input name="Items" type="checkbox" checked="checked" value="9" />可从事检定项目	<br>
<input name="Items" type="checkbox" checked="checked" value="10" />签发日期<br>
<input name="Items" type="checkbox" checked="checked" value="11" />记录日期(年份)<br>
		</form>
	</div>
</div>					

<div data-options="region:'center',split:false">
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="dwmc" width="130">单位名称</th>
			<th field="xm" width="130">姓名</th>
			<th field="xb" width="130">性别</th>
			<th field="whcd" width="130">文化程度</th>
			<th field="csny" width="130">出生年月</th>
			<th field="jlzh" width="130">计量检定员证员</th>
			<th field="qzrq" width="130">首次取证日期</th>
			<th field="yxq" width="130">有效期</th>
			<th field="kjxm" width="130">可从事检定项目</th>
			<th field="qfrq" width="130">签发日期</th>
			
			<th field="jlnf" width="130">记录时间(年份)</th>
			<th field="username" width="130">操作员</th>
			<th field="gxsj" width="130">更新时间</th>
			<!-- <th field="submit" width="130">是否提交</th> -->
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
				<dd>单位名称:</dd>
				<dd><input size="15" id="dwmc" name="dwmc" /></dd>
			</dl>
			<dl>
				<dd>姓名:</dd>
				<dd><input size="15" id="xm" name="xm" /></dd>
			</dl>
			<dl>
				<dd>性别:</dd>
				<dd><input size="15" id="xb" name="xb" /></dd>
			</dl>
			<dl>
				<dd>文化程度:</dd>
				<dd><input type="text" style="width: 150px" id="whcd" name="whcd" /></dd>
			</dl>
			<dl>
				<dd>出生年月:</dd>
				<dd><input  type="text" style="width: 150px" id="csny" name="csny" /></dd>
			</dl>
			<dl>
				<dd>计量检定员证员:</dd>
				<dd><input  type="text" style="width: 150px" id="jlzh" name="jlzh" /></dd>
			</dl>
			<dl>
				<dd>首次取证日期:</dd>
				<dd><input  type="text" style="width: 150px" id="qzrq" name="qzrq" /></dd>
			</dl>
			<dl>
				<dd>有效期:</dd>
				<dd><textarea cols="45" rows="3" id="yxq" name="yxq"></textarea></dd>
			</dl>
						<dl>
				<dd>可从事检定项目:</dd>
				<dd><textarea cols="45" rows="3" id="kjxm" name="kjxm"></textarea></dd>
			</dl>
						<dl>
				<dd>签发日期:</dd>
				<dd><input  type="text" style="width: 150px" id="qfrq" name="qfrq" /></dd>
			</dl>
			
			<!--  <dl>
				<dd>记录时间:</dd>
				<dd><input size="15" id="jlnf" name="jlnf" /></dd>
			</dl>
			<dl>
				<dd>操作员:</dd>
				<dd><input size="15" id="username" name="username" /></dd>
			</dl>
			<dl>
				<dd>更新时间:</dd>
				<dd><input size="15" id="gxsj" name="gxsj" /></dd>
			</dl>
			<dl>
				<dd>是否提交:</dd>
				<dd>
				<select style="width: 150px" id="submit" name="submit" >
				<option value="是">是</option>
				<option value="否">否</option>
				
				</dd>
			</dl>  -->
		</form>
	</div>
</div>	
</body>

</html>
