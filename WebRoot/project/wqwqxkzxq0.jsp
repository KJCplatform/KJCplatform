<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >

<!-- <script src='http://10.255.1.22:8000/CLodopfuncs.js'></script> -->
<script language="javascript" type="text/javascript" src="http://localhost:8000/CLodopfuncs.js"></script>
<object  id="LODOP" classid="clsid:2105C259-1E0C-4534-8141-A753534CB4CA" width=0 height=0> 
<embed id="LODOP_EM" type="application/x-print-lodop" width=0 height=0></embed> 
</object> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>武器装备生产许可单位信息汇总</title>
    <link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
	<style type="text/css">
		#fm{
			margin:0;
			padding:10px 30px;
		}
		.ftitle{
			font-size:14px;
			font-weight:bold;
			color:#666;
			padding:5px 0;
			margin-bottom:10px;
			border-bottom:1px solid #ccc;
		}
		.fitem{
			margin-bottom:5px;
		}
		.fitem label{
			display:inline-block;
			width:80px;
		}
	</style>
	<script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/wqwqxkzxq0.js"></script>
</head>

<body>
<div style="page-break-after:always">
<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>单位名称：</th>
                    <td>
						<input id="fileName" />
					</td>
                
                    <!-- <th>许可类别：</th>
                    <td>
						<input id="xklb" />
					</td> -->
                </tr>
                <tr>
					<th>经济性质：</th>
					<td>
                        <input id="jjxz" />
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
					</td>
					<td>
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-print'" style="width:80px" onclick="print1();">打印</a>
					</td>
					<td>
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="SaveAsFile();">导出excel</a>
                </td>
                </tr>
            </table>
        </form>
</div>
 




