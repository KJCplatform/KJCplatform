<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>专家信息</title>
    <link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
	<script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/json2.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/expert.js"></script>
</head>

<body>

<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
					<th>专家姓名：</th>
					<td>
                        <input id="name" />
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td>       
                </tr>
            </table>
        </form>
</div>

<div data-options="region:'center',split:false">
	
	<!-- 专家信息-->
	<table id="info" ></table>
	<br>
	<div style="text-align:center">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submit()">submit</a>
	</div>
	<br>
	<!-- 产学研-->
	<table id="cxy">
	</table>
	<br><br>	
	<!-- 技术成果-->
	<table id="jscg">
	</table>
	<br><br>
	<!-- 在研-->
	<table id="zy">
	</table> 
		<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="cxyEdit">
		<form id="frmCxy" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>项目名称:</dd>
				<dd><input size="15" id="xmmc" name="xmmc" /></dd>
			</dl>
			<dl>
				<dd>合作起止时间:</dd>
				<dd><input size="15" id="hzsj" name="hzsj" /></dd>
			</dl>
			<dl>
				<dd>项目简介:</dd>
				<dd><textarea cols="45" rows="3" id="xmjj" name="xmjj"></textarea></dd>
			</dl>
			<dl>
				<dd>合作效果:</dd>
				<dd>
				<select id="hzxg" class="easyui-combobox" name = "hzxg">
					<option value=1>良好</option>
					<option value=0>一般</option>
				</select> 
				</dd>
			</dl>
		</form>
	</div>
	<div id="cgEdit">
		<form id="frmCg" style="width:600px" method= "post">
			<input type="hidden" id="id2" name="id" />
			<dl>
				<dd>成果名称:</dd>
				<dd><input size="15" id="cgmc" name="cgmc" /></dd>
			</dl>
			<dl>
				<dd>完成时间:</dd>
				<dd><input size="15" id="wcsj" name="wcsj" /></dd>
			</dl>
			<dl>
				<dd>成果简介:</dd>
				<dd><textarea cols="45" rows="3" id="cgjj" name="cgjj"></textarea></dd>
			</dl>
			<dl>
				<dd>转化情况:</dd>
				<dd>
				<select id="zhqk" class="easyui-combobox" name = "zhqk">
					<option value=1>已转化，继续转化</option>
					<option value=0>未转化，希望转化</option>
				</select> 
				</dd>
			</dl>
		</form>
	</div>
	<div id="zyEdit">
		<form id="frmZy" style="width:600px" method= "post">
			<input type="hidden" id="id2" name="id" />
			<dl>
				<dd>项目名称:</dd>
				<dd><input size="15" id="xmmc2" name="xmmc" /></dd>
			</dl>
			<dl>
				<dd>预计完成时间:</dd>
				<dd><input size="15" id="wcsj2" name="wcsj" /></dd>
			</dl>
			<dl>
				<dd>项目简介:</dd>
				<dd><textarea cols="45" rows="3" id="xmjj2" name="xmjj"></textarea></dd>
			</dl>
			<dl>
				<dd>是否转化:</dd>
				<dd>
				<select id="sfzh" class="easyui-combobox" name = "sfzh">
					<option value=1>是</option>
					<option value=0>否</option>
				</select> 
				</dd>
			</dl>
		</form>
	</div>
</div>	

</div>


</body>

</html>
