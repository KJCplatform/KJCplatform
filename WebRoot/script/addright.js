//JQuery的入口
//获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
var curWwwPath = window.document.location.href;
//获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8080
var localhostPath = curWwwPath.substring(0, pos);
//获取带"/"的项目名，如：/ems
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
var basePath = localhostPath + projectName;

$(function() {
	listDoc();
	// 日期加上日期控件
	$("#fwrq").datebox({
		editable:false,
		required : true
	});
	$("#jzrq").datebox({
		editable:false,
		required : true
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

	
	
	
//	$('#userid').combotree({
//	   // url: basePath + '/project/area.json'
//		url:basePath + '/system/AddrightAction_list.action',
//		
	
			
			
		
		
		
	  //  valueField:'userid',
	  //  textField:'rightid'
		
	});   
	
//	$('#cc').combobox({
//	    url:'combobox_data.json',
//	    valueField:'id',
//	    textField:'text'
//	});  
	

	

//加载公文列表
function listDoc() {
	var actionPath = basePath + '/system/AddrightAction_list.action';
	 $('#dg').datagrid({
            title : '用户权限管理',
            width : 1200,
            height: 400,
            //fit: true,
			fitColumns : true, // 自动适应列宽      
            pageSize : 10,//默认选择的分页是每页5行数据
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
				text : '添加用户权限',
				iconCls : 'icon-add', // 图标
				handler : function() { // 处理函数
					addDoc();
				}
			}, {
				text : '删除用户权限',
				iconCls : 'icon-cancel', // 图标
				handler : function() { // 处理函数
					deleteDoc();
				}
			}
//			, {
//				text : '编辑用户权限',
//				iconCls : 'icon-edit',// 图标
//				handler : function() {// 处理函数
//					editDoc();
//				}
//			} 
			]
        });
	 
	 
//	 
//	 alert("1235");
//
//	 $.getJSON(actionPath, function(json) {
//	 $('#userid').combobox({
//	 data : json.rows,
//	 valueField:'id',
//	 textField:'userid'
//	 });
//	 });
//	 
	 
}


function loadcombotree() {
//	alert("1235");
//
//	var testurl = basePath + '/system/AddrightAction_list.action';
//$.getJSON(testurl, function(json) {
//$('#userid').combobox({
//data : json.rows,
//valueField:'id',
//textField:'userid'
//});
//});

	var testurl = basePath + '/system/AdduserAction_test.action';
	//var testurl = basePath + '/system/KjsjjljgxxbAction_showexport.action';
	
	$.post(testurl, null, function(json) {

		$.getJSON(testurl, function(json) {
		$('#userid').combobox({
		data : json.rows,
		valueField:'id',
		textField:'name'
		});
		});
		
});
	
	
}



//查询
function doSearch(){
	$('#dg').datagrid('load',{
		userid: $('#rightname').val(),
		
	});
}
// 显示编辑窗口
function showEditForm() {
	$("#tabEdit").dialog({
		modal : true,// 模式窗口
		title : '添加用户权限',
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
	loadcombotree();
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
	$("#userid").val(doc.userid);
	$("#rightid").val(doc.rightid);
	$("#id").val(doc.id);

	
	// 显示编辑页面
	showEditForm();
}
function dealSave() {

	var Items = document.getElementsByName("rightid"); 
	var params ="rightid=";
	
    for(var i = 0; i < Items.length; i++) 
    { 
       if(Items[i].checked == true) 
       { 
    	   params+=Items[i].value+" "; 
       } 
    } 
    params+="&userid="+$('#userid').combobox('getValue');
    
	//alert(params);

	var showimport =  basePath + '/system/AddrightAction_add.action';
	            				
	$.post(showimport, params, function(result) {
	        			if (result.operateSuccess) {
	        					$('#dg').datagrid('reload');// 重新加载
	        					$.messager.alert('添加', '添加用户权限成功', 'info');
	        				
	        			}else {
	        					$.messager.alert('添加', '部分用户权限已经添加，请不要重复添加！', 'warning');
	        				}
	        		});
  
	            	  return false;
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
				$('#dg').datagrid('reload');	// reload the right data
			} else {
				$.messager.show({
					title: 'Error',
					msg: result.msg
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
			var actionPath = basePath + '/system/AddrightAction_delete.action?id=';
			var url = actionPath + doc.id;
			// 试一下get方法（地址，回调函数）
			$.get(url, function(result) {
			//	alert(result);
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











	