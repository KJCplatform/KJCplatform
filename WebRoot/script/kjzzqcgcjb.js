//JQuery的入口
//获取当前网址，如： http://localhost:8080/ems/Pages/Basic/Person.jsp
var curWwwPath = window.document.location.href;
//获取主机地址之后的目录，如： /ems/Pages/Basic/Person.jsp
var pathName = window.document.location.pathname;
var pos = curWwwPath.indexOf(pathName);
//获取主机地址，如： http://localhost:8080
var localhostPath = curWwwPath.substring(0, pos);
//获取带"/"的项目名，如：/ems
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
var basePath = localhostPath + projectName;
var user;
$(function() {
	listDoc();
	// 日期加上日期控件
	$("#wcsj").datebox({
		editable:false,
		required : true
	});

	// 给文本框加上验证器
	$("#cgmc").validatebox({
		required : true,
		missingMessage : '不能为空'
	});
	$("#wcdw").validatebox({
		required : true,
		missingMessage : '不能为空'
	});

	$('#jsly').combotree();
	$('#jsly').combotree('loadData', 
	[{ id: "一", text: '一、信息',
		children: [{ id: "11", text: '网络设备' },
		           { id: "12", text: '光传输设备' },
		           { id: "13", text: '接入网系统设备' },
		           { id: "14", text: '数字移动通信产品' },
		           { id: "15", text: '数字音视频产品' },
		           { id: "16", text: '计算机及外部设备' },
		           { id: "17", text: '软件及应用系统' },
		           { id: "18", text: '信息安全产品与系统' },
		           { id: "191", text: '集成电路' },
		           { id: "192", text: '信息功能材料与器件' },
		           { id: "193", text: '电子专用设备、仪器和工模具' },
		           { id: "194", text: '新型显示器件' },
		           { id: "195", text: '新型元器件' },
		           { id: "196", text: '汽车电子' },
		           { id: "197", text: '民用雷达' }
		           ]},
	 {id: "二", text: '二、生物',
		children: [{ id: "21", text: '生物反应及分离技术' },
		           { id: "22", text: '生物制造关键技术及重大产品' },
		           { id: "23", text: '新型疫苗' },
		           { id: "24", text: '重大疾病创新药物及关键技术' },
		           { id: "25", text: '生物技术药物及关键技术' },
		           { id: "26", text: '单克隆抗体系列产品与检测试剂' },
		           { id: "27", text: '新型给药技术及药物新剂型' },
		           { id: "28", text: '计划生育药具' },
		           { id: "291", text: '中药材及饮片' },
		           { id: "292", text: '中药制品' },
		           { id: "293", text: '中药制药工艺及设备' },
		           { id: "294", text: '生物医学材料' },
		           { id: "295", text: '新型医用精密诊断及治疗设备' },
		           { id: "296", text: '医学信息技术及远程医疗' },
		           { id: "297", text: '生物芯片' },
		           { id: "298", text: '生物材料及产品' },
		           { id: "299", text: '功能性食品' }
		           
		           ]},
	 {id: "三", text: '三、航空航天',
		 children: [{ id: "31", text: '民用飞机' },
		       		 { id: "32", text: '空中交通管理系统' },
		       		 { id: "33", text: '新一代民用航空运输系统' },
		       		 { id: "34", text: '卫星通信应用系统' },
		       		 { id: "35", text: '卫星导航应用服务系统' },
		       		 { id: "36", text: '卫星遥感应用系统' }
		       	
		       		           
		       		]},
	{id: "四", text: '四、新材料',
	      children: [{ id: "41", text: '纳米材料' },
			           { id: "42", text: '高性能、低成本钢铁材料' },
			           { id: "43", text: '高性能镁、铝、钛合金材料' },
			           { id: "44", text: '特种功能材料' },
			           { id: "45", text: '稀土材料' },
			           { id: "46", text: '高温结构材料' },
			           { id: "47", text: '新型建筑节能材料' },
			           { id: "48", text: '重交通道路沥青' },
			           { id: "491", text: '高分子材料及新型催化剂' },
			           { id: "492", text: '复合材料' },
			           { id: "493", text: '特种纤维材料' },
			           { id: "494", text: '环境友好材料' },
			           { id: "495", text: '膜材料及组件' },
			           { id: "496", text: '金属粉体材料及粉末冶金技术' },
			           { id: "497", text: '表面涂、镀层材料' },
			           { id: "498", text: '盐湖及海水提锂、提镁技术' },
			           { id: "4991", text: '新型纺织材料及印染后整理技术' },
			           { id: "4992", text: '高性能密封材料' },
			           { id: "4993", text: '子午线轮胎生产技术和关键原材料' },
			           { id: "4994", text: '金属、无机非金属多孔复合催化材料' },
			           { id: "4995", text: '油田用助剂' },
			           { id: "4996", text: '造纸用助剂' },
			           { id: "4997", text: '新型选矿设备及药剂' },
			           { id: "4998", text: '核工程用特种材料' }
			           
			           ]},	 
			       			           
    {id: "五", text: '五、先进能源',
		children: [{ id: "51", text: '动力电池及储能电池' },
		           { id: "52", text: '氢开发与利用' },
		           { id: "53", text: '风能' },
		           { id: "54", text: '太阳能' },
		           { id: "55", text: '生物质能' },
		           { id: "56", text: '地热能与海洋能' },
		           { id: "57", text: '石油勘探开发技术及设备' },
		           { id: "58", text: '油品加工技术及设备' },
		           { id: "591", text: '长距离高压油气输送设备' },
		           { id: "592", text: '煤炭高效安全生产、开发与转化利用' },
		           { id: "593", text: '高效低污染燃煤发电及水电技术系统' },
		           { id: "594", text: '核电及核燃料循环' },
		           { id: "595", text: '电网输送及安全保障技术' }
		        
		           
		           ]},	
     {id: "六", text: '六、现代农业',
 		children: [{ id: "61", text: '农作物新品种' },
 		           { id: "62", text: '蔬菜、水果等园艺作物新品种' },
 		           { id: "63", text: '林木、花卉新品种' },
 		           { id: "64", text: '畜禽水产新品种' },
 		           { id: "65", text: '新型设施农业技术' },
 		           { id: "66", text: '安全高效、规模化畜禽清洁养殖技术' },
 		           { id: "67", text: '安全高效淡水产品清洁养殖技术' },
 		           { id: "68", text: '农林节水技术与设备' },
 		           { id: "691", text: '新型高效生物肥料' },
 		           { id: "692", text: '新型安全饲料' },
 		           { id: "693", text: '农业动物重大疫病预防控制' },
 		           { id: "694", text: '水产疫病预防控制' },
 		           { id: "695", text: '农林植物有害生物检疫、预防、控制' },
 		           { id: "696", text: '数字化农林技术与装备' },
 		           { id: "697", text: '农林产品加工技术与装备' },
 		           { id: "698", text: '农林业生物质材料精深加工与利用' },
 		           { id: "6991", text: '农林业机械' },
 		           { id: "6992", text: '粮食储藏与流通' }
 		           ]},
{id: "七", text: '七、先进制造',
 		children: [{ id: "71", text: '工业自动化' },
 		           { id: "72", text: '网络化制造' },
 		           { id: "73", text: '现代科学仪器设备' },
 		           { id: "74", text: '新型传感器' },
 		           { id: "75", text: '精密高效和成形设备' },
 		           { id: "76", text: '激光加工技术及设备' },
 		           { id: "77", text: '高精度数控机床及功能部件' },
 		           { id: "78", text: '机器人' },
 		           { id: "791", text: '大型石油化工成套设备' },
 		           { id: "792", text: '关键机械基础件' },
 		           { id: "793", text: '电力电子器件及变流装置' },
 		           { id: "794", text: '汽车关键零部件' },
 		           { id: "795", text: '高效节能内燃机' },
 		           { id: "796", text: '数字化专用设备' },
 		           { id: "797", text: '快速制造技术及设备' },
 		           { id: "798", text: '大型构件制造技术及装备' },
 		           { id: "7991", text: '大型部件自动化柔性装配技术及装备' },
 		           { id: "7992", text: '核技术应用' },
		 		   { id: "7993", text: '高技术船舶' },
		           { id: "7994", text: '海洋工程装备' },
		           { id: "7995", text: '轨道交通设备' }
 		           ]},
 {id: "八", text: '八、节能环保和资源综合利用',
	 		children: [{ id: "81", text: '先进节能技术' },
	 		           { id: "82", text: '饮用水安全保障技术' },
	 		           { id: "83", text: '工业和城市节水、废水处理' },
	 		           { id: "84", text: '雨水、海水、苦咸水利用' },
	 		           { id: "85", text: '大气污染与温室气体排放控制' },
	 		           { id: "86", text: '固体废弃物的资源综合利用' },
	 		           { id: "87", text: '危险固体废弃物处置技术及设备' },
	 		           { id: "88", text: '环境自动监测系统' },
	 		           { id: "891", text: '生态环境建设与保护' }
	 		           ]},
 {id: "九", text: '九、海洋',
	 		children: [{ id: "91", text: '海洋监测技术与装备' },
	 		           { id: "92", text: '海洋生物活性物质及生物制品' },
	 		           { id: "93", text: '海水养殖良种繁育和育苗技术' },
	 		           { id: "94", text: '设施渔业和渔业工程装备' },
	 		           { id: "95", text: '海底资源环境监测、勘探技术与装备' },
	 		           { id: "96", text: '海洋环境保护与生态修复技术及装备' }
	 		         
	 		           ]},
		           
{id: "十", text: '十、高技术服务',
		children: [{ id: "101", text: '信息技术服务' },
		           { id: "102", text: '电子商务服务' },
		           { id: "103", text: '数字内容服务' },
		           { id: "104", text: '研发设计服务' },
		           { id: "105", text: '生物技术服务' },
		           { id: "106", text: '检验检测服务' },
		           { id: "107", text: '知识产权服务' },
		           { id: "108", text: '科技成果转化服务' }
		           
		           ]}]
	);
	
	$('#yyhy').combotree();
	$('#yyhy').combotree('loadData', 
			[{ id: "一", text: 'A—农、牧、林、渔业',
				children: [{ id: "11", text: '•	01—作物和牲畜生产、狩猎和相关服务' },
				           { id: "12", text: '•	02—林业与伐木业' },
				           { id: "13", text: '•	03—渔业与水产业' }]},
			
			 {id: "二", text: 'B—采矿和采石',
				children: [{ id: "21", text: '•	04—煤炭和褐煤的开采' },
				           { id: "22", text: '•	05—石油及天然气的开采' },
				           { id: "23", text: '•	06—金属矿的开采' },
				           { id: "22", text: '•	07—其他采矿和采石' },
				           { id: "23", text: '•	08—开采辅助服务' }]},
           {id: "三", text: 'C—制造业',
				children: [{ id: "31", text: '•	09—食品制造' },
				           { id: "32", text: '•	10—饮料制造' },
				           { id: "33", text: '•	11—烟草制品制造' },
				           { id: "34", text: '•	12—纺织品制造' },
				           { id: "35", text: '•	13—服装制造' },
				           { id: "36", text: '•	14—皮革和相关产品制造' },
				           { id: "37", text: '•	15—木材、木材制品及软木制品的制造(家具除外)、草编制品及编织材料物品制造' },
				           { id: "38", text: '•	16—纸和纸制品制造' },
				           { id: "391", text: '• 17—记录媒介物的印刷及复制' },
				           { id: "392", text: '• 18—焦炭和精炼石油产品制造' },
				           { id: "393", text: '• 19—化学品及化学制品制造' },
				           { id: "394", text: '• 20—基本医药产品和医药制剂制造' },
				           { id: "395", text: '• 21—橡胶和塑料制品制造' },
				           { id: "396", text: '• 22—其他非金属矿物制品制造' },
				           { id: "397", text: '• 23—基本金属制造' },
				           { id: "398", text: '• 24—机械设备除外的金属制品制造' },
				           { id: "3991", text: '• 25—计算机、电子产品和光学产品制造' },
				           { id: "3992", text: '• 26—电力设备制造' },
				           { id: "3993", text: '• 27—未另分类的机械和设备制造' },
				           { id: "3994", text: '• 28—汽车、挂车和半挂车制造' },
				           { id: "3995", text: '• 29—其他运输设备制造' },
				           { id: "3996", text: '• 30—家具制造' },
				           { id: "3997", text: '• 31—其他制造业' },
				           { id: "3998", text: '• 32—机械和设备的修理和安装' }
				      ]},
	      { id: "四", text: 'D—电、煤气、蒸气和空调供应',
				children: [{ id: "41", text: '•	33—电、煤气、蒸气和空调供应' }]},
			{id: "五", text: 'E—供水；污水处理、废物管理和补救',
				children: [{ id: "51", text: '•	34—集水、水处理与水供应' },
				           { id: "52", text: '•	35—污水处理' },
				           { id: "53", text: '•	36—废物的收集、处理和处置；材料回收' },
				           { id: "54", text: '•	37—补救和其他废物管理服务' }]},
           {id: "六", text: 'F—建筑业',
				children: [{ id: "61", text: '•	38—楼宇建筑' },
				           { id: "62", text: '•	39—土木工程' },
				           { id: "63", text: '•	40—特殊建筑' }]},
           {id: "七", text: 'G——批发和零售业；汽车和摩托车修理',
				children: [{ id: "71", text: '•	41—批发和零售业；汽车和摩托车修理' },
				           { id: "72", text: '•	42—汽车和摩托车外的批发贸易' },
				           { id: "73", text: '•	43—汽车和摩托车外的零售贸易' }]},
           {id: "八", text: 'H—运输与存储',
				children: [{ id: "81", text: '•	44—陆路运输与管道运输' },
				           { id: "82", text: '•	45—水上运输' },
				           { id: "83", text: '•	46—航空运输' },
				           { id: "84", text: '•	47—储存和运输辅助' },
				           { id: "85", text: '•	48—邮政和邮递' }]},
           {id: "九", text: 'I—食宿服务',
				children: [{ id: "91", text: '•	49—住宿' },
				           { id: "92", text: '•	50—食品和饮料供应服务' }]},
           {id: "十", text: 'J—信息和通信',
				children: [{ id: "101", text: '• 51—出版' },
				           { id: "102", text: '• 52—电影、录像和电视节目制作、录音及音乐作品出版' },
				           { id: "103", text: '• 53—电台和电视广播' },
				           { id: "104", text: '• 54—电信' },
				           { id: "105", text: '• 55—计算机程序设计、咨询及相关' },
				           { id: "106", text: '• 56—信息服务' }]},
	       {id: "十一", text: 'K—金融和保险',
				children: [{ id: "111", text: '• 57—保险和养恤金之外的金融服务' },
				           { id: "112", text: '• 58—强制性社会保障除外的保险、再保险和养恤金' },
				           { id: "113", text: '• 59—金融保险服务及其附属' }]},
           { id: "十二", text: 'L—房地产',
				children: [{ id: "121", text: '• 60—房地产' }]},
				           
		 {id: "十三", text: 'M—专业、科学和技术',
			children: [{ id: "131", text: '• 61—法律和会计' },
			           { id: "132", text: '• 62—总公司的；管理咨询' },
			           { id: "133", text: '• 63—建筑和工程；技术测试和分析' },
			           { id: "134", text: '• 64—科学研究与发展' },
			           { id: "135", text: '• 65—广告业和市场调研' },
			           { id: "136", text: '• 66—其他专业、科学和技术'},
			           { id: "137", text: '• 67—兽医'}]},
       {id: "十四", text: 'N—行政和辅助',
			children: [{ id: "141", text: '• 68—出租和租赁' },
			           { id: "142", text: '• 69—就业' },
			           { id: "143", text: '• 70—旅行社、旅游经营者、预订服务及相关' },
			           { id: "144", text: '• 71—调查和安全' },
			           { id: "145", text: '• 72—宇和院落景观提供的服务' },
			           { id: "146", text: '• 73—室行政管理、办公支持和其他企业辅助' }]},
       { id: "十五", text: 'O—公共管理与国防；强制性社会保障',
			children: [{ id: "151", text: '• 74—管理与国防；强制性社会保障' }]},
		{ id: "十六", text: 'P—教育',
			children: [{ id: "161", text: '• 75—教育' }]},
		{id: "十七", text: 'Q—人体健康和社会工作',
			children: [{ id: "171", text: '• 76—人体健康' },
			           { id: "172", text: '• 77—留宿护理' },
			           { id: "173", text: '• 78—不配备食宿的社会服务' }]},
       {id: "十八", text: 'R—艺术、娱乐和文娱',
			children: [{ id: "181", text: '• 79—艺术创作和文娱' },
			           { id: "182", text: '• 80—图书馆、档案馆、博物馆及其他文化' },
			           { id: "183", text: '• 81—赌博和押宝' },
			           { id: "184", text: '• 82—体育、娱乐和文娱' }]},  
       {id: "十九", text: 'S—其他服务',
		children: [{ id: "191", text: '• 83—成员组织' },
		           { id: "192", text: '• 84—电脑及个人和家庭用品的修理' },
		           { id: "193", text: '• 85—其他个人服务' }]},
       {id: "二十", text: 'T—家庭作为雇主的；家庭自用、未加区分的物品生产和服务',
			children: [{ id: "201", text: '• 86—家庭作为家政人员雇主的' },
			           { id: "202", text: '• 87—未加区分的私人家庭自用物品生产和服务' }]},
   { id: "二十一", text: 'U—国际组织和机构',
	children: [{ id: "211", text: '• 88—国际组织和机构' }]}
			           
				           ]

	);
	
	$('#jyfs').combotree();
	$('#jyfs').combotree('loadData', 
			[{ id: "技术许可", text: '技术许可'},
				{id: "技术转让", text: '技术转让'},
				{id: "技术入股", text: '技术入股'},
				{id: "技术提成", text: '技术提成'},
				{id: "其他方式", text: '其他方式'}
			 ]
	);
	
	
});
//加载公文列表
function listDoc() {
	var actionPath = basePath + '/system/KjzzqcgcjbAction_list.action';
	 $('#dg').datagrid({
            title : '软件著作权',
            //width : 1200,
            height: 400,
            //fit: true,
			fitColumns : true, // 自动适应列宽      
            pageSize : 5,//默认选择的分页是每页5行数据
            pageList : [ 5, 10, 15, 20 ],//可以选择的分页集合
            nowrap : true,//设置为true，当数据长度超出列宽时将会自动截取
            toolbar:"#toolbar",//在添加 增添、删除、修改操作的按钮要用到这个
            url:actionPath,//url调用Action方法
            loadMsg : '数据装载中......',
            singleSelect:true,//为true时只能选择单行
            //sortName : 'xh',//当数据表格初始化时以哪一列来排序
            //sortOrder : 'desc',//定义排序顺序，可以是'asc'或者'desc'（正序或者倒序）。
            pagination : true,//分页
            rownumbers : true,//行数
			
            onLoadSuccess: function (data) { 
				user=eval(data).user;
			//	alert("user="+user);
			}
        });
	 
	 setTimeout(
			 function(){
				// alert("Hello world");
				 if(user=="admin"){
					// alert("admin");
					 $('#dg').datagrid({
						 toolbar:[ {// 工具栏
								text : '添加',
								iconCls : 'icon-add', // 图标
								handler : function() { // 处理函数
									addDoc();
								}
							}, {
								text : '删除',
								iconCls : 'icon-cancel', // 图标
								handler : function() { // 处理函数
									deleteDoc();
								}
							}, {
								text : '编辑',
								iconCls : 'icon-edit',// 图标
								handler : function() {// 处理函数
									editDoc();
								}
							}
						 ]
					 });
				 }
				 else{
					// alert("user1");
				 $('#dg').datagrid({
					 toolbar:[ {// 工具栏
							text : '添加',
							iconCls : 'icon-add', // 图标
							handler : function() { // 处理函数
								addDoc();
							}
						} ]
				 });
				 
				 }
			 },300);
	 
}
//查询
function doSearch(){
	$('#dg').datagrid('load',{
		cgmc: $('#fileName').val(),
		wcdw: $('#fileId').val()
	});
}
// 显示编辑窗口
function showEditForm() {
	$("#tabEdit").dialog({
		modal : true,// 模式窗口
		title : '软件著作权',
		iconCls : 'icon-save',
		width :  '55%',
	       height:  '100%',
		buttons : [ {
			text : '确认',
			handler : function() {
				// 进行表单字段验证，当全部字段都有效时返回true和validatebox一起使用
				if ($('#frmEdit').form('validate')) {
					// 提交到服务器并写入数据库
					dealSave();
					// 关闭窗口
					closeForm();
				} else {
					$.messager.alert('验证', '信息有误或不完整', 'error');
				}
			}
		}, {
			text : '取消',
			handler : function() {
				closeForm();
			}
		} ]
	});
}

