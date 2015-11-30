<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>质量报告统计表</title>
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
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">
		//JQuery的入口
		var curWwwPath = window.document.location.href;
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		var localhostPath = curWwwPath.substring(0, pos);
		var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		var basePath = localhostPath + projectName;
		$(function() {
			listDoc();

		});
		//加载列表
		function listDoc() {
			var actionPath = basePath + '/system/JpzlbgtjbAction_list.action';
			 $('#dg').datagrid({
		            title : '质量报告统计表',
		            width : 1200,
		            height: 400,
		            //fit: true,
					fitColumns : true, // 自动适应列宽      
		            pageSize : 5,//默认选择的分页是每页5行数据
		            pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
		            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
		            //toolbar:"#toolbar",//在添加 增添、删除、修改操作的按钮要用到这个
		            url:actionPath,//url调用Action方法
		            loadMsg : '数据装载中......',
		            singleSelect:true,//为true时只能选择单行
		            //sortName : 'xh',//当数据表格初始化时以哪一列来排序
		            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
		            pagination : true,//分页
		            rownumbers : true,//行数
					
		        });
		 
		}
		//查询
		function doSearch(){
			$('#dg').datagrid('load',{
				year: $('#year').val(),
				dwmc: $('#dwmc').val()
			});
		}
	
		// 关闭窗口
		function showInfo(path) {
			var action = basePath + '/system/JpzlbgtjbAction_' + path + '.action?year=';
			var url = action + $('#year').val();
			$.get(url, function(result) {
				if(result.length != 0){
					$.messager.alert('提醒', result + '没有申报', 'info');
				}
				else{
					$.messager.alert('提醒', '所有单位都已申报', 'info');
				}
			});
		}
	
	</script>
</head>

<body>
<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>年&nbsp;&nbsp;&nbsp;&nbsp;份：</th>
                    <td>
						<input id="year" />
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-tip'" href="javascript:void(0);" onclick="showInfo('noFisrt');">一季度未报</a>
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-tip'" href="javascript:void(0);" onclick="showInfo('noSecond');">二季度未报</a>
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-tip'" href="javascript:void(0);" onclick="showInfo('noThird');">三季度未报</a>
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-tip'" href="javascript:void(0);" onclick="showInfo('noFourth');">四季度未报</a>
					</td>
                </tr>
                <tr>
					<th>单位名称：</th>
					<td>
                        <input id="dwmc" />
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
			<th field="dwmc" width="130">单位名称</th>
			<th field="year" width="130">年份</th>
			<th field="first" width="130">一季度</th>
			<th field="second" width="130">二季度</th>
			<th field="third" width="130">三季度</th>
			<th field="fourth" width="130">四季度</th>
			
		</tr>
	</thead>
	</table>
</div>
</body>

</html>
