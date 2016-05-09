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
import platform.dao.Wqwqxkzxq4Dao;
import platform.domain.Wqwqxkzxq4;
import platform.domain.Wqwqxkzxq4;
import platform.form.Wqwqxkzxq4Form;
import platform.service.Wqwqxkzxq4Service;
import platform.util.StringHelper;
@Transactional
@Service(Wqwqxkzxq4Service.SERVICE_NAME)
public class Wqwqxkzxq4ServiceImpl implements Wqwqxkzxq4Service{
	
	@Resource(name=Wqwqxkzxq4Dao.SERVICE_NAME)
	private Wqwqxkzxq4Dao wqwqxkzxq4Dao;
	private List<Wqwqxkzxq4Form> formListTemp = new ArrayList<Wqwqxkzxq4Form>();
	
	public List<Wqwqxkzxq4Form> findWqwqxkzxq4List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Wqwqxkzxq4> list=wqwqxkzxq4Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Wqwqxkzxq4Form> formlist=this.Wqwqxkzxq4POListToVOList(list);
		return formlist;
		
	}
	public List<Wqwqxkzxq4Form> findWqwqxkzxq4ListWithPage(int pagesize,int pageno,Wqwqxkzxq4Form wqwqxkzxq4Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(wqwqxkzxq4Form!=null&&StringUtils.isNotBlank(wqwqxkzxq4Form.getXmdm())){
			hqlWhere += " and o.xmdm like ?";
			paramsList.add("%"+wqwqxkzxq4Form.getXmdm()+"%");
		}
		if(wqwqxkzxq4Form!=null&&StringUtils.isNotBlank(wqwqxkzxq4Form.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+wqwqxkzxq4Form.getXmmc()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Wqwqxkzxq4> list=wqwqxkzxq4Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Wqwqxkzxq4Form> formlist=this.Wqwqxkzxq4POListToVOList(list);
		if(pageno == 1 ){
			formListTemp = 
					Wqwqxkzxq4POListToVOList(wqwqxkzxq4Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	
	public void updateWqwqxkzxq4(Wqwqxkzxq4Form wqwqxkzxq4Form,String username){
		Wqwqxkzxq4 wqwqxkzxq4=new Wqwqxkzxq4();
		wqwqxkzxq4.setXh(wqwqxkzxq4Form.getXh());
		wqwqxkzxq4.setXmdm(wqwqxkzxq4Form.getXmdm());
		wqwqxkzxq4.setId(Integer.valueOf(wqwqxkzxq4Form.getId()));
	
		
		wqwqxkzxq4.setXmmc(wqwqxkzxq4Form.getXmmc());
		wqwqxkzxq4.setKysc(wqwqxkzxq4Form.getKysc());
		wqwqxkzxq4.setXklx(wqwqxkzxq4Form.getXklx());

		wqwqxkzxq4.setJlnf(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR)));
		wqwqxkzxq4.setUsername(username);
		wqwqxkzxq4.setGxsj(new Date().toString());
		wqwqxkzxq4.setSubmit(0);
		wqwqxkzxq4Dao.update(wqwqxkzxq4);
		
	}
	/*blic void updateWqwqxkzxq4Withget(Wqwqxkzxq4Form wqwqxkzxq4Form){
		Wqwqxkzxq4 wqwqxkzxq4=wqwqxkzxq4Dao.findObjectByID(Integer.valueOf(wqwqxkzxq4Form.getId()));
		wqwqxkzxq4.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq4Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq4Form wqwqxkzxq4Form,String username){
		Wqwqxkzxq4 wqwqxkzxq4=new Wqwqxkzxq4();
		wqwqxkzxq4.setXh(wqwqxkzxq4Form.getXh());
		wqwqxkzxq4.setXmdm(wqwqxkzxq4Form.getXmdm());

		wqwqxkzxq4.setXmmc(wqwqxkzxq4Form.getXmmc());
		wqwqxkzxq4.setKysc(wqwqxkzxq4Form.getKysc());
		wqwqxkzxq4.setXklx(wqwqxkzxq4Form.getXklx());
		
		wqwqxkzxq4.setJlnf(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR)));
	    wqwqxkzxq4.setUsername(username);
	    wqwqxkzxq4.setGxsj(new Date().toString());
	    wqwqxkzxq4.setSubmit(0);
		wqwqxkzxq4Dao.save(wqwqxkzxq4);
	}
	private List<Wqwqxkzxq4Form> Wqwqxkzxq4POListToVOList(List<Wqwqxkzxq4> list) {
		// TODO Auto-generated method stub
		List<Wqwqxkzxq4Form> formlist=new ArrayList<Wqwqxkzxq4Form>();
		for(int i=0;i<list.size();i++){
			Wqwqxkzxq4 wqwqxkzxq4=list.get(i);
			Wqwqxkzxq4Form wqwqxkzxq4Form=new Wqwqxkzxq4Form();
			wqwqxkzxq4Form.setXh(wqwqxkzxq4.getXh());
			wqwqxkzxq4Form.setXmdm(wqwqxkzxq4.getXmdm());
			wqwqxkzxq4Form.setId(String.valueOf(wqwqxkzxq4.getId()));
		
			
			wqwqxkzxq4Form.setXmmc(wqwqxkzxq4.getXmmc());
			wqwqxkzxq4Form.setKysc(wqwqxkzxq4.getKysc());
			wqwqxkzxq4Form.setXklx(wqwqxkzxq4.getXklx());
			wqwqxkzxq4Form.setJlnf(wqwqxkzxq4.getJlnf());
			wqwqxkzxq4Form.setUsername(wqwqxkzxq4.getUsername());
			wqwqxkzxq4Form.setGxsj(wqwqxkzxq4.getGxsj());
			wqwqxkzxq4Form.setSubmit(String.valueOf(wqwqxkzxq4.getSubmit()));
			formlist.add(wqwqxkzxq4Form);
		}
		return formlist;
	}

	@Override
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub
		String path = filePath.replace("\\", "\\\\").replace("C:\\\\fakepath",
				"D:\\kjcoutput");

		Workbook workbook = Workbook.getWorkbook(new File(path));
		Sheet sheet = workbook.getSheet(0);
		int rows = sheet.getRows();
		for (int i = 1; i < rows; i++) {
			Wqwqxkzxq4 wqwqxkzxq4 = new Wqwqxkzxq4();
			wqwqxkzxq4.setXh(sheet.getCell(0, i).getContents());
			wqwqxkzxq4.setXmdm(sheet.getCell(1, i).getContents());
			wqwqxkzxq4.setXmmc(sheet.getCell(2, i).getContents());
			wqwqxkzxq4.setKysc(sheet.getCell(3, i).getContents());
			wqwqxkzxq4.setXklx(sheet.getCell(4, i).getContents());
			wqwqxkzxq4.setJlnf(sheet.getCell(5, i).getContents());
			// xzxzgzb.setUsername();
			wqwqxkzxq4Dao.save(wqwqxkzxq4);
		}

		workbook.close();
	}

	/**
	 * 将要导出的数据存成LinkedHashMap
	 * 
	 * @return LinkedHashMap
	 */
	private LinkedHashMap<String, ArrayList<String>> getDataAsHashMap(
			String items) {
		System.out.println("getDataAsHashMap:" + items);
		LinkedHashMap<String, ArrayList<String>> lhm = new LinkedHashMap<String, ArrayList<String>>();
		System.out.println("LinkedHashMap:" + lhm);
		List<String> li = new ArrayList<String>();
		String[] item = items.split(" ");

		int len = formListTemp.size();
		for (int i = 0; i < item.length; i++) {
			switch (item[i]) {
			case "1":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getXh());
				}
				lhm.put("序号", new ArrayList<String>(li));
				li.clear();
				break;
			case "2":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getXmdm());
				}
				lhm.put("项目代码", new ArrayList<String>(li));
				li.clear();
				break;
			case "3":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getXmmc());
				}
				lhm.put("项目名称", new ArrayList<String>(li));
				li.clear();
				break;
			case "4":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getKysc());
				}
				lhm.put("科研生产", new ArrayList<String>(li));
				li.clear();
				break;
			case "5":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getXklx());
				}
				lhm.put("许可类型", new ArrayList<String>(li));
				li.clear();
				break;
			case "6":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getJlnf());
				}
				lhm.put("记录年份", new ArrayList<String>(li));
				li.clear();
				break;
			case "7":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getUsername());
				}
				lhm.put("操作员", new ArrayList<String>(li));
				li.clear();
				break;
			case "8":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getGxsj());
				}
				lhm.put("更新时间", new ArrayList<String>(li));
				li.clear();
				break;
			case "9":
				for (int j = 0; j < len; j++) {
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
		System.out.println("items:" + items);
		File file = new File("D:\\kjcoutput");
		// 如果文件夹不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			System.out.println("文件夹不存在");
			file.mkdir();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");// 设置日期格式
		String time = df.format(new Date());
		String path = "D:\\kjcoutput\\申请增加的武器装备科研生产许可专业产品表   admin " + time + ".xls";
		System.out
				.println("getDataAsHashMap(items):" + getDataAsHashMap(items));
		CreateExcel.createExcel(getDataAsHashMap(items), path);
	}


	
}
