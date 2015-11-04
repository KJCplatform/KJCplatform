package platform.service;

import java.util.List;


import platform.form.KjqtcgcjbForm;


public interface KjqtcgcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjqtcgcjbServiceImpl";

	public List<KjqtcgcjbForm> findKjqtcgcjbList();
	public List<KjqtcgcjbForm> findKjqtcgcjbListWithPage(int pagesize,int pageno, KjqtcgcjbForm kjqtcgcjbForm);
	public void updateKjqtcgcjb(KjqtcgcjbForm kjqtcgcjbForm);
	public void deleteObject(String id);
	public void saveObject(KjqtcgcjbForm kjqtcgcjbForm);

	
}
