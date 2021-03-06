<%@ page language="java" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
			String rights = (String) request.getSession().getAttribute(
					"globle_rights");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"
    content="ie=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>湖北省国防科工办科技质量处信息管理系统</title>
<link href="<%=basePath%>/css/default.css" rel="stylesheet"
    type="text/css" />
<link rel="stylesheet" type="text/css"
    href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css"
    href="<%=basePath%>/script/easyui/themes/icon.css" />
<script type="text/javascript"
    src="<%=basePath%>/script/easyui/jquery.min.js"></script>
<script type="text/javascript"
    src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/script/index.js"> </script>

<script type="text/javascript">
	var _menus = { "menus":
	[<%if (rights.contains("1")) {%>
	  {
		"menuid": "1",
		"icon": "icon-sys",
		"menuname": "内部管理",
		"menus":[
			{
				"menuid": "11",
				"menuname": "公文管理",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/document.jsp"
				
			},
		
			{
				"menuid": "12",
				"menuname": "专家库",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/kjjszjcjb1.jsp"
				
			},{
				"menuid": "13",
				"menuname": "综合查询",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/professor.jsp"
				
			},
			{
				"menuid": "14",
				"menuname": "国防科技工业单位册",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/nbdwmc.jsp"
				
			},
			{
				"menuid": "15",
				"menuname": "军工单位基本情况信息",
				"icon": "icon-nav",
				"url": "",
				"child":[{
					"menuid": "151",
					"menuname": "数据录入-军工单位基本情况信息",
					"icon": "icon-nav",
					"url": "<%=basePath%>/project/jpjgdwjbqk.jsp"
				},{
					"menuid": "152",
					"menuname": "信息查询-军工单位基本情况信息",
					"icon": "icon-nav",
					"url": "<%=basePath%>/project/jpjgdwjbqk_search.jsp"
				},{
					"menuid": "153",
					"menuname": "信息汇总-军工单位基本情况信息",
					"icon": "icon-nav",
					"url": "<%=basePath%>/project/jpjgdwjbqk0.jsp"
				}]	
			}
			
		]
		
	}<%}
			if (rights.contains("2")) {%>,
	{
		"menuid": "2",
		"icon": "icon-sys",
		"menuname": "科技项目管理",
		"menus":[
			{
			"menuid": "21",
			"menuname": "技术成果基本信息",
			"icon": "icon-nav",
			"url": "demo.html",	
			"child":[{
				"menuid": "211",
				"menuname": "国防专利",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/zljscg.jsp"
			},
			{
				"menuid": "212",
				"menuname": "登记鉴定成果",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/kjcgcjb.jsp"
			},
			{
				"menuid": "213",
				"menuname": "软件著作权",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/kjzzqcgcjb.jsp"
			},
			{
				"menuid": "215",
				"menuname": "其他技术成果",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/kjqtcgcjb.jsp"
			},
			{
				"menuid": "216",
				"menuname": "技术需求采集",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/kjjsxqcjb.jsp"
			}
			]		
		},
		
		{
			"menuid": "22",
			"menuname": "高新技术企业基本信息",
			"icon": "icon-nav",
			"url":  "<%=basePath%>/administration/kjndgxjsqypjb.jsp"
        },
// 			"child":[
// 			{
// 			"menuid": "23",
// 			"menuname": "高新技术企业基本信息",
// 			"icon": "icon-nav",
// 			 "url": "<%=basePath%>/administration/kjndgxjsqypjb.jsp"
// 		},
// 			{
// 				"menuid": "231",
// 				"menuname": "数据录入-高新技术企业认定备案信息",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/project/kjgxqybab.jsp"
// 			},{
// 				"menuid": "232",
// 				"menuname": "信息查询-高新技术企业认定备案信息",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/project/kjgxqybab_search.jsp"
// 			},	{
// 				"menuid": "233",
// 				"menuname": "汇总表-高新技术企业认定备案信息",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/administration/kjndgxqybab.jsp"
				
// 		}
			
			
// 			]	
// 		},
		{
			"menuid": "24",
			"menuname": "军品科研项目",
			"icon": "icon-nav",
			"url": "demo.html",
			"child":[{
			    "menuid": "241",
				"menuname": "军品科研项目汇总表",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjndjpptkyxmb.jsp"	
			},
			{
			    "menuid": "242",
				"menuname": "军品科研项目执行情况表",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjndjpptkyxmb2.jsp"	
			}
			]
			
			
		},
		{
			"menuid": "25",
			"menuname": "重大专项技术需求申报项目汇总表",
			"icon": "icon-nav",
	        "url": "<%=basePath%>/administration/zdzxhz.jsp"	
		},
		{
			"menuid": "27",
			"menuname": "大型仪器信息表",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/aaa.jsp"
			
		},
		{
			"menuid": "28",
			"menuname": "国防科学技术奖",
			"icon": "icon-nav",
			"url": "demo.html",
			"child":[{
				"menuid": "281",
				"menuname": "1.年度我省获国防科学技术进步奖和发明奖统计表",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjndgfjtjb.jsp"
				
			},
            {
                "menuid": "26",
                "menuname": "2.年度我省获国防科学技术奖特一二等奖情况",
                "icon": "icon-nav",
                "url": "<%=basePath%>/administration/kjgfjflqk.jsp" 
            },
		 	{
				"menuid": "282",
				"menuname": "3.年度我省获国防科学技术奖项目获奖统计",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjgjkjjgfxmtj.jsp"
				
			},
			{
				"menuid": "283",
				"menuname": "4.年度我省获国家科学技术奖国防科技工业专用项目特等奖统计",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjgjkjjgftdtj.jsp"
				
			},
			{
				"menuid": "284",
				"menuname": "5.年度我省军工单位获湖北省科学技术奖专用项目特等奖统计",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjndjgkjjlqkb.jsp"
				
			}]
			
			
			
			
		},
		
			{
			"menuid": "29",
			"menuname": "科技项目信息",
			"icon": "icon-nav",
			"url": "demo.html",
			"child":[{
				
				"menuid": "2911",
				"menuname": "录入-军转民",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb.jsp"
			},{
				"menuid": "2912",
				"menuname": "查询-军转民",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb_search.jsp"
			}
			,{
			
				"menuid": "2921",
				"menuname": "录入-民参军",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb2.jsp"
			},{
				"menuid": "2922",
				"menuname": "查询-民参军",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb_search2.jsp"
			
			},
			
		{
				"menuid": "293",
				"menuname": "科技项目库",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/kjkjxmk.jsp"
				
		},
			
		{
				"menuid": "294",
				"menuname": "科技项目信息汇总",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb0.jsp"
				
		}
				]
		},{
			"menuid": "30",
			"menuname": "军工民用技术需求调查表",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/jgmyjsxq.jsp"
		},{
			"menuid": "31",
			"menuname": "军品配套科研项目汇总表",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/jppthz.jsp"
		}
		
		
	]
		
	}<%}
			if (rights.contains("3")) {%>,
	{
		"menuid": "3",
		"icon": "icon-sys",
		"menuname": "军品质量管理",
		"menus":[
		{
			"menuid": "31",
			"menuname": "军工产品质量报表",
			"icon": "icon-nav",
			//"url": "demo.html"	
			"url": "<%=basePath%>/administration/jpzlzkjbb.jsp"			
		},
		{
			"menuid": "32",
			"menuname": "质量事故报表",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/jpsgwtbb.jsp"			
		},
		{
			"menuid": "33",
			"menuname": "国防质量季报统计表",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/zlbgtjb.jsp"		
		},
		{
			"menuid": "34",
			"menuname": "单位信息维护",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/dwxx.jsp"
		}
		]		
	}<%}
			if (rights.contains("4")) {%>,
	{
		"menuid": "4",
		"icon": "icon-sys",
		"menuname": "国防计量管理",
		"menus":[
		{
			"menuid": "41",
			"menuname": "国防三级计量技术机构",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/sjjlbz.jsp"	
		},
		{
			"menuid": "42",
			"menuname": "国防军工企事业单位最高计量标准器具",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/qjhzb.jsp"	
		},
		{
			"menuid": "43",
			"menuname": "国防军工企事业单位计量检定人员",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/xxtjb.jsp"	
		}
		]
	}<%}
			if (rights.contains("5")) {%>,
	{
		"menuid": "5",
		"icon": "icon-sys",
		"menuname": "武器装备许可管理",
		"menus":[
		{
			"menuid": "51",
			"menuname": "武器装备科研生产许可取证单位信息",
			"icon": "icon-nav",
			"url": "",
			"child":[{
				"menuid": "511",
				"menuname": "数据录入-武器装备科研生产许可取证单位信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/wqwqxkzxq.jsp"
			},{
				"menuid": "512",
				"menuname": "信息查询-武器装备科研生产许可取证单位信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/wqwqxkzxq_search.jsp"
			},
		        {
				"menuid": "513",
				"menuname": "武器装备科研生产许可信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/wqwqxkzxx.jsp"	
			},
			
			{
				"menuid": "514",
				"menuname": "信息汇总-武器装备科研生产许可取证单位信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/wqwqxkzxq0.jsp"
			}]		
		}
		]	
	}<%}
			if (rights.contains("6")) {%>,
	{
		"menuid": "6",
		"icon": "icon-sys",
		"menuname": "系统管理",
		"menus":[{
			"menuid": "61",
			"menuname": "用户管理",
			"icon": "icon-users",
			"url": "<%=basePath%>/administration/adduser.jsp"
		},
		{
			"menuid": "62",
			"menuname": "角色管理",
			"icon": "icon-role",
			"url": "<%=basePath%>/administration/addright.jsp"
		}
		
// 		{
// 			"menuid": "63",
// 			"menuname": "系统设置",
// 			"icon": "icon-set",
// 			"url": "demo.html"
// 		}
		]	
	}<%}
			if (rights.contains("7")) {%>,
	{
		"menuid": "7",
		"icon": "icon-sys",
		"menuname": "数据库管理",
		"menus":[{
			"menuid": "71",
			"menuname": "上传数据到光盘",
			"icon": "icon-set",
			"url": "<%=basePath%>/administration/datatocd.jsp"
		},
		{
			"menuid": "72",
			"menuname": "从光盘更新数据",
			"icon": "icon-set",
			"url": "<%=basePath%>/administration/dataformcd.jsp"
		},
		{
			"menuid": "73",
			"menuname": "数据备份与还原",
			"icon": "icon-set",
			"url": "<%=basePath%>/administration/dataarrange.jsp"
		},
		{
			"menuid": "74",
			"menuname": "文件拷贝",
			"icon": "icon-set",
			"url": "<%=basePath%>/administration/copytext.jsp"
		}
		]		
	}<%}
			if (rights.contains("8")) {%>
	{
		"menuid": "8",
		"icon": "icon-sys",
		"menuname": "数据更新",
		"menus":[{
			"menuid": "81",
			"menuname": "上传数据到光盘",
			"icon": "icon-set",
			"url": "<%=basePath%>/administration/datatocd.jsp"
		},
		{
			"menuid": "82",
			"menuname": "从光盘更新数据",
			"icon": "icon-set",
			"url": "<%=basePath%>/administration/dataformcd.jsp"
		}
		]		
	}
	<%}%>
	]		
}
	
	
var curWwwPath = window.document.location.href;
//获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8080
var localhostPath = curWwwPath.substring(0, pos);
//获取带"/"的项目名，如：/ems
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
var basePath = localhostPath + projectName;
        //设置登录窗口
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height: 200,
                resizable:false
            });
        }
        //关闭登录窗口
        function closePwd() {
            $('#w').window('close');
        }
        
            //修改密码
        function serverLogin() {
            var $oldpass = $('#txtOldPass');
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');
            
            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }
            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }
          //  alert($newpass.val());
            var actionChange = basePath + '/system/UserAction_change.action';
            
            var params ="name="+$oldpass.val()+"&"+"password="+$newpass.val();
	  
	  
            $.post(actionChange, params, function(result) {
            if (result.operateSuccess) {
            
					// msgShow('系统提示', '恭喜,密码修改成功！<br>您的新密码为：' + $newpass.val(), 'info');
            	 msgShow('系统提示', '恭喜,密码修改成功！' , 'info');
			} else {
					$.messager.alert('修改密码', '旧密码错误！', 'warning');
			}
            
            
            });
            
        }
        $(function() {
            openPwd();
            $('#editpass').click(function() {
                $('#w').window('open');
            });
            $('#btnEp').click(function() {
                serverLogin();
            })
			$('#btnCancel').click(function(){closePwd();})
            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {
                    if (r) {
                        location.href = '/KJCPlatform/';
                    }
                });
            })
        })
		
		
