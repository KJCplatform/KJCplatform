package platform.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import platform.dao.JpjgdwjbqkDao;
import platform.domain.Jpjgdwjbqk;
import platform.domain.Jpjgdwjbqksrqk;
import platform.domain.Jpjgdwjbqkry;
import platform.form.JpjgdwjbqkForm;
import platform.form.JpjgdwjbqksrqkForm;
import platform.form.JpjgdwjbqkryForm;
import platform.service.JpjgdwjbqkService;

@Transactional
@Service(JpjgdwjbqkService.SERVICE_NAME)
public class JpjgdwjbqkServiceImpl implements JpjgdwjbqkService{
	
	@Resource(name=JpjgdwjbqkDao.SERVICE_NAME)
	private JpjgdwjbqkDao jpjgdwjbqkDao;

	public String saveJpjgdwjbqk(JpjgdwjbqkForm jpjgdwjbqkForm){
		Jpjgdwjbqk jpjgdwjbqk=this.VoObjecttoPoObject(jpjgdwjbqkForm);
		jpjgdwjbqkDao.save(jpjgdwjbqk);
		return jpjgdwjbqkDao.selectMaxId();
		
	}

	private Jpjgdwjbqk VoObjecttoPoObject(JpjgdwjbqkForm jpjgdwjbqkForm) {
		Jpjgdwjbqk jpjgdwjbqk=new Jpjgdwjbqk();
		jpjgdwjbqk.setDwmc(jpjgdwjbqkForm.getDwmc());
		jpjgdwjbqk.setQtmc(jpjgdwjbqkForm.getQtmc());
		jpjgdwjbqk.setDwdh(jpjgdwjbqkForm.getDwdh());
		jpjgdwjbqk.setScdz(jpjgdwjbqkForm.getScdz());
		jpjgdwjbqk.setJjxz(jpjgdwjbqkForm.getJjxz());
		jpjgdwjbqk.setFrdb(jpjgdwjbqkForm.getFrdb());
		jpjgdwjbqk.setDwdz(jpjgdwjbqkForm.getDwdz());
		jpjgdwjbqk.setYzbm(jpjgdwjbqkForm.getYzbm());
		jpjgdwjbqk.setLxr(jpjgdwjbqkForm.getLxr());
		jpjgdwjbqk.setLxdh(jpjgdwjbqkForm.getLxdh());
		jpjgdwjbqk.setZgzs(jpjgdwjbqkForm.getZgzs());
		jpjgdwjbqk.setGzgl(jpjgdwjbqkForm.getGzgl());
		jpjgdwjbqk.setZzgl(jpjgdwjbqkForm.getZzgl());
		jpjgdwjbqk.setCzgl(jpjgdwjbqkForm.getCzgl());
		jpjgdwjbqk.setGzjs(jpjgdwjbqkForm.getGzjs());
		jpjgdwjbqk.setZzjs(jpjgdwjbqkForm.getZzjs());
		jpjgdwjbqk.setCzjs(jpjgdwjbqkForm.getCzjs());
		jpjgdwjbqk.setGzgr(jpjgdwjbqkForm.getGzgr());
		jpjgdwjbqk.setZzgr(jpjgdwjbqkForm.getZzgr());
		jpjgdwjbqk.setCzgr(jpjgdwjbqkForm.getCzgr());
		jpjgdwjbqk.setGjjcgs(jpjgdwjbqkForm.getGjjcgs());
		jpjgdwjbqk.setSbjcgs(jpjgdwjbqkForm.getSbjcgs());
		jpjgdwjbqk.setJlz(jpjgdwjbqkForm.getJlz());
		jpjgdwjbqk.setJlbzsl(jpjgdwjbqkForm.getJlbzsl());
		jpjgdwjbqk.setJpkyrw(jpjgdwjbqkForm.getJpkyrw());
		jpjgdwjbqk.setGjsyssl(jpjgdwjbqkForm.getGjsyssl());
		jpjgdwjbqk.setGfsyssl(jpjgdwjbqkForm.getGfsyssl());
		
		
		return jpjgdwjbqk;
	}
	
	
	
	
	
