package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.JpzlzkdwbDao;
import platform.dao.XzxzgzbDao;
import platform.dao.ZjtxlDao;
import platform.domain.Jpzlzkdwb;
import platform.domain.Zjtxl;
import platform.form.JpzlzkdwbForm;
import platform.form.ZjtxlForm;
import platform.service.JpzlzkdwbService;
import platform.service.ZjtxlService;
import platform.util.StringHelper;
@Transactional
@SuppressWarnings("unused")
@Service(JpzlzkdwbService.SERVICE_NAME)
public class JpzlzkdwbServiceImpl implements JpzlzkdwbService{
	
	@Resource(name=JpzlzkdwbDao.SERVICE_NAME)
	private JpzlzkdwbDao jpzlzkdwbDao;

	@Override
	public List<JpzlzkdwbForm> findJpzlzkdwbWithPage(int rows, int page) {
		// TODO Auto-generated method stub
		String hqlWhere = "";
		List<Jpzlzkdwb> list=jpzlzkdwbDao.findCollectionByConditionWithPage(hqlWhere,null, null, rows, page);
		List<JpzlzkdwbForm> formlist=this.JpzlzkdwbPoToVoList(list);
		return formlist;
	}
	public List<JpzlzkdwbForm> findJpzlzkdwbList() {
		// TODO Auto-generated method stub
		String hqlWhere = "";
		List<Jpzlzkdwb> list=jpzlzkdwbDao.findCollectionByConditionNoPage(hqlWhere,null, null);
		List<JpzlzkdwbForm> formlist=this.JpzlzkdwbPoToVoList(list);
		return formlist;
	}
	private List<JpzlzkdwbForm> JpzlzkdwbPoToVoList(List<Jpzlzkdwb> list) {
		// TODO Auto-generated method stub
		List<JpzlzkdwbForm> formlist=new ArrayList<JpzlzkdwbForm>();
		for(int i=0;(list.size()!=0)&&(i<list.size());i++){
			JpzlzkdwbForm jpzlzkdwbForm=new JpzlzkdwbForm();
			jpzlzkdwbForm.setDwmc(list.get(i).getDwmc());
			jpzlzkdwbForm.setId(String.valueOf(list.get(i).getId()));
			if(list.get(i).getJinyong()==true) jpzlzkdwbForm.setJinyong("是");
			else if(list.get(i).getJinyong()==false) jpzlzkdwbForm.setJinyong("否");
			formlist.add(jpzlzkdwbForm);
		}
		return formlist;
	}
	@Override
	public List<String> findJpzlzkdwbInUseNameList() {
		// TODO Auto-generated method stub
		String hqlWhere = "and o.jinyong = false";
		List<Jpzlzkdwb> list=jpzlzkdwbDao.findCollectionByConditionNoPage(hqlWhere,null, null);
		List<String> nameList=new ArrayList<String>();
		for(int i=0;(list.size()!=0)&&(i<list.size());i++){
			nameList.add(list.get(i).getDwmc());
		}
		return nameList;
	}
	@Override
	public void updateObject(JpzlzkdwbForm jpzlzkdwbForm, String username) {
		// TODO Auto-generated method stub
		Jpzlzkdwb jpzlzkdwb=new Jpzlzkdwb();
		jpzlzkdwb.setId(Integer.valueOf(jpzlzkdwbForm.getId()));
		jpzlzkdwb.setDwmc(jpzlzkdwbForm.getDwmc());
		if(jpzlzkdwbForm.getJinyong().equals("是"))
		jpzlzkdwb.setJinyong(true);
		else jpzlzkdwb.setJinyong(false);
		jpzlzkdwb.setGxsj(new Date().toString());
		jpzlzkdwb.setUsername(username);
		jpzlzkdwb.setSubmit(false);
		jpzlzkdwbDao.update(jpzlzkdwb);
	}
	@Override
	public void saveObject(JpzlzkdwbForm jpzlzkdwbForm, String username) {
		// TODO Auto-generated method stub
		Jpzlzkdwb jpzlzkdwb=new Jpzlzkdwb();
		jpzlzkdwb.setDwmc(jpzlzkdwbForm.getDwmc());
		if(jpzlzkdwbForm.getJinyong().equals("是"))
		jpzlzkdwb.setJinyong(true);
		else jpzlzkdwb.setJinyong(false);
		jpzlzkdwb.setGxsj(new Date().toString());
		jpzlzkdwb.setUsername(username);
		jpzlzkdwb.setSubmit(false);
		jpzlzkdwbDao.save(jpzlzkdwb);
	}
	@Override
	public void deleteObject(String id) {
		// TODO Auto-generated method stub
		jpzlzkdwbDao.deleteObjectByIDs(Integer.valueOf(id));
		
	}
	
	
}
