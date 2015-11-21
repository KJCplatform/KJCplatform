package platform.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.BorderLineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.KjjszjcjbDao;
import platform.domain.Kjjszjcjb;
import platform.domain.Kjjszjcjbcg;
import platform.domain.Kjjszjcjbxm;
import platform.domain.Kjjszjcjbzy;
import platform.domain.Kjsjjljgxxb;
import platform.form.KjjszjcjbForm;
import platform.form.KjjszjcjbcgForm;
import platform.form.KjjszjcjbxmForm;
import platform.form.KjjszjcjbzyForm;
import platform.form.KjsjjljgxxbForm;
import platform.service.KjjszjcjbService;
import platform.util.StringHelper;
@Transactional
@Service(KjjszjcjbService.SERVICE_NAME)
public class KjjszjcjbServiceImpl implements KjjszjcjbService{
	
	@Resource(name=KjjszjcjbDao.SERVICE_NAME)
	private KjjszjcjbDao kjjszjcjbDao;

	public String saveKjjszjcjb(KjjszjcjbForm kjjszjcjbForm){
		Kjjszjcjb kjjszjcjb=this.VoObjecttoPoObject(kjjszjcjbForm);
		kjjszjcjbDao.save(kjjszjcjb);
		return kjjszjcjbDao.selectMaxId();
		
	}
  
	private Kjjszjcjb VoObjecttoPoObject(KjjszjcjbForm kjjszjcjbForm) {
		Kjjszjcjb kjjszjcjb=new Kjjszjcjb();
		kjjszjcjb.setFwyy(kjjszjcjbForm.getFwyy());
		kjjszjcjb.setGzbm(kjjszjcjbForm.getGzbm());
		kjjszjcjb.setGzdw(kjjszjcjbForm.getGzdw());
		kjjszjcjb.setHyly(kjjszjcjbForm.getHyly());
		kjjszjcjb.setJsly(kjjszjcjbForm.getJsly());
		kjjszjcjb.setJszc(kjjszjcjbForm.getJszc());
		kjjszjcjb.setLxdh(kjjszjcjbForm.getLxdh());
		kjjszjcjb.setLxdz(kjjszjcjbForm.getLxdz());
		if(kjjszjcjbForm.getSfgk().equals("是")){
		kjjszjcjb.setSfgk(true);}
		else if(kjjszjcjbForm.getSfgk().equals("否"))
		{kjjszjcjb.setSfgk(false);}
		kjjszjcjb.setSfzh(kjjszjcjbForm.getSfzh());
		kjjszjcjb.setSj(kjjszjcjbForm.getSj());
		kjjszjcjb.setSzdq(kjjszjcjbForm.getSzdq());
		kjjszjcjb.setSzpt(kjjszjcjbForm.getSzpt());
		kjjszjcjb.setXb(kjjszjcjbForm.getXb());
		kjjszjcjb.setXkly(kjjszjcjbForm.getXkly());
		kjjszjcjb.setYx(kjjszjcjbForm.getYx());
		kjjszjcjb.setZgxl(kjjszjcjbForm.getZgxl());
		kjjszjcjb.setZjjj(kjjszjcjbForm.getZjjj());
		kjjszjcjb.setZjxm(kjjszjcjbForm.getZjxm());
		kjjszjcjb.setZw(kjjszjcjbForm.getZw());
		kjjszjcjb.setZytc(kjjszjcjbForm.getZytc());
		
		
		return kjjszjcjb;
	}
	public void addCxyListWithExpertId(int id, List<KjjszjcjbxmForm> list){
		List<Kjjszjcjbxm> Plist=this.xmPoToVoList(list);
		Kjjszjcjb kjjszjcjb= kjjszjcjbDao.findObjectByID(id);
		
		System.out.println(Plist.get(0).getHzsj());
		System.out.println(Plist.get(0).getXmjj());
		System.out.println(Plist.get(0).getXmmc());
		System.out.println(Plist.get(0).getHzxg());
		System.out.println(Plist.get(0).getId());
		System.out.println(Plist.get(0).getKjjszjcjbs());
	
		
		
		for(int i=0;i<Plist.size();i++){
			kjjszjcjb.getKjjszjcjbxms().add(Plist.get(i));
		}
	}
	
