package platform.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjcgcjbDao;
import platform.domain.Kjcgcjb;
import platform.domain.Kjcgcjb;
import platform.form.KjcgcjbForm;
import platform.form.KjcgcjbForm;
import platform.service.KjcgcjbService;
import platform.util.StringHelper;

@Service(KjcgcjbService.SERVICE_NAME)
public class KjcgcjbServiceImpl implements KjcgcjbService{
	
	@Resource(name=KjcgcjbDao.SERVICE_NAME)
	private KjcgcjbDao kjcgcjbDao;
	private List<KjcgcjbForm>  listtemp=new ArrayList<KjcgcjbForm> ();
	public List<KjcgcjbForm> findKjcgcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zywcr", "desc");
		List<Kjcgcjb> list=kjcgcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjcgcjbForm> formlist=this.KjcgcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjcgcjbForm> findKjcgcjbListWithPage(int pagesize,int pageno,KjcgcjbForm kjcgcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjcgcjbForm!=null&&StringUtils.isNotBlank(kjcgcjbForm.getCgmc())){
			hqlWhere += " and o.cgmc like ?";
			paramsList.add("%"+kjcgcjbForm.getCgmc()+"%");
		}
		if(kjcgcjbForm!=null&&StringUtils.isNotBlank(kjcgcjbForm.getWcdw())){
			hqlWhere += " and o.wcdw like ?";
			paramsList.add("%"+kjcgcjbForm.getWcdw()+"%");
		}
		orderby.put(" o.zywcr", "desc");
		params = paramsList.toArray();
		List<Kjcgcjb> list=kjcgcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjcgcjbForm> formlist=this.KjcgcjbPOListToVOList(list);
		
if(pageno==1){
			
			listtemp = 
					KjcgcjbPOListToVOList(kjcgcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
			}
			
		return formlist;
		
	}
	
