package platform.service;

import java.util.List;




import platform.form.KjjsxqcjbForm;



public interface KjjsxqcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjjsxqcjbServiceImpl";

	public List<KjjsxqcjbForm> findKjjsxqcjbList();
	public List<KjjsxqcjbForm> findKjjsxqcjbListWithPage(int pagesize,int pageno, KjjsxqcjbForm kjjsxqcjbForm);
	public void updateKjjsxqcjb(KjjsxqcjbForm kjjsxqcjbForm, String username);
	public void deleteObject(String id);
	public void saveObject(KjjsxqcjbForm kjjsxqcjbForm, String username);
	
}
