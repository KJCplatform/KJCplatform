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
var LODOP;//声明为全局变量
$(function() {
	listDoc();
	/*
	 * // 日期加上日期控件 $("#fwrq").datebox({ editable:false, required : true });
	 * $("#jzrq").datebox({ editable:false, required : true });
	 */
	// 给文本框加上验证器
	$("#dwmc").validatebox({
		required : true,
		missingMessage : '单位名称不能为空'
	});
	$("#dwdh").validatebox({
		required : true,
		missingMessage : '单位代号不能为空'
	});
	/*
	 * $("#jbnr").validatebox({ required : true });
	 */
});
// 加载公文列表
function listDoc() {

	var actionPath = basePath + '/system/Wqwqxkzxq0Action_list.action';

	$('#dg').datagrid({
		title : '武器装备生产许可单位信息汇总',
		width : 3600,
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
		sortName : 'id',// 当数据表格初始化时以哪一列来排序
		sortOrder : 'desc',// 定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
		pagination : true,// 分页
		rownumbers : true
	// 行数

	});
}
// 查询
function doSearch() {
	$('#dg').datagrid('load', {
		dwmc : $('#fileName').val(),
		dwdh : $('#fileId').val()
	});
}
// 显示编辑窗口
function showEditForm() {
	$("#tabEdit").dialog({
		modal : true,// 模式窗口
		title : '武器装备生产许可单位信息汇总',
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
	if (doc == null) {
		$.messager.alert('文件', '请先选中要编辑的文件', 'info');
		return;
	}
	$('#frmEdit').form('clear');
	// 填充数据
	$("#id").val(doc.id);
	$("#dwmc").val(doc.dwmc);
	$("#qtmc").val(doc.qtmc);
	$("#dwdh").val(doc.dwdh);
	$("#scdz").val(doc.scdz);
	$("#jjxz").val(doc.jjxz);
	$("#frdb").val(doc.frdb);
	$("#dwdz").val(doc.dwdz);
	$("#yzbm").val(doc.yzbm);
	$("#lxr").val(doc.lxr);
	$("#lxdh").val(doc.lxdh);
	$("#zgzs").val(doc.zgzs);
	$("#gzgl").val(doc.gzgl);
	$("#zzgl").val(doc.zzgl);
	$("#czgl").val(doc.czgl);
	$("#gzjs").val(doc.gzjs);
	$("#zzjs").val(doc.zzjs);
	$("#czjs").val(doc.czjs);
	$("#gzgr").val(doc.gzgr);
	$("#zzgr").val(doc.zzgr);
	$("#czgr").val(doc.czgr);
	$("#gjjcgs").val(doc.gjjcgs);
	$("#sbjcgs").val(doc.sbjcgs);

	$("#jbqk").val(doc.jbqk);
	$("#kyfx").val(doc.kyfx);
	$("#qyscgl").val(doc.qyscgl);
	$("#kyzk").val(doc.kyzk);
	$("#zlglzk").val(doc.zlglzk);

	$("#bmaqzk").val(doc.bmaqzk);

	$("#jpyfqk").val(doc.jpyfqk);
	$("#jpjcqk").val(doc.jpjcqk);
	$("#jpzzqk").val(doc.jpzzqk);
	$("#wcjpqk").val(doc.wcjpqk);
	$("#xcjpxmqk").val(doc.xcjpxmqk);

	$("#jlnf").val(doc.jlnf);
	$("#username").val(doc.username);
	$("#gxsj").val(doc.gxsj);
	$("#submit").val(doc.submit);

	$("#name1").val(doc.name1);
	$("#name2").val(doc.name2);

	// 显示编辑页面
	showEditForm();
}
function dealSave() {
	// 表单数据序列化成一个字符串用&拼接
	var params = $("#frmEdit").serialize();
	var actionAdd = basePath + '/system/Wqwqxkzxq0Action_add.action';
	var actionUpdate = basePath + '/system/Wqwqxkzxq0Action_update.action';
	// 得到doc的值，为空串表示添加的值，为空串表示添加
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
					+ '/system/Wqwqxkzxq0Action_delete.action?id=';
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


function print2(){
	//得到LODOP对象，注意head标签里面需引入object和embed标签
	LODOP=getLodop(document.getElementById('LODOP'),document.getElementById('LODOP_EM'));
	//封装我们的html元素
	var strBodyStyle="<style>table,td{border:1solid#000000;border-collapse:collapse}</style>";
	//获得id为content标签里面的html元素
	if(document.getElementById("content")!=null)
	var strFormHtml=strBodyStyle+"<body>"+document.getElementById("content").innerHTML+"</body>";
	//打印初始化，页面距离顶部10px，距离左边10px，宽754px，高453px，给打印设置个标题
	LODOP.PRINT_INITA(10,10,754,453,"打印控件操作");
	//设置打印页面属性：2：表示横向打印，0：定义纸张宽度，为0表示无效设置，A4：设置纸张为A4
	LODOP.SET_PRINT_PAGESIZE(2,0,0,"A4");
	//设置文本，参数(距离页面头部，距离页面左边距离，文本宽度，文本高度，文本内容)
	LODOP.ADD_PRINT_TEXT(21,300,300,30,"${unitType}${flowval}检修记录n");
	//给所添加的文本定义样式,0：表示新添加的元素，相应的属性，相应的值
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.SET_PRINT_STYLEA(0,"ItemType",1);//固定标题,设置卫页眉页脚
	LODOP.SET_PRINT_STYLEA(0,"Horient",2);
	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
	//同上
	LODOP.ADD_PRINT_TEXT(40,60,350,30,"机车号:${datePlan.jcType}${datePlan.jcnum}修程:${datePlan.fixFreque}检修日期:${datePlan.kcsj}");
	LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
	//添加html元素
	LODOP.ADD_PRINT_HTM(63,38,684,330,strFormHtml);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.SET_PRINT_STYLEA(0,"ItemType",4);
	LODOP.SET_PRINT_STYLEA(0,"Horient",3);
	LODOP.SET_PRINT_STYLEA(0,"Vorient",3);
	//添加一条线，参数(开始短点距离头部距离，开始端点距左边距离，结束端点距头部距离，结束端点距左边距离)
	LODOP.ADD_PRINT_LINE(53,23,52,725,0,1);
	LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
	LODOP.SET_PRINT_STYLEA(0,"Horient",3);
	LODOP.ADD_PRINT_LINE(414,23,413,725,0,1);
	LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
	LODOP.SET_PRINT_STYLEA(0,"Horient",3);
	LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
	//LODOP.ADD_PRINT_TEXT(421,37,144,22,"左下脚的文本小标题");
	//LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
	LODOP.ADD_PRINT_TEXT(421,542,165,22,"第#页/共&页");
	LODOP.SET_PRINT_STYLEA(0,"ItemType",2);
	LODOP.SET_PRINT_STYLEA(0,"Horient",1);
	LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
	LODOP.PRINT();//打印
}


function print1() {
	//var strBodyStyle="<style>table,td{border:1solid#000000;border-collapse:collapse}</style>";
	//获得id为content标签里面的html元素
    //if(document.getElementByTagName("html")!=null)
	//var strFormHtml=strBodyStyle+"<body>"+document.getElementByTagName("html").innerHTML+"</body>";
	var strHTML = document.getElementsByTagName("html")[0].innerHTML;
	// var strHTML1=document.getElementsById("html")[0].innerHTML;
	LODOP.PRINT_INITA(1, 1, 770, 660, "");
	//设置打印页面属性：2：表示横向打印，0：定义纸张宽度，为0表示无效设置，A4：设置纸张为A4
	LODOP.SET_PRINT_PAGESIZE(1,0,0,"A4");
	//设置文本，参数(距离页面头部，距离页面左边距离，文本宽度，文本高度，文本内容)
	LODOP.ADD_PRINT_TEXT(21,300,300,30,"${unitType}${flowval}");
	//给所添加的文本定义样式,0：表示新添加的元素，相应的属性，相应的值
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.SET_PRINT_STYLEA(0,"ItemType",1);//固定标题,设置卫页眉页脚
	LODOP.SET_PRINT_STYLEA(0,"Horient",2);
	LODOP.SET_PRINT_STYLEA(0,"Bold",1);
	
	LODOP.ADD_PRINT_TEXT(10, 60, 300, 200, "打印:");
	LODOP.ADD_PRINT_HTM(30, 5, "100%", "80%", strHTML);
	LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
	LODOP.SET_PRINT_STYLEA(0,"ItemType",4);
	LODOP.SET_PRINT_STYLEA(0,"Horient",3);
	LODOP.SET_PRINT_STYLEA(0,"Vorient",3);
	//添加一条线，参数(开始短点距离头部距离，开始端点距左边距离，结束端点距头部距离，结束端点距左边距离)
	LODOP.ADD_PRINT_LINE(53,23,52,725,0,1);
	LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
	LODOP.SET_PRINT_STYLEA(0,"Horient",3);
	LODOP.ADD_PRINT_LINE(414,23,413,725,0,1);
	LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
	LODOP.SET_PRINT_STYLEA(0,"Horient",3);
	LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
	//LODOP.ADD_PRINT_TEXT(421,37,144,22,"左下脚的文本小标题");
	//LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
	LODOP.ADD_PRINT_TEXT(421,542,165,22,"第#页/共&页");
	LODOP.SET_PRINT_STYLEA(0,"ItemType",2);
	LODOP.SET_PRINT_STYLEA(0,"Horient",1);
	LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
	// LODOP.ADD_PRINT_HTM(30,5,"100%","80%",strHTML1);
	LODOP.SET_PREVIEW_WINDOW(2, 3, 0, 0, 80, "");
	LODOP.PREVIEW();

}

function exportExcel() {
	var strBodyStyle="<style>table,td{border:1solid#000000;border-collapse:collapse}</style>";
	//获得id为content标签里面的html元素

	var strFormHtml=strBodyStyle+"<body>"+document.getElementByTagName("html")[0].innerHTML+"</body>";
//	var strHTML = document.getElementsByTagName("html")[0].innerHTML;
	LODOP.PRINT_INIT("");
	LODOP.ADD_PRINT_TABLE(5, 5, "99%", "100%", strHTML);
	LODOP.SAVE_TO_FILE("test.xls");

}

function preview(){
CreatePrintPage();
//打印预览
LODOP.PREVIEW();
}
 
function setup(){
CreatePrintPage();
//LODOP.PRINT_SETUP();
LODOP.PRINT_DESIGN();//打印设置
}
 
function print(){
CreatePrintPage();
//打印LODOP.PRINT();
//打印预览
LODOP.PREVIEW();
}
 
//初始化页面
function CreatePrintPage(){
//得到LODOP对象，注意head标签里面需引入object和embed标签
//LODOP=getLodop(document.getElementById('LODOP'),document.getElementById('LODOP_EM'));
//封装我们的html元素
console.log(LODOP);
var strBodyStyle="<style>table,td{border:1solid#000000;border-collapse:collapse}</style>";
//获得id为content标签里面的html元素
if(document.getElementById("dg")!=null)
var strFormHtml=strBodyStyle+"<body>"+document.getElementById("dg").innerHTML+"</body>";
//打印初始化，页面距离顶部10px，距离左边10px，宽754px，高453px，给打印设置个标题
LODOP.PRINT_INITA(10,10,754,453,"打印控件操作");
//设置打印页面属性：2：表示横向打印，0：定义纸张宽度，为0表示无效设置，A4：设置纸张为A4
LODOP.SET_PRINT_PAGESIZE(2,0,0,"A4");
//设置文本，参数(距离页面头部，距离页面左边距离，文本宽度，文本高度，文本内容)
LODOP.ADD_PRINT_TEXT(21,300,300,30,"");
//给所添加的文本定义样式,0：表示新添加的元素，相应的属性，相应的值
LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
LODOP.SET_PRINT_STYLEA(0,"ItemType",1);//固定标题,设置卫页眉页脚
LODOP.SET_PRINT_STYLEA(0,"Horient",2);
LODOP.SET_PRINT_STYLEA(0,"Bold",1);
//同上
LODOP.ADD_PRINT_TEXT(40,60,350,30,"");
LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
//添加html元素
LODOP.ADD_PRINT_HTM(63,38,684,330,strFormHtml);
LODOP.SET_PRINT_STYLEA(0,"FontSize",15);
LODOP.SET_PRINT_STYLEA(0,"ItemType",4);
LODOP.SET_PRINT_STYLEA(0,"Horient",3);
LODOP.SET_PRINT_STYLEA(0,"Vorient",3);
//添加一条线，参数(开始短点距离头部距离，开始端点距左边距离，结束端点距头部距离，结束端点距左边距离)
LODOP.ADD_PRINT_LINE(53,23,52,725,0,1);
LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
LODOP.SET_PRINT_STYLEA(0,"Horient",3);
LODOP.ADD_PRINT_LINE(414,23,413,725,0,1);
LODOP.SET_PRINT_STYLEA(0,"ItemType",1);
LODOP.SET_PRINT_STYLEA(0,"Horient",3);
LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
//LODOP.ADD_PRINT_TEXT(421,37,144,22,"左下脚的文本小标题");
//LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
LODOP.ADD_PRINT_TEXT(421,542,165,22,"第#页/共&页");
LODOP.SET_PRINT_STYLEA(0,"ItemType",2);
LODOP.SET_PRINT_STYLEA(0,"Horient",1);
LODOP.SET_PRINT_STYLEA(0,"Vorient",1);
}
