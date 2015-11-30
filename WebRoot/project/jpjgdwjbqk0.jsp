<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>公文管理</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/jpjgdwjbqk0.js"></script>
</head>

<body>

<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>单位名称：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>单位代号：</th>
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
			<th field="jlz" width="130">计量站</th>
			<th field="jlbzsl" width="130">建立计量标准数量</th>
			<th field="jpkyrw" width="130">主要军品科研生产任务</th>
			<th field="gjsyssl" width="130">国家级实验室数量</th>
			<th field="gfsyssl" width="130">国防实验室数量</th>
			
			
			 <th field="jlnf" width="130">记录时间(年份)</th>
			        <th field="username" width="130">操作员</th>
			        <th field="gxsj" width="130">更新时间</th>
			        <th field="submit" width="130">是否提交</th> 
			
			
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
				<dd>计量站:</dd>
				<dd><input size="15" id="jlz" name="jlz" /></dd>
			</dl>
			<dl>
				<dd>建立计量标准数量:</dd>
				<dd><input size="15" id="jlbzsl" name="jlbzsl" /></dd>
			</dl>
			
			
			<dl>
				<dd>主要军品科研生产任务:</dd>
				<dd><input size="15" id="jpkyrw" name="jpkyrw" /></dd>
			</dl>
			<dl>
				<dd>国家级实验室数量:</dd>
				<dd><input size="15" id="gjsyssl" name="gjsyssl" /></dd>
			</dl>
			<dl>
				<dd>国防实验室数量:</dd>
				<dd><input size="15" id="gfsyssl" name="gfsyssl" /></dd>
			</dl>
			
			
			
			
			  <dl>
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
			</dl> 
		</form>
	</div>
</div>	
</body>

</html>
