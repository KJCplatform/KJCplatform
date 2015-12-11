package platform.service;

import java.util.List;

import platform.form.KjsbxmhzbForm;


public interface KjsbxmhzbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjsbxmhzbServiceImpl";

	public List<KjsbxmhzbForm> findKjsbxmhzbList();
	public List<KjsbxmhzbForm> findKjsbxmhzbListWithPage(int pagesize,int pageno, KjsbxmhzbForm KjsbxmhzbForm);
	public void updateKjsbxmhzb(KjsbxmhzbForm kjsbxmhzbForm, String username);
	public void deleteObject(String id);
	public void saveObject(KjsbxmhzbForm kjsbxmhzbForm, String username);
	
	
	public void showimportObject(String filePath) throws Exception;
	public void showexportObject(String items) throws Exception;

}
