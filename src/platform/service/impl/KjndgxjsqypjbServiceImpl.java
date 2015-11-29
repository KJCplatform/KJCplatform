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

import platform.dao.KjndgxjsqypjbDao;
import platform.domain.Kjndgxjsqypjb;
import platform.domain.Kjsjjljgxxb;
import platform.form.KjndgxjsqypjbForm;
import platform.form.KjzlcjbForm;
import platform.service.KjndgxjsqypjbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjndgxjsqypjbService.SERVICE_NAME)
public class KjndgxjsqypjbServiceImpl implements KjndgxjsqypjbService{
	
	@Resource(name=KjndgxjsqypjbDao.SERVICE_NAME)
	private KjndgxjsqypjbDao kjndgxjsqypjbDao;
	private List<KjndgxjsqypjbForm>  listtemp=new ArrayList<KjndgxjsqypjbForm> ();
	
	
	public List<KjndgxjsqypjbForm> findKjndgxjsqypjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zgzs", "desc");
		List<Kjndgxjsqypjb> list=kjndgxjsqypjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndgxjsqypjbForm> formlist=this.KjndgxjsqypjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjndgxjsqypjbForm> findKjndgxjsqypjbListWithPage(int pagesize,int pageno,KjndgxjsqypjbForm kjndgxjsqypjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjndgxjsqypjbForm!=null&&StringUtils.isNotBlank(kjndgxjsqypjbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+kjndgxjsqypjbForm.getYear()+"%");
		}
		if(kjndgxjsqypjbForm!=null&&StringUtils.isNotBlank(kjndgxjsqypjbForm.getQymc())){
			hqlWhere += " and o.qymc like ?";
			paramsList.add("%"+kjndgxjsqypjbForm.getQymc()+"%");
		}
		orderby.put(" o.zgzs", "desc");
		params = paramsList.toArray();
		List<Kjndgxjsqypjb> list=kjndgxjsqypjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjndgxjsqypjbForm> formlist=this.KjndgxjsqypjbPOListToVOList(list);
		