<div data-options="region:'center',split:false">
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="dwmc" width="130">单位名称</th>
			<th field="qtmc" width="130">其他名称</th>
			<th field="dwdh" width="130">单位代号</th>
			<th field="scdz" width="130">军品科研生产场所地址</th>
			<th field="jjxz" width="130">经济性质</th>
			<th field="frdb" width="130">法人代表</th>
			<th field="dwdz" width="130">单位地址</th>
			<th field="yzbm" width="130">邮政编码</th>
			<th field="lxr" width="130">联系人</th>
			<th field="lxdh" width="130">联系电话</th>
			<th field="zgzs" width="130">在岗职工总人数</th>
			<th field="gzgl" width="130">高职管理</th>
			<th field="zzgl" width="130">中职管理</th>
			<th field="czgl" width="130">初职管理</th>
			<th field="gzjs" width="130">高职技术</th>
			<th field="zzjs" width="130">中职技术</th>
			<th field="czjs" width="130">初职技术</th>
			<th field="gzgr" width="130">高职工人</th>
			<th field="zzgr" width="130">中职工人</th>
			<th field="czgr" width="130">初职工人</th>
			<th field="gjjcgs" width="130">国家级科技成果数</th>
			<th field="sbjcgs" width="130">省部级科技成果数</th>
			
			
			
			<th field="jbqk" width="130">单位基本情况</th>
			<th field="kyfx" width="130">单位科研方向</th>
			<th field="qyscgl" width="130">企业生产纲领</th>
			<th field="kyzk" width="130">科研生产管理组织机构状况</th>
			<th field="zlglzk" width="130">质量管理体系状况</th>
			
			
			<th field="bmaqzk" width="130">保密／安全生产／环保状况</th>
			<th field="jpyfqk" width="130">现有军品研发部门的科研能力和条件情况</th>
			<th field="jpjcqk" width="130">现有军品试验检测部门情况</th>
			<th field="jpzzqk" width="130">现有军品制造部门的生产能力和条件情况</th>
			<th field="wcjpqk" width="130">已完成的主要军品科研生产项目情况</th>
			<th field="xcjpxmqk" width="130">现承担的主要军品科研生产项目的执行情况</th>
			
						<th field="name1" width="130">产值或销售收入情况</th>
									<th field="name2" width="130">武器装备科研生产的许可专业（产品）</th>
			 
			<!--  <th field="jlnf" width="130">记录时间(年份)</th>
			        <th field="username" width="130">操作员</th>
			        <th field="gxsj" width="130">更新时间</th>
			        <th field="submit" width="130">是否提交</th> -->
			
			
		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:800px; height:400px; overflow:auto;" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>单位名称:</dd>
				<dd><input size="15" id="dwmc" name="dwmc" /></dd>
			</dl>
			<dl>
				<dd>其他名称:</dd>
				<dd><input size="15" id="qtmc" name="qtmc" /></dd>
			</dl>
			<dl>
				<dd>单位代号:</dd>
				<dd><input size="15" id="dwdh" name="dwdh" /></dd>
			</dl>
			<dl>
				<dd>军品科研生产场所地址:</dd>
				<dd><input size="15" id="scdz" name="scdz" /></dd>
			</dl>
			<dl>
				<dd>经济性质:</dd>
				<dd><input size="15" id="jjxz" name="jjxz" /></dd>
			</dl>
			<dl>
				<dd>法人代表:</dd>
				<dd><input size="15" id="frdb" name="frdb" /></dd>
			</dl>
			<dl>
				<dd>单位地址:</dd>
				<dd><input size="15" id="dwdz" name="dwdz" /></dd>
			</dl>
			<dl>
				<dd>邮政编码:</dd>
				<dd><input size="15" id="yzbm" name="yzbm" /></dd>
			</dl>
			<dl>
				<dd>联系人:</dd>
				<dd><input size="15" id="lxr" name="lxr" /></dd>
			</dl>
			<dl>
				<dd>联系电话:</dd>
				<dd><input size="15" id="lxdh" name="lxdh" /></dd>
			</dl>
			<dl>
				<dd>在岗职工总人数:</dd>
				<dd><input size="15" id="zgzs" name="zgzs" /></dd>
			</dl>
			<dl>
				<dd>高职管理:</dd>
				<dd><input size="15" id="gzgl" name="gzgl" /></dd>
			</dl>
			
			<dl>
				<dd>中职管理:</dd>
				<dd><input size="15" id="zzgl" name="zzgl" /></dd>
			</dl>
			<dl>
				<dd>初职管理:</dd>
				<dd><input size="15" id="czgl" name="czgl" /></dd>
			</dl>
			<dl>
				<dd>高职技术:</dd>
				<dd><input size="15" id="gzjs" name="gzjs" /></dd>
			</dl>
			<dl>
				<dd>中职技术:</dd>
				<dd><input size="15" id="zzjs" name="zzjs" /></dd>
			</dl>
			<dl>
				<dd>初职技术:</dd>
				<dd><input size="15" id="czjs" name="czjs" /></dd>
			</dl>
			<dl>
				<dd>高职工人:</dd>
				<dd><input size="15" id="gzgr" name="gzgr" /></dd>
			</dl>
			<dl>
				<dd>中职工人:</dd>
				<dd><input size="15" id="zzgr" name="zzgr" /></dd>
			</dl>
			<dl>
				<dd>初职工人:</dd>
				<dd><input size="15" id="czgr" name="czgr" /></dd>
			</dl>
			<dl>
				<dd>国家级科技成果数:</dd>
				<dd><input size="15" id="gjjcgs" name="gjjcgs" /></dd>
			</dl>
			<dl>
				<dd>省部级科技成果数:</dd>
				<dd><input size="15" id="sbjcgs" name="sbjcgs" /></dd>
			</dl>
			<dl>
				<dd>单位基本情况:</dd>
				<dd><input size="15" id="jbqk" name="jbqk" /></dd>
			</dl>
			<dl>
				<dd>单位科研方向:</dd>
				<dd><input size="15" id="kyfx" name="kyfx" /></dd>
			</dl>
			
			
			<dl>
				<dd>企业生产纲领:</dd>
				<dd><input size="15" id="qyscgl" name="qyscgl" /></dd>
			</dl>
			<dl>
				<dd>科研生产管理组织机构状况:</dd>
				<dd><input size="15" id="kyzk" name="kyzk" /></dd>
			</dl>
			<dl>
				<dd>质量管理体系状况:</dd>
				<dd><input size="15" id="zlglzk" name="zlglzk" /></dd>
			</dl>
			
			
			<dl>
				<dd>保密／安全生产／环保状况:</dd>
				<dd><input size="15" id="bmaqzk" name="bmaqzk" /></dd>
			</dl>
			<dl>
				<dd>现有军品研发部门的科研能力和条件情况:</dd>
				<dd><input size="15" id="jpyfqk" name="jpyfqk" /></dd>
			</dl>
			<dl>
				<dd>现有军品试验检测部门情况:</dd>
				<dd><input size="15" id="jpjcqk" name="jpjcqk" /></dd>
			</dl>
			<dl>
				<dd>现有军品制造部门的生产能力和条件情况:</dd>
				<dd><input size="15" id="jpzzqk" name="jpzzqk" /></dd>
			</dl>
			<dl>
				<dd>已完成的主要军品科研生产项目情况:</dd>
				<dd><input size="15" id="wcjpqk" name="wcjpqk" /></dd>
			</dl>
			<dl>
				<dd>现承担的主要军品科研生产项目的执行情况:</dd>
				<dd><input size="15" id="xcjpxmqk" name="xcjpxmqk" /></dd>
			</dl>
			
			
			
			
			<!--   <dl>
				<dd>记录时间:</dd>
				<dd><input size="15" id="jlnf" name="jlnf" /></dd>
			</dl>
			<dl>
				<dd>操作员:</dd>
				<dd><input size="15" id="username" name="username" /></dd>
			</dl>
			<dl>
				<dd>更新时间:</dd>
				<dd><input size="15" id="gxsj" name="gxsj" /></dd>
			</dl>
			<dl>
				<dd>是否提交:</dd>
				<dd>
				<select style="width: 150px" id="submit" name="submit" >
				<option value="是">是</option>
				<option value="否">否</option>
				
				</dd>
			</dl>  -->
		</form>
	</div>
</div>	
</div>
</body>

</html>
