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

import platform.dao.KjndgxjsqypjbDao;
import platform.domain.Kjndgxjsqypjb;
import platform.form.KjndgxjsqypjbForm;
import platform.service.KjndgxjsqypjbService;

@SuppressWarnings("unused")
@Service(KjndgxjsqypjbService.SERVICE_NAME)
public class KjndgxjsqypjbServiceImpl implements KjndgxjsqypjbService{

	@Resource(name=KjndgxjsqypjbDao.SERVICE_NAME)
	private KjndgxjsqypjbDao kjndgxjsqypjbDao;
	private List<KjndgxjsqypjbForm>  listtemp=new ArrayList<KjndgxjsqypjbForm> ();


	@Override
    public List<KjndgxjsqypjbForm> findKjndgxjsqypjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zgzs", "desc");
		List<Kjndgxjsqypjb> list=this.kjndgxjsqypjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndgxjsqypjbForm> formlist=this.KjndgxjsqypjbPOListToVOList(list);
		return formlist;

	}
	@Override
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
		List<Kjndgxjsqypjb> list=this.kjndgxjsqypjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjndgxjsqypjbForm> formlist=this.KjndgxjsqypjbPOListToVOList(list);

	if(pageno==1){

			this.listtemp =
					this.KjndgxjsqypjbPOListToVOList(this.kjndgxjsqypjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
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
	@Override
    public void updateKjndgxjsqypjb(KjndgxjsqypjbForm kjndgxjsqypjbForm,String username){
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

		kjndgxjsqypjb.setZcqznf(kjndgxjsqypjbForm.getZcqznf());

		kjndgxjsqypjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndgxjsqypjb.setUsername(username);
		kjndgxjsqypjb.setGxsj(new Date().toString());

		kjndgxjsqypjb.setSubmit(0);

		this.kjndgxjsqypjbDao.update(kjndgxjsqypjb);

	}
	@Override
    public void deleteObject(String id){
		this.kjndgxjsqypjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	@Override
    public void saveObject(KjndgxjsqypjbForm kjndgxjsqypjbForm,String username){
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

		kjndgxjsqypjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndgxjsqypjb.setUsername(username);
		kjndgxjsqypjb.setGxsj(new Date().toString());
		kjndgxjsqypjb.setSubmit(0);
		kjndgxjsqypjb.setZcqznf(kjndgxjsqypjbForm.getZcqznf());
		this.kjndgxjsqypjbDao.save(kjndgxjsqypjb);
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

			kjndgxjsqypjbForm.setJlnf(kjndgxjsqypjb.getJlnf());
			kjndgxjsqypjbForm.setUsername(kjndgxjsqypjb.getUsername());
			kjndgxjsqypjbForm.setGxsj(kjndgxjsqypjb.getGxsj());
			kjndgxjsqypjbForm.setSubmit(String.valueOf(kjndgxjsqypjb.getSubmit()));

			kjndgxjsqypjbForm.setZcqznf(kjndgxjsqypjb.getZcqznf());
			formlist.add(kjndgxjsqypjbForm);
		}
		return formlist;
	}

	@Override
	public void showimportObject(String showimport,String username)  throws Exception {

		String b = showimport.replace("\\", "\\\\");
		String c = b.replace("C:\\\\fakepath", "D:\\kjcoutput");

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

		try{
		cell=sheet.getCell(2,3);
		if(!cell.getContents().equals(""))
		kjndgxjsqypjb.setZgzs(Integer.valueOf(cell.getContents()));
		}catch(Exception e){System.out.println(e);}

		try{
		cell=sheet.getCell(7,3);
		if(!cell.getContents().equals(""))
		kjndgxjsqypjb.setDzysrs(Integer.valueOf(cell.getContents()));
		}catch(Exception e){}
		try{
		cell=sheet.getCell(10,3);
		if(!cell.getContents().equals(""))
		kjndgxjsqypjb.setYfrys(Integer.valueOf(cell.getContents()));
		}catch(Exception e){}
		try{
		cell=sheet.getCell(4,4);
		if(!cell.getContents().equals(""))
		kjndgxjsqypjb.setXmhds(Integer.valueOf(cell.getContents()));
		}catch(Exception e){}
		try{
		cell=sheet.getCell(10,4);
		if(!cell.getContents().equals(""))
		kjndgxjsqypjb.setCphds(Integer.valueOf(cell.getContents()));
		}catch(Exception e){}

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

		kjndgxjsqypjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndgxjsqypjb.setUsername(username);
		kjndgxjsqypjb.setGxsj(new Date().toString());
		kjndgxjsqypjb.setSubmit(0);

		this.kjndgxjsqypjbDao.save(kjndgxjsqypjb);




		book.close();
		// } catch (Exception e) {
		// System.out.println(e);
		// }


	}



	@Override
    public void showexportObject(String str) throws Exception {

		File file =new File("D:\\kjcoutput");
		//如果文件夹不存在则创建
		if  (!file .exists()  && !file .isDirectory())
		{
		    System.out.println("//不存在");
		    file .mkdir();
		}
		String[] ss = str.split(" ");

		String hqlWhere = "";
		Object[] params = null;
//		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
//		orderby.put(" o.qjsl", "desc");
//		List<Kjsjjljgxxb> list = kjsjjljgxxbDao
//				.findCollectionByConditionNoPage(hqlWhere, params, orderby);
	//	List<KjsjjljgxxbForm> formlist = this.KjsjjljgxxbPOListToVOList(list);

		List<KjndgxjsqypjbForm> formlist =this.listtemp;

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\kjcoutput\\高新技术企业信息    admin  " + time + ".xls";

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

	@Override
    public List<KjndgxjsqypjbForm> findKjndgxjsqypjbById(KjndgxjsqypjbForm kjndgxjsqypjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjndgxjsqypjbForm!=null&&StringUtils.isNotBlank(kjndgxjsqypjbForm.getId())){
			hqlWhere += " o.id="+kjndgxjsqypjbForm.getId();
			//paramsList.add(kjndgxjsqypjbForm.getId());
		}

		orderby.put(" o.zgzs", "desc");
		params = paramsList.toArray();


		List<Kjndgxjsqypjb> list=this.kjndgxjsqypjbDao.findCollectionByConditionNoPage2(hqlWhere, params, orderby);


		List<KjndgxjsqypjbForm> formlist=this.KjndgxjsqypjbPOListToVOList(list);

		return formlist;

	}

	@Override
    public void showexportoneObject(List<KjndgxjsqypjbForm> formlist)
			throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\表8  高新技术企业信息   admin  "+"企业名称-"+formlist.get(0).getQymc()+"   " + time + ".xls";


		// 打开文件
		WritableWorkbook book = Workbook.createWorkbook(new File(path));
		// 生成名为“第一页”的工作表，参数0表示这是第一页
		WritableSheet sheet = book.createSheet(" 第一页 ", 0);

		WritableCellFormat cf=new WritableCellFormat();
		cf.setAlignment(jxl.format.Alignment.CENTRE);


		for(int i=1;i<=10;i++)
		{
			sheet.setColumnView( i , 12 );
		}

		sheet.mergeCells(4, 0, 6, 0);
	    Label label1= new Label(4,0,"高新技术企业认定综合评价表",cf);
	    sheet.addCell(label1);

//	    //边框
	    WritableCellFormat cellFormat=new WritableCellFormat();
		cellFormat.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN);
		cellFormat.setAlignment(jxl.format.Alignment.CENTRE);

	    Label label2= new Label(1,1,"年份",cellFormat);
	    sheet.addCell(label2);


		sheet.mergeCells(2, 1, 10, 1);
	    Label label3= new Label(2,1,formlist.get(0).getYear(),cellFormat);
	    sheet.addCell(label3);

	    Label label4= new Label(1,2,"企业名称",cellFormat);
	    sheet.addCell(label4);


		sheet.mergeCells(2, 2, 5, 2);
	    Label label5= new Label(2,2,formlist.get(0).getQymc(),cellFormat);
	    sheet.addCell(label5);


	    sheet.mergeCells(6, 2, 8, 2);
	    Label label6= new Label(6,2,"主营产品（服务）所属技术领域",cellFormat);
	    sheet.addCell(label6);

	    sheet.mergeCells(9, 2, 10, 2);
	    Label label7= new Label(9,2,formlist.get(0).getCply(),cellFormat);
	    sheet.addCell(label7);


	    Label label8= new Label(1,3,"职工总数（人）",cellFormat);
	    sheet.addCell(label8);

	    sheet.mergeCells(2, 3, 3, 3);
	    Label label9= new Label(3,2,formlist.get(0).getZgzs(),cellFormat);
	    sheet.addCell(label9);

	    sheet.mergeCells(4, 3, 6, 3);
	    Label label11= new Label(4,3,"大专以上学历科技人员数（人）",cellFormat);
	    sheet.addCell(label11);

	    sheet.mergeCells(7, 3, 8, 3);
	    Label label12= new Label(7,3,formlist.get(0).getDzysrs(),cellFormat);
	    sheet.addCell(label12);

	    Label label13= new Label(9,3,"研发人员数（人）",cellFormat);
	    sheet.addCell(label13);
	    Label label14= new Label(10,3,formlist.get(0).getYfrys(),cellFormat);
	    sheet.addCell(label14);


	    sheet.mergeCells(1, 4, 3, 5);
	    Label label15= new Label(1,4,"研发项目核定数",cellFormat);
	    sheet.addCell(label15);

	    sheet.mergeCells(4, 4, 5, 5);
	    Label label16= new Label(4,4,formlist.get(0).getXmhds(),cellFormat);
	    sheet.addCell(label16);

	    sheet.mergeCells(6, 4, 9, 5);
	    Label label17= new Label(6,4,"高新技术产品（服务）核定数",cellFormat);
	    sheet.addCell(label17);


	    sheet.mergeCells(10, 4, 10, 5);
	    Label label18= new Label(10,4,formlist.get(0).getCphds(),cellFormat);
	    sheet.addCell(label18);


	    sheet.mergeCells(1, 6, 3, 6);
	    Label label151= new Label(1,6,"研发项目经费核定总额（万元）",cellFormat);
	    sheet.addCell(label151);

	    sheet.mergeCells(4, 6, 5, 6);
	    Label label161= new Label(4,6,formlist.get(0).getJfze(),cellFormat);
	    sheet.addCell(label161);

	    sheet.mergeCells(6, 6, 9, 6);
	    Label label171= new Label(6,6,"近一年高新技术产品（服务）销售收入核定额（万元）",cellFormat);
	    sheet.addCell(label171);

	    Label label181= new Label(10,6,formlist.get(0).getYncpsr(),cellFormat);
	    sheet.addCell(label181);

	    sheet.mergeCells(1, 7, 3, 7);
	    Label label19= new Label(1,7,"在中国境内研发费用总额核定数（万元）",cellFormat);
	    sheet.addCell(label19);

	    sheet.mergeCells(4, 7, 10, 7);
	    Label label20= new Label(4,7,formlist.get(0).getJnyfze(),cellFormat);
	    sheet.addCell(label20);


	    sheet.mergeCells(1, 8, 9, 8);
	    Label label21= new Label(1,8,"大专以上学历科技人员占企业职工总数的比例（%）",cellFormat);
	    sheet.addCell(label21);
	    Label label22= new Label(10,8,formlist.get(0).getDzrybl(),cellFormat);
	    sheet.addCell(label22);


	    sheet.mergeCells(1, 9, 9, 9);
	    Label label211= new Label(1,9,"研发人员占企业职工总数的比例（%）",cellFormat);
	    sheet.addCell(label211);
	    Label label221= new Label(10,9,formlist.get(0).getYfrybl(),cellFormat);
	    sheet.addCell(label221);

	    sheet.mergeCells(1, 10, 9, 10);
	    Label label212= new Label(1,10,"近3年研究开发费用总额占总销售收入比例（%）",cellFormat);
	    sheet.addCell(label212);
	    Label label222= new Label(10,10,formlist.get(0).getJsnyfbl(),cellFormat);
	    sheet.addCell(label222);

	    sheet.mergeCells(1, 11, 9,11);
	    Label label213= new Label(1,11,"近3年在中国境内研发费用总额占全部研发费用总额比例（%）",cellFormat);
	    sheet.addCell(label213);
	    Label label223= new Label(10,11,formlist.get(0).getJsnjnbl(),cellFormat);
	    sheet.addCell(label223);

	    sheet.mergeCells(1, 12, 9, 12);
	    Label label214= new Label(1,12,"近1年高新技术产品（服务）收入占当年总收入比例（%）",cellFormat);
	    sheet.addCell(label214);
	    Label label224= new Label(10,12,formlist.get(0).getJyngxsrbl(),cellFormat);
	    sheet.addCell(label224);


	    sheet.mergeCells(1, 13, 2, 16);
	    Label label23= new Label(1,13,"综合得分",cellFormat);
	    sheet.addCell(label23);
	    sheet.mergeCells(3, 13, 4, 16);
	    Label label24= new Label(3,13,formlist.get(0).getZhdf(),cellFormat);
	    sheet.addCell(label24);
	    sheet.mergeCells(5, 13, 7, 16);
	    Label label25= new Label(5,13,"其中：",cellFormat);
	    sheet.addCell(label25);

	    sheet.mergeCells(8, 13, 9, 13);
	    Label label26= new Label(8,13,"知识产权得分",cellFormat);
	    sheet.addCell(label26);
	    sheet.mergeCells(8, 14, 9, 14);
	    Label label261= new Label(8,14,"转化能力得分",cellFormat);
	    sheet.addCell(label261);
	    sheet.mergeCells(8, 15, 9, 15);
	    Label label262= new Label(8,15,"管理水平得分",cellFormat);
	    sheet.addCell(label262);
	    sheet.mergeCells(8, 16, 9, 16);
	    Label label263= new Label(8,16,"成长指标得分",cellFormat);
	    sheet.addCell(label263);

	    Label label271= new Label(10,13,formlist.get(0).getZscqdf(),cellFormat);
	    sheet.addCell(label271);
	    Label label272= new Label(10,14,formlist.get(0).getZhnldf(),cellFormat);
	    sheet.addCell(label272);
	    Label label273= new Label(10,15,formlist.get(0).getGlspdf(),cellFormat);
	    sheet.addCell(label273);
	    Label label274= new Label(10,16,formlist.get(0).getCzzbdf(),cellFormat);
	    sheet.addCell(label274);

	    sheet.mergeCells(1, 17, 10, 22);
	    Label label28= new Label(1,17,"对企业整体情况的综合评价（对照《认定办法》规定的各项认定指标，简要进行综合评价）：\n"+formlist.get(0).getZhpj(),cellFormat);
	    sheet.addCell(label28);

	    sheet.mergeCells(1, 23, 10, 23);
	    Label label281= new Label(1,23,"评定专家组："+formlist.get(0).getPdzjz(),cellFormat);
	    sheet.addCell(label281);


	    book.write();
		book.close();
	}

}
