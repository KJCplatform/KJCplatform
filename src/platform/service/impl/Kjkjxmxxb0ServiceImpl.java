package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.Kjkjxmxxb0Dao;
import platform.domain.Kjkjxmxxb0;
import platform.form.Kjkjxmxxb0Form;
import platform.service.Kjkjxmxxb0Service;
import platform.util.StringHelper;
@Transactional
@Service(Kjkjxmxxb0Service.SERVICE_NAME)
public class Kjkjxmxxb0ServiceImpl implements Kjkjxmxxb0Service{
	
	@Resource(name=Kjkjxmxxb0Dao.SERVICE_NAME)
	private Kjkjxmxxb0Dao kjkjxmxxb0Dao;
	
	public List<Kjkjxmxxb0Form> findKjkjxmxxb0List(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Kjkjxmxxb0> list=kjkjxmxxb0Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjkjxmxxb0Form> formlist=this.Kjkjxmxxb0POListToVOList(list);
		return formlist;
		
	}
	public List<Kjkjxmxxb0Form> findKjkjxmxxb0ListWithPage(int pagesize,int pageno,Kjkjxmxxb0Form Kjkjxmxxb0Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(Kjkjxmxxb0Form!=null&&StringUtils.isNotBlank(Kjkjxmxxb0Form.getXmbh())){
			hqlWhere += " and o.xmbh like ?";
			paramsList.add("%"+Kjkjxmxxb0Form.getXmbh()+"%");
		}
		if(Kjkjxmxxb0Form!=null&&StringUtils.isNotBlank(Kjkjxmxxb0Form.getXmmc())){
			hqlWhere += " and o.xmmc like ?";
			paramsList.add("%"+Kjkjxmxxb0Form.getXmmc()+"%");
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Kjkjxmxxb0> list=kjkjxmxxb0Dao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<Kjkjxmxxb0Form> formlist=this.Kjkjxmxxb0POListToVOList(list);
		return formlist;
		
	}
	
	public void updateKjkjxmxxb0(Kjkjxmxxb0Form kjkjxmxxb0Form){
		Kjkjxmxxb0 kjkjxmxxb0=new Kjkjxmxxb0();
		kjkjxmxxb0.setId(Integer.valueOf(kjkjxmxxb0Form.getId()));
		kjkjxmxxb0.setXmbh(kjkjxmxxb0Form.getXmbh());
		kjkjxmxxb0.setXmmc(kjkjxmxxb0Form.getXmmc());
		kjkjxmxxb0.setCjdws(kjkjxmxxb0Form.getCjdws());
		kjkjxmxxb0.setDwmc(kjkjxmxxb0Form.getDwmc());
		kjkjxmxxb0.setDwszd(kjkjxmxxb0Form.getDwszd());
		kjkjxmxxb0.setTxdz(kjkjxmxxb0Form.getTxdz());
		kjkjxmxxb0.setYb(kjkjxmxxb0Form.getYb());
		kjkjxmxxb0.setDwxz(kjkjxmxxb0Form.getDwxz());
		kjkjxmxxb0.setSjbm(kjkjxmxxb0Form.getSjbm());
		kjkjxmxxb0.setFzr(kjkjxmxxb0Form.getFzr());
		kjkjxmxxb0.setXb(kjkjxmxxb0Form.getXb());
		kjkjxmxxb0.setCsn(kjkjxmxxb0Form.getCsn());
		kjkjxmxxb0.setXl(kjkjxmxxb0Form.getXl());
		kjkjxmxxb0.setZc(kjkjxmxxb0Form.getZc());
		kjkjxmxxb0.setLxdh(kjkjxmxxb0Form.getLxdh());
		kjkjxmxxb0.setEmail(kjkjxmxxb0Form.getEmail());
		kjkjxmxxb0.setXmzrs(kjkjxmxxb0Form.getXmzrs());
		kjkjxmxxb0.setGj(kjkjxmxxb0Form.getGj());
		kjkjxmxxb0.setZj(kjkjxmxxb0Form.getZj());
		kjkjxmxxb0.setCj(kjkjxmxxb0Form.getCj());
		kjkjxmxxb0.setQt(kjkjxmxxb0Form.getQt());
		kjkjxmxxb0.setQssj(kjkjxmxxb0Form.getQssj());
		kjkjxmxxb0.setZzsj(kjkjxmxxb0Form.getZzsj());
		kjkjxmxxb0.setXmhdlx(kjkjxmxxb0Form.getXmhdlx());
		kjkjxmxxb0.setSsly(kjkjxmxxb0Form.getSsly());
		kjkjxmxxb0.setXmjsly(kjkjxmxxb0Form.getXmjsly());
		kjkjxmxxb0.setZyyfnr(kjkjxmxxb0Form.getZyyfnr());
		kjkjxmxxb0.setCgxs(kjkjxmxxb0Form.getCgxs());
		kjkjxmxxb0.setYqzl(kjkjxmxxb0Form.getYqzl());
		kjkjxmxxb0.setZjf(kjkjxmxxb0Form.getZjf());
		kjkjxmxxb0.setSbk(kjkjxmxxb0Form.getSbk());
		kjkjxmxxb0.setJlnf(kjkjxmxxb0Form.getJlnf());
		kjkjxmxxb0.setUsername(kjkjxmxxb0Form.getUsername());
		kjkjxmxxb0.setGxsj(kjkjxmxxb0Form.getGxsj());
		kjkjxmxxb0.setSubmit(kjkjxmxxb0Form.getSubmit());
		kjkjxmxxb0Dao.update(kjkjxmxxb0);
		
	}
	/*blic void updateKjkjxmxxb0Withget(Kjkjxmxxb0Form Kjkjxmxxb0Form){
		Kjkjxmxxb0 Kjkjxmxxb0=Kjkjxmxxb0Dao.findObjectByID(Integer.valueOf(Kjkjxmxxb0Form.getId()));
		Kjkjxmxxb0.setCljg("chenggong");
	}*/
	public void deleteObject(String id){
		kjkjxmxxb0Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(Kjkjxmxxb0Form kjkjxmxxb0Form){
		Kjkjxmxxb0 kjkjxmxxb0=new Kjkjxmxxb0();
		kjkjxmxxb0.setXmbh(kjkjxmxxb0Form.getXmbh());
		kjkjxmxxb0.setXmmc(kjkjxmxxb0Form.getXmmc());
		kjkjxmxxb0.setCjdws(kjkjxmxxb0Form.getCjdws());
		kjkjxmxxb0.setDwmc(kjkjxmxxb0Form.getDwmc());
		kjkjxmxxb0.setDwszd(kjkjxmxxb0Form.getDwszd());
		kjkjxmxxb0.setTxdz(kjkjxmxxb0Form.getTxdz());
		kjkjxmxxb0.setYb(kjkjxmxxb0Form.getYb());
		kjkjxmxxb0.setDwxz(kjkjxmxxb0Form.getDwxz());
		kjkjxmxxb0.setSjbm(kjkjxmxxb0Form.getSjbm());
		kjkjxmxxb0.setFzr(kjkjxmxxb0Form.getFzr());
		kjkjxmxxb0.setXb(kjkjxmxxb0Form.getXb());
		kjkjxmxxb0.setCsn(kjkjxmxxb0Form.getCsn());
		kjkjxmxxb0.setXl(kjkjxmxxb0Form.getXl());
		kjkjxmxxb0.setZc(kjkjxmxxb0Form.getZc());
		kjkjxmxxb0.setLxdh(kjkjxmxxb0Form.getLxdh());
		kjkjxmxxb0.setEmail(kjkjxmxxb0Form.getEmail());
		kjkjxmxxb0.setXmzrs(kjkjxmxxb0Form.getXmzrs());
		kjkjxmxxb0.setGj(kjkjxmxxb0Form.getGj());
		kjkjxmxxb0.setZj(kjkjxmxxb0Form.getZj());
		kjkjxmxxb0.setCj(kjkjxmxxb0Form.getCj());
		kjkjxmxxb0.setQt(kjkjxmxxb0Form.getQt());
		kjkjxmxxb0.setQssj(kjkjxmxxb0Form.getQssj());
		kjkjxmxxb0.setZzsj(kjkjxmxxb0Form.getZzsj());
		kjkjxmxxb0.setXmhdlx(kjkjxmxxb0Form.getXmhdlx());
		kjkjxmxxb0.setSsly(kjkjxmxxb0Form.getSsly());
		kjkjxmxxb0.setXmjsly(kjkjxmxxb0Form.getXmjsly());
		kjkjxmxxb0.setZyyfnr(kjkjxmxxb0Form.getZyyfnr());
		kjkjxmxxb0.setCgxs(kjkjxmxxb0Form.getCgxs());
		kjkjxmxxb0.setYqzl(kjkjxmxxb0Form.getYqzl());
		kjkjxmxxb0.setZjf(kjkjxmxxb0Form.getZjf());
		kjkjxmxxb0.setSbk(kjkjxmxxb0Form.getSbk());
		
		kjkjxmxxb0.setJlnf(kjkjxmxxb0Form.getJlnf());
		kjkjxmxxb0.setUsername(kjkjxmxxb0Form.getUsername());
		kjkjxmxxb0.setGxsj(kjkjxmxxb0Form.getGxsj());
		kjkjxmxxb0.setSubmit(kjkjxmxxb0Form.getSubmit());
		
		kjkjxmxxb0Dao.save(kjkjxmxxb0);
	}
	private List<Kjkjxmxxb0Form> Kjkjxmxxb0POListToVOList(List<Kjkjxmxxb0> list) {
		// TODO Auto-generated method stub
		List<Kjkjxmxxb0Form> formlist=new ArrayList<Kjkjxmxxb0Form>();
		for(int i=0;i<list.size();i++){
            Kjkjxmxxb0Form kjkjxmxxb0Form=new Kjkjxmxxb0Form();
			
            kjkjxmxxb0Form.setId(String.valueOf(list.get(i).getId()));
            kjkjxmxxb0Form.setXmbh(list.get(i).getXmbh());
            kjkjxmxxb0Form.setXmmc(list.get(i).getXmmc());
            kjkjxmxxb0Form.setCjdws(list.get(i).getCjdws());
            kjkjxmxxb0Form.setDwmc(list.get(i).getDwmc());
            kjkjxmxxb0Form.setDwszd(list.get(i).getDwszd());
            kjkjxmxxb0Form.setTxdz(list.get(i).getTxdz());
            kjkjxmxxb0Form.setYb(list.get(i).getYb());
            kjkjxmxxb0Form.setDwxz(list.get(i).getDwxz());
            kjkjxmxxb0Form.setSjbm(list.get(i).getSjbm());
            kjkjxmxxb0Form.setFzr(list.get(i).getFzr());
            kjkjxmxxb0Form.setXb(list.get(i).getXb());
            kjkjxmxxb0Form.setCsn(list.get(i).getCsn());
            kjkjxmxxb0Form.setXl(list.get(i).getXl());
            kjkjxmxxb0Form.setZc(list.get(i).getZc());
            kjkjxmxxb0Form.setLxdh(list.get(i).getLxdh());
            kjkjxmxxb0Form.setEmail(list.get(i).getEmail());
            kjkjxmxxb0Form.setXmzrs(list.get(i).getXmzrs());
            kjkjxmxxb0Form.setGj(list.get(i).getGj());
            kjkjxmxxb0Form.setZj(list.get(i).getZj());
            kjkjxmxxb0Form.setCj(list.get(i).getCj());
            kjkjxmxxb0Form.setQt(list.get(i).getQt());
            kjkjxmxxb0Form.setQssj(list.get(i).getQssj());
            kjkjxmxxb0Form.setZzsj(list.get(i).getZzsj());
            kjkjxmxxb0Form.setXmhdlx(list.get(i).getXmhdlx());
            kjkjxmxxb0Form.setSsly(list.get(i).getSsly());
            kjkjxmxxb0Form.setXmjsly(list.get(i).getXmjsly());
            kjkjxmxxb0Form.setZyyfnr(list.get(i).getZyyfnr());
            kjkjxmxxb0Form.setCgxs(list.get(i).getCgxs());
            kjkjxmxxb0Form.setYqzl(list.get(i).getYqzl());
            kjkjxmxxb0Form.setZjf(list.get(i).getZjf());
            kjkjxmxxb0Form.setSbk(list.get(i).getSbk());
			
			kjkjxmxxb0Form.setJlnf(list.get(i).getJlnf());
			kjkjxmxxb0Form.setUsername(list.get(i).getUsername());
			kjkjxmxxb0Form.setGxsj(list.get(i).getGxsj());
			kjkjxmxxb0Form.setSubmit(list.get(i).getSubmit());
			
			formlist.add(kjkjxmxxb0Form);
		}
		return formlist;
	}

	
}
