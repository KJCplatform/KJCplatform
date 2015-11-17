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
//	alert("123");
//	excelSubmit();
//	alert("123");
//	readExcel();
//	alert("456");
	listDoc();
	// 日期加上日期控件
	
//	$("#txdz").validatebox({
//		required : true
//	});
	// 给文本框加上验证器
//	$("#frmc").filebox({
//		required : true,
//		missingMessage : '法人单位名称不能为空'
//	});
	$("#frmc").validatebox({
		required : true,
		missingMessage : '法人单位名称不能为空'
	});
	
	$("#jlzy").validatebox({
		required : true,
		missingMessage : '计量专业不能为空'
	});
//	$("#bgdh").numberbox({
//		//required : true,
//	});
//	$("#sj").numberbox({
//		maxlength:11        //?
//		//required : true,
//	});
//	$("#qjsl").numberbox({
//		//required : true
//	});
	
//	$("#lxr").validatebox({
//		required : true
//	});
});


//加载公文列表
function listDoc() {
	var actionPath = basePath + '/system/KjsjjljgxxbAction_list.action';
	 $('#dg').datagrid({
            title : '国防三级计量技术机构',
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

//查询
function doSearch(){
	$('#dg').datagrid('load',{
		frmc: $('#fileName').val(),
		jlzy: $('#fileId').val()
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
	$("#frmc").val(doc.frmc);
	$("#jlzy").val(doc.jlzy);
	$("#qjsl").val(doc.qjsl);	
	$("#txdz").val(doc.txdz);
	$("#lxr").val(doc.lxr);
	$("#bgdh").val(doc.bgdh);
	$("#sj").val(doc.sj);	
	// 给默认值
//	//$("#fwrq").datebox("setValue", doc.fwrq.substring(0, 10));
//	$("#fwrq").datebox("getValue");
//	$("#jbnr").val(doc.jbnr);
//	//alert($("#jzrq").datebox("getValue"));
//	$("#jzrq").datebox("getValue");
//	$("#jbr").val(doc.jbr);
//	$("#cljg").val(doc.cljg);
	// 显示编辑页面
	showEditForm();
}
function dealSave() {
	// 表单数据序列化成一个字符串用&拼接
	var params = $("#frmEdit").serialize();
	
	var actionAdd = basePath + '/system/KjsjjljgxxbAction_add.action';
	var actionUpdate = basePath + '/system/KjsjjljgxxbAction_update.action';
	// 得到doc的值，为空串表示添加的值，为空串表示添加
	if ($("#id").val() == "") {
		
	//	$.messager.alert('test1', result, 'warning');
		
		$.post(actionAdd, params, function(result) {
			if (result.operateSuccess) {
					$('#dg').datagrid('reload');// 重新加载
					$.messager.alert('添加', '添加成功', 'info');
					//alert(params);
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
			var actionPath = basePath + '/system/KjsjjljgxxbAction_delete.action?id=';
			var url = actionPath + doc.id;
			// 试一下get方法（地址，回调函数）
			$.get(url, function(result) {
				alert(result);
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


//ReadExcel
//function readExcel(){
//	var excelApp;
//	var excelWorkBook;
//	var excelSheet;
//	try{
//		excelApp=new ActiveXObject("Excel.Application");
//		excelWorkBook=excelApp.Workbooks.open("D:\\hhs.xls");
//		excelSheet=oWB.ActiveSheet;
//		excelSheet.Cells(6,2).value;//cell值
//		excelSheet.usedrange.rows.count;//使用的行数
//		excelWorkBook.Worksheets.count;//得到sheet的个数
//		excelSheet=null;
//		excelWorkBook.close();
//		excelApp.Application.Quit();
//		excelApp=null;
//		
//		
//	}catch(e){   
//		alert("error!");
//		if(excelSheet !=null || excelSheet!=undefined){  excelSheet =nul;  }   
//		if(excelWorkBook != null || excelWorkBook!=undefined){  excelWorkBook.close();  }   
//		if(excelApp != null || excelApp!=undefined){  excelApp.Application.Quit();  excelApp=null;  }  }
//}
//
//
//
//
//

//function excelSubmit() {
//	$("#uploadimg-form").resetForm().validate({
//		 rules: {
//		"fileUpload": {
//		 required: true,
//		 accept:"xls"
//		}
//		},
//		 messages: {
//		"fileUpload": {
//		 required:"请选择上传文件",
//		 accept:"文件格式不支持，请上传 xls 格式的文件"
//		}
//		},
//		 submitHandler: function() {
//		$("#uploadimg-form").ajaxSubmit({
//		//url:"ajax.jsp?m=uploadExcel",
//	   
//		type:"post",
//		enctype:"multipart/form-data",
//		 contentType:"application/x-www-form-urlencoded; charset=utf-8",
//		dataType:"json",
//		 success: function(data){
//		 var str ="";
//		 for (var i=0, len=data.length; i < len; i++) {
//		 str +="<p>";
//		 str += data[i]["deparement"] +","+ data[i]["name"] +","+ data[i]["date"];
//		 str +="</p>";
//		}
//		$("#jsonShow").append(str);
//		$("#showData").removeAttr("style");
//		$("#jsonBtn").removeAttr("disabled").removeAttr("title");
//		},
//		 error: function() {
//		alert('error');
//		}
//		});
//		 return false;
//		}
//		});
//
//}
//
//function Exproter() {
//	alert("导出");
//	
//    //获取Datagride的列  
//    var rows = $('#dg').datagrid('getRows');  
//	alert("1");
//    var oXL = new ActiveXObject("Excel.Application"); //创建AX对象excel 
//    alert("2");
//    var oWB = oXL.Workbooks.Add(); //获取workbook对象   
//    alert("3");
//    var oSheet = oWB.ActiveSheet; //激活当前sheet  
//    alert("4");
//    for (var i = 0; i < rows.length; i++) {  
//        oSheet.Cells(i + 1, 1).value = rows[i].O_NAME;  
//    }  
//    alert("5");
//    oXL.Visible = true; //设置excel可见属性  
//	alert(oSheet);
//}



////导入excel  
//function uploadExcel(){     
//  //得到上传文件的全路径  
//  var fileName= $('#uploadExcel').filebox('getValue');  
//       //获取题型  
//  var id= $('#questionType').combobox('getValue');   
//  var questionTypes=encodeURI(id);    
//    
//   if(questionTypes !=""){   
//          //进行基本校验  
//          if(fileName==""){     
//             $.messager.alert('提示','请选择上传文件！','info');   
//          }else{  
//              //对文件格式进行校验  
//              var d1=/\.[^\.]+$/.exec(fileName);   
//              if(d1==".xls"){  
//                   //获取题型     
//                   var id= $('#questionType').combobox('getValue')  
//                   var questionTypes=encodeURI(id);  
//                      
//                   //获取课程  
//                   var courseTypeId =$('#courseTypeId').combobox('getValue')  
//                   var courseType=encodeURI(courseTypeId);  
//                     
//                   //提交表单  
//                   document.getElementById("questionTypesManage").action="${pageContext.request.contextPath}/leadtoQuestionTypes/leadInExcelQuestionBank?questionType="+questionTypes+"&courseType="+courseType;  
//                   document.getElementById("questionTypesManage").submit();     
//                   $.messager.alert('提示','操作成功！','info');          
//             }else{  
//                 $.messager.alert('提示','请选择xls格式文件！','info');   
//                 $('#uploadExcel').filebox('setValue','');   
//             }  
//          }    
//   }else{    
//       $.messager.alert('提示','请选择课程题型！','info');   
//   }
//
//}  












//function ShowImport(){
//	$.showWindow({
//		title:'客户联系人-Excel数据导入',
//		useiframe:true,
//		width:1024,
//		height:700,
//		content:'url:/contact/Import',
//		buttons:[{
//			text:'取消',
//			iconCls:'icon-cancel',
//			handler:function(win){
//				win.close();
//			}
//		}]
//		
//	});
//}




//导入excel  
//function ShowImport(){
//  //得到上传文件的全路径  
//
//  var fileName= $('#uploadExcel').filebox('getValue');  
//       
////  var id=1;   
//  //var questionTypes=encodeURI(id);    
//    
////   if(questionTypes !=""){   
//          //进行基本校验  
//          if(fileName==""){
//             $.messager.alert('提示','请选择上传文件！','info');   
//          }else{
//              //对文件格式进行校验  
//              var d1=/\.[^\.]+$/.exec(fileName);   
//              if(d1==".xls"){  
//                     
//                   //提交表单  
//                   //document.getElementById("questionTypesManage").action="${pageContext.request.contextPath}/leadtoQuestionTypes/leadInExcelQuestionBank?questionType="+questionTypes+"&courseType="+courseType;  
//                   
//                  // document.getElementById("questionTypesManage").action="basePath + '/system/KjsjjljgxxbAction_hhs";
//              
//            	document.getElementById("questionTypesManage").submit();     
//
//				//$.messager.alert('添加', '添加成功', 'info');
//				
//				return false;
//				
//	
//             }else{  
//                 $.messager.alert('提示','请选择xls格式文件！','info');   
//                 $('#uploadExcel').filebox('setValue','');
//             }
//          } 
//   }



//else{
//       $.messager.alert('提示','请选择课程题型！','info');   
//   }
//}  

//function ShowExport(){
//	
//
//	 $('#dg').submit();     
//	 alert("导出成功！");
//	   }





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
	            		var params ="frmc="+fileName;
	            		var showimport = basePath + '/system/KjsjjljgxxbAction_showimport.action';

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
	  
	var params ="frmc="+$('#uploadExcel').filebox('getValue');
	  

	var showimport = basePath + '/system/KjsjjljgxxbAction_showexport.action';
	            				
	$.post(showimport, params, function(result) {
	        			if (result.operateSuccess) {
	        					$('#dg').datagrid('reload');// 重新加载
	        					$.messager.alert('导出', '导出Excel成功', 'info');
	        				
	        			}else {
	        					$.messager.alert('导出', '导出Excel失败', 'warning');
	        				}
	        		});
  
	            	  return false;
	   }




//function test(){
//	
////	var file_upl = document.getElementById('file_upl');
////	file_upl.select();
////	alert(file_upl);
////	var realpath = document.selection.createRange().text;
////	alert(realpath);
//	
//	 file_url = document.getElementById("file_upl").value;
//	 alert(file_url);
//}