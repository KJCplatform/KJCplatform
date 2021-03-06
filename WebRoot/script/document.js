//JQuery的入口
//获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
var curWwwPath = window.document.location.href;
// 获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
// 获取主机地址，如： http://localhost:8080
var localhostPath = curWwwPath.substring(0, pos);
// 获取带"/"的项目名，如：/ems
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
var basePath = localhostPath + projectName;
var user;
$(function() {

	listDoc();

	// 日期加上日期控件
	$("#fwrq").datebox({
		editable : false,
		required : true
	});
	$("#jzrq").datebox({
		editable : true,
		required : false
	});
	// 给文本框加上验证器
	$("#wjm").validatebox({
		required : true,
		missingMessage : '文件名不能为空'
	});
	$("#wjh").validatebox({
		required : true,
		missingMessage : '文件号不能为空'
	});
	$("#jbnr").validatebox({
		required : true
	});
});
// 加载公文列表
function listDoc() {
	var actionPath = basePath + '/system/XzxzgzbAction_list.action';

	$('#dg').datagrid({
		title : '公文管理',
		width : 1200,
		height : 400,
		// fit: true,
		fitColumns : true, // 自动适应列宽
		pageSize : 5,// 默认选择的分页是每页5行数据
		pageList : [ 5, 10, 15, 20 ],// 可以选择的分页集合
		nowrap : true,// 设置为true，当数据长度超出列宽时将会自动截取
		toolbar : "#toolbar",// 在添加 增添、删除、修改操作的按钮要用到这个
		url : actionPath,// url调用Action方法
		loadMsg : '数据装载中......',
		singleSelect : true,// 为true时只能选择单行
		// sortName : 'xh',//当数据表格初始化时以哪一列来排序
		// sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
		pagination : true,// 分页
		rownumbers : true,// 行数

		toolbar : [ {// 工具栏
			text : '添加',
			id : 'add',
			iconCls : 'icon-add', // 图标
			handler : function() { // 处理函数
				addDoc();
			}
		}, {
			text : '删除',
			id : 'delete',
			iconCls : 'icon-cancel', // 图标
			handler : function() { // 处理函数
				deleteDoc();
			}
		}, {
			text : '编辑',
			id : 'edit',
			iconCls : 'icon-edit',// 图标
			handler : function() {// 处理函数
				editDoc();
			}
		} ],

		onLoadSuccess : function(data) {

			user = eval(data).user;

			if (user != "admin") {
				// alert("123");
				$("#delete").linkbutton("disable");
				$("#edit").linkbutton("disable");
			}
		}
	});

	// setTimeout(
	// function(){
	// // alert("Hello world");
	// if(user!="admin"){
	// // alert("admin");
	// $('#dg').datagrid({
	// toolbar:[ {// 工具栏
	// text : '添加',
	// iconCls : 'icon-add', // 图标
	// handler : function() { // 处理函数
	// addDoc();
	// }
	// }, {
	// text : '删除',
	// iconCls : 'icon-cancel', // 图标
	// handler : function() { // 处理函数
	// deleteDoc();
	// }
	// }, {
	// text : '编辑',
	// iconCls : 'icon-edit',// 图标
	// handler : function() {// 处理函数
	// editDoc();
	// }
	// }
	// ]
	// });
	// }
	// else{
	// // alert("user1");
	// $('#dg').datagrid({
	// toolbar:[ {// 工具栏
	// text : '添加',
	// iconCls : 'icon-add', // 图标
	// handler : function() { // 处理函数
	// addDoc();
	// }
	// } ]
	// });
	//				 
	// }
	// },300);
	//	 

}
// 查询

