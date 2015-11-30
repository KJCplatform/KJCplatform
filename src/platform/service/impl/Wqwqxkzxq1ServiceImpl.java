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
import platform.dao.Wqwqxkzxq1Dao;
import platform.domain.Wqwqxkzxq1;
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
	
	public void updateWqwqxkzxq1(Wqwqxkzxq1Form wqwqxkzxq1Form){
		Wqwqxkzxq1 wqwqxkzxq1=new Wqwqxkzxq1();
		wqwqxkzxq1.setXh(wqwqxkzxq1Form.getXh());
		wqwqxkzxq1.setZymc(wqwqxkzxq1Form.getZymc());
		wqwqxkzxq1.setId(Integer.valueOf(wqwqxkzxq1Form.getId()));
		wqwqxkzxq1.setBz(wqwqxkzxq1Form.getBz());
		
		wqwqxkzxq1Dao.update(wqwqxkzxq1);
		
	}
	/*blic void updateWqwqxkzxq1Withget(Wqwqxkzxq1Form wqwqxkzxq1Form){
		Wqwqxkzxq1 wqwqxkzxq1=wqwqxkzxq1Dao.findObjectByID(Integer.valueOf(wqwqxkzxq1Form.getId()));
		wqwqxkzxq1.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq1Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq1Form wqwqxkzxq1Form){
		Wqwqxkzxq1 wqwqxkzxq1=new Wqwqxkzxq1();
		wqwqxkzxq1.setXh(wqwqxkzxq1Form.getXh());
		wqwqxkzxq1.setZymc(wqwqxkzxq1Form.getZymc());
	
		wqwqxkzxq1.setBz(wqwqxkzxq1Form.getBz());
		
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
			
			formlist.add(wqwqxkzxq1Form);
		}
		return formlist;
	}
	public void showExportObject(String items) throws Exception {
		// TODO Auto-generated method stub
		
	}
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub
		
	}
	


	
}
