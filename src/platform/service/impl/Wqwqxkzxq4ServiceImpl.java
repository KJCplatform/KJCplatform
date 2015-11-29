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
import platform.dao.Wqwqxkzxq4Dao;
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
	
	public void updateWqwqxkzxq4(Wqwqxkzxq4Form wqwqxkzxq4Form){
		Wqwqxkzxq4 wqwqxkzxq4=new Wqwqxkzxq4();
		wqwqxkzxq4.setXh(wqwqxkzxq4Form.getXh());
		wqwqxkzxq4.setXmdm(wqwqxkzxq4Form.getXmdm());
		wqwqxkzxq4.setId(Integer.valueOf(wqwqxkzxq4Form.getId()));
	
		
		wqwqxkzxq4.setXmmc(wqwqxkzxq4Form.getXmmc());
		wqwqxkzxq4.setKysc(wqwqxkzxq4Form.getKysc());
		wqwqxkzxq4.setXklx(wqwqxkzxq4Form.getXklx());

		
		wqwqxkzxq4Dao.update(wqwqxkzxq4);
		
	}
	/*blic void updateWqwqxkzxq4Withget(Wqwqxkzxq4Form wqwqxkzxq4Form){
		Wqwqxkzxq4 wqwqxkzxq4=wqwqxkzxq4Dao.findObjectByID(Integer.valueOf(wqwqxkzxq4Form.getId()));
		wqwqxkzxq4.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq4Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq4Form wqwqxkzxq4Form){
		Wqwqxkzxq4 wqwqxkzxq4=new Wqwqxkzxq4();
		wqwqxkzxq4.setXh(wqwqxkzxq4Form.getXh());
		wqwqxkzxq4.setXmdm(wqwqxkzxq4Form.getXmdm());

		wqwqxkzxq4.setXmmc(wqwqxkzxq4Form.getXmmc());
		wqwqxkzxq4.setKysc(wqwqxkzxq4Form.getKysc());
		wqwqxkzxq4.setXklx(wqwqxkzxq4Form.getXklx());
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
			formlist.add(wqwqxkzxq4Form);
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
