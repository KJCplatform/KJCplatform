package platform.service.impl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import excel.CreateExcel;
import platform.dao.JpzlbgtjbDao;
import platform.dao.JpzlzkjbbDao;
import platform.domain.Jpzlbgtjb;
import platform.domain.Jpzlzkjbb;
import platform.form.JpzlzkjbbForm;
import platform.service.JpzlzkjbbService;
import platform.util.StringHelper;


@Service(JpzlzkjbbService.SERVICE_NAME)
public class JpzlzkjbbServiceImpl implements JpzlzkjbbService{
	
	@Resource(name=JpzlzkjbbDao.SERVICE_NAME)
	private JpzlzkjbbDao jpzlzkjbbDao;
	
	@Resource(name=JpzlbgtjbDao.SERVICE_NAME)
	private JpzlbgtjbDao jpzlbgtjbDao;
	private List<JpzlzkjbbForm> formListTemp ;
	public List<JpzlzkjbbForm> findJpzlzkjbbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.hgl", "desc");
		List<Jpzlzkjbb> list=jpzlzkjbbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpzlzkjbbForm> formlist=this.JpzlzkjbbPOListToVOList(list);
		return formlist;
		
	}
	public List<JpzlzkjbbForm> findJpzlzkjbbListWithPage(int pagesize,int pageno,JpzlzkjbbForm jpzlzkjbbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpzlzkjbbForm!=null&&StringUtils.isNotBlank(jpzlzkjbbForm.getJd())){
			hqlWhere += " and o.jd like ?";
			paramsList.add("%"+jpzlzkjbbForm.getJd()+"%");
		}
		if(jpzlzkjbbForm!=null&&StringUtils.isNotBlank(jpzlzkjbbForm.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+jpzlzkjbbForm.getDwmc()+"%");
		}
		orderby.put(" o.hgl", "desc");
		params = paramsList.toArray();
		List<Jpzlzkjbb> list=jpzlzkjbbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JpzlzkjbbForm> formlist=this.JpzlzkjbbPOListToVOList(list);
		
		if(pageno == 1){
			formListTemp = 
					JpzlzkjbbPOListToVOList(jpzlzkjbbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	/*private int id;
	  private String cpmc;
	  private Date fsrq;
	  private String yyqk;
	  private String bz;
	  private String tbr;
	  private String zlbmfzr;
	  private Date bcrq;*/
	public void updateJpzlzkjbb(JpzlzkjbbForm jpzlzkjbbForm){
		Jpzlzkjbb old=jpzlzkjbbDao.findObjectByID( Integer.valueOf(jpzlzkjbbForm.getId()));
	     String oldjd=old.getJd();
	     String olddwmc= old.getDwmc();
	     String oldnf=old.getJlnf();   	    
		
		
		
		    Jpzlzkjbb jpzlzkjbb=new Jpzlzkjbb();
        //  jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
			jpzlzkjbb.setId(Integer.valueOf(jpzlzkjbbForm.getId()));
			jpzlzkjbb.setJd(jpzlzkjbbForm.getJd());
			jpzlzkjbb.setDwmc(jpzlzkjbbForm.getDwmc());
			jpzlzkjbb.setHgl(jpzlzkjbbForm.getHgl());
			jpzlzkjbb.setCgl(jpzlzkjbbForm.getCgl());
			jpzlzkjbb.setSsl(jpzlzkjbbForm.getSsl());
			jpzlzkjbb.setZlhdqk(jpzlzkjbbForm.getZlhdqk());
			jpzlzkjbb.setTbr(jpzlzkjbbForm.getTbr());
			jpzlzkjbb.setZlbfzr(jpzlzkjbbForm.getZlbfzr());
			jpzlzkjbb.sets2hr(jpzlzkjbbForm.getS2hr());
			jpzlzkjbb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			//jpzlzkjbb.sets2hr("123");
			if(jpzlzkjbbForm.getBcrq()!=null&&!jpzlzkjbbForm.getBcrq().equals(""))
			jpzlzkjbb.setBcrq(StringHelper.stringConvertDate2(jpzlzkjbbForm.getBcrq()));
		    jpzlzkjbbDao.update(jpzlzkjbb);
		    
		    
		    String hqlWhere = "";
			Object [] params = null;
			List<String> paramsList=new ArrayList<String>();
				hqlWhere += " and o.dwmc = ?";
				paramsList.add(olddwmc);
				hqlWhere += " and o.year = ?";
				paramsList.add(oldnf);
			params = paramsList.toArray();
		    Jpzlbgtjb oldJpzlbgtjb=jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere, params, null).get(0);
		    switch(oldjd){
		    case "一": oldJpzlbgtjb.setFirst(null);break;
		    case "二": oldJpzlbgtjb.setSecond(null);break;
		    case "三": oldJpzlbgtjb.setThird(null);break;
		    case "四": oldJpzlbgtjb.setFourth(null);break;
		    }
		    oldJpzlbgtjb.setSubmit(false);
		    //oldJpzlbgtjb.setUsername();
		    oldJpzlbgtjb.setGxsj(new Date().toString());
		    jpzlbgtjbDao.save(oldJpzlbgtjb);
		    String hqlWhere1 = "";
			Object [] params1 = null;
			List<String> paramsList1=new ArrayList<String>();
				hqlWhere1 += " and o.dwmc = ?";
				paramsList1.add(jpzlzkjbbForm.getDwmc());
				hqlWhere1 += " and o.year = ?";
				paramsList1.add(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
				params1 = paramsList1.toArray();
			    Jpzlbgtjb newJpzlbgtjb=(jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere1, params1, null).size()==0)?(new Jpzlbgtjb()): (jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere1, params1, null).get(0));
			    newJpzlbgtjb.setDwmc(jpzlzkjbbForm.getDwmc());
			    newJpzlbgtjb.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			    switch(jpzlzkjbbForm.getJd()){
			    case "一": newJpzlbgtjb.setFirst("是");break;
			    case "二": newJpzlbgtjb.setSecond("是");break;
			    case "三·": newJpzlbgtjb.setThird("是");break;
			    case "四": newJpzlbgtjb.setFourth("是");break;
			    }
			    newJpzlbgtjb.setSubmit(false);
			    //oldJpzlbgtjb.setUsername();
			    newJpzlbgtjb.setGxsj(new Date().toString());
			    jpzlbgtjbDao.save(newJpzlbgtjb);
	}
	public void deleteObject(String id){
		System.out.println(Integer.valueOf(id));
		Jpzlzkjbb old=jpzlzkjbbDao.findObjectByID(Integer.valueOf(id));
	     String oldjd=old.getJd();
	     String olddwmc= old.getDwmc();
	     String oldnf=old.getJlnf();  
		jpzlzkjbbDao.deleteObjectByIDs(Integer.valueOf(id));
		
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
			hqlWhere += " and o.dwmc = ?";
			paramsList.add(olddwmc);
			hqlWhere += " and o.year = ?";
			paramsList.add(oldnf);
		params = paramsList.toArray();
	    Jpzlbgtjb oldJpzlbgtjb=jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere, params, null).get(0);
	    switch(oldjd){
	    case "一": oldJpzlbgtjb.setFirst(null);break;
	    case "二": oldJpzlbgtjb.setSecond(null);break;
	    case "三": oldJpzlbgtjb.setThird(null);break;
	    case "四": oldJpzlbgtjb.setFourth(null);break;
	    }
	    oldJpzlbgtjb.setSubmit(false);
	    //oldJpzlbgtjb.setUsername();
	    oldJpzlbgtjb.setGxsj(new Date().toString());
	    jpzlbgtjbDao.save(oldJpzlbgtjb);
	}
	public void saveObject(JpzlzkjbbForm jpzlzkjbbForm){
		Jpzlzkjbb jpzlzkjbb=new Jpzlzkjbb();
        //  jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		jpzlzkjbb.setJd(jpzlzkjbbForm.getJd());
		jpzlzkjbb.setDwmc(jpzlzkjbbForm.getDwmc());
		jpzlzkjbb.setHgl(jpzlzkjbbForm.getHgl());
		jpzlzkjbb.setCgl(jpzlzkjbbForm.getCgl());
		jpzlzkjbb.setSsl(jpzlzkjbbForm.getSsl());
		jpzlzkjbb.setZlhdqk(jpzlzkjbbForm.getZlhdqk());
		jpzlzkjbb.setTbr(jpzlzkjbbForm.getTbr());
		jpzlzkjbb.setZlbfzr(jpzlzkjbbForm.getZlbfzr());
		jpzlzkjbb.sets2hr(jpzlzkjbbForm.getS2hr());
		jpzlzkjbb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		//jpzlzkjbb.sets2hr("123");
		if(jpzlzkjbbForm.getBcrq()!=null&&!jpzlzkjbbForm.getBcrq().equals(""))
		jpzlzkjbb.setBcrq(StringHelper.stringConvertDate2(jpzlzkjbbForm.getBcrq()));
		
		try{
		jpzlzkjbbDao.save(jpzlzkjbb);
		}catch(Exception e){System.out.println(e);}
		
		String hqlWhere1 = "";
		Object [] params1 = null;
		List<String> paramsList1=new ArrayList<String>();
			hqlWhere1 += " and o.dwmc = ?";
			paramsList1.add(jpzlzkjbbForm.getDwmc());
			hqlWhere1 += " and o.year = ?";
			paramsList1.add(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
			params1 = paramsList1.toArray();
		    Jpzlbgtjb newJpzlbgtjb=(jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere1, params1, null).size()==0)?(new Jpzlbgtjb()): (jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere1, params1, null).get(0));
		    newJpzlbgtjb.setDwmc(jpzlzkjbbForm.getDwmc());
		    newJpzlbgtjb.setYear(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		    switch(jpzlzkjbbForm.getJd()){
		    case "一": newJpzlbgtjb.setFirst("是");break;
		    case "二": newJpzlbgtjb.setSecond("是");break;
		    case "三": newJpzlbgtjb.setThird("是");break;
		    case "四": newJpzlbgtjb.setFourth("是");break;
		    }
		    newJpzlbgtjb.setSubmit(false);
		    //oldJpzlbgtjb.setUsername();
		    newJpzlbgtjb.setGxsj(new Date().toString());
		    jpzlbgtjbDao.save(newJpzlbgtjb);
	}
	private List<JpzlzkjbbForm> JpzlzkjbbPOListToVOList(List<Jpzlzkjbb> list) {
		// TODO Auto-generated method stub
		List<JpzlzkjbbForm> formlist=new ArrayList<JpzlzkjbbForm>();
		for(int i=0;i<list.size();i++){
			Jpzlzkjbb jpzlzkjbb=list.get(i);
			JpzlzkjbbForm jpzlzkjbbForm=new JpzlzkjbbForm();
            //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			jpzlzkjbbForm.setId(String.valueOf(jpzlzkjbb.getId()));
			jpzlzkjbbForm.setJd(jpzlzkjbb.getJd());
			jpzlzkjbbForm.setDwmc(jpzlzkjbb.getDwmc());
			jpzlzkjbbForm.setHgl(jpzlzkjbb.getHgl());
			jpzlzkjbbForm.setCgl(jpzlzkjbb.getCgl());
			jpzlzkjbbForm.setSsl(jpzlzkjbb.getSsl());
			jpzlzkjbbForm.setZlhdqk(jpzlzkjbb.getZlhdqk());
			jpzlzkjbbForm.setTbr(jpzlzkjbb.getTbr());
			jpzlzkjbbForm.setZlbfzr(jpzlzkjbb.getZlbfzr());
			jpzlzkjbbForm.setS2hr(jpzlzkjbb.gets2hr());
			//jpzlzkjbbForm.sets2hr("123");
			jpzlzkjbbForm.setBcrq(String.valueOf(jpzlzkjbb.getBcrq()));
			jpzlzkjbbForm.setJlnf(jpzlzkjbb.getJlnf());
			formlist.add(jpzlzkjbbForm);
		}
		return formlist;
	}

	@Override
	public void showImportObject(String filePath) throws Exception {
		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");
		Workbook workbook = Workbook.getWorkbook(new File(path));		
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		for(int i = 1; i < rows ; i ++){
			Jpzlzkjbb jpzlzkjbb = new Jpzlzkjbb();
			jpzlzkjbb.setJd(sheet.getCell(0, i).getContents());
			jpzlzkjbb.setDwmc(sheet.getCell(1, i).getContents());
			jpzlzkjbb.setHgl(sheet.getCell(2, i).getContents());
			jpzlzkjbb.setCgl(sheet.getCell(3, i).getContents());
			jpzlzkjbb.setSsl(sheet.getCell(4, i).getContents());
			jpzlzkjbb.setZlhdqk(sheet.getCell(5, i).getContents());
			jpzlzkjbb.setTbr(sheet.getCell(6, i).getContents());
			jpzlzkjbb.setZlbfzr(sheet.getCell(7, i).getContents());
			jpzlzkjbb.sets2hr(sheet.getCell(8, i).getContents());
			jpzlzkjbb.setBcrq(StringHelper.stringConvertDate(sheet.getCell(9, i).getContents()));
			jpzlzkjbb.setJlnf(sheet.getCell(10, i).getContents());

			
			jpzlzkjbbDao.save(jpzlzkjbb);
		}
		
		workbook.close();
	}
		
	/**
	 * 将要导出的数据存成LinkedHashMap
	 *
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(String items){
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String ,ArrayList<String>>();
		List<String> li = new ArrayList<String>();
		String[] item = items.split(" ");

		int len =formListTemp.size();
		for(int i = 0; i < item.length; i ++){
			switch (item[i]) {
			case "1":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getJd());
			    }
			    lhm.put("季度", new ArrayList<String>(li));
			    li.clear();
				break;
			case "2":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getDwmc());
			    }
			    lhm.put("单位名称", new ArrayList<String>(li));
			    li.clear();
				break;
			case "3":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getHgl());
			    }
			    lhm.put("军品一次交验（检）合格率", new ArrayList<String>(li));
			    li.clear();
				break;
			case "4":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getCgl());
			    }
			    lhm.put("重大试验成功率", new ArrayList<String>(li));
			    li.clear();
				break;
			case "5":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getSsl());
			    }
			    lhm.put("军品质量损失率", new ArrayList<String>(li));
			    li.clear();
			    break;
			case "6":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getZlhdqk());
			    }
			    lhm.put("单位重大质量活动情况", new ArrayList<String>(li));
			    li.clear();
				break;
			case "7":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getTbr());
			    }
			    lhm.put("填表人", new ArrayList<String>(li));
			    li.clear();
				break;
			case "8":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getZlbfzr());
			    }
			    lhm.put("质量部门负责人", new ArrayList<String>(li));
			    li.clear();
				break;
			case "9":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getS2hr());
			    }
			    lhm.put("审核人", new ArrayList<String>(li));
			    li.clear();
			    break;
			case "10":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getBcrq());
			    }
			    lhm.put("报出日期", new ArrayList<String>(li));
			    li.clear();
				break;
			case "11":
			    for(int j= 0;j< len;j++){
			    	li.add(formListTemp.get(j).getJlnf());
			    }
			    lhm.put("记录日期(年份)", new ArrayList<String>(li));
			    li.clear();
				break;

			}
		}	
		return lhm;
	}
	
	
	@Override
	public void showExportObject(String items) throws Exception {
		File file =new File("D:\\kjcoutput");    
		//如果文件夹不存在则创建    
		if  (!file .exists()  && !file .isDirectory())      
		{       
		    System.out.println("文件夹不存在");  
		    file .mkdir();    
		} 
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\kjcoutput\\湖北省国防科技工业军工产品质量状况季报表    admin "+ time+".xls";
		CreateExcel.createExcel(getDataAsHashMap(items), path);			
	}

}
