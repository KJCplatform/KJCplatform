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

});
//加载公文列表
function listDoc() {
	var actionPath = basePath + '/system/Action_list.action';
	 $('#dg').datagrid({
            title : '综合查询',
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
			
			/*toolbar:[ {// 工具栏
				text : '综合查询',
				iconCls : 'icon-add', // 图标
				handler : function() { // 处理函数
					addDoc();
				}
			}]*/
        });
}
//查询
function doSearch(){
	$('#dg').datagrid('load',{
		name: $('#username').val(),
		
	});
}
// 显示编辑窗口
/*function showEditForm() {
	$("#tabEdit").dialog({
		modal : true,// 模式窗口
		title : '综合查询',
		iconCls : 'icon-save',
		
	});
}
*/
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
	$("#sjbf").val(doc.sjbf);
	$("#sjhy").val(doc.sjhy);
	$("#id").val(doc.id);

	
	// 显示编辑页面
	showEditForm();
}
