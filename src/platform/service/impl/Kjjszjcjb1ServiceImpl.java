package platform.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.inject.New;

import jxl.Sheet;
import jxl.Workbook;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import excel.CreateExcel;
import platform.dao.Kjjszjcjb1Dao;
import platform.domain.Kjjszjcjb1;
import platform.form.Kjjszjcjb1Form;
import platform.service.Kjjszjcjb1Service;
@Transactional
@Service(Kjjszjcjb1Service.SERVICE_NAME)
public class Kjjszjcjb1ServiceImpl implements Kjjszjcjb1Service{
	
	@Resource(name=Kjjszjcjb1Dao.SERVICE_NAME)
	private Kjjszjcjb1Dao kjjszjcjb1Dao;
	private List<Kjjszjcjb1Form> formListTemp = new ArrayList<Kjjszjcjb1Form>();
	public List<Kjjszjcjb1Form> findKjjszjcjb1List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.sfzh", "desc");
		List<Kjjszjcjb1> list=kjjszjcjb1Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjjszjcjb1Form> formlist=this.Kjjszjcjb1POListToVOList(list);
		return formlist;
		
	}
	public List<Kjjszjcjb1Form> findKjjszjcjb1ListWithPage(int pagesize,int pageno,Kjjszjcjb1Form Kjjszjcjb1Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(Kjjszjcjb1Form!=null&&StringUtils.isNotBlank(Kjjszjcjb1Form.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+Kjjszjcjb1Form.getXm()+"%");
		}
		if(Kjjszjcjb1Form!=null&&StringUtils.isNotBlank(Kjjszjcjb1Form.getGzdw())){
			hqlWhere += " and o.gzdw like ?";
			paramsList.add("%"+Kjjszjcjb1Form.getGzdw()+"%");
		}
		orderby.put(" o.sfzh", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb1> list=kjjszjcjb1Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Kjjszjcjb1Form> formlist=this.Kjjszjcjb1POListToVOList(list);
		if(pageno == 1){
			formListTemp = 
					Kjjszjcjb1POListToVOList(kjjszjcjb1Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	
	public void updateKjjszjcjb1(Kjjszjcjb1Form kjjszjcjb1Form){
		Kjjszjcjb1 kjjszjcjb1=new Kjjszjcjb1();
		kjjszjcjb1.setXm(kjjszjcjb1Form.getXm());
		kjjszjcjb1.setXb(kjjszjcjb1Form.getXb());
		kjjszjcjb1.setId(Integer.valueOf(kjjszjcjb1Form.getId()));
		kjjszjcjb1.setGzdw(kjjszjcjb1Form.getGzdw());
		kjjszjcjb1.setGzbm(kjjszjcjb1Form.getGzbm());
		kjjszjcjb1.setZw(kjjszjcjb1Form.getZw());
		kjjszjcjb1.setJszc(kjjszjcjb1Form.getJszc());
		kjjszjcjb1.setSszy(kjjszjcjb1Form.getSszy());
		kjjszjcjb1.setYjfx(kjjszjcjb1Form.getYjfx());
		kjjszjcjb1.setSj(kjjszjcjb1Form.getSj());
		kjjszjcjb1.setDh(kjjszjcjb1Form.getDh());
		kjjszjcjb1.setYx(kjjszjcjb1Form.getYx());
		kjjszjcjb1.setSfzh(kjjszjcjb1Form.getSfzh());
		kjjszjcjb1.setBz(kjjszjcjb1Form.getBz());
		
		
		kjjszjcjb1.setJlnf(kjjszjcjb1Form.getJlnf());
		kjjszjcjb1.setUsername(kjjszjcjb1Form.getUsername());
		kjjszjcjb1.setGxsj(kjjszjcjb1Form.getGxsj());
		kjjszjcjb1.setSubmit(kjjszjcjb1Form.getSubmit());
		kjjszjcjb1Dao.update(kjjszjcjb1);
		
	}
	/*blic void updateKjjszjcjb1Withget(Kjjszjcjb1Form Kjjszjcjb1Form){
		Kjjszjcjb1 Kjjszjcjb1=Kjjszjcjb1Dao.findObjectByID(Integer.valueOf(Kjjszjcjb1Form.getId()));
		Kjjszjcjb1.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		kjjszjcjb1Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Kjjszjcjb1Form kjjszjcjb1Form){
		Kjjszjcjb1 kjjszjcjb1=new Kjjszjcjb1();
		kjjszjcjb1.setXm(kjjszjcjb1Form.getXm());
		kjjszjcjb1.setXb(kjjszjcjb1Form.getXb());
		kjjszjcjb1.setGzdw(kjjszjcjb1Form.getGzdw());
		kjjszjcjb1.setGzbm(kjjszjcjb1Form.getGzbm());
		kjjszjcjb1.setZw(kjjszjcjb1Form.getZw());
		kjjszjcjb1.setJszc(kjjszjcjb1Form.getJszc());
		kjjszjcjb1.setSszy(kjjszjcjb1Form.getSszy());
		kjjszjcjb1.setYjfx(kjjszjcjb1Form.getYjfx());
		kjjszjcjb1.setSj(kjjszjcjb1Form.getSj());
		kjjszjcjb1.setDh(kjjszjcjb1Form.getDh());
		kjjszjcjb1.setYx(kjjszjcjb1Form.getYx());
		kjjszjcjb1.setSfzh(kjjszjcjb1Form.getSfzh());
		kjjszjcjb1.setBz(kjjszjcjb1Form.getBz());
		
		
		kjjszjcjb1.setJlnf(kjjszjcjb1Form.getJlnf());
		kjjszjcjb1.setUsername(kjjszjcjb1Form.getUsername());
		kjjszjcjb1.setGxsj(kjjszjcjb1Form.getGxsj());
		kjjszjcjb1.setSubmit(kjjszjcjb1Form.getSubmit());
		kjjszjcjb1Dao.save(kjjszjcjb1);
	}
	private List<Kjjszjcjb1Form> Kjjszjcjb1POListToVOList(List<Kjjszjcjb1> list) {
		// TODO Auto-generated method stub
		List<Kjjszjcjb1Form> formlist=new ArrayList<Kjjszjcjb1Form>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjb1 kjjszjcjb1=list.get(i);
			Kjjszjcjb1Form kjjszjcjb1Form=new Kjjszjcjb1Form();
			kjjszjcjb1Form.setXm(kjjszjcjb1.getXm());
			kjjszjcjb1Form.setXb(kjjszjcjb1.getXb());
	//		Kjjszjcjb1Form.setFwrq(String.valueOf(Kjjszjcjb1.getFwrq()));
			kjjszjcjb1Form.setId(String.valueOf(kjjszjcjb1.getId()));
			kjjszjcjb1Form.setGzdw(kjjszjcjb1.getGzdw());
			kjjszjcjb1Form.setGzbm(kjjszjcjb1.getGzbm());
	//		Kjjszjcjb1Form.setJzrq(String.valueOf(Kjjszjcjb1.getJzrq()));
			kjjszjcjb1Form.setZw(kjjszjcjb1.getZw());
			kjjszjcjb1Form.setJszc(kjjszjcjb1.getJszc());
			kjjszjcjb1Form.setSszy(kjjszjcjb1.getSszy());
			kjjszjcjb1Form.setYjfx(kjjszjcjb1.getYjfx());
			kjjszjcjb1Form.setJszc(kjjszjcjb1.getJszc());
			kjjszjcjb1Form.setSj(kjjszjcjb1.getSj());
			kjjszjcjb1Form.setDh(kjjszjcjb1.getDh());
			kjjszjcjb1Form.setYx(kjjszjcjb1.getYx());
			kjjszjcjb1Form.setSfzh(kjjszjcjb1.getSfzh());
			kjjszjcjb1Form.setBz(kjjszjcjb1.getBz());
			
			
			kjjszjcjb1Form.setJlnf(kjjszjcjb1.getJlnf());
			kjjszjcjb1Form.setUsername(kjjszjcjb1.getUsername());
			kjjszjcjb1Form.setGxsj(kjjszjcjb1.getGxsj());
			kjjszjcjb1Form.setSubmit(String.valueOf(kjjszjcjb1.getSubmit()));
			formlist.add(kjjszjcjb1Form);
		}
		return formlist;
	}
	@Override
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("导入excel。。。");
		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");		
		Workbook workbook = Workbook.getWorkbook(new File(path));		
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		
		for(int i = 1 ; i < rows; i ++){
			Kjjszjcjb1 kjjszjcjb1 = new Kjjszjcjb1();
			kjjszjcjb1.setXm(sheet.getCell(0, i).getContents());
			kjjszjcjb1.setXb(sheet.getCell(1, i).getContents());
			kjjszjcjb1.setGzdw(sheet.getCell(2, i).getContents());
			kjjszjcjb1.setGzbm(sheet.getCell(3, i).getContents());
			kjjszjcjb1.setZw(sheet.getCell(4, i).getContents());
			kjjszjcjb1.setJszc(sheet.getCell(5, i).getContents());
			kjjszjcjb1.setSszy(sheet.getCell(6, i).getContents());
			kjjszjcjb1.setYjfx(sheet.getCell(7, i).getContents());
			kjjszjcjb1.setSj(sheet.getCell(8, i).getContents());
			kjjszjcjb1.setDh(sheet.getCell(9, i).getContents());
			kjjszjcjb1.setYx(sheet.getCell(10, i).getContents());
			kjjszjcjb1.setSfzh(sheet.getCell(11, i).getContents());
			kjjszjcjb1.setBz(sheet.getCell(12, i).getContents());
			kjjszjcjb1.setJlnf(sheet.getCell(13, i).getContents());
			kjjszjcjb1.setUsername("");
			kjjszjcjb1.setGxsj(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			kjjszjcjb1.setSubmit("否");
			
			kjjszjcjb1Dao.save(kjjszjcjb1);
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
		int len = formListTemp.size();
		for(int i=0; i < item.length; i ++){
			switch (item[i]) {
			case "1":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getXm());
			    }
			    lhm.put("姓名", new ArrayList<String>(li));
			    li.clear();
				break;
			case "2":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getXb());
			    }
			    lhm.put("性别", new ArrayList<String>(li));
			    li.clear();
				break;			
			case "3":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getGzdw());
			    }
			    lhm.put("工作单位", new ArrayList<String>(li));
			    li.clear();
				break;
			case "4":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getGzbm());
			    }
			    lhm.put("工作部门", new ArrayList<String>(li));
			    li.clear();
				break;
			case "5":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getZw());
			    }
			    lhm.put("职务", new ArrayList<String>(li));
			    li.clear();
				break;
			case "6":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getJszc());
			    }
			    lhm.put("技术职称", new ArrayList<String>(li));
			    li.clear();
				break;
			case "7":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getSszy());
			    }
			    lhm.put("所属专业", new ArrayList<String>(li));
			    li.clear();
				break;
			case "8":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getYjfx());
			    }
			    lhm.put("研究方向", new ArrayList<String>(li));
			    li.clear();
				break;	
			case "9":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getSj());
			    }
			    lhm.put("手机", new ArrayList<String>(li));
			    li.clear();
				break;
			case "10":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getDh());
			    }
			    lhm.put("电话", new ArrayList<String>(li));
			    li.clear();
				break;
			case "11":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getYx());
			    }
			    lhm.put("邮箱", new ArrayList<String>(li));
			    li.clear();
				break;	
			case "12":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getSfzh());
			    }
			    lhm.put("身份证号", new ArrayList<String>(li));
			    li.clear();
				break;	
			case "13":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getBz());
			    }
			    lhm.put("备注", new ArrayList<String>(li));
			    li.clear();
				break;		
			case "14":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getJlnf());
			    }
			    lhm.put("记录年份", new ArrayList<String>(li));
			    li.clear();
				break;	
			case "15":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getUsername());
			    }
			    lhm.put("操作员", new ArrayList<String>(li));
			    li.clear();
				break;	
			case "16":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getGxsj());
			    }
			    lhm.put("更新时间", new ArrayList<String>(li));
			    li.clear();
				break;	
			case "17":
			    for(int j= 0;j< len; j++){
			    	li.add(formListTemp.get(j).getSubmit());
			    }
			    lhm.put("是否提交", new ArrayList<String>(li));
			    li.clear();
				break;	
			}
			
		}
		return lhm;
	}
	
	@Override
	public void showExportObject(String items) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("导出测试。。。。。");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\质量管理专家表  admin " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(items), path);
		
	}


	
}
