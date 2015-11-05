package platform.service;

import java.util.List;

import platform.form.KjndgxqybabForm;


public interface KjndgxqybabService {
	public final static String SERVICE_NAME = "platform.service.impl.KjndgxqybabServiceImpl";

	public List<KjndgxqybabForm> findKjndgxqybabList();
	public List<KjndgxqybabForm> findKjndgxqybabListWithPage(int pagesize,int pageno, KjndgxqybabForm kjndgxqybabForm);
	public void updateKjndgxqybab(KjndgxqybabForm KjndgxqybabForm);
	public void deleteObject(String id);
	public void saveObject(KjndgxqybabForm KjndgxqybabForm);

	
	
}
