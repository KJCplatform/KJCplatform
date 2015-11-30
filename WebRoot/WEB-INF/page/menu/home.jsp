<%@ page language="java"  pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String rights=(String)request.getSession().getAttribute("globle_rights");
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" content="ie=edge"/> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>湖北省国防科技工业科技信息管理系统</title>
    <link href="<%=basePath%>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/script/easyui/themes/icon.css" />
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/script/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/script/index.js"> </script>

<script type="text/javascript">
	var _menus = { "menus":
	[<%if(rights.contains("1")){%>
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
				"child":[
							{
								"menuid": "121",
								"menuname": "质量管理专家",
								"icon": "icon-nav",
								"url": "<%=basePath%>/administration/kjjszjcjb1.jsp"
								
							},
							{
								"menuid": "122",
								"menuname": "计量管理专家",
								"icon": "icon-nav",
								"url": "<%=basePath%>/administration/kjjszjcjb2.jsp"
								
							},
							{
								"menuid": "123",
								"menuname": "科技专家",
								"icon": "icon-nav",
								"url": "<%=basePath%>/administration/kjjszjcjb3.jsp"
								
							},
							{
								"menuid": "124",
								"menuname": "许可专家",
								"icon": "icon-nav",
								"url": "<%=basePath%>/administration/kjjszjcjb4.jsp"
								
							}
						]
				
				
				//"url": "http://hxling.cnblogs.com",
				
// 				"child": [{
// 					"menuid": "121",
// 					"menuname": "计量机构",
// 					"icon": "icon-role",
// 					"url": "demo2.html"
// 					},
					
// 					{
// 					"menuid": "122",
// 					"menuname": "高技术企业",
// 					"icon": "icon-role",
// 					"url": "demo.html"
// 					},
// 					{
// 					"menuid": "123",
// 					"menuname": "军工企业",
// 					"icon": "icon-role",
// 					"url": "demo.html"
// 					},
// 					{
// 					"menuid": "124",
// 					"menuname": "专家通讯录",
// 					"icon": "icon-role",
// 					"url": "demo.html"
// 					},
// 					{
// 					"menuid": "125",
// 					"menuname": "项目目录",
// 					"icon": "icon-set",
// 					"url": "demo.html"
// 					},
// 					{
// 					"menuid": "126",
// 					"menuname": "成果目录",
// 					"icon": "icon-set",
// 					"url": "demo.html"
// 					},
// 					{
// 					"menuid": "127",
// 					"menuname": "专项目录",
// 					"icon": "icon-set",
// 					"url": "demo.html"
// 					}					
// 				]
			}
// 			,{
// 				"menuid": "13",
// 				"menuname": "行业通讯库",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/administration/hytxk.jsp"
				
// 			}
			
		]
		
	},<%}if(rights.contains("2")){%>
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
//			{
//			    "menuid": "214",
//				"menuname": "农作物新品种成果",
//				"icon": "icon-nav",
//				"url": "<%=basePath%>/administration/kjnzwcjb.jsp"
//			},
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
//			{
//				"menuid": "217",
//				"menuname": "融资需求",
//				"icon": "icon-nav",
//				"url": "<%=basePath%>/administration/kjrzxqcjb.jsp" }
			]		
		},
		{
			"menuid": "22",
			"menuname": "高新技术企业信息",
			"icon": "icon-nav",
			 "url": "<%=basePath%>/administration/kjndgxjsqypjb.jsp"
		},
		{
			"menuid": "23",
			"menuname": "军品科研项目",
			"icon": "icon-nav",
			"url": "demo.html",
			"child":[{
			    "menuid": "231",
				"menuname": "军品科研项目汇总表",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjndjpptkyxmb.jsp"	
			},
			{
			    "menuid": "232",
				"menuname": "军品科研项目执行情况表",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjndjpptkyxmb2.jsp"	
			}
			]
			
			
		},
		{
			"menuid": "24",
			"menuname": "湖北省科学技术奖励",
			"icon": "icon-nav",
	        "url": "<%=basePath%>/administration/kjgfjflqk.jsp"	
		},
		{
			"menuid": "52",
			"menuname": "大型仪器信息表",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/aaa.jsp"
			
		},
		{
			"menuid": "25",
			"menuname": "国防科学技术奖",
			"icon": "icon-nav",
			"url": "demo.html",
			"child":[{
				"menuid": "251",
				"menuname": "1.****年度我省获国防科学技术进步奖和发明奖统计表",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjndgfjtjb.jsp"
				
			},
			{
				"menuid": "252",
				"menuname": "2.****期间至****年度我省获国家科学技术奖国防科技工业专用项目特等奖统计",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjgjkjjgfxmtj.jsp"
				
			},
			{
				"menuid": "253",
				"menuname": "3.****至****年度我省获国家科学技术奖国防科技工业专用项目统计",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjgjkjjgftdtj.jsp"
				
			},
			{
				"menuid": "254",
				"menuname": "4.年度我省军工单位获湖北省科学技术奖励情况表",
				"icon": "icon-nav",
			    "url": "<%=basePath%>/administration/kjndjgkjjlqkb.jsp"
				
			}]
			
			
			
			
		},
