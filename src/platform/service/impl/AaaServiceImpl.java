package platform.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.AaaDao;
import platform.domain.Aaa;
import platform.domain.Kjrzxqcjb;
import platform.form.AaaForm;
import platform.form.KjdxyqxxbForm;
import platform.form.KjrzxqcjbForm;
import platform.service.AaaService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(AaaService.SERVICE_NAME)
public class AaaServiceImpl implements AaaService{
	
	@Resource(name=AaaDao.SERVICE_NAME)
	private AaaDao aaaDao;
	
	public List<AaaForm> findAaaList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.qyrq", "desc");
		List<Aaa> list=aaaDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<AaaForm> formlist=this.AaaPOListToVOList(list);
		return formlist;
		
	}
	public List<AaaForm> findAaaListWithPage(int pagesize,int pageno,AaaForm aaaForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(aaaForm!=null&&StringUtils.isNotBlank(aaaForm.getYqbh())){
			hqlWhere += " and o.yqbh like ?";
			paramsList.add("%"+aaaForm.getYqbh()+"%");
		}
		if(aaaForm!=null&&StringUtils.isNotBlank(aaaForm.getFlbm())){
			hqlWhere += " and o.flbm like ?";
			paramsList.add("%"+aaaForm.getFlbm()+"%");
		}
		orderby.put(" o.qyrq", "desc");
		params = paramsList.toArray();
		List<Aaa> list=aaaDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<AaaForm> formlist=this.AaaPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateAaa(AaaForm aaaForm){
		Aaa aaa=new Aaa();
		aaa.setYqbh(aaaForm.getYqbh());
		aaa.setFlbm(aaaForm.getFlbm());
		aaa.setQyrq(StringHelper.stringConvertDate(aaaForm.getQyrq()));
		aaa.setId(Integer.valueOf(aaaForm.getId()));
		aaa.setNbbh(aaaForm.getNbbh());
		aaa.setZwmc(aaaForm.getZwmc());
		aaa.setYwmc(aaaForm.getYwmc());
		aaa.setXhgg(aaaForm.getXhgg());
		aaa.setJszb(aaaForm.getJszb());
		aaa.setCsyjly(aaaForm.getCsyjly());
		aaa.setZyyt(aaaForm.getZyyt());
		aaa.setZyfjgn(aaaForm.getZyfjgn());
		aaa.setRzqk(aaaForm.getRzqk());
		aaa.setSccs(aaaForm.getSccs());
		aaa.setCdgb(aaaForm.getCdgb());
		aaa.setYqyz(aaaForm.getYqyz());
		aaa.setSzdwmc(aaaForm.getSzdwmc());
		aaa.setSysmc(aaaForm.getSysmc());
		aaa.setAfdz(aaaForm.getAfdz());
		aaa.setYzbm(aaaForm.getYzbm());
		aaa.setLxr(aaaForm.getLxr());
		aaa.setDh(aaaForm.getDh());
		aaa.setDzyj(aaaForm.getDzyj());
	//	if(!aaaForm.getNfwsr().equals(""))
	//	aaa.setSfgx(Integer.valueOf(aaaForm.getSfgx()));
		aaa.setSfgx(aaaForm.getSfgx());
		aaa.setYqzt(aaaForm.getYqzt());
		aaa.setKfjsap(aaaForm.getKfjsap());
		aaa.setCksfbz(aaaForm.getCksfbz());
		aaa.setFwtjnf(aaaForm.getFwtjnf());
		aaa.setNfwjs(aaaForm.getNfwjs());
	//	if(!aaaForm.getNfwsr().equals(""))
		//aaa.setNfwsr(Integer.valueOf(aaaForm.getNfwsr()));
		aaa.setNfwsr(aaaForm.getNfwsr());
		aaa.setZmyh(aaaForm.getZmyh());
		aaa.setYycg(aaaForm.getYycg());
		aaa.setYqtp(aaaForm.getYqtp());
		aaa.setBz(aaaForm.getBz());
		aaaDao.update(aaa);
		
	}
	public void deleteObject(String id){
		aaaDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(AaaForm aaaForm){
		Aaa aaa=new Aaa();
		aaa.setYqbh(aaaForm.getYqbh());
		aaa.setFlbm(aaaForm.getFlbm());
		aaa.setQyrq(StringHelper.stringConvertDate(aaaForm.getQyrq()));
		aaa.setNbbh(aaaForm.getNbbh());
		aaa.setZwmc(aaaForm.getZwmc());
		aaa.setYwmc(aaaForm.getYwmc());
		aaa.setXhgg(aaaForm.getXhgg());
		aaa.setJszb(aaaForm.getJszb());
		aaa.setCsyjly(aaaForm.getCsyjly());
		aaa.setZyyt(aaaForm.getZyyt());
		aaa.setZyfjgn(aaaForm.getZyfjgn());
		aaa.setRzqk(aaaForm.getRzqk());
		aaa.setSccs(aaaForm.getSccs());
		aaa.setCdgb(aaaForm.getCdgb());
		aaa.setYqyz(aaaForm.getYqyz());
		aaa.setSzdwmc(aaaForm.getSzdwmc());
		aaa.setSysmc(aaaForm.getSysmc());
		aaa.setAfdz(aaaForm.getAfdz());
		aaa.setYzbm(aaaForm.getYzbm());
		aaa.setLxr(aaaForm.getLxr());
		aaa.setDh(aaaForm.getDh());
		aaa.setDzyj(aaaForm.getDzyj());
		aaa.setSfgx(aaaForm.getSfgx());
		aaa.setYqzt(aaaForm.getYqzt());
		aaa.setKfjsap(aaaForm.getKfjsap());
		aaa.setCksfbz(aaaForm.getCksfbz());
		aaa.setFwtjnf(aaaForm.getFwtjnf());
		aaa.setNfwjs(aaaForm.getNfwjs());
		aaa.setNfwsr(aaaForm.getNfwsr());
		aaa.setZmyh(aaaForm.getZmyh());
		aaa.setYycg(aaaForm.getYycg());
		aaa.setYqtp(aaaForm.getYqtp());
		aaa.setBz(aaaForm.getBz());
		aaaDao.save(aaa);
	}
	private List<AaaForm> AaaPOListToVOList(List<Aaa> list) {
		// TODO Auto-generated method stub
		List<AaaForm> formlist=new ArrayList<AaaForm>();
		for(int i=0;i<list.size();i++){
			Aaa aaa=list.get(i);
			AaaForm aaaForm=new AaaForm();
			aaaForm.setYqbh(aaa.getYqbh());
			aaaForm.setFlbm(aaa.getFlbm());
			aaaForm.setQyrq(String.valueOf(aaa.getQyrq()));
			aaaForm.setId(String.valueOf(aaa.getId()));
			aaaForm.setNbbh(aaa.getNbbh());
			aaaForm.setZwmc(aaa.getZwmc());
			aaaForm.setYwmc(aaa.getYwmc());
			aaaForm.setXhgg(aaa.getXhgg());
			aaaForm.setJszb(aaa.getJszb());
			aaaForm.setCsyjly(aaa.getCsyjly());
			aaaForm.setZyyt(aaa.getZyyt());
			aaaForm.setZyfjgn(aaa.getZyfjgn());
			aaaForm.setRzqk(aaa.getRzqk());
			aaaForm.setSccs(aaa.getSccs());
			aaaForm.setCdgb(aaa.getCdgb());
			aaaForm.setYqyz(aaa.getYqyz());
			aaaForm.setSzdwmc(aaa.getSzdwmc());
			aaaForm.setSysmc(aaa.getSysmc());
			aaaForm.setAfdz(aaa.getAfdz());
			aaaForm.setYzbm(aaa.getYzbm());
			aaaForm.setLxr(aaa.getLxr());
			aaaForm.setDh(aaa.getDh());
			aaaForm.setDzyj(aaa.getDzyj());
			aaaForm.setSfgx(aaa.getSfgx());
			aaaForm.setYqzt(aaa.getYqzt());
			aaaForm.setKfjsap(aaa.getKfjsap());
			aaaForm.setCksfbz(aaa.getCksfbz());
			aaaForm.setFwtjnf(aaa.getFwtjnf());
			aaaForm.setNfwjs(aaa.getNfwjs());
			aaaForm.setNfwsr(aaa.getNfwsr());
			aaaForm.setZmyh(aaa.getZmyh());
			aaaForm.setYycg(aaa.getYycg());
			aaaForm.setYqtp(aaa.getYqtp());
			aaaForm.setBz(aaa.getBz());
			formlist.add(aaaForm);
			
		}
		return formlist;
	}

	
}
