package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjrzxqcjbDao;
import platform.domain.Kjrzxqcjb;
import platform.form.KjrzxqcjbForm;
import platform.service.KjrzxqcjbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjrzxqcjbService.SERVICE_NAME)
public class KjrzxqcjbServiceImpl implements KjrzxqcjbService{
	
	@Resource(name=KjrzxqcjbDao.SERVICE_NAME)
	private KjrzxqcjbDao kjrzxqcjbDao;
	
	public List<KjrzxqcjbForm> findKjrzxqcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zcsj", "desc");
		List<Kjrzxqcjb> list=kjrzxqcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjrzxqcjbForm> formlist=this.KjrzxqcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjrzxqcjbForm> findKjrzxqcjbListWithPage(int pagesize,int pageno,KjrzxqcjbForm kjrzxqcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjrzxqcjbForm!=null&&StringUtils.isNotBlank(kjrzxqcjbForm.getQymc())){
			hqlWhere += " and o.qymc like ?";
			paramsList.add("%"+kjrzxqcjbForm.getQymc()+"%");
		}
		if(kjrzxqcjbForm!=null&&StringUtils.isNotBlank(kjrzxqcjbForm.getQylx())){
			hqlWhere += " and o.qylx like ?";
			paramsList.add("%"+kjrzxqcjbForm.getQylx()+"%");
		}
		orderby.put(" o.zcsj", "desc");
		params = paramsList.toArray();
		List<Kjrzxqcjb> list=kjrzxqcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjrzxqcjbForm> formlist=this.KjrzxqcjbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjrzxqcjb(KjrzxqcjbForm kjrzxqcjbForm){
		Kjrzxqcjb kjrzxqcjb=new Kjrzxqcjb();
		kjrzxqcjb.setId(Integer.valueOf(kjrzxqcjbForm.getId()));
		kjrzxqcjb.setQymc(kjrzxqcjbForm.getQymc());
		kjrzxqcjb.setQylx(kjrzxqcjbForm.getQylx());
		kjrzxqcjb.setQytz(kjrzxqcjbForm.getQytz());
		kjrzxqcjb.setZczb(kjrzxqcjbForm.getZczb());
		kjrzxqcjb.setZcsj(StringHelper.stringConvertDate2(kjrzxqcjbForm.getZcsj()));
		kjrzxqcjb.setYgzs(kjrzxqcjbForm.getYgzs());
		kjrzxqcjb.setRzed(kjrzxqcjbForm.getRzed());
		kjrzxqcjb.setZjyt(kjrzxqcjbForm.getZjyt());
		kjrzxqcjb.setRzfs(kjrzxqcjbForm.getRzfs());
		kjrzxqcjb.setXmjj(kjrzxqcjbForm.getXmjj());
		kjrzxqcjb.setSfgk(kjrzxqcjbForm.getSfgk());
		kjrzxqcjb.setXmlxr(kjrzxqcjbForm.getXmlxr());
		kjrzxqcjb.setGddh(kjrzxqcjbForm.getGddh());
		kjrzxqcjb.setSj(kjrzxqcjbForm.getSj());
		kjrzxqcjb.setDzyx(kjrzxqcjbForm.getDzyx());
		kjrzxqcjb.setLxdz(kjrzxqcjbForm.getLxdz());
		kjrzxqcjbDao.update(kjrzxqcjb);
		
	}
	public void deleteObject(String id){
		kjrzxqcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjrzxqcjbForm kjrzxqcjbForm){
		Kjrzxqcjb kjrzxqcjb=new Kjrzxqcjb();
		kjrzxqcjb.setQymc(kjrzxqcjbForm.getQymc());
		kjrzxqcjb.setQylx(kjrzxqcjbForm.getQylx());
		kjrzxqcjb.setQytz(kjrzxqcjbForm.getQytz());
		kjrzxqcjb.setZczb(kjrzxqcjbForm.getZczb());
		kjrzxqcjb.setZcsj(StringHelper.stringConvertDate2(kjrzxqcjbForm.getZcsj()));
		kjrzxqcjb.setYgzs(kjrzxqcjbForm.getYgzs());
		kjrzxqcjb.setRzed(kjrzxqcjbForm.getRzed());
		kjrzxqcjb.setZjyt(kjrzxqcjbForm.getZjyt());
		kjrzxqcjb.setRzfs(kjrzxqcjbForm.getRzfs());
		kjrzxqcjb.setXmjj(kjrzxqcjbForm.getXmjj());
		kjrzxqcjb.setSfgk(kjrzxqcjbForm.getSfgk());
		kjrzxqcjb.setXmlxr(kjrzxqcjbForm.getXmlxr());
		kjrzxqcjb.setGddh(kjrzxqcjbForm.getGddh());
		kjrzxqcjb.setSj(kjrzxqcjbForm.getSj());
		kjrzxqcjb.setDzyx(kjrzxqcjbForm.getDzyx());
		kjrzxqcjb.setLxdz(kjrzxqcjbForm.getLxdz());
		kjrzxqcjbDao.save(kjrzxqcjb);
	}
	private List<KjrzxqcjbForm>KjrzxqcjbPOListToVOList(List<Kjrzxqcjb> list) {
		// TODO Auto-generated method stub
		List<KjrzxqcjbForm> formlist=new ArrayList<KjrzxqcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjrzxqcjb kjrzxqcjb=list.get(i);
			KjrzxqcjbForm kjrzxqcjbForm=new KjrzxqcjbForm();
			
			kjrzxqcjbForm.setId(String.valueOf(kjrzxqcjb.getId()));
			kjrzxqcjbForm.setQymc(kjrzxqcjb.getQymc());
			kjrzxqcjbForm.setQylx(kjrzxqcjb.getQylx());
			kjrzxqcjbForm.setQytz(kjrzxqcjb.getQytz());
			kjrzxqcjbForm.setZczb(kjrzxqcjb.getZczb());
			kjrzxqcjbForm.setZcsj(String.valueOf(kjrzxqcjb.getZcsj()));
			kjrzxqcjbForm.setYgzs(kjrzxqcjb.getYgzs());
			kjrzxqcjbForm.setRzed(kjrzxqcjb.getRzed());
			kjrzxqcjbForm.setZjyt(kjrzxqcjb.getZjyt());
			kjrzxqcjbForm.setRzfs(kjrzxqcjb.getRzfs());
			kjrzxqcjbForm.setXmjj(kjrzxqcjb.getXmjj());
			kjrzxqcjbForm.setSfgk(kjrzxqcjb.getSfgk());
			kjrzxqcjbForm.setXmlxr(kjrzxqcjb.getXmlxr());
			kjrzxqcjbForm.setGddh(kjrzxqcjb.getGddh());
			kjrzxqcjbForm.setSj(kjrzxqcjb.getSj());
			kjrzxqcjbForm.setDzyx(kjrzxqcjb.getDzyx());
			kjrzxqcjbForm.setLxdz(kjrzxqcjb.getLxdz());
		
			formlist.add(kjrzxqcjbForm);
		}
		return formlist;
	}

	
}
