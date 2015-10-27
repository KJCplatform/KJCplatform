package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.KjjszjcjbDao;
import platform.domain.Kjjszjcjb;
import platform.domain.Kjjszjcjbcg;
import platform.domain.Kjjszjcjbxm;
import platform.domain.Kjjszjcjbzy;
import platform.form.KjjszjcjbForm;
import platform.form.KjjszjcjbcgForm;
import platform.form.KjjszjcjbxmForm;
import platform.form.KjjszjcjbzyForm;
import platform.service.KjjszjcjbService;
import platform.util.StringHelper;
@Transactional
@Service(KjjszjcjbService.SERVICE_NAME)
public class KjjszjcjbServiceImpl implements KjjszjcjbService{
	
	@Resource(name=KjjszjcjbDao.SERVICE_NAME)
	private KjjszjcjbDao kjjszjcjbDao;

	public String saveKjjszjcjb(KjjszjcjbForm kjjszjcjbForm){
		Kjjszjcjb kjjszjcjb=this.VoObjecttoPoObject(kjjszjcjbForm);
		kjjszjcjbDao.save(kjjszjcjb);
		return kjjszjcjbDao.selectMaxId();
		
	}

	private Kjjszjcjb VoObjecttoPoObject(KjjszjcjbForm kjjszjcjbForm) {
		Kjjszjcjb kjjszjcjb=new Kjjszjcjb();
		kjjszjcjb.setFwyy(kjjszjcjbForm.getFwyy());
		kjjszjcjb.setGzbm(kjjszjcjbForm.getGzbm());
		kjjszjcjb.setGzdw(kjjszjcjbForm.getGzdw());
		kjjszjcjb.setHyly(kjjszjcjbForm.getHyly());
		kjjszjcjb.setJsly(kjjszjcjbForm.getJsly());
		kjjszjcjb.setJszc(kjjszjcjbForm.getJszc());
		kjjszjcjb.setLxdh(kjjszjcjbForm.getLxdh());
		kjjszjcjb.setLxdz(kjjszjcjbForm.getLxdz());
		if(kjjszjcjbForm.getSfgk().equals("是")){
		kjjszjcjb.setSfgk(true);}
		else if(kjjszjcjbForm.getSfgk().equals("否"))
		{kjjszjcjb.setSfgk(false);}
		kjjszjcjb.setSfzh(kjjszjcjbForm.getSfzh());
		kjjszjcjb.setSj(kjjszjcjbForm.getSj());
		kjjszjcjb.setSzdq(kjjszjcjbForm.getSzdq());
		kjjszjcjb.setSzpt(kjjszjcjbForm.getSzpt());
		kjjszjcjb.setXb(kjjszjcjbForm.getXb());
		kjjszjcjb.setXkly(kjjszjcjbForm.getXkly());
		kjjszjcjb.setYx(kjjszjcjbForm.getYx());
		kjjszjcjb.setZgxl(kjjszjcjbForm.getZgxl());
		kjjszjcjb.setZjjj(kjjszjcjbForm.getZjjj());
		kjjszjcjb.setZjxm(kjjszjcjbForm.getZjxm());
		kjjszjcjb.setZw(kjjszjcjbForm.getZw());
		kjjszjcjb.setZytc(kjjszjcjbForm.getZytc());
		
		
		return kjjszjcjb;
	}
	public void addCxyListWithExpertId(int id, List<KjjszjcjbxmForm> list){
		List<Kjjszjcjbxm> Plist=this.xmPoToVoList(list);
		Kjjszjcjb kjjszjcjb= kjjszjcjbDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			kjjszjcjb.getKjjszjcjbxms().add(Plist.get(i));
		}
	}
	public void addJscgListWithExpertId(int id, List<KjjszjcjbcgForm> list){
		List<Kjjszjcjbcg> Plist=this.cgPoToVoList(list);
		Kjjszjcjb kjjszjcjb= kjjszjcjbDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			kjjszjcjb.getKjjszjcjbcgs().add(Plist.get(i));
		}
		
	}
	public void addzyListWithExpertId(int id, List<KjjszjcjbzyForm> list){
		List<Kjjszjcjbzy> Plist=this.zyPoToVoList(list);
		Kjjszjcjb kjjszjcjb= kjjszjcjbDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			kjjszjcjb.getKjjszjcjbzys().add(Plist.get(i));
		}
	}
	private List<Kjjszjcjbzy> zyPoToVoList(List<KjjszjcjbzyForm> list) {
		List<Kjjszjcjbzy> Plist=new ArrayList<Kjjszjcjbzy>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjbzy kjjszjcjbzy=new Kjjszjcjbzy();
			kjjszjcjbzy.setWcsj(StringHelper.stringConvertDate2(list.get(i).getWcsj()));
			kjjszjcjbzy.setXmjj(list.get(i).getXmjj());
			kjjszjcjbzy.setXmmc(list.get(i).getXmmc());
			if(list.get(i).getSfzh().equals("是")){
				kjjszjcjbzy.setSfzh(true);
			}else if(list.get(i).getSfzh().equals("否")){
				kjjszjcjbzy.setSfzh(false);
			}
			Plist.add(kjjszjcjbzy);
		}
		return Plist;
	}

	private List<Kjjszjcjbcg> cgPoToVoList(List<KjjszjcjbcgForm> list) {
		List<Kjjszjcjbcg> Plist=new ArrayList<Kjjszjcjbcg>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjbcg kjjszjcjbcg=new Kjjszjcjbcg();
			kjjszjcjbcg.setWcsj(StringHelper.stringConvertDate2(list.get(i).getWcsj()));
			kjjszjcjbcg.setCgjj(list.get(i).getCgjj());
			kjjszjcjbcg.setCgmc(list.get(i).getCgmc());
			if(list.get(i).getZhqk().equals("已转化，继续转化")){
				kjjszjcjbcg.setZhqk(true);
			}else if(list.get(i).getZhqk().equals("未转化，希望转化")){
				kjjszjcjbcg.setZhqk(false);
			}
			Plist.add(kjjszjcjbcg);
		}
		return Plist;
	}

	private List<Kjjszjcjbxm> xmPoToVoList(List<KjjszjcjbxmForm> list) {
		List<Kjjszjcjbxm> Plist=new ArrayList<Kjjszjcjbxm>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjbxm kjjszjcjbxm=new Kjjszjcjbxm();
			kjjszjcjbxm.setHzsj(list.get(i).getHzsj());
			kjjszjcjbxm.setXmjj(list.get(i).getXmjj());
			kjjszjcjbxm.setXmmc(list.get(i).getXmmc());
			if(list.get(i).getHzxg().equals("良好")){
				kjjszjcjbxm.setHzxg(true);
			}else if(list.get(i).getHzxg().equals("一般")){
				kjjszjcjbxm.setHzxg(false);
			}
			Plist.add(kjjszjcjbxm);
		}
		return Plist;
	}
}
