package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjzzqcgcjbDao;
import platform.domain.Kjzzqcgcjb;
import platform.form.KjzzqcgcjbForm;
import platform.service.KjzzqcgcjbService;
import platform.util.StringHelper;

@Service(KjzzqcgcjbService.SERVICE_NAME)
public class KjzzqcgcjbServiceImpl implements KjzzqcgcjbService{
	
	@Resource(name=KjzzqcgcjbDao.SERVICE_NAME)
	private KjzzqcgcjbDao kjzzqcgcjbDao;
	
	public List<KjzzqcgcjbForm> findKjzzqcgcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zywcr", "desc");
		List<Kjzzqcgcjb> list=kjzzqcgcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjzzqcgcjbForm> formlist=this.KjzzqcgcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjzzqcgcjbForm> findKjzzqcgcjbListWithPage(int pagesize,int pageno,KjzzqcgcjbForm kjzzqcgcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjzzqcgcjbForm!=null&&StringUtils.isNotBlank(kjzzqcgcjbForm.getCgmc())){
			hqlWhere += " and o.cgmc like ?";
			paramsList.add("%"+kjzzqcgcjbForm.getCgmc()+"%");
		}
		if(kjzzqcgcjbForm!=null&&StringUtils.isNotBlank(kjzzqcgcjbForm.getWcdw())){
			hqlWhere += " and o.wcdw like ?";
			paramsList.add("%"+kjzzqcgcjbForm.getWcdw()+"%");
		}
		orderby.put(" o.zywcr", "desc");
		params = paramsList.toArray();
		List<Kjzzqcgcjb> list=kjzzqcgcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjzzqcgcjbForm> formlist=this.KjzzqcgcjbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjzzqcgcjb(KjzzqcgcjbForm kjzzqcgcjbForm){
		Kjzzqcgcjb kjzzqcgcjb=new Kjzzqcgcjb();
		
		kjzzqcgcjb.setId(Integer.valueOf(kjzzqcgcjbForm.getId()));
		
		
		kjzzqcgcjb.setCgmc(kjzzqcgcjbForm.getCgmc());
		kjzzqcgcjb.setWcdw(kjzzqcgcjbForm.getWcdw());
		kjzzqcgcjb.setZywcr(kjzzqcgcjbForm.getZywcr());
		kjzzqcgcjb.setWcsj(StringHelper.stringConvertDate(kjzzqcgcjbForm.getWcsj()));
		kjzzqcgcjb.setRzbh(kjzzqcgcjbForm.getRzbh());
		kjzzqcgcjb.setCgjj(kjzzqcgcjbForm.getCgjj());
		kjzzqcgcjb.setYyhy(kjzzqcgcjbForm.getYyhy());
		kjzzqcgcjb.setJsly(kjzzqcgcjbForm.getJsly());
		kjzzqcgcjb.setCgjd(kjzzqcgcjbForm.getCgjd());
		kjzzqcgcjb.setJyfs(kjzzqcgcjbForm.getJyfs());
		kjzzqcgcjb.setSfzj(Integer.valueOf(kjzzqcgcjbForm.getSfzj()));
		kjzzqcgcjb.setGfdj(kjzzqcgcjbForm.getGfdj());
		kjzzqcgcjb.setZhyq(kjzzqcgcjbForm.getZhyq());
		kjzzqcgcjb.setSfgk(Integer.valueOf(kjzzqcgcjbForm.getSfgk()));
		kjzzqcgcjb.setFbrxz(Integer.valueOf(kjzzqcgcjbForm.getFbrxz()));
		kjzzqcgcjb.setLxrxm(kjzzqcgcjbForm.getLxrxm());
		kjzzqcgcjb.setGddh(kjzzqcgcjbForm.getGddh());
		kjzzqcgcjb.setSzdq(kjzzqcgcjbForm.getSzdq());
		kjzzqcgcjb.setSj(kjzzqcgcjbForm.getSj());
		kjzzqcgcjb.setDzyx(kjzzqcgcjbForm.getDzyx());
		kjzzqcgcjb.setLxdz(kjzzqcgcjbForm.getLxdz());

		
		
		
		kjzzqcgcjbDao.update(kjzzqcgcjb);
		
	}
	public void deleteObject(String id){
		kjzzqcgcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjzzqcgcjbForm kjzzqcgcjbForm){
		Kjzzqcgcjb kjzzqcgcjb=new Kjzzqcgcjb();
		kjzzqcgcjb.setCgmc(kjzzqcgcjbForm.getCgmc());
		kjzzqcgcjb.setWcdw(kjzzqcgcjbForm.getWcdw());
		kjzzqcgcjb.setZywcr(kjzzqcgcjbForm.getZywcr());
		kjzzqcgcjb.setWcsj(StringHelper.stringConvertDate(kjzzqcgcjbForm.getWcsj()));
		kjzzqcgcjb.setRzbh(kjzzqcgcjbForm.getRzbh());
		kjzzqcgcjb.setCgjj(kjzzqcgcjbForm.getCgjj());
		kjzzqcgcjb.setYyhy(kjzzqcgcjbForm.getYyhy());
		kjzzqcgcjb.setJsly(kjzzqcgcjbForm.getJsly());
		kjzzqcgcjb.setCgjd(kjzzqcgcjbForm.getCgjd());
		kjzzqcgcjb.setJyfs(kjzzqcgcjbForm.getJyfs());
		
		if(kjzzqcgcjbForm.getSfzj()!=null)
		kjzzqcgcjb.setSfzj(Integer.valueOf(kjzzqcgcjbForm.getSfzj()));
		kjzzqcgcjb.setGfdj(kjzzqcgcjbForm.getGfdj());
		kjzzqcgcjb.setZhyq(kjzzqcgcjbForm.getZhyq());
		
		if(!kjzzqcgcjbForm.getSfgk().equals(""))
		kjzzqcgcjb.setSfgk(Integer.valueOf(kjzzqcgcjbForm.getSfgk()));
		
		if(!kjzzqcgcjbForm.getFbrxz().equals(""))
		kjzzqcgcjb.setFbrxz(Integer.valueOf(kjzzqcgcjbForm.getFbrxz()));
		kjzzqcgcjb.setLxrxm(kjzzqcgcjbForm.getLxrxm());
		kjzzqcgcjb.setGddh(kjzzqcgcjbForm.getGddh());
		kjzzqcgcjb.setSzdq(kjzzqcgcjbForm.getSzdq());
		kjzzqcgcjb.setSj(kjzzqcgcjbForm.getSj());
		kjzzqcgcjb.setDzyx(kjzzqcgcjbForm.getDzyx());
		kjzzqcgcjb.setLxdz(kjzzqcgcjbForm.getLxdz());
		
		kjzzqcgcjbDao.save(kjzzqcgcjb);
	}
	private List<KjzzqcgcjbForm> KjzzqcgcjbPOListToVOList(List<Kjzzqcgcjb> list) {
		// TODO Auto-generated method stub
		List<KjzzqcgcjbForm> formlist=new ArrayList<KjzzqcgcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjzzqcgcjb kjzzqcgcjb=list.get(i);
			KjzzqcgcjbForm kjzzqcgcjbForm=new KjzzqcgcjbForm();
			
			kjzzqcgcjbForm.setId(String.valueOf(kjzzqcgcjb.getId()));
			kjzzqcgcjbForm.setCgmc(kjzzqcgcjb.getCgmc());
			kjzzqcgcjbForm.setWcdw(kjzzqcgcjb.getWcdw());
			kjzzqcgcjbForm.setZywcr(kjzzqcgcjb.getZywcr());
			kjzzqcgcjbForm.setWcsj(String.valueOf(kjzzqcgcjb.getWcsj()));
			kjzzqcgcjbForm.setRzbh(kjzzqcgcjb.getRzbh());
			kjzzqcgcjbForm.setCgjj(kjzzqcgcjb.getCgjj());
			kjzzqcgcjbForm.setYyhy(kjzzqcgcjb.getYyhy());
			kjzzqcgcjbForm.setJsly(kjzzqcgcjb.getJsly());
			kjzzqcgcjbForm.setCgjd(kjzzqcgcjb.getCgjd());
			kjzzqcgcjbForm.setJyfs(kjzzqcgcjb.getJyfs());
			kjzzqcgcjbForm.setSfzj(String.valueOf(kjzzqcgcjb.getSfzj()));
			kjzzqcgcjbForm.setGfdj(kjzzqcgcjb.getGfdj());
			kjzzqcgcjbForm.setZhyq(kjzzqcgcjb.getZhyq());
			kjzzqcgcjbForm.setSfgk(String.valueOf(kjzzqcgcjb.getSfgk()));
			kjzzqcgcjbForm.setFbrxz(String.valueOf(kjzzqcgcjb.getFbrxz()));
			kjzzqcgcjbForm.setLxrxm(kjzzqcgcjb.getLxrxm());
			kjzzqcgcjbForm.setGddh(kjzzqcgcjb.getGddh());
			kjzzqcgcjbForm.setSzdq(kjzzqcgcjb.getSzdq());
			kjzzqcgcjbForm.setSj(kjzzqcgcjb.getSj());
			kjzzqcgcjbForm.setDzyx(kjzzqcgcjb.getDzyx());
			kjzzqcgcjbForm.setLxdz(kjzzqcgcjb.getLxdz());
			
			
			formlist.add(kjzzqcgcjbForm);
		}
		return formlist;
	}

	
}