// 		{
// 			"menuid": "26",
// 			"menuname": "技术专家信息",
// 			"icon": "icon-nav",
// 			"url": "",
// 			"child":[{
// 				"menuid": "261",
// 				"menuname": "数据录入-技术专家信息",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/project/expert.jsp"
// 			},{
// 				"menuid": "262",
// 				"menuname": "信息查询-技术专家信息",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/project/search.jsp"
// 			}]	
// 		},
// 	{
// 			"menuid": "28",
// 			"menuname": "科技项目信息",
// 			"icon": "icon-nav",
// 			"url": "demo.html",
// 			"child":[{
// 				"menuid": "281",
// 				"menuname": "军转民科技项目信息",
// 				"icon": "icon-nav",
// 				"url": "demo.html",
// 				"child":[{
// 				"menuid": "2811",
// 				"menuname": "数据录入-军转民科技项目信息",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/project/kjkjxmxxb.jsp"
// 			},{
// 				"menuid": "2812",
// 				"menuname": "信息查询-军转民科技项目信息",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/project/kjkjxmxxb_search.jsp"
// 			}]
// 			},{
// 				"menuid": "282",
// 				"menuname": "民参军科技项目信息",
// 				"icon": "icon-nav",
// 				"url": "demo.html",
// 				"child":[{
// 				"menuid": "2821",
// 				"menuname": "数据录入-民参军科技项目信息",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/project/kjkjxmxxb2.jsp"
// 			},{
// 				"menuid": "2822",
// 				"menuname": "信息查询-民参军科技项目信息",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/project/kjkjxmxxb_search2.jsp"
// 			}]
// 			},
			
// 		{
// 				"menuid": "283",
// 				"menuname": "科技项目库",
// 				"icon": "icon-nav",
// 				"url": "<%=basePath%>/administration/kjkjxmk.jsp"
				
