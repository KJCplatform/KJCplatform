package platform.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import platform.dao.AddrightDao;
import platform.domain.Addright;
import platform.form.AddrightForm;
import platform.service.AddrightService;

@SuppressWarnings("unused")
@Service(AddrightService.SERVICE_NAME)
public class AddrightServiceImpl implements AddrightService{

	@Resource(name=AddrightDao.SERVICE_NAME)
	private AddrightDao addrightDao;

	@Override
    public List<AddrightForm> findAddrightList(){
		String hqlWhere = "";
		Object [] params = null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put(" o.userid", "asc");
		List<Addright> list=this.addrightDao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<AddrightForm> formlist=this.AddrightPOListToVOList(list);
		return formlist;

	}
	@Override
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
		List<Addright> list=this.addrightDao.findCollectionByConditionWithPage(hqlWhere, params, orderby,pagesize,pageno);
		List<AddrightForm> formlist=this.AddrightPOListToVOList(list);
		return formlist;

	}

	@Override
    public void updateAddright(AddrightForm addrightForm){
		Addright addright=new Addright();
		System.out.println(addrightForm.getId());
		addright.setId(Integer.valueOf(addrightForm.getId()));
		addright.setUserid(Integer.valueOf(addrightForm.getUserid()));
		addright.setRightid(Integer.valueOf(addrightForm.getRightid()));

		this.addrightDao.update(addright);

	}
	@Override
    public void deleteObject(String id){
		this.addrightDao.deleteObjectByIDs(Integer.valueOf(id));
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

			formlist.add(addrightForm);
		}
		return formlist;
	}

@Override
public void saveObject(String userid, String rightid) {
	String[] ss = rightid.split(" ");

	for(int i=0;i<ss.length;i++)
	{   Addright addright=new Addright();
	    System.out.println("ss:"+ss[i]);
		addright.setUserid(Integer.valueOf(userid));
		addright.setRightid(Integer.valueOf(ss[i]));
		this.addrightDao.save(addright);
	}

}


}
