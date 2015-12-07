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
import org.springframework.transaction.annotation.Transactional;

import excel.CreateExcel;
import platform.dao.Kjjszjcjb3Dao;
import platform.domain.Kjjszjcjb3;
import platform.form.Kjjszjcjb3Form;
import platform.service.Kjjszjcjb3Service;
@Transactional
@Service(Kjjszjcjb3Service.SERVICE_NAME)
public class Kjjszjcjb3ServiceImpl implements Kjjszjcjb3Service{
	
	@Resource(name=Kjjszjcjb3Dao.SERVICE_NAME)
	private Kjjszjcjb3Dao kjjszjcjb3Dao;
	private List<Kjjszjcjb3Form> formListTemp = new ArrayList<Kjjszjcjb3Form>();
	public List<Kjjszjcjb3Form> findKjjszjcjb3List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.sfzh", "desc");
		List<Kjjszjcjb3> list=kjjszjcjb3Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjjszjcjb3Form> formlist=this.Kjjszjcjb3POListToVOList(list);
		return formlist;
		
	}
	public List<Kjjszjcjb3Form> findKjjszjcjb3ListWithPage(int pagesize,int pageno,Kjjszjcjb3Form Kjjszjcjb3Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(Kjjszjcjb3Form!=null&&StringUtils.isNotBlank(Kjjszjcjb3Form.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+Kjjszjcjb3Form.getXm()+"%");
		}
		if(Kjjszjcjb3Form!=null&&StringUtils.isNotBlank(Kjjszjcjb3Form.getGzdw())){
			hqlWhere += " and o.gzdw like ?";
			paramsList.add("%"+Kjjszjcjb3Form.getGzdw()+"%");
		}
		orderby.put(" o.sfzh", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb3> list=kjjszjcjb3Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Kjjszjcjb3Form> formlist=this.Kjjszjcjb3POListToVOList(list);
		if(pageno == 1){
			formListTemp = 
					Kjjszjcjb3POListToVOList(kjjszjcjb3Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	
	public void updateKjjszjcjb3(Kjjszjcjb3Form kjjszjcjb3Form,String username){
		Kjjszjcjb3 kjjszjcjb3=new Kjjszjcjb3();
		kjjszjcjb3.setXm(kjjszjcjb3Form.getXm());
		kjjszjcjb3.setXb(kjjszjcjb3Form.getXb());
		kjjszjcjb3.setId(Integer.valueOf(kjjszjcjb3Form.getId()));
		kjjszjcjb3.setGzdw(kjjszjcjb3Form.getGzdw());
		kjjszjcjb3.setGzbm(kjjszjcjb3Form.getGzbm());
		kjjszjcjb3.setZw(kjjszjcjb3Form.getZw());
		kjjszjcjb3.setJszc(kjjszjcjb3Form.getJszc());
		kjjszjcjb3.setSszy(kjjszjcjb3Form.getSszy());
		kjjszjcjb3.setYjfx(kjjszjcjb3Form.getYjfx());
		kjjszjcjb3.setSj(kjjszjcjb3Form.getSj());
		kjjszjcjb3.setDh(kjjszjcjb3Form.getDh());
		kjjszjcjb3.setYx(kjjszjcjb3Form.getYx());
		kjjszjcjb3.setSfzh(kjjszjcjb3Form.getSfzh());
		kjjszjcjb3.setBz(kjjszjcjb3Form.getBz());
		
		
		kjjszjcjb3.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjjszjcjb3.setUsername(username);
		kjjszjcjb3.setGxsj(new Date().toString());
		kjjszjcjb3.setSubmit(0);
		kjjszjcjb3Dao.update(kjjszjcjb3);
		
	}
	/*blic void updateKjjszjcjb3Withget(Kjjszjcjb3Form Kjjszjcjb3Form){
		Kjjszjcjb3 Kjjszjcjb3=Kjjszjcjb3Dao.findObjectByID(Integer.valueOf(Kjjszjcjb3Form.getId()));
		Kjjszjcjb3.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		kjjszjcjb3Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Kjjszjcjb3Form kjjszjcjb3Form,String username){
		Kjjszjcjb3 kjjszjcjb3=new Kjjszjcjb3();
		kjjszjcjb3.setXm(kjjszjcjb3Form.getXm());
		kjjszjcjb3.setXb(kjjszjcjb3Form.getXb());
		kjjszjcjb3.setGzdw(kjjszjcjb3Form.getGzdw());
		kjjszjcjb3.setGzbm(kjjszjcjb3Form.getGzbm());
		kjjszjcjb3.setZw(kjjszjcjb3Form.getZw());
		kjjszjcjb3.setJszc(kjjszjcjb3Form.getJszc());
		kjjszjcjb3.setSszy(kjjszjcjb3Form.getSszy());
		kjjszjcjb3.setYjfx(kjjszjcjb3Form.getYjfx());
		kjjszjcjb3.setSj(kjjszjcjb3Form.getSj());
		kjjszjcjb3.setDh(kjjszjcjb3Form.getDh());
		kjjszjcjb3.setYx(kjjszjcjb3Form.getYx());
		kjjszjcjb3.setSfzh(kjjszjcjb3Form.getSfzh());
		kjjszjcjb3.setBz(kjjszjcjb3Form.getBz());
		
		
		kjjszjcjb3.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjjszjcjb3.setUsername(username);
		kjjszjcjb3.setGxsj(new Date().toString());
		kjjszjcjb3.setSubmit(0);
		kjjszjcjb3Dao.save(kjjszjcjb3);
	}
	private List<Kjjszjcjb3Form> Kjjszjcjb3POListToVOList(List<Kjjszjcjb3> list) {
		// TODO Auto-generated method stub
		List<Kjjszjcjb3Form> formlist=new ArrayList<Kjjszjcjb3Form>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjb3 kjjszjcjb3=list.get(i);
			Kjjszjcjb3Form kjjszjcjb3Form=new Kjjszjcjb3Form();
			kjjszjcjb3Form.setXm(kjjszjcjb3.getXm());
			kjjszjcjb3Form.setXb(kjjszjcjb3.getXb());
	//		Kjjszjcjb3Form.setFwrq(String.valueOf(Kjjszjcjb3.getFwrq()));
			kjjszjcjb3Form.setId(String.valueOf(kjjszjcjb3.getId()));
			kjjszjcjb3Form.setGzdw(kjjszjcjb3.getGzdw());
			kjjszjcjb3Form.setGzbm(kjjszjcjb3.getGzbm());
	//		Kjjszjcjb3Form.setJzrq(String.valueOf(Kjjszjcjb3.getJzrq()));
			kjjszjcjb3Form.setZw(kjjszjcjb3.getZw());
			kjjszjcjb3Form.setJszc(kjjszjcjb3.getJszc());
			kjjszjcjb3Form.setSszy(kjjszjcjb3.getSszy());
			kjjszjcjb3Form.setYjfx(kjjszjcjb3.getYjfx());
			kjjszjcjb3Form.setJszc(kjjszjcjb3.getJszc());
			kjjszjcjb3Form.setSj(kjjszjcjb3.getSj());
			kjjszjcjb3Form.setDh(kjjszjcjb3.getDh());
			kjjszjcjb3Form.setYx(kjjszjcjb3.getYx());
			kjjszjcjb3Form.setSfzh(kjjszjcjb3.getSfzh());
			kjjszjcjb3Form.setBz(kjjszjcjb3.getBz());
			
			
			kjjszjcjb3Form.setJlnf(kjjszjcjb3.getJlnf());
			kjjszjcjb3Form.setUsername(kjjszjcjb3.getUsername());
			kjjszjcjb3Form.setGxsj(kjjszjcjb3.getGxsj());
			kjjszjcjb3Form.setSubmit(String.valueOf(kjjszjcjb3.getSubmit()));
			formlist.add(kjjszjcjb3Form);
		}
		return formlist;
	}
	@Override
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub
		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath", "D:");		
		Workbook workbook = Workbook.getWorkbook(new File(path));		
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		
		
		for (int i = 1; i < rows; i++) {
			Kjjszjcjb3 kjjszjcjb3 = new Kjjszjcjb3();
			kjjszjcjb3.setXm(sheet.getCell(0, i).getContents());
			kjjszjcjb3.setXb(sheet.getCell(1, i).getContents());
			kjjszjcjb3.setGzdw(sheet.getCell(2, i).getContents());
			kjjszjcjb3.setGzbm(sheet.getCell(3, i).getContents());
			kjjszjcjb3.setZw(sheet.getCell(4, i).getContents());
			kjjszjcjb3.setJszc(sheet.getCell(5, i).getContents());
			kjjszjcjb3.setSszy(sheet.getCell(6, i).getContents());
			kjjszjcjb3.setYjfx(sheet.getCell(7, i).getContents());
			kjjszjcjb3.setSj(sheet.getCell(8, i).getContents());
			kjjszjcjb3.setDh(sheet.getCell(9, i).getContents());
			kjjszjcjb3.setYx(sheet.getCell(10, i).getContents());
			kjjszjcjb3.setSfzh(sheet.getCell(11, i).getContents());
			kjjszjcjb3.setBz(sheet.getCell(12, i).getContents());
			
			kjjszjcjb3.setJlnf(sheet.getCell(13, i).getContents());
			kjjszjcjb3.setUsername(formListTemp.get(0).getUsername());
			kjjszjcjb3.setGxsj(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			kjjszjcjb3.setSubmit(0);

			kjjszjcjb3Dao.save(kjjszjcjb3);
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
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\科技专家表  admin " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(items), path);		
	}

	
}
