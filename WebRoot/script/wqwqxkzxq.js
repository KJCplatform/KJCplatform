//JQuery的入口
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var localhostPath = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
var basePath = localhostPath + projectName;

//globel
var resultid;



var rows = [
            {"id":"dwmc", "name": "单位名称", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"qtmc", "name": "其他名称", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"dwdh", "name": "单位代号", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"scdz", "name": "军品科研生产场所地址", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"jjxz", "name": "经济性质", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"frdb", "name": "法人代表", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"dwdz", "name": "单位地址", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"yzbm", "name": "邮政编码", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"lxr", "name": "联系人", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"lxdh", "name": "联系电话", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"zgzs", "name": "在岗职工总人数", "value": "", "group": "人员构成", "editor":"text" },
            {"id":"gzgl", "name": "高职管理", "group": "人员构成", "value": "", "editor": "text" },
            {"id":"zzgl", "name": "中职管理", "group": "人员构成", "value": "", "editor":"text" },
            {"id":"czgl", "name": "初职管理", "value": "", "group": "人员构成", "editor":"text" },
            {"id":"gzjs", "name": "高职技术", "group": "人员构成", "value": "", "editor": "text" },
            {"id":"zzjs", "name": "中职技术", "group": "人员构成", "value": "", "editor": "text" },
            {"id":"czjs", "name": "初职技术", "group": "人员构成", "value": "", "editor":"text" },
            {"id":"gzgr", "name": "高职工人", "value": "", "group": "人员构成", "editor":"text" },
            {"id":"zzgr", "name": "中职工人", "group": "人员构成", "value": "", "editor":"text" },
            {"id":"czgr", "name": "初职工人", "value": "", "group": "人员构成", "editor":"text" },
            {"id":"gjjcgs", "name": "国家级科技成果数", "group": "获得科技成果数量", "value": "", "editor": "text" },
            {"id":"sbjcgs", "name": "省部级科技成果数", "group": "获得科技成果数量", "value": "", "editor":"text" },
            {"id":"jbqk", "name": "单位基本情况", "value": "", "group": "其他信息", "editor":"text" },
            {"id":"kyfx", "name": "单位科研方向", "group": "其他信息", "value": "", "editor": "text" },
            {"id":"qyscgl", "name": "企业生产纲领", "group": "其他信息", "value": "", "editor":"text" },
            {"id":"kyzk", "name": "科研生产管理组织机构状况", "value": "", "group": "其他信息", "editor":"text" },
            {"id":"zlglzk", "name": "质量管理体系状况", "group": "其他信息", "value": "", "editor": "text" },
            {"id":"bmaqzk", "name": "保密／安全生产／环保状况", "group": "其他信息", "value": "", "editor":"text" },
            {"id":"jpyfqk", "name": "现有军品研发部门的科研能力和条件情况", "value": "", "group": "其他信息", "editor":"text" },
            {"id":"jpjcqk", "name": "现有军品试验检测部门情况", "group": "其他信息", "value": "", "editor": "text" },
            {"id":"jpzzqk", "name": "现有军品制造部门的生产能力和条件情况", "group": "其他信息", "value": "", "editor":"text" },
            {"id":"wcjpqk", "name": "已完成的主要军品科研生产项目情况", "value": "", "group": "其他信息", "editor":"text" },
            {"id":"xcjpxmqk", "name": "现承担的主要军品科研生产项目的执行情况", "group": "其他信息", "value": "", "editor": "text" }

        ];

				
