package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.Wqwqxkzxq0Dao;
import platform.domain.Wqwqxkzxq0;
import platform.domain.Wqwqxkzxq0;
import platform.form.Wqwqxkzxq0Form;
import platform.form.Wqwqxkzxq0Form;
import platform.service.Wqwqxkzxq0Service;
import platform.util.StringHelper;
@Transactional
@Service(Wqwqxkzxq0Service.SERVICE_NAME)
public class Wqwqxkzxq0ServiceImpl implements Wqwqxkzxq0Service{
	
	@Resource(name=Wqwqxkzxq0Dao.SERVICE_NAME)
	private Wqwqxkzxq0Dao wqwqxkzxq0Dao;
	
	public List<Wqwqxkzxq0Form> findWqwqxkzxq0List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Wqwqxkzxq0> list=wqwqxkzxq0Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Wqwqxkzxq0Form> formlist=this.Wqwqxkzxq0POListToVOList(list);
		return formlist;
		
	}
	public List<Wqwqxkzxq0Form> findWqwqxkzxq0ListWithPage(int pagesize,int pageno,Wqwqxkzxq0Form wqwqxkzxq0Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(wqwqxkzxq0Form!=null&&StringUtils.isNotBlank(wqwqxkzxq0Form.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+wqwqxkzxq0Form.getDwmc()+"%");
		}
		if(wqwqxkzxq0Form!=null&&StringUtils.isNotBlank(wqwqxkzxq0Form.getDwdh())){
			hqlWhere += " and o.dwdh like ?";
			paramsList.add("%"+wqwqxkzxq0Form.getDwdh()+"%");
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Wqwqxkzxq0> list=wqwqxkzxq0Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Wqwqxkzxq0Form> formlist=this.Wqwqxkzxq0POListToVOList(list);
		return formlist;
		
	}
	
	public void updateWqwqxkzxq0(Wqwqxkzxq0Form wqwqxkzxq0Form){
		Wqwqxkzxq0 wqwqxkzxq0=new Wqwqxkzxq0();
		wqwqxkzxq0.setId(Integer.valueOf(wqwqxkzxq0Form.getId()));
		wqwqxkzxq0.setDwmc(wqwqxkzxq0Form.getDwmc());
		wqwqxkzxq0.setQtmc(wqwqxkzxq0Form.getQtmc());
		wqwqxkzxq0.setDwdh(wqwqxkzxq0Form.getDwdh());
		wqwqxkzxq0.setScdz(wqwqxkzxq0Form.getScdz());
		wqwqxkzxq0.setJjxz(wqwqxkzxq0Form.getJjxz());
		wqwqxkzxq0.setFrdb(wqwqxkzxq0Form.getFrdb());
		wqwqxkzxq0.setDwdz(wqwqxkzxq0Form.getDwdz());
		wqwqxkzxq0.setYzbm(wqwqxkzxq0Form.getYzbm());
		wqwqxkzxq0.setLxr(wqwqxkzxq0Form.getLxr());
		wqwqxkzxq0.setLxdh(wqwqxkzxq0Form.getLxdh());
		wqwqxkzxq0.setZgzs(wqwqxkzxq0Form.getZgzs());
		wqwqxkzxq0.setGzgl(wqwqxkzxq0Form.getGzgl());
		wqwqxkzxq0.setZzgl(wqwqxkzxq0Form.getZzgl());
		wqwqxkzxq0.setCzgl(wqwqxkzxq0Form.getCzgl());
		wqwqxkzxq0.setGzjs(wqwqxkzxq0Form.getGzjs());
		wqwqxkzxq0.setZzjs(wqwqxkzxq0Form.getZzjs());
		wqwqxkzxq0.setCzjs(wqwqxkzxq0Form.getCzjs());
		wqwqxkzxq0.setGzgr(wqwqxkzxq0Form.getGzgr());
		wqwqxkzxq0.setZzgr(wqwqxkzxq0Form.getZzgr());
		wqwqxkzxq0.setCzgr(wqwqxkzxq0Form.getCzgr());
		wqwqxkzxq0.setGjjcgs(wqwqxkzxq0Form.getGjjcgs());
		wqwqxkzxq0.setSbjcgs(wqwqxkzxq0Form.getSbjcgs());
		wqwqxkzxq0.setJbqk(wqwqxkzxq0Form.getJbqk());
		wqwqxkzxq0.setKyfx(wqwqxkzxq0Form.getKyfx());
		wqwqxkzxq0.setQyscgl(wqwqxkzxq0Form.getQyscgl());
		wqwqxkzxq0.setKyzk(wqwqxkzxq0Form.getKyzk());
		wqwqxkzxq0.setZlglzk(wqwqxkzxq0Form.getZlglzk());
		wqwqxkzxq0.setBmaqzk(wqwqxkzxq0Form.getBmaqzk());
		wqwqxkzxq0.setJpyfqk(wqwqxkzxq0Form.getJpyfqk());
		wqwqxkzxq0.setJpzzqk(wqwqxkzxq0Form.getJpzzqk());
		wqwqxkzxq0.setJpjcqk(wqwqxkzxq0Form.getJpjcqk());
		wqwqxkzxq0.setWcjpqk(wqwqxkzxq0Form.getWcjpqk());
		wqwqxkzxq0.setXcjpxmqk(wqwqxkzxq0Form.getXcjpxmqk());
		wqwqxkzxq0.setJlnf(wqwqxkzxq0Form.getJlnf());
		wqwqxkzxq0.setUsername(wqwqxkzxq0Form.getUsername());
		wqwqxkzxq0.setGxsj(wqwqxkzxq0Form.getGxsj());
		wqwqxkzxq0.setSubmit(wqwqxkzxq0Form.getSubmit());	
			wqwqxkzxq0Dao.update(wqwqxkzxq0);
		
	}
	/*blic void updateWqwqxkzxq0Withget(Wqwqxkzxq0Form Wqwqxkzxq0Form){
		Wqwqxkzxq0 Wqwqxkzxq0=Wqwqxkzxq0Dao.findObjectByID(Integer.valueOf(Wqwqxkzxq0Form.getId()));
		Wqwqxkzxq0.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		wqwqxkzxq0Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Wqwqxkzxq0Form wqwqxkzxq0Form){
		Wqwqxkzxq0 wqwqxkzxq0=new Wqwqxkzxq0();
		//Wqwqxkzxq0.setId(Integer.valueOf(Wqwqxkzxq0Form.getId()));
		wqwqxkzxq0.setDwmc(wqwqxkzxq0Form.getDwmc());
		wqwqxkzxq0.setQtmc(wqwqxkzxq0Form.getQtmc());
		wqwqxkzxq0.setDwdh(wqwqxkzxq0Form.getDwdh());
		wqwqxkzxq0.setScdz(wqwqxkzxq0Form.getScdz());
		wqwqxkzxq0.setJjxz(wqwqxkzxq0Form.getJjxz());
		wqwqxkzxq0.setFrdb(wqwqxkzxq0Form.getFrdb());
		wqwqxkzxq0.setDwdz(wqwqxkzxq0Form.getDwdz());
		wqwqxkzxq0.setYzbm(wqwqxkzxq0Form.getYzbm());
		wqwqxkzxq0.setLxr(wqwqxkzxq0Form.getLxr());
		wqwqxkzxq0.setLxdh(wqwqxkzxq0Form.getLxdh());
		wqwqxkzxq0.setZgzs(wqwqxkzxq0Form.getZgzs());
		wqwqxkzxq0.setGzgl(wqwqxkzxq0Form.getGzgl());
		wqwqxkzxq0.setZzgl(wqwqxkzxq0Form.getZzgl());
		wqwqxkzxq0.setCzgl(wqwqxkzxq0Form.getCzgl());
		wqwqxkzxq0.setGzjs(wqwqxkzxq0Form.getGzjs());
		wqwqxkzxq0.setZzjs(wqwqxkzxq0Form.getZzjs());
		wqwqxkzxq0.setCzjs(wqwqxkzxq0Form.getCzjs());
		wqwqxkzxq0.setGzgr(wqwqxkzxq0Form.getGzgr());
		wqwqxkzxq0.setZzgr(wqwqxkzxq0Form.getZzgr());
		wqwqxkzxq0.setCzgr(wqwqxkzxq0Form.getCzgr());
		wqwqxkzxq0.setGjjcgs(wqwqxkzxq0Form.getGjjcgs());
		wqwqxkzxq0.setSbjcgs(wqwqxkzxq0Form.getSbjcgs());
		wqwqxkzxq0.setJbqk(wqwqxkzxq0Form.getJbqk());
		wqwqxkzxq0.setKyfx(wqwqxkzxq0Form.getKyfx());
		wqwqxkzxq0.setQyscgl(wqwqxkzxq0Form.getQyscgl());
		wqwqxkzxq0.setKyzk(wqwqxkzxq0Form.getKyzk());
		wqwqxkzxq0.setZlglzk(wqwqxkzxq0Form.getZlglzk());
		wqwqxkzxq0.setBmaqzk(wqwqxkzxq0Form.getBmaqzk());
		wqwqxkzxq0.setJpyfqk(wqwqxkzxq0Form.getJpyfqk());
		wqwqxkzxq0.setJpzzqk(wqwqxkzxq0Form.getJpzzqk());
		wqwqxkzxq0.setJpjcqk(wqwqxkzxq0Form.getJpjcqk());
		wqwqxkzxq0.setWcjpqk(wqwqxkzxq0Form.getWcjpqk());
		wqwqxkzxq0.setXcjpxmqk(wqwqxkzxq0Form.getXcjpxmqk());
		wqwqxkzxq0.setJlnf(wqwqxkzxq0Form.getJlnf());
		wqwqxkzxq0.setUsername(wqwqxkzxq0Form.getUsername());
		wqwqxkzxq0.setGxsj(wqwqxkzxq0Form.getGxsj());
		wqwqxkzxq0.setSubmit(wqwqxkzxq0Form.getSubmit());
			wqwqxkzxq0Dao.save(wqwqxkzxq0);
	}
	private List<Wqwqxkzxq0Form> Wqwqxkzxq0POListToVOList(List<Wqwqxkzxq0> list) {
		// TODO Auto-generated method stub
		List<Wqwqxkzxq0Form> formlist=new ArrayList<Wqwqxkzxq0Form>();
		for(int i=0;i<list.size();i++){
Wqwqxkzxq0Form wqwqxkzxq0Form=new Wqwqxkzxq0Form();
			
			wqwqxkzxq0Form.setId(String.valueOf(list.get(i).getId()));
			wqwqxkzxq0Form.setDwmc(list.get(i).getDwmc());
			wqwqxkzxq0Form.setQtmc(list.get(i).getQtmc());
			wqwqxkzxq0Form.setDwdh(list.get(i).getDwdh());
			wqwqxkzxq0Form.setScdz(list.get(i).getScdz());
			wqwqxkzxq0Form.setJjxz(list.get(i).getJjxz());
			wqwqxkzxq0Form.setFrdb(list.get(i).getFrdb());
			wqwqxkzxq0Form.setDwdz(list.get(i).getDwdz());
			wqwqxkzxq0Form.setYzbm(list.get(i).getYzbm());
			wqwqxkzxq0Form.setLxr(list.get(i).getLxr());
			wqwqxkzxq0Form.setLxdh(list.get(i).getLxdh());
			wqwqxkzxq0Form.setZgzs(list.get(i).getZgzs());
			wqwqxkzxq0Form.setGzgl(list.get(i).getGzgl());
			wqwqxkzxq0Form.setZzgl(list.get(i).getZzgl());
			wqwqxkzxq0Form.setCzgl(list.get(i).getCzgl());
			wqwqxkzxq0Form.setGzjs(list.get(i).getGzjs());
			wqwqxkzxq0Form.setZzjs(list.get(i).getZzjs());
			wqwqxkzxq0Form.setCzjs(list.get(i).getCzjs());
			wqwqxkzxq0Form.setGzgr(list.get(i).getGzgr());
			wqwqxkzxq0Form.setZzgr(list.get(i).getZzgr());
			wqwqxkzxq0Form.setCzgr(list.get(i).getCzgr());
			wqwqxkzxq0Form.setGjjcgs(list.get(i).getGjjcgs());
			wqwqxkzxq0Form.setSbjcgs(list.get(i).getSbjcgs());
			wqwqxkzxq0Form.setJbqk(list.get(i).getJbqk());
			wqwqxkzxq0Form.setKyfx(list.get(i).getKyfx());
			wqwqxkzxq0Form.setQyscgl(list.get(i).getQyscgl());
			wqwqxkzxq0Form.setKyzk(list.get(i).getKyzk());
			wqwqxkzxq0Form.setZlglzk(list.get(i).getZlglzk());
			wqwqxkzxq0Form.setBmaqzk(list.get(i).getBmaqzk());
			wqwqxkzxq0Form.setJpyfqk(list.get(i).getJpyfqk());
			wqwqxkzxq0Form.setJpjcqk(list.get(i).getJpjcqk());
			wqwqxkzxq0Form.setJpzzqk(list.get(i).getJpzzqk());
			wqwqxkzxq0Form.setWcjpqk(list.get(i).getWcjpqk());
			wqwqxkzxq0Form.setXcjpxmqk(list.get(i).getXcjpxmqk());
			
			
			wqwqxkzxq0Form.setJlnf(list.get(i).getJlnf());
			wqwqxkzxq0Form.setUsername(list.get(i).getUsername());
			wqwqxkzxq0Form.setGxsj(list.get(i).getGxsj());
			wqwqxkzxq0Form.setSubmit(list.get(i).getSubmit());
			formlist.add(wqwqxkzxq0Form);
		}
		return formlist;
	}

	
}
