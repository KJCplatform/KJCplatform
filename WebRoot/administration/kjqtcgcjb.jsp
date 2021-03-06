<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>其他技术成果</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/kjqtcgcjb.js"></script>
	 <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'"   style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>完成单位：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>主要完成人：</th>
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


<div data-options="region:'center',split:false" style="overflow:scroll" >
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="cgmc" >名称</th>
			<th field="wcdw"  >完成单位</th>
			<th field="zywcr" >完成人</th>
			<th field="wcsj"  >完成时间</th>
			<th field="cgjj"  >成果简介</th>
			<th field="yyhy"  >应用行业</th>
			<th field="jsly"  >技术领域</th>
			<th field="cgjd"  >成果阶段</th>
			<th field="zhfs"  >转化方式</th>
			<th field="sfzj"  >是否中介</th>
			  <th field="zjdw">中介单位</th>
<th field="zjlxr">中介联系人</th>
	<th field="sj" >联系方式</th>
			<th field="gfdj"  >供方定价</th>
			<th field="zhyq"  >转化要求</th>
			<th field="sfgk"  >是否公开</th>
			<th field="fbrxz"  >发布人性质</th>
			<th field="lxrxm"  >联系人姓名</th>
			<th field="gddh"  >固定电话</th>
			<th field="szdq"  >所在地区</th>
			
			<th field="dzyx"  >电子邮箱</th>
			<th field="lxdz"  >联系地址</th>
			
			    <th field="jlnf">记录年份</th>
		
		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 
<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:800px; height:500px; overflow:auto;" method= "post">

		
		-->
		<div id="divEdit" style="display:none;">
		<div id="tabEdit" style="overflow-y:auto;">
			<form id="frmEdit"
				style="width:800px; height:400px;"
				method="post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>成果名称:</dd>
				<dd><input size="20" id="cgmc" name="cgmc" /></dd>
			</dl>
			<dl>
				<dd>成果完成单位:</dd>
				<dd><input size="20" id="wcdw" name="wcdw" /></dd>
			</dl>
			<dl>
				<dd>主要完成人:</dd>
				<dd><input size="20" id="zywcr" name="zywcr" /></dd>
			</dl>
			<dl>
				<dd>完成时间:</dd>
				<dd><input type="text" style="width: 150px" id="wcsj" name="wcsj" /></dd>
			</dl>
			<dl>
				<dd>成果简介:</dd>
				<dd><textarea cols="20" rows="3" id="cgjj" name="cgjj"></textarea></dd>
			</dl>
			            <dl>
                    <dd>
                        应用行业: <input size="15" id="yyhy" name="yyhy" />
                    </dd>
                </dl>



                <dl>
                    <dd>
                        技术领域: <input size="15" id="jsly" name="jsly" />
                    </dd>
                </dl>
			<dl>
				<dd>成果阶段:</dd>
				<dd><select   style="width: 150px" id="cgjd" name="cgjd" >
				<option value="请选择">请选择</option>
				<option value="研发阶段">研发阶段</option>
				<option value="小试阶段">小试阶段</option>
				<option value="中试阶段">中试阶段</option>
				<option value="已有样品/样机">已有样品/样机</option>
				<option value="可量产">可量产</option>
				</select>
				
				</dd>
			</dl>
			<dl>
				<dd>转化方式:</dd>
				<dd>
				<select id="zhfs" multiple="true" name="zhfs" style="width:150px;"></select>
				</dd>
			</dl>
			<dl>
				<dd>是否委托中介:</dd>
				<dd><select  style="width: 150px" id="sfzj" name="sfzj">
				<option value="是">是</option>
				<option value="否">否</option>
				</select></dd>
			</dl>
			
				<dl>
					<dd>
						中介单位: <input size="15" id="zjdw" name="zjdw">
					</dd>
				</dl>	<dl>
					<dd>
						中介联系人: <input size="15" id="zjlxr" name="zjlxr">
					</dd>
				</dl>
				<dl>
			
				<dd>联系方式:</dd><dd> <input type="text" style="width: 150px" id="sj" name="sj"
							style="width:150px;" /></dd>
			</dl>
			<dl>
				<dd>供方定价:</dd>
				<dd><select   style="width: 150px" id="gfdj" name="gfdj" >
				<option value="请选择">请选择</option>
				<option value="">研发阶段</option>
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
				<dd>其他转化要求:</dd>
				<dd><input size="20"  id="zhyq" name="zhyq"></dd>
			</dl>
			<dl>
				<dd>以下信息是否公开:</dd>
				<dd><select  style="width: 150px" id="sfgk" name="sfgk">
				<option value="是">是</option>
				<option value="否">否</option>
				</select></dd>
			</dl>
			<dl>
				<dd>发布人性质:</dd>
				<dd><select style="width: 150px" id="fbrxz" name="fbrxz">
				<option value="机构">机构</option>
				<option value="个人">个人</option>
				</select></dd>
			</dl>
			<dl>
				<dd>联系人姓名:</dd>
				<dd><input size="20"  id="lxrxm" name="lxrxm"></dd>
			</dl>
			<dl>
				<dd>固定电话:</dd>
				<dd><input type="text" style="width: 150px" id="gddh" name="gddh"
							style="width:150px;" /></dd>
			</dl>
			<dl>
				<dd>所在地区:</dd>
				<dd><input size="20"  id="szdq" name="szdq"></dd>
			</dl>
			
				<dl>
				<dd>
						电子邮箱: <input type="text" style="width: 150px" id="dzyx" name="dzyx"
							style="width:150px;" />
					</dd>
				</dl>
			<dl>
			<dd>
				联系地址:
				<input size="20" id="lxdz" name="lxdz">
			</dd>
			</dl>
			
		</form>
	</div>
	</div>

</body>

</html>
