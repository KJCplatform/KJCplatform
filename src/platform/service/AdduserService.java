package platform.service;

import java.util.List;

import platform.form.AdduserForm;


public interface AdduserService {
	public final static String SERVICE_NAME = "platform.service.impl.AdduserServiceImpl";

	public List<AdduserForm> findAdduserList();
	public List<AdduserForm> findAdduserListWithPage(int pagesize,int pageno,AdduserForm adduserForm);
	public void updateAdduser(AdduserForm adduserForm);
	public void deleteObject(String id);
	public void saveObject(AdduserForm adduserForm);

}
