<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>数字框</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/kjndgxqybab.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>企业名称：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>纳税人识别号：</th>
					<td>
                        <input id="fileId" />
					</td>
					<td>
						<a class="easyui-linkbutton" data-options="iconCls:'icon-search'" href="javascript:void(0);" onclick="doSearch();">查询</a>
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
			<th field="year" width="130">年度</th>
			<th field="nf" width="130">年份</th>
			<th field="qymc" width="130">企业名称</th>
			<th field="nssbh" width="130">纳税人识别号</th>
			<th field="ssly" width="130">主营产品技术领域</th>
			<th field="zgswjg" width="130">企业所得税主管税务机关</th>
			<th field="zgzs" width="130">职工总数</th>
			<th field="yjrys" width="130">人事研究开发人员数</th>
			<th field="dzrs" width="130">大专以上人员数</th>
			<th field="ynzsr" width="130">近1年企业总收入</th>
			<th field="sr1" width="130">第1年销售收入</th>
			<th field="sr2" width="130">第2年销售总收入</th>
			<th field="sr3" width="130">第3年销售总收入</th>
			<th field="hj" width="130">销售收入合计</th>
			<th field="xszzl" width="130">销售增长率</th>
			<th field="zc1" width="130">第1 年总资产</th>
			<th field="zc2" width="130">第2年总资产</th>
			<th field="zc3" width="130">第3年总资产</th>
			<th field="zczzl" width="130">总资产增长率</th>  
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
				<dd>年度:</dd>
				<dd><input size="15" id="year" name="year" /></dd>
			</dl>
			<dl>
				<dd>年份:</dd>
				<dd><input size="15" id="nf" name="nf" /></dd>
			</dl>
			<dl>
				<dd>企业名称:</dd>
				<dd><input size="15" id="qymc" name="qymc" /></dd>
			</dl>
			<dl>
				<dd>纳税人识别号:</dd>
				<dd><input size="15" id="nssbh" name="nssbh" /></dd>
			</dl>
			<dl>
				<dd>主营产品技术领域:</dd>
				<dd><input size="15" id="ssly" name="ssly" /></dd>
			</dl>
			<dl>
				<dd>企业所得税主管税务机关:</dd>
				<dd><input size="15" id="zgswjg" name="zgswjg" /></dd>
			</dl>
			<dl>
				<dd>职工总数:</dd>
				<dd><input size="15" id="zgzs" name="zgzs" /></dd>
			</dl>   
			<dl>
				<dd>人事研究开发人员数:</dd>
				<dd><input size="15" id="yjrys" name="yjrys" /></dd>
			</dl>
			<dl>
				<dd>大专以上人员数:</dd>
				<dd><input size="15" id="dzrs" name="dzrs" /></dd>
			</dl>
			<dl>
				<dd>发文机关:</dd>
				<dd><input size="15" id="ynzsr" name="ynzsr" /></dd>
			</dl>
			<dl>
				<dd>近1年企业总收入:</dd>
				<dd><input size="15" id="sr1" name="sr1" /></dd>
			</dl>
			<dl>
				<dd>第1年销售收入:</dd>
				<dd><input size="15" id="sr2" name="sr2" /></dd>
			</dl>
			<dl>
				<dd>第2年销售总收入:</dd>
				<dd><input size="15" id="sr3" name="sr3" /></dd>
			</dl>
			<dl>
				<dd>第3年销售总收入:</dd>
				<dd><input size="15" id="hj" name="hj" /></dd>
			</dl>
			<dl>
				<dd>销售收入合计:</dd>
				<dd><input size="15" id="xszzl" name="xszzl" /></dd>
			</dl>
			<dl>
				<dd>销售增长率:</dd>
				<dd><input size="15" id="zc1" name="zc1" /></dd>
			</dl>
			<dl>
				<dd>第1 年总资产:</dd>
				<dd><input size="15" id="zc2" name="zc2" /></dd>
			</dl>
			<dl>
				<dd>第2 年总资产:</dd>
				<dd><input size="15" id="zc3" name="zc3" /></dd>
			</dl>
			<dl>
				<dd>第3 年总资产:</dd>
				<dd><input size="15" id="zczzl" name="zczzl" /></dd>
			</dl>
			
			
		</form>
	</div>
</div>	
</body>

</html>
