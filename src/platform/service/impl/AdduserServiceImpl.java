package platform.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.AdduserDao;
import platform.domain.Adduser;
import platform.form.AdduserForm;
import platform.service.AdduserService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(AdduserService.SERVICE_NAME)
public class AdduserServiceImpl implements AdduserService{
	
	@Resource(name=AdduserDao.SERVICE_NAME)
	private AdduserDao adduserDao;
	
	public List<AdduserForm> findAdduserList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.id", "desc");
		List<Adduser> list=adduserDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<AdduserForm> formlist=this.AdduserPOListToVOList(list);
		return formlist;
		
	}
	public List<AdduserForm> findAdduserListWithPage(int pagesize,int pageno,AdduserForm adduserForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(adduserForm!=null&&StringUtils.isNotBlank(adduserForm.getName())){
			hqlWhere += " and o.name like ?";
			paramsList.add("%"+adduserForm.getName()+"%");
		}
		
		orderby.put(" o.id", "desc");
		params = paramsList.toArray();
		List<Adduser> list=adduserDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<AdduserForm> formlist=this.AdduserPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateAdduser(AdduserForm adduserForm){
		Adduser adduser=new Adduser();
		System.out.println(adduserForm.getId());
		adduser.setId(Integer.valueOf(adduserForm.getId()));
		adduser.setName(adduserForm.getName());
		adduser.setPassword(adduserForm.getPassword());
		
		adduserDao.update(adduser);
		
	}
	public void deleteObject(String id){
		adduserDao.deleteObjectByIDs(Integer.valueOf(id));
	}
	public void saveObject(AdduserForm adduserForm){
		Adduser adduser=new Adduser();
		adduser.setName(adduserForm.getName());
		adduser.setPassword(adduserForm.getPassword());
		
		adduserDao.save(adduser);
	}
	private List<AdduserForm> AdduserPOListToVOList(List<Adduser> list) {
		// TODO Auto-generated method stub
		List<AdduserForm> formlist=new ArrayList<AdduserForm>();
		for(int i=0;i<list.size();i++){
			Adduser adduser=list.get(i);
			AdduserForm adduserForm=new AdduserForm();
			adduserForm.setId(String.valueOf(adduser.getId()));
			adduserForm.setName(adduser.getName());
			adduserForm.setPassword(adduser.getPassword());
			
			formlist.add(adduserForm);
		}
		return formlist;
	}

	
}
