package platform.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.AddrightDao;
import platform.domain.Addright;
import platform.form.AddrightForm;
import platform.service.AddrightService;
import platform.util.StringHelper;

@SuppressWarnings("unused")
@Service(AddrightService.SERVICE_NAME)
public class AddrightServiceImpl implements AddrightService{
	
	@Resource(name=AddrightDao.SERVICE_NAME)
	private AddrightDao addrightDao;
	
	public List<AddrightForm> findAddrightList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.userid", "asc");
		List<Addright> list=addrightDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<AddrightForm> formlist=this.AddrightPOListToVOList(list);
		return formlist;
		
	}
	public List<AddrightForm> findAddrightListWithPage(int pagesize,int pageno,AddrightForm addrightForm){
		String hqlWhere = "";
		Object [] params = null;
		List<String> paramsList=new ArrayList<String>();
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		if(addrightForm!=null&&StringUtils.isNotBlank(addrightForm.getUserid())){
			hqlWhere += " and o.userid like ?";
			paramsList.add("%"+addrightForm.getUserid()+"%");
		}
		
		orderby.put(" o.userid", "asc");
		params = paramsList.toArray();
		List<Addright> list=addrightDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<AddrightForm> formlist=this.AddrightPOListToVOList(list);
		return formlist;
		
	}
	
	public void updateAddright(AddrightForm addrightForm,String username){
		Addright addright=new Addright();
		System.out.println(addrightForm.getId());
		addright.setId(Integer.valueOf(addrightForm.getId()));
		addright.setUserid(Integer.valueOf(addrightForm.getUserid()));
		addright.setRightid(Integer.valueOf(addrightForm.getRightid()));
		
		addright.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		addright.setUsername(username);
		addright.setGxsj(new Date().toString());
		addright.setSubmit(0);
		addrightDao.update(addright);
		
	}
	public void deleteObject(String id){
		addrightDao.deleteObjectByIDs(Integer.valueOf(id));
	}
//	public void saveObject(AddrightForm addrightForm){
//		Addright addright=new Addright();
//		addright.setUserid(addrightForm.getUserid());
//		addright.setRightid(addrightForm.getRightid());
//		
//		addrightDao.save(addright);
//	}
	
	private List<AddrightForm> AddrightPOListToVOList(List<Addright> list) {
		// TODO Auto-generated method stub
		List<AddrightForm> formlist=new ArrayList<AddrightForm>();
		for(int i=0;i<list.size();i++){
			Addright addright=list.get(i);
			AddrightForm addrightForm=new AddrightForm();
			addrightForm.setId(String.valueOf(addright.getId()));
			addrightForm.setUserid(String.valueOf(addright.getUserid()));
			addrightForm.setRightid(String.valueOf(addright.getRightid()));
			addrightForm.setJlnf(addright.getJlnf());
			addrightForm.setUsername(addright.getUsername());
			addrightForm.setGxsj(addright.getGxsj());
			addrightForm.setSubmit(String.valueOf(addright.getSubmit())); 
			formlist.add(addrightForm);
		}
		return formlist;
	}

public void saveObject(String userid, String rightid,String username) {
	String[] ss = rightid.split(" ");  
	Addright addright=new Addright();
	for(int i=0;i<ss.length;i++)
	{
		addright.setUserid(Integer.valueOf(userid));
		addright.setRightid(Integer.valueOf(ss[i]));
		
		addright.setJlnf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
		addright.setUsername(username);
		addright.setGxsj(new Date().toString());
		addright.setSubmit(0);
		addrightDao.save(addright);
	}
	
}

	
}
