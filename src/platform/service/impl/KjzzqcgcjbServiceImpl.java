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

import platform.dao.KjzzqcgcjbDao;
import platform.domain.Kjzzqcgcjb;
import platform.domain.Kjzzqcgcjb;
import platform.form.KjzzqcgcjbForm;
import platform.form.KjzzqcgcjbForm;
import platform.service.KjzzqcgcjbService;
import platform.util.StringHelper;

@Service(KjzzqcgcjbService.SERVICE_NAME)
public class KjzzqcgcjbServiceImpl implements KjzzqcgcjbService{
	
	@Resource(name=KjzzqcgcjbDao.SERVICE_NAME)
	private KjzzqcgcjbDao kjzzqcgcjbDao;
	private List<KjzzqcgcjbForm>  listtemp=new ArrayList<KjzzqcgcjbForm> ();
	
	public List<KjzzqcgcjbForm> findKjzzqcgcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zywcr", "desc");
		List<Kjzzqcgcjb> list=kjzzqcgcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjzzqcgcjbForm> formlist=this.KjzzqcgcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjzzqcgcjbForm> findKjzzqcgcjbListWithPage(int pagesize,int pageno,KjzzqcgcjbForm kjzzqcgcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjzzqcgcjbForm!=null&&StringUtils.isNotBlank(kjzzqcgcjbForm.getCgmc())){
			hqlWhere += " and o.cgmc like ?";
			paramsList.add("%"+kjzzqcgcjbForm.getCgmc()+"%");
		}
		if(kjzzqcgcjbForm!=null&&StringUtils.isNotBlank(kjzzqcgcjbForm.getWcdw())){
			hqlWhere += " and o.wcdw like ?";
			paramsList.add("%"+kjzzqcgcjbForm.getWcdw()+"%");
		}
		orderby.put(" o.zywcr", "desc");
		params = paramsList.toArray();
		List<Kjzzqcgcjb> list=kjzzqcgcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjzzqcgcjbForm> formlist=this.KjzzqcgcjbPOListToVOList(list);
		
if(pageno==1){
			
			listtemp = 
					KjzzqcgcjbPOListToVOList(kjzzqcgcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
			}
			
		
		return formlist;
		
	}
	
