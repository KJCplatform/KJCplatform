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
			var actionPath = basePath + '/system/list.action';
			 $('#dg').datagrid({
		            title : '单位信息维护表',
		            width : 1200,
		            height: 400,
		            //fit: true,
					fitColumns : true, // 自动适应列宽      
		            pageSize : 5,//默认选择的分页是每页5行数据
		            pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
		            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
		            toolbar:"#toolbar",//在添加 增添、删除、修改操作的按钮要用到这个
		            url:actionPath,//url调用Action方法
		            loadMsg : '数据装载中......',
		            singleSelect:true,//为true时只能选择单行
		            //sortName : 'xh',//当数据表格初始化时以哪一列来排序
		            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
		            pagination : true,//分页
		            rownumbers : true,//行数
			   		toolbar:[ {// 工具栏
							text : '添加',
							iconCls : 'icon-add', // 图标
							handler : function() { // 处理函数
								addDoc();
							}
						}, {
							text : '删除',
							iconCls : 'icon-cancel', // 图标
							handler : function() { // 处理函数
								deleteDoc();
							}
						}, {
							text : '编辑',
							iconCls : 'icon-edit',// 图标
							handler : function() {// 处理函数
								editDoc();
							}
						}
					 ]
					
		        });
		 
		}
		//查询
		function doSearch(){
			$('#dg').datagrid('load',{
				dwmc: $('#dwmc').val()
			});
		}
		// 显示编辑窗口
		function showEditForm() {
			$("#tabEdit").dialog({
				modal : true,// 模式窗口
				title : '单位信息维护',
				iconCls : 'icon-save',
				buttons : [ {
					text : '确认',
					handler : function() {
						// 进行表单字段验证，当全部字段都有效时返回true和validatebox一起使用
						if ($('#frmEdit').form('validate')) {
							// 提交到服务器并写入数据库
							dealSave();
							// 关闭窗口
							closeForm();
						} else {
							$.messager.alert('验证', '信息有误或不完整', 'error');
						}
					}
				}, {
					text : '取消',
					handler : function() {
						closeForm();
					}
				} ]
			});
		}

		// 关闭窗口
		function closeForm() {
			$("#frmEdit").form('clear');
			$('#tabEdit').dialog('close');
		}

		// 添加的函数
		function addDoc() {
			// 清空原有的数据
			$('#frmEdit').form('clear');
			// 显示添加对话框
			showEditForm();
		}

		// 编辑按钮的操作
		function editDoc() {
			var doc = $('#dg').datagrid('getSelected');// 得到选中的一行数据
			// 如果没有选中记录
			if (doc	== null) {
				$.messager.alert('文件', '请先选中要编辑的文件', 'info');
				return;
			}
			$('#frmEdit').form('clear');
			// 填充数据
			$("#id").val(doc.id);
			$("#dwmc").val(doc.dwmc);
			$("#jinyong").val(doc.jinyong);
			// 显示编辑页面
			showEditForm();
		}
		function dealSave() {
			// 表单数据序列化成一个字符串用&拼接
			var params = $("#frmEdit").serialize();
			var actionAdd = basePath + '/system/add.action';
			var actionUpdate = basePath + '/system/update.action';
			// 得到doc的值，为空串表示添加的值，为空串表示添加
			if ($("#id").val() == "") {
				$.post(actionAdd, params, function(result) {
					if (result.operateSuccess) {
					//		alert(result);
							$('#dg').datagrid('reload');// 重新加载
							$.messager.alert('添加', '添加成功', 'info');
					} else {
							$.messager.alert('添加', '添加失败', 'warning');
						}
				});
				} else {
				// 表示更新
					$.post(actionUpdate, params, function(result) {
						if (result.operateSuccess) {
							$('#dg').datagrid('reload');// 重新加载
								$.messager.alert('更新', '更新成功', 'info');
						} else {
								$.messager.alert('更新', '更新失败', 'warning');
							}
					});
				}
			}
		// 删除
		function deleteDoc() {
			var doc = $('#dg').datagrid('getSelected');// 得到选中的一行数据
			// 如果没有选中记录
			if (doc == null) {
				$.messager.alert('删除', '请先选中要删除的文件', 'info');
				return;
			}
			$.messager.confirm('确认', '真的要删除选中的记录吗？', function(r) {
				if (r) {
					var actionPath = basePath + '/system/delete.action?id=';
					var url = actionPath + doc.id;
					// 试一下get方法（地址，回调函数）
					$.get(url, function(result) {
						if (result.operateSuccess) {
							$.messager.alert('删除', '选中的文件成功删除！', 'info');
							// 重新加载
							$("#dg").datagrid('reload');
						} else {
							$.messager.alert('删除', '删除失败！', 'warning');
						}
					});
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
			<th field="jinyong" width="130">是否禁用</th>	
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
				<dd>是否禁用:</dd>
				<dd>
				<select style="width: 150px" id="jinyong" name="jinyong" >
				<option value="是">是</option>
				<option value="否">否</option>
				
				</dd>
			</dl> 
		</form>
	</div>
</div>	

</body>

</html>
