package platform.service;

import java.util.List;

import platform.form.ZjtxlForm;


public interface ZjtxlService {
	public final static String SERVICE_NAME = "platform.service.impl.ZjtxlServiceImpl";

	public List<ZjtxlForm> findZjtxlList();
	public List<ZjtxlForm> findZjtxlListWithPage(int pagesize,int pageno, ZjtxlForm ZjtxlForm);
	public void updateZjtxl(ZjtxlForm ZjtxlForm,String username);
	public void deleteObject(String id);
	public void saveObject(ZjtxlForm ZjtxlForm,String username);

}
