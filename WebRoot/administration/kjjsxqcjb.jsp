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
	<script type="text/javascript" src="<%=basePath%>/script/kjjsxqcjb.js"></script>
	  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>需求名称：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>需求解决方式：</th>
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


<div data-options="region:'center',split:false"  style="overflow:scroll" >
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="xqmc"  >需求名称</th>
			<th field="jjfs"  >解决方式</th>
			<th field="sfzj"  >是否中介</th>
				 
		<th field="zjdw">中介单位</th>
<th field="zjlxr">中介联系人</th>
	<th field="sj"  >联系方式</th>
			<th field="yqrq"  >逾期日期</th>
			<th field="sshy"  >所属行业</th>
			<th field="jsly"  >技术领域</th>
			<th field="xqms"  >需求描述</th>
			<th field="ngzj"  >拟提供资金</th>
			<th field="fbrxz"  >发布人性质</th>
			<th field="sfgk"  >是否公开</th>
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


	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:800px; height:400px; overflow:auto;" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>需求名称:</dd>
				<dd><input size="20" id="xqmc" name="xqmc" />
				
				</dd>
			</dl>
			<dl>
				<dd>解决方式:</dd>
			<dd>  <select id="jjfs"  name="jjfs" style="width: 150px">
			      <option   value=""></option>
                  <option   value="技术转让">技术转让</option>
                  <option   value="技术开发">技术开发</option>
                  <option   value="技术咨询">技术咨询</option>
                  <option   value="技术服务">技术服务</option>
             
				</select>
				
				</dd>
			</dl>
			<dl>
				<dd>是否中介:</dd>
				<dd><select style="width: 150px" id="sfzj" name="sfzj" >
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
				<dd>联系方式:</dd>
				<dd> <input type="text" style="width: 150px" id="sj" name="sj"
							style="width:150px;" /></dd>
			</dl>
			<dl>
				<dd>逾期日期:</dd>
				<dd><input type="text" style="width: 150px" id="yqrq" name="yqrq" /></dd>
			</dl>
			<dl>
				<dd>所属行业:</dd>
					<dd><input size="20" id="sshy" name="sshy" /></dd>
			</dl>



                <dl>
                    <dd>
                        技术领域: <input size="15" id="jsly" name="jsly" />
                    </dd>
                </dl>
			<dl>
				<dd>需求描述:</dd>
				<dd><textarea cols="20" rows="3" id="xqms" name="xqms"></textarea></dd>
			</dl>
			<dl>
				<dd>拟提供资金:</dd>
				<dd><select   style="width: 150px" id="ngzj" name="ngzj" >
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
				</select></dd>
			</dl>
			<dl>
				<dd>发布人性质:</dd>
				<dd><select style="width: 150px" id="fbrxz" name="fbrxz" >
				<option value="机构">机构</option>
				<option value="个人">个人</option>
				</select></dd>
			</dl>
			<dl>
				<dd>是否公开:</dd>
				<dd><select style="width: 150px" id="sfgk" name="sfgk" >
				<option value="是">是</option>
				<option value="否">否</option>
				</select></dd>
			</dl>
			<dl>
				<dd>联系人姓名:</dd>
				<dd><input size="20" id="lxrxm" name="lxrxm" /></dd>
			</dl>
			<dl>
				<dd>固定电话:</dd>
				<dd> <input type="text" style="width: 150px" id="gddh" name="gddh"
							style="width:150px;" /></dd>
			</dl>
		        <dl>
                    <dd>    
                         所在地区: <input
                            type="text" style="width: 150px" id="szdq" name="szdq" />
                    </dd>
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
