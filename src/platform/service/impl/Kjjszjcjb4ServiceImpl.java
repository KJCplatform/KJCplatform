package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.Kjjszjcjb4Dao;
import platform.domain.Kjjszjcjb4;
import platform.form.Kjjszjcjb4Form;
import platform.service.Kjjszjcjb4Service;
import platform.util.StringHelper;
@Transactional
@Service(Kjjszjcjb4Service.SERVICE_NAME)
public class Kjjszjcjb4ServiceImpl implements Kjjszjcjb4Service{
	
	@Resource(name=Kjjszjcjb4Dao.SERVICE_NAME)
	private Kjjszjcjb4Dao kjjszjcjb4Dao;
	
	public List<Kjjszjcjb4Form> findKjjszjcjb4List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.sfzh", "desc");
		List<Kjjszjcjb4> list=kjjszjcjb4Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjjszjcjb4Form> formlist=this.Kjjszjcjb4POListToVOList(list);
		return formlist;
		
	}
	public List<Kjjszjcjb4Form> findKjjszjcjb4ListWithPage(int pagesize,int pageno,Kjjszjcjb4Form Kjjszjcjb4Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(Kjjszjcjb4Form!=null&&StringUtils.isNotBlank(Kjjszjcjb4Form.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+Kjjszjcjb4Form.getXm()+"%");
		}
		if(Kjjszjcjb4Form!=null&&StringUtils.isNotBlank(Kjjszjcjb4Form.getGzdw())){
			hqlWhere += " and o.gzdw like ?";
			paramsList.add("%"+Kjjszjcjb4Form.getGzdw()+"%");
		}
		orderby.put(" o.sfzh", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb4> list=kjjszjcjb4Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Kjjszjcjb4Form> formlist=this.Kjjszjcjb4POListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjjszjcjb4(Kjjszjcjb4Form kjjszjcjb4Form){
		Kjjszjcjb4 kjjszjcjb4=new Kjjszjcjb4();
		kjjszjcjb4.setXm(kjjszjcjb4Form.getXm());
		kjjszjcjb4.setXb(kjjszjcjb4Form.getXb());
		kjjszjcjb4.setId(Integer.valueOf(kjjszjcjb4Form.getId()));
		kjjszjcjb4.setGzdw(kjjszjcjb4Form.getGzdw());
		kjjszjcjb4.setGzbm(kjjszjcjb4Form.getGzbm());
		kjjszjcjb4.setZw(kjjszjcjb4Form.getZw());
		kjjszjcjb4.setJszc(kjjszjcjb4Form.getJszc());
		kjjszjcjb4.setSszy(kjjszjcjb4Form.getSszy());
		kjjszjcjb4.setYjfx(kjjszjcjb4Form.getYjfx());
		kjjszjcjb4.setSj(kjjszjcjb4Form.getSj());
		kjjszjcjb4.setDh(kjjszjcjb4Form.getDh());
		kjjszjcjb4.setYx(kjjszjcjb4Form.getYx());
		kjjszjcjb4.setSfzh(kjjszjcjb4Form.getSfzh());
		kjjszjcjb4.setBz(kjjszjcjb4Form.getBz());
		
		
		kjjszjcjb4.setJlnf(kjjszjcjb4Form.getJlnf());
		kjjszjcjb4.setUsername(kjjszjcjb4Form.getUsername());
		kjjszjcjb4.setGxsj(kjjszjcjb4Form.getGxsj());
		kjjszjcjb4.setSubmit(kjjszjcjb4Form.getSubmit());
		kjjszjcjb4Dao.update(kjjszjcjb4);
		
	}
	/*blic void updateKjjszjcjb4Withget(Kjjszjcjb4Form Kjjszjcjb4Form){
		Kjjszjcjb4 Kjjszjcjb4=Kjjszjcjb4Dao.findObjectByID(Integer.valueOf(Kjjszjcjb4Form.getId()));
		Kjjszjcjb4.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		kjjszjcjb4Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Kjjszjcjb4Form kjjszjcjb4Form){
		Kjjszjcjb4 kjjszjcjb4=new Kjjszjcjb4();
		kjjszjcjb4.setXm(kjjszjcjb4Form.getXm());
		kjjszjcjb4.setXb(kjjszjcjb4Form.getXb());
		kjjszjcjb4.setGzdw(kjjszjcjb4Form.getGzdw());
		kjjszjcjb4.setGzbm(kjjszjcjb4Form.getGzbm());
		kjjszjcjb4.setZw(kjjszjcjb4Form.getZw());
		kjjszjcjb4.setJszc(kjjszjcjb4Form.getJszc());
		kjjszjcjb4.setSszy(kjjszjcjb4Form.getSszy());
		kjjszjcjb4.setYjfx(kjjszjcjb4Form.getYjfx());
		kjjszjcjb4.setSj(kjjszjcjb4Form.getSj());
		kjjszjcjb4.setDh(kjjszjcjb4Form.getDh());
		kjjszjcjb4.setYx(kjjszjcjb4Form.getYx());
		kjjszjcjb4.setSfzh(kjjszjcjb4Form.getSfzh());
		kjjszjcjb4.setBz(kjjszjcjb4Form.getBz());
		
		
		kjjszjcjb4.setJlnf(kjjszjcjb4Form.getJlnf());
		kjjszjcjb4.setUsername(kjjszjcjb4Form.getUsername());
		kjjszjcjb4.setGxsj(kjjszjcjb4Form.getGxsj());
		kjjszjcjb4.setSubmit(kjjszjcjb4Form.getSubmit());
		kjjszjcjb4Dao.save(kjjszjcjb4);
	}
	private List<Kjjszjcjb4Form> Kjjszjcjb4POListToVOList(List<Kjjszjcjb4> list) {
		// TODO Auto-generated method stub
		List<Kjjszjcjb4Form> formlist=new ArrayList<Kjjszjcjb4Form>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjb4 kjjszjcjb4=list.get(i);
			Kjjszjcjb4Form kjjszjcjb4Form=new Kjjszjcjb4Form();
			kjjszjcjb4Form.setXm(kjjszjcjb4.getXm());
			kjjszjcjb4Form.setXb(kjjszjcjb4.getXb());
	//		Kjjszjcjb4Form.setFwrq(String.valueOf(Kjjszjcjb4.getFwrq()));
			kjjszjcjb4Form.setId(String.valueOf(kjjszjcjb4.getId()));
			kjjszjcjb4Form.setGzdw(kjjszjcjb4.getGzdw());
			kjjszjcjb4Form.setGzbm(kjjszjcjb4.getGzbm());
	//		Kjjszjcjb4Form.setJzrq(String.valueOf(Kjjszjcjb4.getJzrq()));
			kjjszjcjb4Form.setZw(kjjszjcjb4.getZw());
			kjjszjcjb4Form.setJszc(kjjszjcjb4.getJszc());
			kjjszjcjb4Form.setSszy(kjjszjcjb4.getSszy());
			kjjszjcjb4Form.setYjfx(kjjszjcjb4.getYjfx());
			kjjszjcjb4Form.setJszc(kjjszjcjb4.getJszc());
			kjjszjcjb4Form.setSj(kjjszjcjb4.getSj());
			kjjszjcjb4Form.setDh(kjjszjcjb4.getDh());
			kjjszjcjb4Form.setYx(kjjszjcjb4.getYx());
			kjjszjcjb4Form.setSfzh(kjjszjcjb4.getSfzh());
			kjjszjcjb4Form.setBz(kjjszjcjb4.getBz());
			
			
			kjjszjcjb4Form.setJlnf(kjjszjcjb4.getJlnf());
			kjjszjcjb4Form.setUsername(kjjszjcjb4.getUsername());
			kjjszjcjb4Form.setGxsj(kjjszjcjb4.getGxsj());
			kjjszjcjb4Form.setSubmit(String.valueOf(kjjszjcjb4.getSubmit()));
			formlist.add(kjjszjcjb4Form);
		}
		return formlist;
	}

	
}
