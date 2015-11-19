package platform.service.impl;

import java.util.ArrayList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.KjkjxmxxbDao;
import platform.domain.Kjkjxmxxb;
import platform.domain.Kjkjxmxxbcjdw;

import platform.form.KjkjxmxxbForm;
import platform.form.KjkjxmxxbcjdwForm;

import platform.service.KjkjxmxxbService;

@Transactional
@Service(KjkjxmxxbService.SERVICE_NAME)
public class KjkjxmxxbServiceImpl implements KjkjxmxxbService{
	
	@Resource(name=KjkjxmxxbDao.SERVICE_NAME)
	private KjkjxmxxbDao kjkjxmxxbDao;

	public String saveKjkjxmxxb(KjkjxmxxbForm kjkjxmxxbForm){
		Kjkjxmxxb kjkjxmxxb=this.VoObjecttoPoObject(kjkjxmxxbForm);
		kjkjxmxxbDao.save(kjkjxmxxb);
		return kjkjxmxxbDao.selectMaxId();
		
	}

	private Kjkjxmxxb VoObjecttoPoObject(KjkjxmxxbForm kjkjxmxxbForm) {
		Kjkjxmxxb kjkjxmxxb=new Kjkjxmxxb();
		kjkjxmxxb.setXmbh(kjkjxmxxbForm.getXmbh());
		kjkjxmxxb.setXmmc(kjkjxmxxbForm.getXmmc());
		kjkjxmxxb.setCjdws(kjkjxmxxbForm.getCjdws());
		kjkjxmxxb.setDwmc(kjkjxmxxbForm.getDwmc());
		kjkjxmxxb.setDwszd(kjkjxmxxbForm.getDwszd());
		kjkjxmxxb.setTxdz(kjkjxmxxbForm.getTxdz());
		kjkjxmxxb.setYb(kjkjxmxxbForm.getYb());
		kjkjxmxxb.setDwxz(kjkjxmxxbForm.getDwxz());
		kjkjxmxxb.setSjbm(kjkjxmxxbForm.getSjbm());
		kjkjxmxxb.setFzr(kjkjxmxxbForm.getFzr());
		kjkjxmxxb.setXb(kjkjxmxxbForm.getXb());
		kjkjxmxxb.setCsn(kjkjxmxxbForm.getCsn());
		kjkjxmxxb.setXl(kjkjxmxxbForm.getXl());
		kjkjxmxxb.setZc(kjkjxmxxbForm.getZc());
		kjkjxmxxb.setLxdh(kjkjxmxxbForm.getLxdh());
		kjkjxmxxb.setEmail(kjkjxmxxbForm.getEmail());
		kjkjxmxxb.setXmzrs(kjkjxmxxbForm.getXmzrs());
		kjkjxmxxb.setGj(kjkjxmxxbForm.getGj());
		kjkjxmxxb.setZj(kjkjxmxxbForm.getZj());
		kjkjxmxxb.setCj(kjkjxmxxbForm.getCj());
		kjkjxmxxb.setQt(kjkjxmxxbForm.getQt());
		kjkjxmxxb.setQssj(kjkjxmxxbForm.getQssj());
		kjkjxmxxb.setZzsj(kjkjxmxxbForm.getZzsj());
		kjkjxmxxb.setXmhdlx(kjkjxmxxbForm.getXmhdlx());
		kjkjxmxxb.setSsly(kjkjxmxxbForm.getSsly());
		kjkjxmxxb.setXmjsly(kjkjxmxxbForm.getXmjsly());
		kjkjxmxxb.setZyyfnr(kjkjxmxxbForm.getZyyfnr());
		kjkjxmxxb.setCgxs(kjkjxmxxbForm.getCgxs());
		kjkjxmxxb.setYqzl(kjkjxmxxbForm.getYqzl());
		kjkjxmxxb.setZjf(kjkjxmxxbForm.getZjf());
		kjkjxmxxb.setSbk(kjkjxmxxbForm.getSbk());
		return kjkjxmxxb;
	}
	public void addCjdwListWithExpertId(int id, List<KjkjxmxxbcjdwForm> list){
		List<Kjkjxmxxbcjdw> Plist=this.cjdwPoToVoList(list);
		Kjkjxmxxb kjkjxmxxb= kjkjxmxxbDao.findObjectByID(id);

		try{
			System.out.println(kjkjxmxxb.getKjkjxmxxbcjdws());
		//kjkjxmxxb.getKjkjxmxxbcjdws().add(Plist.get(0));
		}catch(Exception e){System.out.println(e);}
		//		for(int i=0;i<Plist.size();i++){
//			kjkjxmxxb.getKjkjxmxxbcjdws().add(Plist.get(i));
//		}
		
	}
	
	private List<Kjkjxmxxbcjdw> cjdwPoToVoList(List<KjkjxmxxbcjdwForm> list) {
		List<Kjkjxmxxbcjdw> Plist=new ArrayList<Kjkjxmxxbcjdw>();
		for(int i=0;i<list.size();i++){
			Kjkjxmxxbcjdw kjkjxmxxbcjdw=new Kjkjxmxxbcjdw();
			
			kjkjxmxxbcjdw.setXh(list.get(i).getXh());
			kjkjxmxxbcjdw.setDwmc(list.get(i).getDwmc());
	//		kjkjxmxxbcjdw.setFk_kj_kjxmxxb(list.get(i).getFk_kj_kjxmxxb());
			
			
			
			Plist.add(kjkjxmxxbcjdw);
		}
		return Plist;
	}

	

