//JQuery的入口
var curWwwPath = window.document.location.href;
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
var localhostPath = curWwwPath.substring(0, pos);
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
var basePath = localhostPath + projectName;

//globel
var resultid;

//test

var rows = [
            {"id": "zjxm", "name": "专家姓名", "group": "基本信息", "value": "", "editor": "text" },
            {"id": "xb", "name": "性别", "group": "基本信息", "value": "", 
    		"editor":{
    			"type": 'combobox', 
    			"options":{
    				"data":[{"value":"男","text":"男"},{"value":"女","text":"女"}],
                    "panelHeight":"auto",
					"required": true ,
					"editable" : false 	
    				}
    		} },
            {"id":"sfzh", "name": "身份证号", "value": "", "group": "基本信息", 
				"editor":{
					"type": 'validatebox',	
					"options":{
                        "validType":"idcard"
                    }
					
				}},
    		{"id":"yx", "name":"邮箱","value":"", "group":"基本信息","editor":{
                    "type":"validatebox",
                    "options":{
                        "validType":"email"
                    }
            }},
    		{"id":"jszc", "name": "技术职称", "group": "基本信息", "value": "下拉菜单选择", 
    		"editor":{
    			"type": 'combobox', 
    			"required": true ,
				"editable" : false ,
    			"options":{
    				"data":[{"value":"职称1","text":"职称1"},{"value":"职称2","text":"职称2"},{"value":"职称3","text":"职称3"}],
                    "panelHeight":"auto",
					"required": true ,
					"editable" : false 		
    				}	
    		} },
    		{"id":"zw","name": "职务", "value": "", "group": "基本信息", "editor":"text" },
    		{"id":"gzdw", "name": "工作单位", "value": "法人单位", "group": "基本信息", "editor":"text" },
    		{ "id": "gzbm", "name": "工作部门", "value": "法人单位二级部门", "group": "基本信息", "editor":"text" },
    		{"id": "zgxl", "name": "最高学历", "group": "基本信息", "value": "下拉菜单选择", 
    		"editor":{
    			"type": 'combobox', 
    			"options":{
    				"data":[{"value":"院士","text":"院士"},{"value":"博士","text":"博士"},{"value":"硕士","text":"硕士"},{"value":"本科","text":"本科"},{"value":"大专","text":"大专"},{"value":"其他","text":"其他"}],
                    "panelHeight":"auto",
					"required": true ,
					"editable" : false 		
    				}	
    		} },
    		{"id": "szdq", "name": "所在地区", "group": "基本信息", "value": "", 
    		"editor":{
    			"type": 'combotree', 
				"options":{
					"url": basePath + '/project/area.json',
					"multiple" : true,
					"cascadeCheck": false,
					"required": true ,
					"onClick": function(node) {  
						//返回树对象  
						//alert(node.text);
						var tree = $(this).tree;  
						var node1=$(this).tree('getParent',node.target);
						if(node1){
							//alert(node1.text);
							$(this).tree('check', node1.target);
							
							//alert($(this).combotree.value);

							}
						}
					}
				} 
			},
			
			{"id": "sfgk", "name": "以下信息是否公开", "group": "联系方式", "value": "", 
    		"editor":{
    			"type": 'combobox', 
    			"options":{
    				"data":[{"value":"是","text":"是"},{"value":"否","text":"否"}],
					"panelHeight":"auto",
					"required": true ,
					"editable" : false 	
    				}
    		} },
			{"id": "lxdh", "name": "联系电话", "value": "", "group": "联系方式", 
			"editor":{
				"type": 'validatebox',
				"options":{
					"validType": "phone"
				}
			}},
			{"id": "sj", "name": "手机", "value": "", "group": "联系方式", "editor":{
				"type": 'validatebox',
				"options":{
					"validType": "mobile"
				}
			}},
			{"id": "lxdz", "name": "联系地址", "value": "", "group": "联系方式", "editor":"text" },
			
			{"id": "hyly", "name": "行业领域", "group": "研究方向", "value": "", 
    		"editor":{
    			"type": 'combotree', 
				"options":{
					"url": basePath + '/project/industry.json',
					"multiple" : true,
					"checkbox": true ,
					"cascadeCheck": false,
					"required": true ,
					"editable": false
				}
    			
    		} }	,
			{"id": "jsly", "name": "技术领域", "group": "研究方向", "value": "", 
    		"editor":{
    			"type": 'combotree', 
				"options":{
					"url": basePath + '/project/tech.json',
					"multiple" : true,
					"checkbox": true ,
					"cascadeCheck": false,
					"required": true ,
					"editable": false
				}
    		} }	,
			{"id": "xkly", "name": "学科领域", "group": "研究方向", "value": "", 
    		"editor":{
    			"type": 'combotree', 
    			"options":{
					"url": basePath + '/project/subject.json',
					"multiple" : true,
					"checkbox": true ,
					"cascadeCheck": false,
					"required": true ,
					"editable": false
				}
    		} }	,
			
			{"id": "fwyy", "name": "服务意愿", "group": "其他信息", "value": "", 
    		"editor":{
    			"type": 'combobox', 
    			"options":{
    				"data":[{"value":"技术成果及需求评价","text":"技术成果及需求评价"},{"value":"技术开发","text":"技术开发"},{"value":"技术咨询","text":"技术咨询"},{"value":"技术服务","text":"技术服务"}],
                    "panelHeight":"auto",
					"required": true ,
					"multiple":true ,  
					"editable": false
    				}	
    		} },
			{"id": "szpt", "name": "所在研发平台或实验基地", "value": "", "group": "其他信息", "editor":"text" },
			{"id": "zjjj", "name": "专家简介", "value": "重点介绍自己的学术经历", "group": "其他信息", "editor":"textarea" },
			{"id": "zytc", "name": "专业特长", "value": "重点介绍自己在专业技术领域的特长，可帮助企业解决哪方面的技术问题", "group": "其他信息", "editor":"textarea" }
			
        ];

				
