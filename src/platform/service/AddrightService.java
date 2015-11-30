package platform.service;

import java.util.List;

import platform.form.AddrightForm;


public interface AddrightService {
	public final static String SERVICE_NAME = "platform.service.impl.AddrightServiceImpl";

	public List<AddrightForm> findAddrightList();
	public List<AddrightForm> findAddrightListWithPage(int pagesize,int pageno,AddrightForm addrightForm);
	public void updateAddright(AddrightForm addrightForm);
	public void deleteObject(String id);
	public void saveObject(String userid, String rightid);

}
