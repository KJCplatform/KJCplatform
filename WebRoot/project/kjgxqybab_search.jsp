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
	
		        width: 1200,
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
					  {field:'cpbh',title:'产品编号',editor:'text',width:100},    
					  {field:'cpmc',title:'项目（服务）名称',editor:'text',width:100},
			          {field:'shsr',title:'上年度销售收入',editor:'text',width:100},    
					 
		      ]] 
			});
			
					$('#yfxm').datagrid({
				title : '企业研究开发项目情况',
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
					  {field:'xmbh',title:'项目编号',editor:'text',width:100},    
					  {field:'',title:'项目名称',editor:'text',width:100},
					  {field:'jfhj',title:'项目研发经费-合计',editor:'text',width:100},    
					  {field:'jfnb',title:'项目研发经费-内部',editor:'text',width:100},
					  {field:'jfwb',title:'项目研发经费-外部',editor:'text',width:100}
			
		      ]] 
			});
			
					$('#zscq').datagrid({
				title : '近3年内获得的自主知识产权情况',
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
					  {field:'xmdm',title:'项目代码',editor:'text',width:100},    
					  {field:'xmmc',title:'项目名称',editor:'text',width:100},
					  {field:'kysc',title:'科研/生产',editor:'text',width:100},    
					  {field:'xklx',title:'许可类型',editor:'text',width:100}
			
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
						display[22].value = info.jbqk;
						display[23].value = info.kyfx;
						display[24].value = info.qyscgl;
						display[25].value = info.kyzk;
						display[26].value = info.zlglzk;
						display[27].value = info.bmaqzk;
						display[28].value = info.jpyfqk;
						display[29].value = info.jpjcqk;
						display[30].value = info.jpzzqk;
						display[31].value = info.wcjpqk;
						display[32].value = info.xcjpxmqk;
						
						var srqkdata = {};
						var cpdata = {};
			
				
						if(info.wqwqxkzxqsrqks!= null){
							srqkdata.total = info.wqwqxkzxqsrqks.length;
							srqkdata.rows = info.wqwqxkzxqsrqks;
						}
						if(info.wqwqxkzxqxkzycps!= null){
							cpdata.total = info.wqwqxkzxqxkzycps.length;
							cpdata.rows = info.wqwqxkzxqxkzycps;
						}
				
					}
					 $('#gxjsqyrdba').propertygrid('loadData', display);
					 if(srqkdata){
						 $('#srqk').datagrid('loadData', srqkdata);
					 }
					  if(cpdata){
						 $('#cp').datagrid('loadData', cpdata);
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
					<th>单位名称：</th>
					<td>
                        <input class="easyui-validatebox" type="text" name="dwmc" data-options="required:true" /> 
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
	
	<!-- 产值或销售收入情况-->
	<table id="srqk">
	</table>
	
	<!-- 武器装备科研生产的许可专业（产品）-->
	<table id="cp">
	</table>

</div>

</body>

</html>