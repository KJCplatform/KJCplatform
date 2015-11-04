package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjnzwcjbDao;
import platform.domain.Kjnzwcjb;
import platform.form.KjnzwcjbForm;
import platform.service.KjnzwcjbService;
import platform.util.StringHelper;

@Service(KjnzwcjbService.SERVICE_NAME)
public class KjnzwcjbServiceImpl implements KjnzwcjbService{
	
	@Resource(name=KjnzwcjbDao.SERVICE_NAME)
	private KjnzwcjbDao kjnzwcjbDao;
	
	public List<KjnzwcjbForm> findKjnzwcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xyr", "desc");
		List<Kjnzwcjb> list=kjnzwcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjnzwcjbForm> formlist=this.KjnzwcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjnzwcjbForm> findKjnzwcjbListWithPage(int pagesize,int pageno,KjnzwcjbForm kjnzwcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjnzwcjbForm!=null&&StringUtils.isNotBlank(kjnzwcjbForm.getPzmc())){
			hqlWhere += " and o.pzmc like ?";
			paramsList.add("%"+kjnzwcjbForm.getPzmc()+"%");
		}
		if(kjnzwcjbForm!=null&&StringUtils.isNotBlank(kjnzwcjbForm.getXydw())){
			hqlWhere += " and o.xydw like ?";
			paramsList.add("%"+kjnzwcjbForm.getXydw()+"%");
		}
		orderby.put(" o.xyr", "desc");
		params = paramsList.toArray();
		List<Kjnzwcjb> list=kjnzwcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjnzwcjbForm> formlist=this.KjnzwcjbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjnzwcjb(KjnzwcjbForm kjnzwcjbForm){
		Kjnzwcjb kjnzwcjb=new Kjnzwcjb();
		
		kjnzwcjb.setId(Integer.valueOf(kjnzwcjbForm.getId()));
		
		kjnzwcjb.setPzmc(kjnzwcjbForm.getPzmc());
		kjnzwcjb.setXydw(kjnzwcjbForm.getXydw());
		kjnzwcjb.setXyr(kjnzwcjbForm.getXyr());
	 	kjnzwcjb.setSdsj(StringHelper.stringConvertDate(kjnzwcjbForm.getSdsj()));
	    kjnzwcjb.setSdh(kjnzwcjbForm.getSdh());
		kjnzwcjb.setSdjg(kjnzwcjbForm.getSdjg());
		kjnzwcjb.setPzjj(kjnzwcjbForm.getPzjj());
		kjnzwcjb.setYyhy(kjnzwcjbForm.getYyhy());
		kjnzwcjb.setJsly(kjnzwcjbForm.getJsly());
	 	kjnzwcjb.setCgjd(kjnzwcjbForm.getCgjd());
	    kjnzwcjb.setJyfs(kjnzwcjbForm.getJyfs());
		kjnzwcjb.setSfzj(Integer.valueOf(kjnzwcjbForm.getSfzj()));
		kjnzwcjb.setGfdj(kjnzwcjbForm.getGfdj());
		kjnzwcjb.setZhyq(kjnzwcjbForm.getZhyq());
		kjnzwcjb.setSfgk(Integer.valueOf(kjnzwcjbForm.getSfgk()));
	 	kjnzwcjb.setFbrxz(Integer.valueOf(kjnzwcjbForm.getFbrxz()));
	    kjnzwcjb.setLxrxm(kjnzwcjbForm.getLxrxm());
		kjnzwcjb.setGddh(kjnzwcjbForm.getGddh());
		kjnzwcjb.setSzdq(kjnzwcjbForm.getSzdq());
		kjnzwcjb.setSj(kjnzwcjbForm.getSj());
		kjnzwcjb.setDzyx(kjnzwcjbForm.getDzyx());
	 	kjnzwcjb.setLxdz(kjnzwcjbForm.getLxdz());

		
		kjnzwcjbDao.update(kjnzwcjb);
		
	}
	public void deleteObject(String id){
		kjnzwcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjnzwcjbForm kjnzwcjbForm){
		Kjnzwcjb kjnzwcjb=new Kjnzwcjb();
		
		kjnzwcjb.setPzmc(kjnzwcjbForm.getPzmc());
		kjnzwcjb.setXydw(kjnzwcjbForm.getXydw());
		kjnzwcjb.setXyr(kjnzwcjbForm.getXyr());
	 	kjnzwcjb.setSdsj(StringHelper.stringConvertDate(kjnzwcjbForm.getSdsj()));
	    kjnzwcjb.setSdh(kjnzwcjbForm.getSdh());
		kjnzwcjb.setSdjg(kjnzwcjbForm.getSdjg());
		kjnzwcjb.setPzjj(kjnzwcjbForm.getPzjj());
		kjnzwcjb.setYyhy(kjnzwcjbForm.getYyhy());
		kjnzwcjb.setJsly(kjnzwcjbForm.getJsly());
	 	kjnzwcjb.setCgjd(kjnzwcjbForm.getCgjd());
	    kjnzwcjb.setJyfs(kjnzwcjbForm.getJyfs());
	    
		if(kjnzwcjbForm.getSfzj()!=null)
		kjnzwcjb.setSfzj(Integer.valueOf(kjnzwcjbForm.getSfzj()));
		kjnzwcjb.setGfdj(kjnzwcjbForm.getGfdj());
		kjnzwcjb.setZhyq(kjnzwcjbForm.getZhyq());
		
		if(!kjnzwcjbForm.getSfgk().equals(""))
		kjnzwcjb.setSfgk(Integer.valueOf(kjnzwcjbForm.getSfgk()));
		
		if(!kjnzwcjbForm.getFbrxz().equals(""))
	 	kjnzwcjb.setFbrxz(Integer.valueOf(kjnzwcjbForm.getFbrxz()));
	    kjnzwcjb.setLxrxm(kjnzwcjbForm.getLxrxm());
		kjnzwcjb.setGddh(kjnzwcjbForm.getGddh());
		kjnzwcjb.setSzdq(kjnzwcjbForm.getSzdq());
		kjnzwcjb.setSj(kjnzwcjbForm.getSj());
		kjnzwcjb.setDzyx(kjnzwcjbForm.getDzyx());
	 	kjnzwcjb.setLxdz(kjnzwcjbForm.getLxdz());
	 	
		kjnzwcjbDao.save(kjnzwcjb);
	}
	private List<KjnzwcjbForm> KjnzwcjbPOListToVOList(List<Kjnzwcjb> list) {
		// TODO Auto-generated method stub
		List<KjnzwcjbForm> formlist=new ArrayList<KjnzwcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjnzwcjb kjnzwcjb=list.get(i);
			KjnzwcjbForm kjnzwcjbForm=new KjnzwcjbForm();
			
			kjnzwcjbForm.setId(String.valueOf(kjnzwcjb.getId()));
			kjnzwcjbForm.setPzmc(kjnzwcjb.getPzmc());
			kjnzwcjbForm.setXydw(kjnzwcjb.getXydw());
			kjnzwcjbForm.setXyr(kjnzwcjb.getXyr());
			kjnzwcjbForm.setSdsj(String.valueOf(kjnzwcjb.getSdsj()));
			kjnzwcjbForm.setSdh(kjnzwcjb.getSdh());
			kjnzwcjbForm.setSdjg(kjnzwcjb.getSdjg());
			kjnzwcjbForm.setPzjj(kjnzwcjb.getPzjj());
			kjnzwcjbForm.setYyhy(kjnzwcjb.getYyhy());
			kjnzwcjbForm.setJsly(kjnzwcjb.getJsly());
			kjnzwcjbForm.setCgjd(kjnzwcjb.getCgjd());
			kjnzwcjbForm.setJyfs(kjnzwcjb.getJyfs());
		    kjnzwcjbForm.setSfzj(String.valueOf(kjnzwcjb.getSfzj()));
		    kjnzwcjbForm.setGfdj(kjnzwcjb.getGfdj());
		    kjnzwcjbForm.setZhyq(kjnzwcjb.getZhyq());
		    kjnzwcjbForm.setSfgk(String.valueOf(kjnzwcjb.getSfgk()));
		    kjnzwcjbForm.setFbrxz(String.valueOf(kjnzwcjb.getFbrxz()));
		    kjnzwcjbForm.setLxrxm(kjnzwcjb.getLxrxm());
		    kjnzwcjbForm.setGddh(kjnzwcjb.getGddh());
		    kjnzwcjbForm.setSzdq(kjnzwcjb.getSzdq());
		    kjnzwcjbForm.setSj(kjnzwcjb.getSj());
		    kjnzwcjbForm.setDzyx(kjnzwcjb.getDzyx());
		    kjnzwcjbForm.setLxdz(kjnzwcjb.getLxdz());
		 	
			formlist.add(kjnzwcjbForm);
		}
		return formlist;
	}

	
}
