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

import platform.dao.KjndgxqybabDao;
import platform.domain.Kjndgxqybab;
import platform.form.KjndgxqybabForm;
import platform.service.KjndgxqybabService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjndgxqybabService.SERVICE_NAME)
public class KjndgxqybabServiceImpl implements KjndgxqybabService{
	
	@Resource(name=KjndgxqybabDao.SERVICE_NAME)
	private KjndgxqybabDao kjndgxqybabDao;
	
	public List<KjndgxqybabForm> findKjndgxqybabList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.nf", "desc");
		List<Kjndgxqybab> list=kjndgxqybabDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndgxqybabForm> formlist=this.XzxzgzbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjndgxqybabForm> findKjndgxqybabListWithPage(int pagesize,int pageno,KjndgxqybabForm kjndgxqybabForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjndgxqybabForm!=null&&StringUtils.isNotBlank(kjndgxqybabForm.getQymc())){
			hqlWhere += " and o.qymc like ?";
			paramsList.add("%"+kjndgxqybabForm.getQymc()+"%");
		}
		if(kjndgxqybabForm!=null&&StringUtils.isNotBlank(kjndgxqybabForm.getNssbh())){
			hqlWhere += " and o.nssbh like ?";
			paramsList.add("%"+kjndgxqybabForm.getNssbh()+"%");
		}
		orderby.put(" o.nf", "desc");
		params = paramsList.toArray();
		List<Kjndgxqybab> list=kjndgxqybabDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjndgxqybabForm> formlist=this.XzxzgzbPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjndgxqybab(KjndgxqybabForm kjndgxqybabForm,String username){
		Kjndgxqybab kjndgxqybab=new Kjndgxqybab();
		kjndgxqybab.setId(Integer.valueOf(kjndgxqybabForm.getId()));
		kjndgxqybab.setYear(kjndgxqybabForm.getYear());
		kjndgxqybab.setNf(kjndgxqybabForm.getNf());
		kjndgxqybab.setQymc(kjndgxqybabForm.getQymc());
		kjndgxqybab.setNssbh(kjndgxqybabForm.getNssbh());
		kjndgxqybab.setSsly(kjndgxqybabForm.getSsly());
		kjndgxqybab.setZgswjg(kjndgxqybabForm.getZgswjg());
		kjndgxqybab.setZgzs(kjndgxqybabForm.getZgzs());
		kjndgxqybab.setYjrys(kjndgxqybabForm.getYjrys());
		kjndgxqybab.setDzrs(kjndgxqybabForm.getDzrs());
		kjndgxqybab.setYnzsr(kjndgxqybabForm.getYnzsr());
		kjndgxqybab.setSr1(kjndgxqybabForm.getSr1());
		kjndgxqybab.setSr2(kjndgxqybabForm.getSr2());
		kjndgxqybab.setSr3(kjndgxqybabForm.getSr3());
		kjndgxqybab.setHj(kjndgxqybabForm.getHj());
		kjndgxqybab.setXszzl(kjndgxqybabForm.getXszzl());
		kjndgxqybab.setZc1(kjndgxqybabForm.getZc1());
		kjndgxqybab.setZc2(kjndgxqybabForm.getZc2());
		kjndgxqybab.setZc3(kjndgxqybabForm.getZc3());
		kjndgxqybab.setZczzl(kjndgxqybabForm.getZczzl());
		
		kjndgxqybab.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndgxqybab.setUsername(username);
		kjndgxqybab.setGxsj(new Date().toString());
		kjndgxqybab.setSubmit(0);
		kjndgxqybabDao.update(kjndgxqybab);
		
	}
	public void deleteObject(String id){
		kjndgxqybabDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjndgxqybabForm kjndgxqybabForm,String username){
		Kjndgxqybab kjndgxqybab=new Kjndgxqybab();
		kjndgxqybab.setYear(kjndgxqybabForm.getYear());
		kjndgxqybab.setNf(kjndgxqybabForm.getNf());
		kjndgxqybab.setQymc(kjndgxqybabForm.getQymc());
		kjndgxqybab.setNssbh(kjndgxqybabForm.getNssbh());
		kjndgxqybab.setSsly(kjndgxqybabForm.getSsly());
		kjndgxqybab.setZgswjg(kjndgxqybabForm.getZgswjg());
		kjndgxqybab.setZgzs(kjndgxqybabForm.getZgzs());
		kjndgxqybab.setYjrys(kjndgxqybabForm.getYjrys());
		kjndgxqybab.setDzrs(kjndgxqybabForm.getDzrs());
		kjndgxqybab.setYnzsr(kjndgxqybabForm.getYnzsr());
		kjndgxqybab.setSr1(kjndgxqybabForm.getSr1());
		kjndgxqybab.setSr2(kjndgxqybabForm.getSr2());
		kjndgxqybab.setSr3(kjndgxqybabForm.getSr3());
		kjndgxqybab.setHj(kjndgxqybabForm.getHj());
		kjndgxqybab.setXszzl(kjndgxqybabForm.getXszzl());
		kjndgxqybab.setZc1(kjndgxqybabForm.getZc1());
		kjndgxqybab.setZc2(kjndgxqybabForm.getZc2());
		kjndgxqybab.setZc3(kjndgxqybabForm.getZc3());
		kjndgxqybab.setZczzl(kjndgxqybabForm.getZczzl());
		
		kjndgxqybab.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndgxqybab.setUsername(username);
		kjndgxqybab.setGxsj(new Date().toString());
		kjndgxqybab.setSubmit(0);
	    kjndgxqybabDao.save(kjndgxqybab);
	}
	private List<KjndgxqybabForm> XzxzgzbPOListToVOList(List<Kjndgxqybab> list) {
		// TODO Auto-generated method stub
		List<KjndgxqybabForm> formlist=new ArrayList<KjndgxqybabForm>();
		for(int i=0;i<list.size();i++){
			Kjndgxqybab kjndgxqybab=list.get(i);
			KjndgxqybabForm kjndgxqybabForm=new KjndgxqybabForm();
			kjndgxqybabForm.setId(String.valueOf(kjndgxqybab.getId()));
			kjndgxqybabForm.setYear(kjndgxqybab.getYear());
			kjndgxqybabForm.setNf(kjndgxqybab.getNf());
			kjndgxqybabForm.setQymc(kjndgxqybab.getQymc());
			kjndgxqybabForm.setNssbh(kjndgxqybab.getNssbh());
			kjndgxqybabForm.setSsly(kjndgxqybab.getSsly());
			kjndgxqybabForm.setZgswjg(kjndgxqybab.getZgswjg());
			kjndgxqybabForm.setZgzs(kjndgxqybab.getZgzs());
			kjndgxqybabForm.setYjrys(kjndgxqybab.getYjrys());
			kjndgxqybabForm.setDzrs(kjndgxqybab.getDzrs());
			kjndgxqybabForm.setYnzsr(kjndgxqybab.getYnzsr());
			kjndgxqybabForm.setSr1(kjndgxqybab.getSr1());
			kjndgxqybabForm.setSr2(kjndgxqybab.getSr2());
			kjndgxqybabForm.setSr3(kjndgxqybab.getSr3());
			kjndgxqybabForm.setHj(kjndgxqybab.getHj());
			kjndgxqybabForm.setXszzl(kjndgxqybab.getXszzl());
			kjndgxqybabForm.setZc1(kjndgxqybab.getZc1());
			kjndgxqybabForm.setZc2(kjndgxqybab.getZc2());
			kjndgxqybabForm.setZc3(kjndgxqybab.getZc3());
			kjndgxqybabForm.setZczzl(kjndgxqybab.getZczzl());
			
			kjndgxqybabForm.setJlnf(kjndgxqybab.getJlnf());
			kjndgxqybabForm.setUsername(kjndgxqybab.getUsername());
			kjndgxqybabForm.setGxsj(kjndgxqybab.getGxsj());
			kjndgxqybabForm.setSubmit(String.valueOf(kjndgxqybab.getSubmit()));
			
			formlist.add(kjndgxqybabForm);
		}
		return formlist;
	}
	
	}

	

