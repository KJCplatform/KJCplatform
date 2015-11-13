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
//var test = [
//	 {"id": "xm", "name": "专家姓名", "group": "基本信息", "value": "", "editor": "text" },
//     {"id": "xb", "name": "性别", "group": "基本信息", "value": "", 
//    		"editor":{
//    			"type": 'combobox', 
//    			"required": true ,
//    			"options":{
//    				"data":[{"value":"男","text":"男"},{"value":"女","text":"女"}],
//                        "panelHeight":"auto"		
//    				}
//		} 
//	}
//];

var rows = [
            {"id":"xmbh", "name": "项目编号", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"xmmc", "name": "项目名称", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"cjdws", "name": "参加单位总数", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"dwmc", "name": "承担单位名称", "group": "项目承担单位", "value": "", "editor": "text" },
            {"id":"dwszd", "name": "单位所在地", "group": "项目承担单位", "value": "", "editor":"text" },
            {"id":"txdz", "name": "通讯地址", "value": "", "group": "项目承担单位", "editor":"text" },
            {"id":"yb", "name": "邮编", "group": "项目承担单位", "value": "", "editor":"text" },
            {"id":"dwxz", "name": "单位性质", "group": "项目承担单位", "value": "", "editor":{
    			"type": 'combobox', 
    			"required": true ,
    			"options":{
    				"data":[{"value":"大专院校","text":"大专院校"},{"value":"科研院所","text":"科研院所"},{"value":"企业","text":"企业"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
    		} },
            {"id":"sjbm", "name": "上级行政主管部门", "value": "", "group": "项目承担单位", "editor":"text" },
            {"id":"fzr", "name": "项目负责人姓名", "group": "项目负责人", "value": "", "editor": "text" },
            {"id":"xb", "name": "性别", "group": "项目负责人", "value": "", 	"editor":{
    			"type": 'combobox', 
    			"required": true ,
    			"options":{
    				"data":[{"value":"男","text":"男"},{"value":"女","text":"女"}],
                        "panelHeight":"auto"		
    				}
		}   },
            {"id":"csn", "name": "出生年", "value": "", "group": "项目负责人", "editor":"text" },
            {"id":"xl", "name": "学历", "group": "项目负责人", "value": "","editor":{
    			"type": 'combobox', 
    			"required": true ,
    			"options":{
    				"data":[{"value":"研究生","text":"研究生"},{"value":"大学","text":"大学"},{"value":"大专","text":"大专"},{"value":"中专","text":"中专"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
    		} },
            {"id":"zc", "name": "职称", "group": "项目负责人", "value": "", "editor":{
    			"type": 'combobox', 
    			"required": true ,
    			"options":{
    				"data":[{"value":"高级","text":"高级"},{"value":"中级","text":"中级"},{"value":"初级","text":"初级"}],
                        "panelHeight":"auto"		
    				}	
    		}},
            {"id":"lxdh", "name": "联系电话", "value": "", "group": "项目负责人", "editor":"text" },
            {"id":"email", "name": "Email", "group": "项目负责人", "value": "", "editor":{
                "type":"validatebox",
                "options":{
                    "validType":"email"
                }
        }   },
        
        
        
        
            {"id":"xmzrs", "name": "总人数", "group": "项目组人数", "value": "", "editor":"text" },
            {"id":"gj", "name": "高级", "value": "", "group": "项目组人数", "editor":"text" },
            {"id":"zj", "name": "中级", "group": "项目组人数", "value": "", "editor": "text" },
            {"id":"cj", "name": "初级", "group": "项目组人数", "value": "", "editor":"text" },
            {"id":"qt", "name": "其他", "value": "", "group": "项目组人数", "editor":"text" },
            {"id":"qssj", "name": "起始时间", "group": "其他信息", "value": "", "editor": "text" },
            {"id":"zzsj", "name": "终止时间", "group": "其他信息", "value": "", "editor":"text" },
            {"id":"xmhdlx", "name": "项目活动类型", "value": "", "group": "其他信息", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"options":{
    				"data":[{"value":"应用开发","text":"应用开发"},{"value":"产业化开发","text":"产业化开发"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
        }},
            {"id":"ssly", "name": "所属领域", "group": "其他信息", "value": "", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"options":{
    				"data":[{"value":"工业","text":"工业"},{"value":"农业","text":"农业"},{"value":"社会发展","text":"社会发展"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
        } },
            {"id":"xmjsly", "name": "项目技术来源", "group": "其他信息", "value": "", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"options":{
    				"data":[{"value":"国内技术","text":"国内技术"},{"value":"国外技术","text":"国外技术"},{"value":"本单位自主开发","text":"本单位自主开发"}],
                        "panelHeight":"auto"		
    				}	
        } },
            {"id":"zyyfnr", "name": "主要研发内容", "value": "", "group": "其他信息", "editor":"text" },
            {"id":"cgxs", "name": "预期成果形式", "group": "其他信息", "value": "", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"options":{
    				"data":[{"value":"新技术","text":"新技术"},{"value":"新工艺","text":"新工艺"},{"value":"新产品（含农业新品种、计算机软件）","text":"新产品（含农业新品种、计算机软件）"}
    				,{"value":"新材料","text":"新材料"},{"value":"新装备","text":"新装备"},{"value":"论文论著","text":"论文论著"},{"value":"研究（咨询）报告","text":"研究（咨询）报告"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
        } },
            {"id":"yqzl", "name": "预期取得专利", "group": "其他信息", "value": "", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"options":{
    				"data":[{"value":"国外发明专利","text":"国外发明专利"},{"value":"国内发明专利","text":"国内发明专利"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
        }},
            {"id":"zjf", "name": "总经费", "value": "", "group": "经费投入", "editor":"text" },
            {"id":"sbk", "name": "省拨款", "group": "经费投入", "value": "", "editor": "text" },

            
        ];

				
$(function() {
	var lastIndex;
	$('#kjxmxx').propertygrid({
		width: 1200,
        height: 'auto',
        showGroup: true,
        scrollbarSize: 0,
        columns: [[
                { field: 'name', title: '科技项目信息', width: 50, resizable: true },
                { field: 'value', title: '', width: 100, resizable: false }
        ]]
    });
	$('#kjxmxx').propertygrid('loadData', rows);
	
	// 日期加上日期控件
//	$("#wcsj").datebox({
//		required : true
//	});
//	$("#wcsj2").datebox({
//		required : true
//	});	
	
	$('#qtcjdw').datagrid({
			title : '其他参加单位',
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
					$('#qtcjdw').datagrid('endEdit', lastIndex);
					$('#qtcjdw').datagrid('appendRow',{
						xh:'',
						dwmc:''
					})
					lastIndex = $('#qtcjdw').datagrid('getRows').length-1;
					$('#qtcjdw').datagrid('selectRow',lastIndex);
					$('#qtcjdw').datagrid('beginEdit',lastIndex);	
					
				}
			},'-',{
					text:'删除',
					iconCls:'icon-remove',
					handler:function(){
						var row = $('#qtcjdw').datagrid('getSelected');
						if (row){
							var index = $('#qtcjdw').datagrid('getRowIndex', row);
							$('#qtcjdw').datagrid('deleteRow', index);
						}
						else{
							$.messager.alert('删除', '请先选中要删除的记录', 'info');
						}
					}
				
			},'-',{
				text : "编辑",
				iconCls : "icon-edit",
				handler : function() {
					var row = $('#qtcjdw').datagrid('getSelected');
					if (row) {
						var rowIndex = $('#qtcjdw').datagrid('getRowIndex', row);
						$('#qtcjdw').datagrid('beginEdit', rowIndex);
					}
					else{
							$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
						}
				}
			},'-',{
				text : '保存',
				iconCls : 'icon-save',// 图标
				handler : function() {// 处理函数
					$('#qtcjdw').datagrid('acceptChanges');
				}
			},'-',{	
				text : '提交',
				iconCls : 'icon-ok',// 图标
				handler : function() {// 处理函数

							var action = basePath + '/system/KjkjxmxxbAction_addqtcjdw.action';

							var rows = $('#qtcjdw').datagrid('getRows');
							if(rows.length != 0){
								for(i=0; i<rows.length; i++) {
									rows[i].id = resultid;
								}
								//alert(resultid);
								var data = {'qtcjdwform': JSON.stringify(rows)};
								//alert(data);
								$.post(action, data, function(result){
									if (result.operateSuccess) {
									//alert(result);
										$('#qtcjdw').datagrid('reload');// 重新加载
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
		          {field:'xh',title:'序号',editor:'textarea',width:100},    
		          {field:'dwmc',title:'单位名称',editor:'textarea',width:100},  
			
		      ]] 
	});

	

});

//提交基本信息表
function submit(){
	var s = '';
	var action =  basePath + '/system/KjkjxmxxbAction_add.action';
	var rows = $('#kjxmxx').propertygrid('getRows');
	var changes = $('#kjxmxx').propertygrid('getChanges');
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
					$('#kjxmxx').propertygrid('reload');// 重新加载
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




