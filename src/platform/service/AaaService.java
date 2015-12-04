package platform.service;

import java.util.List;

import platform.form.AaaForm;


public interface AaaService {
	public final static String SERVICE_NAME = "platform.service.impl.AaaServiceImpl";

	public List<AaaForm> findAaaList();
	public List<AaaForm> findAaaListWithPage(int pagesize,int pageno, AaaForm aaaForm);
	public void updateAaa(AaaForm aaaForm, String username);
	public void deleteObject(String id);
	public void saveObject(AaaForm aaaForm, String username);
	
	
	public void showimportObject(String kjgfjflqkForm) throws Exception;
	public void showexportObject(String string) throws Exception;

}
