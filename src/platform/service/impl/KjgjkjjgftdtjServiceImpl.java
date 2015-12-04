package platform.service.impl;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjgjkjjgftdtjDao;
import platform.domain.Kjgjkjjgftdtj;
import platform.form.KjgjkjjgftdtjForm;
import platform.service.KjgjkjjgftdtjService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjgjkjjgftdtjService.SERVICE_NAME)
public class KjgjkjjgftdtjServiceImpl implements KjgjkjjgftdtjService{
	
	@Resource(name=KjgjkjjgftdtjDao.SERVICE_NAME)
	private KjgjkjjgftdtjDao kjgjkjjgftdtjDao;
	
	public List<KjgjkjjgftdtjForm> findKjgjkjjgftdtjList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zywcdw", "desc");
		List<Kjgjkjjgftdtj> list=kjgjkjjgftdtjDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjgjkjjgftdtjForm> formlist=this.KjgjkjjgftdtjPOListToVOList(list);
		return formlist;
		
	}
	public List<KjgjkjjgftdtjForm> findKjgjkjjgftdtjListWithPage(int pagesize,int pageno,KjgjkjjgftdtjForm kjgjkjjgftdtjForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjgjkjjgftdtjForm!=null&&StringUtils.isNotBlank(kjgjkjjgftdtjForm.getNd())){
			hqlWhere += " and o.nd like ?";
			paramsList.add("%"+kjgjkjjgftdtjForm.getNd()+"%");
		}
		if(kjgjkjjgftdtjForm!=null&&StringUtils.isNotBlank(kjgjkjjgftdtjForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+kjgjkjjgftdtjForm.getXmmc()+"%");
		}
		orderby.put(" o.zywcdw", "desc");
		params = paramsList.toArray();
		List<Kjgjkjjgftdtj> list=kjgjkjjgftdtjDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjgjkjjgftdtjForm> formlist=this.KjgjkjjgftdtjPOListToVOList(list);
		return formlist;
		
	}
	/* private int id;
	  private String nd;
	  private String xmmc;
	  private String zywcdw;*/
	public void updateKjgjkjjgftdtj(KjgjkjjgftdtjForm kjgjkjjgftdtjForm,String username){
		Kjgjkjjgftdtj kjgjkjjgftdtj=new Kjgjkjjgftdtj();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjgjkjjgftdtj.setId(Integer.valueOf(kjgjkjjgftdtjForm.getId()));
		kjgjkjjgftdtj.setNd(kjgjkjjgftdtjForm.getNd());
		kjgjkjjgftdtj.setXmmc(kjgjkjjgftdtjForm.getXmmc());
		kjgjkjjgftdtj.setZywcdw(kjgjkjjgftdtjForm.getZywcdw());
		
		kjgjkjjgftdtj.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgjkjjgftdtj.setUsername(username);
		kjgjkjjgftdtj.setGxsj(new Date().toString());
		kjgjkjjgftdtj.setSubmit(0);
		
		kjgjkjjgftdtjDao.update(kjgjkjjgftdtj);
		
	}
	public void deleteObject(String id){
		kjgjkjjgftdtjDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjgjkjjgftdtjForm kjgjkjjgftdtjForm,String username){
		Kjgjkjjgftdtj kjgjkjjgftdtj=new Kjgjkjjgftdtj();
		kjgjkjjgftdtj.setNd(kjgjkjjgftdtjForm.getNd());
		kjgjkjjgftdtj.setXmmc(kjgjkjjgftdtjForm.getXmmc());
		kjgjkjjgftdtj.setZywcdw(kjgjkjjgftdtjForm.getZywcdw());
		
		
		kjgjkjjgftdtj.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjgjkjjgftdtj.setUsername(username);
		kjgjkjjgftdtj.setGxsj(new Date().toString());
		kjgjkjjgftdtj.setSubmit(0);
		
		kjgjkjjgftdtjDao.save(kjgjkjjgftdtj);
	}
	private List<KjgjkjjgftdtjForm> KjgjkjjgftdtjPOListToVOList(List<Kjgjkjjgftdtj> list) {
		// TODO Auto-generated method stub
		List<KjgjkjjgftdtjForm> formlist=new ArrayList<KjgjkjjgftdtjForm>();
		for(int i=0;i<list.size();i++){
			Kjgjkjjgftdtj kjgjkjjgftdtj=list.get(i);
			KjgjkjjgftdtjForm kjgjkjjgftdtjForm=new KjgjkjjgftdtjForm();
			 //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjgjkjjgftdtjForm.setId(String.valueOf(kjgjkjjgftdtj.getId()));
			kjgjkjjgftdtjForm.setNd(kjgjkjjgftdtj.getNd());
			kjgjkjjgftdtjForm.setXmmc(kjgjkjjgftdtj.getXmmc());
			kjgjkjjgftdtjForm.setZywcdw(kjgjkjjgftdtj.getZywcdw());
			
			kjgjkjjgftdtjForm.setJlnf(kjgjkjjgftdtj.getJlnf());
			kjgjkjjgftdtjForm.setUsername(kjgjkjjgftdtj.getUsername());
			kjgjkjjgftdtjForm.setGxsj(kjgjkjjgftdtj.getGxsj());
			kjgjkjjgftdtjForm.setSubmit(String.valueOf(kjgjkjjgftdtj.getSubmit()));
			
			
			formlist.add(kjgjkjjgftdtjForm);
		}
		return formlist;
	}

	
}
