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
            {"id":"year", "name": "年度", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"nf", "name": "年份", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"qymc", "name": "企业名称", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"nssbh", "name": "纳税人识别号", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"ssly", "name": "主营产品技术领域", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"zgswjg", "name": "企业所得税主管税务机关", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"zgzs", "name": "职工总数", "group": "人力资源情况", "value": "", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"yjrys", "name": "人事研究开发人员数", "value": "", "group": "人力资源情况", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"dzrs", "name": "大专以上人员数", "group": "人力资源情况", "value": "", "editor": {
            	"type": 'numberbox', 
            } },
            {"id":"ynzsr", "name": "近1年企业总收入", "group": "企业财务状况", "value": "", "editor":"text" },
            {"id":"sr1", "name": "第1年销售收入", "value": "", "group": "企业财务状况", "editor":"text" },
            {"id":"sr2", "name": "第2年销售总收入", "group": "企业财务状况", "value": "", "editor": "text" },
            {"id":"sr3", "name": "第3年销售总收入", "group": "企业财务状况", "value": "", "editor":"text" },
            {"id":"hj", "name": "销售收入合计", "value": "", "group": "企业财务状况", "editor":"text" },
            {"id":"xszzl", "name": "销售增长率", "group": "企业财务状况", "value": "", "editor": "text" },
            {"id":"zc1", "name": "第1 年总资产", "group": "企业财务状况", "value": "", "editor": "text" },
            {"id":"zc2", "name": "第2 年总资产", "group": "企业财务状况", "value": "", "editor":"text" },
            {"id":"zc3", "name": "第3 年总资产", "value": "", "group": "企业财务状况", "editor":"text" },
            {"id":"zczzl", "name": "总资产增长率", "group": "企业财务状况", "value": "", "editor":"text" },
  
        ];

				