// 关闭窗口
function closeForm() {
	$("#frmEdit").form('clear');
	$('#tabEdit').dialog('close');
}

// 添加的函数
function addDoc() {
	// 清空原有的数据
	$('#frmEdit').form('clear');
	// 显示添加对话框
	showEditForm();
}

// 编辑按钮的操作
function editDoc() {
	var doc = $('#dg').datagrid('getSelected');// 得到选中的一行数据
	// 如果没有选中记录
	if (doc	== null) {
		$.messager.alert('文件', '请先选中要编辑的文件', 'info');
		return;
	}
	$('#frmEdit').form('clear');
	// 填充数据
	
	//$("#fwrq").datebox("getValue");
	
	$("#id").val(doc.id);
	$("#cgmc").val(doc.cgmc);
	$("#wcdw").val(doc.wcdw); 
	$("#zywcr").val(doc.zywcr);	
	$("#wcsj").datebox("setValue", doc.wcsj.substring(0, 10));
	$("#rzbh").val(doc.rzbh);
	$("#cgjj").val(doc.cgjj);
	$("#yyhy").combotree("setValue", doc.yyhy);
	$("#jsly").combotree("setValue", doc.jsly);
	$("#cgjd").val(doc.cgjd);
	$("#jyfs").combotree("setValue", doc.jyfs);
	$("#sfzj").val(doc.sfzj);
	$("#gfdj").val(doc.gfdj);
	$("#zhyq").val(doc.zhyq);
	$("#sfgk").val(doc.sfgk);
	$("#fbrxz").val(doc.fbrxz);
	$("#lxrxm").val(doc.lxrxm);
	$("#gddh").val(doc.gddh);
	$("#szdq").val(doc.szdq);	
	$("#sj").val(doc.sj);
	$("#dzyx").val(doc.dzyx);
	$("#lxdz").val(doc.lxdz);

	// 显示编辑页面
	showEditForm();
}
function dealSave() {
	// 表单数据序列化成一个字符串用&拼接
	var params = $("#frmEdit").serialize();
	var actionAdd = basePath + '/system/KjzzqcgcjbAction_add.action';
	var actionUpdate = basePath + '/system/KjzzqcgcjbAction_update.action';
	// 得到doc的值，为空串表示添加的值，为空串表示添加
	//alert(params);
	if ($("#id").val() == "") {
		$.post(actionAdd, params, function(result) {
			if (result.operateSuccess) {
					$('#dg').datagrid('reload');// 重新加载
					$.messager.alert('添加', '添加成功', 'info');
			} else {
					$.messager.alert('添加', '添加失败', 'warning');
				}
		});
		} else {
		// 表示更新
			$.post(actionUpdate, params, function(result) {
				if (result.operateSuccess) {
					$('#dg').datagrid('reload');// 重新加载
						$.messager.alert('更新', '更新成功', 'info');
				} else {
						$.messager.alert('更新', '更新失败', 'warning');
					}
			});
		}
	}
