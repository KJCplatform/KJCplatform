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
<title>公文管理</title>
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
<script type="text/javascript"
	src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/document.js"></script>
</head>

<body>

	<div data-options="region:'north',title:'查询'" style="height: 60px;">
		<form id="searchForm">
			<table>
				<tr>
					<th>选择查询条件1：</th>
					<td><select id="select" name="select">
							<option value="0"></option>
							<option value="1">文件名</option>
							<option value="2">文件编号</option>
							<option value="3">发文机关</option>
							<!-- <option value="4">发文日期</option> -->
							<option value="5">交办内容</option>
							<!-- <option value="6">截止日期</option> -->
							<option value="7">交办人</option>
							<option value="8">处理结果</option>
							<option value="9">发文类别</option>
							<!-- <option value="9">记录年份</option>
						<option value="10">操作员</option>
						<option value="11">更新时间</option> -->

					</select> <input id="fileName" /></td>
				</tr>
				<!--  <tr>
					<th>文件号：</th>
					<td>
                        <input id="fileId" />
					</td>
					
                
                </tr> -->
				<tr>
					<th>选择查询条件2：</th>
					<td><select id="select2" name="select2">
							<option value="0"></option>
							<option value="1">文件名</option>
							<option value="2">文件编号</option>
							<option value="3">发文机关</option>
							<!-- <option value="4">发文日期</option> -->
							<option value="5">交办内容</option>
							<!-- <option value="6">截止日期</option> -->
							<option value="7">交办人</option>
							<option value="8">处理结果</option>
							<option value="9">发文类别</option>
							<!-- <option value="9">记录年份</option>
						<option value="10">操作员</option>
						<option value="11">更新时间</option> -->

					</select> <input id="fileId" /></td>
					<td><a class="easyui-linkbutton"
						data-options="iconCls:'icon-search'" href="javascript:void(0);"
						onclick="doSearch();">查询</a></td>
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
				>>>请选择导出项<<< <br> <br> <input name="Items" type="checkbox"
					checked="checked" value="1" />文件名 <br> <input name="Items"
					type="checkbox" checked="checked" value="2" />文件编号<br> <input
					name="Items" type="checkbox" checked="checked" value="3" />发文机关<br>
				<input name="Items" type="checkbox" checked="checked" value="4" />发文日期<br>
				<input name="Items" type="checkbox" checked="checked" value="5" />发文类别<br>
				<input name="Items" type="checkbox" checked="checked" value="6" />交办内容<br>
				<input name="Items" type="checkbox" checked="checked" value="7" />截止日期<br>
				<input name="Items" type="checkbox" checked="checked" value="8" />交办人<br>
				<input name="Items" type="checkbox" checked="checked" value="9" />处理结果<br>
				<input name="Items" type="checkbox" checked="checked" value="10" />记录年份<br>
			</form>
		</div>
	</div>

	<div data-options="region:'center',split:false">
		<!-- 表格主题部分-->
		<table id="dg">
			<thead>
				<tr>
					<th field="wjm" width="130">文件名</th>
					<th field="wjh" width="130">文件编号</th>
					<th field="fwjg" width="130">发文机关</th>
					<th field="fwrq" width="130">发文日期</th>
					<th field="fwlb" width="130">发文类别</th>
					<th field="jbnr" width="130">交办内容</th>
					<th field="jzrq" width="130">截止日期</th>
					<th field="jbr" width="130">交办人</th>
					<th field="cljg" width="130">处理结果</th>
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
			<form id="frmEdit" style="width:800px; height:400px; overflow:auto;"
				method="post">
				<input type="hidden" id="id" name="id" />
				<dl>
					<dd>文件名:</dd>
					<dd>
						<input size="15" id="wjm" name="wjm" />
					</dd>
				</dl>
				<dl>
					<dd>文件号:</dd>
					<dd>
						<input size="15" id="wjh" name="wjh" />
					</dd>
				</dl>
				<dl>
					<dd>发文机关:</dd>
					<dd>
						<input size="15" id="fwjg" name="fwjg" />
					</dd>
				</dl>
				<dl>
					<dd>发文日期:</dd>
					<dd>
						<input type="text" style="width: 150px" id="fwrq" name="fwrq" />
					</dd>
				</dl>
				<dl>
					<dd>发文类别:</dd>
					<dd>
						<input type="text" style="width: 150px" id="fwlb" name="fwlb" />
					</dd>
				</dl>
				<dl>
					<dd>交办内容:</dd>
					<dd>
						<textarea cols="45" rows="3" id="jbnr" name="jbnr"></textarea>
					</dd>
				</dl>
				<dl>
					<dd>截止日期:</dd>
					<dd>
						<input type="text" style="width: 150px" id="jzrq" name="jzrq" />
					</dd>
				</dl>
				<dl>
					<dd>交办人:</dd>
					<dd>
						<input size="15" id="jbr" name="jbr" />
					</dd>
				</dl>
				<dl>
					<dd>处理结果:</dd>
					<dd>
						<textarea cols="45" rows="3" id="cljg" name="cljg"></textarea>
					</dd>
				</dl>


				<dl>
					<dd>
						附件1:<input type="text" id="fj1" name="fj1" class="easyui-filebox"
							style="width:200px" data-options="prompt:'请选择文件...'"> <a
							href="#" class="easyui-linkbutton" id="fj1_open"
							style="display:none;" onclick="openfj1()">打开</a> (请上传excel、word)
					</dd>
				</dl>


				<dl>
					<dd>
						附件2:<input type="text" id="fj2" name="fj2" class="easyui-filebox"
							style="width:200px"
							data-options="prompt:'请选择文件...',title:'My Dialog'"> <a
							href="#" class="easyui-linkbutton" id="fj2_open"
							style="display:none;" onclick="openfj2()">打开</a> (请上传PDF)
					</dd>
				</dl>


				<!-- <dl>
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