	public void updateKjzzqcgcjb(KjzzqcgcjbForm kjzzqcgcjbForm){
		Kjzzqcgcjb kjzzqcgcjb=new Kjzzqcgcjb();
		
		kjzzqcgcjb.setId(Integer.valueOf(kjzzqcgcjbForm.getId()));
		
		kjzzqcgcjb.setCgmc(kjzzqcgcjbForm.getCgmc());
		kjzzqcgcjb.setWcdw(kjzzqcgcjbForm.getWcdw());
		kjzzqcgcjb.setZywcr(kjzzqcgcjbForm.getZywcr());
		kjzzqcgcjb.setWcsj(StringHelper.stringConvertDate2(kjzzqcgcjbForm.getWcsj()));
		kjzzqcgcjb.setRzbh(kjzzqcgcjbForm.getRzbh());
		kjzzqcgcjb.setCgjj(kjzzqcgcjbForm.getCgjj());
		kjzzqcgcjb.setYyhy(kjzzqcgcjbForm.getYyhy());
		kjzzqcgcjb.setJsly(kjzzqcgcjbForm.getJsly());
		kjzzqcgcjb.setCgjd(kjzzqcgcjbForm.getCgjd());
		kjzzqcgcjb.setJyfs(kjzzqcgcjbForm.getJyfs());
		
		//数据校验
		if(kjzzqcgcjbForm.getSfzj()!=null){
		if(kjzzqcgcjbForm.getSfzj().equals("是"))
			kjzzqcgcjb.setSfzj(1);
		else if(kjzzqcgcjbForm.getSfzj().equals("否"))
			kjzzqcgcjb.setSfzj(0);
		}
		kjzzqcgcjb.setGfdj(kjzzqcgcjbForm.getGfdj());
		kjzzqcgcjb.setZhyq(kjzzqcgcjbForm.getZhyq());
		
		
		//数据校验
		if(kjzzqcgcjbForm.getSfgk()!=null)
		{
			if(kjzzqcgcjbForm.getSfgk().equals("是"))
				kjzzqcgcjb.setSfgk(1);
			else if(kjzzqcgcjbForm.getSfgk().equals("否"))
				kjzzqcgcjb.setSfgk(0);
		}
		
		
		if(kjzzqcgcjbForm.getFbrxz()!=null&&!kjzzqcgcjbForm.getFbrxz().equals(""))
		kjzzqcgcjb.setFbrxz(Integer.valueOf(kjzzqcgcjbForm.getFbrxz()));
		kjzzqcgcjb.setLxrxm(kjzzqcgcjbForm.getLxrxm());
		kjzzqcgcjb.setGddh(kjzzqcgcjbForm.getGddh());
		kjzzqcgcjb.setSzdq(kjzzqcgcjbForm.getSzdq());
		kjzzqcgcjb.setSj(kjzzqcgcjbForm.getSj());
		kjzzqcgcjb.setDzyx(kjzzqcgcjbForm.getDzyx());
		kjzzqcgcjb.setLxdz(kjzzqcgcjbForm.getLxdz());
		
		
		kjzzqcgcjbDao.update(kjzzqcgcjb);
		
	}
	public void deleteObject(String id){
		kjzzqcgcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjzzqcgcjbForm kjzzqcgcjbForm){
		Kjzzqcgcjb kjzzqcgcjb=new Kjzzqcgcjb();
		kjzzqcgcjb.setCgmc(kjzzqcgcjbForm.getCgmc());
		kjzzqcgcjb.setWcdw(kjzzqcgcjbForm.getWcdw());
		kjzzqcgcjb.setZywcr(kjzzqcgcjbForm.getZywcr());
		kjzzqcgcjb.setWcsj(StringHelper.stringConvertDate2(kjzzqcgcjbForm.getWcsj()));
		kjzzqcgcjb.setRzbh(kjzzqcgcjbForm.getRzbh());
		kjzzqcgcjb.setCgjj(kjzzqcgcjbForm.getCgjj());
		kjzzqcgcjb.setYyhy(kjzzqcgcjbForm.getYyhy());
		kjzzqcgcjb.setJsly(kjzzqcgcjbForm.getJsly());
		kjzzqcgcjb.setCgjd(kjzzqcgcjbForm.getCgjd());
		kjzzqcgcjb.setJyfs(kjzzqcgcjbForm.getJyfs());
		
		//数据校验
		if(kjzzqcgcjbForm.getSfzj()!=null){
		if(kjzzqcgcjbForm.getSfzj().equals("是"))
			kjzzqcgcjb.setSfzj(1);
		else if(kjzzqcgcjbForm.getSfzj().equals("否"))
			kjzzqcgcjb.setSfzj(0);
		}
		kjzzqcgcjb.setGfdj(kjzzqcgcjbForm.getGfdj());
		kjzzqcgcjb.setZhyq(kjzzqcgcjbForm.getZhyq());
		
		
		//数据校验
		if(kjzzqcgcjbForm.getSfgk()!=null)
		{
			if(kjzzqcgcjbForm.getSfgk().equals("是"))
				kjzzqcgcjb.setSfgk(1);
			else if(kjzzqcgcjbForm.getSfgk().equals("否"))
				kjzzqcgcjb.setSfgk(0);
		}
		if(kjzzqcgcjbForm.getFbrxz()!=null&&!kjzzqcgcjbForm.getFbrxz().equals(""))
		kjzzqcgcjb.setFbrxz(Integer.valueOf(kjzzqcgcjbForm.getFbrxz()));
		kjzzqcgcjb.setLxrxm(kjzzqcgcjbForm.getLxrxm());
		kjzzqcgcjb.setGddh(kjzzqcgcjbForm.getGddh());
		kjzzqcgcjb.setSzdq(kjzzqcgcjbForm.getSzdq());
		kjzzqcgcjb.setSj(kjzzqcgcjbForm.getSj());
		kjzzqcgcjb.setDzyx(kjzzqcgcjbForm.getDzyx());
		kjzzqcgcjb.setLxdz(kjzzqcgcjbForm.getLxdz());
		
		kjzzqcgcjbDao.save(kjzzqcgcjb);
	}
	private List<KjzzqcgcjbForm> KjzzqcgcjbPOListToVOList(List<Kjzzqcgcjb> list) {
		// TODO Auto-generated method stub
		List<KjzzqcgcjbForm> formlist=new ArrayList<KjzzqcgcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjzzqcgcjb kjzzqcgcjb=list.get(i);
			KjzzqcgcjbForm kjzzqcgcjbForm=new KjzzqcgcjbForm();
			
			kjzzqcgcjbForm.setId(String.valueOf(kjzzqcgcjb.getId()));
			kjzzqcgcjbForm.setCgmc(kjzzqcgcjb.getCgmc());
			kjzzqcgcjbForm.setWcdw(kjzzqcgcjb.getWcdw());
			kjzzqcgcjbForm.setZywcr(kjzzqcgcjb.getZywcr());
			
			if(kjzzqcgcjb.getWcsj()!=null)
			kjzzqcgcjbForm.setWcsj(String.valueOf(kjzzqcgcjb.getWcsj()));
			kjzzqcgcjbForm.setRzbh(kjzzqcgcjb.getRzbh());
			kjzzqcgcjbForm.setCgjj(kjzzqcgcjb.getCgjj());
			kjzzqcgcjbForm.setYyhy(kjzzqcgcjb.getYyhy());
			kjzzqcgcjbForm.setJsly(kjzzqcgcjb.getJsly());
			kjzzqcgcjbForm.setCgjd(kjzzqcgcjb.getCgjd());
			kjzzqcgcjbForm.setJyfs(kjzzqcgcjb.getJyfs());

			//数据校验
			if(kjzzqcgcjbForm.getSfzj()!=null){
			if(kjzzqcgcjbForm.getSfzj().equals("是"))
				kjzzqcgcjb.setSfzj(1);
			else if(kjzzqcgcjbForm.getSfzj().equals("否"))
				kjzzqcgcjb.setSfzj(0);
			}
			
			kjzzqcgcjbForm.setGfdj(kjzzqcgcjb.getGfdj());
			kjzzqcgcjbForm.setZhyq(kjzzqcgcjb.getZhyq());

			//数据校验
			if(kjzzqcgcjbForm.getSfgk()!=null)
			{
				if(kjzzqcgcjbForm.getSfgk().equals("是"))
					kjzzqcgcjb.setSfgk(1);
				else if(kjzzqcgcjbForm.getSfgk().equals("否"))
					kjzzqcgcjb.setSfgk(0);
			}
			kjzzqcgcjbForm.setFbrxz(String.valueOf(kjzzqcgcjb.getFbrxz()));
			kjzzqcgcjbForm.setLxrxm(kjzzqcgcjb.getLxrxm());
			kjzzqcgcjbForm.setGddh(kjzzqcgcjb.getGddh());
			kjzzqcgcjbForm.setSzdq(kjzzqcgcjb.getSzdq());
			kjzzqcgcjbForm.setSj(kjzzqcgcjb.getSj());
			kjzzqcgcjbForm.setDzyx(kjzzqcgcjb.getDzyx());
			kjzzqcgcjbForm.setLxdz(kjzzqcgcjb.getLxdz());
			
			
			formlist.add(kjzzqcgcjbForm);
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


		Kjzzqcgcjb kjzzqcgcjb=new Kjzzqcgcjb();
		
		Cell cell= sheet.getCell(1,1);
		kjzzqcgcjb.setCgmc(cell.getContents());
		
		cell= sheet.getCell(1,2);
		kjzzqcgcjb.setWcdw(cell.getContents());
		
		cell= sheet.getCell(1,3);
		kjzzqcgcjb.setZywcr(cell.getContents());
		
		cell= sheet.getCell(1,4);
		kjzzqcgcjb.setWcsj(StringHelper.stringConvertDate2(cell.getContents()));
		
		cell= sheet.getCell(1,5);
		kjzzqcgcjb.setRzbh(cell.getContents());
		
		cell= sheet.getCell(1,6);
		kjzzqcgcjb.setCgjj(cell.getContents());
		
		cell= sheet.getCell(1,7);
		kjzzqcgcjb.setYyhy(cell.getContents());
		
		cell= sheet.getCell(1,8);
		kjzzqcgcjb.setJsly(cell.getContents());
		
		cell= sheet.getCell(1,10);
		kjzzqcgcjb.setCgjd(cell.getContents());
		
		cell= sheet.getCell(1,12);
		kjzzqcgcjb.setJyfs(cell.getContents());
		
		
		cell= sheet.getCell(1,14);
		if(!cell.getContents().equals("")){
		if(cell.equals("是"))
			kjzzqcgcjb.setSfzj(1);
		else if(cell.equals("否"))
			kjzzqcgcjb.setSfzj(0);
		}
		
		cell= sheet.getCell(1,17);
		kjzzqcgcjb.setGfdj(cell.getContents());
		
		cell= sheet.getCell(1,18);
		kjzzqcgcjb.setZhyq(cell.getContents());
		
		cell= sheet.getCell(1,19);
		if(!cell.getContents().equals(""))
		{
			if(cell.equals("是"))
				kjzzqcgcjb.setSfgk(1);
			else if(cell.equals("否"))
				kjzzqcgcjb.setSfgk(0);
		}
		
		////
		cell= sheet.getCell(1,20);
		
		if(cell.getContents()!=null&&!cell.getContents().equals(""))
		{
			if(cell.getContents().equals("机构"))
		kjzzqcgcjb.setFbrxz(0);
			else if(cell.getContents().equals("个人"))
				kjzzqcgcjb.setFbrxz(1);
		}
		
		
		cell= sheet.getCell(1,21);
		kjzzqcgcjb.setLxrxm(cell.getContents());
		
	
		cell= sheet.getCell(3,21);
		
		if(!cell.getContents().equals(""))
		kjzzqcgcjb.setGddh(String.valueOf(cell.getContents()));
		
		cell= sheet.getCell(1,22);
		kjzzqcgcjb.setSzdq(cell.getContents());
		
		cell= sheet.getCell(1,23);
		if(!cell.getContents().equals(""))
		kjzzqcgcjb.setSj(String.valueOf(cell.getContents()));
		System.out.println(cell.getContents());
		
		cell= sheet.getCell(3,23);
		kjzzqcgcjb.setDzyx(cell.getContents());
		
		cell= sheet.getCell(1,24);
		kjzzqcgcjb.setLxdz(cell.getContents());
		
		kjzzqcgcjbDao.save(kjzzqcgcjb);
			

		book.close();
		// } catch (Exception e) {
		// System.out.println(e);
		// }
		
		
	}
	
