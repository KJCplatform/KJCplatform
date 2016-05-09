<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>高新技术企业认定备案</title>
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
            {"id":"year", "name": "年度", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"nf", "name": "年份", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"qymc", "name": "企业名称", "value": "", "group": "基本信息", "editor":"text" },
            {"id":"nssbh", "name": "纳税人识别号", "group": "基本信息", "value": "", "editor": "text" },
            {"id":"ssly", "name": "主营产品技术领域", "group": "基本信息", "value": "", "editor":"text" },
            {"id":"zgswjg", "name": "企业所得税主管税务机关", "value": "", "group": "基本信息", "editor":"text" },
//             {"id":"zgzs", "name": "职工总数", "group": "人力资源情况", "value": "", "editor":{
//             	"type": 'numberbox', 
//             } },
            {"id":"yjrys", "name": "从事研究开发人员数", "value": "", "group": "人力资源情况", "editor":{
            	"type": 'numberbox', 
            } },
            {"id":"dzrs", "name": "大专以上人员数", "group": "人力资源情况", "value": "", "editor": {
            	"type": 'numberbox', 
            } },
//             {"id":"ynzsr", "name": "近1年企业总收入", "group": "企业财务状况", "value": "", "editor":"text" },
            {"id":"sr1", "name": "第1年销售收入", "value": "", "group": "企业财务状况", "editor":"text" },
            {"id":"sr2", "name": "第2年销售总收入", "group": "企业财务状况", "value": "", "editor": "text" },
            {"id":"sr3", "name": "第3年销售总收入", "group": "企业财务状况", "value": "", "editor":"text" },
//             {"id":"hj", "name": "销售收入合计", "value": "", "group": "企业财务状况", "editor":"text" },
//             {"id":"xszzl", "name": "销售增长率", "group": "企业财务状况", "value": "", "editor": "text" },
            {"id":"zc1", "name": "第1 年总资产", "group": "企业财务状况", "value": "", "editor": "text" },
            {"id":"zc2", "name": "第2 年总资产", "group": "企业财务状况", "value": "", "editor":"text" },
            {"id":"zc3", "name": "第3 年总资产", "value": "", "group": "企业财务状况", "editor":"text" },
