package platform.service.impl;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.JpzlbgtjbDao;
import platform.dao.JpzlzkdwbDao;
import platform.dao.JpzlzkjbbDao;
import platform.domain.Jpzlbgtjb;
import platform.domain.Jpzlzkdwb;
import platform.domain.Jpzlzkjbb;
import platform.form.JpzlzkjbbForm;
import platform.service.JpzlzkjbbService;
import platform.util.StringHelper;
import excel.CreateExcel;

@Transactional
@Service(JpzlzkjbbService.SERVICE_NAME)
public class JpzlzkjbbServiceImpl implements JpzlzkjbbService{

	@Resource(name=JpzlzkjbbDao.SERVICE_NAME)
	private JpzlzkjbbDao jpzlzkjbbDao;
	@Resource(name = JpzlzkdwbDao.SERVICE_NAME)
	private JpzlzkdwbDao jpzlzkdwbDao;
	@Resource(name=JpzlbgtjbDao.SERVICE_NAME)
	private JpzlbgtjbDao jpzlbgtjbDao;
	private List<JpzlzkjbbForm> formListTemp ;
	@Override
    public List<JpzlzkjbbForm> findJpzlzkjbbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.hgl", "desc");
		List<Jpzlzkjbb> list=this.jpzlzkjbbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpzlzkjbbForm> formlist=this.JpzlzkjbbPOListToVOList(list);
		return formlist;

	}
	@Override
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
		List<Jpzlzkjbb> list=this.jpzlzkjbbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JpzlzkjbbForm> formlist=this.JpzlzkjbbPOListToVOList(list);

		if(pageno == 1){
			this.formListTemp =
					this.JpzlzkjbbPOListToVOList(this.jpzlzkjbbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;

	}

	@Override
    public void updateJpzlzkjbb(JpzlzkjbbForm jpzlzkjbbForm){
		Jpzlzkjbb old=this.jpzlzkjbbDao.findObjectByID( Integer.valueOf(jpzlzkjbbForm.getId()));
	     String oldjd=old.getJd();
	     String olddwmc= old.getDwmc();
	     String oldnf=old.getJlnf();



		    Jpzlzkjbb jpzlzkjbb=new Jpzlzkjbb();
			jpzlzkjbb.setId(Integer.valueOf(jpzlzkjbbForm.getId()));
			jpzlzkjbb.setJd(jpzlzkjbbForm.getJd());
			jpzlzkjbb.setDwmc(jpzlzkjbbForm.getDwmc());
			jpzlzkjbb.setHgl(jpzlzkjbbForm.getHgl());
			jpzlzkjbb.setCgl(jpzlzkjbbForm.getCgl());
			jpzlzkjbb.setSsl2(jpzlzkjbbForm.getSsl2());
			jpzlzkjbb.setZlhdqk(jpzlzkjbbForm.getZlhdqk());
			jpzlzkjbb.setTbr(jpzlzkjbbForm.getTbr());
			jpzlzkjbb.setZlbfzr(jpzlzkjbbForm.getZlbfzr());
			jpzlzkjbb.setShr2(jpzlzkjbbForm.getShr2());
			jpzlzkjbb.setJlnf(jpzlzkjbbForm.getJlnf());
			if(jpzlzkjbbForm.getBcrq()!=null&&!jpzlzkjbbForm.getBcrq().equals(""))
			jpzlzkjbb.setBcrq(StringHelper.stringConvertDate(jpzlzkjbbForm.getBcrq()));
			jpzlzkjbb.setGxsj(StringHelper.dateFormat(new Date()));
		    this.jpzlzkjbbDao.update(jpzlzkjbb);


		    String hqlWhere = "";
			Object [] params = null;
			List<String> paramsList=new ArrayList<String>();
				hqlWhere += " and o.dwmc = ?";
				paramsList.add(olddwmc);
				hqlWhere += " and o.year = ?";
				paramsList.add(oldnf);
			params = paramsList.toArray();
		    Jpzlbgtjb oldJpzlbgtjb=this.jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere, params, null).get(0);
		    switch(oldjd){
		    case "一": oldJpzlbgtjb.setFirst(null);break;
		    case "二": oldJpzlbgtjb.setSecond(null);break;
		    case "三": oldJpzlbgtjb.setThird(null);break;
		    case "四": oldJpzlbgtjb.setFourth(null);break;
		    }
		    oldJpzlbgtjb.setSubmit(0);
		    //oldJpzlbgtjb.setUsername();
		    oldJpzlbgtjb.setGxsj(new Date().toString());
		    this.jpzlbgtjbDao.save(oldJpzlbgtjb);
		    String hqlWhere1 = "";
			Object [] params1 = null;
			List<String> paramsList1=new ArrayList<String>();
				hqlWhere1 += " and o.dwmc = ?";
				paramsList1.add(jpzlzkjbbForm.getDwmc());
				hqlWhere1 += " and o.year = ?";
				paramsList1.add(jpzlzkjbbForm.getJlnf());
				params1 = paramsList1.toArray();
			    Jpzlbgtjb newJpzlbgtjb=(this.jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere1, params1, null).size()==0)?(new Jpzlbgtjb()): (this.jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere1, params1, null).get(0));
			    newJpzlbgtjb.setDwmc(jpzlzkjbbForm.getDwmc());
			    newJpzlbgtjb.setYear(jpzlzkjbbForm.getJlnf());
			    switch(jpzlzkjbbForm.getJd()){
			    case "一": newJpzlbgtjb.setFirst("是");break;
			    case "二": newJpzlbgtjb.setSecond("是");break;
			    case "三": newJpzlbgtjb.setThird("是");break;
			    case "四": newJpzlbgtjb.setFourth("是");break;
			    }
			    newJpzlbgtjb.setSubmit(0);
			    newJpzlbgtjb.setGxsj(StringHelper.dateFormat(new Date()));
			    this.jpzlbgtjbDao.save(newJpzlbgtjb);

			    ////向单位表中插入新的单位信息
			    if( !olddwmc.equals(jpzlzkjbbForm.getDwmc())){
				    String hqlString = " and o.dwmc = '" + jpzlzkjbbForm.getDwmc()+"'";
				    if( this.jpzlzkdwbDao.findCollectionByConditionNoPage(hqlString, null, null).isEmpty() ){
				    	Jpzlzkdwb jpzlzkdwb = new Jpzlzkdwb();
				    	jpzlzkdwb.setDwmc(jpzlzkjbbForm.getDwmc());
				    	jpzlzkdwb.setJinyong(false);
				    	jpzlzkdwb.setGxsj(StringHelper.dateFormat(new Date()));
				    	jpzlzkdwb.setSubmit(0);
				    	this.jpzlzkdwbDao.save(jpzlzkdwb);
				    }
			    }
	}
	@Override
    public void deleteObject(String id){
		Jpzlzkjbb old=this.jpzlzkjbbDao.findObjectByID(Integer.valueOf(id));
	     String oldjd=old.getJd();
	     String olddwmc= old.getDwmc();
	     String oldnf=old.getJlnf();
		this.jpzlzkjbbDao.deleteObjectByIDs(Integer.valueOf(id));

		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
			hqlWhere += " and o.dwmc = ?";
			paramsList.add(olddwmc);
			hqlWhere += " and o.year = ?";
			paramsList.add(oldnf);
		params = paramsList.toArray();
	    Jpzlbgtjb oldJpzlbgtjb=this.jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere, params, null).get(0);
	    switch(oldjd){
	    case "一": oldJpzlbgtjb.setFirst(null);break;
	    case "二": oldJpzlbgtjb.setSecond(null);break;
	    case "三": oldJpzlbgtjb.setThird(null);break;
	    case "四": oldJpzlbgtjb.setFourth(null);break;
	    }
	    oldJpzlbgtjb.setSubmit(0);
	    //oldJpzlbgtjb.setUsername();
	    oldJpzlbgtjb.setGxsj(StringHelper.dateFormat(new Date()));
	    this.jpzlbgtjbDao.save(oldJpzlbgtjb);
	}
	@Override
    public void saveObject(JpzlzkjbbForm jpzlzkjbbForm){
		Jpzlzkjbb jpzlzkjbb=new Jpzlzkjbb();
		jpzlzkjbb.setJd(jpzlzkjbbForm.getJd());
		jpzlzkjbb.setDwmc(jpzlzkjbbForm.getDwmc());
		jpzlzkjbb.setHgl(jpzlzkjbbForm.getHgl());
		jpzlzkjbb.setCgl(jpzlzkjbbForm.getCgl());
		jpzlzkjbb.setSsl2(jpzlzkjbbForm.getSsl2());
		jpzlzkjbb.setZlhdqk(jpzlzkjbbForm.getZlhdqk());
		jpzlzkjbb.setTbr(jpzlzkjbbForm.getTbr());
		jpzlzkjbb.setZlbfzr(jpzlzkjbbForm.getZlbfzr());
		jpzlzkjbb.setShr2(jpzlzkjbbForm.getShr2());
		jpzlzkjbb.setJlnf(jpzlzkjbbForm.getJlnf());
		if(jpzlzkjbbForm.getBcrq()!=null&&!jpzlzkjbbForm.getBcrq().equals(""))
			jpzlzkjbb.setBcrq(StringHelper.stringConvertDate(jpzlzkjbbForm.getBcrq()));
		jpzlzkjbb.setGxsj(StringHelper.dateFormat(new Date()));

		try{
		this.jpzlzkjbbDao.save(jpzlzkjbb);
		}catch(Exception e){System.out.println(e);}

		String hqlWhere1 = "";
		Object [] params1 = null;
		List<String> paramsList1=new ArrayList<String>();
			hqlWhere1 += " and o.dwmc = ?";
			paramsList1.add(jpzlzkjbbForm.getDwmc());
			hqlWhere1 += " and o.year = ?";
			paramsList1.add(jpzlzkjbbForm.getJlnf());
			params1 = paramsList1.toArray();
		    Jpzlbgtjb newJpzlbgtjb=(this.jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere1, params1, null).size()==0)?(new Jpzlbgtjb()): (this.jpzlbgtjbDao.findCollectionByConditionNoPage(hqlWhere1, params1, null).get(0));
		    newJpzlbgtjb.setDwmc(jpzlzkjbbForm.getDwmc());
		    newJpzlbgtjb.setYear(jpzlzkjbbForm.getJlnf());
		    switch(jpzlzkjbbForm.getJd()){
		    case "一": newJpzlbgtjb.setFirst("是");break;
		    case "二": newJpzlbgtjb.setSecond("是");break;
		    case "三": newJpzlbgtjb.setThird("是");break;
		    case "四": newJpzlbgtjb.setFourth("是");break;
		    }
		    newJpzlbgtjb.setSubmit(0);
		    newJpzlbgtjb.setGxsj(StringHelper.dateFormat(new Date()));
		    try{
		    	this.jpzlbgtjbDao.save(newJpzlbgtjb);
		    }catch(Exception e){
		    	System.out.println(e.getMessage());
		    	e.printStackTrace();
		    }

		    //向单位表中插入新的单位信息
		    String hqlString = " and o.dwmc = '" + jpzlzkjbbForm.getDwmc()+"'";
		    if( this.jpzlzkdwbDao.findCollectionByConditionNoPage(hqlString, null, null).isEmpty() ){
		    	Jpzlzkdwb jpzlzkdwb = new Jpzlzkdwb();
		    	jpzlzkdwb.setDwmc(jpzlzkjbbForm.getDwmc());
		    	jpzlzkdwb.setJinyong(false);
		    	jpzlzkdwb.setGxsj(StringHelper.dateFormat(new Date()));
		    	jpzlzkdwb.setSubmit(0);
		    	this.jpzlzkdwbDao.save(jpzlzkdwb);
		    }
	}
	private List<JpzlzkjbbForm> JpzlzkjbbPOListToVOList(List<Jpzlzkjbb> list) {
		// TODO Auto-generated method stub
		List<JpzlzkjbbForm> formlist=new ArrayList<JpzlzkjbbForm>();
		for(int i=0;i<list.size();i++){
			Jpzlzkjbb jpzlzkjbb=list.get(i);
			JpzlzkjbbForm jpzlzkjbbForm=new JpzlzkjbbForm();
			jpzlzkjbbForm.setId(String.valueOf(jpzlzkjbb.getId()));
			jpzlzkjbbForm.setJd(jpzlzkjbb.getJd());
			jpzlzkjbbForm.setDwmc(jpzlzkjbb.getDwmc());
			jpzlzkjbbForm.setHgl(jpzlzkjbb.getHgl());
			jpzlzkjbbForm.setCgl(jpzlzkjbb.getCgl());
			jpzlzkjbbForm.setSsl2(jpzlzkjbb.getSsl2());
			jpzlzkjbbForm.setZlhdqk(jpzlzkjbb.getZlhdqk());
			jpzlzkjbbForm.setTbr(jpzlzkjbb.getTbr());
			jpzlzkjbbForm.setZlbfzr(jpzlzkjbb.getZlbfzr());
			jpzlzkjbbForm.setShr2(jpzlzkjbb.getShr2());
			jpzlzkjbbForm.setBcrq(String.valueOf(jpzlzkjbb.getBcrq()));
			jpzlzkjbbForm.setJlnf(jpzlzkjbb.getJlnf());
			formlist.add(jpzlzkjbbForm);
		}
		return formlist;
	}

	@Override
	public void showImportObject(String filePath) throws Exception {
		Workbook workbook = Workbook.getWorkbook(new File(filePath));
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		for(int i = 1; i < rows ; i ++){
			JpzlzkjbbForm jpzlzkjbb = new JpzlzkjbbForm();
			jpzlzkjbb.setJd(sheet.getCell(1, i).getContents());
			jpzlzkjbb.setDwmc(sheet.getCell(2, i).getContents());
			jpzlzkjbb.setHgl(sheet.getCell(3, i).getContents());
			jpzlzkjbb.setCgl(sheet.getCell(4, i).getContents());
			jpzlzkjbb.setSsl2(sheet.getCell(5, i).getContents());
			jpzlzkjbb.setZlhdqk(sheet.getCell(6, i).getContents());
			jpzlzkjbb.setTbr(sheet.getCell(7, i).getContents());
			jpzlzkjbb.setZlbfzr(sheet.getCell(8, i).getContents());
			jpzlzkjbb.setShr2(sheet.getCell(9, i).getContents());
			jpzlzkjbb.setBcrq(sheet.getCell(10, i).getContents());
			jpzlzkjbb.setJlnf(sheet.getCell(0, i).getContents());

			saveObject(jpzlzkjbb);
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

		int len =this.formListTemp.size();
		for(int i = 0; i < item.length; i ++){
			switch (item[i]) {
			case "1":
			    for(int j= 0;j< len; j++){
			    	li.add(this.formListTemp.get(j).getJd());
			    }
			    lhm.put("季度", new ArrayList<String>(li));
			    li.clear();
				break;
			case "2":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getDwmc());
			    }
			    lhm.put("单位名称", new ArrayList<String>(li));
			    li.clear();
				break;
			case "3":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getHgl());
			    }
			    lhm.put("军品一次交验（检）合格率", new ArrayList<String>(li));
			    li.clear();
				break;
			case "4":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getCgl());
			    }
			    lhm.put("重大试验成功率", new ArrayList<String>(li));
			    li.clear();
				break;
			case "5":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getSsl2());
			    }
			    lhm.put("军品质量损失率", new ArrayList<String>(li));
			    li.clear();
			    break;
			case "6":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getZlhdqk());
			    }
			    lhm.put("单位重大质量活动情况", new ArrayList<String>(li));
			    li.clear();
				break;
			case "7":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getTbr());
			    }
			    lhm.put("填表人", new ArrayList<String>(li));
			    li.clear();
				break;
			case "8":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getZlbfzr());
			    }
			    lhm.put("质量部门负责人", new ArrayList<String>(li));
			    li.clear();
				break;
			case "9":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getShr2());
			    }
			    lhm.put("审核人", new ArrayList<String>(li));
			    li.clear();
			    break;
			case "10":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getBcrq());
			    }
			    lhm.put("报出日期", new ArrayList<String>(li));
			    li.clear();
				break;
			case "11":
			    for(int j= 0;j< len;j++){
			    	li.add(this.formListTemp.get(j).getJlnf());
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
		CreateExcel.createExcel(this.getDataAsHashMap(items), path);
	}

}
