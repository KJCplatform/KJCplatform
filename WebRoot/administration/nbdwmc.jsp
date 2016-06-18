<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head >
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>国防科技工业单位册</title>
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
	<script type="text/javascript" src="<%=basePath%>/script/nbdwmc.js"></script>
	  <script type="text/javascript" src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>
</head>

<body>

<div data-options="region:'north',title:'高级查询'" style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>单位名称：</th>
                    <td>
						<input id="fileName" />
					</td>
                </tr>
                <tr>
					<th>单位地址：</th>
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
          
    <!-- <form id="questionTypesManage"  method="post" enctype="multipart/form-data">  
   选择文件：　<input type="text" id="uploadExcel" name="uploadExcel" class="easyui-filebox" style="width:200px" data-options="prompt:'请选择文件...'">  
       　　<a href="#" class="easyui-linkbutton" id="btnImport" onclick="ShowImport()" >导入</a>                       
       <a href="#" class="easyui-linkbutton" id="btnExport"  onclick="selectExcel()" >导出</a> 　
</form> -->

<div data-options="region:'center',split:false" >
	<!-- 表格主题部分-->
	<table id="dg">
	<thead>
		<tr>
			<th field="dwmc" >单位名称</th>
			<th field="dwdz" >通讯地址</th>
			<th field="yzbm" >邮政编码</th>
			<th field="qh">区号</th>
			<th field="zbdh" >值班电话</th>
			<th field="czhm" >传真号码</th>
			<th field="lxr" >联系人</th>
			<th field="zw" >职务</th>
			<th field="sfsb">质量统计是否上报</th>
			<th field="jinyong" >是否禁用</th>
			 
			  
			<th field="jlnf">记录年份</th>
		
		</tr>
	</thead>
	</table>
</div>

	<!-- 编辑数据的div，默认看不到 -->
<div id="divEdit" style="display:none;">
	<div id="tabEdit">
		<form id="frmEdit" style="width:600px; height:400px; overflow:auto;" method= "post">
			<input type="hidden" id="id" name="id" />
			<dl>
				<dd>单位名称:</dd>
				<dd><input size="20" id="dwmc" name="dwmc" /></dd>
			</dl>
			<dl>
				<dd>通信地址:</dd>
				<dd><input size="20" id="dwdz" name="dwdz" /></dd>
			</dl>
			<dl>
				<dd>邮政编码:</dd>
				<dd><input size="20" id="yzbm" name="yzbm" /></dd>
			</dl>
			<dl>
				<dd>区号:</dd>
				<dd><input size="20" id="qh" name="qh" /></dd>
			</dl>
			<dl>
		<dd>值班电话:</dd>
				<dd><input size="20" id="zbdh" name="zbdh" /></dd>
			</dl>
			<dl>
				<dd>传真号码:</dd>
				<dd><input size="20" id="czhm" name="czhm" /></dd>
			</dl>
			<dl>
				<dd>联系人:</dd>
				<dd><input size="20" id="lxr" name="lxr" /></dd>
			</dl>
			<dl>
				<dd>职务:</dd>
				<dd><input size="20" id="zw" name="zw" /></dd>
			</dl>
			<dl>
			<dd>（必填）质量统计是否上报:</dd>
			<dd>
			<select style="width: 150px" id="sfsb" name="sfsb">
							<option value="是">是</option>
							<option value="否">否</option>
						</select>
			</dd>
			</dl>
			<dl>
			<dd>
			<dd>（必填）是否禁用:</dd>
			<dd>
				<select style="width: 150px" id="jinyong" name="jinyong">
							<option value="是">是</option>
							<option value="否">否</option>
						</select>
			</dd>
			</dl>
			              
		</form>
	</div>
</div>	

<div id="divEdit2" style="display:none;">
	<div id="tabEdit2" style="overflow-y:auto;">
		<form id="frmEdit2" style="height:400px;margin:0px 0px 0px 0px"  method= "post">
		 >>>请选择导出项<<<
		 <br> <br>
<input name="Items" type="checkbox" checked="checked" value="1" />仪器编号<br>
<input name="Items" type="checkbox" checked="checked" value="2" />仪器分类编码<br> 
<input name="Items" type="checkbox" checked="checked" value="3" />所在单位内仪器编号<br> 
<input name="Items" type="checkbox" checked="checked" value="4" />仪器中文名称<br>
<input name="Items" type="checkbox" checked="checked" value="5" />仪器英文名称<br> 
<input name="Items" type="checkbox" checked="checked" value="6" />仪器型号规格<br> 
<input name="Items" type="checkbox" checked="checked" value="7" />主要技术指标<br>
<input name="Items" type="checkbox" checked="checked" value="8" />主要测试和研究领域<br>
<input name="Items" type="checkbox" checked="checked" value="9" />主要用途<br>
<input name="Items" type="checkbox" checked="checked" value="10" />主要附件及功能<br>
<input name="Items" type="checkbox" checked="checked" value="11" />仪器认证情况<br>
<input name="Items" type="checkbox" checked="checked" value="12" />生产厂商<br>
<input name="Items" type="checkbox" checked="checked" value="13" />产地国别<br>
<input name="Items" type="checkbox" checked="checked" value="14" />仪器原值<br>
<input name="Items" type="checkbox" checked="checked" value="15" />启用日期<br>
<input name="Items" type="checkbox" checked="checked" value="16" />所在单位名称<br>
<input name="Items" type="checkbox" checked="checked" value="17" />实验室名称<br>
<input name="Items" type="checkbox" checked="checked" value="18" />仪器安放地址<br>
<input name="Items" type="checkbox" checked="checked" value="19" />邮政编码<br>
<input name="Items" type="checkbox" checked="checked" value="20" />仪器联系人<br>
<input name="Items" type="checkbox" checked="checked" value="21" />电话<br>
<input name="Items" type="checkbox" checked="checked" value="22" />电子邮件<br>
<input name="Items" type="checkbox" checked="checked" value="23" />是否共享<br>
<input name="Items" type="checkbox" checked="checked" value="24" />仪器状态<br>
<input name="Items" type="checkbox" checked="checked" value="25" />开放机时安排<br>
<input name="Items" type="checkbox" checked="checked" value="26" />参考收费标准<br>
<input name="Items" type="checkbox" checked="checked" value="27" />服务统计年份<br>
<input name="Items" type="checkbox" checked="checked" value="28" />年对外服务机时<br>
<input name="Items" type="checkbox" checked="checked" value="29" />年对外服务收入<br>
<input name="Items" type="checkbox" checked="checked" value="30" />知名用户及联系方式<br>
<input name="Items" type="checkbox" checked="checked" value="31" />应用成果<br>
<input name="Items" type="checkbox" checked="checked" value="32" />仪器图片<br>
<input name="Items" type="checkbox" checked="checked" value="33" />备注<br>
<input name="Items" type="checkbox" checked="checked" value="34" />记录年份<br>
<input name="Items" type="checkbox" checked="checked" value="35" />操作员<br>
<input name="Items" type="checkbox" checked="checked" value="36" />更新时间<br>
<input name="Items" type="checkbox" checked="checked" value="37" />是否提交<br>

		</form>
	</div>
</div>	
</body>

</html>