	public void addSrqkListWithExpertId(int id, List<JpjgdwjbqksrqkForm> list){
		List<Jpjgdwjbqksrqk> Plist=this.srqkPoToVoList(list);
		Jpjgdwjbqk jpjgdwjbqk= jpjgdwjbqkDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			jpjgdwjbqk.getJpjgdwjbqksrqks().add(Plist.get(i));
		}
	}
	public void addRyListWithExpertId(int id, List<JpjgdwjbqkryForm> list){
		List<Jpjgdwjbqkry> Plist=this.ryPoToVoList(list);
		Jpjgdwjbqk jpjgdwjbqk= jpjgdwjbqkDao.findObjectByID(id);
		for(int i=0;i<Plist.size();i++){
			jpjgdwjbqk.getJpjgdwjbqkrys().add(Plist.get(i));
		}
		
	}
	
	
	private List<Jpjgdwjbqksrqk> srqkPoToVoList(List<JpjgdwjbqksrqkForm> list) {
		List<Jpjgdwjbqksrqk> Plist=new ArrayList<Jpjgdwjbqksrqk>();
		for(int i=0;i<list.size();i++){
			Jpjgdwjbqksrqk jpjgdwjbqksrqk=new Jpjgdwjbqksrqk();
	//		jpjgdwjbqksrqk.setFk_jgdwjbqk_id(list.get(i).getFk_jgdwjbqk_id());
			jpjgdwjbqksrqk.setYear(list.get(i).getYear());
			jpjgdwjbqksrqk.setZcz(list.get(i).getZcz());
			jpjgdwjbqksrqk.setJp(list.get(i).getJp());
			jpjgdwjbqksrqk.setMp(list.get(i).getMp());
			Plist.add(jpjgdwjbqksrqk);
		}
		return Plist;
	}

	private List<Jpjgdwjbqkry> ryPoToVoList(List<JpjgdwjbqkryForm> list) {
		List<Jpjgdwjbqkry> Plist=new ArrayList<Jpjgdwjbqkry>();
		for(int i=0;i<list.size();i++){
			Jpjgdwjbqkry jpjgdwjbqkry=new Jpjgdwjbqkry();
			
	//		jpjgdwjbqkry.setFk_jgdwjbqk_id(list.get(i).getFk_jgdwjbqk_id());
			jpjgdwjbqkry.setBmzw(list.get(i).getBmzw());
			jpjgdwjbqkry.setXm(list.get(i).getXm());
			jpjgdwjbqkry.setBgdh(list.get(i).getBgdh());
			jpjgdwjbqkry.setSj(list.get(i).getSj());
			
	
			Plist.add(jpjgdwjbqkry);
		}
		return Plist;
	}

	
	
	public List<JpjgdwjbqkForm> findJpjgdwjbqkList(JpjgdwjbqkForm jpjgdwjbqkForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(jpjgdwjbqkForm!=null&&StringUtils.isNotBlank(jpjgdwjbqkForm.getDwmc())){
			hqlWhere += " and o.dwmc = ?";
			paramsList.add(jpjgdwjbqkForm.getDwmc());
		}
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Jpjgdwjbqk> list=jpjgdwjbqkDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<JpjgdwjbqkForm> formlist=this.JpjgdwjbqkPoToVoList(list);
		return formlist;
	}

	private List<JpjgdwjbqkForm> JpjgdwjbqkPoToVoList(List<Jpjgdwjbqk> list) {
		List<JpjgdwjbqkForm> formlist=new ArrayList<JpjgdwjbqkForm>();
		if(list.size()>0){
		for(int i=0;i<list.size();i++){
			JpjgdwjbqkForm jpjgdwjbqkForm=new JpjgdwjbqkForm();
			jpjgdwjbqkForm.setId(String.valueOf(list.get(i).getId()));
			jpjgdwjbqkForm.setDwmc(list.get(i).getDwmc());
			jpjgdwjbqkForm.setQtmc(list.get(i).getQtmc());
			jpjgdwjbqkForm.setDwdh(list.get(i).getDwdh());
			jpjgdwjbqkForm.setScdz(list.get(i).getScdz());
			jpjgdwjbqkForm.setJjxz(list.get(i).getJjxz());
			jpjgdwjbqkForm.setFrdb(list.get(i).getFrdb());
			jpjgdwjbqkForm.setDwdz(list.get(i).getDwdz());
			jpjgdwjbqkForm.setYzbm(list.get(i).getYzbm());
			jpjgdwjbqkForm.setLxr(list.get(i).getLxr());
			jpjgdwjbqkForm.setLxdh(list.get(i).getLxdh());
			jpjgdwjbqkForm.setZgzs(list.get(i).getZgzs());
			jpjgdwjbqkForm.setGzgl(list.get(i).getGzgl());
			jpjgdwjbqkForm.setZzgl(list.get(i).getZzgl());
			jpjgdwjbqkForm.setCzgl(list.get(i).getCzgl());
			jpjgdwjbqkForm.setGzjs(list.get(i).getGzjs());
			jpjgdwjbqkForm.setZzjs(list.get(i).getZzjs());
			jpjgdwjbqkForm.setCzjs(list.get(i).getCzjs());
			jpjgdwjbqkForm.setGzgr(list.get(i).getGzgr());
			jpjgdwjbqkForm.setZzgr(list.get(i).getZzgr());
			jpjgdwjbqkForm.setCzgr(list.get(i).getCzgr());
			jpjgdwjbqkForm.setGjjcgs(list.get(i).getGjjcgs());
			jpjgdwjbqkForm.setSbjcgs(list.get(i).getSbjcgs());
			jpjgdwjbqkForm.setJlz(list.get(i).getJlz());
			jpjgdwjbqkForm.setJlbzsl(list.get(i).getJlbzsl());
			jpjgdwjbqkForm.setJpkyrw(list.get(i).getJpkyrw());
			jpjgdwjbqkForm.setGjsyssl(list.get(i).getGjsyssl());
			jpjgdwjbqkForm.setGfsyssl(list.get(i).getGfsyssl());
			
			jpjgdwjbqkForm.setJpjgdwjbqksrqks(JpjgdwjbqksrqkSetToFormList(list.get(i).getJpjgdwjbqksrqks()));
			jpjgdwjbqkForm.setJpjgdwjbqkrys(JpjgdwjbqkrySetToFormList(list.get(i).getJpjgdwjbqkrys()));
			
			formlist.add(jpjgdwjbqkForm);
		}}
		return formlist;
	}

	
	private List<JpjgdwjbqksrqkForm> JpjgdwjbqksrqkSetToFormList(
			Set<Jpjgdwjbqksrqk> jpjgdwjbqksrqks) {
   List<JpjgdwjbqksrqkForm> formlist=new ArrayList<JpjgdwjbqksrqkForm>();
   if(jpjgdwjbqksrqks.size()>0){
		for(Jpjgdwjbqksrqk jpjgdwjbqksrqk:jpjgdwjbqksrqks){
			JpjgdwjbqksrqkForm jpjgdwjbqksrqkForm=new JpjgdwjbqksrqkForm();
	//		jpjgdwjbqksrqkForm.setFk_jgdwjbqk_id(jpjgdwjbqksrqk.getFk_jgdwjbqk_id());
			jpjgdwjbqksrqkForm.setYear(jpjgdwjbqksrqk.getYear());
			jpjgdwjbqksrqkForm.setZcz(jpjgdwjbqksrqk.getZcz());
			jpjgdwjbqksrqkForm.setJp(jpjgdwjbqksrqk.getJp());
			jpjgdwjbqksrqkForm.setMp(jpjgdwjbqksrqk.getMp());
			formlist.add(jpjgdwjbqksrqkForm);
		}}
		return formlist;
	}

	private List<JpjgdwjbqkryForm> JpjgdwjbqkrySetToFormList(
			Set<Jpjgdwjbqkry> jpjgdwjbqkrys) {
		List<JpjgdwjbqkryForm> formlist=new ArrayList<JpjgdwjbqkryForm>();
		if(jpjgdwjbqkrys.size()>0){
		for(Jpjgdwjbqkry jpjgdwjbqkry:jpjgdwjbqkrys){
			JpjgdwjbqkryForm jpjgdwjbqkryForm=new JpjgdwjbqkryForm();
	//		jpjgdwjbqkryForm.setFk_jgdwjbqk_id(jpjgdwjbqkry.getFk_jgdwjbqk_id());
			jpjgdwjbqkryForm.setBmzw(jpjgdwjbqkry.getBmzw());
			jpjgdwjbqkryForm.setXm(jpjgdwjbqkry.getXm());
			jpjgdwjbqkryForm.setBgdh(jpjgdwjbqkry.getBgdh());
			jpjgdwjbqkryForm.setSj(jpjgdwjbqkry.getSj());
			formlist.add(jpjgdwjbqkryForm);
			
		}}
		return formlist;
	}
	
	
	public void deleteObject(String id){
		jpjgdwjbqkDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	
	
	public void updateObject(JpjgdwjbqkForm jpjgdwjbqkForm){
		Jpjgdwjbqk jpjgdwjbqk=new Jpjgdwjbqk();
		jpjgdwjbqk.setId(Integer.valueOf(jpjgdwjbqkForm.getId()));
		jpjgdwjbqk.setDwmc(jpjgdwjbqkForm.getDwmc());
		jpjgdwjbqk.setQtmc(jpjgdwjbqkForm.getQtmc());
		jpjgdwjbqk.setDwdh(jpjgdwjbqkForm.getDwdh());
		jpjgdwjbqk.setScdz(jpjgdwjbqkForm.getScdz());
		jpjgdwjbqk.setJjxz(jpjgdwjbqkForm.getJjxz());
		jpjgdwjbqk.setFrdb(jpjgdwjbqkForm.getFrdb());
		jpjgdwjbqk.setDwdz(jpjgdwjbqkForm.getDwdz());
		jpjgdwjbqk.setYzbm(jpjgdwjbqkForm.getYzbm());
		jpjgdwjbqk.setLxr(jpjgdwjbqkForm.getLxr());
		jpjgdwjbqk.setLxdh(jpjgdwjbqkForm.getLxdh());
		jpjgdwjbqk.setZgzs(jpjgdwjbqkForm.getZgzs());
		jpjgdwjbqk.setGzgl(jpjgdwjbqkForm.getGzgl());
		jpjgdwjbqk.setZzgl(jpjgdwjbqkForm.getZzgl());
		jpjgdwjbqk.setCzgl(jpjgdwjbqkForm.getCzgl());
		jpjgdwjbqk.setGzjs(jpjgdwjbqkForm.getGzjs());
		jpjgdwjbqk.setZzjs(jpjgdwjbqkForm.getZzjs());
		jpjgdwjbqk.setCzjs(jpjgdwjbqkForm.getCzjs());
		jpjgdwjbqk.setGzgr(jpjgdwjbqkForm.getGzgr());
		jpjgdwjbqk.setZzgr(jpjgdwjbqkForm.getZzgr());
		jpjgdwjbqk.setCzgr(jpjgdwjbqkForm.getCzgr());
		jpjgdwjbqk.setGjjcgs(jpjgdwjbqkForm.getGjjcgs());
		jpjgdwjbqk.setSbjcgs(jpjgdwjbqkForm.getSbjcgs());
		jpjgdwjbqk.setJlz(jpjgdwjbqkForm.getJlz());
		jpjgdwjbqk.setJlbzsl(jpjgdwjbqkForm.getJlbzsl());
		jpjgdwjbqk.setJpkyrw(jpjgdwjbqkForm.getJpkyrw());
		jpjgdwjbqk.setGjsyssl(jpjgdwjbqkForm.getGjsyssl());
		jpjgdwjbqk.setGfsyssl(jpjgdwjbqkForm.getGfsyssl());
		jpjgdwjbqkDao.update(jpjgdwjbqk);
		
	}

	@Override
	public void showImportObject(String filePath) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showExportObject(String items) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
}
