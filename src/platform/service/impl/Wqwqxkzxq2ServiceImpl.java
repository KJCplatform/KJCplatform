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
import platform.dao.Wqwqxkzxq2Dao;
import platform.domain.Wqwqxkzxq2;
import platform.domain.Wqwqxkzxq2;
import platform.form.Wqwqxkzxq2Form;
import platform.form.Wqwqxkzxq2Form;
import platform.service.Wqwqxkzxq2Service;
import platform.util.StringHelper;
@Transactional
@Service(Wqwqxkzxq2Service.SERVICE_NAME)
public class Wqwqxkzxq2ServiceImpl implements Wqwqxkzxq2Service{
	
	@Resource(name=Wqwqxkzxq2Dao.SERVICE_NAME)
	private Wqwqxkzxq2Dao wqwqxkzxq2Dao;
	private List<Wqwqxkzxq2Form> formListTemp = new ArrayList<Wqwqxkzxq2Form>();
	
	public List<Wqwqxkzxq2Form> findWqwqxkzxq2List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Wqwqxkzxq2> list=wqwqxkzxq2Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Wqwqxkzxq2Form> formlist=this.Wqwqxkzxq2POListToVOList(list);
		return formlist;
		
	}
	public List<Wqwqxkzxq2Form> findWqwqxkzxq2ListWithPage(int pagesize,int pageno,Wqwqxkzxq2Form wqwqxkzxq2Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(wqwqxkzxq2Form!=null&&StringUtils.isNotBlank(wqwqxkzxq2Form.getXh())){
			hqlWhere += " and o.xh like ?";
			paramsList.add("%"+wqwqxkzxq2Form.getXh()+"%");
		}
		if(wqwqxkzxq2Form!=null&&StringUtils.isNotBlank(wqwqxkzxq2Form.getZymc())){
			hqlWhere += " and o.zymc like ?";
			paramsList.add("%"+wqwqxkzxq2Form.getZymc()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Wqwqxkzxq2> list=wqwqxkzxq2Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Wqwqxkzxq2Form> formlist=this.Wqwqxkzxq2POListToVOList(list);
		if(pageno == 1 ){
			formListTemp = 
					Wqwqxkzxq2POListToVOList(wqwqxkzxq2Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	
	public void updateWqwqxkzxq2(Wqwqxkzxq2Form wqwqxkzxq2Form,String username){
		Wqwqxkzxq2 wqwqxkzxq2=new Wqwqxkzxq2();
		wqwqxkzxq2.setXh(wqwqxkzxq2Form.getXh());
		wqwqxkzxq2.setZymc(wqwqxkzxq2Form.getZymc());
	
		wqwqxkzxq2.setBz(wqwqxkzxq2Form.getBz());
		wqwqxkzxq2.setId(Integer.valueOf(wqwqxkzxq2Form.getId()));
		wqwqxkzxq2.setJlnf(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR)));
		wqwqxkzxq2.setUsername(username);
		wqwqxkzxq2.setGxsj(new Date().toString());
		wqwqxkzxq2.setSubmit(0);
		wqwqxkzxq2Dao.update(wqwqxkzxq2);
		
	}
	/*blic void updateWqwqxkzxq2Withget(Wqwqxkzxq2Form wqwqxkzxq2Form){
		Wqwqxkzxq2 wqwqxkzxq2=wqwqxkzxq2Dao.findObjectByID(Integer.valueOf(wqwqxkzxq2Form.getId()));
		wqwqxkzxq2.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq2Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq2Form wqwqxkzxq2Form,String username){
		Wqwqxkzxq2 wqwqxkzxq2=new Wqwqxkzxq2();
		wqwqxkzxq2.setXh(wqwqxkzxq2Form.getXh());
		wqwqxkzxq2.setZymc(wqwqxkzxq2Form.getZymc());
	
		wqwqxkzxq2.setBz(wqwqxkzxq2Form.getBz());
		wqwqxkzxq2.setJlnf(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR)));
	    wqwqxkzxq2.setUsername(username);
	    wqwqxkzxq2.setGxsj(new Date().toString());
	    wqwqxkzxq2.setSubmit(0);
		wqwqxkzxq2Dao.save(wqwqxkzxq2);
	}
	private List<Wqwqxkzxq2Form> Wqwqxkzxq2POListToVOList(List<Wqwqxkzxq2> list) {
		// TODO Auto-generated method stub
		List<Wqwqxkzxq2Form> formlist=new ArrayList<Wqwqxkzxq2Form>();
		for(int i=0;i<list.size();i++){
			Wqwqxkzxq2 wqwqxkzxq2=list.get(i);
			Wqwqxkzxq2Form wqwqxkzxq2Form=new Wqwqxkzxq2Form();
			wqwqxkzxq2Form.setXh(wqwqxkzxq2.getXh());
			wqwqxkzxq2Form.setZymc(wqwqxkzxq2.getZymc());
			wqwqxkzxq2Form.setId(String.valueOf(wqwqxkzxq2.getId()));
			wqwqxkzxq2Form.setBz(wqwqxkzxq2.getBz());
			wqwqxkzxq2Form.setJlnf(wqwqxkzxq2.getJlnf());
			wqwqxkzxq2Form.setUsername(wqwqxkzxq2.getUsername());
			wqwqxkzxq2Form.setGxsj(wqwqxkzxq2.getGxsj());
			wqwqxkzxq2Form.setSubmit(String.valueOf(wqwqxkzxq2.getSubmit()));
			formlist.add(wqwqxkzxq2Form);
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
			Wqwqxkzxq2 wqwqxkzxq2 = new Wqwqxkzxq2();
			wqwqxkzxq2.setXh(sheet.getCell(0, i).getContents());
			wqwqxkzxq2.setZymc(sheet.getCell(1, i).getContents());
			wqwqxkzxq2.setBz(sheet.getCell(2, i).getContents());
			wqwqxkzxq2.setJlnf(sheet.getCell(3, i).getContents());

			// xzxzgzb.setJlnf(sheet.getCell(13, i).getContents());
			wqwqxkzxq2.setUsername(formListTemp.get(0).getUsername());
			wqwqxkzxq2.setGxsj(new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date()));
			wqwqxkzxq2.setSubmit(0);
			// xzxzgzb.setUsername();
			wqwqxkzxq2Dao.save(wqwqxkzxq2);
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
					li.add(formListTemp.get(j).getZymc());
				}
				lhm.put("专业名称", new ArrayList<String>(li));
				li.clear();
				break;
			case "3":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getBz());
				}
				lhm.put("备注", new ArrayList<String>(li));
				li.clear();
				break;
			case "4":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getJlnf());
				}
				lhm.put("记录年份", new ArrayList<String>(li));
				li.clear();
				break;
			case "5":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getUsername());
				}
				lhm.put("操作员", new ArrayList<String>(li));
				li.clear();
				break;
			case "6":
				for (int j = 0; j < len; j++) {
					li.add(formListTemp.get(j).getGxsj());
				}
				lhm.put("更新时间", new ArrayList<String>(li));
				li.clear();
				break;
			case "7":
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
		String path = "D:\\kjcoutput\\已获得许可的武器科研专业表   admin " + time + ".xls";
		System.out
				.println("getDataAsHashMap(items):" + getDataAsHashMap(items));
		CreateExcel.createExcel(getDataAsHashMap(items), path);
	}
	


	
}
