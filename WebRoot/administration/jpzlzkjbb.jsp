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
<script type="text/javascript" src="<%=basePath%>/script/jpzlzkjbb.js"></script>
  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

	<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
		<form id="searchForm">
			<table>
				<tr>
					<th>季度：</th>
					<td><input id="fileName" /></td>
				</tr>
				<tr>
					<th>单位名称：</th>
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
</form>

<div id="divEdit2" style="display:none;">
	<div id="tabEdit2" style="overflow-y:auto;">
		<form id="frmEdit2" style="width:330px;margin:0px 0px 0px 0px"  method= "post">
		 >>>请选择导出项<<<
		 <br> <br>
<input name="Items" type="checkbox" checked="checked" value="1" />季度<br>
<input name="Items" type="checkbox" checked="checked" value="2" />单位名称<br> 
<input name="Items" type="checkbox" checked="checked" value="3" />军品一次交验（检）合格率<br> 
<input name="Items" type="checkbox" checked="checked" value="4" />重大试验成功率	<br>
<input name="Items" type="checkbox" checked="checked" value="5" />军品质量损失率	<br> 
<input name="Items" type="checkbox" checked="checked" value="6" />单位重大质量活动情况<br> 
<input name="Items" type="checkbox" checked="checked" value="7" />填表人	<br>
<input name="Items" type="checkbox" checked="checked" value="8" />质量部门负责人	<br>
<input name="Items" type="checkbox" checked="checked" value="9" />审核人	<br>
<input name="Items" type="checkbox" checked="checked" value="10" />报出日期	<br>
<input name="Items" type="checkbox" checked="checked" value="11" />记录时间(年份)<br>

		</form>
	</div>
</div>		

	<div data-options="region:'center',split:false">
		<!-- 表格主题部分-->
		<table id="dg">
			<thead>
				<tr>
					<th field="jd">季度</th>
					<th field="dwmc">单位名称</th>
					<th field="hgl">军品一次交验（检）合格率</th>
					<th field="cgl">重大试验成功率</th>
					<th field="ssl">军品质量损失率</th>
					<th field="zlhdqk">单位重大质量活动情况</th>
		            <th field="tbr">填表人</th>
					<th field="zlbfzr">质量部门负责人</th>
			    	<th field="shr">审核人</th>
					<th field="bcrq">报出日期</th>
					
					<th field="jlnf" width="130">记录时间(年份)</th>
			<th field="username" width="130">操作员</th>
			<th field="gxsj" width="130">更新时间</th>
			<th field="submit" width="130">是否提交</th>
			
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
					<dd>
						季度: <input size="15" id="jd" name="jd" />
					</dd>
				</dl>


				<dl>
					<dd>
						单位名称: <input size="15" id="dwmc" name="dwmc" />
					</dd>
				</dl>
				<dl>
					<dd>
						军品一次交验（检）合格率: <input size="15" id="hgl" name="hgl" />
					</dd>
				</dl>
				<dl>
					<dd>
						重大试验成功率: <input size="15" id="cgl" name="cgl" />
					</dd>
				</dl>
				<dl>
					<dd>
						军品质量损失率: <input size="15" id="ssl" name="ssl" />
					</dd>
				</dl>
								<dl>
					<dd>
						单位重大质量活动情况: <input size="15" id="zlhdqk" name="zlhdqk" />
					</dd>
				</dl>
								<dl>
					<dd>
						填表人: <input size="15" id="tbr" name="tbr" />
					</dd>
				</dl>
												<dl>
					<dd>
						质量部门负责人: <input size="15" id="zlbfzr" name="zlbfzr" />
					</dd>
				</dl>
												<dl>
					<dd>
						审核人: <input size="15" id="shr" name="shr" />
					</dd>
				</dl>
												<dl>
					<dd>
						报出日期: <input  type="text" style="width: 150px" id="bcrq" name="bcrq" />
					</dd>
				</dl>
				
				 <dl>
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
			</dl> 

			</form>
		</div>
	</div>
</body>

</html>
