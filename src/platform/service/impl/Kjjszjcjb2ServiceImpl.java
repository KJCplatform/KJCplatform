package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.Kjjszjcjb2Dao;
import platform.domain.Kjjszjcjb2;
import platform.form.Kjjszjcjb2Form;
import platform.service.Kjjszjcjb2Service;
import platform.util.StringHelper;
@Transactional
@Service(Kjjszjcjb2Service.SERVICE_NAME)
public class Kjjszjcjb2ServiceImpl implements Kjjszjcjb2Service{
	
	@Resource(name=Kjjszjcjb2Dao.SERVICE_NAME)
	private Kjjszjcjb2Dao kjjszjcjb2Dao;
	
	public List<Kjjszjcjb2Form> findKjjszjcjb2List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.sfzh", "desc");
		List<Kjjszjcjb2> list=kjjszjcjb2Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjjszjcjb2Form> formlist=this.Kjjszjcjb2POListToVOList(list);
		return formlist;
		
	}
	public List<Kjjszjcjb2Form> findKjjszjcjb2ListWithPage(int pagesize,int pageno,Kjjszjcjb2Form Kjjszjcjb2Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(Kjjszjcjb2Form!=null&&StringUtils.isNotBlank(Kjjszjcjb2Form.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+Kjjszjcjb2Form.getXm()+"%");
		}
		if(Kjjszjcjb2Form!=null&&StringUtils.isNotBlank(Kjjszjcjb2Form.getGzdw())){
			hqlWhere += " and o.gzdw like ?";
			paramsList.add("%"+Kjjszjcjb2Form.getGzdw()+"%");
		}
		orderby.put(" o.sfzh", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb2> list=kjjszjcjb2Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Kjjszjcjb2Form> formlist=this.Kjjszjcjb2POListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjjszjcjb2(Kjjszjcjb2Form kjjszjcjb2Form){
		Kjjszjcjb2 kjjszjcjb2=new Kjjszjcjb2();
		kjjszjcjb2.setXm(kjjszjcjb2Form.getXm());
		kjjszjcjb2.setXb(kjjszjcjb2Form.getXb());
		kjjszjcjb2.setId(Integer.valueOf(kjjszjcjb2Form.getId()));
		kjjszjcjb2.setGzdw(kjjszjcjb2Form.getGzdw());
		kjjszjcjb2.setGzbm(kjjszjcjb2Form.getGzbm());
		kjjszjcjb2.setZw(kjjszjcjb2Form.getZw());
		kjjszjcjb2.setJszc(kjjszjcjb2Form.getJszc());
		kjjszjcjb2.setSszy(kjjszjcjb2Form.getSszy());
		kjjszjcjb2.setYjfx(kjjszjcjb2Form.getYjfx());
		kjjszjcjb2.setSj(kjjszjcjb2Form.getSj());
		kjjszjcjb2.setDh(kjjszjcjb2Form.getDh());
		kjjszjcjb2.setYx(kjjszjcjb2Form.getYx());
		kjjszjcjb2.setSfzh(kjjszjcjb2Form.getSfzh());
		kjjszjcjb2.setBz(kjjszjcjb2Form.getBz());
		
		
		kjjszjcjb2.setJlnf(kjjszjcjb2Form.getJlnf());
		kjjszjcjb2.setUsername(kjjszjcjb2Form.getUsername());
		kjjszjcjb2.setGxsj(kjjszjcjb2Form.getGxsj());
		kjjszjcjb2.setSubmit(kjjszjcjb2Form.getSubmit());
		kjjszjcjb2Dao.update(kjjszjcjb2);
		
	}
	/*blic void updateKjjszjcjb2Withget(Kjjszjcjb2Form Kjjszjcjb2Form){
		Kjjszjcjb2 Kjjszjcjb2=Kjjszjcjb2Dao.findObjectByID(Integer.valueOf(Kjjszjcjb2Form.getId()));
		Kjjszjcjb2.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		kjjszjcjb2Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Kjjszjcjb2Form kjjszjcjb2Form){
		Kjjszjcjb2 kjjszjcjb2=new Kjjszjcjb2();
		kjjszjcjb2.setXm(kjjszjcjb2Form.getXm());
		kjjszjcjb2.setXb(kjjszjcjb2Form.getXb());
		kjjszjcjb2.setGzdw(kjjszjcjb2Form.getGzdw());
		kjjszjcjb2.setGzbm(kjjszjcjb2Form.getGzbm());
		kjjszjcjb2.setZw(kjjszjcjb2Form.getZw());
		kjjszjcjb2.setJszc(kjjszjcjb2Form.getJszc());
		kjjszjcjb2.setSszy(kjjszjcjb2Form.getSszy());
		kjjszjcjb2.setYjfx(kjjszjcjb2Form.getYjfx());
		kjjszjcjb2.setSj(kjjszjcjb2Form.getSj());
		kjjszjcjb2.setDh(kjjszjcjb2Form.getDh());
		kjjszjcjb2.setYx(kjjszjcjb2Form.getYx());
		kjjszjcjb2.setSfzh(kjjszjcjb2Form.getSfzh());
		kjjszjcjb2.setBz(kjjszjcjb2Form.getBz());
		
		
		kjjszjcjb2.setJlnf(kjjszjcjb2Form.getJlnf());
		kjjszjcjb2.setUsername(kjjszjcjb2Form.getUsername());
		kjjszjcjb2.setGxsj(kjjszjcjb2Form.getGxsj());
		kjjszjcjb2.setSubmit(kjjszjcjb2Form.getSubmit());
		kjjszjcjb2Dao.save(kjjszjcjb2);
	}
	private List<Kjjszjcjb2Form> Kjjszjcjb2POListToVOList(List<Kjjszjcjb2> list) {
		// TODO Auto-generated method stub
		List<Kjjszjcjb2Form> formlist=new ArrayList<Kjjszjcjb2Form>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjb2 kjjszjcjb2=list.get(i);
			Kjjszjcjb2Form kjjszjcjb2Form=new Kjjszjcjb2Form();
			kjjszjcjb2Form.setXm(kjjszjcjb2.getXm());
			kjjszjcjb2Form.setXb(kjjszjcjb2.getXb());
	//		Kjjszjcjb2Form.setFwrq(String.valueOf(Kjjszjcjb2.getFwrq()));
			kjjszjcjb2Form.setId(String.valueOf(kjjszjcjb2.getId()));
			kjjszjcjb2Form.setGzdw(kjjszjcjb2.getGzdw());
			kjjszjcjb2Form.setGzbm(kjjszjcjb2.getGzbm());
	//		Kjjszjcjb2Form.setJzrq(String.valueOf(Kjjszjcjb2.getJzrq()));
			kjjszjcjb2Form.setZw(kjjszjcjb2.getZw());
			kjjszjcjb2Form.setJszc(kjjszjcjb2.getJszc());
			kjjszjcjb2Form.setSszy(kjjszjcjb2.getSszy());
			kjjszjcjb2Form.setYjfx(kjjszjcjb2.getYjfx());
			kjjszjcjb2Form.setJszc(kjjszjcjb2.getJszc());
			kjjszjcjb2Form.setSj(kjjszjcjb2.getSj());
			kjjszjcjb2Form.setDh(kjjszjcjb2.getDh());
			kjjszjcjb2Form.setYx(kjjszjcjb2.getYx());
			kjjszjcjb2Form.setSfzh(kjjszjcjb2.getSfzh());
			kjjszjcjb2Form.setBz(kjjszjcjb2.getBz());
			
			
			kjjszjcjb2Form.setJlnf(kjjszjcjb2.getJlnf());
			kjjszjcjb2Form.setUsername(kjjszjcjb2.getUsername());
			kjjszjcjb2Form.setGxsj(kjjszjcjb2.getGxsj());
			kjjszjcjb2Form.setSubmit(String.valueOf(kjjszjcjb2.getSubmit()));
			formlist.add(kjjszjcjb2Form);
		}
		return formlist;
	}

	
}
