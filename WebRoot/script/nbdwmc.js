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
var user;

$(function() {
	listDoc();
	/*// 日期加上日期控件
	$("#qyrq").datebox({
		editable:false,
		required : true
	});
	// 给文本框加上验证器
	$("#qymc").validatebox({
		required : true,
		missingMessage : '企业名称不能为空'
	});
	$("#qylx").validatebox({
		required : true,
		missingMessage : '融资额度不能为空'
	});*/
	$("#sfsb").validatebox({
		required : true,
		missingMessage : '是否上报不能为空'
	});
	$("#jinyong").validatebox({
		required : true,
		missingMessage : '是否禁用不能为空'
	});
});
//加载公文列表
function listDoc() {
	var actionPath = basePath + '/system/NbdwmcAction_list.action';
	 $('#dg').datagrid({
            title : '国防科技工业单位册',
            //width : 1200,
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
				text : '添加',
				id:'add',
				iconCls : 'icon-add', // 图标
				handler : function() { // 处理函数
					addDoc();
				}
			}, {
				text : '删除',
				id:'delete',
				iconCls : 'icon-cancel', // 图标
				handler : function() { // 处理函数
					deleteDoc();
				}
			}, {
				text : '编辑',
				id:'edit',
				iconCls : 'icon-edit',// 图标
				handler : function() {// 处理函数
					editDoc();
				}
			}
		 ],
	 
            onLoadSuccess: function (data) { 
            	
				user=eval(data).user;
			//	 alert(user); 
				 if(user!="admin"){
					
					 $("#delete").linkbutton("disable");
					 $("#edit").linkbutton("disable");
				 }
			}
        });
}
//查询
function doSearch(){
	$('#dg').datagrid('load',{
		dwmc: $('#fileName').val(),
		dwdz: $('#fileId').val()
	});
}
// 显示编辑窗口
function showEditForm() {
	$("#tabEdit").dialog({
		modal : true,// 模式窗口
		title : '国防科技工业单位册',
		iconCls : 'icon-save',
		width :  '55%',
	       height:  '100%',
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
function closeForm2() {
	//$("#frmEdit2").form('clear');
	$('#tabEdit2').dialog('close');
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
	$("#dwdz").val(doc.dwdz);
	$("#yzbm").val(doc.yzbm);
	$("#qh").val(doc.qh);
	$("#zbdh").val(doc.zbdh);
	$("#czhm").val(doc.czhm);
	$("#lxr").val(doc.lxr);
	$("#zw").val(doc.zw);
	$("#sfsb").val(doc.sfsb);
	$("#jinyong").val(doc.jinyong);
	
	// 显示编辑页面
	showEditForm();
}
function dealSave() {
	// 表单数据序列化成一个字符串用&拼接
	var params = $("#frmEdit").serialize();
	var actionAdd = basePath + '/system/NbdwmcAction_add.action';
	var actionUpdate = basePath + '/system/NbdwmcAction_update.action';
	// 得到doc的值，为空串表示添加的值，为空串表示添加
	if ($("#id").val() == "") {
		$.post(actionAdd, params, function(result) {
			if (result.operateSuccess) {
					//alert(result);
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
			var actionPath = basePath + '/system/AaaAction_delete.action?id=';
			var url = actionPath + doc.id;
			// 试一下get方法（地址，回调函数）
			$.get(url, function(result) {
				//alert(result);
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














function ShowImport(){
	
//	  var file_upl = document.getElementById('uploadExcel');
//	  file_upl.select();
//	  var fileName = document.selection.createRange().text;
//	alert(fileName);
	
	  //得到上传文件的全路径  
	  var fileName= $('#uploadExcel').filebox('getValue');  
//	
	  
	 // alert(fileName);
	          //进行基本校验  
	          if(fileName==""){
	             $.messager.alert('提示','请选择上传文件！','info');   
	          }else{
	              //对文件格式进行校验  
	              var d1=/\.[^\.]+$/.exec(fileName);   
	              if(d1==".xls"){  
	                   //提交表单  
	                   //document.getElementById("questionTypesManage").action="${pageContext.request.contextPath}/leadtoQuestionTypes/leadInExcelQuestionBank?questionType="+questionTypes+"&courseType="+courseType;  
	            	//document.getElementById("questionTypesManage").submit();     
	            		var params ="yqbh="+fileName;
	            		var showimport = basePath + '/system/AaaAction_showimport.action';

	            		//alert(params);
	            		
	          		$.post(showimport, params, function(result) {
	        			if (result.operateSuccess) {
	        					$('#dg').datagrid('reload');// 重新加载
	        					$.messager.alert('导入', '导入Excel成功', 'info');
	        				
	        			}else {
	        					$.messager.alert('导入', '导入Excel失败', 'warning');
	        				}
	        		});
	          		
	            	  
	            	  return false;
	             }else{  
	                 $.messager.alert('提示','请选择xls格式文件！','info');   
	                 $('#uploadExcel').filebox('setValue','');
	             }
	          } 
	   }



function ShowExport(){
	  
	var Items = document.getElementsByName("Items"); 
	var params ="yqbh=";
	
  for(var i = 0; i < Items.length; i++) 
  { 
     if(Items[i].checked == true) 
     { 
  	   params+=Items[i].value+" "; 
     } 
  } 

	//alert(params);

	var showimport = basePath + '/system/AaaAction_showexport.action';
	            				
	$.post(showimport, params, function(result) {
	        			if (result.operateSuccess) {
	        					$('#dg').datagrid('reload');// 重新加载
	        					$.messager.alert('导出', '导出Excel成功', 'info');
	        				
	        			}else {
	        					$.messager.alert('导出', '文件被占用！导出Excel失败', 'warning');
	        				}
	        		});

	            	  return false;
	   }



//Excelselect
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











	