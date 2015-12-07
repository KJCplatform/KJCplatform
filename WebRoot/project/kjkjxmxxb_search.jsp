<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>科技项目信息</title>
    <link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
	<script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/json2.js"></script>
	
	<script>
	
	/*	$('#dg').datagrid({  	
			columns:[[{
				field:'userId',
				title:'User', 
				width:80,
				formatter: function(value,row,index){
					
					return "<a href='javascript:go(row);'>"+value+"</a>";
						
				 }  	
			  }]]  
		});
	*/	
		var curWwwPath = window.document.location.href;
		var pathName = window.document.location.pathname;
		var pos = curWwwPath.indexOf(pathName);
		var localhostPath = curWwwPath.substring(0, pos);
		var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		var basePath = localhostPath + projectName;
		var resultid;
		var display = [
            {"id":"xmbh", "name": "项目编号", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"xmmc", "name": "项目名称", "group": "基本信息", "value": "", "editor":"text" },
//             {"id":"cjdws", "name": "参加单位总数", "value": "", "group": "基本信息", "editor":{
//             	"type": 'numberbox', 
//             } },
            {"id":"dwmc", "name": "单位名称", "group": "项目承担单位", "value": "", "editor": "text" },
            {"id":"dwszd", "name": "单位所在地", "group": "项目承担单位", "value": "", "editor":"text" },
            {"id":"txdz", "name": "通讯地址", "value": "", "group": "项目承担单位", "editor":"text" },
            {"id":"yb", "name": "邮编", "group": "项目承担单位", "value": "", "editor":"text" },
            {"id":"dwxz", "name": "单位性质", "group": "项目承担单位", "value": "请选择", "editor":{
    			"type": 'combobox', 
    			"required": true ,
    			"editable":false,
    			"options":{
    				"data":[{"value":"大专院校","text":"大专院校"},{"value":"科研院所","text":"科研院所"},{"value":"企业","text":"企业"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
    		} },
            {"id":"sjbm", "name": "上级行政主管部门", "value": "", "group": "项目承担单位", "editor":"text" },
            {"id":"fzr", "name": "项目负责人姓名", "group": "项目负责人", "value": "", "editor": "text" },
            {"id":"xb", "name": "性别", "group": "项目负责人", "value": "请选择", 	"editor":{
    			"type": 'combobox', 
    			"required": true ,
    			"editable":false,
    			"options":{
    				"data":[{"value":"男","text":"男"},{"value":"女","text":"女"}],
                        "panelHeight":"auto"		
    				}
		}   },
            {"id":"csn", "name": "出生年", "value": "", "group": "项目负责人", "editor":{
				"type":'datebox',
				"editable":false
			
			} },
            {"id":"xl", "name": "学历", "group": "项目负责人", "value": "请选择","editor":{
    			"type": 'combobox', 
    			"required": true ,
    			"editable":false,
    			"options":{
    				"data":[{"value":"研究生","text":"研究生"},{"value":"大学","text":"大学"},{"value":"大专","text":"大专"},{"value":"中专","text":"中专"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
    		} },
            {"id":"zc", "name": "职称", "group": "项目负责人", "value": "请选择", "editor":{
    			"type": 'combobox', 
    			"required": true ,
    			"editable":false,
    			"options":{
    				"data":[{"value":"高级","text":"高级"},{"value":"中级","text":"中级"},{"value":"初级","text":"初级"}],
                        "panelHeight":"auto"		
    				}	
    		}},
            {"id":"lxdh", "name": "联系电话", "value": "", "group": "项目负责人", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"email", "name": "Email", "group": "项目负责人", "value": "", "editor":{
                "type":"validatebox",
                "options":{
                    "validType":"email"
                }
        }   },
        
        
        
        
            {"id":"xmzrs", "name": "总人数", "group": "项目组人数", "value": "", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"gj", "name": "高级", "value": "", "group": "项目组人数", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"zj", "name": "中级", "group": "项目组人数", "value": "", "editor": {
            	"type": 'numberbox', 
            } },
            {"id":"cj", "name": "初级", "group": "项目组人数", "value": "", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"qt", "name": "其他", "value": "", "group": "项目组人数", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"qssj", "name": "起始时间", "group": "其他信息", "value": "", "editor":{
				"type":'datebox',
				"editable":false} },
            {"id":"zzsj", "name": "终止时间", "group": "其他信息", "value": "", "editor":{
				"type":'datebox',
				"editable":false} },
            {"id":"xmhdlx", "name": "项目活动类型", "value": "请选择", "group": "其他信息", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"editable":false,
    			"options":{
    				"data":[{"value":"应用开发","text":"应用开发"},{"value":"产业化开发","text":"产业化开发"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
        }},
            {"id":"ssly", "name": "所属领域", "group": "其他信息", "value": "请选择", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"editable":false,
    			"options":{
    				"data":[{"value":"工业","text":"工业"},{"value":"农业","text":"农业"},{"value":"社会发展","text":"社会发展"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
        } },
            {"id":"xmjsly", "name": "项目技术来源", "group": "其他信息", "value": "请选择", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"editable":false,
    			"options":{
    				"data":[{"value":"国内技术","text":"国内技术"},{"value":"国外技术","text":"国外技术"},{"value":"本单位自主开发","text":"本单位自主开发"}],
                        "panelHeight":"auto"		
    				}	
        } },
            {"id":"zyyfnr", "name": "主要研发内容", "value": "", "group": "其他信息", "editor":"text" },
            {"id":"cgxs", "name": "预期成果形式", "group": "其他信息", "value": "请选择", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"editable":false,
    			"options":{
    				"data":[{"value":"新技术","text":"新技术"},{"value":"新工艺","text":"新工艺"},{"value":"新产品（含农业新品种、计算机软件）","text":"新产品（含农业新品种、计算机软件）"}
    				,{"value":"新材料","text":"新材料"},{"value":"新装备","text":"新装备"},{"value":"论文论著","text":"论文论著"},{"value":"研究（咨询）报告","text":"研究（咨询）报告"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
        } },
            {"id":"yqzl", "name": "预期取得专利", "group": "其他信息", "value": "请选择", "editor":{
            	"type": 'combobox', 
    			"required": true ,
    			"editable":false,
    			"options":{
    				"data":[{"value":"国外发明专利","text":"国外发明专利"},{"value":"国内发明专利","text":"国内发明专利"},{"value":"其它","text":"其它"}],
                        "panelHeight":"auto"		
    				}	
        }},
            {"id":"zjf", "name": "总经费", "value": "", "group": "经费投入", "editor":"text" },
            {"id":"sbk", "name": "省拨款", "group": "经费投入", "value": "", "editor": "text" },
            {"id":"jlnf", "name": "记录时间（年份） ", "group": "其他信息", "value": "", "editor": "text" },
      
        ];

            

		$(function() {
			var lastIndex;
			$('#kjxmxx').propertygrid({
	
		        width: 1000,
		        height: 'auto',
		        showGroup: true,
		        scrollbarSize: 0,
		        columns: [[
		                { field: 'name', title: '专家基本信息', width: 50, resizable: true },
		                { field: 'value', title: '', width: 100, resizable: false }
		        ]]
		    });
		    $('#kjxmxx').propertygrid('loadData', display);
			
			$('#cjdw').datagrid({
				title : '其他参加单位',
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
				toolbar:[   {// 工具栏
					text : '添加',
					iconCls : 'icon-add', // 图标
					handler : function() { // 处理函数
						$('#cjdw').datagrid('endEdit', lastIndex);
						$('#cjdw').datagrid('appendRow',{
							xh:'',
							dwmc:''
						})
						lastIndex = $('#cjdw').datagrid('getRows').length-1;
						$('#cjdw').datagrid('selectRow',lastIndex);
						$('#cjdw').datagrid('beginEdit',lastIndex);	
						
					}
				},'-',{
					
						text:'删除',
						iconCls:'icon-remove',
						handler:function(){
							var row = $('#cjdw').datagrid('getSelected');
							if (row){
								var index = $('#cjdw').datagrid('getRowIndex', row);
								$('#cjdw').datagrid('deleteRow', index);
							}
							else{
								$.messager.alert('删除', '请先选中要删除的记录', 'info');
							}
						}
					
					},'-',{
					text : "编辑",
					iconCls : "icon-edit",
					handler : function() {
						var row = $('#cjdw').datagrid('getSelected');
						if (row) {
							var rowIndex = $('#cjdw').datagrid('getRowIndex', row);
							$('#cjdw').datagrid('beginEdit', rowIndex);
						}
						else{
								$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
							}
					}
					},'-',{
					text : '保存',
					iconCls : 'icon-save',// 图标
					handler : function() {// 处理函数
						$('#cjdw').datagrid('acceptChanges');
					}
					},'-',{	
						text : '提交',
						iconCls : 'icon-ok',// 图标
						handler : function() {// 处理函数

								var action = basePath + '/system/KjkjxmxxbAction_addcjdw.action';

								var rows = $('#cjdw').datagrid('getRows');
								if(rows.length != 0){
									for(i=0; i<rows.length; i++) {
										rows[i].id = resultid;
									}
									//alert(resultid);
									var data = {'cjdwform': JSON.stringify(rows)};
	//								alert(rows);
									$.post(action, data, function(result){
										if (result.operateSuccess) {
										//alert(result);
											$('#cjdw').datagrid('reload');// 重新加载
											$.messager.alert('提交', '提交成功', 'info');
										} else {
											$.messager.alert('提交', '提交失败', 'warning');
										}
									}); 
								}
							}
				}],	
				columns:[[ 
					  {field:'xh',title:'序号',editor:'text',width:100},    
					  {field:'dwmc',title:'单位名称',editor:'text',width:100}
			
		      ]] 
			});
		});	
		function doSearch(){
			var action =  basePath + '/system/KjkjxmxxbAction_list.action';
			$('#searchForm').form('submit',{
				url: action,
				onSubmit:function(){
					var isValid = $(this).form('validate');
					if(!isValid){
						alert("请输入项目编号");
					}
					return isValid;
				},
				success:function(data){     
					var obj={};
					obj = eval('(' + data + ')');
					var rows = obj.rows;
					//alert(rows.length);
					//判断取出的专家记录是否唯一
					
					if(rows.length == 0){
						alert("系统无此项目编号，请检查输入信息");
					}
					else if(rows.length > 1){
						alert("有多个项目编号，对应多个科技项目信息");
					}
					else{
						info = rows[0];
						//alert(info.fwyy);
						//记录的主键id
						resultid = info.id;
						//alert(resultid);
						display[0].value = info.xmbh;
						display[1].value = info.xmmc;
// 						display[2].value = info.cjdws;
						display[2].value = info.dwmc;
						display[3].value = info.dwszd;
						display[4].value = info.txdz;
						display[5].value = info.yb;
						display[6].value = info.dwxz;
						display[7].value = info.sjbm;
						display[8].value = info.fzr;
						display[9].value = info.xb;
						display[10].value = info.csn;
						display[11].value = info.xl;
						display[12].value = info.zc;
						display[13].value = info.lxdh;
						display[14].value = info.email;
						display[15].value = info.xmzrs;
						
						display[16].value = info.gj;
						display[17].value = info.zj;
						display[18].value = info.cj;
						display[19].value = info.qt;
						display[20].value = info.qssj;
						display[21].value = info.zzsj;
						display[22].value = info.xmhdlx;
						display[23].value = info.ssly;
						display[24].value = info.xmjsly;
						display[25].value = info.zyyfnr;
						display[26].value = info.cgxs;
						display[27].value = info.yqzl;
						display[28].value = info.zjf;
						display[29].value = info.sbk;
						display[30].value = info.jlnf;
			
			
						var cjdwdata = {};
				
						if(info.kjkjxmxxbcjdws != null){
							cjdwdata.total = info.kjkjxmxxbcjdws.length;
							cjdwdata.rows = info.kjkjxmxxbcjdws;
						}
				
					}
					 $('#kjxmxx').propertygrid('loadData', display);
					 if(cjdwdata){
					//alert("cjdw:"+cjdwdata);
						 $('#cjdw').datagrid('loadData', cjdwdata);
					 }					 
				}   
			})
		}
		
		function deleteInfo(){
			//id不是数字
			if(isNaN(resultid)){
				$.messager.alert('删除', '请先查询确认要删除的记录', 'info');
				return;
			}
			$.messager.confirm('确认', '真的要删除该记录吗？', function(r) {
				if (r) {
					var actionPath = basePath + '/system/KjkjxmxxbAction_delete.action?id=';
					var url = actionPath + resultid;
					// 试一下get方法（地址，回调函数）
					$.get(url, function(result) {
						if (result.operateSuccess) {
							$.messager.alert('删除', '选中的记录成功删除！', 'info');
							// 重新加载
							$("#dg").datagrid('reload');
						} else {
							$.messager.alert('删除', '删除失败！', 'warning');
						}
					});
				}
			});
			
		}
		//提交基本信息表
		function update(){
			var s = 'id=' + resultid + '&';
			var action =  basePath + '/system/KjkjxmxxbAction_update.action';
			var rows = $('#kjxmxx').propertygrid('getRows');
			var changes = $('#kjxmxx').propertygrid('getChanges');
// 			if(changes.length == 0){
// 				$.messager.alert('验证', '信息未更改', 'error');
// 			}
// 			else{
				for(var i=0; i<rows.length; i++){
					if(i == rows.length-1){
						s += rows[i].id + '=' + rows[i].value;
					}
					else{
						s += rows[i].id + '=' + rows[i].value + '&';
					}
				}
			
				
				
				
				//alert(s);
				if(s.length != 0){
					$.post(action, s, function(result) {
						if (result.operateSuccess) {
								//alert(result.resultid);
								//resultid = result.resultid;
								$('#kjxmxx').propertygrid('reload');// 重新加载
								$.messager.alert('更新', '更新成功', 'info');
						} else {
								$.messager.alert('更新', '更新失败', 'warning');
							}
					});
				}
// 			}
			
			
		}


	</script>
</head>

<body>

<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm" method="post">
            <table>
                <tr>
					<th>项目编号：</th>
					<td>
                        <input class="easyui-validatebox" type="text" name="xmbh" data-options="required:true" /> 
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td> 
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0);" onclick="deleteInfo();">删除</a>
					</td>	
                </tr>
            </table>
        </form>
</div>

<div data-options="region:'center',split:false">
	
	<!-- 科技项目信息 -->
	<table id="kjxmxx" ></table>
	<br>
	<div style="text-align:center">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="update()">更新</a>
	</div>
	<br>
	<!-- 其他参加单位-->
	<table id="cjdw">
	</table>

</div>

</body>

</html>
