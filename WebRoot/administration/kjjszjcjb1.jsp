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
<title>专家库</title>
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
<script type="text/javascript" src="<%=basePath%>/script/kjjszjcjb1.js"></script>
<script type="text/javascript"
	src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

	<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
		<form id="searchForm">
			<table>
				<tr>
					<th>选择查询条件1：</th>
					<td><select id="select" name="select">
							<option value="0"></option>
							<option value="1">姓名</option>
							<option value="2">性别</option>
							<option value="3">工作单位</option>
							<option value="4">工作部门</option>
							<option value="5">职务</option>
							<option value="6">技术职称</option>
							<option value="7">所属专业</option>
							<option value="8">研究方向</option>
							<option value="9">手机</option>
							<option value="10">电话</option>
						    <option value="11">邮箱</option>
					     	<option value="12">身份证号</option> 
					     	<option value="13">备注</option> 
					     	<option value="14">专家类别</option>

					</select> <input id="fileName" /></td>
				</tr>
				
				<tr>
					<th>选择查询条件2：</th>
					<td><select id="select1" name="select1">
							<option value="0"></option>
							<option value="1">姓名</option>
							<option value="2">性别</option>
							<option value="3">工作单位</option>
							<option value="4">工作部门</option>
							<option value="5">职务</option>
							<option value="6">技术职称</option>
							<option value="7">所属专业</option>
							<option value="8">研究方向</option>
							<option value="9">手机</option>
							<option value="10">电话</option>
						    <option value="11">邮箱</option>
					     	<option value="12">身份证号</option> 
					     	<option value="13">备注</option> 
					     	<option value="14">专家类别</option>

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
			onclick="selectExcel()">导出</a>
	</form>

	<div id="divEdit2" style="display:none;">
		<div id="tabEdit2" style="overflow-y:auto;">
			<form id="frmEdit2" style="width:330px;margin:0px 0px 0px 0px"
				method="post">
				>>>请选择导出项<<< <br> <br> <input name="Items" type="checkbox"
					checked="checked" value="1" />姓名<br> <input name="Items"
					type="checkbox" checked="checked" value="2" />性别 <br> <input
					name="Items" type="checkbox" checked="checked" value="3" />工作单位<br>
				<input name="Items" type="checkbox" checked="checked" value="4" />工作部门<br>
				<input name="Items" type="checkbox" checked="checked" value="5" />职务<br>
				<input name="Items" type="checkbox" checked="checked" value="6" />技术职称<br>
				<input name="Items" type="checkbox" checked="checked" value="7" />所属专业<br>
				<input name="Items" type="checkbox" checked="checked" value="8" />研究方向<br>
				<input name="Items" type="checkbox" checked="checked" value="9" />手机<br>
				<input name="Items" type="checkbox" checked="checked" value="10" />电话
				<br> <input name="Items" type="checkbox" checked="checked"
					value="11" />邮箱 <br> <input name="Items" type="checkbox"
					checked="checked" value="12" />身份证号<br> <input name="Items"
					type="checkbox" checked="checked" value="13" />备注 <br> <input
					name="Items" type="checkbox" checked="checked" value="14" />记录时间<br>
			</form>
		</div>
	</div>


	<div data-options="region:'center',split:false">
		<!-- 表格主题部分-->
		<table id="dg">
			<thead>
				<tr>
					<th field="xm" width="130">姓名</th>
					<th field="xb" width="130">性别</th>
					<th field="gzdw" width="130">工作单位</th>
					<th field="gzbm" width="130">工作部门</th>
					<th field="zw" width="130">职务</th>
					<th field="jszc" width="130">技术职称</th>
					<th field="sszy" width="130">所属专业</th>
					<th field="yjfx" width="130">研究方向</th>
					<th field="sj" width="130">手机</th>
					<th field="dh" width="130">电话</th>
					<th field="yx" width="130">邮箱</th>
					<th field="sfzh" width="130">身份证号</th>
					<th field="bz" width="130">备注</th>


					<th field="jlnf" width="130">记录时间(年份)</th>
					<th field="username" width="130">操作员</th>
					<th field="gxsj" width="130">更新时间</th>
					<th field="lb" width="130">专家类别</th>
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
					<dd>姓名:</dd>
					<dd>
						<input size="20" id="xm" name="xm" />
					</dd>
				</dl>
				<dl>
					<dd>性别:</dd>
					<dd>
						<select id="xb" name="xb">
							<option value=""></option>
							<option value="男">男</option>
							<option value="女">女</option>
						</select>
					</dd>
				</dl>
				<dl>
					<dd>工作单位:</dd>
					<dd>
						<input size="20" id="gzdw" name="gzdw" />
					</dd>
				</dl>
				<dl>
					<dd>工作部门:</dd>
					<dd>
						<input size="20" id="gzbm" name="gzbm" />
					</dd>
				</dl>
				<dl>
					<dd>职务:</dd>
					<dd>
						<input size="20" id="zw" name="zw" />
					</dd>
				</dl>
				<dl>
					<dd>技术职称:</dd>
					<dd>
						<input size="20" id="jszc" name="jszc" />
					</dd>
				</dl>
				<dl>
					<dd>所属专业:</dd>
					<dd>
						<input size="20" id="sszy" name="sszy" />
					</dd>
				</dl>
				<dl>
					<dd>研究方向:</dd>
					<dd>
						<input size="20" id="yjfx" name="yjfx" />
					</dd>
				</dl>
				<dl>
					<dd>手机:</dd>
					<dd>
						<input size="20" id="sj" name="sj" />
					</dd>
				</dl>
				<dl>
					<dd>电话:</dd>
					<dd>
						<input size="20" id="dh" name="dh" />
					</dd>
				</dl>
				<dl>
					<dd>邮箱:</dd>
					<dd>
						<input size="20" id="yx" name="yx" />
					</dd>
				</dl>
				<dl>
					<dd>身份证号:</dd>
					<dd>
						<input size="20" id="sfzh" name="sfzh" />
					</dd>
				</dl>

				<dl>
					<dd>备注:</dd>
					<dd>
						<textarea cols="20" rows="3" id="bz" name="bz"></textarea>
					</dd>
				</dl>
				<dl>
					<dd>专家类别:</dd>
					<dd>
						<select id="lb" name="lb">
							<option value="请选择专家类型">请选择专家类型</option>
							<option value="质量专家">质量专家</option>
							<option value="计量专家">计量专家</option>
							<option value="科技专家">科技专家</option>
							<option value="许可专家">许可专家</option>
						</select>
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
