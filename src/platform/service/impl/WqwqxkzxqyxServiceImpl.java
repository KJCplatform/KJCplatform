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

import platform.dao.WqwqxkzxqyxDao;
import platform.domain.Kjgxqybab;
import platform.domain.Wqwqxkzxqyx;
import platform.domain.Wqwqxkzxqyxsrqk;
import platform.domain.Wqwqxkzxqyxxkzycp;
import platform.form.KjgxqybabForm;
import platform.form.WqwqxkzxqyxForm;
import platform.form.WqwqxkzxqyxsrqkForm;
import platform.form.WqwqxkzxqyxxkzycpForm;
import platform.service.WqwqxkzxqyxService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(WqwqxkzxqyxService.SERVICE_NAME)
public class WqwqxkzxqyxServiceImpl implements WqwqxkzxqyxService{
	
	@Resource(name=WqwqxkzxqyxDao.SERVICE_NAME)
	private WqwqxkzxqyxDao wqwqxkzxqyxDao;
	public String saveWqwqxkzxqyx(WqwqxkzxqyxForm WqwqxkzxqyxForm){
		Wqwqxkzxqyx wqwqxkzxqyx=this.VoObjecttoPoObject(WqwqxkzxqyxForm);
		wqwqxkzxqyxDao.save(wqwqxkzxqyx);
		return wqwqxkzxqyxDao.selectMaxId();
		
	}
	
	private Wqwqxkzxqyx VoObjecttoPoObject(WqwqxkzxqyxForm wqwqxkzxqyxForm) {
		Wqwqxkzxqyx wqwqxkzxqyx=new Wqwqxkzxqyx();
		
		wqwqxkzxqyx.setDwmc(wqwqxkzxqyxForm.getDwmc());
		wqwqxkzxqyx.setQtmc(wqwqxkzxqyxForm.getQtmc());
		wqwqxkzxqyx.setDwdh(wqwqxkzxqyxForm.getDwdh());
		wqwqxkzxqyx.setScdz(wqwqxkzxqyxForm.getScdz());
		wqwqxkzxqyx.setJjxz(wqwqxkzxqyxForm.getJjxz());
		wqwqxkzxqyx.setFrdb(wqwqxkzxqyxForm.getFrdb());
		wqwqxkzxqyx.setDwdz(wqwqxkzxqyxForm.getDwdz());
		wqwqxkzxqyx.setYzbm(wqwqxkzxqyxForm.getYzbm());
		wqwqxkzxqyx.setLxr(wqwqxkzxqyxForm.getLxr());
		wqwqxkzxqyx.setLxdh(wqwqxkzxqyxForm.getLxdh());
		wqwqxkzxqyx.setZgzs(wqwqxkzxqyxForm.getZgzs());
		wqwqxkzxqyx.setGzgl(wqwqxkzxqyxForm.getGzgl());
		wqwqxkzxqyx.setZzgl(wqwqxkzxqyxForm.getZzgl());
		wqwqxkzxqyx.setCzgl(wqwqxkzxqyxForm.getCzgl());
		wqwqxkzxqyx.setGzjs(wqwqxkzxqyxForm.getGzjs());
		wqwqxkzxqyx.setZzjs(wqwqxkzxqyxForm.getZzjs());
		wqwqxkzxqyx.setCzjs(wqwqxkzxqyxForm.getCzjs());
		wqwqxkzxqyx.setGzgr(wqwqxkzxqyxForm.getGzgr());
		wqwqxkzxqyx.setZzgr(wqwqxkzxqyxForm.getZzgr());
		wqwqxkzxqyx.setCzgr(wqwqxkzxqyxForm.getCzgr());
		wqwqxkzxqyx.setGjjcgs(wqwqxkzxqyxForm.getGjjcgs());
		wqwqxkzxqyx.setSbjcgs(wqwqxkzxqyxForm.getSbjcgs());
		wqwqxkzxqyx.setJbqk(wqwqxkzxqyxForm.getJbqk());
		wqwqxkzxqyx.setKyfx(wqwqxkzxqyxForm.getKyfx());
		wqwqxkzxqyx.setQyscgl(wqwqxkzxqyxForm.getQyscgl());
		wqwqxkzxqyx.setKyzk(wqwqxkzxqyxForm.getKyzk());
		wqwqxkzxqyx.setZlglzk(wqwqxkzxqyxForm.getZlglzk());
		wqwqxkzxqyx.setBmaqzk(wqwqxkzxqyxForm.getBmaqzk());
		wqwqxkzxqyx.setJpyfqk(wqwqxkzxqyxForm.getJpyfqk());
		wqwqxkzxqyx.setJpzzqk(wqwqxkzxqyxForm.getJpzzqk());
		wqwqxkzxqyx.setJpjcqk(wqwqxkzxqyxForm.getJpjcqk());
		wqwqxkzxqyx.setWcjpqk(wqwqxkzxqyxForm.getWcjpqk());
		wqwqxkzxqyx.setXcjpxmqk(wqwqxkzxqyxForm.getXcjpxmqk());
		return wqwqxkzxqyx;
	}
	
