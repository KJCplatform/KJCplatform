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
	<script type="text/javascript" src="<%=basePath%>/script/kjnzwcjb.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>品种名称：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>选育单位：</th>
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
			<th field="pzmc" width="130">品种名称</th>
			<th field="xydw" width="130">选育单位</th>
			<th field="xyr" width="130">选育人</th>
			<th field="sdsj" width="130">审定时间</th>
			<th field="sdh" width="130">审定号</th>
			<th field="sdjg" width="130">审定机构</th>
			<th field="pzjj" width="130">品种简介</th>
			<th field="yyhy" width="130">应用行业</th>
			<th field="jsly" width="130">技术领域</th>
			<th field="cgjd" width="130">成果阶段</th>
			<th field="jyfs" width="130">交易方式</th>
			<th field="sfzj" width="130">是否委托中介</th>
			<th field="gfdj" width="130">供方定价</th>
			<th field="zhyq" width="130">其他转化要求</th>
			<th field="sfgk" width="130">以下信息是否公开</th>
			<th field="fbrxz" width="130">发布人性质</th>
			<th field="lxrxm" width="130">联系人姓名</th>
			<th field="gddh" width="130">固定电话</th>
			<th field="szdq" width="130">所在地区</th>
			<th field="sj" width="130">手机</th>
			<th field="dzyx" width="130">电子邮箱</th>
			<th field="lxdz" width="130">联系地址</th>

		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit" style="overflow-y:auto;">
		<form id="frmEdit" style="width:600px; height:600px;margin:100px 0px 0px 0px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>品种名称:
				<input size="15" id="pzmc" name="pzmc" /></dd>
			</dl>
			<dl>
				<dd>选育单位:
				<input size="15" id="xydw" name="xydw" /></dd>
			</dl>
			<dl>
				<dd>选育人:
				<input size="15" id="xyr" name="xyr" /></dd>
			</dl>
			<dl>
				<dd>审定时间:
				<input type="text" style="width: 150px" id="sdsj" name="sdsj" /></dd>
			</dl>
			<dl>
				<dd>审定号:
				<input  type="text" style="width: 150px" id="sdh" name="sdh" /></dd>
			</dl>
			<dl>
				<dd>审定机构:
				<input  type="text" style="width: 150px" id="sdjg" name="sdjg" /></dd>
			</dl>
			<dl>
				<dd>品种简介:
				<textarea cols="45" rows="3" id="pzjj" name="pzjj"></textarea></dd>
			</dl>
							<dl>
						<dd>
						应用行业: <select id="yyhy" multiple="true" name="yyhy">
		
						</select>
					</dd>
				</dl>
				
				<dl>
					<dd>
						技术领域: <select id="jsly" multiple="true" name="jsly">

						</select>
					</dd>
				</dl>
				
				<dl>
					<dd>
						成果阶段: <select id="cgjd" name="cgjd">
								<option value=""></option>
							<option value="研发阶段">研发阶段</option>
							<option value="小试阶段">小试阶段</option>
							<option value="中试阶段">中试阶段</option>
							<option value="已有样品/样机">已有样品/样机</option>
							<option value="可量产">可量产</option>

						</select>
					</dd>
				</dl>

				<dd>
					交易方式: <select id="jyfs" multiple="true" name="jyfs">

					</select>
				</dd>
				</dl>


				<dl>
					<dd>
						是否委托中介: <select id="sfwtzj" name="sfwtzj">
							<option value="1" selected="selected">是</option>
							<option value="0">否</option>
						</select>
					</dd>
				</dl>


				<dl>
					<dd>
						供方定价: <select id="gfdj" name="gfdj">
							<option value=""></option>
							<option value="20万元以下">20万元以下</option>
							<option value="20-50万元以下">20-50万元以下</option>
							<option value="50-100万元以下">50-100万元以下</option>
							<option value="100-200万元以下">100-200万元以下</option>
							<option value="200-500万元以下">200-500万元以下</option>
							<option value="500-1000万元以下">500-1000万元以下</option>
							<option value="1000万元以上">1000万元以上</option>
							<option value="面议">面议</option>

						</select>
					</dd>
				</dl>


				<dl>
					<dd>
						其他转化要求: <input size="15" id="qtzhyq" name="qtzhyq" />
					</dd>
				</dl>


				<dl>
					<dd>
						以下信息是否公开: <select id="sfgk" name="sfgk">
							<option value="1" selected="selected">是</option>
							<option value="0">否</option>
						</select>
					</dd>
				</dl>

				<dl>
					<dd>发布人性质:
					<select id="fbrxz" name="fbrxz">
							<option value="0" selected="selected">机构</option>
							<option value="1">个人</option>
						</select>
					</dd>
				</dl>
				
				<dl>
					<dd>
						联系人姓名: <input size="15" id="lxr" name="lxr" /> 固定电话: <input
							type="text" style="width: 150px" id="gddh" name="gddh" />
					</dd>
				</dl>


				<dl>
					<dd>
						所在地区: <select id="szdq" name="szdq">
							<option value=""></option>
							<option value="武汉市">武汉市</option>
							<option value="北京市">北京市</option>
						</select>
					</dd>
				</dl>



				<dl>
					<dd>
						手机: <input type="text" style="width: 150px" id="sj" name="sj" />
						电子邮箱: <input size="15" id="dzyx" name="dzyx" />
					</dd>
				</dl>
				<dl>
					<dd>
						联系地址: <input size="15" id="lxdz" name="lxdz">
					</dd>
				</dl>
	
			
		</form>
	</div>
</div>	
</body>

</html>
