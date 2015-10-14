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
	
	
<script type="text/javascript">
		var url;
		$(function() {
        $('#dg').datagrid({
            title : '公文管理',
            width : 1200,
            height: 400,
            //fit: true,
            pageSize : 5,//默认选择的分页是每页5行数据
            pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
            toolbar:"#toolbar",//在添加 增添、删除、修改操作的按钮要用到这个
            url:'<%=basePath%>/system/XzxzgzbAction_list.action',//url调用Action方法
            loadMsg : '数据装载中......',
            singleSelect:true,//为true时只能选择单行
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
            pagination : true,//分页
            rownumbers : true//行数
        });
         
    });
		
		function addDoc(){
			$('#frmEdit').dialog('open').dialog('setTitle','添加');
			$('#fm').form('clear');
	//		url = 'save_user.php';
		}
		function editUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$('#frmEdit').dialog('open').dialog('setTitle','编辑');
				$('#fm').form('load',row);
				url = 'update_user.php?id='+row.id;
			}
		}
/*		function save(){
			$('#fm').form('submit',{
				url: url,
				onSubmit: function(){
					return $(this).form('validate');
				},
				success: function(result){
					var result = eval('('+result+')');
					if (result.success){
						$('#frmEdit').dialog('close');		// close the dialog
						$('#dg').datagrid('reload');	// reload the user data
					} else {
						$.messager.show({
							title: 'Error',
							msg: result.msg
						});
					}
				}
			});
		}
*/
		function dealSave() {
		// 表单数据序列化成一个字符串用&拼接
			var params = $("#frmEdit").serialize();
			// 得到doc的值，为空串表示添加的值，为空串表示添加
			if ($("#doc").val() == "") {
				$.post("addBook.action", params, function(result) {
				if (result.operateSuccess) {
					$('#dg').datagrid('reload');// 重新加载
					$.messager.alert('添加', '添加成功', 'info');
				} else {
					$.messager.alert('添加', '添加失败', 'warning');
				}
			});
			} else {
			// 表示更新
				$.post("updateBook.action", params, function(result) {
					if (result.operateSuccess) {
						$('#dg').datagrid('reload');// 重新加载
						$.messager.alert('更新', '更新成功', 'info');
					} else {
						$.messager.alert('更新', '更新失败', 'warning');
					}
				});
			}
		}
		function removeUser(){
			var row = $('#dg').datagrid('getSelected');
			if (row){
				$.messager.confirm('Confirm','Are you sure you want to remove this user?',function(r){
					if (r){
						$.post('remove_user.php',{id:row.id},function(result){
							if (result.success){
								$('#dg').datagrid('reload');	// reload the user data
							} else {
								$.messager.show({	// show error message
									title: 'Error',
									msg: result.msg
								});
							}
						},'json');
					}
				});
			}
		}
		function doSearch(){
			$('#dg').datagrid('load',{
				wjm: $('#filename').val(),
				wjh: $('#fileId').val()
			});
		}
	</script>	
</head>
<body>
<div data-options="region:'north',title:'高级查询'" style="height: 100px; background: #F4F4F4;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>文件名：</th>
                    <td>
						<input name="name" />
					</td>
                </tr>
                <tr>
					<th>发文日期：</th>
					<td>
                        <input class="easyui-datetimebox" name="time" />
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td>
                    <td><a class="easyui-linkbutton" href="javascript:void(0);" onclick="clearSearch();">清空</a>
					</td>
                </tr>
            </table>
        </form>
</div>
<div data-options="region:'center',split:false">
	<table id="dg">
		<thead>
			<tr>
				<th field="wjm" width="130">文件名</th>
				<th field="wjh" width="130">文件编号</th>
				<th field="fwjg" width="130">发文机关</th>
				<th field="fwrq" width="130">发文日期</th>
				<th field="jbnr" width="130">交办内容</th>
				<th field="jzrq" width="130">截止日期</th>
				<th field="jbr" width="130">交办人</th>
				<th field="cljg" width="130">处理结果</th>
			</tr>
		</thead>
	</table>
</div>
	<div id="toolbar">
		<span style="text-align: right;">文件名:</span>
		<input id="filename" style="line-height:20px;border:1px solid #ccc">
		<span style="text-align: right;">文件编号:</span>
		<input id="fileId" style="line-height:20px;border:1px solid #ccc">
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">Search</a>
		<div style="float: right;">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addDoc()">添加</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDoc()">编辑</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="removeDoc()">删除</a>
		</div>
	</div>
	
	<div id="frmEdit" class="easyui-dialog" style="width:600px;height:400px;padding:10px 20px"
			closed="true" buttons="#frmEdit-buttons">
		<form id="fm" method="post" novalidate>
			<div class="fitem">
				<p>文件名:</p>
				<input id="doc" name="filename" class="easyui-validatebox" required="true" style="width:350px; height:22px"></input>
			</div>
			<div class="fitem">
				<p>文件编号:</p>
				<input name="fileId" class="easyui-validatebox" required="true" style="width:350px; height:22px"></input>
			</div>
			<div class="fitem">
				<p>发文机关:</p>
				<input name="orgniaztion" class="easyui-validatebox" style="width:350px; height:22px"></input>
			</div>
			<div class="fitem">
				<p>发文日期:</p>
				<input name="date" id="dd" class="easyui-datebox" style="width:350px; height:22px"></input>
			</div>
			<div class="fitem">
				<p>交办内容:</p>
				<textarea name="content" style="width:350px; height:60px"></textarea>
			</div>
			<div class="fitem">
				<p>截止日期:</p>
				<input name="deadline" id="dd" class="easyui-datebox" style="width:350px; height:22px"></input>
			</div>
			<div class="fitem">
				<p>交办人:</p>
				<input name="officer" class="easyui-validatebox" style="width:350px; height:22px"></input>
			</div>
			<div class="fitem">
				<p>处理结果:</p>
				<textarea name="result" style="width:350px; height:60px"></textarea>
			</div>
			
			
		</form>
	</div>
	<div id="frmEdit-buttons">
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="dealSave()">保存</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#frmEdit').dialog('close')">取消</a>
	</div>
</body>

</html>