//保存操作第二种实现方法
function save(){
	$('#frmEdit').form('submit',{
		url: url,
		onSubmit: function(){
			return $(this).form('validate');
		},
		success: function(result){
			var result = eval('('+result+')');
			if (result.success){
				$('#frmEdit').dialog('close');		// close the dialog
				$('#dg').datagrid('reload');	// reload the user data
			} else {
				$.messager.show({
					title: 'Error',
					msg: result.msg
				});
			}
		}
	});
}

// 删除
function deleteDoc() {
	var doc = $('#dg').datagrid('getSelected');// 得到选中的一行数据
	// 如果没有选中记录
	if (doc == null) {
		$.messager.alert('删除', '请先选中要删除的文件', 'info');
		return;
	}
	$.messager.confirm('确认', '真的要删除选中的记录吗？', function(r) {
		if (r) {
			var actionPath = basePath + '/system/KjzzqcgcjbAction_delete.action?id=';
			var url = actionPath + doc.id;
			// 试一下get方法（地址，回调函数）
			$.get(url, function(result) {
				//alert(result);
				if (result.operateSuccess) {
					$.messager.alert('删除', '选中的文件成功删除！', 'info');
					// 重新加载
					$("#dg").datagrid('reload');
				} else {
					$.messager.alert('删除', '删除失败！', 'warning');
				}
			});
		}
	});
}













