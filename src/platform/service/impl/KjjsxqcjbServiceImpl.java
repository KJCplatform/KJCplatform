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

import platform.dao.KjjsxqcjbDao;
import platform.domain.Kjjsxqcjb;
import platform.form.KjjsxqcjbForm;
import platform.service.KjjsxqcjbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjjsxqcjbService.SERVICE_NAME)
public class KjjsxqcjbServiceImpl implements KjjsxqcjbService{
	
	@Resource(name=KjjsxqcjbDao.SERVICE_NAME)
	private KjjsxqcjbDao kjjsxqcjbDao;
	
	public List<KjjsxqcjbForm> findKjjsxqcjbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.yqrq", "desc");
		List<Kjjsxqcjb> list=kjjsxqcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjjsxqcjbForm> formlist=this.KjjsxqcjbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjjsxqcjbForm> findKjjsxqcjbListWithPage(int pagesize,int pageno,KjjsxqcjbForm kjjsxqcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjjsxqcjbForm!=null&&StringUtils.isNotBlank(kjjsxqcjbForm.getXqmc())){
			hqlWhere += " and o.xqmc like ?";
			paramsList.add("%"+kjjsxqcjbForm.getXqmc()+"%");
		}
		if(kjjsxqcjbForm!=null&&StringUtils.isNotBlank(kjjsxqcjbForm.getJjfs())){
			hqlWhere += " and o.jjfs like ?";
			paramsList.add("%"+kjjsxqcjbForm.getSshy()+"%");
		}
		orderby.put(" o.yqrq", "desc");
		params = paramsList.toArray();
		List<Kjjsxqcjb> list=kjjsxqcjbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjjsxqcjbForm> formlist=this.KjjsxqcjbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjjsxqcjb(KjjsxqcjbForm kjjsxqcjbForm,String username){
		Kjjsxqcjb kjjsxqcjb=new Kjjsxqcjb();
		kjjsxqcjb.setId(Integer.valueOf(kjjsxqcjbForm.getId()));
		kjjsxqcjb.setXqmc(kjjsxqcjbForm.getXqmc());
		kjjsxqcjb.setJjfs(kjjsxqcjbForm.getJjfs());
		kjjsxqcjb.setSfzj(kjjsxqcjbForm.getSfzj());
		kjjsxqcjb.setYqrq(kjjsxqcjbForm.getYqrq());
		
		kjjsxqcjb.setSshy(kjjsxqcjbForm.getSshy());
		kjjsxqcjb.setJsly(kjjsxqcjbForm.getJsly());
		kjjsxqcjb.setXqms(kjjsxqcjbForm.getXqms());
		kjjsxqcjb.setNgzj(kjjsxqcjbForm.getNgzj());
		kjjsxqcjb.setFbrxz(kjjsxqcjbForm.getFbrxz());
		kjjsxqcjb.setSfgk(kjjsxqcjbForm.getSfgk());
		kjjsxqcjb.setLxrxm(kjjsxqcjbForm.getLxrxm());
		kjjsxqcjb.setGddh(kjjsxqcjbForm.getGddh());
		kjjsxqcjb.setSzdq(kjjsxqcjbForm.getSzdq());
		kjjsxqcjb.setSj(kjjsxqcjbForm.getSj());
		kjjsxqcjb.setDzyx(kjjsxqcjbForm.getDzyx());
		kjjsxqcjb.setLxdz(kjjsxqcjbForm.getLxdz());
		kjjsxqcjb.setZjdw(kjjsxqcjbForm.getZjdw());
		kjjsxqcjb.setZjlxr(kjjsxqcjbForm.getZjlxr());
		kjjsxqcjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjjsxqcjb.setUsername(username);
		kjjsxqcjb.setGxsj(new Date().toString());
		kjjsxqcjb.setSubmit(0);
		kjjsxqcjb.setZjdw(kjjsxqcjbForm.getZjdw());
		kjjsxqcjb.setZjlxr(kjjsxqcjbForm.getZjlxr());
		
		kjjsxqcjbDao.update(kjjsxqcjb);

		
	}
	public void deleteObject(String id){
		kjjsxqcjbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjjsxqcjbForm kjjsxqcjbForm,String username){
		Kjjsxqcjb kjjsxqcjb=new Kjjsxqcjb();
		kjjsxqcjb.setXqmc(kjjsxqcjbForm.getXqmc());
		kjjsxqcjb.setJjfs(kjjsxqcjbForm.getJjfs());
		kjjsxqcjb.setYqrq(kjjsxqcjbForm.getYqrq());
		kjjsxqcjb.setSfzj(kjjsxqcjbForm.getSfzj());
		kjjsxqcjb.setSshy(kjjsxqcjbForm.getSshy());
		kjjsxqcjb.setJsly(kjjsxqcjbForm.getJsly());
		kjjsxqcjb.setXqms(kjjsxqcjbForm.getXqms());
		kjjsxqcjb.setNgzj(kjjsxqcjbForm.getNgzj());
		kjjsxqcjb.setFbrxz(kjjsxqcjbForm.getFbrxz());
		kjjsxqcjb.setSfgk(kjjsxqcjbForm.getSfgk());
		kjjsxqcjb.setLxrxm(kjjsxqcjbForm.getLxrxm());
		kjjsxqcjb.setGddh(kjjsxqcjbForm.getGddh());
		kjjsxqcjb.setSzdq(kjjsxqcjbForm.getSzdq());
		kjjsxqcjb.setSj(kjjsxqcjbForm.getSj());
		kjjsxqcjb.setDzyx(kjjsxqcjbForm.getDzyx());
		kjjsxqcjb.setLxdz(kjjsxqcjbForm.getLxdz());
		
		kjjsxqcjb.setZjdw(kjjsxqcjbForm.getZjdw());
		kjjsxqcjb.setZjlxr(kjjsxqcjbForm.getZjlxr());
		
		kjjsxqcjb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjjsxqcjb.setUsername(username);
		kjjsxqcjb.setGxsj(new Date().toString());
		kjjsxqcjb.setSubmit(0);
		
		
		kjjsxqcjbDao.save(kjjsxqcjb);

	}
	private List<KjjsxqcjbForm> KjjsxqcjbPOListToVOList(List<Kjjsxqcjb> list) {
		// TODO Auto-generated method stub
		List<KjjsxqcjbForm> formlist=new ArrayList<KjjsxqcjbForm>();
		for(int i=0;i<list.size();i++){
			Kjjsxqcjb kjjsxqcjb=list.get(i);
			KjjsxqcjbForm kjjsxqcjbForm=new KjjsxqcjbForm();
			kjjsxqcjbForm.setXqmc(kjjsxqcjb.getXqmc());
			kjjsxqcjbForm.setJjfs(kjjsxqcjb.getJjfs());
			kjjsxqcjbForm.setYqrq(kjjsxqcjb.getYqrq());
			kjjsxqcjbForm.setId(String.valueOf(kjjsxqcjb.getId()));
			kjjsxqcjbForm.setSfzj(kjjsxqcjb.getSfzj());
			kjjsxqcjbForm.setSshy(kjjsxqcjb.getSshy());
			kjjsxqcjbForm.setJsly(kjjsxqcjb.getJsly());
			kjjsxqcjbForm.setXqms(kjjsxqcjb.getXqms());
			kjjsxqcjbForm.setNgzj(kjjsxqcjb.getNgzj());
			kjjsxqcjbForm.setFbrxz(kjjsxqcjb.getFbrxz());
			kjjsxqcjbForm.setSfgk(kjjsxqcjb.getSfgk());
			kjjsxqcjbForm.setLxrxm(kjjsxqcjb.getLxrxm());
			kjjsxqcjbForm.setGddh(kjjsxqcjb.getGddh());
			kjjsxqcjbForm.setSzdq(kjjsxqcjb.getSzdq());
			kjjsxqcjbForm.setSj(kjjsxqcjb.getSj());
			kjjsxqcjbForm.setDzyx(kjjsxqcjb.getDzyx());
			kjjsxqcjbForm.setLxdz(kjjsxqcjb.getLxdz());

			kjjsxqcjbForm.setJlnf(kjjsxqcjb.getJlnf());
			kjjsxqcjbForm.setUsername(kjjsxqcjb.getUsername());
			kjjsxqcjbForm.setGxsj(kjjsxqcjb.getGxsj());
			kjjsxqcjbForm.setSubmit(String.valueOf(kjjsxqcjb.getSubmit()));
			
			kjjsxqcjbForm.setZjdw(kjjsxqcjb.getZjdw());
			kjjsxqcjbForm.setZjlxr(kjjsxqcjb.getZjlxr());
			
			formlist.add(kjjsxqcjbForm);

		}
		return formlist;
	}
	

	
}