$(function() {
	var lastIndex;
	$('#info').propertygrid({
		width: 1200,
        height: 'auto',
        showGroup: true,
        scrollbarSize: 0,
        columns: [[
                { field: 'name', title: '技术专家数据采集', width: 50, resizable: true },
                { field: 'value', title: '', width: 100, resizable: false }
        ]]
    });
	$("#info").propertygrid('loadData', rows);
	
	
	$('#cxy').datagrid({
			title : '产学研合作项目情况',
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
					$('#cxy').datagrid('endEdit', lastIndex);
					$('#cxy').datagrid('appendRow',{
						xmmc:'',
						hzsj:'',
						xmjj:'',
						hzxg:''
					})
					lastIndex = $('#cxy').datagrid('getRows').length-1;
					$('#cxy').datagrid('selectRow',lastIndex);
					$('#cxy').datagrid('beginEdit',lastIndex);	
					
				}
			},'-',{
					text:'删除',
					iconCls:'icon-remove',
					handler:function(){
						var row = $('#cxy').datagrid('getSelected');
						if (row){
							var index = $('#cxy').datagrid('getRowIndex', row);
							$('#cxy').datagrid('deleteRow', index);
						}
						else{
							$.messager.alert('删除', '请先选中要删除的记录', 'info');
						}
					}
				
			},'-',{
				text : "编辑",
				iconCls : "icon-edit",
				handler : function() {
					var row = $('#cxy').datagrid('getSelected');
					if (row) {
						var rowIndex = $('#cxy').datagrid('getRowIndex', row);
						$('#cxy').datagrid('beginEdit', rowIndex);
					}
					else{
							$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
						}
				}
			},'-',{
				text : '保存',
				iconCls : 'icon-save',// 图标
				handler : function() {// 处理函数
					$('#cxy').datagrid('acceptChanges');
				}
			},'-',{	
				text : '提交',
				iconCls : 'icon-ok',// 图标
				handler : function() {// 处理函数

							var action = basePath + '/system/KjjszjcjbAction_addcxy.action';

							var rows = $('#cxy').datagrid('getRows');
							if(rows.length != 0){
								for(i=0; i<rows.length; i++) {
									rows[i].id = resultid;
								}
								//alert(resultid);
								var data = {'cxyform': JSON.stringify(rows)};
								//alert(data);
								$.post(action, data, function(result){
									if (result.operateSuccess) {
									//alert(result);
										$('#cxy').datagrid('reload');// 重新加载
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
		          {field:'xmmc',title:'项目名称',editor:'textarea',width:100},    
		          {field:'hzsj',title:'合作起止时间',editor:'textarea',width:100},  
				  {field:'xmjj',title:'项目简介',editor:'textarea',width:200},  				  
		          {field:'hzxg',title:'合作效果',width:100,
					editor:{  
						type:'combobox',  
						options:{  
							data:[{"value":"良好","text":"良好"},{"value":"一般","text":"一般"}],  
							required:true ,
							editable:false	
							} 
						}    
				  }
		      ]] 
	});

	
	$('#jscg').datagrid({
			title : '主持或参与完成的技术成果情况',
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
					$('#jscg').datagrid('endEdit', lastIndex);
					$('#jscg').datagrid('appendRow',{
						cgmc:'',
						wcsj:'',
						cgjj:'',
						zhqk:''
					})
					lastIndex = $('#jscg').datagrid('getRows').length-1;
					$('#jscg').datagrid('selectRow',lastIndex);
					$('#jscg').datagrid('beginEdit',lastIndex);	
					
				}
			},'-',{
					text:'删除',
					iconCls:'icon-remove',
					handler:function(){
						var row = $('#jscg').datagrid('getSelected');
						if (row){
							var index = $('#jscg').datagrid('getRowIndex', row);
							$('#jscg').datagrid('deleteRow', index);
						}
						else{
							$.messager.alert('删除', '请先选中要删除的记录', 'info');
						}
					}
				
			},'-',{
				text : "编辑",
				iconCls : "icon-edit",
				handler : function() {
					var row = $('#jscg').datagrid('getSelected');
					if (row) {
						var rowIndex = $('#jscg').datagrid('getRowIndex', row);
						$('#jscg').datagrid('beginEdit', rowIndex);
					}
					else{
							$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
						}
				}
			},'-',{
				text : '保存',
				iconCls : 'icon-save',// 图标
				handler : function() {// 处理函数
					$('#jscg').datagrid('acceptChanges');
				}
			},'-',{
				text : '提交',
				iconCls : 'icon-edit',// 图标
				handler : function() {// 处理函数
						var action = basePath + '/system/KjjszjcjbAction_addjscg.action';
						var rows = $('#jscg').datagrid('getRows');
						if(rows.length != 0){
							for(i=0; i<rows.length; i++) {
								rows[i].id = resultid;
							}
							//alert(resultid);
							var data = {'jscgform': JSON.stringify(rows)};
							//alert(data);
							$.post(action, data, function(result){
								if (result.operateSuccess) {
								//alert(result);
									$('#jscg').datagrid('reload');// 重新加载
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
				{field:'cgmc',title:'成果名称',editor:'textarea',width:100},    
		        {field:'wcsj',title:'完成时间',width:100, editor:{
					type:'datebox',
					options:{
						required: true,
						editable: false	
					}
					}
				},  
				{field:'cgjj',title:'成果简介',editor:'textarea',width:100},  				  
		        {field:'zhqk',title:'转化情况',width:100, editor:{
						type:'combobox',  
						options:{  
							data:[{"value":"已转化，继续转化","text":"已转化，继续转化"},{"value":"未转化，希望转化","text":"未转化，希望转化"}],  
							required:true,
							editable: false
							} 
					}
				}    
		      ]] 
	});
	
		$('#zy').datagrid({
			title : '在研项目情况',
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
					$('#zy').datagrid('endEdit', lastIndex);
					$('#zy').datagrid('appendRow',{
						xmmc:'',
						wcsj:'',
						xmjj:'',
						sfzh:''
					})
					lastIndex = $('#zy').datagrid('getRows').length-1;
					$('#zy').datagrid('selectRow',lastIndex);
					$('#zy').datagrid('beginEdit',lastIndex);	
					
				}
			},'-',{
					text:'删除',
					iconCls:'icon-remove',
					handler:function(){
						var row = $('#zy').datagrid('getSelected');
						if (row){
							var index = $('#zy').datagrid('getRowIndex', row);
							$('#zy').datagrid('deleteRow', index);
						}
						else{
							$.messager.alert('删除', '请先选中要删除的记录', 'info');
						}
					}
				
			},'-',{
					text : "编辑",
					iconCls : "icon-edit",
					handler : function() {
						var row = $('#zy').datagrid('getSelected');
						if (row) {
							var rowIndex = $('#zy').datagrid('getRowIndex', row);
							$('#zy').datagrid('beginEdit', rowIndex);
						}
						else{
								$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
							}
					}
			},'-',{
				text : '保存',
				iconCls : 'icon-save',// 图标
				handler : function() {// 处理函数
					$('#zy').datagrid('acceptChanges');
				}
			},'-',{
				text : '提交',
				iconCls : 'icon-edit',// 图标
				handler : function() {// 处理函数
					var action = basePath + '/system/KjjszjcjbAction_addzy.action';
					var rows = $('#zy').datagrid('getRows');
					if(rows.length != 0){
						for(i=0; i<rows.length; i++) {
							rows[i].id = resultid;
						}
						//alert(resultid);
						var data = {'zyform': JSON.stringify(rows)};
						//alert(data);
						$.post(action, data, function(result){
							if (result.operateSuccess) {
							//alert(result);
								$('#zy').datagrid('reload');// 重新加载
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
		        {field:'xmmc',title:'项目名称',editor:'textarea',width:100},    
		        {field:'wcsj',title:'预计完成时间',width:100,
					editor:{
						type:'datebox',
						options:{
							required: true,
							editable: false
						}			
					}
				},  
				{field:'xmjj',title:'项目简介',width:100,editor:'textarea'},  				  
		        {field:'sfzh',title:'是否转化',width:100,editor:{
						type:'combobox',  
						options:{  
							data:[{"value":"是","text":"是"},{"value":"否","text":"否"}],  
							required:true,
							editable: false	
						} 
					}
				}    
		      ]] 
	});
});

//提交基本信息表
function submit(){
	var s = '';
	var action =  basePath + '/system/KjjszjcjbAction_add.action';
	var rows = $('#info').propertygrid('getRows');
	var changes = $('#info').propertygrid('getChanges');
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
					$('#info').propertygrid('reload');// 重新加载
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




