<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>军工单位基本情况</title>
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
              {"id":"dwmc", "name": "单位名称", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"qtmc", "name": "其他名称", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"dwdh", "name": "单位代号", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"scdz", "name": "军品科研生产场所地址", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"jjxz", "name": "经济性质", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"frdb", "name": "法人代表", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"dwdz", "name": "单位地址", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"yzbm", "name": "邮政编码", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"lxr", "name": "联系人", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"lxdh", "name": "联系电话", "group": "基本信息", "value": "", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"zgzs", "name": "在岗职工总人数", "value": "", "group": "人员构成", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"gzgl", "name": "高职管理", "group": "人员构成", "value": "", "editor": "text" },
            {"id":"zzgl", "name": "中职管理", "group": "人员构成", "value": "", "editor":"text" },
            {"id":"czgl", "name": "初职管理", "value": "", "group": "人员构成", "editor":"text" },
            {"id":"gzjs", "name": "高职技术", "group": "人员构成", "value": "", "editor": "text" },
            {"id":"zzjs", "name": "中职技术", "group": "人员构成", "value": "", "editor": "text" },
            {"id":"czjs", "name": "初职技术", "group": "人员构成", "value": "", "editor":"text" },
            {"id":"gzgr", "name": "高职工人", "value": "", "group": "人员构成", "editor":"text" },
            {"id":"zzgr", "name": "中职工人", "group": "人员构成", "value": "", "editor":"text" },
            {"id":"czgr", "name": "初职工人", "value": "", "group": "人员构成", "editor":"text" },
            {"id":"gjjcgs", "name": "国家级科技成果数", "group": "获得科技成果数量", "value": "", "editor": {
            	"type": 'numberbox', 
            } },
            {"id":"sbjcgs", "name": "省部级科技成果数", "group": "获得科技成果数量", "value": "", "editor":{
            	"type": 'numberbox', 
            } },

            {"id":"jlz", "name": "计量站", "group": "其他信息", "value": "", "editor": "text" },
            {"id":"jlbzsl", "name": "建立计量标准数量", "group": "其他信息", "value": "", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"jpkyrw", "name": "主要军品科研生产任务", "value": "", "group": "其他信息", "editor":"text" },
            {"id":"gjsyssl", "name": "国家级实验室数量", "group": "其他信息", "value": "", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"gfsyssl", "name": "国防实验室数量", "value": "", "group": "其他信息", "editor":{
            	"type": 'numberbox', 
            } },
                        {"id":"jlnf", "name": "记录时间（年份） ", "group": "其他信息", "value": "", "editor": "text" },
            {"id":"username", "name": "操作员", "group": "其他信息", "value": "", "editor":"text" },
            {"id":"gxsj", "name": "更新时间", "value": "", "group": "其他信息", "editor":"text" },
            {"id":"submit", "name": "是否提交", "group": "其他信息", "value": "", "editor": "text" }
        ];
			
		$(function() {
			var lastIndex;
			$('#jgdwjbqk').propertygrid({
	
		        width: 1000,
		        height: 'auto',
		        showGroup: true,
		        scrollbarSize: 0,
		        columns: [[
		                { field: 'name', title: '军工单位基本情况', width: 50, resizable: true },
		                { field: 'value', title: '', width: 100, resizable: false }
		        ]]
		    });
		    $('#jgdwjbqk').propertygrid('loadData', display);
			
			$('#srqk').datagrid({
				title : '产值或销售收入情况',
				width : 1000,
				height: 400,
				fitColumns : true, // 自动适应列宽      
				pageSize : 5,//默认选择的分页是每页5行数据
				pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
				nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
				toolbar:"#toolbar",
				//url:actionPath,
				//pagination : true,//分页
				rownumbers : true,//行数
				columns:[[ 
					  {field:'year',title:'年度',editor:'text',width:100},    
					  {field:'zcz',title:'总产值（或销售收入）',editor:'text',width:100},
			          {field:'jp',title:'军品',editor:'text',width:100},    
					  {field:'mp',title:'民品',editor:'text',width:100}
			
		      ]],
		     toolbar:[   {// 工具栏
					text : '添加',
					iconCls : 'icon-add', // 图标
					handler : function() { // 处理函数
						$('#srqk').datagrid('endEdit', lastIndex);
						$('#srqk').datagrid('appendRow',{
							xh:'',
							dwmc:''
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

								var action = basePath + '/system/JpjgdwjbqkAction_addsrqk.action';

								var rows = $('#srqk').datagrid('getRows');
								if(rows.length != 0){
									for(i=0; i<rows.length; i++) {
										rows[i].id = resultid;
									}
									//alert(resultid);
									var data = {'srqkform': JSON.stringify(rows)};
	//								alert(rows);
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
				}] 
		      
			});
			
					$('#ry').datagrid({
				title : '武器装备科研生产的许可专业（产品）',
				width : 1000,
				height: 400,
				fitColumns : true, // 自动适应列宽      
				pageSize : 5,//默认选择的分页是每页5行数据
				pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
				nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
				toolbar:"#toolbar",
				//url:actionPath,
				//pagination : true,//分页
				rownumbers : true,//行数
				columns:[[ 
					  {field:'bmzw',title:'部门及职务',editor:'text',width:100},    
					  {field:'xm',title:'姓名',editor:'text',width:100},
					  {field:'bgdh',title:'办公电话',editor:'text',width:100},    
					  {field:'sj',title:'手机',editor:'text',width:100}
			
		      ]],
		     toolbar:[   {// 工具栏
					text : '添加',
					iconCls : 'icon-add', // 图标
					handler : function() { // 处理函数
						$('#ry').datagrid('endEdit', lastIndex);
						$('#ry').datagrid('appendRow',{
							xh:'',
							dwmc:''
						})
						lastIndex = $('#ry').datagrid('getRows').length-1;
						$('#ry').datagrid('selectRow',lastIndex);
						$('#ry').datagrid('beginEdit',lastIndex);	
						
					}
				},'-',{
					
						text:'删除',
						iconCls:'icon-remove',
						handler:function(){
							var row = $('#ry').datagrid('getSelected');
							if (row){
								var index = $('#ry').datagrid('getRowIndex', row);
								$('#ry').datagrid('deleteRow', index);
							}
							else{
								$.messager.alert('删除', '请先选中要删除的记录', 'info');
							}
						}
					
					},'-',{
					text : "编辑",
					iconCls : "icon-edit",
					handler : function() {
						var row = $('#ry').datagrid('getSelected');
						if (row) {
							var rowIndex = $('#ry').datagrid('getRowIndex', row);
							$('#ry').datagrid('beginEdit', rowIndex);
						}
						else{
								$.messager.alert('编辑', '请先选中要编辑的记录', 'info');
							}
					}
					},'-',{
					text : '保存',
					iconCls : 'icon-save',// 图标
					handler : function() {// 处理函数
						$('#ry').datagrid('acceptChanges');
					}
					},'-',{	
						text : '提交',
						iconCls : 'icon-ok',// 图标
						handler : function() {// 处理函数

								var action = basePath + '/system/JpjgdwjbqkAction_addry.action';

								var rows = $('#ry').datagrid('getRows');
								if(rows.length != 0){
									for(i=0; i<rows.length; i++) {
										rows[i].id = resultid;
									}
									//alert(resultid);
									var data = {'ryform': JSON.stringify(rows)};
	//								alert(rows);
									$.post(action, data, function(result){
										if (result.operateSuccess) {
										//alert(result);
											$('#ry').datagrid('reload');// 重新加载
											$.messager.alert('提交', '提交成功', 'info');
										} else {
											$.messager.alert('提交', '提交失败', 'warning');
										}
									}); 
								}
							}
				}]
			});
			
		});	
		
		
		
		function doSearch(){
			var action =  basePath + '/system/JpjgdwjbqkAction_list.action';
			$('#searchForm').form('submit',{
				url: action,
				onSubmit:function(){
					var isValid = $(this).form('validate');
					if(!isValid){
						alert("请输入单位名称");
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
						alert("系统无此单位名称，请检查输入信息");
					}
					else if(rows.length > 1){
						alert("有多个单位名称，对应多条信息");
					}
					else{
						info = rows[0];
						//alert(info.fwyy);
							resultid = info.id;
						display[0].value = info.dwmc;
						display[1].value = info.qtmc;
						display[2].value = info.dwdh;
						display[3].value = info.scdz;
						display[4].value = info.jjxz;
						display[5].value = info.frdb;
						display[6].value = info.dwdz;
						display[7].value = info.yzbm;
						display[8].value = info.lxr;
						display[9].value = info.lxdh;
						display[10].value = info.zgzs;
						display[11].value = info.gzgl;
						display[12].value = info.zzgl;
						display[13].value = info.czgl;
						display[14].value = info.gzjs;
						display[15].value = info.zzjs;
						display[16].value = info.czjs;
						display[17].value = info.gzgr;
						display[18].value = info.zzgr;
						display[19].value = info.czgr;
						display[20].value = info.gjjcgs;
						display[21].value = info.sbjcgs;
						
						display[22].value = info.jlz;
						display[23].value = info.jlbzsl;
						display[24].value = info.jpkyrw;
						display[25].value = info.gjsyssl;
						display[26].value = info.gfsyssl;
			            
			            display[27].value = info.jlnf;
						display[28].value = info.username;
						display[29].value = info.gxsj;
						display[30].value = info.submit;
						
						var srqkdata = {};
						var rydata = {};
			
				
						if(info.jpjgdwjbqksrqks!= null){
							srqkdata.total = info.jpjgdwjbqksrqks.length;
							srqkdata.rows = info.jpjgdwjbqksrqks;
						}
						if(info.jpjgdwjbqkrys!= null){
							rydata.total = info.jpjgdwjbqkrys.length;
							rydata.rows = info.jpjgdwjbqkrys;
						}
				
					}
					 $('#jgdwjbqk').propertygrid('loadData', display);
					 if(srqkdata){
						 $('#srqk').datagrid('loadData', srqkdata);
					 }
					  if(rydata){
						 $('#ry').datagrid('loadData', rydata);
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
					var actionPath = basePath + '/system/JpjgdwjbqkAction_delete.action?id=';
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
			var action =  basePath + '/system/JpjgdwjbqkAction_update.action';
			var rows = $('#jgdwjbqk').propertygrid('getRows');
			var changes = $('#jgdwjbqk').propertygrid('getChanges');
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
								$('#jgdwjbqk').propertygrid('reload');// 重新加载
								$.messager.alert('更新', '更新成功', 'info');
						} else {
								$.messager.alert('更新', '更新失败', 'warning');
							}
					});
				}
// 			}
			
			
		}
		
		function ShowExport(){

			var showimport = basePath + '/system/JpjgdwjbqkAction_showexport.action';
			            				
			$.post(showimport, function(result) {
			        			if (result.operateSuccess) {
			        					$('#dg').datagrid('reload');// 重新加载
			        					$.messager.alert('导出', '导出Excel成功', 'info');
			        				
			        			}else {
			        					$.messager.alert('导出', '文件被占用！导出Excel失败', 'warning');
			        				}
			        		});
		  
			            	  return false;
			   }



	</script>
</head>

<body>

<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm" method="post">
            <table>
                <tr>
					<th>单位名称：</th>
					<td>
                        <input class="easyui-validatebox" type="text" name="dwmc" data-options="required:true" /> 
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td>      
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0);" onclick="deleteInfo();">删除</a>
					</td>	 
					<td>
						<a href="#" class="easyui-linkbutton" id="btnExport" onclick="ShowExport()" >导出</a>      
					</td>
                </tr>
            </table>
        </form>
</div>


<div data-options="region:'center',split:false">
	
	<!-- 军工单位基本情况 -->
	<table id="jgdwjbqk" ></table>
	<br>
	<div style="text-align:center">
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="update()">更新</a>
	
	</div>
	<br>
	
	<!-- 产值或销售收入情况-->
	<table id="srqk">
	</table>
	
	<!-- 武器装备科研生产的许可专业（产品）-->
	<table id="ry">
	</table>

</div>

</body>

</html>
