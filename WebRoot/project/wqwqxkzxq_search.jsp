<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>武器装备科研生产许可证需求</title>
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
            {"name": "单位名称", "group": "基本信息", "value": "", "editor": "text" },
            {"name": "其他名称", "group": "基本信息", "value": "", "editor":"text" },
            {"name": "单位代号", "value": "", "group": "基本信息", "editor":"text" },
            {"name": "军品科研生产场所地址", "group": "基本信息", "value": "", "editor": "text" },
            {"name": "经济性质", "group": "基本信息", "value": "", "editor":"text" },
            {"name": "法人代表", "value": "", "group": "基本信息", "editor":"text" },
            {"name": "单位地址", "group": "基本信息", "value": "", "editor":"text" },
            {"name": "邮政编码", "value": "", "group": "基本信息", "editor":"text" },
            {"name": "联系人", "group": "基本信息", "value": "", "editor": "text" },
            {"name": "联系电话", "group": "基本信息", "value": "", "editor":"text" },
            {"name": "在岗职工总人数", "value": "", "group": "人员构成", "editor":"text" },
            {"name": "高职管理", "group": "人员构成", "value": "", "editor": "text" },
            {"name": "中职管理", "group": "人员构成", "value": "", "editor":"text" },
            {"name": "初职管理", "value": "", "group": "人员构成", "editor":"text" },
            {"name": "高职技术", "group": "人员构成", "value": "", "editor": "text" },
            {"name": "中职技术", "group": "人员构成", "value": "", "editor": "text" },
            {"name": "初职技术", "group": "人员构成", "value": "", "editor":"text" },
            {"name": "高职工人", "value": "", "group": "人员构成", "editor":"text" },
            {"name": "中职工人", "group": "人员构成", "value": "", "editor":"text" },
            {"name": "初职工人", "value": "", "group": "人员构成", "editor":"text" },
            {"name": "国家级科技成果数", "group": "获得科技成果数量", "value": "", "editor": "text" },
            {"name": "省部级科技成果数", "group": "获得科技成果数量", "value": "", "editor":"text" },
            {"name": "单位基本情况", "value": "", "group": "其他信息", "editor":"text" },
            {"name": "单位科研方向", "group": "其他信息", "value": "", "editor": "text" },
            {"name": "企业生产纲领", "group": "其他信息", "value": "", "editor":"text" },
            {"name": "科研生产管理组织机构状况", "value": "", "group": "其他信息", "editor":"text" },
            {"name": "质量管理体系状况", "group": "其他信息", "value": "", "editor": "text" },
            {"name": "保密／安全生产／环保状况", "group": "其他信息", "value": "", "editor":"text" },
            {"name": "现有军品研发部门的科研能力和条件情况", "value": "", "group": "其他信息", "editor":"text" },
            {"name": "现有军品试验检测部门情况", "group": "其他信息", "value": "", "editor": "text" },
            {"name": "现有军品制造部门的生产能力和条件情况", "group": "其他信息", "value": "", "editor":"text" },
            {"name": "已完成的主要军品科研生产项目情况", "value": "", "group": "其他信息", "editor":"text" },
            {"name": "现承担的主要军品科研生产项目的执行情况", "group": "其他信息", "value": "", "editor": "text" }

        ];
			
		$(function() {
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
		    $('#wqzbkyscxkzxq').propertygrid('loadData', display);
			
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
				//pagination : true,//分页
				rownumbers : true,//行数
				columns:[[ 
					  {field:'year',title:'年度',editor:'text',width:100},    
					  {field:'zcz',title:'总产值（或销售收入）',editor:'text',width:100},
			          {field:'jp',title:'军品',editor:'text',width:100},    
					  {field:'mp',title:'民品',editor:'text',width:100}
			
		      ]] 
			});
			
					$('#xkzycp').datagrid({
				title : '武器装备科研生产的许可专业（产品）',
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
			var action =  basePath + '/system/WqwqxkzxqAction_list.action';
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
						var xkzycpdata = {};
			
				
						if(info.wqwqxkzxqsrqks!= null){
							srqkdata.total = info.wqwqxkzxqsrqks.length;
							srqkdata.rows = info.wqwqxkzxqsrqks;
						}
						if(info.wqwqxkzxqxkzyxkzycps!= null){
							xkzycpdata.total = info.wqwqxkzxqxkzyxkzycps.length;
							xkzycpdata.rows = info.wqwqxkzxqxkzyxkzycps;
						}
				
					}
					 $('#wqzbkyscxkzxq').propertygrid('loadData', display);
					 if(srqkdata){
						 $('#srqk').datagrid('loadData', srqkdata);
					 }
					  if(xkzycpdata){
						 $('#xkzycp').datagrid('loadData', xkzycpdata);
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
	
	<!-- 武器装备科研生产许可证需求 -->
	<table id="wqzbkyscxkzxq" ></table>
	<br>
	<div style="text-align:center">
	
	</div>
	<br>
	
	<!-- 产值或销售收入情况-->
	<table id="srqk">
	</table>
	
	<!-- 武器装备科研生产的许可专业（产品）-->
	<table id="xkzycp">
	</table>

</div>

</body>

</html>
