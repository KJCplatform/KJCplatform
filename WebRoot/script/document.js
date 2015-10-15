//JQuery的入口
$(function() {
	listDoc();
	// 日期加上日期控件
	$("#fwrq").datebox({
		required : true
	});
	$("#jzrq").datebox({
		required : true
	});
	// 给文本框加上验证器
	$("#wjm").validatebox({
		required : true
		missingMessage : '文件名不能为空'
	});
	$("#wjh").validatebox({
		required : true
		missingMessage : '文件号不能为空'
	});
	$("#jbnr").validatebox({
		required : true
	});
});
//加载公文列表
function listDoc() {
	 $('#dg').datagrid({
            title : '公文管理',
            width : 1200,
            height: 400,
            //fit: true,
			fitColumns : true, // 自动适应列宽      
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
			} ],
        });
}
// 显示编辑窗口
function showEditForm() {
	$("#tabEdit").dialog({
		modal : true,// 模式窗口
		title : '公文操作',
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
function editBook() {
	var doc = $('#dg').datagrid('getSelected');// 得到选中的一行数据
	// 如果没有选中记录
	if (doc	== null) {
		$.messager.alert('文件', '请先选中要编辑的文件', 'info');
		return;
	}
	$('#frmEdit').form('clear');
	// 填充数据
	$("#id").val(doc.id);
	$("#wjm").val(doc.wjm);
	$("#wjh").val(doc.wjh);
	$("#fwjg").val(doc.fwjg);	
	// 给默认值
	$("#fwrq").datebox("setValue", book.pubdate.substring(0, 10));
	$("#jbnr").val(doc.jbnr);
	$("#jzrq").databox('getValue');
	$("#jbr").val(doc.jbr);
	$("#cljg").val(doc.cljg);
	// 显示编辑页面
	showEditForm();
}
function dealSave() {
	// 表单数据序列化成一个字符串用&拼接
	var params = $("#frmEdit").serialize();
	// 得到doc的值，为空串表示添加的值，为空串表示添加
	if ($("#id").val() == "") {
		$.post("<%=basePath%>/system/XzxzgzbAction_add.action", params, function(result) {
			if (result.operateSuccess) {
					$('#dg').datagrid('reload');// 重新加载
					$.messager.alert('添加', '添加成功', 'info');
			} else {
					$.messager.alert('添加', '添加失败', 'warning');
				}
		});
		} else {
		// 表示更新
			$.post("<%=basePath%>/system/XzxzgzbAction_update.action", params, function(result) {
				if (result.operateSuccess) {
					$('#dg').datagrid('reload');// 重新加载
						$.messager.alert('更新', '更新成功', 'info');
				} else {
						$.messager.alert('更新', '更新失败', 'warning');
					}
			});
		}
	}
//保存操作第二种实现方法
function save(){
	$('#frmEdit').form('submit',{
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
		function save(){
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
