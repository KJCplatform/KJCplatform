package platform.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import platform.dao.KjzlcjbDao;
import platform.domain.Kjzlcjb;
import platform.domain.Kjzlcjb;
import platform.form.KjsjjljgxxbForm;
import platform.form.KjzlcjbForm;
import platform.form.KjzlcjbForm;
import platform.service.KjzlcjbService;
import platform.util.StringHelper;

@Service(KjzlcjbService.SERVICE_NAME)
public class KjzlcjbServiceImpl implements KjzlcjbService{
	
	@Resource(name=KjzlcjbDao.SERVICE_NAME)
	private KjzlcjbDao kjzlcjbDao;
	private List<KjzlcjbForm>  listtemp=new ArrayList<KjzlcjbForm> ();
	
	public List<KjzlcjbForm> findKjzlcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zlqr", "desc");
		List<Kjzlcjb> list=kjzlcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjzlcjbForm> formlist=this.KjzlcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjzlcjbForm> findKjzlcjbListWithPage(int pagesize,int pageno,KjzlcjbForm kjzlcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjzlcjbForm!=null&&StringUtils.isNotBlank(kjzlcjbForm.getCgmc())){
			hqlWhere += " and o.cgmc like ?";
			paramsList.add("%"+kjzlcjbForm.getCgmc()+"%");
		}
		if(kjzlcjbForm!=null&&StringUtils.isNotBlank(kjzlcjbForm.getZllx())){
			hqlWhere += " and o.zllx like ?";
			paramsList.add("%"+kjzlcjbForm.getZllx()+"%");
		}
		orderby.put(" o.zlqr", "desc");
		params = paramsList.toArray();//
		List<Kjzlcjb> list=kjzlcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjzlcjbForm> formlist=this.KjzlcjbPOListToVOList(list);//
		
		if(pageno==1){
			
			listtemp = 
					KjzlcjbPOListToVOList(kjzlcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
			}
			
		return formlist;
		
	}
	