//             {"id":"zczzl", "name": "总资产增长率", "group": "企业财务状况", "value": "", "editor":"text" },
              {"id":"jlnf", "name": "记录时间（年份） ", "group": "其他信息", "value": "", "editor": "text" },
         
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
		    $('#gxjsqyrdba').propertygrid('loadData', display);
			
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
				//pagination : true,//分页
				rownumbers : true,//行数
				columns:[[ 
					  {field:'cpbh',title:'产品编号',editor:'text',width:100},    
					  {field:'cpmc',title:'项目（服务）名称',editor:'text',width:100},
			          {field:'shsr',title:'上年度销售收入',editor:'text',width:100},    
					 
		      ]] ,
		      
		      toolbar:[   {// 工具栏
					text : '添加',
					iconCls : 'icon-add', // 图标
					handler : function() { // 处理函数
						$('#gxcp').datagrid('endEdit', lastIndex);
						$('#gxcp').datagrid('appendRow',{
							xh:'',
							dwmc:''
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
// 								if(rows.length != 0){
									for(i=0; i<rows.length; i++) {
										rows[i].id = resultid;
									}
									//alert(resultid);
									var data = {'gxcpform': JSON.stringify(rows)};
	//								alert(rows);
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
								
// 							}
				}]
		      
		      
		      
		      
		      
		      
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
				//pagination : true,//分页
				rownumbers : true,//行数
				columns:[[ 
					  {field:'xmbh',title:'项目编号',editor:'text',width:100},    
					  {field:'xmmc',title:'项目名称',editor:'text',width:100},
					  {field:'jfhj',title:'项目研发经费-合计',editor:'text',width:100},    
					  {field:'jfnb',title:'项目研发经费-内部',editor:'text',width:100},
					  {field:'jfwb',title:'项目研发经费-外部',editor:'text',width:100}
			
		      ]],
		      	toolbar:[   {// 工具栏
					text : '添加',
					iconCls : 'icon-add', // 图标
					handler : function() { // 处理函数
						$('#yfxm').datagrid('endEdit', lastIndex);
						$('#yfxm').datagrid('appendRow',{
							xh:'',
							dwmc:''
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
// 								if(rows.length != 0){
									for(i=0; i<rows.length; i++) {
										rows[i].id = resultid;
									}
									//alert(resultid);
									var data = {'yfxmform': JSON.stringify(rows)};
	//								alert(rows);
									$.post(action, data, function(result){
										if (result.operateSuccess) {
										//alert(result);
											$('#yfxm').datagrid('reload');// 重新加载
											$.messager.alert('提交', '提交成功', 'info');
										} else {
											$.messager.alert('提交', '提交失败', 'warning');
										}
									}); 
// 								}
							}
				}]
		       
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
				//pagination : true,//分页
				rownumbers : true,//行数
				columns:[[ 
					  {field:'xmbh',title:'项目编号',editor:'text',width:100},    
					  {field:'sqmc',title:'授权项目名称',editor:'text',width:100},
					  {field:'lb',title:'类别',editor:'text',width:100},    
					  {field:'sqh',title:'授权号',editor:'text',width:100},
					  {field:'sqrq',title:'授权日期',width:100,editor:{
						type:'datebox',
						required: true
					}
					}
			
		      ]],
		      	toolbar:[   {// 工具栏
					text : '添加',
					iconCls : 'icon-add', // 图标
					handler : function() { // 处理函数
						$('#zscq').datagrid('endEdit', lastIndex);
						$('#zscq').datagrid('appendRow',{
							xh:'',
							dwmc:''
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
// 								if(rows.length != 0){
									for(i=0; i<rows.length; i++) {
										rows[i].id = resultid;
									}
									//alert(resultid);
									var data = {'zscqform': JSON.stringify(rows)};
								
									$.post(action, data, function(result){
										if (result.operateSuccess) {
										//alert(result);
											$('#zscq').datagrid('reload');// 重新加载
											$.messager.alert('提交', '提交成功', 'info');
										} else {
											$.messager.alert('提交', '提交失败', 'warning');
										}
									}); 
// 								}
							}
				}] 
			});
			
		});	
		
		
		
		function doSearch(){
			var action =  basePath + '/system/KjgxqybabAction_list.action';
			$('#searchForm').form('submit',{
				url: action,
				onSubmit:function(){
					var isValid = $(this).form('validate');
					if(!isValid){
						alert("请输入企业名称");
					}
					return isValid;
				},
				success:function(data){     
					var obj={};
					obj = eval('(' + data + ')');
					var rows = obj.rows;
					//alert(rows.length);
					//判断取出的专家记录是否唯一
					
					if(rows.length > 1){
						alert("有多个企业名称，对应多条信息");
					}
					if(rows.length == 0){
						alert("系统无此企业名称，请检查输入信息");
						
					}
					
					else{
						info = rows[0];
						//alert(info.fwyy);
						resultid = info.id;
						display[0].value = info.year;
						display[1].value = info.nf;
						display[2].value = info.qymc;
						display[3].value = info.nssbh;
						display[4].value = info.ssly;
						display[5].value = info.zgswjg;
// 						display[6].value = info.zgzs;
						display[6].value = info.yjrys;
						display[7].value = info.dzrs;
// 						display[9].value = info.ynzsr;
						display[8].value = info.sr1;
						display[9].value = info.sr2;
						display[10].value = info.sr3;
// 						display[13].value = info.hj;
// 						display[14].value = info.xszzl;
						display[11].value = info.zc1;
						display[12].value = info.zc2;
						display[13].value = info.zc3;
// 						display[18].value = info.zczzl;
			            display[14].value = info.jlnf;
			            
// 						display[20].value = info.username;
// 						display[21].value = info.gxsj;
						//display[22].value = info.submit;
						
						var gxcpdata = {};
						var yfxmdata = {};
			            var zscqdata = {};
				
						if(info.kjgxqybabgxcps!= null){
							gxcpdata.total = info.kjgxqybabgxcps.length;
							gxcpdata.rows = info.kjgxqybabgxcps;
						}
						if(info.kjgxqybabyfxms!= null){
							yfxmdata.total = info.kjgxqybabyfxms.length;
							yfxmdata.rows = info.kjgxqybabyfxms;
						}
						if(info.kjgxqybabzscqs!= null){
							zscqdata.total = info.kjgxqybabzscqs.length;
							zscqdata.rows = info.kjgxqybabzscqs;
						}
				
					}
					 $('#gxjsqyrdba').propertygrid('loadData', display);
					 if(gxcpdata){
					// alert("1");
						 $('#gxcp').datagrid('loadData', gxcpdata);
					 }
					  if(yfxmdata){
					//   alert("2");
						 $('#yfxm').datagrid('loadData', yfxmdata);
					 }
					 if(zscqdata){
					 // alert("3");
						 $('#zscq').datagrid('loadData', zscqdata);
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
					var actionPath = basePath + '/system/KjgxqybabAction_delete.action?id=';
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
			var action =  basePath + '/system/KjgxqybabAction_update.action';
			var rows = $('#gxjsqyrdba').propertygrid('getRows');
			var changes = $('#gxjsqyrdba').propertygrid('getChanges');
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
								$('#gxjsqyrdba').propertygrid('reload');// 重新加载
								$.messager.alert('更新', '更新成功', 'info');
						} else {
								$.messager.alert('更新', '更新失败', 'warning');
							}
					});
				}
// 			}
			
			
		}
        
        
        
        
        
        
        
        function ShowExport(){

      var isValid = $('#searchForm').form('validate');
                    if(!isValid){
                        alert("请输入企业名称");
                        return false;
                    }
                    //alert(isValid);

    var params =$('#searchForm').serialize();
    //alert(params);

    var showimport = basePath + '/system/KjgxqybabAction_showexport.action';
                                
    $.post(showimport, params, function(result) {
                        if (result.operateSuccess) {
                                $('#dg').datagrid('reload');// 重新加载
                                $.messager.alert('导出', '导出Excel成功', 'info');
                            
                        }else {
                                $.messager.alert('导出', '导出失败：系统无此企业认定备案信息，请检查企业名称', 'warning');
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
					<th>企业名称：</th>
					<td>
                        <input class="easyui-validatebox" type="text" name="qymc" data-options="required:true" /> 
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td>       
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0);" onclick="deleteInfo();">删除</a>
					</td>
                        <td>
                       <a href="#" class="easyui-linkbutton" id="btnExport" onclick="ShowExport()" >导出Excel</a> 　
                    </td>  	
                </tr>
            </table>
        </form>
</div>

<div data-options="region:'center',split:false">
	
	<!-- 高新技术企业认定备案 -->
	<table id="gxjsqyrdba" ></table>
	<br>
	<div style="text-align:center">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="update()">更新</a>
	
	</div>
	<br>
	
	<!-- 上年度高新技术产品（服务）情况-->
	<table id="gxcp">
	</table>
	
	<!-- 企业研究开发项目情况-->
	<table id="yfxm">
	</table>
	
	<!-- 近3年内获得的自主知识产权情况）-->
	<table id="zscq">
	</table>

</div>

</body>

</html>
