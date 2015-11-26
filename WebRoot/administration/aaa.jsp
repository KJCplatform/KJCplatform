<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>大型仪器信息表</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/aaa.js"></script>
	  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>仪器编号：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>仪器分类：</th>
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


<div data-options="region:'center',split:false" >
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="yqbh" >仪器编号</th>
			<th field="flbm" >仪器分类编码</th>
			<th field="nbbh" >所在单位内仪器编号</th>
			<th field="zwmc">仪器中文名称</th>
			<th field="ywmc" >仪器英文名称</th>
			<th field="xhgg" >仪器型号规格</th>
			<th field="jszb" >主要技术指标</th>
			<th field="csyjly" >主要测试和研究领域</th>
			<th field="zyyt">主要用途</th>
			<th field="zyfjgn" >主要附件及功能</th>
			<th field="rzqk" >仪器认证情况</th>
			<th field="sccs" >生产厂商</th>
			<th field="cdgb" >产地国别</th>
     		<th field="yqyz">仪器原值</th>
			<th field="qyrq" >启用日期</th>
			<th field="szdwmc" >所在单位名称</th>
			<th field="sysmc" >实验室名称</th>
			<th field="afdz" >仪器安放地址</th>
			<th field="yzbm">邮政编码</th>
			<th field="lxr" >仪器联系人</th>
			<th field="dh" >电话</th>
			<th field="dzyj" >电子邮件</th>
			<th field="sfgx" >是否共享</th>
			<th field="yqzt" >仪器状态</th>
			<th field="kfjsap" >开放机时安排</th>
			<th field="cksfbz" >参考收费标准</th>
			<th field="fwtjnf" >服务统计年份</th>
			<th field="nfwjs" >年对外服务机时</th>
			<th field="nfwsr" >年对外服务收入</th>
			<th field="zmyh" >知名用户及联系方式</th>
			<th field="yycg" >应用成果</th>
			<th field="yqtp" >仪器图片</th>
			<th field="bz" >备注</th>     
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
				<dd>仪器编号:</dd>
				<dd><input size="20" id="yqbh" name="yqbh" /></dd>
			</dl>
			<dl>
				<dd>仪器分类编码:</dd>
				<dd><input size="20" id="flbm" name="flbm" /></dd>
			</dl>
			<dl>
				<dd>所在单位内仪器编号:</dd>
				<dd><input size="20" id="nbbh" name="nbbh" /></dd>
			</dl>
			<dl>
				<dd>仪器中文名称:</dd>
				<dd><input size="20" id="zwmc" name="zwmc" /></dd>
			</dl>
			<dl>
		<dd>仪器英文名称:</dd>
				<dd><input size="20" id="ywmc" name="ywmc" /></dd>
			</dl>
			<dl>
				<dd>仪器型号规格:</dd>
				<dd><input size="20" id="xhgg" name="xhgg" /></dd>
			</dl>
			<dl>
				<dd>主要技术指标:</dd>
				<dd><input size="20" id="jszb" name="jszb" /></dd>
			</dl>
			<dl>
				<dd>主要测试和研究领域:</dd>
				<dd><input size="20" id="csyjly" name="csyjly" /></dd>
			</dl>
			<dl>
				<dd>主要用途:</dd>
				<dd><input size="20" id="zyyt" name="zyyt" /></dd>
			</dl>
			<dl>
				<dd>主要附件及功能:</dd>
				<dd><input size="20" id="zyfjgn" name="zyfjgn" /></dd>
			</dl>
			<dl>
				<dd>仪器认证情况:</dd>
				<dd><input size="20" id="rzqk" name="rzqk" /></dd>
			</dl>
			<dl>
				<dd>生产厂商:</dd>
				<dd><input size="20" id="sccs" name="sccs" /></dd>
			</dl>
			<dl>
				<dd>产地国别:</dd>
				<dd><input size="20" id="cdgb" name="cdgb" /></dd>
			</dl>
			<dl>
				<dd>仪器原值:</dd>
				<dd><input size="20" id="yqyz" name="yqyz" /></dd>
			</dl>
			<dl>
				<dd>启用日期:</dd>
				<dd><input  type="text" style="width: 150px" id="qyrq" name="qyrq" /></dd>
			</dl>
			<dl>
				<dd>所在单位名称:</dd>
				<dd><input size="20" id="szdwmc" name="szdwmc" /></dd>
			</dl>
			<dl>
				<dd>实验室名称:</dd>
				<dd><input size="20" id="sysmc" name="sysmc" /></dd>
			</dl>
			<dl>
				<dd>仪器安放地址:</dd>
				<dd><input size="20" id="afdz" name="afdz" /></dd>
			</dl>
			<dl>
				<dd>邮政编码:</dd>
				<dd><input size="20" id="yzbm" name="yzbm" /></dd>
			</dl>
			<dl>
				<dd>仪器联系人:</dd>
				<dd><input size="20" id="lxr" name="lxr" /></dd>
			</dl>
			<dl>
				<dd>电话:</dd>
				<dd><input size="20" id="dh" name="dh" /></dd>
			</dl>
			<dl>
				<dd>电子邮件:</dd>
				<dd><input size="20" id="dzyj" name="dzyj" /></dd>
			</dl>
			<dl>
				<dd>是否共享:</dd>
				<dd><input size="20" id="sfgx" name="sfgx" /></dd>
			</dl>
			<dl>
				<dd>仪器状态:</dd>
				<dd><input size="20" id="yqzt" name="yqzt" /></dd>
			</dl>
			<dl>
				<dd>开放机时安排:</dd>
				<dd><input size="20" id="kfjsap" name="kfjsap" /></dd>
			</dl>
			<dl>
				<dd>参考收费标准:</dd>
				<dd><input size="20" id="cksfbz" name="cksfbz" /></dd>
			</dl>
			<dl>
				<dd>服务统计年份:</dd>
				<dd><input size="20" id="fwtjnf" name="fwtjnf" /></dd>
			</dl>
			<dl>
				<dd>年对外服务机时:</dd>
				<dd><input size="20" id="nfwjs" name="nfwjs" /></dd>
			</dl>
			<dl>
				<dd>年对外服务收入:</dd>
				<dd><input size="20" id="nfwsr" name="nfwsr" /></dd>
			</dl>
			<dl>
				<dd>知名用户及联系方式:</dd>
				<dd><input size="20" id="zmyh" name="zmyh" /></dd>
			</dl>
			<dl>
				<dd>应用成果:</dd>
				<dd><input size="20" id="yycg" name="yycg" /></dd>
			</dl>
			<dl>
				<dd>仪器图片:</dd>
				<dd><input size="20" id="yqtp" name="yqtp" /></dd>
			</dl>
			<dl>
				<dd>备注:</dd>
				<dd><input size="20" id="bz" name="bz" /></dd>
			</dl>                    
		</form>
	</div>
</div>	
</body>

</html>
