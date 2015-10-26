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
import platform.form.KjjszjcjbForm;
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
	
}