$(function() {
	var lastIndex;
	$('#gxjsqyrdba').propertygrid({
		width: 1000,
        height: 'auto',
        showGroup: true,
        scrollbarSize: 0,
        columns: [[
                { field: 'name', title: '高新技术企业认定备案', width: 50, resizable: true },
                { field: 'value', title: '', width: 100, resizable: false }
        ]]
    });
	$('#gxjsqyrdba').propertygrid('loadData', rows);
	
	// 日期加上日期控件
//	$("#wcsj").datebox({
//		required : true
//	});
//	$("#wcsj2").datebox({
//		required : true
//	});	
	
	$('#gxcp').datagrid({
			title : '上年度高新技术产品（服务）情况',
            width : 1000,
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
					$('#gxcp').datagrid('endEdit', lastIndex);
					$('#gxcp').datagrid('appendRow',{
						cpbh:'',
						cpmc:'',
						shsr:''
							
					})
					lastIndex = $('#gxcp').datagrid('getRows').length-1;
					$('#gxcp').datagrid('selectRow',lastIndex);
					$('#gxcp').datagrid('beginEdit',lastIndex);	
					
				}
			},'-',{
					text:'删除',
					iconCls:'icon-remove',
					handler:function(){
						var row = $('#gxcp').datagrid('getSelected');
						if (row){
							var index = $('#gxcp').datagrid('getRowIndex', row);
							$('#gxcp').datagrid('deleteRow', index);
						}
						else{
							$.messager.alert('删除', '请先选中要删除的记录', 'info');
						}
					}
				
			},'-',{
				text : "编辑",
				iconCls : "icon-edit",
				handler : function() {
					var row = $('#gxcp').datagrid('getSelected');
					if (row) {
						var rowIndex = $('#gxcp').datagrid('getRowIndex', row);
						$('#gxcp').datagrid('beginEdit', rowIndex);
					}
					else{
							$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
						}
				}
			},'-',{
				text : '保存',
				iconCls : 'icon-save',// 图标
				handler : function() {// 处理函数
					$('#gxcp').datagrid('acceptChanges');
				}
			},'-',{	
				text : '提交',
				iconCls : 'icon-ok',// 图标
				handler : function() {// 处理函数

							var action = basePath + '/system/KjgxqybabAction_addgxcp.action';

							var rows = $('#gxcp').datagrid('getRows');
							if(rows.length != 0){
								for(i=0; i<rows.length; i++) {
									rows[i].id = resultid;
								}
								//alert(resultid);
								var data = {'gxcpform': JSON.stringify(rows)};
								//alert(data);
								$.post(action, data, function(result){
									if (result.operateSuccess) {
									//alert(result);
										$('#gxcp').datagrid('reload');// 重新加载
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
		          {field:'cpbh',title:'产品编号',editor:'textarea',width:100},    
		          {field:'cpmc',title:'项目（服务）名称',editor:'textarea',width:100},  
		          {field:'shsr',title:'上年度销售收入',editor:'textarea',width:100},  
		        
		      ]] 
	});

	
	
	
	
	
	$('#yfxm').datagrid({
		title : '企业研究开发项目情况',
        width : 1000,
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
				$('#yfxm').datagrid('endEdit', lastIndex);
				$('#yfxm').datagrid('appendRow',{
					xmbh:'',
					xmmc:'',
					jfhj:'',
					jfnb:'',
					jfwb:''
				})
				lastIndex = $('#yfxm').datagrid('getRows').length-1;
				$('#yfxm').datagrid('selectRow',lastIndex);
				$('#yfxm').datagrid('beginEdit',lastIndex);	
				
			}
		},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
					var row = $('#yfxm').datagrid('getSelected');
					if (row){
						var index = $('#yfxm').datagrid('getRowIndex', row);
						$('#yfxm').datagrid('deleteRow', index);
					}
					else{
						$.messager.alert('删除', '请先选中要删除的记录', 'info');
					}
				}
			
		},'-',{
			text : "编辑",
			iconCls : "icon-edit",
			handler : function() {
				var row = $('#yfxm').datagrid('getSelected');
				if (row) {
					var rowIndex = $('#yfxm').datagrid('getRowIndex', row);
					$('#yfxm').datagrid('beginEdit', rowIndex);
				}
				else{
						$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
					}
			}
		},'-',{
			text : '保存',
			iconCls : 'icon-save',// 图标
			handler : function() {// 处理函数
				$('#yfxm').datagrid('acceptChanges');
			}
		},'-',{	
			text : '提交',
			iconCls : 'icon-ok',// 图标
			handler : function() {// 处理函数

						var action = basePath + '/system/KjgxqybabAction_addyfxm.action';

						var rows = $('#yfxm').datagrid('getRows');
						if(rows.length != 0){
							for(i=0; i<rows.length; i++) {
								rows[i].id = resultid;
							}
							//alert(resultid);
							var data = {'yfxmform': JSON.stringify(rows)};
							//alert(data);
							$.post(action, data, function(result){
								if (result.operateSuccess) {
								//alert(result);
									$('#yfxm').datagrid('reload');// 重新加载
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
	          {field:'xmbh',title:'项目编号',editor:'textarea',width:100},    
	          {field:'xmmc',title:'项目名称',editor:'textarea',width:100},  
	          {field:'jfhj',title:'项目研发经费-合计',editor:'textarea',width:100},  
	          {field:'jfnb',title:'项目研发经费-内部',editor:'textarea',width:100},  
	          {field:'jfwb',title:'项目研发经费-外部',editor:'textarea',width:100},  
		      	
	       
	      ]] 
});
	
	
	
	$('#zscq').datagrid({
		title : '近3年内获得的自主知识产权情况',
        width : 1000,
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
				$('#zscq').datagrid('endEdit', lastIndex);
				$('#zscq').datagrid('appendRow',{
					xmbh:'',
					sqmc:'',
					lb:'',
					sqh:'',
					sqrq:''	
				})
				lastIndex = $('#zscq').datagrid('getRows').length-1;
				$('#zscq').datagrid('selectRow',lastIndex);
				$('#zscq').datagrid('beginEdit',lastIndex);	
				
			}
		},'-',{
				text:'删除',
				iconCls:'icon-remove',
				handler:function(){
					var row = $('#zscq').datagrid('getSelected');
					if (row){
						var index = $('#zscq').datagrid('getRowIndex', row);
						$('#zscq').datagrid('deleteRow', index);
					}
					else{
						$.messager.alert('删除', '请先选中要删除的记录', 'info');
					}
				}
			
		},'-',{
			text : "编辑",
			iconCls : "icon-edit",
			handler : function() {
				var row = $('#zscq').datagrid('getSelected');
				if (row) {
					var rowIndex = $('#zscq').datagrid('getRowIndex', row);
					$('#zscq').datagrid('beginEdit', rowIndex);
				}
				else{
						$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
					}
			}
		},'-',{
			text : '保存',
			iconCls : 'icon-save',// 图标
			handler : function() {// 处理函数
				$('#zscq').datagrid('acceptChanges');
			}
		},'-',{	
			text : '提交',
			iconCls : 'icon-ok',// 图标
			handler : function() {// 处理函数

						var action = basePath + '/system/KjgxqybabAction_addzscq.action';

						var rows = $('#zscq').datagrid('getRows');
						if(rows.length != 0){
							for(i=0; i<rows.length; i++) {
								rows[i].id = resultid;
							}
							//alert(resultid);
							var data = {'zscqform': JSON.stringify(rows)};
							//alert(data);
							$.post(action, data, function(result){
								if (result.operateSuccess) {
								//alert(result);
									$('#zscq').datagrid('reload');// 重新加载
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
	          {field:'xmbh',title:'项目编号',editor:'textarea',width:100},    
	          {field:'sqmc',title:'授权项目名称',editor:'textarea',width:100},  
	          {field:'lb',title:'类别',editor:'textarea',width:100},  
	          {field:'sqh',title:'授权号',editor:'textarea',width:100},  
	          {field:'sqrq',title:'授权日期',width:100,editor:{
					type:'datebox',
					required: true
					}}
		
	          
	      ]] 
});
	
	
});

//提交基本信息表
function submit(){
	var s = '';
	var action =  basePath + '/system/KjgxqybabAction_add.action';
	var rows = $('#gxjsqyrdba').propertygrid('getRows');
	var changes = $('#gxjsqyrdba').propertygrid('getChanges');
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
					$('#gxjsqyrdba').propertygrid('reload');// 重新加载
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




