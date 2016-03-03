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

import platform.dao.KjqtcgcjbDao;
import platform.domain.Kjqtcgcjb;
import platform.form.KjqtcgcjbForm;
import platform.service.KjqtcgcjbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjqtcgcjbService.SERVICE_NAME)
public class KjqtcgcjbServiceImpl implements KjqtcgcjbService{
	
	@Resource(name=KjqtcgcjbDao.SERVICE_NAME)
	private KjqtcgcjbDao kjqtcgcjbDao;
	
	public List<KjqtcgcjbForm> findKjqtcgcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.wcsj", "desc");
		List<Kjqtcgcjb> list=kjqtcgcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjqtcgcjbForm> formlist=this.KjqtcgcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjqtcgcjbForm> findKjqtcgcjbListWithPage(int pagesize,int pageno,KjqtcgcjbForm kjqtcgcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjqtcgcjbForm!=null&&StringUtils.isNotBlank(kjqtcgcjbForm.getWcdw())){
			hqlWhere += " and o.wcdw like ?";
			paramsList.add("%"+kjqtcgcjbForm.getWcdw()+"%");
		}
		if(kjqtcgcjbForm!=null&&StringUtils.isNotBlank(kjqtcgcjbForm.getZywcr())){
			hqlWhere += " and o.zywcr like ?";
			paramsList.add("%"+kjqtcgcjbForm.getZywcr()+"%");
		}
		orderby.put(" o.wcsj", "desc");
		params = paramsList.toArray();
		List<Kjqtcgcjb> list=kjqtcgcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjqtcgcjbForm> formlist=this.KjqtcgcjbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjqtcgcjb(KjqtcgcjbForm kjqtcgcjbForm,String username){
		Kjqtcgcjb kjqtcgcjb=new Kjqtcgcjb();
		kjqtcgcjb.setId(Integer.valueOf(kjqtcgcjbForm.getId()));
		kjqtcgcjb.setCgmc(kjqtcgcjbForm.getCgmc());
		kjqtcgcjb.setWcdw(kjqtcgcjbForm.getWcdw());
		kjqtcgcjb.setZywcr(kjqtcgcjbForm.getZywcr());
		kjqtcgcjb.setWcsj(StringHelper.stringConvertDate2(kjqtcgcjbForm.getWcsj()));
		
		kjqtcgcjb.setCgjj(kjqtcgcjbForm.getCgjj());
		kjqtcgcjb.setYyhy(kjqtcgcjbForm.getYyhy());
		kjqtcgcjb.setJsly(kjqtcgcjbForm.getJsly());
		kjqtcgcjb.setCgjd(kjqtcgcjbForm.getCgjd());
		kjqtcgcjb.setZhfs(kjqtcgcjbForm.getZhfs());
		kjqtcgcjb.setSfzj(kjqtcgcjbForm.getSfzj());
		kjqtcgcjb.setGfdj(kjqtcgcjbForm.getGfdj());
		kjqtcgcjb.setZhyq(kjqtcgcjbForm.getZhyq());
		kjqtcgcjb.setSfgk(kjqtcgcjbForm.getSfgk());
		kjqtcgcjb.setFbrxz(kjqtcgcjbForm.getFbrxz());
		kjqtcgcjb.setLxrxm(kjqtcgcjbForm.getLxrxm());
		kjqtcgcjb.setGddh(kjqtcgcjbForm.getGddh());
		kjqtcgcjb.setSzdq(kjqtcgcjbForm.getSzdq());
		kjqtcgcjb.setSj(kjqtcgcjbForm.getSj());
		kjqtcgcjb.setDzyx(kjqtcgcjbForm.getDzyx());
		kjqtcgcjb.setLxdz(kjqtcgcjbForm.getLxdz());
		
		kjqtcgcjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjqtcgcjb.setUsername(username);
		kjqtcgcjb.setGxsj(new Date().toString());
		kjqtcgcjb.setSubmit(0);
		kjqtcgcjb.setZjdw(kjqtcgcjbForm.getZjdw());
		kjqtcgcjb.setZjlxr(kjqtcgcjbForm.getZjlxr());
		kjqtcgcjbDao.update(kjqtcgcjb);
		
	}
	public void deleteObject(String id){
		kjqtcgcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjqtcgcjbForm kjqtcgcjbForm,String username){
		Kjqtcgcjb kjqtcgcjb=new Kjqtcgcjb();
		kjqtcgcjb.setCgmc(kjqtcgcjbForm.getCgmc());
		kjqtcgcjb.setWcdw(kjqtcgcjbForm.getWcdw());
		kjqtcgcjb.setZywcr(kjqtcgcjbForm.getZywcr());
		kjqtcgcjb.setWcsj(StringHelper.stringConvertDate2(kjqtcgcjbForm.getWcsj()));
        kjqtcgcjb.setCgjj(kjqtcgcjbForm.getCgjj());
		kjqtcgcjb.setYyhy(kjqtcgcjbForm.getYyhy());
		kjqtcgcjb.setJsly(kjqtcgcjbForm.getJsly());
		kjqtcgcjb.setCgjd(kjqtcgcjbForm.getCgjd());
		kjqtcgcjb.setZhfs(kjqtcgcjbForm.getZhfs());
		kjqtcgcjb.setSfzj(kjqtcgcjbForm.getSfzj());
		kjqtcgcjb.setGfdj(kjqtcgcjbForm.getGfdj());
		kjqtcgcjb.setZhyq(kjqtcgcjbForm.getZhyq());
		kjqtcgcjb.setSfgk(kjqtcgcjbForm.getSfgk());
		kjqtcgcjb.setFbrxz(kjqtcgcjbForm.getFbrxz());
		kjqtcgcjb.setLxrxm(kjqtcgcjbForm.getLxrxm());
		kjqtcgcjb.setGddh(kjqtcgcjbForm.getGddh());
		kjqtcgcjb.setSzdq(kjqtcgcjbForm.getSzdq());
		kjqtcgcjb.setSj(kjqtcgcjbForm.getSj());
		kjqtcgcjb.setDzyx(kjqtcgcjbForm.getDzyx());
		kjqtcgcjb.setLxdz(kjqtcgcjbForm.getLxdz());
		kjqtcgcjb.setZjdw(kjqtcgcjbForm.getZjdw());
		kjqtcgcjb.setZjlxr(kjqtcgcjbForm.getZjlxr());
		kjqtcgcjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjqtcgcjb.setUsername(username);
		kjqtcgcjb.setGxsj(new Date().toString());
		kjqtcgcjb.setSubmit(0);
		
		
		try{
		kjqtcgcjbDao.save(kjqtcgcjb);
		}catch(Exception e){
			System.out.println(e);
		}
	
		}
	private List<KjqtcgcjbForm> KjqtcgcjbPOListToVOList(List<Kjqtcgcjb> list) {
		// TODO Auto-generated method stub
		List<KjqtcgcjbForm> formlist=new ArrayList<KjqtcgcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjqtcgcjb kjqtcgcjb=list.get(i);
			KjqtcgcjbForm kjqtcgcjbForm=new KjqtcgcjbForm();
			kjqtcgcjbForm.setId(String.valueOf(kjqtcgcjb.getId()));
			kjqtcgcjbForm.setCgmc(kjqtcgcjb.getCgmc());
			kjqtcgcjbForm.setWcdw(kjqtcgcjb.getWcdw());
			kjqtcgcjbForm.setZywcr(kjqtcgcjb.getZywcr());
			kjqtcgcjbForm.setWcsj(String.valueOf(kjqtcgcjb.getWcsj()));
			kjqtcgcjbForm.setCgjj(kjqtcgcjb.getCgjj());
			kjqtcgcjbForm.setYyhy(kjqtcgcjb.getYyhy());
			kjqtcgcjbForm.setJsly(kjqtcgcjb.getJsly());
			kjqtcgcjbForm.setCgjd(kjqtcgcjb.getCgjd());
			kjqtcgcjbForm.setZhfs(kjqtcgcjb.getZhfs());
			kjqtcgcjbForm.setSfzj(kjqtcgcjb.getSfzj());
			kjqtcgcjbForm.setGfdj(kjqtcgcjb.getGfdj());
			kjqtcgcjbForm.setZhyq(kjqtcgcjb.getZhyq());
			kjqtcgcjbForm.setSfgk(kjqtcgcjb.getSfgk());
			kjqtcgcjbForm.setFbrxz(kjqtcgcjb.getFbrxz());
			kjqtcgcjbForm.setLxrxm(kjqtcgcjb.getLxrxm());
			kjqtcgcjbForm.setGddh(kjqtcgcjb.getGddh());
			kjqtcgcjbForm.setSzdq(kjqtcgcjb.getSzdq());
			kjqtcgcjbForm.setSj(kjqtcgcjb.getSj());
			kjqtcgcjbForm.setDzyx(kjqtcgcjb.getDzyx());
			kjqtcgcjbForm.setLxdz(kjqtcgcjb.getLxdz());
			
			kjqtcgcjbForm.setJlnf(kjqtcgcjb.getJlnf());
			kjqtcgcjbForm.setUsername(kjqtcgcjb.getUsername());
			kjqtcgcjbForm.setGxsj(kjqtcgcjb.getGxsj());
			kjqtcgcjbForm.setSubmit(String.valueOf(kjqtcgcjb.getSubmit()));
			
			kjqtcgcjbForm.setZjdw(kjqtcgcjb.getZjdw());
			kjqtcgcjbForm.setZjlxr(kjqtcgcjb.getZjlxr());
			
			formlist.add(kjqtcgcjbForm);
		}
		return formlist;
	}
	
	}

	