function doSearch() {
	var test = $('#select option:selected').val();
	var test2 = $('#select2 option:selected').val();
	/*
	 * alert(test); alert(test2);
	 */
	/*
	 * alert($('#select option:selected').val()); var
	 * selectObj=document.getElementById("select"); var
	 * index=selectObj.selectedIndex; var value=selectObj.options[index].value;
	 * alert(selectObj); alert(selectObj);
	 */
	if (test == 0) {
		if (test2 == 0)
			$('#dg').datagrid('load', {});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				jbnr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				fwlb : $('#fileId').val()
			});
	}
	;
	if (test == 1) {
		if (test2 == 0)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val()
			});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val(),
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val(),
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val(),
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val(),
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val(),
				jbnr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val(),
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val(),
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				wjm : $('#fileName').val(),
				fwlb : $('#fileId').val()
			});
	}
	;
	if (test == 2) {
		if (test2 == 0)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val()
			});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val(),
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val(),
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val(),
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val(),
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val(),
				jbnr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val(),
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val(),
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				wjh : $('#fileName').val(),
				fwlb : $('#fileId').val()
			});
	}
	;

	if (test == 3) {
		if (test2 == 0)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val()
			});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val(),
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val(),
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val(),
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val(),
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val(),
				jbnr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val(),
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val(),
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				fwjg : $('#fileName').val(),
				fwlb : $('#fileId').val()
			});
	}
	;

	if (test == 4) {
		if (test2 == 0)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val()
			});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val(),
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val(),
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val(),
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val(),
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val(),
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val(),
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				fwrq : $('#fileName').val(),
				fwlb : $('#fileId').val()
			});
	}
	;

	if (test == 5) {
		if (test2 == 0)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val()
			});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val(),
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val(),
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val(),
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val(),
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val(),
				jbnr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val(),
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val(),
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				jbnr : $('#fileName').val(),
				fwlb : $('#fileId').val()
			});
	}
	;

	if (test == 6) {
		if (test2 == 0)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val()
			});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val(),
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val(),
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val(),
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val(),
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val(),
				jbnr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val(),
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val(),
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				jzrq : $('#fileName').val(),
				fwlb : $('#fileId').val()
			});
	}
	;

	if (test == 7) {
		if (test2 == 0)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val()
			});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val(),
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val(),
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val(),
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val(),
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val(),
				jbnr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val(),
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val(),
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				jbr : $('#fileName').val(),
				fwlb : $('#fileId').val()
			});
	}
	;

	if (test == 8) {
		if (test2 == 0)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val()
			});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val(),
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val(),
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val(),
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val(),
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val(),
				jbnr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val(),
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val(),
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				cljg : $('#fileName').val(),
				fwlb : $('#fileId').val()
			});
	}
	;
	if(test==9){
		if(test2 == 0)
			$('#dg').datagrid('load', {
			fwlb : $('#fileName').val()
		});
		if (test2 == 1)
			$('#dg').datagrid('load', {
				fwlb : $('#fileName').val(),
				wjm : $('#fileId').val()
			});
		if (test2 == 2)
			$('#dg').datagrid('load', {
				fwlb : $('#fileName').val(),
				wjh : $('#fileId').val()
			});
		if (test2 == 3)
			$('#dg').datagrid('load', {
				fwlb : $('#fileName').val(),
				fwjg : $('#fileId').val()
			});
		if (test2 == 4)
			$('#dg').datagrid('load', {
				fwlb : $('#fileName').val(),
				fwrq : $('#fileId').val()
			});
		if (test2 == 5)
			$('#dg').datagrid('load', {
				fwlb : $('#fileName').val(),
				jbnr : $('#fileId').val()
			});
		if (test2 == 6)
			$('#dg').datagrid('load', {
				fwlb : $('#fileName').val(),
				jzrq : $('#fileId').val()
			});
		if (test2 == 7)
			$('#dg').datagrid('load', {
				fwlb : $('#fileName').val(),
				jbr : $('#fileId').val()
			});
		if (test2 == 8)
			$('#dg').datagrid('load', {
				fwlb : $('#fileName').val(),
				cljg : $('#fileId').val()
			});
		if (test2 == 9)
			$('#dg').datagrid('load', {
				fwlb : $('#fileName').val(),
				fwlb : $('#fileId').val()
			});
	}

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
	$("#fj1_open").hide();
	$("#fj2_open").hide();
	// 显示添加对话框
	showEditForm();
}

