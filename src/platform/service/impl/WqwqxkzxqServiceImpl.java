package platform.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.WqwqxkzxqDao;
import platform.domain.Kjgxqybab;
import platform.domain.Wqwqxkzxq;
import platform.domain.Wqwqxkzxqsrqk;
import platform.domain.Wqwqxkzxqxkzycp;
import platform.form.KjgxqybabForm;
import platform.form.WqwqxkzxqForm;
import platform.form.WqwqxkzxqsrqkForm;
import platform.form.WqwqxkzxqxkzycpForm;
import platform.service.WqwqxkzxqService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(WqwqxkzxqService.SERVICE_NAME)
public class WqwqxkzxqServiceImpl implements WqwqxkzxqService{
	
	@Resource(name=WqwqxkzxqDao.SERVICE_NAME)
	private WqwqxkzxqDao wqwqxkzxqDao;
	public String saveWqwqxkzxq(WqwqxkzxqForm wqwqxkzxqForm,String username){
		Wqwqxkzxq wqwqxkzxq=this.VoObjecttoPoObject(wqwqxkzxqForm);
		wqwqxkzxq.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		wqwqxkzxq.setUsername(username);
		wqwqxkzxq.setGxsj(new Date().toString());
		wqwqxkzxq.setSubmit(0);
		wqwqxkzxqDao.save(wqwqxkzxq);
		return wqwqxkzxqDao.selectMaxId();
		
	}
	
	private Wqwqxkzxq VoObjecttoPoObject(WqwqxkzxqForm wqwqxkzxqForm) {
		Wqwqxkzxq wqwqxkzxq=new Wqwqxkzxq();
		
		wqwqxkzxq.setDwmc(wqwqxkzxqForm.getDwmc());
		wqwqxkzxq.setQtmc(wqwqxkzxqForm.getQtmc());
		wqwqxkzxq.setDwdh(wqwqxkzxqForm.getDwdh());
		wqwqxkzxq.setScdz(wqwqxkzxqForm.getScdz());
		wqwqxkzxq.setJjxz(wqwqxkzxqForm.getJjxz());
		wqwqxkzxq.setFrdb(wqwqxkzxqForm.getFrdb());
		wqwqxkzxq.setDwdz(wqwqxkzxqForm.getDwdz());
		wqwqxkzxq.setYzbm(wqwqxkzxqForm.getYzbm());
		wqwqxkzxq.setLxr(wqwqxkzxqForm.getLxr());
		wqwqxkzxq.setLxdh(wqwqxkzxqForm.getLxdh());
		wqwqxkzxq.setZgzs(wqwqxkzxqForm.getZgzs());
		wqwqxkzxq.setGzgl(wqwqxkzxqForm.getGzgl());
		wqwqxkzxq.setZzgl(wqwqxkzxqForm.getZzgl());
		wqwqxkzxq.setCzgl(wqwqxkzxqForm.getCzgl());
		wqwqxkzxq.setGzjs(wqwqxkzxqForm.getGzjs());
		wqwqxkzxq.setZzjs(wqwqxkzxqForm.getZzjs());
		wqwqxkzxq.setCzjs(wqwqxkzxqForm.getCzjs());
		wqwqxkzxq.setGzgr(wqwqxkzxqForm.getGzgr());
		wqwqxkzxq.setZzgr(wqwqxkzxqForm.getZzgr());
		wqwqxkzxq.setCzgr(wqwqxkzxqForm.getCzgr());
		wqwqxkzxq.setGjjcgs(wqwqxkzxqForm.getGjjcgs());
		wqwqxkzxq.setSbjcgs(wqwqxkzxqForm.getSbjcgs());
		wqwqxkzxq.setJbqk(wqwqxkzxqForm.getJbqk());
		wqwqxkzxq.setKyfx(wqwqxkzxqForm.getKyfx());
		wqwqxkzxq.setQyscgl(wqwqxkzxqForm.getQyscgl());
		wqwqxkzxq.setKyzk(wqwqxkzxqForm.getKyzk());
		wqwqxkzxq.setZlglzk(wqwqxkzxqForm.getZlglzk());
		wqwqxkzxq.setBmaqzk(wqwqxkzxqForm.getBmaqzk());
		wqwqxkzxq.setJpyfqk(wqwqxkzxqForm.getJpyfqk());
		wqwqxkzxq.setJpzzqk(wqwqxkzxqForm.getJpzzqk());
		wqwqxkzxq.setJpjcqk(wqwqxkzxqForm.getJpjcqk());
		wqwqxkzxq.setWcjpqk(wqwqxkzxqForm.getWcjpqk());
		wqwqxkzxq.setXcjpxmqk(wqwqxkzxqForm.getXcjpxmqk());
		return wqwqxkzxq;
	}
	