	public void addSrqkListWithExpertId(int id, List<WqwqxkzxqyxsrqkForm> list){
		List<Wqwqxkzxqyxsrqk> Plist=this.srqkPoToVoList(list);
		Wqwqxkzxqyx wqwqxkzxqyx= wqwqxkzxqyxDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			wqwqxkzxqyx.getWqwqxkzxqyxsrqks().add(Plist.get(i));
		}
	}
	public void addXkzycpListWithExpertId(int id, List<WqwqxkzxqyxxkzycpForm> list){
		List<Wqwqxkzxqyxxkzycp> Plist=this.xkzycpPoToVoList(list);
		Wqwqxkzxqyx wqwqxkzxqyx= wqwqxkzxqyxDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			wqwqxkzxqyx.getWqwqxkzxqyxxkzycps().add(Plist.get(i));
		}
		
	}
	
	
	private List<Wqwqxkzxqyxsrqk> srqkPoToVoList(List<WqwqxkzxqyxsrqkForm> list) {
		List<Wqwqxkzxqyxsrqk> Plist=new ArrayList<Wqwqxkzxqyxsrqk>();
		for(int i=0;i<list.size();i++){
            Wqwqxkzxqyxsrqk wqwqxkzxqyxsrqk=new Wqwqxkzxqyxsrqk();
    //        Wqwqxkzxqyxsrqk.setFk_Wqwqxkzxqyx_id(list.get(i).getFk_Wqwqxkzxqyx_id());
            wqwqxkzxqyxsrqk.setYear(list.get(i).getYear());
            wqwqxkzxqyxsrqk.setZcz(list.get(i).getZcz());
            wqwqxkzxqyxsrqk.setJp(list.get(i).getJp());
            wqwqxkzxqyxsrqk.setMp(list.get(i).getMp());
			Plist.add(wqwqxkzxqyxsrqk);
		}
		return Plist;
	}

	private List<Wqwqxkzxqyxxkzycp> xkzycpPoToVoList(List<WqwqxkzxqyxxkzycpForm> list) {
		List<Wqwqxkzxqyxxkzycp> Plist=new ArrayList<Wqwqxkzxqyxxkzycp>();
		for(int i=0;i<list.size();i++){
			Wqwqxkzxqyxxkzycp wqwqxkzxqyxxkzycp=new Wqwqxkzxqyxxkzycp();
			
	//		Wqwqxkzxqyxxkzycp.setFk_Wqwqxkzxqyx_id(list.get(i).getFk_Wqwqxkzxqyx_id());
			wqwqxkzxqyxxkzycp.setXmdm(list.get(i).getXmdm());
			wqwqxkzxqyxxkzycp.setXmmc(list.get(i).getXmmc());
			wqwqxkzxqyxxkzycp.setKysc(list.get(i).getKysc());
			wqwqxkzxqyxxkzycp.setXklx(list.get(i).getXklx());
			Plist.add(wqwqxkzxqyxxkzycp);
		}
		return Plist;
	}

	public List<WqwqxkzxqyxForm> findWqwqxkzxqyxList(WqwqxkzxqyxForm wqwqxkzxqyxForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(wqwqxkzxqyxForm!=null&&StringUtils.isNotBlank(wqwqxkzxqyxForm.getDwmc())){
			hqlWhere += " and o.dwmc = ?";
			paramsList.add(wqwqxkzxqyxForm.getDwmc());
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Wqwqxkzxqyx> list=wqwqxkzxqyxDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<WqwqxkzxqyxForm> formlist=this.WqwqxkzxqyxPoToVoList(list);
		return formlist;
	}

	
	private List<WqwqxkzxqyxForm> WqwqxkzxqyxPoToVoList(List<Wqwqxkzxqyx> list) {
		List<WqwqxkzxqyxForm> formlist=new ArrayList<WqwqxkzxqyxForm>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			WqwqxkzxqyxForm wqwqxkzxqyxForm=new WqwqxkzxqyxForm();
			
			wqwqxkzxqyxForm.setId(String.valueOf(list.get(i).getId()));
			wqwqxkzxqyxForm.setDwmc(list.get(i).getDwmc());
			wqwqxkzxqyxForm.setQtmc(list.get(i).getQtmc());
			wqwqxkzxqyxForm.setDwdh(list.get(i).getDwdh());
			wqwqxkzxqyxForm.setScdz(list.get(i).getScdz());
			wqwqxkzxqyxForm.setJjxz(list.get(i).getJjxz());
			wqwqxkzxqyxForm.setFrdb(list.get(i).getFrdb());
			wqwqxkzxqyxForm.setDwdz(list.get(i).getDwdz());
			wqwqxkzxqyxForm.setYzbm(list.get(i).getYzbm());
			wqwqxkzxqyxForm.setLxr(list.get(i).getLxr());
			wqwqxkzxqyxForm.setLxdh(list.get(i).getLxdh());
			wqwqxkzxqyxForm.setZgzs(list.get(i).getZgzs());
			wqwqxkzxqyxForm.setGzgl(list.get(i).getGzgl());
			wqwqxkzxqyxForm.setZzgl(list.get(i).getZzgl());
			wqwqxkzxqyxForm.setCzgl(list.get(i).getCzgl());
			wqwqxkzxqyxForm.setGzjs(list.get(i).getGzjs());
			wqwqxkzxqyxForm.setZzjs(list.get(i).getZzjs());
			wqwqxkzxqyxForm.setCzjs(list.get(i).getCzjs());
			wqwqxkzxqyxForm.setGzgr(list.get(i).getGzgr());
			wqwqxkzxqyxForm.setZzgr(list.get(i).getZzgr());
			wqwqxkzxqyxForm.setCzgr(list.get(i).getCzgr());
			wqwqxkzxqyxForm.setGjjcgs(list.get(i).getGjjcgs());
			wqwqxkzxqyxForm.setSbjcgs(list.get(i).getSbjcgs());
			wqwqxkzxqyxForm.setJbqk(list.get(i).getJbqk());
			wqwqxkzxqyxForm.setKyfx(list.get(i).getKyfx());
			wqwqxkzxqyxForm.setQyscgl(list.get(i).getQyscgl());
			wqwqxkzxqyxForm.setKyzk(list.get(i).getKyzk());
			wqwqxkzxqyxForm.setZlglzk(list.get(i).getZlglzk());
			wqwqxkzxqyxForm.setBmaqzk(list.get(i).getBmaqzk());
			wqwqxkzxqyxForm.setJpyfqk(list.get(i).getJpyfqk());
			wqwqxkzxqyxForm.setJpjcqk(list.get(i).getJpjcqk());
			wqwqxkzxqyxForm.setJpzzqk(list.get(i).getJpzzqk());
			wqwqxkzxqyxForm.setWcjpqk(list.get(i).getWcjpqk());
			wqwqxkzxqyxForm.setXcjpxmqk(list.get(i).getXcjpxmqk());
			wqwqxkzxqyxForm.setWqwqxkzxqyxxkzycps(WqwqxkzxqyxxkzycpSetToFormList(list.get(i).getWqwqxkzxqyxxkzycps()));
			wqwqxkzxqyxForm.setWqwqxkzxqyxsrqks(WqwqxkzxqyxsrqkSetToFormList(list.get(i).getWqwqxkzxqyxsrqks()));
			formlist.add(wqwqxkzxqyxForm);
		}
		}
	return formlist;
}
	private List<WqwqxkzxqyxsrqkForm> WqwqxkzxqyxsrqkSetToFormList(
			Set<Wqwqxkzxqyxsrqk> Wqwqxkzxqyxsrqks) {
   List<WqwqxkzxqyxsrqkForm> formlist=new ArrayList<WqwqxkzxqyxsrqkForm>();
   if(Wqwqxkzxqyxsrqks.size()>0){
		for(Wqwqxkzxqyxsrqk wqwqxkzxqyxsrqk:Wqwqxkzxqyxsrqks){
			WqwqxkzxqyxsrqkForm wqwqxkzxqyxsrqkForm=new WqwqxkzxqyxsrqkForm();
	//		WqwqxkzxqyxsrqkForm.setFk_Wqwqxkzxqyx_id(Wqwqxkzxqyxsrqk.getFk_Wqwqxkzxqyx_id());
			wqwqxkzxqyxsrqkForm.setYear(wqwqxkzxqyxsrqk.getYear());
			wqwqxkzxqyxsrqkForm.setZcz(wqwqxkzxqyxsrqk.getZcz());
			wqwqxkzxqyxsrqkForm.setJp(wqwqxkzxqyxsrqk.getJp());
			wqwqxkzxqyxsrqkForm.setMp(wqwqxkzxqyxsrqk.getMp());
			formlist.add(wqwqxkzxqyxsrqkForm);
		}}
		return formlist;
	}

	private List<WqwqxkzxqyxxkzycpForm> WqwqxkzxqyxxkzycpSetToFormList(
			Set<Wqwqxkzxqyxxkzycp> Wqwqxkzxqyxxkzycps) {
		List<WqwqxkzxqyxxkzycpForm> formlist=new ArrayList<WqwqxkzxqyxxkzycpForm>();
		if(Wqwqxkzxqyxxkzycps.size()>0){
		for(Wqwqxkzxqyxxkzycp wqwqxkzxqyxxkzycp:Wqwqxkzxqyxxkzycps){
			WqwqxkzxqyxxkzycpForm wqwqxkzxqyxxkzycpForm=new WqwqxkzxqyxxkzycpForm();
	//		WqwqxkzxqyxxkzycpForm.setFk_Wqwqxkzxqyx_id(Wqwqxkzxqyxxkzycp.getFk_Wqwqxkzxqyx_id());
			wqwqxkzxqyxxkzycpForm.setXmdm(wqwqxkzxqyxxkzycp.getXmdm());
			wqwqxkzxqyxxkzycpForm.setXmmc(wqwqxkzxqyxxkzycp.getXmmc());
			wqwqxkzxqyxxkzycpForm.setKysc(wqwqxkzxqyxxkzycp.getKysc());
			wqwqxkzxqyxxkzycpForm.setXklx(wqwqxkzxqyxxkzycp.getXklx());
			formlist.add(wqwqxkzxqyxxkzycpForm);
			
		}}
		return formlist;
	}

	


	public void deleteObject(String id){
		wqwqxkzxqyxDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	
	
	public void updateObject(WqwqxkzxqyxForm wqwqxkzxqyxForm){
		
		
	Wqwqxkzxqyx wqwqxkzxqyx=new Wqwqxkzxqyx();
	wqwqxkzxqyx.setId(Integer.valueOf(wqwqxkzxqyxForm.getId()));
	wqwqxkzxqyx.setDwmc(wqwqxkzxqyxForm.getDwmc());
	wqwqxkzxqyx.setQtmc(wqwqxkzxqyxForm.getQtmc());
	wqwqxkzxqyx.setDwdh(wqwqxkzxqyxForm.getDwdh());
	wqwqxkzxqyx.setScdz(wqwqxkzxqyxForm.getScdz());
	wqwqxkzxqyx.setJjxz(wqwqxkzxqyxForm.getJjxz());
	wqwqxkzxqyx.setFrdb(wqwqxkzxqyxForm.getFrdb());
	wqwqxkzxqyx.setDwdz(wqwqxkzxqyxForm.getDwdz());
	wqwqxkzxqyx.setYzbm(wqwqxkzxqyxForm.getYzbm());
	wqwqxkzxqyx.setLxr(wqwqxkzxqyxForm.getLxr());
	wqwqxkzxqyx.setLxdh(wqwqxkzxqyxForm.getLxdh());
	wqwqxkzxqyx.setZgzs(wqwqxkzxqyxForm.getZgzs());
	wqwqxkzxqyx.setGzgl(wqwqxkzxqyxForm.getGzgl());
	wqwqxkzxqyx.setZzgl(wqwqxkzxqyxForm.getZzgl());
	wqwqxkzxqyx.setCzgl(wqwqxkzxqyxForm.getCzgl());
	wqwqxkzxqyx.setGzjs(wqwqxkzxqyxForm.getGzjs());
	wqwqxkzxqyx.setZzjs(wqwqxkzxqyxForm.getZzjs());
	wqwqxkzxqyx.setCzjs(wqwqxkzxqyxForm.getCzjs());
	wqwqxkzxqyx.setGzgr(wqwqxkzxqyxForm.getGzgr());
	wqwqxkzxqyx.setZzgr(wqwqxkzxqyxForm.getZzgr());
	wqwqxkzxqyx.setCzgr(wqwqxkzxqyxForm.getCzgr());
	wqwqxkzxqyx.setGjjcgs(wqwqxkzxqyxForm.getGjjcgs());
	wqwqxkzxqyx.setSbjcgs(wqwqxkzxqyxForm.getSbjcgs());
	wqwqxkzxqyx.setJbqk(wqwqxkzxqyxForm.getJbqk());
	wqwqxkzxqyx.setKyfx(wqwqxkzxqyxForm.getKyfx());
	wqwqxkzxqyx.setQyscgl(wqwqxkzxqyxForm.getQyscgl());
	wqwqxkzxqyx.setKyzk(wqwqxkzxqyxForm.getKyzk());
	wqwqxkzxqyx.setZlglzk(wqwqxkzxqyxForm.getZlglzk());
	wqwqxkzxqyx.setBmaqzk(wqwqxkzxqyxForm.getBmaqzk());
	wqwqxkzxqyx.setJpyfqk(wqwqxkzxqyxForm.getJpyfqk());
	wqwqxkzxqyx.setJpzzqk(wqwqxkzxqyxForm.getJpzzqk());
	wqwqxkzxqyx.setJpjcqk(wqwqxkzxqyxForm.getJpjcqk());
	wqwqxkzxqyx.setWcjpqk(wqwqxkzxqyxForm.getWcjpqk());
	wqwqxkzxqyx.setXcjpxmqk(wqwqxkzxqyxForm.getXcjpxmqk());
		
		wqwqxkzxqyxDao.update(wqwqxkzxqyx);
		
	}
	

	
}
