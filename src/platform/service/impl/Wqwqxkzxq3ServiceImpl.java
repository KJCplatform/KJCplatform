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
import platform.dao.Wqwqxkzxq3Dao;
import platform.domain.Wqwqxkzxq3;
import platform.domain.Wqwqxkzxq3;
import platform.form.Wqwqxkzxq3Form;
import platform.service.Wqwqxkzxq3Service;
import platform.util.StringHelper;
@Transactional
@Service(Wqwqxkzxq3Service.SERVICE_NAME)
public class Wqwqxkzxq3ServiceImpl implements Wqwqxkzxq3Service{
	
	@Resource(name=Wqwqxkzxq3Dao.SERVICE_NAME)
	private Wqwqxkzxq3Dao wqwqxkzxq3Dao;
	private List<Wqwqxkzxq3Form> formListTemp = new ArrayList<Wqwqxkzxq3Form>();
	
	public List<Wqwqxkzxq3Form> findWqwqxkzxq3List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Wqwqxkzxq3> list=wqwqxkzxq3Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Wqwqxkzxq3Form> formlist=this.Wqwqxkzxq3POListToVOList(list);
		return formlist;
		
	}
	public List<Wqwqxkzxq3Form> findWqwqxkzxq3ListWithPage(int pagesize,int pageno,Wqwqxkzxq3Form wqwqxkzxq3Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(wqwqxkzxq3Form!=null&&StringUtils.isNotBlank(wqwqxkzxq3Form.getXmdm())){
			hqlWhere += " and o.xmdm like ?";
			paramsList.add("%"+wqwqxkzxq3Form.getXmdm()+"%");
		}
		if(wqwqxkzxq3Form!=null&&StringUtils.isNotBlank(wqwqxkzxq3Form.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+wqwqxkzxq3Form.getXmmc()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Wqwqxkzxq3> list=wqwqxkzxq3Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Wqwqxkzxq3Form> formlist=this.Wqwqxkzxq3POListToVOList(list);
		if(pageno == 1 ){
			formListTemp = 
					Wqwqxkzxq3POListToVOList(wqwqxkzxq3Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	
	public void updateWqwqxkzxq3(Wqwqxkzxq3Form wqwqxkzxq3Form,String username){
		Wqwqxkzxq3 wqwqxkzxq3=new Wqwqxkzxq3();
		wqwqxkzxq3.setXh(wqwqxkzxq3Form.getXh());
		wqwqxkzxq3.setXmdm(wqwqxkzxq3Form.getXmdm());
		wqwqxkzxq3.setId(Integer.valueOf(wqwqxkzxq3Form.getId()));
	
		
		wqwqxkzxq3.setXmmc(wqwqxkzxq3Form.getXmmc());
		wqwqxkzxq3.setKysc(wqwqxkzxq3Form.getKysc());
		wqwqxkzxq3.setXklx(wqwqxkzxq3Form.getXklx());

		wqwqxkzxq3.setJlnf(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR)));
		wqwqxkzxq3.setUsername(username);
		wqwqxkzxq3.setGxsj(new Date().toString());
		wqwqxkzxq3.setSubmit(0);
		wqwqxkzxq3Dao.update(wqwqxkzxq3);
		
	}
	/*blic void updateWqwqxkzxq3Withget(Wqwqxkzxq3Form wqwqxkzxq3Form){
		Wqwqxkzxq3 wqwqxkzxq3=wqwqxkzxq3Dao.findObjectByID(Integer.valueOf(wqwqxkzxq3Form.getId()));
		wqwqxkzxq3.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq3Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq3Form wqwqxkzxq3Form,String username){
		Wqwqxkzxq3 wqwqxkzxq3=new Wqwqxkzxq3();
		wqwqxkzxq3.setXh(wqwqxkzxq3Form.getXh());
		wqwqxkzxq3.setXmdm(wqwqxkzxq3Form.getXmdm());

		wqwqxkzxq3.setXmmc(wqwqxkzxq3Form.getXmmc());
		wqwqxkzxq3.setKysc(wqwqxkzxq3Form.getKysc());
		wqwqxkzxq3.setXklx(wqwqxkzxq3Form.getXklx());
		
		wqwqxkzxq3.setJlnf(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR)));
	    wqwqxkzxq3.setUsername(username);
	    wqwqxkzxq3.setGxsj(new Date().toString());
	    wqwqxkzxq3.setSubmit(0);
		wqwqxkzxq3Dao.save(wqwqxkzxq3);
	}
	private List<Wqwqxkzxq3Form> Wqwqxkzxq3POListToVOList(List<Wqwqxkzxq3> list) {
		// TODO Auto-generated method stub
		List<Wqwqxkzxq3Form> formlist=new ArrayList<Wqwqxkzxq3Form>();
		for(int i=0;i<list.size();i++){
			Wqwqxkzxq3 wqwqxkzxq3=list.get(i);
			Wqwqxkzxq3Form wqwqxkzxq3Form=new Wqwqxkzxq3Form();
			wqwqxkzxq3Form.setXh(wqwqxkzxq3.getXh());
			wqwqxkzxq3Form.setXmdm(wqwqxkzxq3.getXmdm());
			wqwqxkzxq3Form.setId(String.valueOf(wqwqxkzxq3.getId()));
		
			
			wqwqxkzxq3Form.setXmmc(wqwqxkzxq3.getXmmc());
			wqwqxkzxq3Form.setKysc(wqwqxkzxq3.getKysc());
			wqwqxkzxq3Form.setXklx(wqwqxkzxq3.getXklx());
			
			wqwqxkzxq3Form.setJlnf(wqwqxkzxq3.getJlnf());
			wqwqxkzxq3Form.setUsername(wqwqxkzxq3.getUsername());
			wqwqxkzxq3Form.setGxsj(wqwqxkzxq3.getGxsj());
			wqwqxkzxq3Form.setSubmit(String.valueOf(wqwqxkzxq3.getSubmit()));
			formlist.add(wqwqxkzxq3Form);
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
			Wqwqxkzxq3 wqwqxkzxq3 = new Wqwqxkzxq3();
			wqwqxkzxq3.setXh(sheet.getCell(0, i).getContents());
			wqwqxkzxq3.setXmdm(sheet.getCell(1, i).getContents());
			wqwqxkzxq3.setXmmc(sheet.getCell(2, i).getContents());
			wqwqxkzxq3.setKysc(sheet.getCell(3, i).getContents());
			wqwqxkzxq3.setXklx(sheet.getCell(4, i).getContents());
			wqwqxkzxq3.setJlnf(sheet.getCell(5, i).getContents());

			// xzxzgzb.setJlnf(sheet.getCell(13, i).getContents());
			wqwqxkzxq3.setUsername(formListTemp.get(0).getUsername());
			wqwqxkzxq3.setGxsj(new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date()));
			wqwqxkzxq3.setSubmit(0);
			// xzxzgzb.setUsername();
			wqwqxkzxq3Dao.save(wqwqxkzxq3);
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
		String path = "D:\\kjcoutput\\申请延续的武器装备科研生产许可专业产品表   admin " + time + ".xls";
		System.out
				.println("getDataAsHashMap(items):" + getDataAsHashMap(items));
		CreateExcel.createExcel(getDataAsHashMap(items), path);
	}


	
}
