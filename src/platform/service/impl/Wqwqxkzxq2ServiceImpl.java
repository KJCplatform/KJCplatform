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
import platform.dao.Wqwqxkzxq2Dao;
import platform.domain.Wqwqxkzxq1;
import platform.domain.Wqwqxkzxq2;
import platform.form.Wqwqxkzxq1Form;
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
	
	public void updateWqwqxkzxq2(Wqwqxkzxq2Form wqwqxkzxq2Form){
		Wqwqxkzxq2 wqwqxkzxq2=new Wqwqxkzxq2();
		wqwqxkzxq2.setXh(wqwqxkzxq2Form.getXh());
		wqwqxkzxq2.setZymc(wqwqxkzxq2Form.getZymc());
	
		wqwqxkzxq2.setBz(wqwqxkzxq2Form.getBz());
		wqwqxkzxq2.setId(Integer.valueOf(wqwqxkzxq2Form.getId()));
		
		wqwqxkzxq2Dao.update(wqwqxkzxq2);
		
	}
	/*blic void updateWqwqxkzxq2Withget(Wqwqxkzxq2Form wqwqxkzxq2Form){
		Wqwqxkzxq2 wqwqxkzxq2=wqwqxkzxq2Dao.findObjectByID(Integer.valueOf(wqwqxkzxq2Form.getId()));
		wqwqxkzxq2.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq2Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq2Form wqwqxkzxq2Form){
		Wqwqxkzxq2 wqwqxkzxq2=new Wqwqxkzxq2();
		wqwqxkzxq2.setXh(wqwqxkzxq2Form.getXh());
		wqwqxkzxq2.setZymc(wqwqxkzxq2Form.getZymc());
	
		wqwqxkzxq2.setBz(wqwqxkzxq2Form.getBz());
		
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
			
			formlist.add(wqwqxkzxq2Form);
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
