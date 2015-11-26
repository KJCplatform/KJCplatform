package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjcgcjbDao;
import platform.domain.Kjcgcjb;
import platform.form.KjcgcjbForm;
import platform.service.KjcgcjbService;
import platform.util.StringHelper;

@Service(KjcgcjbService.SERVICE_NAME)
public class KjcgcjbServiceImpl implements KjcgcjbService{
	
	@Resource(name=KjcgcjbDao.SERVICE_NAME)
	private KjcgcjbDao kjcgcjbDao;
	
	public List<KjcgcjbForm> findKjcgcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zywcr", "desc");
		List<Kjcgcjb> list=kjcgcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjcgcjbForm> formlist=this.KjcgcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjcgcjbForm> findKjcgcjbListWithPage(int pagesize,int pageno,KjcgcjbForm kjcgcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjcgcjbForm!=null&&StringUtils.isNotBlank(kjcgcjbForm.getCgmc())){
			hqlWhere += " and o.cgmc like ?";
			paramsList.add("%"+kjcgcjbForm.getCgmc()+"%");
		}
		if(kjcgcjbForm!=null&&StringUtils.isNotBlank(kjcgcjbForm.getWcdw())){
			hqlWhere += " and o.wcdw like ?";
			paramsList.add("%"+kjcgcjbForm.getWcdw()+"%");
		}
		orderby.put(" o.zywcr", "desc");
		params = paramsList.toArray();
		List<Kjcgcjb> list=kjcgcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjcgcjbForm> formlist=this.KjcgcjbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjcgcjb(KjcgcjbForm kjcgcjbForm){
		Kjcgcjb kjcgcjb=new Kjcgcjb();
		
		kjcgcjb.setId(Integer.valueOf(kjcgcjbForm.getId()));
		
		kjcgcjb.setCgmc(kjcgcjbForm.getCgmc());
		kjcgcjb.setWcdw(kjcgcjbForm.getWcdw());
		kjcgcjb.setZywcr(kjcgcjbForm.getZywcr());
		kjcgcjb.setWcsj(StringHelper.stringConvertDate2(kjcgcjbForm.getWcsj()));
		kjcgcjb.setDjjdh(kjcgcjbForm.getDjjdh());
		kjcgcjb.setTxxs(kjcgcjbForm.getTxxs());
		kjcgcjb.setCgjj(kjcgcjbForm.getCgjj());
		kjcgcjb.setYyhy(kjcgcjbForm.getYyhy());
		kjcgcjb.setJsly(kjcgcjbForm.getJsly());
		kjcgcjb.setCgjd(kjcgcjbForm.getCgjd());
		kjcgcjb.setJyfs(kjcgcjbForm.getJyfs());
		
		//数据校验
		if(kjcgcjbForm.getSfzj()!=null){
		if(kjcgcjbForm.getSfzj().equals("是"))
			kjcgcjb.setSfzj(1);
		else if(kjcgcjbForm.getSfzj().equals("否"))
			kjcgcjb.setSfzj(0);
		}
		kjcgcjb.setGfdj(kjcgcjbForm.getGfdj());
		kjcgcjb.setZhyq(kjcgcjbForm.getZhyq());
		
		//数据校验
		if(kjcgcjbForm.getSfgk()!=null)
		{
			if(kjcgcjbForm.getSfgk().equals("是"))
				kjcgcjb.setSfgk(1);
			else if(kjcgcjbForm.getSfgk().equals("否"))
				kjcgcjb.setSfgk(0);
		}
		if(kjcgcjbForm.getFbrxz()!=null&&!kjcgcjbForm.getFbrxz().equals(""))
		kjcgcjb.setFbrxz(Integer.valueOf(kjcgcjbForm.getFbrxz()));
		kjcgcjb.setLxrxm(kjcgcjbForm.getLxrxm());
		kjcgcjb.setGddh(kjcgcjbForm.getGddh());
		kjcgcjb.setSzdq(kjcgcjbForm.getSzdq());
		kjcgcjb.setSj(kjcgcjbForm.getSj());
		kjcgcjb.setDzyx(kjcgcjbForm.getDzyx());
		kjcgcjb.setLxdz(kjcgcjbForm.getLxdz());
		
		kjcgcjbDao.update(kjcgcjb);
		
	}
	public void deleteObject(String id){
		kjcgcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjcgcjbForm kjcgcjbForm){
		Kjcgcjb kjcgcjb=new Kjcgcjb();
		kjcgcjb.setCgmc(kjcgcjbForm.getCgmc());
		kjcgcjb.setWcdw(kjcgcjbForm.getWcdw());
		kjcgcjb.setZywcr(kjcgcjbForm.getZywcr());
		kjcgcjb.setWcsj(StringHelper.stringConvertDate2(kjcgcjbForm.getWcsj()));
		kjcgcjb.setDjjdh(kjcgcjbForm.getDjjdh());
		kjcgcjb.setTxxs(kjcgcjbForm.getTxxs());
		kjcgcjb.setCgjj(kjcgcjbForm.getCgjj());
		kjcgcjb.setYyhy(kjcgcjbForm.getYyhy());
		kjcgcjb.setJsly(kjcgcjbForm.getJsly());
		kjcgcjb.setCgjd(kjcgcjbForm.getCgjd());
		kjcgcjb.setJyfs(kjcgcjbForm.getJyfs());
		
		//数据校验
		if(kjcgcjbForm.getSfzj()!=null){
		if(kjcgcjbForm.getSfzj().equals("是"))
			kjcgcjb.setSfzj(1);
		else if(kjcgcjbForm.getSfzj().equals("否"))
			kjcgcjb.setSfzj(0);
		}
		kjcgcjb.setGfdj(kjcgcjbForm.getGfdj());
		kjcgcjb.setZhyq(kjcgcjbForm.getZhyq());
		
		//数据校验
		if(kjcgcjbForm.getSfgk()!=null)
		{
			if(kjcgcjbForm.getSfgk().equals("是"))
				kjcgcjb.setSfgk(1);
			else if(kjcgcjbForm.getSfgk().equals("否"))
				kjcgcjb.setSfgk(0);
		}
		
		if(kjcgcjbForm.getFbrxz()!=null&&!kjcgcjbForm.getFbrxz().equals(""))
		kjcgcjb.setFbrxz(Integer.valueOf(kjcgcjbForm.getFbrxz()));
		kjcgcjb.setLxrxm(kjcgcjbForm.getLxrxm());
		kjcgcjb.setGddh(kjcgcjbForm.getGddh());
		kjcgcjb.setSzdq(kjcgcjbForm.getSzdq());
		kjcgcjb.setSj(kjcgcjbForm.getSj());
		kjcgcjb.setDzyx(kjcgcjbForm.getDzyx());
		kjcgcjb.setLxdz(kjcgcjbForm.getLxdz());
		kjcgcjbDao.save(kjcgcjb);
	}
	private List<KjcgcjbForm> KjcgcjbPOListToVOList(List<Kjcgcjb> list) {
		// TODO Auto-generated method stub
		List<KjcgcjbForm> formlist=new ArrayList<KjcgcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjcgcjb kjcgcjb=list.get(i);
			 
			KjcgcjbForm kjcgcjbForm=new KjcgcjbForm();
			
			kjcgcjbForm.setId(String.valueOf(kjcgcjb.getId()));
			kjcgcjbForm.setCgmc(kjcgcjb.getCgmc());
			kjcgcjbForm.setWcdw(kjcgcjb.getWcdw());
			kjcgcjbForm.setZywcr(kjcgcjb.getZywcr());
			kjcgcjbForm.setWcsj(String.valueOf(kjcgcjb.getWcsj()));
			kjcgcjbForm.setDjjdh(kjcgcjb.getDjjdh());
			kjcgcjbForm.setTxxs(kjcgcjb.getTxxs());
			kjcgcjbForm.setCgjj(kjcgcjb.getCgjj());
			kjcgcjbForm.setYyhy(kjcgcjb.getYyhy());
			kjcgcjbForm.setJsly(kjcgcjb.getJsly());
			kjcgcjbForm.setCgjd(kjcgcjb.getCgjd());
			kjcgcjbForm.setJyfs(kjcgcjb.getJyfs());
			if(kjcgcjb.getSfzj()==1)
				kjcgcjbForm.setSfzj("是");
				else if(kjcgcjb.getSfzj()==0)
					kjcgcjbForm.setSfzj("否");
				
			kjcgcjbForm.setGfdj(kjcgcjb.getGfdj());
			kjcgcjbForm.setZhyq(kjcgcjb.getZhyq());
			if(kjcgcjb.getSfgk()==1)
				kjcgcjbForm.setSfgk("是");
				else if(kjcgcjb.getSfgk()==0)
					kjcgcjbForm.setSfgk("否");
			
			kjcgcjbForm.setFbrxz(String.valueOf(kjcgcjb.getFbrxz()));
			kjcgcjbForm.setLxrxm(kjcgcjb.getLxrxm());
			kjcgcjbForm.setGddh(kjcgcjb.getGddh());
			kjcgcjbForm.setSzdq(kjcgcjb.getSzdq());
			kjcgcjbForm.setSj(kjcgcjb.getSj());
			kjcgcjbForm.setDzyx(kjcgcjb.getDzyx());
			kjcgcjbForm.setLxdz(kjcgcjb.getLxdz());
			
			formlist.add(kjcgcjbForm);
		}
		return formlist;
	}

	
}
