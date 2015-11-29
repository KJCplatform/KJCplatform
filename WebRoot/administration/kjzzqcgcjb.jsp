<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>软件著作权</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/kjzzqcgcjb.js"></script>
	 <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>成果名称：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>成果完成单位：</th>
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


	    <form id="questionTypesManage"  method="post" enctype="multipart/form-data">  
   选择文件：　<input type="text" id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">  
       　　<a href="#" class="easyui-linkbutton" id="btnImport" onclick="ShowImport()" >导入</a>                       
       <a href="#" class="easyui-linkbutton" id="btnExport"  onclick="selectExcel()" >导出</a> 　
</form>




<div data-options="region:'center',split:false">
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="cgmc" >成果名称</th>
			<th field="wcdw" >成果完成单位</th>
			<th field="zywcr" >主要完成人</th>
			<th field="wcsj" >完成时间</th>
			<th field="rzbh">软著编号</th>
			<th field="cgjj" >成果简介</th>
			<th field="yyhy" >应用行业</th>
			<th field="jsly">技术领域</th>
			<th field="cgjd" >成果阶段</th>
			<th field="jyfs" >交易方式</th>
			<th field="sfzj" >是否委托中介</th>
			<th field="gfdj" >供方定价</th>
			<th field="zhyq" >其他转化要求</th>
			<th field="sfgk" >以下信息是否公开</th>
			<th field="fbrxz" >发布人性质</th>
			<th field="lxrxm">联系人姓名</th>
			<th field="gddh" >固定电话</th>
			<th field="szdq" >所在地区</th>
			<th field="sj" >手机</th>
			<th field="dzyx" >电子邮箱</th>
			<th field="lxdz">联系地址</th>
            <th field="jlnf">记录年份</th>
		    <th field="username">记录人</th>
			<th field="gxsj">更新时间</th>
			<th field="submit">是否提交</th>
		</tr>
	</thead>
	</table>
</div>


	<div id="divEdit2" style="display:none;">
	<div id="tabEdit2" style="overflow-y:auto;">
		<form id="frmEdit2" style="width:330px;margin:0px 0px 0px 0px"  method= "post">
		 >>>请选择导出项<<<
		 <br> <br>
<input name="Items" type="checkbox" checked="checked" value="1" />成果名称<br>
<input name="Items" type="checkbox" checked="checked" value="2" />成果完成单位<br> 
<input name="Items" type="checkbox" checked="checked" value="3" />主要完成人<br> 
<input name="Items" type="checkbox" checked="checked" value="4" />完成时间<br>

<input name="Items" type="checkbox" checked="checked" value="5" />软著编号<br>
<input name="Items" type="checkbox" checked="checked" value="6" />成果简介<br> 
<input name="Items" type="checkbox" checked="checked" value="7" />应用行业<br>
<input name="Items" type="checkbox" checked="checked" value="8" />技术领域<br> 
<input name="Items" type="checkbox" checked="checked" value="9" />成果阶段<br> 
<input name="Items" type="checkbox" checked="checked" value="10" />交易方式<br>

<input name="Items" type="checkbox" checked="checked" value="11" />是否委托中介<br>
<input name="Items" type="checkbox" checked="checked" value="12" />供方定价<br> 
<input name="Items" type="checkbox" checked="checked" value="13" />其他转化要求<br> 
<input name="Items" type="checkbox" checked="checked" value="14" />以下信息是否公开<br>
<input name="Items" type="checkbox" checked="checked" value="15" />发布人性质<br> 

<input name="Items" type="checkbox" checked="checked" value="16" />联系人姓名<br> 
<input name="Items" type="checkbox" checked="checked" value="17" />固定电话<br> 
<input name="Items" type="checkbox" checked="checked" value="18" />所在地区<br>

<input name="Items" type="checkbox" checked="checked" value="19" />手机<br>
<input name="Items" type="checkbox" checked="checked" value="20" />电子邮箱<br> 
<input name="Items" type="checkbox" checked="checked" value="21" />联系地址<br> 
	</form>
	</div>
</div>	
	

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit" style="overflow-y:auto;">
			<form id="frmEdit" style="width:800px;height:400px" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>成果名称:
				<input size="15" id="cgmc" name="cgmc" /></dd>
			</dl>
			<dl>
				<dd>成果完成单位:
				<input size="15" id="wcdw" name="wcdw" /></dd>
			</dl>
			<dl>
				<dd>主要完成人:
				<input size="15" id="zywcr" name="zywcr" /></dd>
			</dl>
			<dl>
				<dd>完成时间:
				<input type="text" style="width: 150px" id="wcsj" name="wcsj" /></dd>
			</dl>
			<dl>
				<dd>软著编号:
				<input type="text" style="width: 150px" id="rzbh" name="rzbh" /></dd>
			</dl>
			<dl>
					<dd>成果简介:
						<textarea cols="45" rows="5" size="15" id="cgjj" name="cgjj" /></textarea>
					</dd>
				</dl>
				<dl>
						<dd>
						应用行业: <select id="yyhy" multiple="true" name="yyhy" style="width:150px;">
		
						</select>
					</dd>
				</dl>
				
				<dl>
					<dd>
						技术领域: <select id="jsly" multiple="true" name="jsly" style="width:150px;">

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
					交易方式: <select id="jyfs"   multiple="true" name="jyfs" style="width:150px;" >


					</select>
				</dd>
				</dl>


				<dl>
					<dd>
						是否委托中介: <select id="sfzj" name="sfzj">
							<option value="是" selected="selected">是</option>
							<option value="否">否</option>
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
						其他转化要求: <input size="15" id="zhyq" name="zhyq" />
					</dd>
				</dl>


				<dl>
					<dd>
						以下信息是否公开: <select id="sfgk" name="sfgk">
							<option value="是" selected="selected">是</option>
							<option value="否">否</option>
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
						联系人姓名: <input size="15" id="lxrxm" name="lxrxm" /> 固定电话: <input
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
