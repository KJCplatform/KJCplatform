package platform.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjgfjflqkDao;
import platform.domain.Kjgfjflqk;
import platform.form.KjgfjflqkForm;
import platform.service.KjgfjflqkService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjgfjflqkService.SERVICE_NAME)
public class KjgfjflqkServiceImpl implements KjgfjflqkService{
	
	@Resource(name=KjgfjflqkDao.SERVICE_NAME)
	private KjgfjflqkDao kjgfjflqkDao;
	
	public List<KjgfjflqkForm> findKjgfjflqkList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.zywcdw", "desc");
		List<Kjgfjflqk> list=kjgfjflqkDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjgfjflqkForm> formlist=this.KjgfjflqkPOListToVOList(list);
		return formlist;
		
	}
	public List<KjgfjflqkForm> findKjgfjflqkListWithPage(int pagesize,int pageno,KjgfjflqkForm kjgfjflqkForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjgfjflqkForm!=null&&StringUtils.isNotBlank(kjgfjflqkForm.getDj())){
			hqlWhere += " and o.dj like ?";
			paramsList.add("%"+kjgfjflqkForm.getDj()+"%");
		}
		if(kjgfjflqkForm!=null&&StringUtils.isNotBlank(kjgfjflqkForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+kjgfjflqkForm.getXmmc()+"%");
		}
		orderby.put(" o.zywcdw", "desc");
		params = paramsList.toArray();
		List<Kjgfjflqk> list=kjgfjflqkDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjgfjflqkForm> formlist=this.KjgfjflqkPOListToVOList(list);
		return formlist;
		
	}
	/*private int id;
	  private String dj;
	  private String xmmc;
	  private String zywcdw;*/
	public void updateKjgfjflqk(KjgfjflqkForm kjgfjflqkForm){
		Kjgfjflqk kjgfjflqk=new Kjgfjflqk();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjgfjflqk.setId(Integer.valueOf(kjgfjflqkForm.getId()));
		kjgfjflqk.setDj(kjgfjflqkForm.getDj());
		kjgfjflqk.setXmmc(kjgfjflqkForm.getXmmc());
		kjgfjflqk.setZywcdw(kjgfjflqkForm.getZywcdw());
		kjgfjflqkDao.update(kjgfjflqk);
		
	}
	public void deleteObject(String id){
		kjgfjflqkDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjgfjflqkForm kjgfjflqkForm){
		Kjgfjflqk kjgfjflqk=new Kjgfjflqk();
		kjgfjflqk.setDj(kjgfjflqkForm.getDj());
		kjgfjflqk.setXmmc(kjgfjflqkForm.getXmmc());
		kjgfjflqk.setZywcdw(kjgfjflqkForm.getZywcdw());
		kjgfjflqkDao.save(kjgfjflqk);
	}
	private List<KjgfjflqkForm> KjgfjflqkPOListToVOList(List<Kjgfjflqk> list) {
		// TODO Auto-generated method stub
		List<KjgfjflqkForm> formlist=new ArrayList<KjgfjflqkForm>();
		for(int i=0;i<list.size();i++){
			Kjgfjflqk kjgfjflqk=list.get(i);
			KjgfjflqkForm kjgfjflqkForm=new KjgfjflqkForm();
			  //	jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjgfjflqkForm.setId(String.valueOf(kjgfjflqk.getId()));
			kjgfjflqkForm.setDj(kjgfjflqk.getDj());
			kjgfjflqkForm.setXmmc(kjgfjflqk.getXmmc());
			kjgfjflqkForm.setZywcdw(kjgfjflqk.getZywcdw());
			formlist.add(kjgfjflqkForm);
		}
		return formlist;
	}

	
}
