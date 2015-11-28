package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.Kjjszjcjb3Dao;
import platform.domain.Kjjszjcjb3;
import platform.form.Kjjszjcjb3Form;
import platform.service.Kjjszjcjb3Service;
import platform.util.StringHelper;
@Transactional
@Service(Kjjszjcjb3Service.SERVICE_NAME)
public class Kjjszjcjb3ServiceImpl implements Kjjszjcjb3Service{
	
	@Resource(name=Kjjszjcjb3Dao.SERVICE_NAME)
	private Kjjszjcjb3Dao kjjszjcjb3Dao;
	
	public List<Kjjszjcjb3Form> findKjjszjcjb3List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.sfzh", "desc");
		List<Kjjszjcjb3> list=kjjszjcjb3Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjjszjcjb3Form> formlist=this.Kjjszjcjb3POListToVOList(list);
		return formlist;
		
	}
	public List<Kjjszjcjb3Form> findKjjszjcjb3ListWithPage(int pagesize,int pageno,Kjjszjcjb3Form Kjjszjcjb3Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(Kjjszjcjb3Form!=null&&StringUtils.isNotBlank(Kjjszjcjb3Form.getXm())){
			hqlWhere += " and o.xm like ?";
			paramsList.add("%"+Kjjszjcjb3Form.getXm()+"%");
		}
		if(Kjjszjcjb3Form!=null&&StringUtils.isNotBlank(Kjjszjcjb3Form.getGzdw())){
			hqlWhere += " and o.gzdw like ?";
			paramsList.add("%"+Kjjszjcjb3Form.getGzdw()+"%");
		}
		orderby.put(" o.sfzh", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb3> list=kjjszjcjb3Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Kjjszjcjb3Form> formlist=this.Kjjszjcjb3POListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjjszjcjb3(Kjjszjcjb3Form kjjszjcjb3Form){
		Kjjszjcjb3 kjjszjcjb3=new Kjjszjcjb3();
		kjjszjcjb3.setXm(kjjszjcjb3Form.getXm());
		kjjszjcjb3.setXb(kjjszjcjb3Form.getXb());
		kjjszjcjb3.setId(Integer.valueOf(kjjszjcjb3Form.getId()));
		kjjszjcjb3.setGzdw(kjjszjcjb3Form.getGzdw());
		kjjszjcjb3.setGzbm(kjjszjcjb3Form.getGzbm());
		kjjszjcjb3.setZw(kjjszjcjb3Form.getZw());
		kjjszjcjb3.setJszc(kjjszjcjb3Form.getJszc());
		kjjszjcjb3.setSszy(kjjszjcjb3Form.getSszy());
		kjjszjcjb3.setYjfx(kjjszjcjb3Form.getYjfx());
		kjjszjcjb3.setSj(kjjszjcjb3Form.getSj());
		kjjszjcjb3.setDh(kjjszjcjb3Form.getDh());
		kjjszjcjb3.setYx(kjjszjcjb3Form.getYx());
		kjjszjcjb3.setSfzh(kjjszjcjb3Form.getSfzh());
		kjjszjcjb3.setBz(kjjszjcjb3Form.getBz());
		
		
		kjjszjcjb3.setJlnf(kjjszjcjb3Form.getJlnf());
		kjjszjcjb3.setUsername(kjjszjcjb3Form.getUsername());
		kjjszjcjb3.setGxsj(kjjszjcjb3Form.getGxsj());
		kjjszjcjb3.setSubmit(kjjszjcjb3Form.getSubmit());
		kjjszjcjb3Dao.update(kjjszjcjb3);
		
	}
	/*blic void updateKjjszjcjb3Withget(Kjjszjcjb3Form Kjjszjcjb3Form){
		Kjjszjcjb3 Kjjszjcjb3=Kjjszjcjb3Dao.findObjectByID(Integer.valueOf(Kjjszjcjb3Form.getId()));
		Kjjszjcjb3.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		kjjszjcjb3Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Kjjszjcjb3Form kjjszjcjb3Form){
		Kjjszjcjb3 kjjszjcjb3=new Kjjszjcjb3();
		kjjszjcjb3.setXm(kjjszjcjb3Form.getXm());
		kjjszjcjb3.setXb(kjjszjcjb3Form.getXb());
		kjjszjcjb3.setGzdw(kjjszjcjb3Form.getGzdw());
		kjjszjcjb3.setGzbm(kjjszjcjb3Form.getGzbm());
		kjjszjcjb3.setZw(kjjszjcjb3Form.getZw());
		kjjszjcjb3.setJszc(kjjszjcjb3Form.getJszc());
		kjjszjcjb3.setSszy(kjjszjcjb3Form.getSszy());
		kjjszjcjb3.setYjfx(kjjszjcjb3Form.getYjfx());
		kjjszjcjb3.setSj(kjjszjcjb3Form.getSj());
		kjjszjcjb3.setDh(kjjszjcjb3Form.getDh());
		kjjszjcjb3.setYx(kjjszjcjb3Form.getYx());
		kjjszjcjb3.setSfzh(kjjszjcjb3Form.getSfzh());
		kjjszjcjb3.setBz(kjjszjcjb3Form.getBz());
		
		
		kjjszjcjb3.setJlnf(kjjszjcjb3Form.getJlnf());
		kjjszjcjb3.setUsername(kjjszjcjb3Form.getUsername());
		kjjszjcjb3.setGxsj(kjjszjcjb3Form.getGxsj());
		kjjszjcjb3.setSubmit(kjjszjcjb3Form.getSubmit());
		kjjszjcjb3Dao.save(kjjszjcjb3);
	}
	private List<Kjjszjcjb3Form> Kjjszjcjb3POListToVOList(List<Kjjszjcjb3> list) {
		// TODO Auto-generated method stub
		List<Kjjszjcjb3Form> formlist=new ArrayList<Kjjszjcjb3Form>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjb3 kjjszjcjb3=list.get(i);
			Kjjszjcjb3Form kjjszjcjb3Form=new Kjjszjcjb3Form();
			kjjszjcjb3Form.setXm(kjjszjcjb3.getXm());
			kjjszjcjb3Form.setXb(kjjszjcjb3.getXb());
	//		Kjjszjcjb3Form.setFwrq(String.valueOf(Kjjszjcjb3.getFwrq()));
			kjjszjcjb3Form.setId(String.valueOf(kjjszjcjb3.getId()));
			kjjszjcjb3Form.setGzdw(kjjszjcjb3.getGzdw());
			kjjszjcjb3Form.setGzbm(kjjszjcjb3.getGzbm());
	//		Kjjszjcjb3Form.setJzrq(String.valueOf(Kjjszjcjb3.getJzrq()));
			kjjszjcjb3Form.setZw(kjjszjcjb3.getZw());
			kjjszjcjb3Form.setJszc(kjjszjcjb3.getJszc());
			kjjszjcjb3Form.setSszy(kjjszjcjb3.getSszy());
			kjjszjcjb3Form.setYjfx(kjjszjcjb3.getYjfx());
			kjjszjcjb3Form.setJszc(kjjszjcjb3.getJszc());
			kjjszjcjb3Form.setSj(kjjszjcjb3.getSj());
			kjjszjcjb3Form.setDh(kjjszjcjb3.getDh());
			kjjszjcjb3Form.setYx(kjjszjcjb3.getYx());
			kjjszjcjb3Form.setSfzh(kjjszjcjb3.getSfzh());
			kjjszjcjb3Form.setBz(kjjszjcjb3.getBz());
			
			
			kjjszjcjb3Form.setJlnf(kjjszjcjb3.getJlnf());
			kjjszjcjb3Form.setUsername(kjjszjcjb3.getUsername());
			kjjszjcjb3Form.setGxsj(kjjszjcjb3.getGxsj());
			kjjszjcjb3Form.setSubmit(String.valueOf(kjjszjcjb3.getSubmit()));
			formlist.add(kjjszjcjb3Form);
		}
		return formlist;
	}

	
}
