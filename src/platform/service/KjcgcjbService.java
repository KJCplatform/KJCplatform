package platform.service;

import java.util.List;

import platform.form.KjcgcjbForm;


public interface KjcgcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjcgcjbServiceImpl";

	public List<KjcgcjbForm> findKjcgcjbList();
	public List<KjcgcjbForm> findKjcgcjbListWithPage(int pagesize,int pageno, KjcgcjbForm kjcgcjbForm);
	public void updateKjcgcjb(KjcgcjbForm kjcgcjbForm, String username);
	public void deleteObject(String id);
	public void saveObject(KjcgcjbForm kjcgcjbForm, String username);
	public void showimportObject(String cgmc, String username) throws Exception;
	public void showexportObject(String cgmc) throws Exception;

}
