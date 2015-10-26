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
import platform.domain.Kjjszjcjbxm;
import platform.form.KjjszjcjbForm;
import platform.form.KjjszjcjbxmForm;
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

	private List<Kjjszjcjbxm> xmPoToVoList(List<KjjszjcjbxmForm> list) {
		List<Kjjszjcjbxm> Plist=new ArrayList<Kjjszjcjbxm>();
		for(int i=0;i<list.size();i++){
			Kjjszjcjbxm kjjszjcjbxm=new Kjjszjcjbxm();
			kjjszjcjbxm.setHzsj(list.get(i).getHzsj());
			kjjszjcjbxm.setXmjj(list.get(i).getXmjj());
			kjjszjcjbxm.setXmmc(list.get(i).getXmjj());
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