	public void addJscgListWithExpertId(int id, List<KjjszjcjbcgForm> list){
		List<Kjjszjcjbcg> Plist=this.cgPoToVoList(list);
		Kjjszjcjb kjjszjcjb= kjjszjcjbDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			kjjszjcjb.getKjjszjcjbcgs().add(Plist.get(i));
		}
		
	}
	public void addzyListWithExpertId(int id, List<KjjszjcjbzyForm> list){
		List<Kjjszjcjbzy> Plist=this.zyPoToVoList(list);
		Kjjszjcjb kjjszjcjb= kjjszjcjbDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			kjjszjcjb.getKjjszjcjbzys().add(Plist.get(i));
		}
	}
	private List<Kjjszjcjbzy> zyPoToVoList(List<KjjszjcjbzyForm> list) {
		List<Kjjszjcjbzy> Plist=new ArrayList<Kjjszjcjbzy>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjbzy kjjszjcjbzy=new Kjjszjcjbzy();
			kjjszjcjbzy.setWcsj(StringHelper.stringConvertDate2(list.get(i).getWcsj()));
			kjjszjcjbzy.setXmjj(list.get(i).getXmjj());
			kjjszjcjbzy.setXmmc(list.get(i).getXmmc());
			if(list.get(i).getSfzh().equals("是")){
				kjjszjcjbzy.setSfzh(true);
			}else if(list.get(i).getSfzh().equals("否")){
				kjjszjcjbzy.setSfzh(false);
			}
			Plist.add(kjjszjcjbzy);
		}
		return Plist;
	}

	private List<Kjjszjcjbcg> cgPoToVoList(List<KjjszjcjbcgForm> list) {
		List<Kjjszjcjbcg> Plist=new ArrayList<Kjjszjcjbcg>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjbcg kjjszjcjbcg=new Kjjszjcjbcg();
			kjjszjcjbcg.setWcsj(StringHelper.stringConvertDate2(list.get(i).getWcsj()));
			kjjszjcjbcg.setCgjj(list.get(i).getCgjj());
			kjjszjcjbcg.setCgmc(list.get(i).getCgmc());
			if(list.get(i).getZhqk().equals("已转化，继续转化")){
				kjjszjcjbcg.setZhqk(true);
			}else if(list.get(i).getZhqk().equals("未转化，希望转化")){
				kjjszjcjbcg.setZhqk(false);
			}
			Plist.add(kjjszjcjbcg);
		}
		return Plist;
	}

	private List<Kjjszjcjbxm> xmPoToVoList(List<KjjszjcjbxmForm> list) {
		List<Kjjszjcjbxm> Plist=new ArrayList<Kjjszjcjbxm>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjbxm kjjszjcjbxm=new Kjjszjcjbxm();
			kjjszjcjbxm.setHzsj(list.get(i).getHzsj());
			kjjszjcjbxm.setXmjj(list.get(i).getXmjj());
			kjjszjcjbxm.setXmmc(list.get(i).getXmmc());
			if(list.get(i).getHzxg().equals("良好")){
				kjjszjcjbxm.setHzxg(true);
			}else if(list.get(i).getHzxg().equals("一般")){
				kjjszjcjbxm.setHzxg(false);
			}
			Plist.add(kjjszjcjbxm);
		}
		return Plist;
	}
	public List<KjjszjcjbForm> findKjjszjcjbList(KjjszjcjbForm kjjszjcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjjszjcjbForm!=null&&StringUtils.isNotBlank(kjjszjcjbForm.getZjxm())){
			hqlWhere += " and o.zjxm = ?";
			paramsList.add(kjjszjcjbForm.getZjxm());
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb> list=kjjszjcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjjszjcjbForm> formlist=this.KjjszjcjbPoToVoList(list);
		return formlist;
	}
	 
	private List<KjjszjcjbForm> KjjszjcjbPoToVoList(List<Kjjszjcjb> list) {
		List<KjjszjcjbForm> formlist=new ArrayList<KjjszjcjbForm>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			KjjszjcjbForm kjjszjcjbForm=new KjjszjcjbForm();
			kjjszjcjbForm.setFwyy(list.get(i).getFwyy());
			kjjszjcjbForm.setGzbm(list.get(i).getGzbm());
			kjjszjcjbForm.setGzdw(list.get(i).getGzdw());
			kjjszjcjbForm.setHyly(list.get(i).getHyly());
			kjjszjcjbForm.setJsly(list.get(i).getJsly());
			kjjszjcjbForm.setJszc(list.get(i).getJszc());
			kjjszjcjbForm.setLxdh(list.get(i).getLxdh());
			kjjszjcjbForm.setLxdz(list.get(i).getLxdz());
			
			if(list.get(i).getSfgk()!=null){
			 if(list.get(i).getSfgk()==true)
			kjjszjcjbForm.setSfgk("是");
			else kjjszjcjbForm.setSfgk("否");}
			
			kjjszjcjbForm.setSfzh(list.get(i).getSfzh());
			kjjszjcjbForm.setSj(list.get(i).getSj());
			kjjszjcjbForm.setSzdq(list.get(i).getSzdq());
			kjjszjcjbForm.setSzpt(list.get(i).getSzpt());
			kjjszjcjbForm.setXb(list.get(i).getXb());
			kjjszjcjbForm.setXkly(list.get(i).getXkly());
			kjjszjcjbForm.setYx(list.get(i).getYx());
			kjjszjcjbForm.setZgxl(list.get(i).getZgxl());
			kjjszjcjbForm.setZjjj(list.get(i).getZjjj());
			kjjszjcjbForm.setZjxm(list.get(i).getZjxm());
			kjjszjcjbForm.setZw(list.get(i).getZw());
			kjjszjcjbForm.setZytc(list.get(i).getZytc());
			kjjszjcjbForm.setKjjszjcjbcgs(KjjszjcjbcgSetToFormList(list.get(i).getKjjszjcjbcgs()));
			kjjszjcjbForm.setKjjszjcjbzys(KjjszjcjbzySetToFormList(list.get(i).getKjjszjcjbzys()));
			kjjszjcjbForm.setKjjszjcjbxms(KjjszjcjbxmSetToFormList(list.get(i).getKjjszjcjbxms()));
			formlist.add(kjjszjcjbForm);
		}}
		return formlist;
	}

	private List<KjjszjcjbxmForm> KjjszjcjbxmSetToFormList(
			Set<Kjjszjcjbxm> kjjszjcjbxms) {
   List<KjjszjcjbxmForm> formlist=new ArrayList<KjjszjcjbxmForm>();
   if(kjjszjcjbxms.size()>0){
		for(Kjjszjcjbxm kjjszjcjbxm:kjjszjcjbxms){
			KjjszjcjbxmForm kjjszjcjbxmForm=new KjjszjcjbxmForm();
			kjjszjcjbxmForm.setHzsj(kjjszjcjbxm.getHzsj());
			if(kjjszjcjbxm.getHzxg()!=null) 
			{if(kjjszjcjbxm.getHzxg()==true)
			kjjszjcjbxmForm.setHzxg("良好");
             else kjjszjcjbxmForm.setHzxg("一般");}
			kjjszjcjbxmForm.setXmjj(kjjszjcjbxm.getXmjj());
			kjjszjcjbxmForm.setXmmc(kjjszjcjbxm.getXmmc());
			formlist.add(kjjszjcjbxmForm);
		}}
		return formlist;
	}

	private List<KjjszjcjbzyForm> KjjszjcjbzySetToFormList(
			Set<Kjjszjcjbzy> kjjszjcjbzys) {
		List<KjjszjcjbzyForm> formlist=new ArrayList<KjjszjcjbzyForm>();
		if(kjjszjcjbzys.size()>0){
		for(Kjjszjcjbzy kjjszjcjbzy:kjjszjcjbzys){
			KjjszjcjbzyForm kjjszjcjbzyForm=new KjjszjcjbzyForm();
			if(kjjszjcjbzy.getSfzh()!=null)
			{
			if(kjjszjcjbzy.getSfzh()==true)
			kjjszjcjbzyForm.setSfzh("是");
			else kjjszjcjbzyForm.setSfzh("否");}
			kjjszjcjbzyForm.setWcsj(kjjszjcjbzy.getWcsj().toString());
			kjjszjcjbzyForm.setXmjj(kjjszjcjbzy.getXmmc());
			kjjszjcjbzyForm.setXmmc(kjjszjcjbzy.getXmmc());
			formlist.add(kjjszjcjbzyForm);
			
		}}
		return formlist;
	}

	private List<KjjszjcjbcgForm> KjjszjcjbcgSetToFormList(
			Set<Kjjszjcjbcg> kjjszjcjbcgs) {
		// TODO Auto-generated method stub
		List<KjjszjcjbcgForm> formlist=new ArrayList<KjjszjcjbcgForm>();
		if(kjjszjcjbcgs.size()>0){
		for(Kjjszjcjbcg kjjszjcjbcg:kjjszjcjbcgs){
			KjjszjcjbcgForm kjjszjcjbcgForm=new KjjszjcjbcgForm();
			kjjszjcjbcgForm.setCgjj(kjjszjcjbcg.getCgjj());
			kjjszjcjbcgForm.setCgmc(kjjszjcjbcg.getCgmc());
			kjjszjcjbcgForm.setWcsj(String.valueOf(kjjszjcjbcg.getWcsj()));
			if(kjjszjcjbcg.getZhqk()!=null)
			{if(kjjszjcjbcg.getZhqk()==true)
			kjjszjcjbcgForm.setZhqk("已转化，继续转化");
			else kjjszjcjbcgForm.setZhqk("未转化，希望转化");}
			formlist.add(kjjszjcjbcgForm);
		}}
		return formlist;
	}

	@Override
	public List<KjjszjcjbForm> findContactWithpage(int pagesize, int pageno) {
		// TODO Auto-generated method stub
		List<KjjszjcjbForm> formlist=new ArrayList<KjjszjcjbForm>();
		List<Object[]> list=kjjszjcjbDao.findContactWithpage(pagesize, pageno);
		for(int i=0;i<list.size();i++){
			KjjszjcjbForm kjjszjcjbForm=new KjjszjcjbForm();
			kjjszjcjbForm.setZjxm(list.get(i)[0].toString());
			kjjszjcjbForm.setGzdw(list.get(i)[1].toString());
			kjjszjcjbForm.setGzbm(list.get(i)[2].toString());
			kjjszjcjbForm.setZw(list.get(i)[3].toString());
			kjjszjcjbForm.setSj(list.get(i)[4].toString());
			kjjszjcjbForm.setLxdh(list.get(i)[5].toString());
			formlist.add(kjjszjcjbForm);
		}
		return formlist;
	}

	@Override
	public int listSize() {
		// TODO Auto-generated method stub
		int size=kjjszjcjbDao.findCollectionByConditionNoPage("", null, null).size();
		return size;
	}
	
	
	
	
	
	public void showimportObject(String showimport) throws Exception {
//
//		String b = showimport.replace("\\", "\\\\");
//		String c = b.replace("C:\\\\fakepath", "D:");
//
//		Workbook book = Workbook.getWorkbook(new File(c));
//		// Workbook book = Workbook.getWorkbook( new File(b));
//		// 获得第一个工作表对象
//		Sheet sheet = book.getSheet(0);
//		// 得到第一列第一行的单元格
//
//		int columnum = sheet.getColumns();// 得到列数
//		int rownum = sheet.getRows();// 得到行数
//
//		int array[] = new int[50];
//
//		for (int i = 0; i < rownum; i++) {
//
//			if (i == 0) {
//				for (int j = 0; j < columnum; j++) {
//					Cell cell0 = sheet.getCell(j, i);
//					switch (cell0.getContents().trim()) {
//					case "法人单位名称":
//						array[j] = 1;
//						break;
//					case "涉及的计量专业":
//						array[j] = 2;
//						break;
//					case "企事业最高计量标准器具数量":
//						array[j] = 3;
//						break;
//					case "通讯地址":
//						array[j] = 4;
//						break;
//					case "联系人":
//						array[j] = 5;
//						break;
//					case "办公电话":
//						array[j] = 6;
//						break;
//					case "手机":
//						array[j] = 7;
//						break;
//					}
//				}
//
//			}
//
//			else {
//
//				Kjsjjljgxxb kjsjjljgxxb = new Kjsjjljgxxb();
//				for (int j = 0; j < columnum; j++) {
//
//					Cell cell0 = sheet.getCell(j, i);
//
//					switch (array[j]) {
//					case 1:
//						kjsjjljgxxb.setFrmc(cell0.getContents());
//						break;
//					case 2:
//						kjsjjljgxxb.setJlzy(cell0.getContents());
//						break;
//					case 3:
//						kjsjjljgxxb.setQjsl(Integer.valueOf(cell0.getContents()));
//						break;
//					case 4:
//						kjsjjljgxxb.setTxdz(cell0.getContents());
//						break;
//					case 5:
//						kjsjjljgxxb.setLxr(cell0.getContents());
//						break;
//					case 6:
//						kjsjjljgxxb.setBgdh(cell0.getContents());
//						break;
//					case 7:
//						kjsjjljgxxb.setSj(Integer.valueOf(cell0.getContents()));
//						break;
//					}
//				}
//
//				kjsjjljgxxbDao.save(kjsjjljgxxb);
//			}
//
//		}
//
//		book.close();
//		// } catch (Exception e) {
//		// System.out.println(e);
//		// }

	}

	@Override
	public void showexportObject(String str,List<KjjszjcjbForm> formlist) throws Exception {

	
		String hqlWhere = "zjxm='"+str+"'";
		Object[] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zjxm", "desc");
	
		List<Kjjszjcjb> list=kjjszjcjbDao.findCollectionByConditionNoPage2(hqlWhere, params, orderby);
		List<KjjszjcjbForm> fm=this.KjjszjcjbPoToVoList(list);

		//System.out.println(list.get(0).getId());
		
//		for(int i=0;i<18;i++){
//			System.out.println("hhs:"+formlist.get(0).getKjjszjcjbxms().get(i).getXmjj());
//		}
		
	
		
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		// System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
		String time = df.format(new Date());
		String path = "D:\\表8  技术专家数据采集表   admin  "+"专家姓名-"+str+"   " + time + ".xls";

		
		// 打开文件
		WritableWorkbook book = Workbook.createWorkbook(new File(path));
		// 生成名为“第一页”的工作表，参数0表示这是第一页
		WritableSheet sheet = book.createSheet(" 第一页 ", 0);
		
		WritableCellFormat cf=new WritableCellFormat();
		cf.setAlignment(jxl.format.Alignment.CENTRE);
		    
		sheet.mergeCells(4, 0, 6, 0);
	    Label label1= new Label(4,0,"表8  技术专家数据采集表",cf); 
	    sheet.addCell(label1);
	    
//	    //边框
	    WritableCellFormat cellFormat=new WritableCellFormat();
		cellFormat.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
		cellFormat.setAlignment(jxl.format.Alignment.CENTRE);
	    
		sheet.mergeCells(0, 1, 1, 1);
	    Label label2_1= new Label(0,1,"专家姓名",cellFormat); 
	    sheet.addCell(label2_1);
		sheet.mergeCells(2, 1, 4, 1);
	    Label label2_2= new Label(2,1,formlist.get(0).getZjxm(),cellFormat); 
	    sheet.addCell(label2_2);
	    
		sheet.mergeCells(5, 1, 6, 1);
	    Label label2_3= new Label(5,1,"性别",cellFormat); 
	    sheet.addCell(label2_3);
		sheet.mergeCells(7, 1, 9, 1);
	    Label label2_4= new Label(7,1,formlist.get(0).getXb(),cellFormat); 
	    sheet.addCell(label2_4);
	    
	    
		sheet.mergeCells(0, 2, 1, 2);
	    Label label3_1= new Label(0,2,"身份证号",cellFormat); 
	    sheet.addCell(label3_1);
		sheet.mergeCells(2, 2, 4, 2);
	    Label label3_2= new Label(2,2,formlist.get(0).getSfzh(),cellFormat); 
	    sheet.addCell(label3_2);
	    
		sheet.mergeCells(5, 2, 6, 2);
	    Label label3_3= new Label(5,2,"邮箱",cellFormat); 
	    sheet.addCell(label3_3);
		sheet.mergeCells(7, 2, 9, 2);
	    Label label3_4= new Label(7,2,formlist.get(0).getYx(),cellFormat); 
	    sheet.addCell(label3_4);
	    
		sheet.mergeCells(0, 3, 1, 3);
	    Label label4_1= new Label(0,3,"技术职称",cellFormat); 
	    sheet.addCell(label4_1);
		sheet.mergeCells(2, 3, 4, 3);
	    Label label4_2= new Label(2,3,formlist.get(0).getJszc(),cellFormat); 
	    sheet.addCell(label4_2);
	    
		sheet.mergeCells(5, 3, 6, 3);
	    Label label4_3= new Label(5,3,"职务",cellFormat); 
	    sheet.addCell(label4_3);
		sheet.mergeCells(7, 3, 9, 3);
	    Label label4_4= new Label(7,3,formlist.get(0).getZw(),cellFormat); 
	    sheet.addCell(label4_4);
	    
		sheet.mergeCells(0, 4, 1, 4);
		Label label5_1= new Label(0,4,"工作单位",cellFormat); 
	    sheet.addCell(label5_1);
		sheet.mergeCells(2, 4, 9, 4);
		Label label5_2= new Label(2,4,formlist.get(0).getGzdw(),cellFormat); 
	    sheet.addCell(label5_2);
	    
		sheet.mergeCells(0, 5, 1, 5);
		Label label6_1= new Label(0,5,"工作部门",cellFormat); 
	    sheet.addCell(label6_1);
		sheet.mergeCells(2, 5, 9, 5);
		Label label6_2= new Label(2,5,formlist.get(0).getGzbm(),cellFormat); 
	    sheet.addCell(label6_2);
	    
		sheet.mergeCells(0, 6, 1, 6);
		Label label7_1= new Label(0,6,"最高学历",cellFormat); 
	    sheet.addCell(label7_1);
		sheet.mergeCells(2, 6, 9, 6);
		Label label7_2= new Label(2,6,formlist.get(0).getZgxl(),cellFormat); 
	    sheet.addCell(label7_2);
		   
	    
		sheet.mergeCells(0, 7, 1, 7);
		Label label8_1= new Label(0,7,"所在地区",cellFormat); 
	    sheet.addCell(label8_1);
		sheet.mergeCells(2, 7, 9, 7);
		Label label8_2= new Label(2,7,formlist.get(0).getSzdq(),cellFormat); 
	    sheet.addCell(label8_2);
	    
	    
		sheet.mergeCells(0, 8, 0, 10);
		Label label9to11_1= new Label(0,8,"研\n究\n方\n向",cellFormat); 
		sheet.addCell(label9to11_1);
	
		Label label9_1=new Label(1,8,"行业领域",cellFormat); 
		sheet.addCell(label9_1);
		sheet.mergeCells(2, 8, 9, 8);
		Label label9_2= new Label(2,8,formlist.get(0).getHyly(),cellFormat); 
		sheet.addCell(label9_2);
		
		Label label10_1=new Label(1,9,"技术领域",cellFormat); 
		sheet.addCell(label10_1);
		sheet.mergeCells(2, 9, 9, 9);
		Label label10_2= new Label(2,9,formlist.get(0).getJsly(),cellFormat); 
		sheet.addCell(label10_2);
		
		Label label11_1=new Label(1,10,"学科领域",cellFormat); 
		sheet.addCell(label11_1);
		sheet.mergeCells(2, 10, 9, 10);
		Label label11_2= new Label(2,10,formlist.get(0).getXkly(),cellFormat); 
		sheet.addCell(label11_2);
		
		
		sheet.mergeCells(0, 11, 1, 11);
		Label label12_1= new Label(0,11,"服务意愿",cellFormat); 
	    sheet.addCell(label12_1);
		sheet.mergeCells(2, 11, 9, 11);
		Label label12_2= new Label(2,11,formlist.get(0).getFwyy(),cellFormat); 
	    sheet.addCell(label12_2);
	    
	    
		sheet.mergeCells(0, 12, 1, 12);
		Label label13_1= new Label(0,12,"所在研发平台或实验基地",cellFormat); 
	    sheet.addCell(label13_1);
		sheet.mergeCells(2, 12, 9, 12);
		Label label13_2= new Label(2,12,formlist.get(0).getSzpt(),cellFormat); 
	    sheet.addCell(label13_2);
	    
	    
		sheet.mergeCells(0, 13, 1, 13);
		Label label14_1= new Label(0,13,"专家简介",cellFormat); 
	    sheet.addCell(label14_1);
		sheet.mergeCells(2, 13, 9, 13);
		Label label14_2= new Label(2,13,formlist.get(0).getZjjj(),cellFormat); 
	    sheet.addCell(label14_2);
	    
	    
		sheet.mergeCells(0, 14, 1, 14);
		Label label15_1= new Label(0,14,"专业特长",cellFormat); 
	    sheet.addCell(label15_1);
		sheet.mergeCells(2, 14, 9, 14);
		Label label15_2= new Label(2,14,formlist.get(0).getZytc(),cellFormat); 
	    sheet.addCell(label15_2);
	    
	    
	    int xmnum=formlist.get(0).getKjjszjcjbxms().size();
	    int cgnum=formlist.get(0).getKjjszjcjbcgs().size();
	    int zynum=formlist.get(0).getKjjszjcjbzys().size();
	    
//		System.out.println("hhsxm:"+formlist.get(0).getKjjszjcjbxms().size());
//		System.out.println("hhs2:"+formlist.get(0).getKjjszjcjbcgs().size());
//		System.out.println("hhs3:"+formlist.get(0).getKjjszjcjbzys().size());
	    
	    
		
		sheet.mergeCells(0, 15, 9, 15);
		Label label16= new Label(0,15,"产学研合作项目情况",cellFormat); 
		sheet.addCell(label16);
		
		
		
		for(int i=0;i<=xmnum;i++){
		
			if(i==0){
		sheet.mergeCells(0, 16+i, 1, 16+i);
		Label label17_1= new Label(0,16+i,"序号",cellFormat); 
		sheet.addCell(label17_1);
		sheet.mergeCells(2, 16+i, 3, 16+i);
		Label label17_2= new Label(2,16+i,"项目名称",cellFormat); 
		sheet.addCell(label17_2);
		sheet.mergeCells(4, 16+i, 5, 16+i);
		Label label17_3= new Label(4,16+i,"合作起止时间",cellFormat); 
		sheet.addCell(label17_3);
		sheet.mergeCells(6, 16+i, 7, 16+i);
		Label label17_4= new Label(6,16+i,"项目简介",cellFormat); 
		sheet.addCell(label17_4);
		sheet.mergeCells(8, 16+i, 9, 16+i);
		Label label17_5= new Label(8,16+i,"合作效果",cellFormat); 
		sheet.addCell(label17_5);
			}
			else{
				sheet.mergeCells(0, 16+i, 1, 16+i);
				Label label17_1= new Label(0,16+i,String.valueOf(i),cellFormat); 
				sheet.addCell(label17_1);
				sheet.mergeCells(2, 16+i, 3, 16+i);
				Label label17_2= new Label(2,16+i,formlist.get(0).getKjjszjcjbxms().get(i-1).getXmmc(),cellFormat); 
				sheet.addCell(label17_2);
				sheet.mergeCells(4, 16+i, 5, 16+i);
				Label label17_3= new Label(4,16+i,formlist.get(0).getKjjszjcjbxms().get(i-1).getHzsj(),cellFormat); 
				sheet.addCell(label17_3);
				sheet.mergeCells(6, 16+i, 7, 16+i);
				Label label17_4= new Label(6,16+i,formlist.get(0).getKjjszjcjbxms().get(i-1).getXmjj(),cellFormat); 
				sheet.addCell(label17_4);
				sheet.mergeCells(8, 16+i, 9, 16+i);
				Label label17_5= new Label(8,16+i,formlist.get(0).getKjjszjcjbxms().get(i-1).getHzxg(),cellFormat); 
				sheet.addCell(label17_5);
			}
				
			
			
		}
		
		
		sheet.mergeCells(0, 17+xmnum, 9, 17+xmnum);
		Label label18= new Label(0,17+xmnum,"主持或参与完成的技术成果情况",cellFormat); 
		sheet.addCell(label18);
		
		
		
		for(int i=xmnum;i<=xmnum+cgnum;i++){
			if(i==xmnum){
		sheet.mergeCells(0, 18+i, 1, 18+i);
		Label label19_1= new Label(0,18+i,"序号",cellFormat); 
		sheet.addCell(label19_1);
		sheet.mergeCells(2, 18+i, 3, 18+i);
		Label label19_2= new Label(2,18+i,"成果名称",cellFormat); 
		sheet.addCell(label19_2);
		sheet.mergeCells(4, 18+i, 5, 18+i);
		Label label19_3= new Label(4,18+i,"完成时间",cellFormat); 
		sheet.addCell(label19_3);
		sheet.mergeCells(6, 18+i, 7, 18+i);
		Label label19_4= new Label(6,18+i,"成果简介",cellFormat); 
		sheet.addCell(label19_4);
		sheet.mergeCells(8, 18+i, 9, 18+i);
		Label label19_5= new Label(8,18+i,"转化情况",cellFormat); 
		sheet.addCell(label19_5);
			}
			else{
				sheet.mergeCells(0, 18+i, 1, 18+i);
				Label label19_1= new Label(0,18+i,String.valueOf(i-xmnum),cellFormat); 
				sheet.addCell(label19_1);
				sheet.mergeCells(2, 18+i, 3, 18+i);
				Label label19_2= new Label(2,18+i,formlist.get(0).getKjjszjcjbcgs().get(i-xmnum-1).getCgmc(),cellFormat); 
				sheet.addCell(label19_2);
				sheet.mergeCells(4, 18+i, 5, 18+i);
				Label label19_3= new Label(4,18+i,formlist.get(0).getKjjszjcjbcgs().get(i-xmnum-1).getWcsj(),cellFormat); 
				sheet.addCell(label19_3);
				sheet.mergeCells(6, 18+i, 7, 18+i);
				Label label19_4= new Label(6,18+i,formlist.get(0).getKjjszjcjbcgs().get(i-xmnum-1).getCgjj(),cellFormat); 
				sheet.addCell(label19_4);
				sheet.mergeCells(8, 18+i, 9, 18+i);
				Label label19_5= new Label(8,18+i,formlist.get(0).getKjjszjcjbcgs().get(i-xmnum-1).getZhqk(),cellFormat); 
				sheet.addCell(label19_5);
			}
			
			
		}
		
		
		
		sheet.mergeCells(0, 19+xmnum+cgnum, 9, 19+xmnum+cgnum);
		Label label20= new Label(0,19+xmnum+cgnum,"在研项目情况",cellFormat); 
		sheet.addCell(label20);
		
		
		for(int i=xmnum+cgnum;i<=xmnum+cgnum+zynum;i++){
			if(i==xmnum+cgnum){
		sheet.mergeCells(0, 20+i, 1, 20+i);
		Label label21_1= new Label(0,20+i,"序号",cellFormat); 
		sheet.addCell(label21_1);
		sheet.mergeCells(2, 20+i, 3, 20+i);
		Label label21_2= new Label(2,20+i,"项目名称",cellFormat); 
		sheet.addCell(label21_2);
		sheet.mergeCells(4, 20+i, 5, 20+i);
		Label label21_3= new Label(4,20+i,"预计完成时间",cellFormat); 
		sheet.addCell(label21_3);
		sheet.mergeCells(6, 20+i, 7, 20+i);
		Label label21_4= new Label(6,20+i,"项目简介",cellFormat); 
		sheet.addCell(label21_4);
		sheet.mergeCells(8, 20+i, 9, 20+i);
		Label label21_5= new Label(8,20+i,"是否转化",cellFormat); 
		sheet.addCell(label21_5);
			}
			else {
				sheet.mergeCells(0, 20+i, 1, 20+i);
				Label label21_1= new Label(0,20+i,String.valueOf(i-xmnum-cgnum),cellFormat); 
				sheet.addCell(label21_1);
				sheet.mergeCells(2, 20+i, 3, 20+i);
				Label label21_2= new Label(2,20+i,formlist.get(0).getKjjszjcjbzys().get(i-xmnum-cgnum-1).getXmmc(),cellFormat); 
				sheet.addCell(label21_2);
				sheet.mergeCells(4, 20+i, 5, 20+i);
				Label label21_3= new Label(4,20+i,formlist.get(0).getKjjszjcjbzys().get(i-xmnum-cgnum-1).getWcsj(),cellFormat); 
				sheet.addCell(label21_3);
				sheet.mergeCells(6, 20+i, 7, 20+i);
				Label label21_4= new Label(6,20+i,formlist.get(0).getKjjszjcjbzys().get(i-xmnum-cgnum-1).getXmjj(),cellFormat); 
				sheet.addCell(label21_4);
				sheet.mergeCells(8, 20+i, 9, 20+i);
				Label label21_5= new Label(8,20+i,formlist.get(0).getKjjszjcjbzys().get(i-xmnum-cgnum-1).getSfzh(),cellFormat); 
				sheet.addCell(label21_5);
				
			}
		
		}
		
		
		
		
		int addlength=xmnum+cgnum+zynum;
		
		
		sheet.mergeCells(0, 21+addlength, 1, 21+addlength);
		Label label22_1= new Label(0,21+addlength,"以下信息是否公开",cellFormat); 
		sheet.addCell(label22_1);
		sheet.mergeCells(2, 21+addlength, 9, 21+addlength);
		Label label22_2= new Label(2,21+addlength,formlist.get(0).getSfgk(),cellFormat); 
		sheet.addCell(label22_2);
		
		sheet.mergeCells(0, 22+addlength, 1, 22+addlength);
		Label label23_1= new Label(0,22+addlength,"联系电话",cellFormat); 
		sheet.addCell(label23_1);
		sheet.mergeCells(2, 22+addlength, 4, 22+addlength);
		Label label23_2= new Label(2,22+addlength,formlist.get(0).getLxdh(),cellFormat); 
		sheet.addCell(label23_2);
		sheet.mergeCells(5, 22+addlength, 6, 22+addlength);
		Label label23_3= new Label(5,22+addlength,"手机",cellFormat); 
		sheet.addCell(label23_3);
		sheet.mergeCells(7, 22+addlength, 9, 22+addlength);
		Label label23_4= new Label(7,22+addlength,formlist.get(0).getSj(),cellFormat); 
		sheet.addCell(label23_4);
		
		
		sheet.mergeCells(0, 23+addlength, 1, 23+addlength);
		Label label24_1= new Label(0,23+addlength,"联系地址",cellFormat); 
		sheet.addCell(label24_1);
		sheet.mergeCells(2, 23+addlength, 9, 23+addlength);
		Label label24_2= new Label(2,23+addlength,formlist.get(0).getLxdz(),cellFormat); 
		sheet.addCell(label24_2);
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	    //居中
//	     WritableCellFormat cellFormat=new WritableCellFormat();
//	　　　 cellFormat.setAlignment(jxl.format.Alignment.CENTER);
//	　　　 label.setCellFormat(cellFormat);
//	　　　 sheetWrite.addCell(label);
	 
		//合并单元格
//	    sheet.mergeCells(0,3,2,3);   
//        Label label= new Label(0,3,"合并了三个单元格");   
//        sheet.addCell(label);   
		
	 //边框
//		WritableSheet ws = book.createSheet( "Test Sheet 1 ",0);WritableFont wf = new WritableFont(WritableFont.TIMES,18,WritableFont.BOLD,true); 
//		WritableCellFormat wcf = new WritableCellFormat(wf); 
//		wcf.setBorder(jxl.format.Border.ALL,jxl.format.BorderLineStyle.THIN); 
//		Label labelcf = new Label(1,0, "this is a label with border test ",wcf); 
//		ws.addCell(labelcf); 
		
//		//将第一行的高度设为200 
//		sheet.setRowView(0,200); 
//		WritableSheet.setColumnView(int i,int width); 
//		作用是指定第i+1列的宽度，比如： 
//		//将第一列的宽度设为30 
//		sheet.setColumnView(0,30);
		
		
		
		// 在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
		// 以及单元格内容为test

//		System.out.println("hhs:"+formlist.get(0).getFwyy()+formlist.get(0).getId());
		
		//Label label = new Label(0, 0, formlist.get(0).getId());
		//sheet.addCell(label);
		
//		Label label = new Label(0, 0, "法人单位名称");
//		sheet.addCell(label);
//		Label label2 = new Label(1,0, "涉及的计量专业");
//		sheet.addCell(label2);
//		Label label3 = new Label(2, 0, "企事业最高计量标准器具数量");
//		sheet.addCell(label3);
//		Label label4 = new Label(3, 0, "通讯地址");
//		sheet.addCell(label4);
//		Label label5 = new Label(4, 0, "联系人");
//		sheet.addCell(label5);
//		Label label6 = new Label(5, 0, "办公电话");
//		sheet.addCell(label6);
//		Label label7 = new Label(6, 0, "手机");
//		sheet.addCell(label7);
		
		
//		for (int i = 0; i <= list.size(); i++) {
//			if (i == 0) {
//				Label label = new Label(0, i, "法人单位名称");
//				sheet.addCell(label);
//				Label label2 = new Label(1, i, "涉及的计量专业");
//				sheet.addCell(label2);
//				Label label3 = new Label(2, i, "企事业最高计量标准器具数量");
//				sheet.addCell(label3);
//				Label label4 = new Label(3, i, "通讯地址");
//				sheet.addCell(label4);
//				Label label5 = new Label(4, i, "联系人");
//				sheet.addCell(label5);
//				Label label6 = new Label(5, i, "办公电话");
//				sheet.addCell(label6);
//				Label label7 = new Label(6, i, "手机");
//				sheet.addCell(label7);
//			} else {
//
//				Label label = new Label(0, i, formlist.get(i-1).getFrmc());
//				sheet.addCell(label);
//				Label label2 = new Label(1, i, formlist.get(i-1).getJlzy());
//				sheet.addCell(label2);
//				Label label3 = new Label(2, i, formlist.get(i-1).getQjsl());
//				sheet.addCell(label3);
//				Label label4 = new Label(3, i, formlist.get(i-1).getTxdz());
//				sheet.addCell(label4);
//				Label label5 = new Label(4, i, formlist.get(i-1).getLxr());
//				sheet.addCell(label5);
//				Label label6 = new Label(5, i, formlist.get(i-1).getBgdh());
//				sheet.addCell(label6);
//				Label label7 = new Label(6, i, formlist.get(i-1).getSj());
//				sheet.addCell(label7);
//			}
//
//		}

		// /**/ /*
		// * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
		// */
		// jxl.write.Number number = new jxl.write.Number( 1 , 0 , 555.12541 );
		// sheet.addCell(number);

		// 写入数据并关闭文件
		book.write();
		book.close();

	}
	
	
	
	public List<KjjszjcjbxmForm> FindxmById(int id, List<KjjszjcjbxmForm> list){
		List<Kjjszjcjbxm> Plist=this.xmPoToVoList(list);
		Kjjszjcjb kjjszjcjb= kjjszjcjbDao.findObjectByID(id);
		
		System.out.println(kjjszjcjb.getKjjszjcjbxms());
		for(int i=0;i<Plist.size();i++){
			kjjszjcjb.getKjjszjcjbxms().add(Plist.get(i));
		}
		
		return list;
	}
//	
//	public void addJscgListWithExpertId(int id, List<KjjszjcjbcgForm> list){
//		List<Kjjszjcjbcg> Plist=this.cgPoToVoList(list);
//		Kjjszjcjb kjjszjcjb= kjjszjcjbDao.findObjectByID(id);
//		for(int i=0;i<Plist.size();i++){
//			kjjszjcjb.getKjjszjcjbcgs().add(Plist.get(i));
//		}
//		
//	}
//	public void addzyListWithExpertId(int id, List<KjjszjcjbzyForm> list){
//		List<Kjjszjcjbzy> Plist=this.zyPoToVoList(list);
//		Kjjszjcjb kjjszjcjb= kjjszjcjbDao.findObjectByID(id);
//		for(int i=0;i<Plist.size();i++){
//			kjjszjcjb.getKjjszjcjbzys().add(Plist.get(i));
//		}
//		
//		
//	}
	
}
