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
	/*
	 * $("#fwrq").datebox({ required : true }); $("#jzrq").datebox({ required :
	 * true });
	 */
	// 给文本框加上验证器
	$("#xm").validatebox({
		required : true,
		missingMessage : '姓名不能为空'
	});
	$("#gzdw").validatebox({
		required : true,
		missingMessage : '工作单位不能为空'
	});
	/*
	 * $("#jbnr").validatebox({ required : true });
	 */
});
// 加载公文列表
function listDoc() {
	var actionPath = basePath + '/system/Kjjszjcjb1Action_list.action';
	$('#dg').datagrid({
		title : '专家库',
		width : 1500,
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
		sortName : 'sfzh',// 当数据表格初始化时以哪一列来排序
		sortOrder : 'desc',// 定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
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
			// alert(user);
			user = eval(data).user;

			if (user != "admin") {
				// alert("123");
				$("#delete").linkbutton("disable");
				$("#edit").linkbutton("disable");
			}
		}
	});
}
// 查询
function doSearch() {
	var test = $('#select option:selected').val();
	var test1 = $('#select1 option:selected').val();
	if (test == 0) {
		if (test1 == 0)
			$('#dg').datagrid('load', {});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 1) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			xm:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				xm:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 2) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			xb:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				xb:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 3) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			gzdw:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				gzdw:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 4) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			gzbm:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				gzbm:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	
	if (test == 5) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			zw:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				zw:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 6) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			jszc:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				jszc:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 7) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			sszy:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				sszy:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 8) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			yjfx:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				yjfx:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 9) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			sj:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				sj:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 10) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			dh:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				dh:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 11) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			yx:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				yx:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 12) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			sfzh:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				sfzh:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 13) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			bz:$('#fileName').val()
	});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				bz:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
	
	
	if (test == 14) {
		if (test1 == 0)
			$('#dg').datagrid('load', {
			lb:$('#fileName').val()
			});
		if (test1 == 1)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				xm : $('#fileId').val()
			});
		if (test1 == 2)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				xb : $('#fileId').val()
			});
		if (test1 == 3)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				gzdw : $('#fileId').val()
			});
		if (test1 == 4)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				gzbm : $('#fileId').val()
			});
		if (test1 == 5)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				zw : $('#fileId').val()
			});
		if (test1 == 6)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				jszc : $('#fileId').val()
			});
		if (test1 == 7)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				sszy : $('#fileId').val()
			});
		if (test1 == 8)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				yjfx : $('#fileId').val()
			});
		if (test1 == 9)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				sj : $('#fileId').val()
			});
		if (test1 == 10)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				dh : $('#fileId').val()
			});
		if (test1 == 11)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				yx : $('#fileId').val()
			});
		if (test1 == 12)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				sfzh : $('#fileId').val()
			});
		if (test1 == 13)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				bz : $('#fileId').val()
			});
		if (test1 == 14)
			$('#dg').datagrid('load', {
				lb:$('#fileName').val(),
				lb : $('#fileId').val()
			});
	}
	;
}
// 显示编辑窗口
function showEditForm() {
	$("#tabEdit").dialog({
		modal : true,// 模式窗口
		title : '专家库',
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
	$("#xm").val(doc.xm);
	$("#gzdw").val(doc.gzdw);
	$("#xb").val(doc.xb);
	// 给默认值
	// $("#fwrq").datebox("setValue", doc.fwrq.substring(0, 10));
	// $("#fwrq").datebox("getValue");
	$("#gzbm").val(doc.gzbm);
	// alert($("#jzrq").datebox("getValue"));
	// $("#jzrq").datebox("getValue");
	$("#zw").val(doc.zw);

	$("#jszc").val(doc.jszc);
	$("#sszy").val(doc.sszy);
	$("#yjfx").val(doc.yjfx);
	$("#sj").val(doc.sj);
	$("#dh").val(doc.dh);
	$("#yx").val(doc.yx);
	$("#sfzh").val(doc.sfzh);
	$("#bz").val(doc.bz);
	$("#lb").val(doc.lb);

	/*
	 * $("#jlnf").val(doc.jlnf); $("#username").val(doc.username);
	 * $("#gxsj").val(doc.gxsj); $("#submit").val(doc.submit);
	 */
	// 显示编辑页面
	showEditForm();
}
function dealSave() {
	// 表单数据序列化成一个字符串用&拼接
	var params = $("#frmEdit").serialize();
	var actionAdd = basePath + '/system/Kjjszjcjb1Action_add.action';
	var actionUpdate = basePath + '/system/Kjjszjcjb1Action_update.action';
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
					+ '/system/Kjjszjcjb1Action_delete.action?id=';
			var url = actionPath + doc.id;
			// 试一下get方法（地址，回调函数）
			$.get(url, function(result) {
				// alert(result);
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
			var params = "xm=" + fileName;
			var showimport = basePath
					+ '/system/Kjjszjcjb1Action_showimport.action';

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
	var params = "xm=";

	for (var i = 0; i < Items.length; i++) {
		if (Items[i].checked == true) {
			params += Items[i].value + " ";
		}
	}

	// alert(params);

	var showimport = basePath + '/system/Kjjszjcjb1Action_showexport.action';

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

function closeForm2() {
	// $("#frmEdit2").form('clear');
	$('#tabEdit2').dialog('close');
}