	public void updateKjcgcjb(KjcgcjbForm kjcgcjbForm,String username){
		Kjcgcjb kjcgcjb=new Kjcgcjb();
		
		kjcgcjb.setId(Integer.valueOf(kjcgcjbForm.getId()));
		
		kjcgcjb.setCgmc(kjcgcjbForm.getCgmc());
		kjcgcjb.setWcdw(kjcgcjbForm.getWcdw());
		kjcgcjb.setZywcr(kjcgcjbForm.getZywcr());
		kjcgcjb.setWcsj(StringHelper.stringConvertDate2(kjcgcjbForm.getWcsj()));
		kjcgcjb.setDjjdh(kjcgcjbForm.getDjjdh());
		kjcgcjb.setTxxs(kjcgcjbForm.getTxxs());
		kjcgcjb.setCgjj(kjcgcjbForm.getCgjj());
		kjcgcjb.setYyhy(kjcgcjbForm.getYyhy());
		kjcgcjb.setJsly(kjcgcjbForm.getJsly());
		kjcgcjb.setCgjd(kjcgcjbForm.getCgjd());
		kjcgcjb.setJyfs(kjcgcjbForm.getJyfs());
		
		//数据校验
		if(kjcgcjbForm.getSfzj()!=null){
		if(kjcgcjbForm.getSfzj().equals("是"))
			kjcgcjb.setSfzj(1);
		else if(kjcgcjbForm.getSfzj().equals("否"))
			kjcgcjb.setSfzj(0);
		}
		kjcgcjb.setGfdj(kjcgcjbForm.getGfdj());
		kjcgcjb.setZhyq(kjcgcjbForm.getZhyq());
		
		//数据校验
		if(kjcgcjbForm.getSfgk()!=null)
		{
			if(kjcgcjbForm.getSfgk().equals("是"))
				kjcgcjb.setSfgk(1);
			else if(kjcgcjbForm.getSfgk().equals("否"))
				kjcgcjb.setSfgk(0);
		}
		if(kjcgcjbForm.getFbrxz()!=null&&!kjcgcjbForm.getFbrxz().equals(""))
		{
			if(kjcgcjbForm.getFbrxz().equals("机构"))
		kjcgcjb.setFbrxz(0);
			else if(kjcgcjbForm.getFbrxz().equals("个人"))
				kjcgcjb.setFbrxz(1);
		}
		kjcgcjb.setLxrxm(kjcgcjbForm.getLxrxm());
		kjcgcjb.setGddh(kjcgcjbForm.getGddh());
		kjcgcjb.setSzdq(kjcgcjbForm.getSzdq());
		kjcgcjb.setSj(kjcgcjbForm.getSj());
		kjcgcjb.setDzyx(kjcgcjbForm.getDzyx());
		kjcgcjb.setLxdz(kjcgcjbForm.getLxdz());
		
		
		
		kjcgcjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjcgcjb.setUsername(username);
		kjcgcjb.setGxsj(new Date().toString());
		kjcgcjb.setSubmit(0);
		
		kjcgcjbDao.update(kjcgcjb);
		
	}
	public void deleteObject(String id){
		kjcgcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjcgcjbForm kjcgcjbForm,String username){
		Kjcgcjb kjcgcjb=new Kjcgcjb();
		kjcgcjb.setCgmc(kjcgcjbForm.getCgmc());
		kjcgcjb.setWcdw(kjcgcjbForm.getWcdw());
		kjcgcjb.setZywcr(kjcgcjbForm.getZywcr());
		kjcgcjb.setWcsj(StringHelper.stringConvertDate2(kjcgcjbForm.getWcsj()));
		kjcgcjb.setDjjdh(kjcgcjbForm.getDjjdh());
		kjcgcjb.setTxxs(kjcgcjbForm.getTxxs());
		kjcgcjb.setCgjj(kjcgcjbForm.getCgjj());
		kjcgcjb.setYyhy(kjcgcjbForm.getYyhy());
		kjcgcjb.setJsly(kjcgcjbForm.getJsly());
		kjcgcjb.setCgjd(kjcgcjbForm.getCgjd());
		kjcgcjb.setJyfs(kjcgcjbForm.getJyfs());
		
		//数据校验
		if(kjcgcjbForm.getSfzj()!=null){
		if(kjcgcjbForm.getSfzj().equals("是"))
			kjcgcjb.setSfzj(1);
		else if(kjcgcjbForm.getSfzj().equals("否"))
			kjcgcjb.setSfzj(0);
		}
		kjcgcjb.setGfdj(kjcgcjbForm.getGfdj());
		kjcgcjb.setZhyq(kjcgcjbForm.getZhyq());
		
		//数据校验
		if(kjcgcjbForm.getSfgk()!=null)
		{
			if(kjcgcjbForm.getSfgk().equals("是"))
				kjcgcjb.setSfgk(1);
			else if(kjcgcjbForm.getSfgk().equals("否"))
				kjcgcjb.setSfgk(0);
		}
		
		if(kjcgcjbForm.getFbrxz()!=null&&!kjcgcjbForm.getFbrxz().equals(""))
		{
			if(kjcgcjbForm.getFbrxz().equals("机构"))
		kjcgcjb.setFbrxz(0);
			else if(kjcgcjbForm.getFbrxz().equals("个人"))
				kjcgcjb.setFbrxz(1);
		}
		kjcgcjb.setLxrxm(kjcgcjbForm.getLxrxm());
		kjcgcjb.setGddh(kjcgcjbForm.getGddh());
		kjcgcjb.setSzdq(kjcgcjbForm.getSzdq());
		kjcgcjb.setSj(kjcgcjbForm.getSj());
		kjcgcjb.setDzyx(kjcgcjbForm.getDzyx());
		kjcgcjb.setLxdz(kjcgcjbForm.getLxdz());
		
		kjcgcjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjcgcjb.setUsername(username);
		kjcgcjb.setGxsj(new Date().toString());
		kjcgcjb.setSubmit(0);
		
		kjcgcjbDao.save(kjcgcjb);
	}
	private List<KjcgcjbForm> KjcgcjbPOListToVOList(List<Kjcgcjb> list) {
		// TODO Auto-generated method stub
		List<KjcgcjbForm> formlist=new ArrayList<KjcgcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjcgcjb kjcgcjb=list.get(i);
			 
			KjcgcjbForm kjcgcjbForm=new KjcgcjbForm();
			
			kjcgcjbForm.setId(String.valueOf(kjcgcjb.getId()));
			kjcgcjbForm.setCgmc(kjcgcjb.getCgmc());
			kjcgcjbForm.setWcdw(kjcgcjb.getWcdw());
			kjcgcjbForm.setZywcr(kjcgcjb.getZywcr());
			kjcgcjbForm.setWcsj(String.valueOf(kjcgcjb.getWcsj()));
			kjcgcjbForm.setDjjdh(kjcgcjb.getDjjdh());
			kjcgcjbForm.setTxxs(kjcgcjb.getTxxs());
			kjcgcjbForm.setCgjj(kjcgcjb.getCgjj());
			kjcgcjbForm.setYyhy(kjcgcjb.getYyhy());
			kjcgcjbForm.setJsly(kjcgcjb.getJsly());
			kjcgcjbForm.setCgjd(kjcgcjb.getCgjd());
			kjcgcjbForm.setJyfs(kjcgcjb.getJyfs());
			if(kjcgcjb.getSfzj()==1)
				kjcgcjbForm.setSfzj("是");
				else if(kjcgcjb.getSfzj()==0)
					kjcgcjbForm.setSfzj("否");
				
			kjcgcjbForm.setGfdj(kjcgcjb.getGfdj());
			kjcgcjbForm.setZhyq(kjcgcjb.getZhyq());
			if(kjcgcjb.getSfgk()==1)
				kjcgcjbForm.setSfgk("是");
				else if(kjcgcjb.getSfgk()==0)
					kjcgcjbForm.setSfgk("否");
			
			if(kjcgcjb.getFbrxz()==0)
			kjcgcjbForm.setFbrxz("机构");
			else if(kjcgcjb.getFbrxz()==1)
				kjcgcjbForm.setFbrxz("个人");
			
			kjcgcjbForm.setLxrxm(kjcgcjb.getLxrxm());
			kjcgcjbForm.setGddh(kjcgcjb.getGddh());
			kjcgcjbForm.setSzdq(kjcgcjb.getSzdq());
			kjcgcjbForm.setSj(kjcgcjb.getSj());
			kjcgcjbForm.setDzyx(kjcgcjb.getDzyx());
			kjcgcjbForm.setLxdz(kjcgcjb.getLxdz());
			
			kjcgcjbForm.setJlnf(kjcgcjb.getJlnf());
			kjcgcjbForm.setUsername(kjcgcjb.getUsername());
			kjcgcjbForm.setGxsj(kjcgcjb.getGxsj());
			kjcgcjbForm.setSubmit(String.valueOf(kjcgcjb.getSubmit()));
			
			
			
			formlist.add(kjcgcjbForm);
		}
		return formlist;
	}

	
	
	
	
	
	
	@Override
	public void showimportObject(String showimport,String username)  throws Exception {
		
		String b = showimport.replace("\\", "\\\\");
		String c = b.replace("C:\\\\fakepath", "D:");

		Workbook book = Workbook.getWorkbook(new File(c));
		// Workbook book = Workbook.getWorkbook( new File(b));
		// 获得第一个工作表对象
		Sheet sheet = book.getSheet(0);
		// 得到第一列第一行的单元格

		int columnum = sheet.getColumns();// 得到列数
		int rownum = sheet.getRows();// 得到行数


		Kjcgcjb kjcgcjb=new Kjcgcjb();
		
		Cell cell= sheet.getCell(1,1);
		kjcgcjb.setCgmc(cell.getContents());
		
		cell= sheet.getCell(1,2);
		kjcgcjb.setWcdw(cell.getContents());
		
		cell= sheet.getCell(1,3);
		kjcgcjb.setZywcr(cell.getContents());
		
		cell= sheet.getCell(1,4);
		if(!cell.getContents().equals(""))
		kjcgcjb.setWcsj(StringHelper.stringConvertDate2(cell.getContents()));
		
		cell= sheet.getCell(1,5);
		kjcgcjb.setDjjdh(cell.getContents());
		
		cell= sheet.getCell(1,6);
		kjcgcjb.setTxxs(cell.getContents());
		

		cell= sheet.getCell(1,8);
		kjcgcjb.setCgjj(cell.getContents());
		
		cell= sheet.getCell(1,9);
		kjcgcjb.setYyhy(cell.getContents());
		
		cell= sheet.getCell(1,10);
		kjcgcjb.setJsly(cell.getContents());
		
		cell= sheet.getCell(1,11);
		kjcgcjb.setCgjd(cell.getContents());
		
		cell= sheet.getCell(1,13);
		kjcgcjb.setJyfs(cell.getContents());
		
		
		cell= sheet.getCell(1,15);
		if(!cell.getContents().equals("")){
		if(cell.equals("是"))
			kjcgcjb.setSfzj(1);
		else if(cell.equals("否"))
			kjcgcjb.setSfzj(0);
		}
		
		cell= sheet.getCell(1,17);
		kjcgcjb.setGfdj(cell.getContents());
		
		cell= sheet.getCell(1,20);
		kjcgcjb.setZhyq(cell.getContents());
		
		cell= sheet.getCell(1,21);
		if(!cell.getContents().equals(""))
		{
			if(cell.equals("是"))
				kjcgcjb.setSfgk(1);
			else if(cell.equals("否"))
				kjcgcjb.setSfgk(0);
		}
		
		////
		cell= sheet.getCell(1,22);
		
		if(cell.getContents()!=null&&!cell.getContents().equals(""))
		{
			if(cell.getContents().equals("机构"))
		kjcgcjb.setFbrxz(0);
			else if(cell.getContents().equals("个人"))
				kjcgcjb.setFbrxz(1);
		}
		
		
		cell= sheet.getCell(1,23);
		kjcgcjb.setLxrxm(cell.getContents());
		
	
		cell= sheet.getCell(3,23);
		
		if(!cell.getContents().equals(""))
		kjcgcjb.setGddh(String.valueOf(cell.getContents()));
		
		cell= sheet.getCell(1,24);
		kjcgcjb.setSzdq(cell.getContents());
		
		cell= sheet.getCell(1,25);
		if(!cell.getContents().equals(""))
		kjcgcjb.setSj(String.valueOf(cell.getContents()));
		System.out.println(cell.getContents());
		
		cell= sheet.getCell(3,25);
		kjcgcjb.setDzyx(cell.getContents());
		
		cell= sheet.getCell(1,26);
		kjcgcjb.setLxdz(cell.getContents());
		
		kjcgcjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjcgcjb.setUsername(username);
		kjcgcjb.setGxsj(new Date().toString());
		kjcgcjb.setSubmit(0);
		
		kjcgcjbDao.save(kjcgcjb);
			

		book.close();
		// } catch (Exception e) {
		// System.out.println(e);
		// }
		
		
	}
	
	public void showexportObject(String str) throws Exception {

		File file =new File("D:\\湖北省国防科技工业科技信息管理系统excel导出");    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("//不存在");  
		    file .mkdir();    
		} 
		String[] ss = str.split(" ");  

		String hqlWhere = "";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.qjsl", "desc");