$(function() {
	var lastIndex;
	$('#wqzbkyscxkzxq').propertygrid({
		width: 1200,
        height: 'auto',
        showGroup: true,
        scrollbarSize: 0,
        columns: [[
                { field: 'name', title: '武器装备科研生产许可证需求', width: 50, resizable: true },
                { field: 'value', title: '', width: 100, resizable: false }
        ]]
    });
	$('#wqzbkyscxkzxq').propertygrid('loadData', rows);
	
	// 日期加上日期控件
//	$("#wcsj").datebox({
//		required : true
//	});
//	$("#wcsj2").datebox({
//		required : true
//	});	
	
	$('#srqk').datagrid({
			title : '产值或销售收入情况',
            width : 1200,
            height: 400,
			fitColumns : true, // 自动适应列宽      
            pageSize : 5,//默认选择的分页是每页5行数据
            pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
			toolbar:"#toolbar",
			//url:actionPath,
			pagination : true,//分页
            rownumbers : true,//行数
			toolbar:[ {// 工具栏
				text : '添加',
				iconCls : 'icon-add', // 图标
				handler : function() { // 处理函数
					$('#srqk').datagrid('endEdit', lastIndex);
					$('#srqk').datagrid('appendRow',{
						year:'',
						zcz:'',
						jp:'',
						mp:''
							
					})
					lastIndex = $('#srqk').datagrid('getRows').length-1;
					$('#srqk').datagrid('selectRow',lastIndex);
					$('#srqk').datagrid('beginEdit',lastIndex);	
					
				}
			},'-',{
					text:'删除',
					iconCls:'icon-remove',
					handler:function(){
						var row = $('#srqk').datagrid('getSelected');
						if (row){
							var index = $('#srqk').datagrid('getRowIndex', row);
							$('#srqk').datagrid('deleteRow', index);
						}
						else{
							$.messager.alert('删除', '请先选中要删除的记录', 'info');
						}
					}
				
			},'-',{
				text : "编辑",
				iconCls : "icon-edit",
				handler : function() {
					var row = $('#srqk').datagrid('getSelected');
					if (row) {
						var rowIndex = $('#srqk').datagrid('getRowIndex', row);
						$('#srqk').datagrid('beginEdit', rowIndex);
					}
					else{
							$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
						}
				}
			},'-',{
				text : '保存',
				iconCls : 'icon-save',// 图标
				handler : function() {// 处理函数
					$('#srqk').datagrid('acceptChanges');
				}
			},'-',{	
				text : '提交',
				iconCls : 'icon-ok',// 图标
				handler : function() {// 处理函数

							var action = basePath + '/system/WqwqxkzxqAction_addsrqk.action';

							var rows = $('#srqk').datagrid('getRows');
							if(rows.length != 0){
								for(i=0; i<rows.length; i++) {
									rows[i].id = resultid;
								}
								//alert(resultid);
								var data = {'srqkform': JSON.stringify(rows)};
								//alert(data);
								$.post(action, data, function(result){
									if (result.operateSuccess) {
									//alert(result);
										$('#srqk').datagrid('reload');// 重新加载
										$.messager.alert('提交', '提交成功', 'info');
									} else {
										$.messager.alert('提交', '提交失败', 'warning');
									}
								});
							}
						}
			}],
		/*	onClickRow:function(rowIndex){
				if (lastIndex != rowIndex){
					$('#cxy').datagrid('endEdit', lastIndex);
					$('#cxy').datagrid('beginEdit', rowIndex);
				}
				lastIndex = rowIndex;
			},
		*/	
			
			columns:[[ 
				  {field:'id',hidden:true,editor:{
					  type: 'numberbox',
					  options:{
						  value: 0
					  }
				  }}, 
		          {field:'year',title:'年度',editor:'textarea',width:100},    
		          {field:'zcz',title:'总产值（或销售收入）',editor:'textarea',width:100},  
		          {field:'jp',title:'军品',editor:'textarea',width:100},  
		          {field:'mp',title:'民品',editor:'textarea',width:100},  
					
		      ]] 
	});

	
	
	
	
	
	$('#cp').datagrid({
		title : '武器装备科研生产的许可专业（产品）',
        width : 1200,
        height: 400,
		fitColumns : true, // 自动适应列宽      
        pageSize : 5,//默认选择的分页是每页5行数据
        pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
        nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
		toolbar:"#toolbar",
		//url:actionPath,
		pagination : true,//分页
        rownumbers : true,//行数
		toolbar:[ {// 工具栏
			text : '添加',
			iconCls : 'icon-add', // 图标
			handler : function() { // 处理函数
				$('#cp').datagrid('endEdit', lastIndex);
				$('#cp').datagrid('appendRow',{
					xmdm:'',
					xmmc:'',
					kysc:'',
					xklx:''
				})
				lastIndex = $('#cp').datagrid('getRows').length-1;
				$('#cp').datagrid('selectRow',lastIndex);
				$('#cp').datagrid('beginEdit',lastIndex);	
				
			}
		},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
					var row = $('#cp').datagrid('getSelected');
					if (row){
						var index = $('#cp').datagrid('getRowIndex', row);
						$('#cp').datagrid('deleteRow', index);
					}
					else{
						$.messager.alert('删除', '请先选中要删除的记录', 'info');
					}
				}
			
		},'-',{
			text : "编辑",
			iconCls : "icon-edit",
			handler : function() {
				var row = $('#cp').datagrid('getSelected');
				if (row) {
					var rowIndex = $('#cp').datagrid('getRowIndex', row);
					$('#cp').datagrid('beginEdit', rowIndex);
				}
				else{
						$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
					}
			}
		},'-',{
			text : '保存',
			iconCls : 'icon-save',// 图标
			handler : function() {// 处理函数
				$('#cp').datagrid('acceptChanges');
			}
		},'-',{	
			text : '提交',
			iconCls : 'icon-ok',// 图标
			handler : function() {// 处理函数

						var action = basePath + '/system/WqwqxkzxqAction_addcp.action';

						var rows = $('#cp').datagrid('getRows');
						if(rows.length != 0){
							for(i=0; i<rows.length; i++) {
								rows[i].id = resultid;
							}
							//alert(resultid);
							var data = {'cpform': JSON.stringify(rows)};
							//alert(data);
							$.post(action, data, function(result){
								if (result.operateSuccess) {
								//alert(result);
									$('#cp').datagrid('reload');// 重新加载
									$.messager.alert('提交', '提交成功', 'info');
								} else {
									$.messager.alert('提交', '提交失败', 'warning');
								}
							});
						}
					}
		}],

		columns:[[ 
			  {field:'id',hidden:true,editor:{
				  type: 'numberbox',
				  options:{
					  value: 0
				  }
			  }}, 
	          {field:'xmdm',title:'项目代码',editor:'textarea',width:100},    
	          {field:'xmmc',title:'项目名称',editor:'textarea',width:100},  
	          {field:'kysc',title:'科研/生产',editor:'textarea',width:100},  
	          {field:'xklx',title:'许可类型',editor:'textarea',width:100},  
				
	      ]] 
});

});

//提交基本信息表
function submit(){
	var s = '';
	var action =  basePath + '/system/WqwqxkzxqAction_add.action';
	var rows = $('#wqzbkyscxkzxq').propertygrid('getRows');
	var changes = $('#wqzbkyscxkzxq').propertygrid('getChanges');
	if(rows.length != changes.length){
		$.messager.alert('验证', '信息有误或不完整', 'error');
	}
	else{
		for(var i=0; i<changes.length; i++){
			if(i == changes.length-1){
				s += changes[i].id + '=' + changes[i].value;
			}
			else{
				s += changes[i].id + '=' + changes[i].value + '&';
			}
		}
	
	}
	//alert(s);
	if(s.length != 0){
		$.post(action, s, function(result) {
			if (result.operateSuccess) {
					//alert(result.resultid);
					resultid = result.resultid;
					$('#wqzbkyscxkzxq').propertygrid('reload');// 重新加载
					$.messager.alert('提交', '提交成功', 'info');
			} else {
					$.messager.alert('提交', '提交失败', 'warning');
				}
		});
	}
	
}

// 关闭窗口
function closeForm(div, form) {
	$(form).form('clear');
	$(div).dialog('close');
}




