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
	<script type="text/javascript" src="<%=basePath%>/script/kjkjxmxxb0.js"></script>
</head>

<body>

<div data-options="region:'north',title:'查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>文件名：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>文件号：</th>
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
			<th field="xmbh" width="130">项目编号</th>
			<th field="xmmc" width="130">项目名称</th>
			<th field="cjdws" width="130">参加单位总数</th>
			<th field="dwmc" width="130">承担单位名称</th>
			<th field="dwszd" width="130">单位所在地</th>
			<th field="txdz" width="130">通讯地址</th>
			<th field="yb" width="130">邮编</th>
			<th field="dwxz" width="130">单位性质</th>
			<th field="sjbm" width="130">上级行政主管部门</th>
			<th field="fzr" width="130">项目负责人姓名</th>
			<th field="xb" width="130">性别</th>
			<th field="csn" width="130">出生年</th>
			<th field="xl" width="130">学历</th>
			<th field="zc" width="130">职称</th>
			<th field="lxdh" width="130">联系电话</th>
			<th field="email" width="130">Email</th>
			<th field="xmzrs" width="130">项目组人数</th>
			<th field="gj" width="130">高级</th>
			<th field="zj" width="130">中级</th>
			<th field="cj" width="130">初级</th>
			<th field="qt" width="130">其他</th>
			<th field="qssj" width="130">起始时间</th>
			<th field="zzsj" width="130">终止时间</th>
			<th field="xmhdlx" width="130">项目活动类型</th>
			<th field="ssly" width="130">所属领域</th>
			<th field="xmjsly" width="130">项目技术来源</th>
			<th field="zyyfnr" width="130">主要研发内容</th>
			<th field="cgxs" width="130">预期成果形式</th>
			<th field="yqzl" width="130">预期取得专利</th>
			<th field="zjf" width="130">总经费</th>
			<th field="sbk" width="130">省拨款</th>
			<!-- <th field="sjbm" width="130">记录时间(年份)</th>
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
				<dd>项目编号:</dd>
				<dd><input size="15" id="xmbh" name="xmbh" /></dd>
			</dl>
			<dl>
				<dd>项目名称:</dd>
				<dd><input size="15" id="xmmc" name="xmmc" /></dd>
			</dl>
			<dl>
				<dd>参加单位总数:</dd>
				<dd><input size="15" id="cjdws" name="cjdws" /></dd>
			</dl>
			<dl>
				<dd>承担单位名称:</dd>
				<dd><input size="15" id="dwmc" name="dwmc" /></dd>
			</dl>
			<dl>
				<dd>单位所在地:</dd>
				<dd><input size="15" id="dwszd" name="dwszd" /></dd>
			</dl>
			<dl>
				<dd>通讯地址:</dd>
				<dd><input size="15" id="txdz" name="txdz" /></dd>
			</dl>
			<dl>
				<dd>邮编:</dd>
				<dd><input size="15" id="yb" name="yb" /></dd>
			</dl>
			<dl>
				<dd>单位性质:</dd>
				<dd><input size="15" id="dwxz" name="dwxz" /></dd>
			</dl>
			<dl>
				<dd>上级行政主管部门:</dd>
				<dd><input size="15" id="sjbm" name="sjbm" /></dd>
			</dl>
			<dl>
				<dd>项目负责人姓名:</dd>
				<dd><input size="15" id="fzr" name="fzr" /></dd>
			</dl>
			<dl>
				<dd>性别:</dd>
				<dd><input size="15" id="xb" name="xb" /></dd>
			</dl>
			<dl>
				<dd>出生年:</dd>
				<dd><input size="15" id="csn" name="csn" /></dd>
			</dl>
			<dl>
				<dd>学历:</dd>
				<dd><input size="15" id="xl" name="xl" /></dd>
			</dl>
			<dl>
				<dd>职称:</dd>
				<dd><input size="15" id="zc" name="zc" /></dd>
			</dl>
			<dl>
				<dd>联系电话:</dd>
				<dd><input size="15" id="lxdh" name="lxdh" /></dd>
			</dl>
			<dl>
				<dd>Email:</dd>
				<dd><input size="15" id="email" name="email" /></dd>
			</dl>
			<dl>
				<dd>项目组人数:</dd>
				<dd><input size="15" id="xmzrs" name="xmzrs" /></dd>
			</dl>
			<dl>
				<dd>高级:</dd>
				<dd><input size="15" id="gj" name="gj" /></dd>
			</dl>
			<dl>
				<dd>中级:</dd>
				<dd><input size="15" id="zj" name="zj" /></dd>
			</dl>
			<dl>
				<dd>初级:</dd>
				<dd><input size="15" id="cj" name="cj" /></dd>
			</dl>
			<dl>
				<dd>其他:</dd>
				<dd><input size="15" id="qt" name="qt" /></dd>
			</dl>
			<dl>
				<dd>起始时间:</dd>
				<dd><input size="15" id="qssj" name="qssj" /></dd>
			</dl>
			<dl>
				<dd>终止时间:</dd>
				<dd><input size="15" id="zzsj" name="zzsj" /></dd>
			</dl>
			<dl>
				<dd>项目活动类型:</dd>
				<dd><input size="15" id="xmhdlx" name="xmhdlx" /></dd>
			</dl>
			<dl>
				<dd>所属领域:</dd>
				<dd><input size="15" id="ssly" name="ssly" /></dd>
			</dl>
			<dl>
				<dd>项目技术来源:</dd>
				<dd><input size="15" id="xmjsly" name="xmjsly" /></dd>
			</dl>
			<dl>
				<dd>主要研发内容:</dd>
				<dd><input size="15" id="zyyfnr" name="zyyfnr" /></dd>
			</dl>
			<dl>
				<dd>预期成果形式:</dd>
				<dd><input size="15" id="cgxs" name="cgxs" /></dd>
			</dl>
			<dl>
				<dd>预期取得专利:</dd>
				<dd><input size="15" id="yqzl" name="yqzl" /></dd>
			</dl>
			<dl>
				<dd>总经费:</dd>
				<dd><input size="15" id="zjf" name="zjf" /></dd>
			</dl>
			<dl>
				<dd>省拨款:</dd>
				<dd><input size="15" id="sbk" name="sbk" /></dd>
			</dl>
			
			
			
			
			<!--  <dl>
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
</body>

</html>
