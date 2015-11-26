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
	<script type="text/javascript" src="<%=basePath%>/script/addright.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                
                <tr>
					<th>用户名：</th>
					<td>
                        <input id="rightname" />
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
			<th field="userid" width="130">用户id</th>
			<th field="rightid" width="130">权限id</th>
			
			
		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:600px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>用户id:</dd>
				
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp 
				<select  id="userid" name="userid" type="select" width=“60px"  style="width:150px;">
				
				<option value="1"> admin</option>
				<option value="2"> admin2</option>
				<option value="3"> user1</option>
				<option value="4"> user2</option>
				<option value="5"> user3</option>
				<option value="6"> user4</option>
				<option value="7"> user5</option>
				<option value="8"> user6</option>
				</select>
				
				
<!-- 				<dd>	 -->
<!-- 			<select id="yyhy" multiple="true" name="yyhy" style="width:150px;"></select> -->
<!-- 			</dd> -->
			
				
			</dl>
			<dl>
				<dd>权限id:</dd>
				<dd>
				
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type="checkbox" name="rightid" value="1"/><span>行政管理</span>
				</br>
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type="checkbox" name="rightid" value="2"/><span>科技项目管理</span>
				</br>
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type="checkbox" name="rightid" value="3"/><span>军品质量管理</span>
				</br>
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type="checkbox" name="rightid" value="4"/><span>计量机构管理</span>
				</br>
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type="checkbox" name="rightid" value="5"/><span>武器装备许可管理</span>
				</br>
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type="checkbox" name="rightid" value="6"/><span>系统管理</span>
				</br>
				&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<input type="checkbox" name="rightid" value="7"/><span>数据库管理</span>
				</br>
				</dd>
			</dl>
			
			
		</form>
	</div>
</div>	
</body>

</html>
