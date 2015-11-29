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
import platform.dao.Wqwqxkzxq3Dao;
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
	
	public void updateWqwqxkzxq3(Wqwqxkzxq3Form wqwqxkzxq3Form){
		Wqwqxkzxq3 wqwqxkzxq3=new Wqwqxkzxq3();
		wqwqxkzxq3.setXh(wqwqxkzxq3Form.getXh());
		wqwqxkzxq3.setXmdm(wqwqxkzxq3Form.getXmdm());
		wqwqxkzxq3.setId(Integer.valueOf(wqwqxkzxq3Form.getId()));
	
		
		wqwqxkzxq3.setXmmc(wqwqxkzxq3Form.getXmmc());
		wqwqxkzxq3.setKysc(wqwqxkzxq3Form.getKysc());
		wqwqxkzxq3.setXklx(wqwqxkzxq3Form.getXklx());

		
		wqwqxkzxq3Dao.update(wqwqxkzxq3);
		
	}
	/*blic void updateWqwqxkzxq3Withget(Wqwqxkzxq3Form wqwqxkzxq3Form){
		Wqwqxkzxq3 wqwqxkzxq3=wqwqxkzxq3Dao.findObjectByID(Integer.valueOf(wqwqxkzxq3Form.getId()));
		wqwqxkzxq3.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq3Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq3Form wqwqxkzxq3Form){
		Wqwqxkzxq3 wqwqxkzxq3=new Wqwqxkzxq3();
		wqwqxkzxq3.setXh(wqwqxkzxq3Form.getXh());
		wqwqxkzxq3.setXmdm(wqwqxkzxq3Form.getXmdm());

		wqwqxkzxq3.setXmmc(wqwqxkzxq3Form.getXmmc());
		wqwqxkzxq3.setKysc(wqwqxkzxq3Form.getKysc());
		wqwqxkzxq3.setXklx(wqwqxkzxq3Form.getXklx());
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
			formlist.add(wqwqxkzxq3Form);
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