	public void showexportObject(String str) throws Exception {

		 
		String[] ss = str.split(" ");  

		String hqlWhere = "";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.qjsl", "desc");
//		List<Kjsjjljgxxb> list = kjsjjljgxxbDao
//				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
	//	List<KjsjjljgxxbForm> formlist = this.KjsjjljgxxbPOListToVOList(list);

		List<KjzzqcgcjbForm> formlist =listtemp;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\软件著作权    admin  " + time + ".xls";

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
					Label lab8 = new Label(lie, 0, "软著编号",cellFormat);
				    sheet.addCell(lab8);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getRzbh(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
	
				case "6":
					Label lab10 = new Label(lie, 0, "成果简介",cellFormat);
				    sheet.addCell(lab10);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getCgjj(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "7":
					Label lab11 = new Label(lie, 0, "应用行业",cellFormat);
				    sheet.addCell(lab11);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getYyhy(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "8":
					Label lab12 = new Label(lie, 0, "技术领域",cellFormat);
				    sheet.addCell(lab12);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getJsly(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "9":
					Label lab13 = new Label(lie, 0, "成果阶段",cellFormat);
				    sheet.addCell(lab13);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getCgjd(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "10":
					Label lab14 = new Label(lie, 0, "交易方式",cellFormat);
				    sheet.addCell(lab14);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getJyfs(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				    
					case "11":
						Label lab15 = new Label(lie, 0, "是否委托中介",cellFormat);
					    sheet.addCell(lab15);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getSfzj(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "12":
						Label lab16 = new Label(lie, 0,"供方定价",cellFormat);
					    sheet.addCell(lab16);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getGfdj(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "13":
						Label lab17 = new Label(lie, 0, "其他转化要求",cellFormat);
					    sheet.addCell(lab17);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getZhyq(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "14":
						Label lab18 = new Label(lie, 0, "以下信息是否公开",cellFormat);
					    sheet.addCell(lab18);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getSfgk(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "15":
						Label lab181 = new Label(lie, 0, "发布人性质",cellFormat);
					    sheet.addCell(lab181);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getFbrxz(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "16":
						Label lab19 = new Label(lie, 0, "联系人姓名",cellFormat);
					    sheet.addCell(lab19);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getLxrxm(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "17":
						Label lab20 = new Label(lie, 0, "固定电话",cellFormat);
					    sheet.addCell(lab20);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getGddh(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "18":
						Label lab21 = new Label(lie, 0, "所在地区",cellFormat);
					    sheet.addCell(lab21);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getSzdq(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					    
						case "19":
							Label lab22 = new Label(lie, 0, "手机",cellFormat);
						    sheet.addCell(lab22);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getSj(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						case "20":
							Label lab23 = new Label(lie, 0,"电子邮箱",cellFormat);
						    sheet.addCell(lab23);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getDzyx(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						case "21":
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
