package platform.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.KjndjpptkyxmbDao;
import platform.domain.Kjndjpptkyxmb;
import platform.form.JljlqjhzbForm;
import platform.form.KjndjpptkyxmbForm;
import platform.service.KjndjpptkyxmbService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(KjndjpptkyxmbService.SERVICE_NAME)
public class KjndjpptkyxmbServiceImpl implements KjndjpptkyxmbService{
	
	@Resource(name=KjndjpptkyxmbDao.SERVICE_NAME)
	private KjndjpptkyxmbDao kjndjpptkyxmbDao;
	
	public List<KjndjpptkyxmbForm> findKjndjpptkyxmbList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.cyzgbm", "desc");
		List<Kjndjpptkyxmb> list=kjndjpptkyxmbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjndjpptkyxmbForm> formlist=this.KjndjpptkyxmbPOListToVOList(list);
		return formlist;
		
	}
	public List<KjndjpptkyxmbForm> findKjndjpptkyxmbListWithPage(int pagesize,int pageno,KjndjpptkyxmbForm kjndjpptkyxmbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjndjpptkyxmbForm!=null&&StringUtils.isNotBlank(kjndjpptkyxmbForm.getXmbh())){
			hqlWhere += " and o.xmbh like ?";
			paramsList.add("%"+kjndjpptkyxmbForm.getXmbh()+"%");
		}
		if(kjndjpptkyxmbForm!=null&&StringUtils.isNotBlank(kjndjpptkyxmbForm.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+kjndjpptkyxmbForm.getXmmc()+"%");
		}
		orderby.put(" o.cyzgbm", "desc");
		params = paramsList.toArray();
		List<Kjndjpptkyxmb> list=kjndjpptkyxmbDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<KjndjpptkyxmbForm> formlist=this.KjndjpptkyxmbPOListToVOList(list);
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
	public void updateKjndjpptkyxmb(KjndjpptkyxmbForm kjndjpptkyxmbForm){
		Kjndjpptkyxmb kjndjpptkyxmb=new Kjndjpptkyxmb();
//		jljlqjhzb.setCljg(jljlqjhzbForm.getCljg());
		//	jljlqjhzb.setFwrq(StringHelper.stringConvertDate(jljlqjhzbForm.getFwrq()));
		kjndjpptkyxmb.setId(Integer.valueOf(kjndjpptkyxmbForm.getId()));
		kjndjpptkyxmb.setXmbh(kjndjpptkyxmbForm.getXmbh());
		kjndjpptkyxmb.setXmmc(kjndjpptkyxmbForm.getXmmc());
		kjndjpptkyxmb.setCyzgbm(kjndjpptkyxmbForm.getCyzgbm());
		kjndjpptkyxmb.setCydw(kjndjpptkyxmbForm.getCydw());
		kjndjpptkyxmb.setXqzgbm(kjndjpptkyxmbForm.getXqzgbm());
		kjndjpptkyxmb.setXqdw(kjndjpptkyxmbForm.getXqdw());
		kjndjpptkyxmb.setBjxh(kjndjpptkyxmbForm.getBjxh());
		kjndjpptkyxmb.setXmnr(kjndjpptkyxmbForm.getXmnr());
		kjndjpptkyxmb.setYzzq(kjndjpptkyxmbForm.getYzzq());
		kjndjpptkyxmb.setPfzjf(kjndjpptkyxmbForm.getPfzjf());
		kjndjpptkyxmb.setPfgbjf(kjndjpptkyxmbForm.getPfgbjf());
		kjndjpptkyxmb.setDwzjf(kjndjpptkyxmbForm.getDwzjf());
		kjndjpptkyxmb.setDwgbjf(kjndjpptkyxmbForm.getDwgbjf());
		kjndjpptkyxmb.setNdyjnr(kjndjpptkyxmbForm.getNdyjnr());
		kjndjpptkyxmb.setYjwcqk(kjndjpptkyxmbForm.getYjwcqk());
		kjndjpptkyxmb.setWwcyy(kjndjpptkyxmbForm.getWwcyy());
		kjndjpptkyxmb.setClsfzj(kjndjpptkyxmbForm.getClsfzj());
		kjndjpptkyxmb.setQdcg(kjndjpptkyxmbForm.getQdcg());
		kjndjpptkyxmb.setCzwt(kjndjpptkyxmbForm.getCzwt());
		kjndjpptkyxmb.setCsjy(kjndjpptkyxmbForm.getCsjy());
		kjndjpptkyxmb.setBz(kjndjpptkyxmbForm.getBz());
		kjndjpptkyxmbDao.update(kjndjpptkyxmb);
		
	}
	public void deleteObject(String id){
		kjndjpptkyxmbDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(KjndjpptkyxmbForm kjndjpptkyxmbForm){
		Kjndjpptkyxmb kjndjpptkyxmb=new Kjndjpptkyxmb();
		kjndjpptkyxmb.setXmbh(kjndjpptkyxmbForm.getXmbh());
		kjndjpptkyxmb.setXmmc(kjndjpptkyxmbForm.getXmmc());
		kjndjpptkyxmb.setCyzgbm(kjndjpptkyxmbForm.getCyzgbm());
		kjndjpptkyxmb.setCydw(kjndjpptkyxmbForm.getCydw());
		kjndjpptkyxmb.setXqzgbm(kjndjpptkyxmbForm.getXqzgbm());
		kjndjpptkyxmb.setXqdw(kjndjpptkyxmbForm.getXqdw());
		kjndjpptkyxmb.setBjxh(kjndjpptkyxmbForm.getBjxh());
		kjndjpptkyxmb.setXmnr(kjndjpptkyxmbForm.getXmnr());
		kjndjpptkyxmb.setYzzq(kjndjpptkyxmbForm.getYzzq());
		kjndjpptkyxmb.setPfzjf(kjndjpptkyxmbForm.getPfzjf());
		kjndjpptkyxmb.setPfgbjf(kjndjpptkyxmbForm.getPfgbjf());
		kjndjpptkyxmb.setDwzjf(kjndjpptkyxmbForm.getDwzjf());
		kjndjpptkyxmb.setDwgbjf(kjndjpptkyxmbForm.getDwgbjf());
		kjndjpptkyxmb.setNdyjnr(kjndjpptkyxmbForm.getNdyjnr());
		kjndjpptkyxmb.setYjwcqk(kjndjpptkyxmbForm.getYjwcqk());
		kjndjpptkyxmb.setWwcyy(kjndjpptkyxmbForm.getWwcyy());
		kjndjpptkyxmb.setClsfzj(kjndjpptkyxmbForm.getClsfzj());
		kjndjpptkyxmb.setQdcg(kjndjpptkyxmbForm.getQdcg());
		kjndjpptkyxmb.setCzwt(kjndjpptkyxmbForm.getCzwt());
		kjndjpptkyxmb.setCsjy(kjndjpptkyxmbForm.getCsjy());
		kjndjpptkyxmb.setBz(kjndjpptkyxmbForm.getBz());
		kjndjpptkyxmbDao.save(kjndjpptkyxmb);
	}
	private List<KjndjpptkyxmbForm> KjndjpptkyxmbPOListToVOList(List<Kjndjpptkyxmb> list) {
		// TODO Auto-generated method stub
		List<KjndjpptkyxmbForm> formlist=new ArrayList<KjndjpptkyxmbForm>();
		for(int i=0;i<list.size();i++){
			Kjndjpptkyxmb kjndjpptkyxmb=list.get(i);
			KjndjpptkyxmbForm kjndjpptkyxmbForm=new KjndjpptkyxmbForm();
//			jljlqjhzbForm.setCljg(jljlqjhzb.getCljg());
			//	jljlqjhzbForm.setFwrq(String.valueOf(jljlqjhzb.getFwrq()));
			kjndjpptkyxmbForm.setId(String.valueOf(kjndjpptkyxmb.getId()));
			kjndjpptkyxmbForm.setXmbh(kjndjpptkyxmb.getXmbh());
			kjndjpptkyxmbForm.setXmmc(kjndjpptkyxmb.getXmmc());
			kjndjpptkyxmbForm.setCyzgbm(kjndjpptkyxmb.getCyzgbm());
			kjndjpptkyxmbForm.setCydw(kjndjpptkyxmb.getCydw());
			kjndjpptkyxmbForm.setXqzgbm(kjndjpptkyxmb.getXqzgbm());
			kjndjpptkyxmbForm.setXqdw(kjndjpptkyxmb.getXqdw());
			kjndjpptkyxmbForm.setBjxh(kjndjpptkyxmb.getBjxh());
			kjndjpptkyxmbForm.setXmnr(kjndjpptkyxmb.getXmnr());
			kjndjpptkyxmbForm.setYzzq(kjndjpptkyxmb.getYzzq());
			kjndjpptkyxmbForm.setPfzjf(kjndjpptkyxmb.getPfzjf());
			kjndjpptkyxmbForm.setPfgbjf(kjndjpptkyxmb.getPfgbjf());
			kjndjpptkyxmbForm.setDwzjf(kjndjpptkyxmb.getDwzjf());
			kjndjpptkyxmbForm.setDwgbjf(kjndjpptkyxmb.getDwgbjf());
			kjndjpptkyxmbForm.setNdyjnr(kjndjpptkyxmb.getNdyjnr());
			kjndjpptkyxmbForm.setYjwcqk(kjndjpptkyxmb.getYjwcqk());
			kjndjpptkyxmbForm.setWwcyy(kjndjpptkyxmb.getWwcyy());
			kjndjpptkyxmbForm.setClsfzj(kjndjpptkyxmb.getClsfzj());
			kjndjpptkyxmbForm.setQdcg(kjndjpptkyxmb.getQdcg());
			kjndjpptkyxmbForm.setCzwt(kjndjpptkyxmb.getCzwt());
			kjndjpptkyxmbForm.setCsjy(kjndjpptkyxmb.getCsjy());
			kjndjpptkyxmbForm.setBz(kjndjpptkyxmb.getBz());
			formlist.add(kjndjpptkyxmbForm);
		}
		return formlist;
	}

	
}
