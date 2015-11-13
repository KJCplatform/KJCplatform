package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.KjgxqybabDao;
import platform.domain.Kjgxqybab;
import platform.domain.Kjgxqybabzscq;
import platform.domain.Kjgxqybabyfxm;
import platform.domain.Kjgxqybabgxcp;
import platform.domain.Kjndgxqybab;
import platform.form.KjgxqybabForm;
import platform.form.KjgxqybabzscqForm;
import platform.form.KjgxqybabyfxmForm;
import platform.form.KjgxqybabgxcpForm;
import platform.form.KjndgxqybabForm;
import platform.service.KjgxqybabService;
import platform.util.StringHelper;
@Transactional
@Service(KjgxqybabService.SERVICE_NAME)
public class KjgxqybabServiceImpl implements KjgxqybabService{
	
	@Resource(name=KjgxqybabDao.SERVICE_NAME)
	private KjgxqybabDao kjgxqybabDao;

	public String saveKjgxqybab(KjgxqybabForm kjgxqybabForm){
		Kjgxqybab kjgxqybab=this.VoObjecttoPoObject(kjgxqybabForm);
		kjgxqybabDao.save(kjgxqybab);
		return kjgxqybabDao.selectMaxId();
		
	}

	private Kjgxqybab VoObjecttoPoObject(KjgxqybabForm kjgxqybabForm) {
		
		Kjgxqybab kjgxqybab=new Kjgxqybab();
		kjgxqybab.setId(Integer.valueOf(kjgxqybabForm.getId()));
		kjgxqybab.setYear(kjgxqybabForm.getYear());
		kjgxqybab.setNf(kjgxqybabForm.getNf());
		kjgxqybab.setQymc(kjgxqybabForm.getQymc());
		kjgxqybab.setNssbh(kjgxqybabForm.getNssbh());
		kjgxqybab.setSsly(kjgxqybabForm.getSsly());
		kjgxqybab.setZgswjg(kjgxqybabForm.getZgswjg());
		kjgxqybab.setZgzs(kjgxqybabForm.getZgzs());
		kjgxqybab.setYjrys(kjgxqybabForm.getYjrys());
		kjgxqybab.setDzrs(kjgxqybabForm.getDzrs());
		kjgxqybab.setYnzsr(kjgxqybabForm.getYnzsr());
		kjgxqybab.setSr1(kjgxqybabForm.getSr1());
		kjgxqybab.setSr2(kjgxqybabForm.getSr2());
		kjgxqybab.setSr3(kjgxqybabForm.getSr3());
		kjgxqybab.setHj(kjgxqybabForm.getHj());
		kjgxqybab.setXszzl(kjgxqybabForm.getXszzl());
		kjgxqybab.setZc1(kjgxqybabForm.getZc1());
		kjgxqybab.setZc2(kjgxqybabForm.getZc2());
		kjgxqybab.setZc3(kjgxqybabForm.getZc3());
		kjgxqybab.setZczzl(kjgxqybabForm.getZczzl());
		
		
		return kjgxqybab;
	}
	public void addZscqListWithExpertId(int id, List<KjgxqybabzscqForm> list){
		List<Kjgxqybabzscq> Plist=this.zscqPoToVoList(list);
		Kjgxqybab kjgxqybab= kjgxqybabDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			kjgxqybab.getKjgxqybabzscqs().add(Plist.get(i));
		}
	}
	public void addYfxmListWithExpertId(int id, List<KjgxqybabyfxmForm> list){
		List<Kjgxqybabyfxm> Plist=this.yfxmPoToVoList(list);
		Kjgxqybab kjgxqybab= kjgxqybabDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			kjgxqybab.getKjgxqybabyfxms().add(Plist.get(i));
		}
		
	}
	public void addGxcpListWithExpertId(int id, List<KjgxqybabgxcpForm> list){
		List<Kjgxqybabgxcp> Plist=this.gxcpPoToVoList(list);
		Kjgxqybab kjgxqybab= kjgxqybabDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			kjgxqybab.getKjgxqybabgxcps().add(Plist.get(i));
		}
	}
	
	
	
	private List<Kjgxqybabzscq> zscqPoToVoList(List<KjgxqybabzscqForm> list) {
		List<Kjgxqybabzscq> Plist=new ArrayList<Kjgxqybabzscq>();
		for(int i=0;i<list.size();i++){
			Kjgxqybabzscq kjgxqybabzscq=new Kjgxqybabzscq();
	//		kjgxqybabzscq.setFk_gxqybab_id(list.get(i).getFk_gxqybab_id());
			kjgxqybabzscq.setXmbh(list.get(i).getXmbh());
			kjgxqybabzscq.setSqmc(list.get(i).getSqmc());
			kjgxqybabzscq.setLb(list.get(i).getLb());
			kjgxqybabzscq.setSqh(list.get(i).getSqh());
			kjgxqybabzscq.setSqrq(list.get(i).getSqrq());
			Plist.add(kjgxqybabzscq);
		}
		return Plist;
	}

	private List<Kjgxqybabyfxm> yfxmPoToVoList(List<KjgxqybabyfxmForm> list) {
		List<Kjgxqybabyfxm> Plist=new ArrayList<Kjgxqybabyfxm>();
		for(int i=0;i<list.size();i++){
			Kjgxqybabyfxm kjgxqybabyfxm=new Kjgxqybabyfxm();
	//		kjgxqybabyfxm.setFk_gxqybab_id(list.get(i).getFk_gxqybab_id());
			kjgxqybabyfxm.setXmbh(list.get(i).getXmbh());
			kjgxqybabyfxm.setXmmc(list.get(i).getXmmc());
			kjgxqybabyfxm.setJfhj(list.get(i).getJfhj());
			kjgxqybabyfxm.setJfnb(list.get(i).getJfnb());
			kjgxqybabyfxm.setJfwb(list.get(i).getJfwb());
			
			Plist.add(kjgxqybabyfxm);
		}
		return Plist;
	}

	private List<Kjgxqybabgxcp> gxcpPoToVoList(List<KjgxqybabgxcpForm> list) {
		List<Kjgxqybabgxcp> Plist=new ArrayList<Kjgxqybabgxcp>();
		for(int i=0;i<list.size();i++){
			Kjgxqybabgxcp kjgxqybabgxcp=new Kjgxqybabgxcp();
	//		kjgxqybabgxcp.setFk_gxqybab_id(list.get(i).getFk_gxqybab_id());
			kjgxqybabgxcp.setCpbh(list.get(i).getCpbh());
			kjgxqybabgxcp.setCpmc(list.get(i).getCpmc());
			kjgxqybabgxcp.setShsr(list.get(i).getShsr());
			Plist.add(kjgxqybabgxcp);
		}
		return Plist;
	}
	public List<KjgxqybabForm> findKjgxqybabList(KjgxqybabForm kjgxqybabForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjgxqybabForm!=null&&StringUtils.isNotBlank(kjgxqybabForm.getYear())){
			hqlWhere += " and o.year = ?";
			paramsList.add(kjgxqybabForm.getYear());
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Kjgxqybab> list=kjgxqybabDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjgxqybabForm> formlist=this.KjgxqybabPoToVoList(list);
		return formlist;
	}

	private List<KjgxqybabForm> KjgxqybabPoToVoList(List<Kjgxqybab> list) {
		List<KjgxqybabForm> formlist=new ArrayList<KjgxqybabForm>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			KjgxqybabForm kjgxqybabForm=new KjgxqybabForm();
			
			kjgxqybabForm.setYear(list.get(i).getYear());
			kjgxqybabForm.setNf(list.get(i).getNf());
			kjgxqybabForm.setQymc(list.get(i).getQymc());
			kjgxqybabForm.setNssbh(list.get(i).getNssbh());
			kjgxqybabForm.setSsly(list.get(i).getSsly());
			kjgxqybabForm.setZgswjg(list.get(i).getZgswjg());
			kjgxqybabForm.setZgzs(list.get(i).getZgzs());
			kjgxqybabForm.setYjrys(list.get(i).getYjrys());
			kjgxqybabForm.setDzrs(list.get(i).getDzrs());
			kjgxqybabForm.setYnzsr(list.get(i).getYnzsr());
			kjgxqybabForm.setSr1(list.get(i).getSr1());
			kjgxqybabForm.setSr2(list.get(i).getSr2());
			kjgxqybabForm.setSr3(list.get(i).getSr3());
			kjgxqybabForm.setHj(list.get(i).getHj());
			kjgxqybabForm.setXszzl(list.get(i).getXszzl());
			kjgxqybabForm.setZc1(list.get(i).getZc1());
			kjgxqybabForm.setZc2(list.get(i).getZc2());
			kjgxqybabForm.setZc3(list.get(i).getZc3());
			kjgxqybabForm.setZczzl(list.get(i).getZczzl());
			
			
			kjgxqybabForm.setKjgxqybabzscqs(KjgxqybabzscqSetToFormList(list.get(i).getKjgxqybabzscqs()));
			kjgxqybabForm.setKjgxqybabyfxms(KjgxqybabyfxmSetToFormList(list.get(i).getKjgxqybabyfxms()));
			kjgxqybabForm.setKjgxqybabgxcps(KjgxqybabgxcpSetToFormList(list.get(i).getKjgxqybabgxcps()));
			formlist.add(kjgxqybabForm);
		}}
		return formlist;
	}

	private List<KjgxqybabzscqForm> KjgxqybabzscqSetToFormList(
			Set<Kjgxqybabzscq> kjgxqybabzscqs) {
   List<KjgxqybabzscqForm> formlist=new ArrayList<KjgxqybabzscqForm>();
   if(kjgxqybabzscqs.size()>0){
		for(Kjgxqybabzscq kjgxqybabzscq:kjgxqybabzscqs){
			KjgxqybabzscqForm kjgxqybabzscqForm=new KjgxqybabzscqForm();
	//		kjgxqybabzscqForm.setFk_gxqybab_id(kjgxqybabzscq.getFk_gxqybab_id());
			kjgxqybabzscqForm.setXmbh(kjgxqybabzscq.getXmbh());
			kjgxqybabzscqForm.setSqmc(kjgxqybabzscq.getSqmc());
			kjgxqybabzscqForm.setLb(kjgxqybabzscq.getLb());
			kjgxqybabzscqForm.setSqh(kjgxqybabzscq.getSqh());
			kjgxqybabzscqForm.setSqrq(kjgxqybabzscq.getSqrq());
			formlist.add(kjgxqybabzscqForm);
		}}
		return formlist;
	}

	private List<KjgxqybabyfxmForm> KjgxqybabyfxmSetToFormList(
			Set<Kjgxqybabyfxm> kjgxqybabyfxms) {
		List<KjgxqybabyfxmForm> formlist=new ArrayList<KjgxqybabyfxmForm>();
		if(kjgxqybabyfxms.size()>0){
		for(Kjgxqybabyfxm kjgxqybabyfxm:kjgxqybabyfxms){
			KjgxqybabyfxmForm kjgxqybabyfxmForm=new KjgxqybabyfxmForm();
			
	//		kjgxqybabyfxmForm.setFk_gxqybab_id(kjgxqybabyfxm.getFk_gxqybab_id());
			kjgxqybabyfxmForm.setXmbh(kjgxqybabyfxm.getXmbh());
			kjgxqybabyfxmForm.setXmmc(kjgxqybabyfxm.getXmmc());
			kjgxqybabyfxmForm.setJfhj(kjgxqybabyfxm.getJfhj());
			kjgxqybabyfxmForm.setJfnb(kjgxqybabyfxm.getJfnb());
			kjgxqybabyfxmForm.setJfwb(kjgxqybabyfxm.getJfwb());
			formlist.add(kjgxqybabyfxmForm);
			
		}}
		return formlist;
	}

	private List<KjgxqybabgxcpForm> KjgxqybabgxcpSetToFormList(
			Set<Kjgxqybabgxcp> kjgxqybabgxcps) {
		// TODO Auto-generated method stub
		List<KjgxqybabgxcpForm> formlist=new ArrayList<KjgxqybabgxcpForm>();
		if(kjgxqybabgxcps.size()>0){
		for(Kjgxqybabgxcp kjgxqybabgxcp:kjgxqybabgxcps){
			KjgxqybabgxcpForm kjgxqybabgxcpForm=new KjgxqybabgxcpForm();
	//		kjgxqybabgxcpForm.setFk_gxqybab_id(kjgxqybabgxcp.getFk_gxqybab_id());
			kjgxqybabgxcpForm.setCpbh(kjgxqybabgxcp.getCpbh());
			kjgxqybabgxcpForm.setCpmc(kjgxqybabgxcp.getCpmc());
			kjgxqybabgxcpForm.setShsr(kjgxqybabgxcp.getShsr());
			formlist.add(kjgxqybabgxcpForm);
		}}
		return formlist;
	}
}
