<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>专家信息</title>
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
		
		var display = [
	            { "name": "姓名", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "性别", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "身份证号", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "邮箱", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "技术职称", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "职务", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "工作单位", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "工作部门", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "最高学历", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "所在地区", "group": "基本信息", "value": "", "editor": "text" },
				{ "name": "行业领域", "group": "研究方向","value": "", "editor": "text"},
				{ "name": "技术领域", "group": "研究方向","value": "", "editor": "text"},
				{ "name": "学科领域", "group": "研究方向","value": "", "editor": "text"},
				{ "name": "服务意愿", "group": "其他信息","value": "", "editor": "text"},
				{ "name": "所在研发平台或实验基地", "group": "其他信息","value": "", "editor": "text"},
				{ "name": "专家简介", "group": "其他信息","value": "", "editor": "textarea"},
				{ "name": "专业特长", "group": "其他信息","value": "", "editor": "textarea"}
			]
		$(function() {
			$('#info').propertygrid({
	
		        width: 1200,
		        height: 'auto',
		        showGroup: true,
		        scrollbarSize: 0,
		        columns: [[
		                { field: 'name', title: '专家基本信息', width: 50, resizable: true },
		                { field: 'value', title: '', width: 100, resizable: false }
		        ]]
		    });
		    $('#info').propertygrid('loadData', display);
			
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
				//pagination : true,//分页
				rownumbers : true,//行数
				columns:[[ 
					  {field:'xmmc',title:'项目名称',editor:'text',width:100},    
					  {field:'hzsj',title:'合作起止时间',editor:'text',width:100},  
					  {field:'xmjj',title:'项目简介',editor:'text',width:200},
					  {field:'hzxg',title:'合作效果',width:100, edtior:'text'}
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
				columns:[[    
					{field:'cgmc',title:'成果名称',editor:'text',width:100},    
					{field:'wcsj',title:'完成时间',width:100, editor:'text'},  
					{field:'cgjj',title:'成果简介',editor:'textarea',width:100},
					{field:'zhqk',title:'转化情况',width:100, editor:'text'}    
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
				columns:[[    
					{field:'xmmc',title:'项目名称',width:100,editor:'text'},    
					{field:'wcsj',title:'预计完成时间',width:100,editor:'text'},  
					{field:'xmjj',title:'项目简介',width:100,editor:'text'},  				  
					{field:'sfzh',title:'是否转化',width:100,editor:'text'}    
				  ]] 
				});
		});	
		function doSearch(){
			var action =  basePath + '/system/KjjszjcjbAction_list.action';
			$('#searchForm').form('submit',{
				url: action,
				onSubmit:function(){
					var isValid = $(this).form('validate');
					if(!isValid){
						alert("请输入专家姓名");
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
						alert("系统无此专家信息，请检查输入信息");
					}
					else if(rows.length > 1){
						alert("专家重名，对应多个专家信息");
					}
					else{
						info = rows[0];
						//alert(info.fwyy);
						display[0].value = info.zjxm;
						display[1].value = info.xb;
						display[2].value = info.sfzh;
						display[3].value = info.yx;
						display[4].value = info.jszc;
						display[5].value = info.zw;
						display[6].value = info.gzdw;
						display[7].value = info.gzbm;
						display[8].value = info.zgxl;
						display[9].value = info.szdq;
						display[10].value = info.hyly;
						display[11].value = info.jsly;
						display[12].value = info.xkly;
						display[13].value = info.fwyy;
						display[14].value = info.szpt;
						display[15].value = info.zjjj;
						display[16].value = info.zytc;
						
						var cxydata = {};
						var jscgdata = {};
						var zydata = {};
						if(info.kjjszjcjbxms != null){
							cxydata.total = info.kjjszjcjbxms.length;
							cxydata.rows = info.kjjszjcjbxms;
						}
						if(info.kjjszjcjbcgs != null){
							jscgdata.total = info.kjjszjcjbcgs.length;
							jscgdata.rows = info.kjjszjcjbcgs;
						}
						if(info.kjjszjcjbzys != null){
							zydata.total = info.kjjszjcjbzys.length;
							zydata.rows = info.kjjszjcjbzys;
						}	
					}
					 $('#info').propertygrid('loadData', display);
					 if(cxydata){
						 $('#cxy').datagrid('loadData', cxydata);
					 }
					 if(jscgdata){
						 $('#jscg').datagrid('loadData', jscgdata);
					 }
					 if(zydata){
						 $('#zy').datagrid('loadData', zydata);
					 }
					 
				}   
			})
		}


function ShowExport(){

	  var isValid = $('#searchForm').form('validate');
					if(!isValid){
						alert("请输入专家姓名");
						return false;
					}
					//alert(isValid);

	var params =$('#searchForm').serialize();
	//alert(params);

	var showimport = basePath + '/system/KjjszjcjbAction_showexport.action';
	            				
	$.post(showimport, params, function(result) {
	        			if (result.operateSuccess) {
	        					$('#dg').datagrid('reload');// 重新加载
	        					$.messager.alert('导出', '导出Excel成功', 'info');
	        				
	        			}else {
	        					$.messager.alert('导出', '导出失败：系统无此专家信息，请检查专家姓名', 'warning');
	        				}
	        		});
  
	            	  return false;
	            	  }

function ShowImport(){}

	</script>
</head>

<body>

<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm" method="post">
            <table>
                <tr>
					<th>专家姓名：</th>
					<td>
                        <input class="easyui-validatebox" type="text" name="zjxm" data-options="required:true" /> 
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询  </a>
					    <a href="#" class="easyui-linkbutton" id="btnExport" onclick="ShowExport()" >导出Excel</a> 　
					</td>       
                </tr>
            </table>
        </form>
</div>

<!--     <form id="questionTypesManage"  method="post" enctype="multipart/form-data">   -->
<!--    选择文件：　<input type="text" id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">   -->
<!--        　　<a href="#" class="easyui-linkbutton" id="btnImport" onclick="ShowImport()" >导入</a>                        -->
<!--        <a href="#" class="easyui-linkbutton" id="btnExport" onclick="ShowExport()" >导出Excel</a> 　 -->
<!-- </form> -->


<div data-options="region:'center',split:false">
	
	<!-- 专家信息-->
	<table id="info" ></table>
	<br>
	<div style="text-align:center">
	
	</div>
	<br>
	<!-- 产学研-->
	<table id="cxy">
	</table>
	<br><br>	
	<!-- 技术成果-->
	<table id="jscg">
	</table>
	<br><br>
	<!-- 在研-->
	<table id="zy">
	</table> 

</div>

</body>

</html>
