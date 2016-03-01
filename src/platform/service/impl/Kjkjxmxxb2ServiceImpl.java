package platform.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.Kjkjxmxxb2Dao;
import platform.domain.Kjkjxmxxb2;
import platform.domain.Kjkjxmxxb2cjdw;
import platform.domain.Kjndgfjtjb;
import platform.form.Kjkjxmxxb2Form;
import platform.form.Kjkjxmxxb2cjdwForm;
import platform.form.KjndgfjtjbForm;
import platform.service.Kjkjxmxxb2Service;

@Transactional

@Service(Kjkjxmxxb2Service.SERVICE_NAME)
public class Kjkjxmxxb2ServiceImpl implements Kjkjxmxxb2Service{
	
	@Resource(name=Kjkjxmxxb2Dao.SERVICE_NAME)
	private Kjkjxmxxb2Dao kjkjxmxxb2Dao;

	public String saveKjkjxmxxb2(Kjkjxmxxb2Form kjkjxmxxb2Form,String username){
		Kjkjxmxxb2 kjkjxmxxb2=this.VoObjecttoPoObject(kjkjxmxxb2Form);
		
		kjkjxmxxb2.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjkjxmxxb2.setUsername(username);
		kjkjxmxxb2.setGxsj(new Date().toString());
		kjkjxmxxb2.setSubmit(0);
		
		try{
		kjkjxmxxb2Dao.save(kjkjxmxxb2);
		}catch(Exception e){System.out.println(e);}
		return kjkjxmxxb2Dao.selectMaxId();
		
	}

	private Kjkjxmxxb2 VoObjecttoPoObject(Kjkjxmxxb2Form kjkjxmxxb2Form) {
		Kjkjxmxxb2 kjkjxmxxb2=new Kjkjxmxxb2();
	//	kjkjxmxxb2.setId(Integer.valueOf(kjkjxmxxb2Form.getId()));
		kjkjxmxxb2.setXmbh(kjkjxmxxb2Form.getXmbh());
		kjkjxmxxb2.setXmmc(kjkjxmxxb2Form.getXmmc());
		kjkjxmxxb2.setCjdws(kjkjxmxxb2Form.getCjdws());
		kjkjxmxxb2.setDwmc(kjkjxmxxb2Form.getDwmc());
		kjkjxmxxb2.setDwszd(kjkjxmxxb2Form.getDwszd());
		kjkjxmxxb2.setTxdz(kjkjxmxxb2Form.getTxdz());
		kjkjxmxxb2.setYb(kjkjxmxxb2Form.getYb());
		kjkjxmxxb2.setDwxz(kjkjxmxxb2Form.getDwxz());
		kjkjxmxxb2.setSjbm(kjkjxmxxb2Form.getSjbm());
		kjkjxmxxb2.setFzr(kjkjxmxxb2Form.getFzr());
		kjkjxmxxb2.setXb(kjkjxmxxb2Form.getXb());
		kjkjxmxxb2.setCsn(kjkjxmxxb2Form.getCsn());
		kjkjxmxxb2.setXl(kjkjxmxxb2Form.getXl());
		kjkjxmxxb2.setZc(kjkjxmxxb2Form.getZc());
		kjkjxmxxb2.setLxdh(kjkjxmxxb2Form.getLxdh());
		kjkjxmxxb2.setEmail(kjkjxmxxb2Form.getEmail());
		kjkjxmxxb2.setXmzrs(kjkjxmxxb2Form.getXmzrs());
		kjkjxmxxb2.setGj(kjkjxmxxb2Form.getGj());
		kjkjxmxxb2.setZj(kjkjxmxxb2Form.getZj());
		kjkjxmxxb2.setCj(kjkjxmxxb2Form.getCj());
		kjkjxmxxb2.setQt(kjkjxmxxb2Form.getQt());
		kjkjxmxxb2.setQssj(kjkjxmxxb2Form.getQssj());
		kjkjxmxxb2.setZzsj(kjkjxmxxb2Form.getZzsj());
		kjkjxmxxb2.setXmhdlx(kjkjxmxxb2Form.getXmhdlx());
		kjkjxmxxb2.setSsly(kjkjxmxxb2Form.getSsly());
		kjkjxmxxb2.setXmjsly(kjkjxmxxb2Form.getXmjsly());
		kjkjxmxxb2.setZyyfnr(kjkjxmxxb2Form.getZyyfnr());
		kjkjxmxxb2.setCgxs(kjkjxmxxb2Form.getCgxs());
		kjkjxmxxb2.setYqzl(kjkjxmxxb2Form.getYqzl());
		kjkjxmxxb2.setZjf(kjkjxmxxb2Form.getZjf());
		kjkjxmxxb2.setSbk(kjkjxmxxb2Form.getSbk());

		return kjkjxmxxb2;
	}
	public void addCjdwListWithExpertId(int id, List<Kjkjxmxxb2cjdwForm> list){
//		System.out.println("hhs1:"+list.get(0).getXh());
		List<Kjkjxmxxb2cjdw> Plist=this.cjdwPoToVoList(list);
//		System.out.println("hhs2:"+Plist.get(0).getXh());
		
		Kjkjxmxxb2 kjkjxmxxb2= kjkjxmxxb2Dao.findObjectByID(id);
//		private Integer id;
//		private String xh;
//		private String dwmc;
//		private Set<Kjkjxmxxb2> Kjkjxmxxb2s = new HashSet<Kjkjxmxxb2>();
		
		
//		System.out.println("hh:"+Plist.get(0).getDwmc());
//		System.out.println("hh:"+Plist.get(0).getXh());
//		System.out.println("hh:"+Plist.get(0).getId());
//		System.out.println("hh:"+Plist.get(0).getKjkjxmxxb2s());
		
		try{
		
		for(int i=0;i<Plist.size();i++){
			kjkjxmxxb2.getKjkjxmxxb2cjdws().add(Plist.get(i));
		}
		
		}catch(Exception e){System.out.println(e);}
		
	}
	