	public List<KjkjxmxxbForm> findKjkjxmxxbList(KjkjxmxxbForm kjkjxmxxbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjkjxmxxbForm!=null&&StringUtils.isNotBlank(kjkjxmxxbForm.getXmbh())){
			hqlWhere += " and o.xmbh = ?";
			paramsList.add(kjkjxmxxbForm.getXmbh());
		}
		orderby.put(" o.qssj", "desc");
		params = paramsList.toArray();
		List<Kjkjxmxxb> list=kjkjxmxxbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjkjxmxxbForm> formlist=this.KjkjxmxxbPoToVoList(list);
		return formlist;
	}

	private List<KjkjxmxxbForm> KjkjxmxxbPoToVoList(List<Kjkjxmxxb> list) {
		List<KjkjxmxxbForm> formlist=new ArrayList<KjkjxmxxbForm>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			KjkjxmxxbForm kjkjxmxxbForm=new KjkjxmxxbForm();
			kjkjxmxxbForm.setXmbh(list.get(i).getXmbh());
			kjkjxmxxbForm.setXmmc(list.get(i).getXmmc());
			kjkjxmxxbForm.setCjdws(list.get(i).getCjdws());
			kjkjxmxxbForm.setDwmc(list.get(i).getDwmc());
			kjkjxmxxbForm.setDwszd(list.get(i).getDwszd());
			kjkjxmxxbForm.setTxdz(list.get(i).getTxdz());
			kjkjxmxxbForm.setYb(list.get(i).getYb());
			kjkjxmxxbForm.setDwxz(list.get(i).getDwxz());
			kjkjxmxxbForm.setSjbm(list.get(i).getSjbm());
			kjkjxmxxbForm.setFzr(list.get(i).getFzr());
			kjkjxmxxbForm.setXb(list.get(i).getXb());
			kjkjxmxxbForm.setCsn(list.get(i).getCsn());
			kjkjxmxxbForm.setXl(list.get(i).getXl());
			kjkjxmxxbForm.setZc(list.get(i).getZc());
			kjkjxmxxbForm.setLxdh(list.get(i).getLxdh());
			kjkjxmxxbForm.setEmail(list.get(i).getEmail());
			kjkjxmxxbForm.setXmzrs(list.get(i).getXmzrs());
			kjkjxmxxbForm.setGj(list.get(i).getGj());
			kjkjxmxxbForm.setZj(list.get(i).getZj());
			kjkjxmxxbForm.setCj(list.get(i).getCj());
			kjkjxmxxbForm.setQt(list.get(i).getQt());
			kjkjxmxxbForm.setQssj(list.get(i).getQssj());
			kjkjxmxxbForm.setZzsj(list.get(i).getZzsj());
			kjkjxmxxbForm.setXmhdlx(list.get(i).getXmhdlx());
			kjkjxmxxbForm.setSsly(list.get(i).getSsly());
			kjkjxmxxbForm.setXmjsly(list.get(i).getXmjsly());
			kjkjxmxxbForm.setZyyfnr(list.get(i).getZyyfnr());
			kjkjxmxxbForm.setCgxs(list.get(i).getCgxs());
			kjkjxmxxbForm.setYqzl(list.get(i).getYqzl());
			kjkjxmxxbForm.setZjf(list.get(i).getZjf());
			kjkjxmxxbForm.setSbk(list.get(i).getSbk());
			
			
			
			kjkjxmxxbForm.setKjkjxmxxbcjdws(KjkjxmxxbcjdwSetToFormList(list.get(i).getKjkjxmxxbcjdws()));
			
			formlist.add(kjkjxmxxbForm);
		}}
		return formlist;
	}

	private List<KjkjxmxxbcjdwForm> KjkjxmxxbcjdwSetToFormList(
			Set<Kjkjxmxxbcjdw> kjkjxmxxbcjdws) {
   List<KjkjxmxxbcjdwForm> formlist=new ArrayList<KjkjxmxxbcjdwForm>();
   if(kjkjxmxxbcjdws.size()>0){
		for(Kjkjxmxxbcjdw kjkjxmxxbcjdw:kjkjxmxxbcjdws){
			KjkjxmxxbcjdwForm kjkjxmxxbcjdwForm=new KjkjxmxxbcjdwForm();
			kjkjxmxxbcjdwForm.setXh(kjkjxmxxbcjdw.getXh());
			kjkjxmxxbcjdwForm.setDwmc(kjkjxmxxbcjdw.getDwmc());
	//		kjkjxmxxbcjdwForm.setFk_kj_kjxmxxb(kjkjxmxxbcjdw.getFk_kj_kjxmxxb());
			
			
			formlist.add(kjkjxmxxbcjdwForm);
		}}
		return formlist;
	}

}