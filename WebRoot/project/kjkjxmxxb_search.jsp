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
		
		var display = [
            {"name": "项目编号", "group": "基本信息", "value": "", "editor":"text"},
            {"name": "项目名称", "group": "基本信息", "value": "", "editor":"text" },
            {"name": "参加单位总数", "value": "", "group": "基本信息", "editor":"text" },
            {"name": "承担单位名称", "group": "项目承担单位", "value": "", "editor": "text" },
            {"name": "单位所在地", "group": "项目承担单位", "value": "", "editor":"text" },
            {"name": "通讯地址", "value": "", "group": "项目承担单位", "editor":"text" },
            {"name": "邮编", "group": "项目承担单位", "value": "", "editor":"text" },
            {"name": "单位性质", "group": "项目承担单位", "value": "", "editor":"text" },
            {"name": "上级行政主管部门", "value": "", "group": "项目承担单位", "editor":"text" },
            {"name": "项目负责人姓名", "group": "项目负责人", "value": "", "editor": "text" },
            {"name": "性别", "group": "项目负责人", "value": "", 	"editor":"text" },
            {"name": "出生年", "value": "", "group": "项目负责人", "editor":"text" },
            {"name": "学历", "group": "项目负责人", "value": "","editor":"text" },
            {"name": "职称", "group": "项目负责人", "value": "", "editor":"text" },
            {"name": "联系电话", "value": "", "group": "项目负责人", "editor":"text" },
            {"name": "Email", "group": "项目负责人", "value": "", "editor":"text" },
            {"name": "总人数", "group": "项目组人数", "value": "", "editor":"text" },
            {"name": "高级", "value": "", "group": "项目组人数", "editor":"text" },
            {"name": "中级", "group": "项目组人数", "value": "", "editor": "text" },
            {"name": "初级", "group": "项目组人数", "value": "", "editor":"text" },
            {"name": "其他", "value": "", "group": "项目组人数", "editor":"text" },
            {"name": "起始时间", "group": "其他信息", "value": "", "editor": "text" },
            {"name": "终止时间", "group": "其他信息", "value": "", "editor":"text" },
            {"name": "项目活动类型", "value": "", "group": "其他信息", "editor":"text" },
            {"name": "所属领域", "group": "其他信息", "value": "", "editor":"text" },
            {"name": "项目技术来源", "group": "其他信息", "value": "", "editor":"text" },
            {"name": "主要研发内容", "value": "", "group": "其他信息", "editor":"text" },
            {"name": "预期成果形式", "group": "其他信息", "value": "", "editor":"text" },
            {"name": "预期取得专利", "group": "其他信息", "value": "", "editor":"text" },
            {"name": "总经费", "value": "", "group": "经费投入", "editor":"text" },
            {"name": "省拨款", "group": "经费投入", "value": "", "editor": "text" }

            
        ];
			
		$(function() {
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
				//pagination : true,//分页
				rownumbers : true,//行数
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
						display[0].value = info.xmbh;
						display[1].value = info.xmmc;
						display[2].value = info.cjdws;
						display[3].value = info.dwmc;
						display[4].value = info.dwszd;
						display[5].value = info.txdz;
						display[6].value = info.yb;
						display[7].value = info.dwxz;
						display[8].value = info.sjbm;
						display[9].value = info.fzr;
						display[10].value = info.xb;
						display[11].value = info.csn;
						display[12].value = info.xl;
						display[13].value = info.zc;
						display[14].value = info.lxdh;
						display[15].value = info.email;
						display[16].value = info.xmzrs;
						
						display[17].value = info.gj;
						display[18].value = info.zj;
						display[19].value = info.cj;
						display[20].value = info.qt;
						display[21].value = info.qssj;
						display[22].value = info.zzsj;
						display[23].value = info.xmhdlx;
						display[24].value = info.ssly;
						display[25].value = info.xmjsly;
						display[26].value = info.zyyfnr;
						display[27].value = info.cgxs;
						display[28].value = info.yqzl;
						display[29].value = info.zjf;
						display[30].value = info.sbk;
						
						var cjdwdata = {};
				
						if(info.Kjkjxmxxbcjdws != null){
							cjdwdata.total = info.Kjkjxmxxbcjdws.length;
							cjdwdata.rows = info.Kjkjxmxxbcjdws;
						}
				
					}
					 $('#kjxmxx').propertygrid('loadData', display);
					 if(cjdwdata){
						 $('#cjdw').datagrid('loadData', cjdwdata);
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
					<th>项目编号：</th>
					<td>
                        <input class="easyui-validatebox" type="text" name="xmbh" data-options="required:true" /> 
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
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
	
	</div>
	<br>
	<!-- 其他参加单位-->
	<table id="cjdw">
	</table>

</div>

</body>

</html>