	private List<Kjkjxmxxb2cjdw> cjdwPoToVoList(List<Kjkjxmxxb2cjdwForm> list) {
		List<Kjkjxmxxb2cjdw> Plist=new ArrayList<Kjkjxmxxb2cjdw>();
		for(int i=0;i<list.size();i++){
			Kjkjxmxxb2cjdw kjkjxmxxb2cjdw=new Kjkjxmxxb2cjdw();
			kjkjxmxxb2cjdw.setDwmc(list.get(i).getDwmc());
			kjkjxmxxb2cjdw.setXh(list.get(i).getXh());
	//		kjkjxmxxb2cjdw.setFk_kj_kjxmxxb(list.get(i).getFk_kj_kjxmxxb());
			
			
			
			Plist.add(kjkjxmxxb2cjdw);
		}
		return Plist;
	}

	

	public List<Kjkjxmxxb2Form> findKjkjxmxxb2List(Kjkjxmxxb2Form kjkjxmxxb2Form){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjkjxmxxb2Form!=null&&StringUtils.isNotBlank(kjkjxmxxb2Form.getXmbh())){
			hqlWhere += " and o.xmbh = ?";
			paramsList.add(kjkjxmxxb2Form.getXmbh());
		}
		orderby.put(" o.qssj", "desc");
		params = paramsList.toArray();
		List<Kjkjxmxxb2> list=kjkjxmxxb2Dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<Kjkjxmxxb2Form> formlist=this.Kjkjxmxxb2PoToVoList(list);
		return formlist;
	}

	private List<Kjkjxmxxb2Form> Kjkjxmxxb2PoToVoList(List<Kjkjxmxxb2> list) {
		List<Kjkjxmxxb2Form> formlist=new ArrayList<Kjkjxmxxb2Form>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			
			Kjkjxmxxb2Form kjkjxmxxb2Form=new Kjkjxmxxb2Form();
			
			kjkjxmxxb2Form.setId(String.valueOf(list.get(i).getId()));
			
			kjkjxmxxb2Form.setXmbh(list.get(i).getXmbh());
			kjkjxmxxb2Form.setXmmc(list.get(i).getXmmc());
			kjkjxmxxb2Form.setCjdws(list.get(i).getCjdws());
			kjkjxmxxb2Form.setDwmc(list.get(i).getDwmc());
			kjkjxmxxb2Form.setDwszd(list.get(i).getDwszd());
			kjkjxmxxb2Form.setTxdz(list.get(i).getTxdz());
			kjkjxmxxb2Form.setYb(list.get(i).getYb());
			kjkjxmxxb2Form.setDwxz(list.get(i).getDwxz());
			kjkjxmxxb2Form.setSjbm(list.get(i).getSjbm());
			kjkjxmxxb2Form.setFzr(list.get(i).getFzr());
			kjkjxmxxb2Form.setXb(list.get(i).getXb());
			kjkjxmxxb2Form.setCsn(list.get(i).getCsn());
			kjkjxmxxb2Form.setXl(list.get(i).getXl());
			kjkjxmxxb2Form.setZc(list.get(i).getZc());
			kjkjxmxxb2Form.setLxdh(list.get(i).getLxdh());
			kjkjxmxxb2Form.setEmail(list.get(i).getEmail());
			kjkjxmxxb2Form.setXmzrs(list.get(i).getXmzrs());
			kjkjxmxxb2Form.setGj(list.get(i).getGj());
			kjkjxmxxb2Form.setZj(list.get(i).getZj());
			kjkjxmxxb2Form.setCj(list.get(i).getCj());
			kjkjxmxxb2Form.setQt(list.get(i).getQt());
			kjkjxmxxb2Form.setQssj(list.get(i).getQssj());
			kjkjxmxxb2Form.setZzsj(list.get(i).getZzsj());
			kjkjxmxxb2Form.setXmhdlx(list.get(i).getXmhdlx());
			kjkjxmxxb2Form.setSsly(list.get(i).getSsly());
			kjkjxmxxb2Form.setXmjsly(list.get(i).getXmjsly());
			kjkjxmxxb2Form.setZyyfnr(list.get(i).getZyyfnr());
			kjkjxmxxb2Form.setCgxs(list.get(i).getCgxs());
			kjkjxmxxb2Form.setYqzl(list.get(i).getYqzl());
			kjkjxmxxb2Form.setZjf(list.get(i).getZjf());
			kjkjxmxxb2Form.setSbk(list.get(i).getSbk());
			
			kjkjxmxxb2Form.setJlnf(list.get(i).getJlnf());
			kjkjxmxxb2Form.setUsername(list.get(i).getUsername());
			kjkjxmxxb2Form.setGxsj(list.get(i).getGxsj());
			kjkjxmxxb2Form.setSubmit(String.valueOf(list.get(i).getSubmit()));
			
			kjkjxmxxb2Form.setKjkjxmxxb2cjdws(Kjkjxmxxb2cjdwSetToFormList(list.get(i).getKjkjxmxxb2cjdws()));
			
			formlist.add(kjkjxmxxb2Form);
		}}
		return formlist;
	}

	private List<Kjkjxmxxb2cjdwForm> Kjkjxmxxb2cjdwSetToFormList(
			Set<Kjkjxmxxb2cjdw> kjkjxmxxb2cjdws) {
   List<Kjkjxmxxb2cjdwForm> formlist=new ArrayList<Kjkjxmxxb2cjdwForm>();
   if(kjkjxmxxb2cjdws.size()>0){
		for(Kjkjxmxxb2cjdw kjkjxmxxb2cjdw:kjkjxmxxb2cjdws){
			Kjkjxmxxb2cjdwForm kjkjxmxxb2cjdwForm=new Kjkjxmxxb2cjdwForm();
			kjkjxmxxb2cjdwForm.setXh(kjkjxmxxb2cjdw.getXh());
			kjkjxmxxb2cjdwForm.setDwmc(kjkjxmxxb2cjdw.getDwmc());
	//		kjkjxmxxb2cjdwForm.setFk_kj_kjxmxxb(kjkjxmxxb2cjdw.getFk_kj_kjxmxxb());
			
			
			formlist.add(kjkjxmxxb2cjdwForm);
		}}
		return formlist;
	}
	
	
	
	public void deleteObject(String id){
		kjkjxmxxb2Dao.deleteObjectByIDs(Integer.valueOf(id));
	}
	
	
	public void updateObject(Kjkjxmxxb2Form kjkjxmxxb2Form,String username){
		Kjkjxmxxb2 kjkjxmxxb2=new Kjkjxmxxb2();

		kjkjxmxxb2.setId(Integer.valueOf(kjkjxmxxb2Form.getId()));
		kjkjxmxxb2.setXmbh(kjkjxmxxb2Form.getXmbh());
		kjkjxmxxb2.setXmmc(kjkjxmxxb2Form.getXmmc());
		kjkjxmxxb2.setCjdws(kjkjxmxxb2Form.getCjdws());
		kjkjxmxxb2.setDwmc(kjkjxmxxb2Form.getDwmc());
		kjkjxmxxb2.setDwszd(kjkjxmxxb2Form.getDwszd());
		kjkjxmxxb2.setTxdz(kjkjxmxxb2Form.getTxdz());
		kjkjxmxxb2.setYb(kjkjxmxxb2Form.getYb());
		kjkjxmxxb2.setDwxz(kjkjxmxxb2Form.getDwxz());
		kjkjxmxxb2.setSjbm(kjkjxmxxb2Form.getSjbm());
		kjkjxmxxb2.setFzr(kjkjxmxxb2Form.getFzr());
		kjkjxmxxb2.setXb(kjkjxmxxb2Form.getXb());
		kjkjxmxxb2.setCsn(kjkjxmxxb2Form.getCsn());
		kjkjxmxxb2.setXl(kjkjxmxxb2Form.getXl());
		kjkjxmxxb2.setZc(kjkjxmxxb2Form.getZc());
		kjkjxmxxb2.setLxdh(kjkjxmxxb2Form.getLxdh());
		kjkjxmxxb2.setEmail(kjkjxmxxb2Form.getEmail());
		kjkjxmxxb2.setXmzrs(kjkjxmxxb2Form.getXmzrs());
		kjkjxmxxb2.setGj(kjkjxmxxb2Form.getGj());
		kjkjxmxxb2.setZj(kjkjxmxxb2Form.getZj());
		kjkjxmxxb2.setCj(kjkjxmxxb2Form.getCj());
		kjkjxmxxb2.setQt(kjkjxmxxb2Form.getQt());
		kjkjxmxxb2.setQssj(kjkjxmxxb2Form.getQssj());
		kjkjxmxxb2.setZzsj(kjkjxmxxb2Form.getZzsj());
		kjkjxmxxb2.setXmhdlx(kjkjxmxxb2Form.getXmhdlx());
		kjkjxmxxb2.setSsly(kjkjxmxxb2Form.getSsly());
		kjkjxmxxb2.setXmjsly(kjkjxmxxb2Form.getXmjsly());
		kjkjxmxxb2.setZyyfnr(kjkjxmxxb2Form.getZyyfnr());
		kjkjxmxxb2.setCgxs(kjkjxmxxb2Form.getCgxs());
		kjkjxmxxb2.setYqzl(kjkjxmxxb2Form.getYqzl());
		kjkjxmxxb2.setZjf(kjkjxmxxb2Form.getZjf());
		kjkjxmxxb2.setSbk(kjkjxmxxb2Form.getSbk());
		
		
		kjkjxmxxb2.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		kjkjxmxxb2.setUsername(username);
		kjkjxmxxb2.setGxsj(new Date().toString());
		kjkjxmxxb2.setSubmit(0);
		
		
		kjkjxmxxb2Dao.update(kjkjxmxxb2);
		
	}

}