// 		}
		
			{
			"menuid": "28",
			"menuname": "科技项目信息",
			"icon": "icon-nav",
			"url": "demo.html",
			"child":[{
				
				"menuid": "2811",
				"menuname": "录入-军转民",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb.jsp"
			},{
				"menuid": "2812",
				"menuname": "查询-军转民",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb_search.jsp"
			}
			,{
			
				"menuid": "2821",
				"menuname": "录入-民参军",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb2.jsp"
			},{
				"menuid": "2822",
				"menuname": "查询-民参军",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb_search2.jsp"
			
			},
			
		{
				"menuid": "283",
				"menuname": "科技项目库",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/kjkjxmk.jsp"
				
		},
			
		{
				"menuid": "284",
				"menuname": "科技项目信息汇总",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjkjxmxxb0.jsp"
				
		}
				]
		},
		{
			"menuid": "29",
			"menuname": "高新技术企业认定备案信息",
			"icon": "icon-nav",
			"url": "",
			"child":[{
				"menuid": "291",
				"menuname": "数据录入-高新技术企业认定备案信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjgxqybab.jsp"
			},{
				"menuid": "292",
				"menuname": "信息查询-高新技术企业认定备案信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/kjgxqybab_search.jsp"
			},	{
				"menuid": "293",
				"menuname": "汇总表-高新技术企业认定备案信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/kjndgxqybab.jsp"
				
		}
			
			
			]	
		}
		
		
		
	]
		
	},<%}if(rights.contains("3")){%>
	{
		"menuid": "3",
		"icon": "icon-sys",
		"menuname": "军品质量管理",
		"menus":[
		{
			"menuid": "31",
			"menuname": "军工产品质量",
			"icon": "icon-nav",
			//"url": "demo.html"	
			"url": "<%=basePath%>/administration/jpzlzkjbb.jsp"			
		},
		{
			"menuid": "32",
			"menuname": "质量事故",
			"icon": "icon-nav",
			"url": "<%=basePath%>/administration/jpsgwtbb.jsp"			
		},
		{
			"menuid": "33",
			"menuname": "国防质量报告统计表",
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
	},<%}if(rights.contains("4")){%>
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
		},
		{
			"menuid": "44",
			"menuname": "军工单位基本情况信息",
			"icon": "icon-nav",
			"url": "",
			"child":[{
				"menuid": "441",
				"menuname": "数据录入-军工单位基本情况信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/jpjgdwjbqk.jsp"
			},{
				"menuid": "442",
				"menuname": "信息查询-军工单位基本情况信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/jpjgdwjbqk_search.jsp"
			},{
				"menuid": "443",
				"menuname": "信息汇总-军工单位基本情况信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/jpjgdwjbqk0.jsp"
			}]	
		}
		]
	},<%}if(rights.contains("5")){%>
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
				"menuid": "512A",
				"menuname": "已获得许可的武器生产专业(产品)",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/wqwqxkzxq1.jsp"	
			},
			{
				"menuid": "512B",
				"menuname": "已获得许可的武器科研专业",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/wqwqxkzxq2.jsp"	
			},
			{
				"menuid": "512C",
				"menuname": "申请延续的武器装备科研生产许可专业产品",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/wqwqxkzxq3.jsp"	
			},
			{
				"menuid": "512D",
				"menuname": "申请增加的武器装备科研生产许可专业产品",
				"icon": "icon-nav",
				"url": "<%=basePath%>/administration/wqwqxkzxq4.jsp"	
			},
			
			{
				"menuid": "513",
				"menuname": "信息汇总-武器装备科研生产许可取证单位信息",
				"icon": "icon-nav",
				"url": "<%=basePath%>/project/wqwqxkzxq0.jsp"
			}]		
		}
		]	
	},<%}if(rights.contains("6")){%>
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
	},<%}if(rights.contains("7")){%>
	{
		"menuid": "7",
		"icon": "icon-sys",
		"menuname": "数据库管理",
		"menus":[{
			"menuid": "71",
			"menuname": "数据一致性管理",
			"icon": "icon-set",
			"url": "demo2.html"
		},
		{
			"menuid": "72",
			"menuname": "数据库更新",
			"icon": "icon-set",
			"url": "demo2.html"
		},
		{
			"menuid": "73",
			"menuname": "数据库备份",
			"icon": "icon-set",
			"url": "demo2.html"
		},
		{
			"menuid": "74",
			"menuname": "数据库还原",
			"icon": "icon-set",
			"url": "demo2.html"
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


            alert($newpass.val());
            var actionChange = basePath + '/system/UserAction_change.action';
            
            var params ="name="+$oldpass.val()+"&"+"password="+$newpass.val();
	  
	  
            $.post(actionChange, params, function(result) {
            if (result.operateSuccess) {
            
					 msgShow('系统提示', '恭喜,密码修改成功！<br>您的新密码为：' + $newpass.val(), 'info');
            
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
<body class="easyui-layout" style="overflow-y: hidden"  fit="true"   scroll="no">
<noscript>
<div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;">
    <img src="<%=basePath%>/images/noscript.gif" alt='抱歉,请开启脚本支持！' />
</div>
</noscript>

    <div region="north" split="true" border="false" style="overflow: hidden; height: 30px;
        background: url(<%=basePath%>/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体">
        <span style="float:right; padding-right:20px;" class="head">欢迎   <a href="#" id="editpass">修改密码</a> <a href="#" id="loginOut">安全退出</a></span>
        <span style="padding-left:10px; font-size: 20px; "><img src="<%=basePath%>/images/blocks.gif" width="20" height="20" align="absmiddle" /> 湖北省国防科技工业科技信息管理系统</span>
    </div>
    <div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
        <div class="footer">By 湖北省国防科学技术工业办公室      jQuery.Easy-UI </div>
    </div>
    <div region="west" split="true"  title="导航菜单" style="width:180px;" id="west">
			<div id="nav">
		<!--  导航内容 -->
				
			</div>

    </div>
    <div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
			<div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; text-align:center;" >
				<br><br>
				<h1 style="font-size:24px;">欢迎使用湖北省国防科学技术工业办公室软件平台</h1>
				<h1 style="font-size:40px;">国家秘密高于一切</h1>
				<h1 style="font-size:40px;">保密责任重于泰山</h1>
			</div>
		</div>
    </div>
    
    
    <!--修改密码窗口-->
    <div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height: 200px; padding: 5px;
        background: #fafafa;">
        <div class="easyui-layout" fit="true">
            <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
                <table cellpadding=3>
                 <tr>
                        <td>输入旧密码：</td>
                        <td><input id="txtOldPass" type="Password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>新密码：</td>
                        <td><input id="txtNewPass" type="Password" class="txt01" /></td>
                    </tr>
                    <tr>
                        <td>确认新密码： </td>
                        <td><input id="txtRePass" type="Password" class="txt01" /></td>
                    </tr>
                </table>
            </div>
            <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;">
                <a id="btnEp" class="easyui-linkbutton" icon="icon-ok" href="javascript:void(0)" >
                    确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a>
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
