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
		
		var display = [
            {"name": "年度", "group": "基本信息", "value": "", "editor": "text" },
            {"name": "年份", "group": "基本信息", "value": "", "editor":"text" },
            {"name": "企业名称", "value": "", "group": "基本信息", "editor":"text" },
            {"name": "纳税人识别号", "group": "基本信息", "value": "", "editor": "text" },
            {"name": "主营产品技术领域", "group": "基本信息", "value": "", "editor":"text" },
            {"name": "企业所得税主管税务机关", "value": "", "group": "基本信息", "editor":"text" },
            {"name": "职工总数", "group": "人力资源情况", "value": "", "editor":"text" },
            {"name": "人事研究开发人员数", "value": "", "group": "人力资源情况", "editor":"text" },
            {"name": "大专以上人员数", "group": "人力资源情况", "value": "", "editor": "text" },
            {"name": "近1年企业总收入", "group": "企业财务状况", "value": "", "editor":"text" },
            {"name": "第1年销售收入", "value": "", "group": "企业财务状况", "editor":"text" },
            {"name": "第2年销售总收入", "group": "企业财务状况", "value": "", "editor": "text" },
            {"name": "第3年销售总收入", "group": "企业财务状况", "value": "", "editor":"text" },
            {"name": "销售收入合计", "value": "", "group": "企业财务状况", "editor":"text" },
            {"name": "销售增长率", "group": "企业财务状况", "value": "", "editor": "text" },
            {"name": "第1 年总资产", "group": "企业财务状况", "value": "", "editor": "text" },
            {"name": "第2 年总资产", "group": "企业财务状况", "value": "", "editor":"text" },
            {"name": "第3 年总资产", "value": "", "group": "企业财务状况", "editor":"text" },
            {"name": "总资产增长率", "group": "企业财务状况", "value": "", "editor":"text" },
  
        ];
			
		$(function() {
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
				//pagination : true,//分页
				rownumbers : true,//行数
				columns:[[ 
					  {field:'xmbh',title:'项目编号',editor:'text',width:100},    
					  {field:'xmmc',title:'项目名称',editor:'text',width:100},
					  {field:'jfhj',title:'项目研发经费-合计',editor:'text',width:100},    
					  {field:'jfnb',title:'项目研发经费-内部',editor:'text',width:100},
					  {field:'jfwb',title:'项目研发经费-外部',editor:'text',width:100}
			
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
			
		      ]] 
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
					if(rows.length == 0){
						alert("系统无此企业名称，请检查输入信息");
					}
					else if(rows.length > 1){
						alert("有多个企业名称，对应多条信息");
					}
					else{
						info = rows[0];
						//alert(info.fwyy);
						display[0].value = info.year;
						display[1].value = info.nf;
						display[2].value = info.qymc;
						display[3].value = info.nssbh;
						display[4].value = info.ssly;
						display[5].value = info.zgswjg;
						display[6].value = info.zgzs;
						display[7].value = info.yjrys;
						display[8].value = info.dzrs;
						display[9].value = info.ynzsr;
						display[10].value = info.sr1;
						display[11].value = info.sr2;
						display[12].value = info.sr3;
						display[13].value = info.hj;
						display[14].value = info.xszzl;
						display[15].value = info.zc1;
						display[16].value = info.zc2;
						display[17].value = info.zc3;
						display[18].value = info.zczzl;

						
						var gxcpdata = {};
						var yfxmdata = {};
			            var zscqdata = {};
				
						if(info.kjgxqybabgxcps!= null){
							gxcpdata.total = info.kjgxqybabgxcps.length;
							gxcpdata.rows = info.kjgxqybabgxcps;
						}
						if(info.kjgxqybabxkyfxms!= null){
							yfxmdata.total = info.kjgxqybabxkyfxms.length;
							yfxmdata.rows = info.kjgxqybabxkyfxms;
						}
						if(info.kjgxqybabxkzscqs!= null){
							zscqdata.total = info.kjgxqybabxkzscqs.length;
							zscqdata.rows = info.kjgxqybabxkzscqs;
						}
				
					}
					 $('#gxjsqyrdba').propertygrid('loadData', display);
					 if(gxcpdata){
						 $('#gxcp').datagrid('loadData', gxcpdata);
					 }
					  if(yfxmdata){
						 $('#yfxm').datagrid('loadData', yfxmdata);
					 }
					 if(zscqdata){
						 $('#zscq').datagrid('loadData', zscqdata);
					 }
				}   
			})
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
                </tr>
            </table>
        </form>
</div>

<div data-options="region:'center',split:false">
	
	<!-- 高新技术企业认定备案 -->
	<table id="gxjsqyrdba" ></table>
	<br>
	<div style="text-align:center">
	
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
