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
	<script type="text/javascript" src="<%=basePath%>/script/kjrzxqcjb.js"></script>
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
					<th>企业类型：</th>
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
			<th field="qymc" width="130">企业名称</th>
			<th field="qylx" width="130">企业类型</th>
			<th field="qytz" width="130">企业特征</th>
			<th field="zczb" width="130">注册资本</th>
			<th field="zcsj" width="130">注册时间</th>
			<th field="ygzs" width="130">员工总数</th>
			<th field="rzed" width="130">融资额度</th>
			<th field="zjyt" width="130">资金用途</th>
			<th field="rzfs" width="130">融资方式</th>
			<th field="xmjj" width="130">项目简介</th>
			<th field="sfgk" width="130">以下信息是否公开</th>
			<th field="xmlxr" width="130">项目联系人</th>
			<th field="gddh" width="130">固定电话</th>
			<th field="sj" width="130">手机</th>
			<th field="dzyx" width="130">电子邮箱</th>
			<th field="lxdz" width="130">联系地址</th>
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
				<dd>企业名称:</dd>
				<dd><input size="20" id="qymc" name="qymc" /></dd>
			</dl>
		 	<dl>
				<dd>企业类型:</dd>
				<dd><select style="width: 150px" id="qylx" name="qylx" >
				<option value="请选择">请选择</option>
				<option value="国有企业">国有企业</option>
				<option value="集体企业">集体企业</option>
				<option value="股份制企业">股份制企业</option>
				<option value="私营企业">私营企业</option>
				<option value="其他">其他</option>
				
				</select></dd>
			</dl>
			<dl>
				<dd>企业特征:</dd>
				<dd><select style="width: 150px" id="qytz" name="qytz" >
				<option value="请选择">请选择</option>
				<option value="认定的高新技术企业">认定的高新技术企业</option>
				<option value="科技型中小企业">科技型中小企业</option>
				<option value="创新性试点企业">创新性试点企业</option>
				<option value="其他">其他</option>
				
				</select>
				</dd>
			</dl>
		  	<dl>
				<dd>注册资本:</dd>
				<dd><textarea cols="20" rows="3" id="zczb" name="zczb"></textarea></dd>
			</dl>
			<dl>
				<dd>注册时间:</dd>
				<dd><input type="text" style="width: 150px" id="zcsj" name="zcsj" /></dd>
			</dl>
			<dl>
				<dd>员工总数:</dd>
				<dd><input size="20" id="ygzs" name="ygzs" /></dd>
			</dl>
			<dl>
				<dd>融资额度:</dd>
				<dd><input size="20" id="rzed" name="rzed" /></dd>
			</dl>
			<dl>
				<dd>资金用途:</dd>
				<dd><select style="width: 150px" id="zjyt" name="zjyt" >
				<option value="请选择">请选择</option>
				<option value="产品研发">产品研发</option>
				<option value="市场开拓">市场开拓</option>
				<option value="资金周转">资金周转</option>
				<option value="其他">其他</option>
				
				</select></dd>
			</dl>
			<dl>
				<dd>融资方式:</dd>
				<dd><select style="width: 150px" id="rzfs" name="rzfs" >
				<option value="请选择">请选择</option>
				<option value="股权融资">股权融资</option>
				<option value="债券融资">债券融资</option>
				<option value="贷款及其他">贷款及其他</option>
				
				</select></dd>
			</dl>
			<dl>
				<dd>项目简介:</dd>
				<dd><textarea cols="20" rows="3" id="xmjj" name="xmjj"></textarea></dd>
			</dl>
			<dl>
				<dd>以下信息是否公开:</dd>
				<dd>
				<select style="width: 150px" id="sfgk" name="sfgk" >
				<option value="是">是</option>
				<option value="否">否</option>
				</select>
				</dd>
				</dl>
			<dl>
				<dd>项目联系人:</dd>
				<dd><input size="20" id="xmlxr" name="xmlxr" /></dd>
			</dl>
			<dl>
				<dd>固定电话:</dd>
				<dd><input size="20" id="gddh" name="gddh" /></dd>
			</dl>
			<dl>
				<dd>手机:</dd>
				<dd><input size="20" id="sj" name="sj" /></dd>
			</dl>
			<dl>
				<dd>电子邮箱:</dd>
				<dd><input size="20" id="dzyx" name="dzyx" /></dd>
			</dl>
			<dl>
				<dd>联系地址:</dd>
				<dd><input size="20" id="lxdz" name="lxdz" /></dd>
			</dl>   
			
		</form>
		</div>
</div>	

</body>

</html>
