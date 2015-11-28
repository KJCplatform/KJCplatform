package platform.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjndjpptkyxmzxbDao;
import platform.domain.Kjndjpptkyxmzxb;
import platform.form.JljlqjhzbForm;
import platform.form.KjndjpptkyxmzxbForm;
import platform.service.KjndjpptkyxmzxbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjndjpptkyxmzxbService.SERVICE_NAME)
public class KjndjpptkyxmzxbServiceImpl implements KjndjpptkyxmzxbService{
	
	@Resource(name=KjndjpptkyxmzxbDao.SERVICE_NAME)
	private KjndjpptkyxmzxbDao kjndjpptkyxmzxbDao;
	
	public List<KjndjpptkyxmzxbForm> findKjndjpptkyxmzxbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.cyzgbm", "desc");
		List<Kjndjpptkyxmzxb> list=kjndjpptkyxmzxbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndjpptkyxmzxbForm> formlist=this.KjndjpptkyxmzxbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjndjpptkyxmzxbForm> findKjndjpptkyxmzxbListWithPage(int pagesize,int pageno,KjndjpptkyxmzxbForm kjndjpptkyxmzxbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjndjpptkyxmzxbForm!=null&&StringUtils.isNotBlank(kjndjpptkyxmzxbForm.getXmbh())){
			hqlWhere += " and o.xmbh like ?";
			paramsList.add("%"+kjndjpptkyxmzxbForm.getXmbh()+"%");
		}
		if(kjndjpptkyxmzxbForm!=null&&StringUtils.isNotBlank(kjndjpptkyxmzxbForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+kjndjpptkyxmzxbForm.getXmmc()+"%");
		}
		orderby.put(" o.cyzgbm", "desc");
		params = paramsList.toArray();
		List<Kjndjpptkyxmzxb> list=kjndjpptkyxmzxbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjndjpptkyxmzxbForm> formlist=this.KjndjpptkyxmzxbPOListToVOList(list);
		return formlist;
		
	}
	/*private int id;
	  private String xmbh;
	  private String xmmc;
	  private String cyzgbm;
	  private String cydw;
	  private String xqzgbm;
	  private String xqdw;
	  private String bjxh;
	  private String xmnr;
	  private String yzzq;
	  private String pfzjf;
	  private String pfgbjf;
	  private String dwzjf;
	  private String dwgbjf;
	  private String ndyjnr;
	  private String yjwcqk;
	  private String wwcyy;
	  private String clsfzj;
	  private String qdcg;
	  private String czwt;
	  private String csjy;
	  private String bz;*/
	public void updateKjndjpptkyxmzxb(KjndjpptkyxmzxbForm kjndjpptkyxmzxbForm){
		Kjndjpptkyxmzxb kjndjpptkyxmzxb=new Kjndjpptkyxmzxb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjndjpptkyxmzxb.setId(Integer.valueOf(kjndjpptkyxmzxbForm.getId()));
		kjndjpptkyxmzxb.setXmbh(kjndjpptkyxmzxbForm.getXmbh());
		kjndjpptkyxmzxb.setXmmc(kjndjpptkyxmzxbForm.getXmmc());
		kjndjpptkyxmzxb.setCyzgbm(kjndjpptkyxmzxbForm.getCyzgbm());
		kjndjpptkyxmzxb.setCydw(kjndjpptkyxmzxbForm.getCydw());
		kjndjpptkyxmzxb.setXqzgbm(kjndjpptkyxmzxbForm.getXqzgbm());
		kjndjpptkyxmzxb.setXqdw(kjndjpptkyxmzxbForm.getXqdw());
		kjndjpptkyxmzxb.setBjxh(kjndjpptkyxmzxbForm.getBjxh());
		kjndjpptkyxmzxb.setXmnr(kjndjpptkyxmzxbForm.getXmnr());
		kjndjpptkyxmzxb.setYzzq(kjndjpptkyxmzxbForm.getYzzq());
		kjndjpptkyxmzxb.setPfzjf(kjndjpptkyxmzxbForm.getPfzjf());
		kjndjpptkyxmzxb.setPfgbjf(kjndjpptkyxmzxbForm.getPfgbjf());

		kjndjpptkyxmzxb.setBz(kjndjpptkyxmzxbForm.getBz());
		kjndjpptkyxmzxbDao.update(kjndjpptkyxmzxb);
		
	}
	public void deleteObject(String id){
		kjndjpptkyxmzxbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjndjpptkyxmzxbForm kjndjpptkyxmzxbForm){
		Kjndjpptkyxmzxb kjndjpptkyxmzxb=new Kjndjpptkyxmzxb();
		kjndjpptkyxmzxb.setXmbh(kjndjpptkyxmzxbForm.getXmbh());
		kjndjpptkyxmzxb.setXmmc(kjndjpptkyxmzxbForm.getXmmc());
		kjndjpptkyxmzxb.setCyzgbm(kjndjpptkyxmzxbForm.getCyzgbm());
		kjndjpptkyxmzxb.setCydw(kjndjpptkyxmzxbForm.getCydw());
		kjndjpptkyxmzxb.setXqzgbm(kjndjpptkyxmzxbForm.getXqzgbm());
		kjndjpptkyxmzxb.setXqdw(kjndjpptkyxmzxbForm.getXqdw());
		kjndjpptkyxmzxb.setBjxh(kjndjpptkyxmzxbForm.getBjxh());
		kjndjpptkyxmzxb.setXmnr(kjndjpptkyxmzxbForm.getXmnr());
		kjndjpptkyxmzxb.setYzzq(kjndjpptkyxmzxbForm.getYzzq());
		kjndjpptkyxmzxb.setPfzjf(kjndjpptkyxmzxbForm.getPfzjf());
		kjndjpptkyxmzxb.setPfgbjf(kjndjpptkyxmzxbForm.getPfgbjf());

		kjndjpptkyxmzxb.setBz(kjndjpptkyxmzxbForm.getBz());
		kjndjpptkyxmzxbDao.save(kjndjpptkyxmzxb);
	}
	private List<KjndjpptkyxmzxbForm> KjndjpptkyxmzxbPOListToVOList(List<Kjndjpptkyxmzxb> list) {
		// TODO Auto-generated method stub
		List<KjndjpptkyxmzxbForm> formlist=new ArrayList<KjndjpptkyxmzxbForm>();
		for(int i=0;i<list.size();i++){
			Kjndjpptkyxmzxb kjndjpptkyxmzxb=list.get(i);
			KjndjpptkyxmzxbForm kjndjpptkyxmzxbForm=new KjndjpptkyxmzxbForm();
//			jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjndjpptkyxmzxbForm.setId(String.valueOf(kjndjpptkyxmzxb.getId()));
			kjndjpptkyxmzxbForm.setXmbh(kjndjpptkyxmzxb.getXmbh());
			kjndjpptkyxmzxbForm.setXmmc(kjndjpptkyxmzxb.getXmmc());
			kjndjpptkyxmzxbForm.setCyzgbm(kjndjpptkyxmzxb.getCyzgbm());
			kjndjpptkyxmzxbForm.setCydw(kjndjpptkyxmzxb.getCydw());
			kjndjpptkyxmzxbForm.setXqzgbm(kjndjpptkyxmzxb.getXqzgbm());
			kjndjpptkyxmzxbForm.setXqdw(kjndjpptkyxmzxb.getXqdw());
			kjndjpptkyxmzxbForm.setBjxh(kjndjpptkyxmzxb.getBjxh());
			kjndjpptkyxmzxbForm.setXmnr(kjndjpptkyxmzxb.getXmnr());
			kjndjpptkyxmzxbForm.setYzzq(kjndjpptkyxmzxb.getYzzq());
			kjndjpptkyxmzxbForm.setPfzjf(kjndjpptkyxmzxb.getPfzjf());
			kjndjpptkyxmzxbForm.setPfgbjf(kjndjpptkyxmzxb.getPfgbjf());

			kjndjpptkyxmzxbForm.setBz(kjndjpptkyxmzxb.getBz());
			formlist.add(kjndjpptkyxmzxbForm);
		}
		return formlist;
	}

	
}
