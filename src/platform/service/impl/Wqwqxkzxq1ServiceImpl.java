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
import platform.dao.Wqwqxkzxq1Dao;
import platform.domain.Wqwqxkzxq1;
import platform.domain.Xzxzgzb;
import platform.form.Wqwqxkzxq1Form;
import platform.service.Wqwqxkzxq1Service;
import platform.util.StringHelper;
@Transactional
@Service(Wqwqxkzxq1Service.SERVICE_NAME)
public class Wqwqxkzxq1ServiceImpl implements Wqwqxkzxq1Service{
	
	@Resource(name=Wqwqxkzxq1Dao.SERVICE_NAME)
	private Wqwqxkzxq1Dao wqwqxkzxq1Dao;
	private List<Wqwqxkzxq1Form> formListTemp = new ArrayList<Wqwqxkzxq1Form>();
	
	public List<Wqwqxkzxq1Form> findWqwqxkzxq1List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Wqwqxkzxq1> list=wqwqxkzxq1Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Wqwqxkzxq1Form> formlist=this.Wqwqxkzxq1POListToVOList(list);
		return formlist;
		
	}
	public List<Wqwqxkzxq1Form> findWqwqxkzxq1ListWithPage(int pagesize,int pageno,Wqwqxkzxq1Form wqwqxkzxq1Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(wqwqxkzxq1Form!=null&&StringUtils.isNotBlank(wqwqxkzxq1Form.getXh())){
			hqlWhere += " and o.xh like ?";
			paramsList.add("%"+wqwqxkzxq1Form.getXh()+"%");
		}
		if(wqwqxkzxq1Form!=null&&StringUtils.isNotBlank(wqwqxkzxq1Form.getZymc())){
			hqlWhere += " and o.zymc like ?";
			paramsList.add("%"+wqwqxkzxq1Form.getZymc()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Wqwqxkzxq1> list=wqwqxkzxq1Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Wqwqxkzxq1Form> formlist=this.Wqwqxkzxq1POListToVOList(list);
		if(pageno == 1 ){
			formListTemp = 
					Wqwqxkzxq1POListToVOList(wqwqxkzxq1Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby));
		}
		return formlist;
		
	}
	
	public void updateWqwqxkzxq1(Wqwqxkzxq1Form wqwqxkzxq1Form,String username){
		Wqwqxkzxq1 wqwqxkzxq1=new Wqwqxkzxq1();
		wqwqxkzxq1.setXh(wqwqxkzxq1Form.getXh());
		wqwqxkzxq1.setZymc(wqwqxkzxq1Form.getZymc());
		wqwqxkzxq1.setId(Integer.valueOf(wqwqxkzxq1Form.getId()));
		wqwqxkzxq1.setBz(wqwqxkzxq1Form.getBz());
		wqwqxkzxq1.setJlnf(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR)));
		wqwqxkzxq1.setUsername(username);
		wqwqxkzxq1.setGxsj(new Date().toString());
		wqwqxkzxq1.setSubmit(0);
		wqwqxkzxq1Dao.update(wqwqxkzxq1);
		
	}
	/*blic void updateWqwqxkzxq1Withget(Wqwqxkzxq1Form wqwqxkzxq1Form){
		Wqwqxkzxq1 wqwqxkzxq1=wqwqxkzxq1Dao.findObjectByID(Integer.valueOf(wqwqxkzxq1Form.getId()));
		wqwqxkzxq1.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq1Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq1Form wqwqxkzxq1Form,String username){
		Wqwqxkzxq1 wqwqxkzxq1=new Wqwqxkzxq1();
		wqwqxkzxq1.setXh(wqwqxkzxq1Form.getXh());
		wqwqxkzxq1.setZymc(wqwqxkzxq1Form.getZymc());
	    wqwqxkzxq1.setBz(wqwqxkzxq1Form.getBz());
	    wqwqxkzxq1.setJlnf(String.valueOf(Calendar.getInstance()
				.get(Calendar.YEAR)));
	    wqwqxkzxq1.setUsername(username);
	    wqwqxkzxq1.setGxsj(new Date().toString());
	    wqwqxkzxq1.setSubmit(0);
		wqwqxkzxq1Dao.save(wqwqxkzxq1);
	}
	private List<Wqwqxkzxq1Form> Wqwqxkzxq1POListToVOList(List<Wqwqxkzxq1> list) {
		// TODO Auto-generated method stub
		List<Wqwqxkzxq1Form> formlist=new ArrayList<Wqwqxkzxq1Form>();
		for(int i=0;i<list.size();i++){
			Wqwqxkzxq1 wqwqxkzxq1=list.get(i);
			Wqwqxkzxq1Form wqwqxkzxq1Form=new Wqwqxkzxq1Form();
			wqwqxkzxq1Form.setXh(wqwqxkzxq1.getXh());
			wqwqxkzxq1Form.setZymc(wqwqxkzxq1.getZymc());
			wqwqxkzxq1Form.setId(String.valueOf(wqwqxkzxq1.getId()));
			wqwqxkzxq1Form.setBz(wqwqxkzxq1.getBz());
			wqwqxkzxq1Form.setJlnf(wqwqxkzxq1.getJlnf());
			wqwqxkzxq1Form.setUsername(wqwqxkzxq1.getUsername());
			wqwqxkzxq1Form.setGxsj(wqwqxkzxq1.getGxsj());
			wqwqxkzxq1Form.setSubmit(String.valueOf(wqwqxkzxq1.getSubmit()));
			formlist.add(wqwqxkzxq1Form);
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
			Wqwqxkzxq1 wqwqxkzxq1 = new Wqwqxkzxq1();
			wqwqxkzxq1.setXh(sheet.getCell(0, i).getContents());
			wqwqxkzxq1.setZymc(sheet.getCell(1, i).getContents());
			wqwqxkzxq1.setBz(sheet.getCell(2, i).getContents());
			wqwqxkzxq1.setJlnf(sheet.getCell(3, i).getContents());

			// xzxzgzb.setJlnf(sheet.getCell(13, i).getContents());
			wqwqxkzxq1.setUsername(formListTemp.get(0).getUsername());
			wqwqxkzxq1.setGxsj(new SimpleDateFormat("yyyy-MM-dd")
					.format(new Date()));
			wqwqxkzxq1.setSubmit(0);
			// xzxzgzb.setUsername();
			wqwqxkzxq1Dao.save(wqwqxkzxq1);
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
			/*case "5":
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
				break;*/
			}
		}
System.out.println("运行之后的lhm"+lhm);
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
		String path = "D:\\kjcoutput\\已获得许可的武器生产专业表   admin " + time + ".xls";
System.out
				.println("getDataAsHashMap(items):" + getDataAsHashMap(items));
		CreateExcel.createExcel(getDataAsHashMap(items), path);
	}
	


	
}