	public void addSrqkListWithExpertId(int id, List<WqwqxkzxqsrqkForm> list){
		List<Wqwqxkzxqsrqk> Plist=this.srqkPoToVoList(list);
		Wqwqxkzxq wqwqxkzxq= wqwqxkzxqDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			wqwqxkzxq.getWqwqxkzxqsrqks().add(Plist.get(i));
		}
	}
	public void addXkzycpListWithExpertId(int id, List<WqwqxkzxqxkzycpForm> list){
		List<Wqwqxkzxqxkzycp> Plist=this.xkzycpPoToVoList(list);
		Wqwqxkzxq wqwqxkzxq= wqwqxkzxqDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			wqwqxkzxq.getWqwqxkzxqxkzycps().add(Plist.get(i));
		}
		
	}
	
	
	private List<Wqwqxkzxqsrqk> srqkPoToVoList(List<WqwqxkzxqsrqkForm> list) {
		List<Wqwqxkzxqsrqk> Plist=new ArrayList<Wqwqxkzxqsrqk>();
		for(int i=0;i<list.size();i++){
            Wqwqxkzxqsrqk wqwqxkzxqsrqk=new Wqwqxkzxqsrqk();
    //        wqwqxkzxqsrqk.setFk_wqwqxkzxq_id(list.get(i).getFk_wqwqxkzxq_id());
            wqwqxkzxqsrqk.setYear(list.get(i).getYear());
            wqwqxkzxqsrqk.setZcz(list.get(i).getZcz());
            wqwqxkzxqsrqk.setJp(list.get(i).getJp());
            wqwqxkzxqsrqk.setMp(list.get(i).getMp());
			Plist.add(wqwqxkzxqsrqk);
		}
		return Plist;
	}

	private List<Wqwqxkzxqxkzycp> xkzycpPoToVoList(List<WqwqxkzxqxkzycpForm> list) {
		List<Wqwqxkzxqxkzycp> Plist=new ArrayList<Wqwqxkzxqxkzycp>();
		for(int i=0;i<list.size();i++){
			Wqwqxkzxqxkzycp wqwqxkzxqxkzycp=new Wqwqxkzxqxkzycp();
			
	//		wqwqxkzxqxkzycp.setFk_wqwqxkzxq_id(list.get(i).getFk_wqwqxkzxq_id());
			wqwqxkzxqxkzycp.setXmdm(list.get(i).getXmdm());
			wqwqxkzxqxkzycp.setXmmc(list.get(i).getXmmc());
			wqwqxkzxqxkzycp.setKysc(list.get(i).getKysc());
			wqwqxkzxqxkzycp.setXklx(list.get(i).getXklx());
			Plist.add(wqwqxkzxqxkzycp);
		}
		return Plist;
	}

	public List<WqwqxkzxqForm> findWqwqxkzxqList(WqwqxkzxqForm wqwqxkzxqForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(wqwqxkzxqForm!=null&&StringUtils.isNotBlank(wqwqxkzxqForm.getDwmc())){
			hqlWhere += " and o.dwmc = ?";
			paramsList.add(wqwqxkzxqForm.getDwmc());
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Wqwqxkzxq> list=wqwqxkzxqDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<WqwqxkzxqForm> formlist=this.WqwqxkzxqPoToVoList(list);
		return formlist;
	}

	
	private List<WqwqxkzxqForm> WqwqxkzxqPoToVoList(List<Wqwqxkzxq> list) {
		List<WqwqxkzxqForm> formlist=new ArrayList<WqwqxkzxqForm>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			WqwqxkzxqForm wqwqxkzxqForm=new WqwqxkzxqForm();
			
			wqwqxkzxqForm.setId(String.valueOf(list.get(i).getId()));
			wqwqxkzxqForm.setDwmc(list.get(i).getDwmc());
			wqwqxkzxqForm.setQtmc(list.get(i).getQtmc());
			wqwqxkzxqForm.setDwdh(list.get(i).getDwdh());
			wqwqxkzxqForm.setScdz(list.get(i).getScdz());
			wqwqxkzxqForm.setJjxz(list.get(i).getJjxz());
			wqwqxkzxqForm.setFrdb(list.get(i).getFrdb());
			wqwqxkzxqForm.setDwdz(list.get(i).getDwdz());
			wqwqxkzxqForm.setYzbm(list.get(i).getYzbm());
			wqwqxkzxqForm.setLxr(list.get(i).getLxr());
			wqwqxkzxqForm.setLxdh(list.get(i).getLxdh());
			wqwqxkzxqForm.setZgzs(list.get(i).getZgzs());
			wqwqxkzxqForm.setGzgl(list.get(i).getGzgl());
			wqwqxkzxqForm.setZzgl(list.get(i).getZzgl());
			wqwqxkzxqForm.setCzgl(list.get(i).getCzgl());
			wqwqxkzxqForm.setGzjs(list.get(i).getGzjs());
			wqwqxkzxqForm.setZzjs(list.get(i).getZzjs());
			wqwqxkzxqForm.setCzjs(list.get(i).getCzjs());
			wqwqxkzxqForm.setGzgr(list.get(i).getGzgr());
			wqwqxkzxqForm.setZzgr(list.get(i).getZzgr());
			wqwqxkzxqForm.setCzgr(list.get(i).getCzgr());
			wqwqxkzxqForm.setGjjcgs(list.get(i).getGjjcgs());
			wqwqxkzxqForm.setSbjcgs(list.get(i).getSbjcgs());
			wqwqxkzxqForm.setJbqk(list.get(i).getJbqk());
			wqwqxkzxqForm.setKyfx(list.get(i).getKyfx());
			wqwqxkzxqForm.setQyscgl(list.get(i).getQyscgl());
			wqwqxkzxqForm.setKyzk(list.get(i).getKyzk());
			wqwqxkzxqForm.setZlglzk(list.get(i).getZlglzk());
			wqwqxkzxqForm.setBmaqzk(list.get(i).getBmaqzk());
			wqwqxkzxqForm.setJpyfqk(list.get(i).getJpyfqk());
			wqwqxkzxqForm.setJpjcqk(list.get(i).getJpjcqk());
			wqwqxkzxqForm.setJpzzqk(list.get(i).getJpzzqk());
			wqwqxkzxqForm.setWcjpqk(list.get(i).getWcjpqk());
			wqwqxkzxqForm.setXcjpxmqk(list.get(i).getXcjpxmqk());
			wqwqxkzxqForm.setJlnf(list.get(i).getJlnf());
			wqwqxkzxqForm.setUsername(list.get(i).getUsername());
			wqwqxkzxqForm.setGxsj(list.get(i).getGxsj());
			wqwqxkzxqForm.setSubmit(String.valueOf(list.get(i).getSubmit()));
			wqwqxkzxqForm.setWqwqxkzxqxkzycps(WqwqxkzxqxkzycpSetToFormList(list.get(i).getWqwqxkzxqxkzycps()));
			wqwqxkzxqForm.setWqwqxkzxqsrqks(WqwqxkzxqsrqkSetToFormList(list.get(i).getWqwqxkzxqsrqks()));
			formlist.add(wqwqxkzxqForm);
		}
		}
	return formlist;
}
	private List<WqwqxkzxqsrqkForm> WqwqxkzxqsrqkSetToFormList(
			Set<Wqwqxkzxqsrqk> wqwqxkzxqsrqks) {
   List<WqwqxkzxqsrqkForm> formlist=new ArrayList<WqwqxkzxqsrqkForm>();
   if(wqwqxkzxqsrqks.size()>0){
		for(Wqwqxkzxqsrqk wqwqxkzxqsrqk:wqwqxkzxqsrqks){
			WqwqxkzxqsrqkForm wqwqxkzxqsrqkForm=new WqwqxkzxqsrqkForm();
	//		wqwqxkzxqsrqkForm.setFk_wqwqxkzxq_id(wqwqxkzxqsrqk.getFk_wqwqxkzxq_id());
			wqwqxkzxqsrqkForm.setYear(wqwqxkzxqsrqk.getYear());
			wqwqxkzxqsrqkForm.setZcz(wqwqxkzxqsrqk.getZcz());
			wqwqxkzxqsrqkForm.setJp(wqwqxkzxqsrqk.getJp());
			wqwqxkzxqsrqkForm.setMp(wqwqxkzxqsrqk.getMp());
			formlist.add(wqwqxkzxqsrqkForm);
		}}
		return formlist;
	}

	private List<WqwqxkzxqxkzycpForm> WqwqxkzxqxkzycpSetToFormList(
			Set<Wqwqxkzxqxkzycp> wqwqxkzxqxkzycps) {
		List<WqwqxkzxqxkzycpForm> formlist=new ArrayList<WqwqxkzxqxkzycpForm>();
		if(wqwqxkzxqxkzycps.size()>0){
		for(Wqwqxkzxqxkzycp wqwqxkzxqxkzycp:wqwqxkzxqxkzycps){
			WqwqxkzxqxkzycpForm wqwqxkzxqxkzycpForm=new WqwqxkzxqxkzycpForm();
	//		wqwqxkzxqxkzycpForm.setFk_wqwqxkzxq_id(wqwqxkzxqxkzycp.getFk_wqwqxkzxq_id());
			wqwqxkzxqxkzycpForm.setXmdm(wqwqxkzxqxkzycp.getXmdm());
			wqwqxkzxqxkzycpForm.setXmmc(wqwqxkzxqxkzycp.getXmmc());
			wqwqxkzxqxkzycpForm.setKysc(wqwqxkzxqxkzycp.getKysc());
			wqwqxkzxqxkzycpForm.setXklx(wqwqxkzxqxkzycp.getXklx());
			formlist.add(wqwqxkzxqxkzycpForm);
			
		}}
		return formlist;
	}

	


	public void deleteObject(String id){
		wqwqxkzxqDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	
	
	public void updateObject(WqwqxkzxqForm wqwqxkzxqForm,String username){
		
		
	Wqwqxkzxq wqwqxkzxq=new Wqwqxkzxq();
	wqwqxkzxq.setId(Integer.valueOf(wqwqxkzxqForm.getId()));
		wqwqxkzxq.setDwmc(wqwqxkzxqForm.getDwmc());
		wqwqxkzxq.setQtmc(wqwqxkzxqForm.getQtmc());
		wqwqxkzxq.setDwdh(wqwqxkzxqForm.getDwdh());
		wqwqxkzxq.setScdz(wqwqxkzxqForm.getScdz());
		wqwqxkzxq.setJjxz(wqwqxkzxqForm.getJjxz());
		wqwqxkzxq.setFrdb(wqwqxkzxqForm.getFrdb());
		wqwqxkzxq.setDwdz(wqwqxkzxqForm.getDwdz());
		wqwqxkzxq.setYzbm(wqwqxkzxqForm.getYzbm());
		wqwqxkzxq.setLxr(wqwqxkzxqForm.getLxr());
		wqwqxkzxq.setLxdh(wqwqxkzxqForm.getLxdh());
		wqwqxkzxq.setZgzs(wqwqxkzxqForm.getZgzs());
		wqwqxkzxq.setGzgl(wqwqxkzxqForm.getGzgl());
		wqwqxkzxq.setZzgl(wqwqxkzxqForm.getZzgl());
		wqwqxkzxq.setCzgl(wqwqxkzxqForm.getCzgl());
		wqwqxkzxq.setGzjs(wqwqxkzxqForm.getGzjs());
		wqwqxkzxq.setZzjs(wqwqxkzxqForm.getZzjs());
		wqwqxkzxq.setCzjs(wqwqxkzxqForm.getCzjs());
		wqwqxkzxq.setGzgr(wqwqxkzxqForm.getGzgr());
		wqwqxkzxq.setZzgr(wqwqxkzxqForm.getZzgr());
		wqwqxkzxq.setCzgr(wqwqxkzxqForm.getCzgr());
		wqwqxkzxq.setGjjcgs(wqwqxkzxqForm.getGjjcgs());
		wqwqxkzxq.setSbjcgs(wqwqxkzxqForm.getSbjcgs());
		wqwqxkzxq.setJbqk(wqwqxkzxqForm.getJbqk());
		wqwqxkzxq.setKyfx(wqwqxkzxqForm.getKyfx());
		wqwqxkzxq.setQyscgl(wqwqxkzxqForm.getQyscgl());
		wqwqxkzxq.setKyzk(wqwqxkzxqForm.getKyzk());
		wqwqxkzxq.setZlglzk(wqwqxkzxqForm.getZlglzk());
		wqwqxkzxq.setBmaqzk(wqwqxkzxqForm.getBmaqzk());
		wqwqxkzxq.setJpyfqk(wqwqxkzxqForm.getJpyfqk());
		wqwqxkzxq.setJpzzqk(wqwqxkzxqForm.getJpzzqk());
		wqwqxkzxq.setJpjcqk(wqwqxkzxqForm.getJpjcqk());
		wqwqxkzxq.setWcjpqk(wqwqxkzxqForm.getWcjpqk());
		wqwqxkzxq.setXcjpxmqk(wqwqxkzxqForm.getXcjpxmqk());
		wqwqxkzxq.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		wqwqxkzxq.setUsername(username);
		wqwqxkzxq.setGxsj(new Date().toString());
		wqwqxkzxq.setSubmit(0);
		wqwqxkzxqDao.update(wqwqxkzxq);
		
	}
	

	
}
