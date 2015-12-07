package platform.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.Jpjgdwjbqk0Dao;
import platform.domain.Jpjgdwjbqk;
import platform.domain.Jpjgdwjbqk0;
import platform.form.Jpjgdwjbqk0Form;
import platform.form.JpjgdwjbqkForm;
import platform.service.Jpjgdwjbqk0Service;
import platform.util.StringHelper;
@Transactional
@Service(Jpjgdwjbqk0Service.SERVICE_NAME)
public class Jpjgdwjbqk0ServiceImpl implements Jpjgdwjbqk0Service{
	
	@Resource(name=Jpjgdwjbqk0Dao.SERVICE_NAME)
	private Jpjgdwjbqk0Dao jpjgdwjbqk0Dao;
	
	public List<Jpjgdwjbqk0Form> findJpjgdwjbqk0List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Jpjgdwjbqk0> list=jpjgdwjbqk0Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Jpjgdwjbqk0Form> formlist=this.Jpjgdwjbqk0POListToVOList(list);
		return formlist;
		
	}
	public List<Jpjgdwjbqk0Form> findJpjgdwjbqk0ListWithPage(int pagesize,int pageno,Jpjgdwjbqk0Form jpjgdwjbqk0Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpjgdwjbqk0Form!=null&&StringUtils.isNotBlank(jpjgdwjbqk0Form.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+jpjgdwjbqk0Form.getDwmc()+"%");
		}
		if(jpjgdwjbqk0Form!=null&&StringUtils.isNotBlank(jpjgdwjbqk0Form.getDwdh())){
			hqlWhere += " and o.dwdh like ?";
			paramsList.add("%"+jpjgdwjbqk0Form.getDwdh()+"%");
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Jpjgdwjbqk0> list=jpjgdwjbqk0Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Jpjgdwjbqk0Form> formlist=this.Jpjgdwjbqk0POListToVOList(list);
		return formlist;
		
	}
	
	public void updateJpjgdwjbqk0(Jpjgdwjbqk0Form jpjgdwjbqk0Form,String username){
		Jpjgdwjbqk0 jpjgdwjbqk0=new Jpjgdwjbqk0();
		jpjgdwjbqk0.setId(Integer.valueOf(jpjgdwjbqk0Form.getId()));
		jpjgdwjbqk0.setDwmc(jpjgdwjbqk0Form.getDwmc());
		jpjgdwjbqk0.setQtmc(jpjgdwjbqk0Form.getQtmc());
		jpjgdwjbqk0.setDwdh(jpjgdwjbqk0Form.getDwdh());
		jpjgdwjbqk0.setScdz(jpjgdwjbqk0Form.getScdz());
		jpjgdwjbqk0.setJjxz(jpjgdwjbqk0Form.getJjxz());
		jpjgdwjbqk0.setFrdb(jpjgdwjbqk0Form.getFrdb());
		jpjgdwjbqk0.setDwdz(jpjgdwjbqk0Form.getDwdz());
		jpjgdwjbqk0.setYzbm(jpjgdwjbqk0Form.getYzbm());
		jpjgdwjbqk0.setLxr(jpjgdwjbqk0Form.getLxr());
		jpjgdwjbqk0.setLxdh(jpjgdwjbqk0Form.getLxdh());
		jpjgdwjbqk0.setZgzs(jpjgdwjbqk0Form.getZgzs());
		jpjgdwjbqk0.setGzgl(jpjgdwjbqk0Form.getGzgl());
		jpjgdwjbqk0.setZzgl(jpjgdwjbqk0Form.getZzgl());
		jpjgdwjbqk0.setCzgl(jpjgdwjbqk0Form.getCzgl());
		jpjgdwjbqk0.setGzjs(jpjgdwjbqk0Form.getGzjs());
		jpjgdwjbqk0.setZzjs(jpjgdwjbqk0Form.getZzjs());
		jpjgdwjbqk0.setCzjs(jpjgdwjbqk0Form.getCzjs());
		jpjgdwjbqk0.setGzgr(jpjgdwjbqk0Form.getGzgr());
		jpjgdwjbqk0.setZzgr(jpjgdwjbqk0Form.getZzgr());
		jpjgdwjbqk0.setCzgr(jpjgdwjbqk0Form.getCzgr());
		jpjgdwjbqk0.setGjjcgs(jpjgdwjbqk0Form.getGjjcgs());
		jpjgdwjbqk0.setSbjcgs(jpjgdwjbqk0Form.getSbjcgs());
		jpjgdwjbqk0.setJlz(jpjgdwjbqk0Form.getJlz());
		jpjgdwjbqk0.setJlbzsl(jpjgdwjbqk0Form.getJlbzsl());
		jpjgdwjbqk0.setJpkyrw(jpjgdwjbqk0Form.getJpkyrw());
		jpjgdwjbqk0.setGjsyssl(jpjgdwjbqk0Form.getGjsyssl());
		jpjgdwjbqk0.setGfsyssl(jpjgdwjbqk0Form.getGfsyssl());
		
		jpjgdwjbqk0.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jpjgdwjbqk0.setUsername(username);
		jpjgdwjbqk0.setGxsj(new Date().toString());
		jpjgdwjbqk0.setSubmit(0);
		jpjgdwjbqk0Dao.update(jpjgdwjbqk0);
		
	}
	/*blic void updateJpjgdwjbqk0Withget(Jpjgdwjbqk0Form Jpjgdwjbqk0Form){
		Jpjgdwjbqk0 Jpjgdwjbqk0=Jpjgdwjbqk0Dao.findObjectByID(Integer.valueOf(Jpjgdwjbqk0Form.getId()));
		Jpjgdwjbqk0.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		jpjgdwjbqk0Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Jpjgdwjbqk0Form jpjgdwjbqk0Form,String username){
		Jpjgdwjbqk0 jpjgdwjbqk0=new Jpjgdwjbqk0();
		jpjgdwjbqk0.setDwmc(jpjgdwjbqk0Form.getDwmc());
		jpjgdwjbqk0.setQtmc(jpjgdwjbqk0Form.getQtmc());
		jpjgdwjbqk0.setDwdh(jpjgdwjbqk0Form.getDwdh());
		jpjgdwjbqk0.setScdz(jpjgdwjbqk0Form.getScdz());
		jpjgdwjbqk0.setJjxz(jpjgdwjbqk0Form.getJjxz());
		jpjgdwjbqk0.setFrdb(jpjgdwjbqk0Form.getFrdb());
		jpjgdwjbqk0.setDwdz(jpjgdwjbqk0Form.getDwdz());
		jpjgdwjbqk0.setYzbm(jpjgdwjbqk0Form.getYzbm());
		jpjgdwjbqk0.setLxr(jpjgdwjbqk0Form.getLxr());
		jpjgdwjbqk0.setLxdh(jpjgdwjbqk0Form.getLxdh());
		jpjgdwjbqk0.setZgzs(jpjgdwjbqk0Form.getZgzs());
		jpjgdwjbqk0.setGzgl(jpjgdwjbqk0Form.getGzgl());
		jpjgdwjbqk0.setZzgl(jpjgdwjbqk0Form.getZzgl());
		jpjgdwjbqk0.setCzgl(jpjgdwjbqk0Form.getCzgl());
		jpjgdwjbqk0.setGzjs(jpjgdwjbqk0Form.getGzjs());
		jpjgdwjbqk0.setZzjs(jpjgdwjbqk0Form.getZzjs());
		jpjgdwjbqk0.setCzjs(jpjgdwjbqk0Form.getCzjs());
		jpjgdwjbqk0.setGzgr(jpjgdwjbqk0Form.getGzgr());
		jpjgdwjbqk0.setZzgr(jpjgdwjbqk0Form.getZzgr());
		jpjgdwjbqk0.setCzgr(jpjgdwjbqk0Form.getCzgr());
		jpjgdwjbqk0.setGjjcgs(jpjgdwjbqk0Form.getGjjcgs());
		jpjgdwjbqk0.setSbjcgs(jpjgdwjbqk0Form.getSbjcgs());
		jpjgdwjbqk0.setJlz(jpjgdwjbqk0Form.getJlz());
		jpjgdwjbqk0.setJlbzsl(jpjgdwjbqk0Form.getJlbzsl());
		jpjgdwjbqk0.setJpkyrw(jpjgdwjbqk0Form.getJpkyrw());
		jpjgdwjbqk0.setGjsyssl(jpjgdwjbqk0Form.getGjsyssl());
		jpjgdwjbqk0.setGfsyssl(jpjgdwjbqk0Form.getGfsyssl());
		
		jpjgdwjbqk0.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		jpjgdwjbqk0.setUsername(username);
		jpjgdwjbqk0.setGxsj(new Date().toString());
		jpjgdwjbqk0.setSubmit(0);
		jpjgdwjbqk0Dao.save(jpjgdwjbqk0);
	}
	private List<Jpjgdwjbqk0Form> Jpjgdwjbqk0POListToVOList(List<Jpjgdwjbqk0> list) {
		// TODO Auto-generated method stub
		List<Jpjgdwjbqk0Form> formlist=new ArrayList<Jpjgdwjbqk0Form>();
		for(int i=0;i<list.size();i++){
			Jpjgdwjbqk0 jpjgdwjbqk0=list.get(i);
			Jpjgdwjbqk0Form jpjgdwjbqk0Form=new Jpjgdwjbqk0Form();
			jpjgdwjbqk0Form.setId(String.valueOf(list.get(i).getId()));
			jpjgdwjbqk0Form.setDwmc(list.get(i).getDwmc());
			jpjgdwjbqk0Form.setQtmc(list.get(i).getQtmc());
			jpjgdwjbqk0Form.setDwdh(list.get(i).getDwdh());
			jpjgdwjbqk0Form.setScdz(list.get(i).getScdz());
			jpjgdwjbqk0Form.setJjxz(list.get(i).getJjxz());
			jpjgdwjbqk0Form.setFrdb(list.get(i).getFrdb());
			jpjgdwjbqk0Form.setDwdz(list.get(i).getDwdz());
			jpjgdwjbqk0Form.setYzbm(list.get(i).getYzbm());
			jpjgdwjbqk0Form.setLxr(list.get(i).getLxr());
			jpjgdwjbqk0Form.setLxdh(list.get(i).getLxdh());
			jpjgdwjbqk0Form.setZgzs(list.get(i).getZgzs());
			jpjgdwjbqk0Form.setGzgl(list.get(i).getGzgl());
			jpjgdwjbqk0Form.setZzgl(list.get(i).getZzgl());
			jpjgdwjbqk0Form.setCzgl(list.get(i).getCzgl());
			jpjgdwjbqk0Form.setGzjs(list.get(i).getGzjs());
			jpjgdwjbqk0Form.setZzjs(list.get(i).getZzjs());
			jpjgdwjbqk0Form.setCzjs(list.get(i).getCzjs());
			jpjgdwjbqk0Form.setGzgr(list.get(i).getGzgr());
			jpjgdwjbqk0Form.setZzgr(list.get(i).getZzgr());
			jpjgdwjbqk0Form.setCzgr(list.get(i).getCzgr());
			jpjgdwjbqk0Form.setGjjcgs(list.get(i).getGjjcgs());
			jpjgdwjbqk0Form.setSbjcgs(list.get(i).getSbjcgs());
			jpjgdwjbqk0Form.setJlz(list.get(i).getJlz());
			jpjgdwjbqk0Form.setJlbzsl(list.get(i).getJlbzsl());
			jpjgdwjbqk0Form.setJpkyrw(list.get(i).getJpkyrw());
			jpjgdwjbqk0Form.setGjsyssl(list.get(i).getGjsyssl());
			jpjgdwjbqk0Form.setGfsyssl(list.get(i).getGfsyssl());
			
			jpjgdwjbqk0Form.setJlnf(jpjgdwjbqk0.getJlnf());
			jpjgdwjbqk0Form.setUsername(jpjgdwjbqk0.getUsername());
			jpjgdwjbqk0Form.setGxsj(jpjgdwjbqk0.getGxsj());
			jpjgdwjbqk0Form.setSubmit(String.valueOf(jpjgdwjbqk0.getSubmit()));
			
			formlist.add(jpjgdwjbqk0Form);
		}
		return formlist;
	}

	
}
