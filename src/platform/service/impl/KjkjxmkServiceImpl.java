package platform.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import platform.dao.KjkjxmkDao;
import platform.domain.Kjkjxmk;
import platform.form.KjkjxmkForm;
import platform.service.KjkjxmkService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjkjxmkService.SERVICE_NAME)
public class KjkjxmkServiceImpl implements KjkjxmkService{
	
	@Resource(name=KjkjxmkDao.SERVICE_NAME)
	private KjkjxmkDao kjkjxmkDao;
	
	public List<KjkjxmkForm> findKjkjxmkList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.xh", "desc");
		List<Kjkjxmk> list=kjkjxmkDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjkjxmkForm> formlist=this.KjkjxmkPOListToVOList(list);
		return formlist;
		
	}
	public List<KjkjxmkForm> findKjkjxmkListWithPage(int pagesize,int pageno,KjkjxmkForm kjkjxmkForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjkjxmkForm!=null&&StringUtils.isNotBlank(kjkjxmkForm.getDwmc())){
			hqlWhere += " and o.dwmc like ?";
			paramsList.add("%"+kjkjxmkForm.getDwmc()+"%");
		}
		if(kjkjxmkForm!=null&&StringUtils.isNotBlank(kjkjxmkForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+kjkjxmkForm.getXmmc()+"%");
		}
		orderby.put(" o.xh", "desc");
		params = paramsList.toArray();
		List<Kjkjxmk> list=kjkjxmkDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjkjxmkForm> formlist=this.KjkjxmkPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjkjxmk(KjkjxmkForm kjkjxmkForm){
		Kjkjxmk kjkjxmk=new Kjkjxmk();
		kjkjxmk.setId(Integer.valueOf(kjkjxmk.getId()));
		kjkjxmk.setLb(kjkjxmkForm.getLb());
		kjkjxmk.setXh(kjkjxmkForm.getXh());
		kjkjxmk.setDwmc(kjkjxmkForm.getDwmc());
		kjkjxmk.setXmmc(kjkjxmkForm.getXmmc());
		kjkjxmk.setJsgmnr(kjkjxmkForm.getJsgmnr());
		kjkjxmk.setXmjszq(kjkjxmkForm.getXmjszq());
		kjkjxmk.setYmjd(kjkjxmkForm.getYmjd());
		kjkjxmk.setZtz(kjkjxmkForm.getZtz());
		kjkjxmk.setYwctz(kjkjxmkForm.getYwctz());
		kjkjxmk.setBz(kjkjxmkForm.getBz());
		kjkjxmkDao.update(kjkjxmk);
		
	}
	public void deleteObject(String id){
		kjkjxmkDao.deleteObjectByIDs(Integer.parseInt(id));
	}
	
	public void saveObject(KjkjxmkForm kjkjxmkForm){
		Kjkjxmk kjkjxmk=new Kjkjxmk();
//		kjkjxmk.setId(Integer.valueOf(kjkjxmkForm.getId()));
		kjkjxmk.setLb(kjkjxmkForm.getLb());
		kjkjxmk.setXh(kjkjxmkForm.getXh());
		kjkjxmk.setDwmc(kjkjxmkForm.getDwmc());
		kjkjxmk.setXmmc(kjkjxmkForm.getXmmc());
		kjkjxmk.setJsgmnr(kjkjxmkForm.getJsgmnr());
		kjkjxmk.setXmjszq(kjkjxmkForm.getXmjszq());
		kjkjxmk.setYmjd(kjkjxmkForm.getYmjd());
		kjkjxmk.setZtz(kjkjxmkForm.getZtz());
		kjkjxmk.setYwctz(kjkjxmkForm.getYwctz());
		kjkjxmk.setBz(kjkjxmkForm.getBz());
		kjkjxmkDao.save(kjkjxmk);
	}
	private List<KjkjxmkForm> KjkjxmkPOListToVOList(List<Kjkjxmk> list) {
		// TODO Auto-generated method stub
		List<KjkjxmkForm> formlist=new ArrayList<KjkjxmkForm>();
		for(int i=0;i<list.size();i++){
			Kjkjxmk kjkjxmk=list.get(i);
			KjkjxmkForm kjkjxmkForm=new KjkjxmkForm();
			kjkjxmkForm.setId(String.valueOf(kjkjxmk.getId()));
			kjkjxmkForm.setLb(kjkjxmk.getLb());
			kjkjxmkForm.setXh(kjkjxmk.getXh());
			kjkjxmkForm.setDwmc(kjkjxmk.getDwmc());
			kjkjxmkForm.setXmmc(kjkjxmk.getXmmc());
			kjkjxmkForm.setJsgmnr(kjkjxmk.getJsgmnr());
			kjkjxmkForm.setXmjszq(kjkjxmk.getXmjszq());
			kjkjxmkForm.setYmjd(kjkjxmk.getYmjd());
			kjkjxmkForm.setZtz(kjkjxmk.getZtz());
			kjkjxmkForm.setYwctz(kjkjxmk.getYwctz());
			kjkjxmkForm.setBz(kjkjxmk.getBz());
			formlist.add(kjkjxmkForm);
		}
		return formlist;
	}
	
	
}
