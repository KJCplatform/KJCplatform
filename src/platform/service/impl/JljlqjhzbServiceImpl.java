package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.JljlqjhzbDao;
import platform.domain.Jljlqjhzb;
import platform.form.JljlqjhzbForm;
import platform.service.JljlqjhzbService;
import platform.util.StringHelper;

@Service(JljlqjhzbService.SERVICE_NAME)
public class JljlqjhzbServiceImpl implements JljlqjhzbService{
	
	@Resource(name=JljlqjhzbDao.SERVICE_NAME)
	private JljlqjhzbDao jljlqjhzbDao;
	
	public List<JljlqjhzbForm> findJljlqjhzbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.qjmc", "desc");
		List<Jljlqjhzb> list=jljlqjhzbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JljlqjhzbForm> formlist=this.JljlqjhzbPOListToVOList(list);
		return formlist;
		
	}
	public List<JljlqjhzbForm> findJljlqjhzbListWithPage(int pagesize,int pageno,JljlqjhzbForm jljlqjhzbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jljlqjhzbForm!=null&&StringUtils.isNotBlank(jljlqjhzbForm.getFrmc())){
			hqlWhere += " and o.frmc like ?";
			paramsList.add("%"+jljlqjhzbForm.getFrmc()+"%");
		}
		if(jljlqjhzbForm!=null&&StringUtils.isNotBlank(jljlqjhzbForm.getJlzy())){
			hqlWhere += " and o.jlzy like ?";
			paramsList.add("%"+jljlqjhzbForm.getJlzy()+"%");
		}
		orderby.put(" o.qjmc", "desc");
		params = paramsList.toArray();
		List<Jljlqjhzb> list=jljlqjhzbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<JljlqjhzbForm> formlist=this.JljlqjhzbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateJljlqjhzb(JljlqjhzbForm jljlqjhzbForm){
		Jljlqjhzb jljlqjhzb=new Jljlqjhzb();
		jljlqjhzb.setFrmc(jljlqjhzbForm.getFrmc());
		jljlqjhzb.setJlzy(jljlqjhzbForm.getJlzy());
		jljlqjhzb.setQjmc(jljlqjhzbForm.getQjmc());
		jljlqjhzb.setId(Integer.valueOf(jljlqjhzbForm.getId()));
		jljlqjhzb.setZsh(jljlqjhzbForm.getZsh());
		jljlqjhzb.setZmcxh(jljlqjhzbForm.getZmcxh());
		jljlqjhzb.setPtmcxh(jljlqjhzbForm.getPtmcxh());
		jljlqjhzb.setClcsfw(jljlqjhzbForm.getClcsfw());
		jljlqjhzb.setBqdd(jljlqjhzbForm.getBqdd());
		jljlqjhzb.setZsyjg(jljlqjhzbForm.getZsyjg());
		
		jljlqjhzbDao.update(jljlqjhzb);
		
	}
	public void deleteObject(String id){
		jljlqjhzbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(JljlqjhzbForm jljlqjhzbForm){
		Jljlqjhzb jljlqjhzb=new Jljlqjhzb();
		
		jljlqjhzb.setFrmc(jljlqjhzbForm.getFrmc());
		jljlqjhzb.setJlzy(jljlqjhzbForm.getJlzy());
		jljlqjhzb.setQjmc(jljlqjhzbForm.getQjmc());
		jljlqjhzb.setZsh(jljlqjhzbForm.getZsh());
		jljlqjhzb.setZmcxh(jljlqjhzbForm.getZmcxh());
		jljlqjhzb.setPtmcxh(jljlqjhzbForm.getPtmcxh());
		jljlqjhzb.setClcsfw(jljlqjhzbForm.getClcsfw());
		jljlqjhzb.setBqdd(jljlqjhzbForm.getBqdd());
		jljlqjhzb.setZsyjg(jljlqjhzbForm.getZsyjg());
		
		jljlqjhzbDao.save(jljlqjhzb);
	}
	private List<JljlqjhzbForm> JljlqjhzbPOListToVOList(List<Jljlqjhzb> list) {
		// TODO Auto-generated method stub
		List<JljlqjhzbForm> formlist=new ArrayList<JljlqjhzbForm>();
		for(int i=0;i<list.size();i++){
			Jljlqjhzb jljlqjhzb=list.get(i);
			JljlqjhzbForm jljlqjhzbForm=new JljlqjhzbForm();
			
			jljlqjhzbForm.setFrmc(jljlqjhzb.getFrmc());
			jljlqjhzbForm.setJlzy(jljlqjhzb.getJlzy());
			jljlqjhzbForm.setQjmc(jljlqjhzb.getQjmc());
			jljlqjhzbForm.setId(String.valueOf(jljlqjhzb.getId()));
			
			jljlqjhzbForm.setZsh(jljlqjhzb.getZsh());
			jljlqjhzbForm.setZmcxh(jljlqjhzb.getZmcxh());
			jljlqjhzbForm.setPtmcxh(jljlqjhzb.getPtmcxh());
			jljlqjhzbForm.setClcsfw(jljlqjhzb.getClcsfw());
			jljlqjhzbForm.setBqdd(jljlqjhzb.getBqdd());
			jljlqjhzbForm.setZsyjg(jljlqjhzb.getZsyjg());
			formlist.add(jljlqjhzbForm);
		}
		return formlist;
	}

	
}