</script>

</head>
<body class="easyui-layout" style="overflow-y: hidden" fit="true"
    scroll="no">
    <noscript>
        <div
            style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
            <img src="<%=basePath%>/images/noscript.gif"
                alt='抱歉,请开启脚本支持！' />
        </div>
    </noscript>

    <div region="north" split="true" border="false"
        style="overflow: hidden; height: 30px;
        background: url(<%=basePath%>/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">欢迎
            <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a>
        </span> <span style="padding-left:10px; font-size: 20px; "><img
            src="<%=basePath%>/images/blocks.gif" width="20" height="20"
            align="absmiddle" /> 湖北省国防科工办科技质量处信息管理系统</span>
    </div>
    <div region="south" split="true"
        style="height: 30px; background: #D2E0F2; ">
        <div class="footer">By 湖北省国防科学技术工业办公室 jQuery.Easy-UI</div>
    </div>
    <div region="west" split="true" title="导航菜单" style="width:180px;"
        id="west">
        <div id="nav">
            <!--  导航内容 -->

        </div>

    </div>
    <div id="mainPanle" region="center"
        style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs" fit="true" border="false">
            <div title="欢迎使用"
                style="padding:20px;overflow:hidden; color:red; text-align:center;">
                <br>
                <br>
                <h1 style="font-size:24px;">欢迎使用湖北省国防科工办科技质量处信息管理系统</h1>
                <h1 style="font-size:40px;">国家秘密高于一切</h1>
                <h1 style="font-size:40px;">保密责任重于泰山</h1>
            </div>
        </div>
    </div>


    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false"
        minimizable="false" maximizable="false" icon="icon-save"
        style="width: 300px; height: 200px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false"
                style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                    <tr>
                        <td>输入旧密码：</td>
                        <td><input id="txtOldPass" type="Password"
                            class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="Password"
                            class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认新密码：</td>
                        <td><input id="txtRePass" type="Password"
                            class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false"
                style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok"
                    href="javascript:void(0)"> 确定</a> <a id="btnCancel"
                    class="easyui-linkbutton" icon="icon-cancel"
                    href="javascript:void(0)">取消</a>
            </div>
        </div>
    </div>

    <div id="mm" class="easyui-menu" style="width:150px;">
        <div id="tabupdate">刷新</div>
        <div class="menu-sep"></div>
        <div id="close">关闭</div>
        <div id="closeall">全部关闭</div>
        <div id="closeother">除此之外全部关闭</div>
        <div class="menu-sep"></div>
        <div id="closeright">当前页右侧全部关闭</div>
        <div id="closeleft">当前页左侧全部关闭</div>
        <div class="menu-sep"></div>
        <div id="exit">退出</div>
    </div>
</body>
</html>