// 编辑按钮的操作
function editDoc() {
	var doc = $('#dg').datagrid('getSelected');// 得到选中的一行数据
	// 如果没有选中记录
	if (doc == null) {
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
	$("#fwrq").datebox("setValue", doc.fwrq.substring(0, 10));
	// $("#fwrq").datebox("getValue");
	$("#jbnr").val(doc.jbnr);
	// alert($("#jzrq").datebox("getValue"));
	$("#jzrq").datebox("setValue", doc.jzrq.substring(0, 10));
	// $("#jzrq").datebox("getValue");
	$("#jbr").val(doc.jbr);
	$("#cljg").val(doc.cljg);
	$("#fwlb").val(doc.fwlb);
	/*
	 * $("#jlnf").val(doc.jlnf); $("#username").val(doc.username);
	 * $("#gxsj").val(doc.gxsj); $("#submit").val(doc.submit);
	 */
	// 显示编辑页面
	$("#fj1_open").show();
	$("#fj2_open").show();
	showEditForm();
}
function dealSave() {
	// 表单数据序列化成一个字符串用&拼接
	var params = $("#frmEdit").serialize();
	var actionAdd = basePath + '/system/XzxzgzbAction_add.action';
	var actionUpdate = basePath + '/system/XzxzgzbAction_update.action';
	// 得到doc的值，为空串表示添加的值，为空串表示添加

	var fileName = $('#uploadExcel').filebox('getValue');
	//	
	// 附件1 附件2
	params += "&fj1=" + $('#fj1').filebox('getValue');
	params += "&fj2=" + $('#fj2').filebox('getValue');
	// alert(params);

	if ($("#id").val() == "") {
		$.post(actionAdd, params, function(result) {
			if (result.operateSuccess) {
				// alert(result);
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
// 保存操作第二种实现方法
function save() {
	$('#frmEdit').form('submit', {
		url : url,
		onSubmit : function() {
			return $(this).form('validate');
		},
		success : function(result) {
			var result = eval('(' + result + ')');
			if (result.success) {
				$('#frmEdit').dialog('close'); // close the dialog
				$('#dg').datagrid('reload'); // reload the user data
			} else {
				$.messager.show({
					title : 'Error',
					msg : result.msg
				});
			}
		}
	});
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
			var actionPath = basePath
					+ '/system/XzxzgzbAction_delete.action?id=';
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

function ShowImport() {

	// var file_upl = document.getElementById('uploadExcel');
	// file_upl.select();
	// var fileName = document.selection.createRange().text;
	// alert(fileName);

	// 得到上传文件的全路径
	var fileName = $('#uploadExcel').filebox('getValue');
	//	

	// alert(fileName);
	// 进行基本校验
	if (fileName == "") {
		$.messager.alert('提示', '请选择上传文件！', 'info');
	} else {
		// 对文件格式进行校验
		var d1 = /\.[^\.]+$/.exec(fileName);
		if (d1 == ".xls") {
			// 提交表单
			// document.getElementById("questionTypesManage").action="${pageContext.request.contextPath}/leadtoQuestionTypes/leadInExcelQuestionBank?questionType="+questionTypes+"&courseType="+courseType;
			// document.getElementById("questionTypesManage").submit();
			var params = "id=" + fileName;
			var showimport = basePath
					+ '/system/XzxzgzbAction_showimport.action';

			// alert(params);

			$.post(showimport, params, function(result) {
				if (result.operateSuccess) {
					$('#dg').datagrid('reload');// 重新加载
					$.messager.alert('导入', '导入Excel成功', 'info');

				} else {
					$.messager.alert('导入', '导入Excel失败', 'warning');
				}
			});

			return false;
		} else {
			$.messager.alert('提示', '请选择xls格式文件！', 'info');
			$('#uploadExcel').filebox('setValue', '');
		}
	}
}

function ShowExport() {

	var Items = document.getElementsByName("Items");
	var params = "id=";

	for (var i = 0; i < Items.length; i++) {
		if (Items[i].checked == true) {
			params += Items[i].value + " ";
		}
	}

	// alert(params);

	var showimport = basePath + '/system/XzxzgzbAction_showexport.action';

	$.post(showimport, params, function(result) {
		if (result.operateSuccess) {
			$('#dg').datagrid('reload');// 重新加载
			$.messager.alert('导出', '导出Excel成功', 'info');

		} else {
			$.messager.alert('导出', '文件被占用！导出Excel失败', 'warning');
		}
	});

	return false;
}

// Excelselect
function selectExcel() {

	$("#tabEdit2").dialog({
		modal : true,// 模式窗口
		title : '导出Excel',
		iconCls : 'icon-save',
		buttons : [ {
			text : '确认',
			handler : function() {

				ShowExport();
				closeForm2();
			}
		}, {
			text : '取消',
			handler : function() {
				closeForm2();
			}
		} ]
	});
}

// 导出pdf

function ToPdf() {

	var Items = document.getElementsByName("Items");
	var params = "id=";

	for (var i = 0; i < Items.length; i++) {
		if (Items[i].checked == true) {
			params += Items[i].value + " ";
		}
	}

	// alert(params);

	var topdf = basePath + '/system/XzxzgzbAction_topdf.action';

	$.post(topdf, params, function(result) {
		if (result.operateSuccess) {
			$('#dg').datagrid('reload');// 重新加载
			$.messager.alert('导出', '导出Excel成功', 'info');

		} else {
			$.messager.alert('导出', '文件被占用！导出Excel失败', 'warning');
		}
	});

	return false;
}

function topdf() {

	$("#tabEdit2").dialog({
		modal : true,// 模式窗口
		title : '导出pdf',
		iconCls : 'icon-save',
		buttons : [ {
			text : '确认',
			handler : function() {

				ToPdf();
				closeForm2();
			}
		}, {
			text : '取消',
			handler : function() {
				closeForm2();
			}
		} ]
	});
}

function closeForm2() {
	// $("#frmEdit2").form('clear');
	$('#tabEdit2').dialog('close');
}

function writeFileToService() {

	// var file_upl = document.getElementById('uploadExcel');
	// file_upl.select();
	// var fileName = document.selection.createRange().text;
	// alert(fileName);

	// 得到上传文件的全路径
	var fileName = $('#uploadExcel').filebox('getValue');
	//	

	// alert(fileName);
	// 进行基本校验
	if (fileName == "") {
		$.messager.alert('提示', '请选择上传文件！', 'info');
	} else {
		// 对文件格式进行校验
		var d1 = /\.[^\.]+$/.exec(fileName);
		if (d1 == ".xls") {
			// 提交表单
			// document.getElementById("questionTypesManage").action="${pageContext.request.contextPath}/leadtoQuestionTypes/leadInExcelQuestionBank?questionType="+questionTypes+"&courseType="+courseType;
			// document.getElementById("questionTypesManage").submit();
			var params = "id=" + fileName;
			var writeFileToService = basePath
					+ '/system/FileOperateUtilAction_writeFileToService.action';

			// alert(params);

			$.post(writeFileToService, params, function(result) {
				if (result.operateSuccess) {
					$('#dg').datagrid('reload');// 重新加载
					$.messager.alert('导入', '导入Excel成功', 'info');

				} else {
					$.messager.alert('导入', '导入Excel失败', 'warning');
				}
			});

			return false;
		} else {
			$.messager.alert('提示', '请选择xls格式文件！', 'info');
			$('#uploadExcel').filebox('setValue', '');
		}
	}
}

function openfj1() {
	var doc = $('#dg').datagrid('getSelected');// 得到选中的一行数据
	params = "id=" + doc.id;
	var openfj1 = basePath + '/system/XzxzgzbAction_openfj1.action';

	$.post(openfj1, params, function(result) {
		if (result.operateSuccess) {
			$.messager.alert('打开', '打开成功！', 'info');

		} else {Jzrq
			$.messager.alert('打开', '格式不正确或不存在此文件！', 'warning');
		}
	});

	return false;
}

function openfj2() {
	var doc = $('#dg').datagrid('getSelected');// 得到选中的一行数据
	params = "id=" + doc.id;
	var openfj2 = basePath + '/system/XzxzgzbAction_openfj2.action';

	$.post(openfj2, params, function(result) {
		if (result.operateSuccess) {
			$.messager.alert('打开', '打开成功！', 'info');

		} else {
			$.messager.alert('打开', '格式不正确或不存在此文件！', 'warning');
		}
	});

	return false;
}