	if(pageno==1){
			
			listtemp = 
					KjndgxjsqypjbPOListToVOList(kjndgxjsqypjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
			}
			
	
		return formlist;
		
	}
	/*private int id;
	  private String year;
	  private String qymc;
	  private String cply;
	  private int Zgzs;
	  private int Dzysrs;
	  private int Yfrys;
	  private int Xmhds;
	  private int Cphds;
	  private String Jfze;
	  private String Yncpsr;
	  private String Jnyfze;
	  private String Dzrybl;
	  private String Yfrybl;
	  private String Jsnyfbl;
	  private String Jsnjnbl;
	  private String Jyngxsrbl;
	  private String Zhdf;
	  private String Zhnldf;
	  private String Czzbdf;
	  private String Zhpj;
	  private String Pdzjz;*/
	public void updateKjndgxjsqypjb(KjndgxjsqypjbForm kjndgxjsqypjbForm){
		Kjndgxjsqypjb kjndgxjsqypjb=new Kjndgxjsqypjb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjndgxjsqypjb.setId(Integer.valueOf(kjndgxjsqypjbForm.getId()));
		kjndgxjsqypjb.setYear(kjndgxjsqypjbForm.getYear());
		kjndgxjsqypjb.setQymc(kjndgxjsqypjbForm.getQymc());
		kjndgxjsqypjb.setCply(kjndgxjsqypjbForm.getCply());
		
		if(kjndgxjsqypjbForm.getZgzs()!=null&&!kjndgxjsqypjbForm.getZgzs().equals(""))
		kjndgxjsqypjb.setZgzs(Integer.valueOf(kjndgxjsqypjbForm.getZgzs()));
		
		if(kjndgxjsqypjbForm.getDzysrs()!=null&&!kjndgxjsqypjbForm.getDzysrs().equals(""))
		kjndgxjsqypjb.setDzysrs(Integer.valueOf(kjndgxjsqypjbForm.getDzysrs()));
		
		if(kjndgxjsqypjbForm.getYfrys()!=null&&!kjndgxjsqypjbForm.getYfrys().equals(""))
		kjndgxjsqypjb.setYfrys(Integer.valueOf(kjndgxjsqypjbForm.getYfrys()));
		
		if(kjndgxjsqypjbForm.getXmhds()!=null&&!kjndgxjsqypjbForm.getXmhds().equals(""))
		kjndgxjsqypjb.setXmhds(Integer.valueOf(kjndgxjsqypjbForm.getXmhds()));
		
		if(kjndgxjsqypjbForm.getCphds()!=null&&!kjndgxjsqypjbForm.getCphds().equals(""))
		kjndgxjsqypjb.setCphds(Integer.valueOf(kjndgxjsqypjbForm.getCphds()));
		
		kjndgxjsqypjb.setJfze(kjndgxjsqypjbForm.getJfze());
		kjndgxjsqypjb.setYncpsr(kjndgxjsqypjbForm.getYncpsr());
		kjndgxjsqypjb.setJnyfze(kjndgxjsqypjbForm.getJnyfze());
		kjndgxjsqypjb.setDzrybl(kjndgxjsqypjbForm.getDzrybl());
		kjndgxjsqypjb.setYfrybl(kjndgxjsqypjbForm.getYfrybl());
		kjndgxjsqypjb.setJsnyfbl(kjndgxjsqypjbForm.getJsnyfbl());
		kjndgxjsqypjb.setJsnjnbl(kjndgxjsqypjbForm.getJsnjnbl());
		kjndgxjsqypjb.setJyngxsrbl(kjndgxjsqypjbForm.getJyngxsrbl());
		kjndgxjsqypjb.setZhdf(kjndgxjsqypjbForm.getZhdf());
		kjndgxjsqypjb.setZhnldf(kjndgxjsqypjbForm.getZhnldf());
		kjndgxjsqypjb.setCzzbdf(kjndgxjsqypjbForm.getCzzbdf());
		kjndgxjsqypjb.setZscqdf(kjndgxjsqypjbForm.getZscqdf());
		kjndgxjsqypjb.setGlspdf(kjndgxjsqypjbForm.getGlspdf());
		kjndgxjsqypjb.setZhpj(kjndgxjsqypjbForm.getZhpj());
		kjndgxjsqypjb.setPdzjz(kjndgxjsqypjbForm.getPdzjz());
		
		
		kjndgxjsqypjbDao.update(kjndgxjsqypjb);
		
	}
	public void deleteObject(String id){
		kjndgxjsqypjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjndgxjsqypjbForm kjndgxjsqypjbForm){
		Kjndgxjsqypjb kjndgxjsqypjb=new Kjndgxjsqypjb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		
		kjndgxjsqypjb.setYear(kjndgxjsqypjbForm.getYear());
		kjndgxjsqypjb.setQymc(kjndgxjsqypjbForm.getQymc());
		kjndgxjsqypjb.setCply(kjndgxjsqypjbForm.getCply());
		if(kjndgxjsqypjbForm.getZgzs()!=null&&!kjndgxjsqypjbForm.getZgzs().equals(""))
		kjndgxjsqypjb.setZgzs(Integer.valueOf(kjndgxjsqypjbForm.getZgzs()));
		
		if(kjndgxjsqypjbForm.getDzysrs()!=null&&!kjndgxjsqypjbForm.getDzysrs().equals(""))
		kjndgxjsqypjb.setDzysrs(Integer.valueOf(kjndgxjsqypjbForm.getDzysrs()));
		
		if(kjndgxjsqypjbForm.getYfrys()!=null&&!kjndgxjsqypjbForm.getYfrys().equals(""))
		kjndgxjsqypjb.setYfrys(Integer.valueOf(kjndgxjsqypjbForm.getYfrys()));
		
		if(kjndgxjsqypjbForm.getXmhds()!=null&&!kjndgxjsqypjbForm.getXmhds().equals(""))
		kjndgxjsqypjb.setXmhds(Integer.valueOf(kjndgxjsqypjbForm.getXmhds()));
		
		if(kjndgxjsqypjbForm.getCphds()!=null&&!kjndgxjsqypjbForm.getCphds().equals(""))
		kjndgxjsqypjb.setCphds(Integer.valueOf(kjndgxjsqypjbForm.getCphds()));
		
		kjndgxjsqypjb.setJfze(kjndgxjsqypjbForm.getJfze());
		kjndgxjsqypjb.setYncpsr(kjndgxjsqypjbForm.getYncpsr());
		kjndgxjsqypjb.setJnyfze(kjndgxjsqypjbForm.getJnyfze());
		kjndgxjsqypjb.setDzrybl(kjndgxjsqypjbForm.getDzrybl());
		kjndgxjsqypjb.setYfrybl(kjndgxjsqypjbForm.getYfrybl());
		kjndgxjsqypjb.setJsnyfbl(kjndgxjsqypjbForm.getJsnyfbl());
		kjndgxjsqypjb.setJsnjnbl(kjndgxjsqypjbForm.getJsnjnbl());
		kjndgxjsqypjb.setJyngxsrbl(kjndgxjsqypjbForm.getJyngxsrbl());
		kjndgxjsqypjb.setZhdf(kjndgxjsqypjbForm.getZhdf());
		kjndgxjsqypjb.setZscqdf(kjndgxjsqypjbForm.getZscqdf());
		kjndgxjsqypjb.setGlspdf(kjndgxjsqypjbForm.getGlspdf());
		
		kjndgxjsqypjb.setZhnldf(kjndgxjsqypjbForm.getZhnldf());
		kjndgxjsqypjb.setCzzbdf(kjndgxjsqypjbForm.getCzzbdf());
		kjndgxjsqypjb.setZhpj(kjndgxjsqypjbForm.getZhpj());
		kjndgxjsqypjb.setPdzjz(kjndgxjsqypjbForm.getPdzjz());
		kjndgxjsqypjbDao.save(kjndgxjsqypjb);
	}
	private List<KjndgxjsqypjbForm> KjndgxjsqypjbPOListToVOList(List<Kjndgxjsqypjb> list) {
		// TODO Auto-generated method stub
		List<KjndgxjsqypjbForm> formlist=new ArrayList<KjndgxjsqypjbForm>();
		for(int i=0;i<list.size();i++){
			Kjndgxjsqypjb kjndgxjsqypjb=list.get(i);
			KjndgxjsqypjbForm kjndgxjsqypjbForm=new KjndgxjsqypjbForm();
//			jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjndgxjsqypjbForm.setId(String.valueOf(kjndgxjsqypjb.getId()));
			kjndgxjsqypjbForm.setYear(kjndgxjsqypjb.getYear());
			kjndgxjsqypjbForm.setQymc(kjndgxjsqypjb.getQymc());
			kjndgxjsqypjbForm.setCply(kjndgxjsqypjb.getCply());
			kjndgxjsqypjbForm.setZgzs(String.valueOf(kjndgxjsqypjb.getZgzs()));
			kjndgxjsqypjbForm.setDzysrs(String.valueOf(kjndgxjsqypjb.getDzysrs()));
			kjndgxjsqypjbForm.setYfrys(String.valueOf(kjndgxjsqypjb.getYfrys()));
			kjndgxjsqypjbForm.setXmhds(String.valueOf(kjndgxjsqypjb.getXmhds()));
			kjndgxjsqypjbForm.setCphds(String.valueOf(kjndgxjsqypjb.getCphds()));
			kjndgxjsqypjbForm.setJfze(kjndgxjsqypjb.getJfze());
			kjndgxjsqypjbForm.setYncpsr(kjndgxjsqypjb.getYncpsr());
			kjndgxjsqypjbForm.setJnyfze(kjndgxjsqypjb.getJnyfze());
			kjndgxjsqypjbForm.setDzrybl(kjndgxjsqypjb.getDzrybl());
			kjndgxjsqypjbForm.setYfrybl(kjndgxjsqypjb.getYfrybl());
			kjndgxjsqypjbForm.setJsnyfbl(kjndgxjsqypjb.getJsnyfbl());
			kjndgxjsqypjbForm.setJsnjnbl(kjndgxjsqypjb.getJsnjnbl());
			kjndgxjsqypjbForm.setJyngxsrbl(kjndgxjsqypjb.getJyngxsrbl());
			kjndgxjsqypjbForm.setZhdf(kjndgxjsqypjb.getZhdf());
			kjndgxjsqypjbForm.setZscqdf(kjndgxjsqypjb.getZscqdf());
			kjndgxjsqypjbForm.setGlspdf(kjndgxjsqypjb.getGlspdf());
			
			kjndgxjsqypjbForm.setZhnldf(kjndgxjsqypjb.getZhnldf());
			kjndgxjsqypjbForm.setCzzbdf(kjndgxjsqypjb.getCzzbdf());
			kjndgxjsqypjbForm.setZhpj(kjndgxjsqypjb.getZhpj());
			kjndgxjsqypjbForm.setPdzjz(kjndgxjsqypjb.getPdzjz());
			
			formlist.add(kjndgxjsqypjbForm);
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


		Kjndgxjsqypjb kjndgxjsqypjb=new Kjndgxjsqypjb();
		
		Cell cell= sheet.getCell(2,1);
		kjndgxjsqypjb.setYear(cell.getContents());
		
		cell=sheet.getCell(2,2);
		kjndgxjsqypjb.setQymc(cell.getContents());
		
		cell=sheet.getCell(9,2);
		kjndgxjsqypjb.setCply(cell.getContents());
	
		cell=sheet.getCell(2,3);
		kjndgxjsqypjb.setZgzs(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(7,3);
		kjndgxjsqypjb.setDzysrs(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(10,3);
		kjndgxjsqypjb.setYfrys(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(4,4);
		kjndgxjsqypjb.setXmhds(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(10,4);
		kjndgxjsqypjb.setCphds(Integer.valueOf(cell.getContents().trim()));
	
		cell=sheet.getCell(4,6);
		kjndgxjsqypjb.setJfze(cell.getContents());
	
		cell=sheet.getCell(10,6);
		kjndgxjsqypjb.setYncpsr(cell.getContents());
	
		cell=sheet.getCell(4,7);
		kjndgxjsqypjb.setJnyfze(cell.getContents());
		
		cell=sheet.getCell(10,8);
		kjndgxjsqypjb.setDzrybl(cell.getContents());
		
		cell=sheet.getCell(10,9);
		kjndgxjsqypjb.setYfrybl(cell.getContents());
		
		cell=sheet.getCell(10,10);
		kjndgxjsqypjb.setJsnyfbl(cell.getContents());
		
		cell=sheet.getCell(10,11);
		kjndgxjsqypjb.setJsnjnbl(cell.getContents());
		
		cell=sheet.getCell(10,12);
		kjndgxjsqypjb.setJyngxsrbl(cell.getContents());
		
		cell=sheet.getCell(10,13);
		kjndgxjsqypjb.setZscqdf(cell.getContents());
		
		cell=sheet.getCell(10,14);
		kjndgxjsqypjb.setZhnldf(cell.getContents());
		
		cell=sheet.getCell(10,15);
		kjndgxjsqypjb.setGlspdf(cell.getContents());
		
		cell=sheet.getCell(10,16);
		kjndgxjsqypjb.setCzzbdf(cell.getContents());
		
		cell=sheet.getCell(3,13);
		kjndgxjsqypjb.setZhdf(cell.getContents());
		
		cell=sheet.getCell(1,17);
		kjndgxjsqypjb.setZhpj(cell.getContents());
		
		cell=sheet.getCell(1,23);
		kjndgxjsqypjb.setPdzjz(cell.getContents());
		
		
		
		
		kjndgxjsqypjbDao.save(kjndgxjsqypjb);
			

		

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

		List<KjndgxjsqypjbForm> formlist =listtemp;
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\高新技术企业信息    admin  " + time + ".xls";

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
				Label lab1 = new Label(lie, 0, "年度",cellFormat);
			    sheet.addCell(lab1);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getYear(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "2":
				Label lab2 = new Label(lie, 0,"企业名称",cellFormat);
			    sheet.addCell(lab2);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getQymc(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "3":
				Label lab3 = new Label(lie, 0, "最初取证年份",cellFormat);
			    sheet.addCell(lab3);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getZcqznf(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "4":
				Label lab4 = new Label(lie, 0, "主营产品所属领域",cellFormat);
			    sheet.addCell(lab4);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getCply(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "5":
				Label lab5 = new Label(lie, 0, "职工总数",cellFormat);
			    sheet.addCell(lab5);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getZgzs(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "6":
				Label lab6 = new Label(lie, 0, "大专以上学历科技人员数",cellFormat);
			    sheet.addCell(lab6);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getDzysrs(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			case "7":
				Label lab7 = new Label(lie, 0, "研发人员数",cellFormat);
			    sheet.addCell(lab7);
			    for(int j=1;j<=formlist.size();j++){
			    	Label label = new Label(lie, j, formlist.get(j-1).getYfrys(),cellFormat);
					sheet.addCell(label);
			    }
			    lie++;
			    break;
			    
				case "8":
					Label lab8 = new Label(lie, 0, "研发项目核定数",cellFormat);
				    sheet.addCell(lab8);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getXmhds(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "9":
					Label lab9 = new Label(lie, 0,"高新技术产品核定数",cellFormat);
				    sheet.addCell(lab9);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getCphds(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "10":
					Label lab10 = new Label(lie, 0, "研发项目经费核定总额",cellFormat);
				    sheet.addCell(lab10);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getJfze(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "11":
					Label lab11 = new Label(lie, 0, "近一年高新产品销售收入核定额",cellFormat);
				    sheet.addCell(lab11);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getYncpsr(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "12":
					Label lab12 = new Label(lie, 0, "在中国境内研发费用总额定数",cellFormat);
				    sheet.addCell(lab12);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getJnyfze(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "13":
					Label lab13 = new Label(lie, 0, "大专以上学历科技人员占企业职工总数比例",cellFormat);
				    sheet.addCell(lab13);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getDzrybl(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				case "14":
					Label lab14 = new Label(lie, 0, "研发人员占企89业职工总数的比例",cellFormat);
				    sheet.addCell(lab14);
				    for(int j=1;j<=formlist.size();j++){
				    	Label label = new Label(lie, j, formlist.get(j-1).getYfrybl(),cellFormat);
						sheet.addCell(label);
				    }
				    lie++;
				    break;
				    
					case "15":
						Label lab15 = new Label(lie, 0, "近3年研究开发费用总额占总销售收入比例",cellFormat);
					    sheet.addCell(lab15);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getJsnyfbl(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "16":
						Label lab16 = new Label(lie, 0,"近3年在中国境内研发费用总额占全部研发费用总额比例",cellFormat);
					    sheet.addCell(lab16);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getJsnjnbl(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "17":
						Label lab17 = new Label(lie, 0, "近1年高新技术产品（服务）收入占当年总收入比例",cellFormat);
					    sheet.addCell(lab17);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getJyngxsrbl(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "18":
						Label lab18 = new Label(lie, 0, "综合得分",cellFormat);
					    sheet.addCell(lab18);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getZhdf(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "19":
						Label lab19 = new Label(lie, 0, "知识产权得分",cellFormat);
					    sheet.addCell(lab19);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getZhnldf(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "20":
						Label lab20 = new Label(lie, 0, "转化能力得分",cellFormat);
					    sheet.addCell(lab20);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getZhnldf(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					case "21":
						Label lab21 = new Label(lie, 0, "管理水平得分",cellFormat);
					    sheet.addCell(lab21);
					    for(int j=1;j<=formlist.size();j++){
					    	Label label = new Label(lie, j, formlist.get(j-1).getGlspdf(),cellFormat);
							sheet.addCell(label);
					    }
					    lie++;
					    break;
					    
						case "22":
							Label lab22 = new Label(lie, 0, "成长指标得分",cellFormat);
						    sheet.addCell(lab22);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getCzzbdf(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						case "23":
							Label lab23 = new Label(lie, 0,"对企业整体情况的综合评价",cellFormat);
						    sheet.addCell(lab23);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getZhpj(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						case "24":
							Label lab24 = new Label(lie, 0, "评定专家组",cellFormat);
						    sheet.addCell(lab24);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getPdzjz(),cellFormat);
								sheet.addCell(label);
						    }
						    lie++;
						    break;
						case "25":
							Label lab25 = new Label(lie, 0, "备注",cellFormat);
						    sheet.addCell(lab25);
						    for(int j=1;j<=formlist.size();j++){
						    	Label label = new Label(lie, j, formlist.get(j-1).getBz(),cellFormat);
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
