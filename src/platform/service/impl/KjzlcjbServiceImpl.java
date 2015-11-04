package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjzlcjbDao;
import platform.domain.Kjzlcjb;
import platform.form.KjzlcjbForm;
import platform.service.KjzlcjbService;
import platform.util.StringHelper;

@Service(KjzlcjbService.SERVICE_NAME)
public class KjzlcjbServiceImpl implements KjzlcjbService{
	
	@Resource(name=KjzlcjbDao.SERVICE_NAME)
	private KjzlcjbDao kjzlcjbDao;
	
	public List<KjzlcjbForm> findKjzlcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zlqr", "desc");
		List<Kjzlcjb> list=kjzlcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjzlcjbForm> formlist=this.KjzlcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjzlcjbForm> findKjzlcjbListWithPage(int pagesize,int pageno,KjzlcjbForm kjzlcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjzlcjbForm!=null&&StringUtils.isNotBlank(kjzlcjbForm.getCgmc())){
			hqlWhere += " and o.cgmc like ?";
			paramsList.add("%"+kjzlcjbForm.getCgmc()+"%");
		}
		if(kjzlcjbForm!=null&&StringUtils.isNotBlank(kjzlcjbForm.getZllx())){
			hqlWhere += " and o.zllx like ?";
			paramsList.add("%"+kjzlcjbForm.getZllx()+"%");
		}
		orderby.put(" o.zlqr", "desc");
		params = paramsList.toArray();//
		List<Kjzlcjb> list=kjzlcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjzlcjbForm> formlist=this.KjzlcjbPOListToVOList(list);//
		return formlist;
		
	}
	
	public void updateKjzlcjb(KjzlcjbForm kjzlcjbForm){
	Kjzlcjb kjzlcjb=new Kjzlcjb();
		
		kjzlcjb.setId(Integer.valueOf(kjzlcjbForm.getId()));
		

		kjzlcjb.setCgmc(kjzlcjbForm.getCgmc());
		kjzlcjb.setZllx(kjzlcjbForm.getZllx());
		kjzlcjb.setZlqr(kjzlcjbForm.getZlqr());
		kjzlcjb.setZywcr(kjzlcjbForm.getZywcr());
		kjzlcjb.setZlh(kjzlcjbForm.getZlh());
		kjzlcjb.setGkh(kjzlcjbForm.getGkh());
		
		kjzlcjb.setGkr(StringHelper.stringConvertDate(kjzlcjbForm.getGkr()));
		kjzlcjb.setZflh(kjzlcjbForm.getZflh());
		kjzlcjb.setFlzt(kjzlcjbForm.getFlzt());
		kjzlcjb.setCgjj(kjzlcjbForm.getCgjj());
		kjzlcjb.setYyhy(kjzlcjbForm.getYyhy());
		kjzlcjb.setJsly(kjzlcjbForm.getJsly());
		kjzlcjb.setCgjd(kjzlcjbForm.getCgjd());
		kjzlcjb.setJyfs(kjzlcjbForm.getJyfs());
		
		//数据校验
		if(kjzlcjbForm.getSfwtzj()!=null)
		kjzlcjb.setSfwtzj(Integer.valueOf(kjzlcjbForm.getSfwtzj()));
		kjzlcjb.setGfdj(kjzlcjbForm.getGfdj());
		kjzlcjb.setQtzhyq(kjzlcjbForm.getQtzhyq());
		
		//数据校验
		if(kjzlcjbForm.getSfgk()!=null)
		kjzlcjb.setSfgk(Integer.valueOf(kjzlcjbForm.getSfgk()));
		kjzlcjb.setLxr(kjzlcjbForm.getLxr());
		
		//数据校验
		if(kjzlcjbForm.getGddh()!=null
				&&!kjzlcjbForm.getGddh().equals(""))
		kjzlcjb.setGddh(Long.valueOf(kjzlcjbForm.getGddh()));
		kjzlcjb.setSzdq(kjzlcjbForm.getSzdq());
		
		//数据校验
		if(!kjzlcjbForm.getSj().equals(""))
		kjzlcjb.setSj(Long.valueOf(kjzlcjbForm.getSj()));
		kjzlcjb.setDzyx(kjzlcjbForm.getDzyx());
		kjzlcjb.setLxdz(kjzlcjbForm.getLxdz());
		
		
		kjzlcjbDao.update(kjzlcjb);
		
	}
	public void deleteObject(String id){
		kjzlcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjzlcjbForm kjzlcjbForm){
		Kjzlcjb kjzlcjb=new Kjzlcjb();

		kjzlcjb.setCgmc(kjzlcjbForm.getCgmc());
		kjzlcjb.setZllx(kjzlcjbForm.getZllx());
		kjzlcjb.setZlqr(kjzlcjbForm.getZlqr());
		kjzlcjb.setZywcr(kjzlcjbForm.getZywcr());
		kjzlcjb.setZlh(kjzlcjbForm.getZlh());
		kjzlcjb.setGkh(kjzlcjbForm.getGkh());
		//System.out.println(kjzlcjbForm.getGkr().equals(""));
		if(!kjzlcjbForm.getGkr().equals(""))
		kjzlcjb.setGkr(StringHelper.stringConvertDate(kjzlcjbForm.getGkr()));
		kjzlcjb.setZflh(kjzlcjbForm.getZflh());
		kjzlcjb.setFlzt(kjzlcjbForm.getFlzt());
		kjzlcjb.setCgjj(kjzlcjbForm.getCgjj());
		kjzlcjb.setYyhy(kjzlcjbForm.getYyhy());
		//System.out.println(kjzlcjbForm.getYyhy()==null);
		kjzlcjb.setJsly(kjzlcjbForm.getJsly());
		kjzlcjb.setCgjd(kjzlcjbForm.getCgjd());
		kjzlcjb.setJyfs(kjzlcjbForm.getJyfs());
		
		//数据校验
		if(kjzlcjbForm.getSfwtzj()!=null)
		kjzlcjb.setSfwtzj(Integer.valueOf(kjzlcjbForm.getSfwtzj()));
		kjzlcjb.setGfdj(kjzlcjbForm.getGfdj());
		kjzlcjb.setQtzhyq(kjzlcjbForm.getQtzhyq());
		
		//数据校验
		if(kjzlcjbForm.getSfgk()!=null)
		kjzlcjb.setSfgk(Integer.valueOf(kjzlcjbForm.getSfgk()));
		kjzlcjb.setLxr(kjzlcjbForm.getLxr());
		
		//数据校验
		if(!kjzlcjbForm.getGddh().equals(""))
		kjzlcjb.setGddh(Long.valueOf(kjzlcjbForm.getGddh()));
		kjzlcjb.setSzdq(kjzlcjbForm.getSzdq());
		
		//数据校验
		if(!kjzlcjbForm.getSj().equals(""))
		kjzlcjb.setSj(Long.valueOf(kjzlcjbForm.getSj()));
		kjzlcjb.setDzyx(kjzlcjbForm.getDzyx());
		kjzlcjb.setLxdz(kjzlcjbForm.getLxdz());
		kjzlcjbDao.save(kjzlcjb);
	}
	private List<KjzlcjbForm> KjzlcjbPOListToVOList(List<Kjzlcjb> list) {
		// TODO Auto-generated method stub
		List<KjzlcjbForm> formlist=new ArrayList<KjzlcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjzlcjb kjzlcjb=list.get(i);
			KjzlcjbForm kjzlcjbForm=new KjzlcjbForm();
			
			kjzlcjbForm.setId(String.valueOf(kjzlcjb.getId()));
			kjzlcjbForm.setCgmc(kjzlcjb.getCgmc());
			kjzlcjbForm.setZllx(kjzlcjb.getZllx());
			kjzlcjbForm.setZlqr(kjzlcjb.getZlqr());
			kjzlcjbForm.setZywcr(kjzlcjb.getZywcr());
			kjzlcjbForm.setZlh(kjzlcjb.getZlh());
			kjzlcjbForm.setGkh(kjzlcjb.getGkh());
			
			if(kjzlcjb.getGkr()!=null)
			kjzlcjbForm.setGkr(String.valueOf(kjzlcjb.getGkr()));
			kjzlcjbForm.setZflh(kjzlcjb.getZflh());
			kjzlcjbForm.setFlzt(kjzlcjb.getFlzt());
			kjzlcjbForm.setCgjj(kjzlcjb.getCgjj());
			kjzlcjbForm.setYyhy(kjzlcjb.getYyhy());
			kjzlcjbForm.setJsly(kjzlcjb.getJsly());
			kjzlcjbForm.setCgjd(kjzlcjb.getCgjd());
			kjzlcjbForm.setJyfs(kjzlcjb.getJyfs());

			kjzlcjbForm.setSfwtzj(String.valueOf(kjzlcjb.getSfwtzj()));
			kjzlcjbForm.setGfdj(kjzlcjb.getGfdj());
			kjzlcjbForm.setQtzhyq(kjzlcjb.getQtzhyq());
			
			kjzlcjbForm.setSfgk(String.valueOf(kjzlcjb.getSfgk()));
			kjzlcjbForm.setLxr(kjzlcjb.getLxr());
			
			if(kjzlcjb.getGddh()!=null)
			kjzlcjbForm.setGddh(String.valueOf(kjzlcjb.getGddh()));
			kjzlcjbForm.setSzdq(kjzlcjb.getSzdq());
			
			if(kjzlcjb.getSj()!=null)
			kjzlcjbForm.setSj(String.valueOf(kjzlcjb.getSj()));
			kjzlcjbForm.setDzyx(kjzlcjb.getDzyx());
			kjzlcjbForm.setLxdz(kjzlcjb.getLxdz());
			formlist.add(kjzlcjbForm);
		}
		return formlist;
	}

	
}
