package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.Kjjszjcjb1Dao;
import platform.domain.Kjjszjcjb1;
import platform.form.Kjjszjcjb1Form;
import platform.service.Kjjszjcjb1Service;
import platform.util.StringHelper;
@Transactional
@Service(Kjjszjcjb1Service.SERVICE_NAME)
public class Kjjszjcjb1ServiceImpl implements Kjjszjcjb1Service{
	
	@Resource(name=Kjjszjcjb1Dao.SERVICE_NAME)
	private Kjjszjcjb1Dao kjjszjcjb1Dao;
	
	public List<Kjjszjcjb1Form> findKjjszjcjb1List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.sfzh", "desc");
		List<Kjjszjcjb1> list=kjjszjcjb1Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjjszjcjb1Form> formlist=this.Kjjszjcjb1POListToVOList(list);
		return formlist;
		
	}
	public List<Kjjszjcjb1Form> findKjjszjcjb1ListWithPage(int pagesize,int pageno,Kjjszjcjb1Form Kjjszjcjb1Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(Kjjszjcjb1Form!=null&&StringUtils.isNotBlank(Kjjszjcjb1Form.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+Kjjszjcjb1Form.getXm()+"%");
		}
		if(Kjjszjcjb1Form!=null&&StringUtils.isNotBlank(Kjjszjcjb1Form.getGzdw())){
			hqlWhere += " and o.gzdw like ?";
			paramsList.add("%"+Kjjszjcjb1Form.getGzdw()+"%");
		}
		orderby.put(" o.sfzh", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb1> list=kjjszjcjb1Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Kjjszjcjb1Form> formlist=this.Kjjszjcjb1POListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjjszjcjb1(Kjjszjcjb1Form kjjszjcjb1Form){
		Kjjszjcjb1 kjjszjcjb1=new Kjjszjcjb1();
		kjjszjcjb1.setXm(kjjszjcjb1Form.getXm());
		kjjszjcjb1.setXb(kjjszjcjb1Form.getXb());
		kjjszjcjb1.setId(Integer.valueOf(kjjszjcjb1Form.getId()));
		kjjszjcjb1.setGzdw(kjjszjcjb1Form.getGzdw());
		kjjszjcjb1.setGzbm(kjjszjcjb1Form.getGzbm());
		kjjszjcjb1.setZw(kjjszjcjb1Form.getZw());
		kjjszjcjb1.setJszc(kjjszjcjb1Form.getJszc());
		kjjszjcjb1.setSszy(kjjszjcjb1Form.getSszy());
		kjjszjcjb1.setYjfx(kjjszjcjb1Form.getYjfx());
		kjjszjcjb1.setSj(kjjszjcjb1Form.getSj());
		kjjszjcjb1.setDh(kjjszjcjb1Form.getDh());
		kjjszjcjb1.setYx(kjjszjcjb1Form.getYx());
		kjjszjcjb1.setSfzh(kjjszjcjb1Form.getSfzh());
		kjjszjcjb1.setBz(kjjszjcjb1Form.getBz());
		
		
		kjjszjcjb1.setJlnf(kjjszjcjb1Form.getJlnf());
		kjjszjcjb1.setUsername(kjjszjcjb1Form.getUsername());
		kjjszjcjb1.setGxsj(kjjszjcjb1Form.getGxsj());
		kjjszjcjb1.setSubmit(kjjszjcjb1Form.getSubmit());
		kjjszjcjb1Dao.update(kjjszjcjb1);
		
	}
	/*blic void updateKjjszjcjb1Withget(Kjjszjcjb1Form Kjjszjcjb1Form){
		Kjjszjcjb1 Kjjszjcjb1=Kjjszjcjb1Dao.findObjectByID(Integer.valueOf(Kjjszjcjb1Form.getId()));
		Kjjszjcjb1.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		kjjszjcjb1Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Kjjszjcjb1Form kjjszjcjb1Form){
		Kjjszjcjb1 kjjszjcjb1=new Kjjszjcjb1();
		kjjszjcjb1.setXm(kjjszjcjb1Form.getXm());
		kjjszjcjb1.setXb(kjjszjcjb1Form.getXb());
		kjjszjcjb1.setGzdw(kjjszjcjb1Form.getGzdw());
		kjjszjcjb1.setGzbm(kjjszjcjb1Form.getGzbm());
		kjjszjcjb1.setZw(kjjszjcjb1Form.getZw());
		kjjszjcjb1.setJszc(kjjszjcjb1Form.getJszc());
		kjjszjcjb1.setSszy(kjjszjcjb1Form.getSszy());
		kjjszjcjb1.setYjfx(kjjszjcjb1Form.getYjfx());
		kjjszjcjb1.setSj(kjjszjcjb1Form.getSj());
		kjjszjcjb1.setDh(kjjszjcjb1Form.getDh());
		kjjszjcjb1.setYx(kjjszjcjb1Form.getYx());
		kjjszjcjb1.setSfzh(kjjszjcjb1Form.getSfzh());
		kjjszjcjb1.setBz(kjjszjcjb1Form.getBz());
		
		
		kjjszjcjb1.setJlnf(kjjszjcjb1Form.getJlnf());
		kjjszjcjb1.setUsername(kjjszjcjb1Form.getUsername());
		kjjszjcjb1.setGxsj(kjjszjcjb1Form.getGxsj());
		kjjszjcjb1.setSubmit(kjjszjcjb1Form.getSubmit());
		kjjszjcjb1Dao.save(kjjszjcjb1);
	}
	private List<Kjjszjcjb1Form> Kjjszjcjb1POListToVOList(List<Kjjszjcjb1> list) {
		// TODO Auto-generated method stub
		List<Kjjszjcjb1Form> formlist=new ArrayList<Kjjszjcjb1Form>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjb1 kjjszjcjb1=list.get(i);
			Kjjszjcjb1Form kjjszjcjb1Form=new Kjjszjcjb1Form();
			kjjszjcjb1Form.setXm(kjjszjcjb1.getXm());
			kjjszjcjb1Form.setXb(kjjszjcjb1.getXb());
	//		Kjjszjcjb1Form.setFwrq(String.valueOf(Kjjszjcjb1.getFwrq()));
			kjjszjcjb1Form.setId(String.valueOf(kjjszjcjb1.getId()));
			kjjszjcjb1Form.setGzdw(kjjszjcjb1.getGzdw());
			kjjszjcjb1Form.setGzbm(kjjszjcjb1.getGzbm());
	//		Kjjszjcjb1Form.setJzrq(String.valueOf(Kjjszjcjb1.getJzrq()));
			kjjszjcjb1Form.setZw(kjjszjcjb1.getZw());
			kjjszjcjb1Form.setJszc(kjjszjcjb1.getJszc());
			kjjszjcjb1Form.setSszy(kjjszjcjb1.getSszy());
			kjjszjcjb1Form.setYjfx(kjjszjcjb1.getYjfx());
			kjjszjcjb1Form.setJszc(kjjszjcjb1.getJszc());
			kjjszjcjb1Form.setSj(kjjszjcjb1.getSj());
			kjjszjcjb1Form.setDh(kjjszjcjb1.getDh());
			kjjszjcjb1Form.setYx(kjjszjcjb1.getYx());
			kjjszjcjb1Form.setSfzh(kjjszjcjb1.getSfzh());
			kjjszjcjb1Form.setBz(kjjszjcjb1.getBz());
			
			
			kjjszjcjb1Form.setJlnf(kjjszjcjb1.getJlnf());
			kjjszjcjb1Form.setUsername(kjjszjcjb1.getUsername());
			kjjszjcjb1Form.setGxsj(kjjszjcjb1.getGxsj());
			kjjszjcjb1Form.setSubmit(String.valueOf(kjjszjcjb1.getSubmit()));
			formlist.add(kjjszjcjb1Form);
		}
		return formlist;
	}

	
}