//		List<Kjsjjljgxxb> list = kjsjjljgxxbDao
//				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
	//	List<KjsjjljgxxbForm> formlist = this.KjsjjljgxxbPOListToVOList(list);

		List<KjcgcjbForm> formlist =listtemp;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\湖北省国防科技工业科技信息管理系统excel导出\\登记鉴定成果    admin  " + time + ".xls";

		// 打开文件
		WritableWorkbook book = Workbook.createWorkbook(new File(path));
		// 生成名为“第一页”的工作表，参数0表示这是第一页
		WritableSheet sheet = book.createSheet(" 第一页 ", 0);
		// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
		// 以及单元格内容为test

		  WritableCellFormat cellFormat=new WritableCellFormat();
			cellFormat.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
			cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
			
		
			int lie=0;
			
		for(int i=0;i<ss.length;i++)
		{
			sheet.setColumnView( i , 20 );
			switch(ss[i]){
			case "1":
				Label lab1 = new Label(lie, 0, "成果名称",cellFormat);
			    sheet.addCell(lab1);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getCgmc(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "2":
				Label lab5 = new Label(lie, 0, "成果完成单位",cellFormat);
			    sheet.addCell(lab5);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getWcdw(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "3":
				Label lab6 = new Label(lie, 0, "主要完成人",cellFormat);
			    sheet.addCell(lab6);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getZywcr(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "4":
				Label lab7 = new Label(lie, 0, "完成时间",cellFormat);
			    sheet.addCell(lab7);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getWcsj(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			    
				case "5":
					Label lab8 = new Label(lie, 0, "登记鉴定号",cellFormat);
				    sheet.addCell(lab8);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getDjjdh(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "6":
					Label lab9 = new Label(lie, 0,"成果体现形式",cellFormat);
				    sheet.addCell(lab9);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getTxxs(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "7":
					Label lab10 = new Label(lie, 0, "成果简介",cellFormat);
				    sheet.addCell(lab10);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getCgjj(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "8":
					Label lab11 = new Label(lie, 0, "应用行业",cellFormat);
				    sheet.addCell(lab11);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getYyhy(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "9":
					Label lab12 = new Label(lie, 0, "技术领域",cellFormat);
				    sheet.addCell(lab12);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getJsly(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "10":
					Label lab13 = new Label(lie, 0, "成果阶段",cellFormat);
				    sheet.addCell(lab13);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getCgjd(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "11":
					Label lab14 = new Label(lie, 0, "交易方式",cellFormat);
				    sheet.addCell(lab14);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getJyfs(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				    
					case "12":
						Label lab15 = new Label(lie, 0, "是否委托中介",cellFormat);
					    sheet.addCell(lab15);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getSfzj(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "13":
						Label lab16 = new Label(lie, 0,"供方定价",cellFormat);
					    sheet.addCell(lab16);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getGfdj(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "14":
						Label lab17 = new Label(lie, 0, "其他转化要求",cellFormat);
					    sheet.addCell(lab17);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getZhyq(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "15":
						Label lab18 = new Label(lie, 0, "以下信息是否公开",cellFormat);
					    sheet.addCell(lab18);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getSfgk(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "16":
						Label lab181 = new Label(lie, 0, "发布人性质",cellFormat);
					    sheet.addCell(lab181);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getFbrxz(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "17":
						Label lab19 = new Label(lie, 0, "联系人姓名",cellFormat);
					    sheet.addCell(lab19);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getLxrxm(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "18":
						Label lab20 = new Label(lie, 0, "固定电话",cellFormat);
					    sheet.addCell(lab20);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getGddh(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "19":
						Label lab21 = new Label(lie, 0, "所在地区",cellFormat);
					    sheet.addCell(lab21);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getSzdq(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					    
						case "20":
							Label lab22 = new Label(lie, 0, "手机",cellFormat);
						    sheet.addCell(lab22);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getSj(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						case "21":
							Label lab23 = new Label(lie, 0,"电子邮箱",cellFormat);
						    sheet.addCell(lab23);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getDzyx(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						case "22":
							Label lab24 = new Label(lie, 0, "联系地址",cellFormat);
						    sheet.addCell(lab24);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getLxdz(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						
			
			}
		}
		

		// 写入数据并关闭文件
		book.write();
		book.close();

	}

	
	

}
