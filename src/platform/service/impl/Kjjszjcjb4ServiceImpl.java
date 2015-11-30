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

import excel.CreateExcel;
import platform.dao.Kjjszjcjb4Dao;
import platform.domain.Kjjszjcjb4;
import platform.form.Kjjszjcjb4Form;
import platform.service.Kjjszjcjb4Service;

@Transactional
@Service(Kjjszjcjb4Service.SERVICE_NAME)
public class Kjjszjcjb4ServiceImpl implements Kjjszjcjb4Service{
	
	@Resource(name=Kjjszjcjb4Dao.SERVICE_NAME)
	private Kjjszjcjb4Dao kjjszjcjb4Dao;
	private List<Kjjszjcjb4Form> formListTemp = new ArrayList<Kjjszjcjb4Form>();
	public List<Kjjszjcjb4Form> findKjjszjcjb4List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.sfzh", "desc");
		List<Kjjszjcjb4> list=kjjszjcjb4Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjjszjcjb4Form> formlist=this.Kjjszjcjb4POListToVOList(list);
		return formlist;
		
	}
	public List<Kjjszjcjb4Form> findKjjszjcjb4ListWithPage(int pagesize,int pageno,Kjjszjcjb4Form Kjjszjcjb4Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(Kjjszjcjb4Form!=null&&StringUtils.isNotBlank(Kjjszjcjb4Form.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+Kjjszjcjb4Form.getXm()+"%");
		}
		if(Kjjszjcjb4Form!=null&&StringUtils.isNotBlank(Kjjszjcjb4Form.getGzdw())){
			hqlWhere += " and o.gzdw like ?";
			paramsList.add("%"+Kjjszjcjb4Form.getGzdw()+"%");
		}
		orderby.put(" o.sfzh", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb4> list=kjjszjcjb4Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Kjjszjcjb4Form> formlist=this.Kjjszjcjb4POListToVOList(list);
		if(pageno == 1){
			formListTemp =
					Kjjszjcjb4POListToVOList(kjjszjcjb4Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	
	public void updateKjjszjcjb4(Kjjszjcjb4Form kjjszjcjb4Form){
		Kjjszjcjb4 kjjszjcjb4=new Kjjszjcjb4();
		kjjszjcjb4.setXm(kjjszjcjb4Form.getXm());
		kjjszjcjb4.setXb(kjjszjcjb4Form.getXb());
		kjjszjcjb4.setId(Integer.valueOf(kjjszjcjb4Form.getId()));
		kjjszjcjb4.setGzdw(kjjszjcjb4Form.getGzdw());
		kjjszjcjb4.setGzbm(kjjszjcjb4Form.getGzbm());
		kjjszjcjb4.setZw(kjjszjcjb4Form.getZw());
		kjjszjcjb4.setJszc(kjjszjcjb4Form.getJszc());
		kjjszjcjb4.setSszy(kjjszjcjb4Form.getSszy());
		kjjszjcjb4.setYjfx(kjjszjcjb4Form.getYjfx());
		kjjszjcjb4.setSj(kjjszjcjb4Form.getSj());
		kjjszjcjb4.setDh(kjjszjcjb4Form.getDh());
		kjjszjcjb4.setYx(kjjszjcjb4Form.getYx());
		kjjszjcjb4.setSfzh(kjjszjcjb4Form.getSfzh());
		kjjszjcjb4.setBz(kjjszjcjb4Form.getBz());
		
		
		kjjszjcjb4.setJlnf(kjjszjcjb4Form.getJlnf());
		kjjszjcjb4.setUsername(kjjszjcjb4Form.getUsername());
		kjjszjcjb4.setGxsj(kjjszjcjb4Form.getGxsj());
		kjjszjcjb4.setSubmit(kjjszjcjb4Form.getSubmit());
		kjjszjcjb4Dao.update(kjjszjcjb4);
		
	}
	/*blic void updateKjjszjcjb4Withget(Kjjszjcjb4Form Kjjszjcjb4Form){
		Kjjszjcjb4 Kjjszjcjb4=Kjjszjcjb4Dao.findObjectByID(Integer.valueOf(Kjjszjcjb4Form.getId()));
		Kjjszjcjb4.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		kjjszjcjb4Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Kjjszjcjb4Form kjjszjcjb4Form){
		Kjjszjcjb4 kjjszjcjb4=new Kjjszjcjb4();
		kjjszjcjb4.setXm(kjjszjcjb4Form.getXm());
		kjjszjcjb4.setXb(kjjszjcjb4Form.getXb());
		kjjszjcjb4.setGzdw(kjjszjcjb4Form.getGzdw());
		kjjszjcjb4.setGzbm(kjjszjcjb4Form.getGzbm());
		kjjszjcjb4.setZw(kjjszjcjb4Form.getZw());
		kjjszjcjb4.setJszc(kjjszjcjb4Form.getJszc());
		kjjszjcjb4.setSszy(kjjszjcjb4Form.getSszy());
		kjjszjcjb4.setYjfx(kjjszjcjb4Form.getYjfx());
		kjjszjcjb4.setSj(kjjszjcjb4Form.getSj());
		kjjszjcjb4.setDh(kjjszjcjb4Form.getDh());
		kjjszjcjb4.setYx(kjjszjcjb4Form.getYx());
		kjjszjcjb4.setSfzh(kjjszjcjb4Form.getSfzh());
		kjjszjcjb4.setBz(kjjszjcjb4Form.getBz());
		
		
		kjjszjcjb4.setJlnf(kjjszjcjb4Form.getJlnf());
		kjjszjcjb4.setUsername(kjjszjcjb4Form.getUsername());
		kjjszjcjb4.setGxsj(kjjszjcjb4Form.getGxsj());
		kjjszjcjb4.setSubmit(kjjszjcjb4Form.getSubmit());
		kjjszjcjb4Dao.save(kjjszjcjb4);
	}
	private List<Kjjszjcjb4Form> Kjjszjcjb4POListToVOList(List<Kjjszjcjb4> list) {
		// TODO Auto-generated method stub
		List<Kjjszjcjb4Form> formlist=new ArrayList<Kjjszjcjb4Form>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjb4 kjjszjcjb4=list.get(i);
			Kjjszjcjb4Form kjjszjcjb4Form=new Kjjszjcjb4Form();
			kjjszjcjb4Form.setXm(kjjszjcjb4.getXm());
			kjjszjcjb4Form.setXb(kjjszjcjb4.getXb());
	//		Kjjszjcjb4Form.setFwrq(String.valueOf(Kjjszjcjb4.getFwrq()));
			kjjszjcjb4Form.setId(String.valueOf(kjjszjcjb4.getId()));
			kjjszjcjb4Form.setGzdw(kjjszjcjb4.getGzdw());
			kjjszjcjb4Form.setGzbm(kjjszjcjb4.getGzbm());
	//		Kjjszjcjb4Form.setJzrq(String.valueOf(Kjjszjcjb4.getJzrq()));
			kjjszjcjb4Form.setZw(kjjszjcjb4.getZw());
			kjjszjcjb4Form.setJszc(kjjszjcjb4.getJszc());
			kjjszjcjb4Form.setSszy(kjjszjcjb4.getSszy());
			kjjszjcjb4Form.setYjfx(kjjszjcjb4.getYjfx());
			kjjszjcjb4Form.setJszc(kjjszjcjb4.getJszc());
			kjjszjcjb4Form.setSj(kjjszjcjb4.getSj());
			kjjszjcjb4Form.setDh(kjjszjcjb4.getDh());
			kjjszjcjb4Form.setYx(kjjszjcjb4.getYx());
			kjjszjcjb4Form.setSfzh(kjjszjcjb4.getSfzh());
			kjjszjcjb4Form.setBz(kjjszjcjb4.getBz());
			
			
			kjjszjcjb4Form.setJlnf(kjjszjcjb4.getJlnf());
			kjjszjcjb4Form.setUsername(kjjszjcjb4.getUsername());
			kjjszjcjb4Form.setGxsj(kjjszjcjb4.getGxsj());
			kjjszjcjb4Form.setSubmit(String.valueOf(kjjszjcjb4.getSubmit()));
			formlist.add(kjjszjcjb4Form);
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
			Kjjszjcjb4 kjjszjcjb4 = new Kjjszjcjb4();
			kjjszjcjb4.setXm(sheet.getCell(0, i).getContents());
			kjjszjcjb4.setXb(sheet.getCell(1, i).getContents());
			kjjszjcjb4.setGzdw(sheet.getCell(2, i).getContents());
			kjjszjcjb4.setGzbm(sheet.getCell(3, i).getContents());
			kjjszjcjb4.setZw(sheet.getCell(4, i).getContents());
			kjjszjcjb4.setJszc(sheet.getCell(5, i).getContents());
			kjjszjcjb4.setSszy(sheet.getCell(6, i).getContents());
			kjjszjcjb4.setYjfx(sheet.getCell(7, i).getContents());
			kjjszjcjb4.setSj(sheet.getCell(8, i).getContents());
			kjjszjcjb4.setDh(sheet.getCell(9, i).getContents());
			kjjszjcjb4.setYx(sheet.getCell(10, i).getContents());
			kjjszjcjb4.setSfzh(sheet.getCell(11, i).getContents());
			kjjszjcjb4.setBz(sheet.getCell(12, i).getContents());
			kjjszjcjb4.setJlnf(sheet.getCell(13, i).getContents());
			kjjszjcjb4.setUsername("");
			kjjszjcjb4.setGxsj(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
			kjjszjcjb4.setSubmit("否");
			
			kjjszjcjb4Dao.save(kjjszjcjb4);
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
		String path = "D:\\许可专家表  admin " + time + ".xls";	
		CreateExcel.createExcel(getDataAsHashMap(items), path);		
	}

	
}

	