function ShowImport(){
	
//	  var file_upl = document.getElementById('uploadExcel');
//	  file_upl.select();
//	  var fileName = document.selection.createRange().text;
//	alert(fileName);
	
	  //得到上传文件的全路径  
	  var fileName= $('#uploadExcel').filebox('getValue');  
//	
	  
	 // alert(fileName);
	          //进行基本校验  
	          if(fileName==""){
	             $.messager.alert('提示','请选择上传文件！','info');   
	          }else{
	              //对文件格式进行校验  
	              var d1=/\.[^\.]+$/.exec(fileName);   
	              if(d1==".xls"){  
	                   //提交表单  
	                   //document.getElementById("questionTypesManage").action="${pageContext.request.contextPath}/leadtoQuestionTypes/leadInExcelQuestionBank?questionType="+questionTypes+"&courseType="+courseType;  
	            	//document.getElementById("questionTypesManage").submit();     
	            		var params ="cgmc="+fileName;
	            		var showimport = basePath + '/system/KjzzqcgcjbAction_showimport.action';

	            		//alert(params);
	            		
	          		$.post(showimport, params, function(result) {
	        			if (result.operateSuccess) {
	        					$('#dg').datagrid('reload');// 重新加载
	        					$.messager.alert('导入', '导入Excel成功', 'info');
	        				
	        			}else {
	        					$.messager.alert('导入', '导入Excel失败', 'warning');
	        				}
	        		});
	          		
	            	  
	            	  return false;
	             }else{  
	                 $.messager.alert('提示','请选择xls格式文件！','info');   
	                 $('#uploadExcel').filebox('setValue','');
	             }
	          } 
	   }



