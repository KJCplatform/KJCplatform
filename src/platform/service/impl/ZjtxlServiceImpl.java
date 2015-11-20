package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.XzxzgzbDao;
import platform.dao.ZjtxlDao;
import platform.domain.Zjtxl;
import platform.form.ZjtxlForm;
import platform.service.ZjtxlService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(ZjtxlService.SERVICE_NAME)
public class ZjtxlServiceImpl implements ZjtxlService{
	
	@Resource(name=ZjtxlDao.SERVICE_NAME)
	private ZjtxlDao zjtxlDao;
	
	public List<ZjtxlForm> findZjtxlList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Zjtxl> list=zjtxlDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<ZjtxlForm> formlist=this.ZjtxlPOListToVOList(list);
		return formlist;
		
	}
	public List<ZjtxlForm> findZjtxlListWithPage(int pagesize,int pageno,ZjtxlForm zjtxlForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(zjtxlForm!=null&&StringUtils.isNotBlank(zjtxlForm.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+zjtxlForm.getXm()+"%");
		}
		if(zjtxlForm!=null&&StringUtils.isNotBlank(zjtxlForm.getDw())){
			hqlWhere += " and o.dw like ?";
			paramsList.add("%"+zjtxlForm.getDw()+"%");
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Zjtxl> list=zjtxlDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<ZjtxlForm> formlist=this.ZjtxlPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateZjtxl(ZjtxlForm zjtxlForm){
		Zjtxl zjtxl=new Zjtxl();
		zjtxl.setId(Integer.valueOf(zjtxlForm.getId()));
		zjtxl.setXm(zjtxlForm.getXm());
		zjtxl.setDw(zjtxlForm.getDw());
		zjtxl.setBm(zjtxlForm.getBm());
		zjtxl.setZw(zjtxlForm.getZw());
		zjtxl.setLxfszj(zjtxlForm.getLxfszj());
		zjtxl.setLxfssj(zjtxlForm.getLxfssj());
		zjtxlDao.update(zjtxl);
		
	}
	public void deleteObject(String id){
		zjtxlDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(ZjtxlForm zjtxlForm){
		Zjtxl zjtxl=new Zjtxl();
		zjtxl.setXm(zjtxlForm.getXm());
		zjtxl.setDw(zjtxlForm.getDw());
		zjtxl.setBm(zjtxlForm.getBm());
		zjtxl.setZw(zjtxlForm.getZw());
		zjtxl.setLxfszj(zjtxlForm.getLxfszj());
		zjtxl.setLxfssj(zjtxlForm.getLxfssj());
		zjtxlDao.save(zjtxl);
	}
	private List<ZjtxlForm> ZjtxlPOListToVOList(List<Zjtxl> list) {
		// TODO Auto-generated method stub
		List<ZjtxlForm> formlist=new ArrayList<ZjtxlForm>();
		for(int i=0;i<list.size();i++){
			Zjtxl zjtxl=list.get(i);
			ZjtxlForm zjtxlForm=new ZjtxlForm();
			zjtxlForm.setId(String.valueOf(zjtxl.getId()));
			zjtxlForm.setXm(zjtxl.getXm());
			zjtxlForm.setDw(zjtxl.getDw());
		
			zjtxlForm.setBm(zjtxl.getBm());
			zjtxlForm.setZw(zjtxl.getZw());
			
			zjtxlForm.setLxfszj(zjtxl.getLxfszj());
			zjtxlForm.setLxfssj(zjtxl.getLxfssj());
			formlist.add(zjtxlForm);
		}
		return formlist;
	}

	
}
