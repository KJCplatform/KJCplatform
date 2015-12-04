package platform.service.impl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjndjgkjjlqkbDao;
import platform.domain.Kjndjgkjjlqkb;
import platform.form.KjndjgkjjlqkbForm;
import platform.service.KjndjgkjjlqkbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjndjgkjjlqkbService.SERVICE_NAME)
public class KjndjgkjjlqkbServiceImpl implements KjndjgkjjlqkbService{
	
	@Resource(name=KjndjgkjjlqkbDao.SERVICE_NAME)
	private KjndjgkjjlqkbDao kjndjgkjjlqkbDao;
	
	public List<KjndjgkjjlqkbForm> findKjndjgkjjlqkbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xmmc", "desc");
		List<Kjndjgkjjlqkb> list=kjndjgkjjlqkbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndjgkjjlqkbForm> formlist=this.KjndjgkjjlqkbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjndjgkjjlqkbForm> findKjndjgkjjlqkbListWithPage(int pagesize,int pageno,KjndjgkjjlqkbForm kjndjgkjjlqkbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjndjgkjjlqkbForm!=null&&StringUtils.isNotBlank(kjndjgkjjlqkbForm.getYear())){
			hqlWhere += " and o.year like ?";
			paramsList.add("%"+kjndjgkjjlqkbForm.getYear()+"%");
		}
		if(kjndjgkjjlqkbForm!=null&&StringUtils.isNotBlank(kjndjgkjjlqkbForm.getJz())){
			hqlWhere += " and o.jz like ?";
			paramsList.add("%"+kjndjgkjjlqkbForm.getJz()+"%");
		}
		orderby.put(" o.xmmc", "desc");
		params = paramsList.toArray();
		List<Kjndjgkjjlqkb> list=kjndjgkjjlqkbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjndjgkjjlqkbForm> formlist=this.KjndjgkjjlqkbPOListToVOList(list);
		return formlist;
		
	}
	/* private int id;
	  private String year;
	  private String Jz;
	  private String Dj;
	  private String Xmmc;
	  private String Wcdw;
	  private String Djdw;*/
	public void updateKjndjgkjjlqkb(KjndjgkjjlqkbForm kjndjgkjjlqkbForm,String username){
		Kjndjgkjjlqkb kjndjgkjjlqkb=new Kjndjgkjjlqkb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjndjgkjjlqkb.setId(Integer.valueOf(kjndjgkjjlqkbForm.getId()));
		kjndjgkjjlqkb.setYear(kjndjgkjjlqkbForm.getYear());
		kjndjgkjjlqkb.setJz(kjndjgkjjlqkbForm.getJz());
		kjndjgkjjlqkb.setDj(kjndjgkjjlqkbForm.getDj());
		kjndjgkjjlqkb.setXmmc(kjndjgkjjlqkbForm.getXmmc());
		kjndjgkjjlqkb.setWcdw(kjndjgkjjlqkbForm.getWcdw());
		kjndjgkjjlqkb.setDjdw(kjndjgkjjlqkbForm.getDjdw());
		
		kjndjgkjjlqkb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndjgkjjlqkb.setUsername(username);
		kjndjgkjjlqkb.setGxsj(new Date().toString());
		kjndjgkjjlqkb.setSubmit(0);
		kjndjgkjjlqkbDao.update(kjndjgkjjlqkb);
		
	}
	public void deleteObject(String id){
		kjndjgkjjlqkbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjndjgkjjlqkbForm kjndjgkjjlqkbForm,String username){
		Kjndjgkjjlqkb kjndjgkjjlqkb=new Kjndjgkjjlqkb();
		
		kjndjgkjjlqkb.setYear(kjndjgkjjlqkbForm.getYear());
		kjndjgkjjlqkb.setJz(kjndjgkjjlqkbForm.getJz());
		kjndjgkjjlqkb.setDj(kjndjgkjjlqkbForm.getDj());
		kjndjgkjjlqkb.setXmmc(kjndjgkjjlqkbForm.getXmmc());
		kjndjgkjjlqkb.setWcdw(kjndjgkjjlqkbForm.getWcdw());
		kjndjgkjjlqkb.setDjdw(kjndjgkjjlqkbForm.getDjdw());
		
		kjndjgkjjlqkb.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjndjgkjjlqkb.setUsername(username);
		kjndjgkjjlqkb.setGxsj(new Date().toString());
		kjndjgkjjlqkb.setSubmit(0);
		kjndjgkjjlqkbDao.save(kjndjgkjjlqkb);
	}
	private List<KjndjgkjjlqkbForm> KjndjgkjjlqkbPOListToVOList(List<Kjndjgkjjlqkb> list) {
		// TODO Auto-generated method stub
		List<KjndjgkjjlqkbForm> formlist=new ArrayList<KjndjgkjjlqkbForm>();
		for(int i=0;i<list.size();i++){
			Kjndjgkjjlqkb kjndjgkjjlqkb=list.get(i);
			KjndjgkjjlqkbForm kjndjgkjjlqkbForm=new KjndjgkjjlqkbForm();
			 //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjndjgkjjlqkbForm.setId(String.valueOf(kjndjgkjjlqkb.getId()));
			kjndjgkjjlqkbForm.setYear(kjndjgkjjlqkb.getYear());
			kjndjgkjjlqkbForm.setJz(kjndjgkjjlqkb.getJz());
			kjndjgkjjlqkbForm.setDj(kjndjgkjjlqkb.getDj());
			kjndjgkjjlqkbForm.setXmmc(kjndjgkjjlqkb.getXmmc());
			kjndjgkjjlqkbForm.setWcdw(kjndjgkjjlqkb.getWcdw());
			kjndjgkjjlqkbForm.setDjdw(kjndjgkjjlqkb.getDjdw());
			
			kjndjgkjjlqkbForm.setJlnf(kjndjgkjjlqkb.getJlnf());
			kjndjgkjjlqkbForm.setUsername(kjndjgkjjlqkb.getUsername());
			kjndjgkjjlqkbForm.setGxsj(kjndjgkjjlqkb.getGxsj());
			kjndjgkjjlqkbForm.setSubmit(String.valueOf(kjndjgkjjlqkb.getSubmit()));
			formlist.add(kjndjgkjjlqkbForm);
		}
		return formlist;
	}

	
}
