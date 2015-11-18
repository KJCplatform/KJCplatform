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
	public List<KjjszjcjbForm> findKjjszjcjbList(KjjszjcjbForm kjjszjcjbForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(kjjszjcjbForm!=null&&StringUtils.isNotBlank(kjjszjcjbForm.getZjxm())){
			hqlWhere += " and o.zjxm = ?";
			paramsList.add(kjjszjcjbForm.getZjxm());
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Kjjszjcjb> list=kjjszjcjbDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<KjjszjcjbForm> formlist=this.KjjszjcjbPoToVoList(list);
		return formlist;
	}
	 
	private List<KjjszjcjbForm> KjjszjcjbPoToVoList(List<Kjjszjcjb> list) {
		List<KjjszjcjbForm> formlist=new ArrayList<KjjszjcjbForm>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			KjjszjcjbForm kjjszjcjbForm=new KjjszjcjbForm();
			kjjszjcjbForm.setFwyy(list.get(i).getFwyy());
			kjjszjcjbForm.setGzbm(list.get(i).getGzbm());
			kjjszjcjbForm.setGzdw(list.get(i).getGzdw());
			kjjszjcjbForm.setHyly(list.get(i).getHyly());
			kjjszjcjbForm.setJsly(list.get(i).getJsly());
			kjjszjcjbForm.setJszc(list.get(i).getJszc());
			kjjszjcjbForm.setLxdh(list.get(i).getLxdh());
			kjjszjcjbForm.setLxdz(list.get(i).getLxdz());
			
			if(list.get(i).getSfgk()!=null){
			 if(list.get(i).getSfgk()==true)
			kjjszjcjbForm.setSfgk("是");
			else kjjszjcjbForm.setSfgk("否");}
			
			kjjszjcjbForm.setSfzh(list.get(i).getSfzh());
			kjjszjcjbForm.setSj(list.get(i).getSj());
			kjjszjcjbForm.setSzdq(list.get(i).getSzdq());
			kjjszjcjbForm.setSzpt(list.get(i).getSzpt());
			kjjszjcjbForm.setXb(list.get(i).getXb());
			kjjszjcjbForm.setXkly(list.get(i).getXkly());
			kjjszjcjbForm.setYx(list.get(i).getYx());
			kjjszjcjbForm.setZgxl(list.get(i).getZgxl());
			kjjszjcjbForm.setZjjj(list.get(i).getZjjj());
			kjjszjcjbForm.setZjxm(list.get(i).getZjxm());
			kjjszjcjbForm.setZw(list.get(i).getZw());
			kjjszjcjbForm.setZytc(list.get(i).getZytc());
			kjjszjcjbForm.setKjjszjcjbcgs(KjjszjcjbcgSetToFormList(list.get(i).getKjjszjcjbcgs()));
			kjjszjcjbForm.setKjjszjcjbzys(KjjszjcjbzySetToFormList(list.get(i).getKjjszjcjbzys()));
			kjjszjcjbForm.setKjjszjcjbxms(KjjszjcjbxmSetToFormList(list.get(i).getKjjszjcjbxms()));
			formlist.add(kjjszjcjbForm);
		}}
		return formlist;
	}

	private List<KjjszjcjbxmForm> KjjszjcjbxmSetToFormList(
			Set<Kjjszjcjbxm> kjjszjcjbxms) {
   List<KjjszjcjbxmForm> formlist=new ArrayList<KjjszjcjbxmForm>();
   if(kjjszjcjbxms.size()>0){
		for(Kjjszjcjbxm kjjszjcjbxm:kjjszjcjbxms){
			KjjszjcjbxmForm kjjszjcjbxmForm=new KjjszjcjbxmForm();
			kjjszjcjbxmForm.setHzsj(kjjszjcjbxm.getHzsj());
			if(kjjszjcjbxm.getHzxg()!=null) 
			{if(kjjszjcjbxm.getHzxg()==true)
			kjjszjcjbxmForm.setHzxg("良好");
             else kjjszjcjbxmForm.setHzxg("一般");}
			kjjszjcjbxmForm.setXmjj(kjjszjcjbxm.getXmjj());
			kjjszjcjbxmForm.setXmmc(kjjszjcjbxm.getXmmc());
			formlist.add(kjjszjcjbxmForm);
		}}
		return formlist;
	}

	private List<KjjszjcjbzyForm> KjjszjcjbzySetToFormList(
			Set<Kjjszjcjbzy> kjjszjcjbzys) {
		List<KjjszjcjbzyForm> formlist=new ArrayList<KjjszjcjbzyForm>();
		if(kjjszjcjbzys.size()>0){
		for(Kjjszjcjbzy kjjszjcjbzy:kjjszjcjbzys){
			KjjszjcjbzyForm kjjszjcjbzyForm=new KjjszjcjbzyForm();
			if(kjjszjcjbzy.getSfzh()!=null)
			{
			if(kjjszjcjbzy.getSfzh()==true)
			kjjszjcjbzyForm.setSfzh("是");
			else kjjszjcjbzyForm.setSfzh("否");}
			kjjszjcjbzyForm.setWcsj(kjjszjcjbzy.getWcsj().toString());
			kjjszjcjbzyForm.setXmjj(kjjszjcjbzy.getXmmc());
			kjjszjcjbzyForm.setXmmc(kjjszjcjbzy.getXmmc());
			formlist.add(kjjszjcjbzyForm);
			
		}}
		return formlist;
	}

	private List<KjjszjcjbcgForm> KjjszjcjbcgSetToFormList(
			Set<Kjjszjcjbcg> kjjszjcjbcgs) {
		// TODO Auto-generated method stub
		List<KjjszjcjbcgForm> formlist=new ArrayList<KjjszjcjbcgForm>();
		if(kjjszjcjbcgs.size()>0){
		for(Kjjszjcjbcg kjjszjcjbcg:kjjszjcjbcgs){
			KjjszjcjbcgForm kjjszjcjbcgForm=new KjjszjcjbcgForm();
			kjjszjcjbcgForm.setCgjj(kjjszjcjbcg.getCgjj());
			kjjszjcjbcgForm.setCgmc(kjjszjcjbcg.getCgmc());
			kjjszjcjbcgForm.setWcsj(String.valueOf(kjjszjcjbcg.getWcsj()));
			if(kjjszjcjbcg.getZhqk()!=null)
			{if(kjjszjcjbcg.getZhqk()==true)
			kjjszjcjbcgForm.setZhqk("已转化，继续转化");
			else kjjszjcjbcgForm.setZhqk("未转化，希望转化");}
			formlist.add(kjjszjcjbcgForm);
		}}
		return formlist;
	}

	@Override
	public List<KjjszjcjbForm> findContactWithpage(int pagesize, int pageno) {
		// TODO Auto-generated method stub
		List<KjjszjcjbForm> formlist=new ArrayList<KjjszjcjbForm>();
		List<Object[]> list=kjjszjcjbDao.findContactWithpage(pagesize, pageno);
		for(int i=0;i<list.size();i++){
			KjjszjcjbForm kjjszjcjbForm=new KjjszjcjbForm();
			kjjszjcjbForm.setZjxm(list.get(i)[0].toString());
			kjjszjcjbForm.setGzdw(list.get(i)[1].toString());
			kjjszjcjbForm.setGzbm(list.get(i)[2].toString());
			kjjszjcjbForm.setZw(list.get(i)[3].toString());
			kjjszjcjbForm.setSj(list.get(i)[4].toString());
			kjjszjcjbForm.setLxdh(list.get(i)[5].toString());
			formlist.add(kjjszjcjbForm);
		}
		return formlist;
	}

	@Override
	public int listSize() {
		// TODO Auto-generated method stub
		int size=kjjszjcjbDao.findCollectionByConditionNoPage("", null, null).size();
		return size;
	}
}
