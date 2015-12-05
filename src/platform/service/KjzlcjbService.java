package platform.service;

import java.util.List;

import platform.form.KjzlcjbForm;


public interface KjzlcjbService {
	public final static String SERVICE_NAME = "platform.service.impl.KjzlcjbServiceImpl";

	public List<KjzlcjbForm> findKjzlcjbList();
	public List<KjzlcjbForm> findKjzlcjbListWithPage(int pagesize,int pageno, KjzlcjbForm kjzlcjbForm);
	public void updateKjzlcjb(KjzlcjbForm kjzlcjbForm, String username);
	public void deleteObject(String id);
	public void saveObject(KjzlcjbForm kjzlcjbForm, String username);
	public void showimportObject(String cgmc, String username) throws Exception;
	public void showexportObject(String cgmc, String username) throws Exception;

}