	public void updateKjzlcjb(KjzlcjbForm kjzlcjbForm){
	Kjzlcjb kjzlcjb=new Kjzlcjb();
		
		kjzlcjb.setId(Integer.valueOf(kjzlcjbForm.getId()));
		

		kjzlcjb.setCgmc(kjzlcjbForm.getCgmc());
		kjzlcjb.setZllx(kjzlcjbForm.getZllx());
		kjzlcjb.setZlqr(kjzlcjbForm.getZlqr());
		kjzlcjb.setZywcr(kjzlcjbForm.getZywcr());
		kjzlcjb.setZlh(kjzlcjbForm.getZlh());
		kjzlcjb.setGkh(kjzlcjbForm.getGkh());
		kjzlcjb.setGkr(StringHelper.stringConvertDate(kjzlcjbForm.getGkr()));
		kjzlcjb.setZflh(kjzlcjbForm.getZflh());
		kjzlcjb.setFlzt(kjzlcjbForm.getFlzt());
		kjzlcjb.setCgjj(kjzlcjbForm.getCgjj());
		kjzlcjb.setYyhy(kjzlcjbForm.getYyhy());
		kjzlcjb.setJsly(kjzlcjbForm.getJsly());
		kjzlcjb.setCgjd(kjzlcjbForm.getCgjd());
		kjzlcjb.setJyfs(kjzlcjbForm.getJyfs());
		
		//数据校验
		if(kjzlcjbForm.getSfzj()!=null){
		if(kjzlcjbForm.getSfzj().equals("是"))
			kjzlcjb.setSfzj(1);
		else if(kjzlcjbForm.getSfzj().equals("否"))
			kjzlcjb.setSfzj(0);
		}
		
		kjzlcjb.setGfdj(kjzlcjbForm.getGfdj());
		kjzlcjb.setZhyq(kjzlcjbForm.getZhyq());
		
		//数据校验
		if(kjzlcjbForm.getSfgk()!=null)
		{
			if(kjzlcjbForm.getSfgk().equals("是"))
				kjzlcjb.setSfgk(1);
			else if(kjzlcjbForm.getSfgk().equals("否"))
				kjzlcjb.setSfgk(0);
		}
		
		
		kjzlcjb.setLxrxm(kjzlcjbForm.getLxrxm());
		
		//数据校验
		if(kjzlcjbForm.getGddh()!=null
				&&!kjzlcjbForm.getGddh().equals(""))
		kjzlcjb.setGddh(Long.valueOf(kjzlcjbForm.getGddh()));
		
		kjzlcjb.setSzdq(kjzlcjbForm.getSzdq());
		
		//数据校验
		if(!kjzlcjbForm.getSj().equals(""))
		kjzlcjb.setSj(Long.valueOf(kjzlcjbForm.getSj()));
		kjzlcjb.setDzyx(kjzlcjbForm.getDzyx());
		kjzlcjb.setLxdz(kjzlcjbForm.getLxdz());
		
		
		kjzlcjbDao.update(kjzlcjb);
		
	}
	public void deleteObject(String id){
		kjzlcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjzlcjbForm kjzlcjbForm){
		Kjzlcjb kjzlcjb=new Kjzlcjb();

		kjzlcjb.setCgmc(kjzlcjbForm.getCgmc());
		kjzlcjb.setZllx(kjzlcjbForm.getZllx());
		kjzlcjb.setZlqr(kjzlcjbForm.getZlqr());
		kjzlcjb.setZywcr(kjzlcjbForm.getZywcr());
		kjzlcjb.setZlh(kjzlcjbForm.getZlh());
		kjzlcjb.setGkh(kjzlcjbForm.getGkh());
		kjzlcjb.setGkr(StringHelper.stringConvertDate(kjzlcjbForm.getGkr()));
		kjzlcjb.setZflh(kjzlcjbForm.getZflh());
		kjzlcjb.setFlzt(kjzlcjbForm.getFlzt());
		kjzlcjb.setCgjj(kjzlcjbForm.getCgjj());
		kjzlcjb.setYyhy(kjzlcjbForm.getYyhy());
		kjzlcjb.setJsly(kjzlcjbForm.getJsly());
		kjzlcjb.setCgjd(kjzlcjbForm.getCgjd());
		kjzlcjb.setJyfs(kjzlcjbForm.getJyfs());
		
		//数据校验
		if(kjzlcjbForm.getSfzj()!=null){
		if(kjzlcjbForm.getSfzj().equals("是"))
			kjzlcjb.setSfzj(1);
		else if(kjzlcjbForm.getSfzj().equals("否"))
			kjzlcjb.setSfzj(0);
		}
		
		kjzlcjb.setGfdj(kjzlcjbForm.getGfdj());
		kjzlcjb.setZhyq(kjzlcjbForm.getZhyq());
		
		//数据校验
		if(kjzlcjbForm.getSfgk()!=null)
		{
			if(kjzlcjbForm.getSfgk().equals("是"))
				kjzlcjb.setSfgk(1);
			else if(kjzlcjbForm.getSfgk().equals("否"))
				kjzlcjb.setSfgk(0);
		}
		
		kjzlcjb.setLxrxm(kjzlcjbForm.getLxrxm());
		
		//数据校验
		if(!kjzlcjbForm.getGddh().equals(""))
		kjzlcjb.setGddh(Long.valueOf(kjzlcjbForm.getGddh()));
		kjzlcjb.setSzdq(kjzlcjbForm.getSzdq());
		
		//数据校验
		if(!kjzlcjbForm.getSj().equals(""))
		kjzlcjb.setSj(Long.valueOf(kjzlcjbForm.getSj()));
		kjzlcjb.setDzyx(kjzlcjbForm.getDzyx());
		kjzlcjb.setLxdz(kjzlcjbForm.getLxdz());
		
		
		
//		kjzlcjb.setJlnf("test1");
//		kjzlcjb.setUser("test2");
//		kjzlcjb.setGxsj("test3");
//		kjzlcjb.setSubmit("0");
		
		kjzlcjbDao.save(kjzlcjb);
	}
	private List<KjzlcjbForm> KjzlcjbPOListToVOList(List<Kjzlcjb> list) {
		// TODO Auto-generated method stub
		List<KjzlcjbForm> formlist=new ArrayList<KjzlcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjzlcjb kjzlcjb=list.get(i);
			KjzlcjbForm kjzlcjbForm=new KjzlcjbForm();
			
			kjzlcjbForm.setId(String.valueOf(kjzlcjb.getId()));
			kjzlcjbForm.setCgmc(kjzlcjb.getCgmc());
			kjzlcjbForm.setZllx(kjzlcjb.getZllx());
			kjzlcjbForm.setZlqr(kjzlcjb.getZlqr());
			kjzlcjbForm.setZywcr(kjzlcjb.getZywcr());
			kjzlcjbForm.setZlh(kjzlcjb.getZlh());
			kjzlcjbForm.setGkh(kjzlcjb.getGkh());
			
			if(kjzlcjb.getGkr()!=null)
			kjzlcjbForm.setGkr(String.valueOf(kjzlcjb.getGkr()));
			kjzlcjbForm.setZflh(kjzlcjb.getZflh());
			kjzlcjbForm.setFlzt(kjzlcjb.getFlzt());
			kjzlcjbForm.setCgjj(kjzlcjb.getCgjj());
			kjzlcjbForm.setYyhy(kjzlcjb.getYyhy());
			kjzlcjbForm.setJsly(kjzlcjb.getJsly());
			kjzlcjbForm.setCgjd(kjzlcjb.getCgjd());
			kjzlcjbForm.setJyfs(kjzlcjb.getJyfs());

			if(kjzlcjb.getSfzj()==1)
			kjzlcjbForm.setSfzj("是");
			else if(kjzlcjb.getSfzj()==0)
			kjzlcjbForm.setSfzj("否");
			
			
			kjzlcjbForm.setGfdj(kjzlcjb.getGfdj());
			kjzlcjbForm.setZhyq(kjzlcjb.getZhyq());
			
			
			if(kjzlcjb.getSfgk()==1)
				kjzlcjbForm.setSfgk("是");
				else if(kjzlcjb.getSfgk()==0)
				kjzlcjbForm.setSfgk("否");
			
			kjzlcjbForm.setLxrxm(kjzlcjb.getLxrxm());
			
			if(kjzlcjb.getGddh()!=null)
			kjzlcjbForm.setGddh(String.valueOf(kjzlcjb.getGddh()));
			kjzlcjbForm.setSzdq(kjzlcjb.getSzdq());
			
			if(kjzlcjb.getSj()!=null)
			kjzlcjbForm.setSj(String.valueOf(kjzlcjb.getSj()));
			kjzlcjbForm.setDzyx(kjzlcjb.getDzyx());
			kjzlcjbForm.setLxdz(kjzlcjb.getLxdz());
			
			
			
			
			formlist.add(kjzlcjbForm);
		}
		return formlist;
	}
	
	
	@Override
	public void showimportObject(String showimport)  throws Exception {
		
		String b = showimport.replace("\\", "\\\\");
		String c = b.replace("C:\\\\fakepath", "D:");

		Workbook book = Workbook.getWorkbook(new File(c));
		// Workbook book = Workbook.getWorkbook( new File(b));
		// 获得第一个工作表对象
		Sheet sheet = book.getSheet(0);
		// 得到第一列第一行的单元格

		int columnum = sheet.getColumns();// 得到列数
		int rownum = sheet.getRows();// 得到行数


		Kjzlcjb kjzlcjb=new Kjzlcjb();
		
		Cell cell= sheet.getCell(1,1);
		kjzlcjb.setCgmc(cell.getContents());
		
		cell= sheet.getCell(1,3);
		kjzlcjb.setZllx(cell.getContents());
		
		cell= sheet.getCell(1,4);
		kjzlcjb.setZlqr(cell.getContents());
		
		cell= sheet.getCell(1,5);
		kjzlcjb.setZywcr(cell.getContents());
		
		cell= sheet.getCell(1,6);
		kjzlcjb.setZlh(cell.getContents());
		
		cell= sheet.getCell(1,7);
		kjzlcjb.setGkh(cell.getContents());
		
		cell= sheet.getCell(1,8);
		if(!cell.getContents().equals(""))
		kjzlcjb.setGkr(StringHelper.stringConvertDate(cell.getContents()));
		
		cell= sheet.getCell(1,9);
		kjzlcjb.setZflh(cell.getContents());
		
		cell= sheet.getCell(1,10);
		kjzlcjb.setFlzt(cell.getContents());
		
		cell= sheet.getCell(1,11);
		kjzlcjb.setCgjj(cell.getContents());
		
		cell= sheet.getCell(1,12);
		kjzlcjb.setYyhy(cell.getContents());
		
		cell= sheet.getCell(1,13);
		kjzlcjb.setJsly(cell.getContents());
		
		cell= sheet.getCell(1,15);
		kjzlcjb.setCgjd(cell.getContents());
		
		cell= sheet.getCell(1,17);
		kjzlcjb.setJyfs(cell.getContents());
		
		
		cell= sheet.getCell(1,19);
		if(!cell.getContents().equals("")){
		if(cell.equals("是"))
			kjzlcjb.setSfzj(1);
		else if(cell.equals("否"))
			kjzlcjb.setSfzj(0);
		}
		
		cell= sheet.getCell(1,22);
		kjzlcjb.setGfdj(cell.getContents());
		
		cell= sheet.getCell(1,23);
		kjzlcjb.setZhyq(cell.getContents());
		
		cell= sheet.getCell(1,24);
		if(!cell.getContents().equals(""))
		{
			if(cell.equals("是"))
				kjzlcjb.setSfgk(1);
			else if(cell.equals("否"))
				kjzlcjb.setSfgk(0);
		}
		
		cell= sheet.getCell(1,25);
		kjzlcjb.setLxrxm(cell.getContents());
		
	
		cell= sheet.getCell(3,25);
		
		if(!cell.getContents().equals(""))
		kjzlcjb.setGddh(Long.valueOf(cell.getContents()));
		
		cell= sheet.getCell(1,26);
		kjzlcjb.setSzdq(cell.getContents());
		
		cell= sheet.getCell(1,27);
		if(!cell.getContents().equals(""))
		kjzlcjb.setSj(Long.valueOf(cell.getContents()));
		System.out.println(cell.getContents());
		
		cell= sheet.getCell(3,27);
		kjzlcjb.setDzyx(cell.getContents());
		
		cell= sheet.getCell(1,28);
		kjzlcjb.setLxdz(cell.getContents());
		
		kjzlcjbDao.save(kjzlcjb);
			

		book.close();
		// } catch (Exception e) {
		// System.out.println(e);
		// }
		
		
	}
	
	public void showexportObject(String str) throws Exception {

		 
		String[] ss = str.split(" ");  

		String hqlWhere = "";
		Object[] params = null;
//		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
//		orderby.put(" o.qjsl", "desc");
//		List<Kjsjjljgxxb> list = kjsjjljgxxbDao
//				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
	//	List<KjsjjljgxxbForm> formlist = this.KjsjjljgxxbPOListToVOList(list);

		List<KjzlcjbForm> formlist =listtemp;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\国防专利    admin  " + time + ".xls";

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
				Label lab2 = new Label(lie, 0,"专利类型",cellFormat);
			    sheet.addCell(lab2);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getZllx(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "3":
				Label lab3 = new Label(lie, 0, "专利权人",cellFormat);
			    sheet.addCell(lab3);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getZlqr(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "4":
				Label lab4 = new Label(lie, 0, "主要完成人",cellFormat);
			    sheet.addCell(lab4);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getZywcr(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "5":
				Label lab5 = new Label(lie, 0, "专利号",cellFormat);
			    sheet.addCell(lab5);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getZlh(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "6":
				Label lab6 = new Label(lie, 0, "主分类号",cellFormat);
			    sheet.addCell(lab6);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getZflh(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "7":
				Label lab7 = new Label(lie, 0, "公开号",cellFormat);
			    sheet.addCell(lab7);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getGkh(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			    
				case "8":
					Label lab8 = new Label(lie, 0, "公开日",cellFormat);
				    sheet.addCell(lab8);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getGkr(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "9":
					Label lab9 = new Label(lie, 0,"法律状态",cellFormat);
				    sheet.addCell(lab9);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getFlzt(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "10":
					Label lab10 = new Label(lie, 0, "成果简介",cellFormat);
				    sheet.addCell(lab10);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getCgjj(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "11":
					Label lab11 = new Label(lie, 0, "应用行业",cellFormat);
				    sheet.addCell(lab11);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getYyhy(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "12":
					Label lab12 = new Label(lie, 0, "技术领域",cellFormat);
				    sheet.addCell(lab12);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getJsly(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "13":
					Label lab13 = new Label(lie, 0, "成果阶段",cellFormat);
				    sheet.addCell(lab13);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getCgjd(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "14":
					Label lab14 = new Label(lie, 0, "交易方式",cellFormat);
				    sheet.addCell(lab14);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getJyfs(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				    
					case "15":
						Label lab15 = new Label(lie, 0, "是否委托中介",cellFormat);
					    sheet.addCell(lab15);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getSfzj(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "16":
						Label lab16 = new Label(lie, 0,"供方定价",cellFormat);
					    sheet.addCell(lab16);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getGfdj(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "17":
						Label lab17 = new Label(lie, 0, "其他转化要求",cellFormat);
					    sheet.addCell(lab17);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getZhyq(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "18":
						Label lab18 = new Label(lie, 0, "是否公开",cellFormat);
					    sheet.addCell(lab18);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getSfgk(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "19":
						Label lab19 = new Label(lie, 0, "联系人姓名",cellFormat);
					    sheet.addCell(lab19);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getLxrxm(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "20":
						Label lab20 = new Label(lie, 0, "固定电话",cellFormat);
					    sheet.addCell(lab20);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getGddh(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "21":
						Label lab21 = new Label(lie, 0, "所在地区",cellFormat);
					    sheet.addCell(lab21);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getSzdq(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					    
						case "22":
							Label lab22 = new Label(lie, 0, "手机",cellFormat);
						    sheet.addCell(lab22);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getSj(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						case "23":
							Label lab23 = new Label(lie, 0,"电子邮箱",cellFormat);
						    sheet.addCell(lab23);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getDzyx(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						case "24":
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
