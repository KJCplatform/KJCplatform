package platform.service;

import java.util.List;

import platform.form.KjcgcjbForm;


public interface KjcgcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjcgcjbServiceImpl";

	public List<KjcgcjbForm> findKjcgcjbList();
	public List<KjcgcjbForm> findKjcgcjbListWithPage(int pagesize,int pageno, KjcgcjbForm kjcgcjbForm);
	public void updateKjcgcjb(KjcgcjbForm kjcgcjbForm);
	public void deleteObject(String id);
	public void saveObject(KjcgcjbForm kjcgcjbForm);
	public void showimportObject(String cgmc) throws Exception;
	public void showexportObject(String cgmc) throws Exception;

}
