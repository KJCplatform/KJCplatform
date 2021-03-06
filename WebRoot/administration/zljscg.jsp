<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>专利技术成果</title>
<link href="<%=path%>/css/default.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css"
    href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
    href="<%=basePath%>/script/easyui/themes/icon.css" />
<style type="text/css">
#fm {
    margin: 0;
    padding: 10px 30px;
}

.ftitle {
    font-size: 14px;
    font-weight: bold;
    color: #666;
    padding: 5px 0;
    margin-bottom: 10px;
    border-bottom: 1px solid #ccc;
}

.fitem {
    margin-bottom: 5px;
}

.fitem label {
    display: inline-block;
    width: 80px;
}
</style>

<script type="text/javascript"
    src="<%=basePath%>/script/easyui/jquery.min.js"></script>
<script type="text/javascript"
    src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/zljscg.js"></script>

<script type="text/javascript"
    src="<%=basePath%>/script/easyui-lang-zh_CN.js"></script>

</head>

<body>

    <div data-options="region:'north',title:'高级查询'"
        style="height: 60px;">
        <form id="searchForm">
            <table>
                <tr>
                    <th>发明名称：</th>
                    <td><input id="fileName" /></td>
                </tr>
                <tr>
                    <th>专利类型：</th>
                    <td><input id="fileId" /></td>
                    <td><a class="easyui-linkbutton"
                        data-options="iconCls:'icon-search'"
                        href="javascript:void(0);" onclick="doSearch();">查询</a></td>

                </tr>
            </table>
        </form>
    </div>


    <form id="questionTypesManage" method="post"
        enctype="multipart/form-data">
        选择文件： <input type="text" id="uploadExcel" name="uploadExcel"
            class="easyui-filebox" style="width:200px"
            data-options="prompt:'请选择文件...'"> <a href="#"
            class="easyui-linkbutton" id="btnImport"
            onclick="ShowImport()">导入</a> <a href="#"
            class="easyui-linkbutton" id="btnExport"
            onclick="selectExcel()">导出</a> <a href="#"
            class="easyui-linkbutton" id="btnExport"
            onclick="selectFile()">查看附件</a>

    </form>


    <div data-options="region:'center',split:false">
        <!-- 表格主题部分-->
        <table id="dg">
            <thead>
                <tr>
                    <th field="sqh">申请号</th>
                    <th field="zlh">专利号</th>
                    <th field="cgmc">发明名称</th>

                    <th field="zlqr">专利权人</th>
                    <th field="zywcr">主要完成人</th>

                    <th field="zflh">主分类号</th>

                    <th field="mj">密级</th>
                    <th field="qx">期限</th>
                    <th field="jmtj">解密条件</th>
                    <th field="slr">受理日</th>

                    <th field="cgjj">成果简介</th>
                    <th field="yyhy">应用行业</th>
                    <th field="jsly">技术领域</th>
                    <th field="cgjd">成果阶段</th>
                    <th field="lxrxm">成果联系人</th>
                    <th field="gddh">电话</th>
                    <th field="szdq">所在地区</th>
                    <th field="dzyx">电子邮箱</th>
                    <th field="lxdz">联系地址</th>
                    <th field="jyfs">交易方式</th>
                    <th field="sfzj">是否委托中介</th>
                    <th field="gfdj">供方定价</th>
                    <th field="zhyq">其他转化要求</th>
                    <th field="sfgk">是否公开</th>
                    <th field="zjdw">中介单位</th>
                    <th field="zjlxr">中介联系人</th>
                    <th field="sj">联系方式</th>



                    <th field="jlnf">记录年份</th>

                    <!--                     <th field="fj1">附件1</th> -->
                    <!--                     <th field="fj2">附件2</th> -->

                </tr>
            </thead>
        </table>
    </div>

    <div id="divEdit2" style="display:none;">
        <div id="tabEdit2" style="overflow-y:auto;">
            <form id="frmEdit2"
                style="width:330px;margin:0px 0px 0px 0px" method="post">
                >>>请选择导出项<<< <br> <br> <input name="Items"
                    type="checkbox" checked="checked" value="1" />申请号<br>
                <input name="Items" type="checkbox" checked="checked"
                    value="2" />专利号<br> <input name="Items"
                    type="checkbox" checked="checked" value="3" />发明名称<br>
                <input name="Items" type="checkbox" checked="checked"
                    value="4" />专利权人<br> <input name="Items"
                    type="checkbox" checked="checked" value="5" />主要完成人<br>
                <input name="Items" type="checkbox" checked="checked"
                    value="6" />主分类号<br> <input name="Items"
                    type="checkbox" checked="checked" value="7" />密级<br>

                <input name="Items" type="checkbox" checked="checked"
                    value="8" />期限<br> <input name="Items"
                    type="checkbox" checked="checked" value="9" />解密条件<br>
                <input name="Items" type="checkbox" checked="checked"
                    value="10" />受理日<br> 
                <input name="Items" type="checkbox" checked="checked"
                    value="11" />成果简介<br> <input name="Items"
                    type="checkbox" checked="checked" value="12" />应用行业<br>
                <input name="Items" type="checkbox" checked="checked"
                    value="13" />技术领域<br> <input name="Items"
                    type="checkbox" checked="checked" value="14" />成果阶段<br>
                <input name="Items" type="checkbox" checked="checked"
                    value="15" />成果联系人<br> <input name="Items"
                    type="checkbox" checked="checked" value="16" />电话<br>
                <input name="Items" type="checkbox" checked="checked"
                    value="17" />所在地区<br> <input name="Items"
                    type="checkbox" checked="checked" value="18" />电子邮箱<br>
                <input name="Items" type="checkbox" checked="checked"
                    value="19" />联系地址<br> <input name="Items"
                    type="checkbox" checked="checked" value="20" />交易方式<br>

                <input name="Items" type="checkbox" checked="checked"
                    value="21" />是否委托中介<br> <input name="Items"
                    type="checkbox" checked="checked" value="22" />供方定价<br>
                <input name="Items" type="checkbox" checked="checked"
                    value="23" />其他转化要求<br>
                     <input name="Items" type="checkbox" checked="checked"
                    value="24" />是否公开<br>
                     <input name="Items" type="checkbox" checked="checked"
                    value="25" />中介单位<br>
                     <input name="Items" type="checkbox" checked="checked"
                    value="26" />中介联系人<br>
                     <input name="Items" type="checkbox" checked="checked"
                    value="27" />联系方式<br>
            </form>
        </div>
    </div>

    <div id="open" style="display:none;">
        <div id="tabOpen"
            style="width:400px; height:300px; overflow:auto;">
            <form id="openFj">
                <input id="Fj1" name="Fj1" type="checkbox" value="附件1" />
                <span id="fj1Name"></span><br> <input id="Fj2"
                    name="Fj2" type="checkbox" value="附件2" /> <span
                    id="fj2Name"></span><br>
            </form>
        </div>
    </div>


    <!-- 编辑数据的div，默认看不到 -->
    <div id="divEdit" style="display:none;">
        <div id="tabEdit" style="overflow-y:auto;">
            <form id="frmEdit" style="width:50%;height:400"
                method="post">
                <input type="hidden" id="id" name="id" />
                <dl>
                    <dd>
                        申请号: <input size="15" id="sqh" name="sqh">
                    </dd>
                </dl>
                <dl>
                    <dd>
                        专利号: <input type="text" style="width: 150px"
                            id="zlh" name="zlh">
                    </dd>
                </dl>
                <dl>
                    <dd>
                        发明名称: <input size="15" id="cgmc" name="cgmc" />
                    </dd>
                </dl>

                <!-- 				<dl> -->
                <!-- 					<dd> -->
                <!-- 						专利类型: <select id="zllx" name="zllx"> -->
                <!-- 							<option value=""></option> -->
                <!-- 							<option value="发明专利">发明专利</option> -->
                <!-- 							<option value="实用新型专利">实用新型专利</option> -->
                <!-- 							<option value="外观设计专利">外观设计专利</option> -->
                <!-- 						</select> -->
                <!-- 					</dd> -->
                <!-- 				</dl> -->


                <dl>
                    <dd>
                        专利权人: <input size="15" id="zlqr" name="zlqr" />
                    </dd>
                </dl>
                <dl>
                    <dd>
                        主要完成人: <input type="text" style="width: 150px"
                            id="zywcr" name="zywcr" />
                    </dd>
                </dl>
                <dl>
                    <dd>
                        主分类号: <input type="text" style="width: 150px"
                            id="zflh" name="zflh">
                    </dd>
                </dl>
                <dl>
                    <dd>
                        密级: <input type="text" style="width: 150px"
                            id="mj" name="mj" />
                    </dd>
                </dl>
                <dl>
                    <dd>
                        期限: <input type="text" style="width: 150px"
                            id="qx" name="qx" />
                    </dd>
                </dl>

                <dl>
                    <dd>
                        解密条件: <input size="15" id="jmtj" name="jmtj" />
                    </dd>
                </dl>
                <dl>
                    <dd>
                        受理日: <input type="text" style="width: 150px"
                            id="slr" name="slr" />
                    </dd>
                </dl>


                <dl>
                    <dd>
                        成果简介:
                        <textarea cols="45" rows="5" size="15" id="cgjj"
                            name="cgjj" /></textarea>
                    </dd>
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
                <dl>
                    <dd>
                        成果联系人: <input size="15" id="lxrxm" name="lxrxm" />
                    </dd>
                </dl>
                <dl>
                    <dd>
                        电话: <input type="text" style="width: 150px"
                            id="gddh" name="gddh" style="width:150px;" />
                    </dd>
                </dl>


                <dl>
                    <dd>
                        所在地区: <input type="text" style="width: 150px"
                            id="szdq" name="szdq" style="width:150px;" />
                    </dd>
                </dl>




                <dl>

                    <dd>
                        电子邮箱: <input type="text" style="width: 150px"
                            id="dzyx" name="dzyx" style="width:150px;" />
                    </dd>
                </dl>
                <dl>
                    <dd>
                        联系地址: <input size="15" id="lxdz" name="lxdz">
                    </dd>
                </dl>
         <dl>
                    <dd>
                        交易方式: <input size="15" id="jyfs" name="jyfs">
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
                    <dd>
                        中介单位: <input size="15" id="zjdw" name="zjdw">
                    </dd>
                </dl>
                <dl>
                    <dd>
                        中介联系人: <input size="15" id="zjlxr" name="zjlxr">
                    </dd>
                </dl>

                <dl>
                    <dd>
                        联系方式: <input type="text" style="width: 150px"
                            id="sj" name="sj" style="width:150px;" />
                    </dd>
                </dl>
                <dl>
                    <dd>
                        附件1: <input type="text" style="width: 150px"
                            id="fj1" name="fj1" class="easyui-filebox"
                            style="width:200px"
                            data-options="prompt:'请选择文件...'" />
                    </dd>
                </dl>

                <dl>
                    <dd>
                        附件2: <input type="text" style="width: 150px"
                            id="fj2" name="fj2" class="easyui-filebox"
                            style="width:200px"
                            data-options="prompt:'请选择文件...'" />
                    </dd>
                </dl>





            </form>
        </div>
    </div>
</body>

</html>