function ShowExport(){
	  
	var Items = document.getElementsByName("Items"); 
	var params ="cgmc=";
	
    for(var i = 0; i < Items.length; i++) 
    { 
       if(Items[i].checked == true) 
       { 
    	   params+=Items[i].value+" "; 
       } 
    } 

	//alert(params);

	var showimport = basePath + '/system/KjzzqcgcjbAction_showexport.action';
	            				
	$.post(showimport, params, function(result) {
	        			if (result.operateSuccess) {
	        					$('#dg').datagrid('reload');// 重新加载
	        					$.messager.alert('导出', '导出Excel成功', 'info');
	        				
	        			}else {
	        					$.messager.alert('导出', '文件被占用！导出Excel失败', 'warning');
	        				}
	        		});
  
	            	  return false;
	   }



//Excelselect
function selectExcel() {

	$("#tabEdit2").dialog({
		modal : true,// 模式窗口
		title : '导出Excel',
		iconCls : 'icon-save',
		buttons : [ {
			text : '确认',
			handler : function() {
				
				ShowExport();
				closeForm2();
			}
		}, {
			text : '取消',
			handler : function() {
				closeForm2();
			}
		} ]
	});
}


function closeForm2() {
	//$("#frmEdit2").form('clear');
	$('#tabEdit2').dialog('close');
}
